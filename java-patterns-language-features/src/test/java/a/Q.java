package a;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;

interface UserDiscountApi
{
    int getDiscount(UUID userId);
}

class Q
{
    @Test
    void exercise_design_reverse_engineering1()
    {
        // given
        Good good1 = new Good(UUID.randomUUID(), new BigDecimal(100));
        Good good2 = new Good(UUID.randomUUID(), new BigDecimal(150));

        Order order = new Order(List.of(good1, good2));

        DiscountCalculator sut = new DiscountCalculator(userId -> 2);

        // when
        Order result = sut.foo(UUID.randomUUID(), order);

        // then
        assertThat(result.goods.get(0).finalPrice.intValue(), CoreMatchers.equalTo(98));
        assertThat(result.goods.get(1).finalPrice.intValue(), CoreMatchers.equalTo(147));
    }

    @Test
    void exercise_design_reverse_engineering2()
    {
        // given
        BigDecimal price = new BigDecimal(100.50);
        price.setScale(2);


        Good good1 = new Good(UUID.randomUUID(), price);

        Order order = new Order(List.of(good1));

        DiscountCalculator sut = new DiscountCalculator(userId -> 2);

        // when
        Order result = sut.foo(UUID.randomUUID(), order);

        // then
        BigDecimal operand = new BigDecimal("98.49").setScale(2, RoundingMode.HALF_UP);

        assertThat(result.goods.get(0).finalPrice, CoreMatchers.equalTo(operand));
    }

    @Test
    @DisplayName("Тесты на Illegal Arugment, тесты null")
    void exercise_design_reverse_engineering3()
    {
        // todo
    }

    @Test
    @DisplayName("Тесты на то что цены нереальные")
    void exercise_design_reverse_engineering4()
    {
        // todo
    }

    @Test
    @DisplayName("Тесты на то что скидка в диапазоне 0..100")
    void exercise_design_reverse_engineering5()
    {
        // todo
    }
}

class DiscountCalculator
{
    private static final Logger log = LoggerFactory.getLogger(DiscountCalculator.class);

    private UserDiscountApi userDiscountApi;

    DiscountCalculator(UserDiscountApi userDiscountApi)
    {
        this.userDiscountApi = userDiscountApi;
    }

    private static void validate1(Order order)
    {
        order.goods.forEach(a -> {
            if (a.price.intValue() < 0)
            {
                throw new IllegalArgumentException("detailed error message");
            }
        });
    }

    Order foo(UUID userId, Order order)
    {
        Objects.requireNonNull(userId);
        Objects.requireNonNull(order);

        validate1(order);


        int discount = userDiscountApi.getDiscount(userId);
        if (discount < 1 || discount > 100)
        {
            throw new IllegalArgumentException("discount error: " + discount);
        }

        for (Good good : order.goods)
        {
            BigDecimal divisor = new BigDecimal(100);

            BigDecimal multiplicand = new BigDecimal(discount);

            BigDecimal discount1 = good.price.divide(divisor)
                                             .multiply(multiplicand);
            BigDecimal bigDecimal = discount1.setScale(2, RoundingMode.HALF_UP);

            good.finalPrice = good.price.subtract(bigDecimal);
        }

        return order;
    }
}

class Order
{
    List<Good> goods = new ArrayList<>();

    Order(List<Good> goods)
    {
        this.goods = goods;
    }
}

class Good
{

    UUID       uuid;
    BigDecimal price;
    BigDecimal finalPrice;

    Good(UUID uuid, BigDecimal price)
    {
        this.uuid = uuid;
        this.price = price;
    }
}
