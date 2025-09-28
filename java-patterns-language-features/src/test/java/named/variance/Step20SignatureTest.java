package named.variance;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

class A
{
    public Number test1()
    {
        return 1;
    }
}

class B extends A
{
    //        public Integer test2()
    //        {
    //                return 2;
    //        }
}

/// Answer the questions stated in [Fruit].

class Step2SignatureTest extends TestBase
{

    @Test
    void what_is_the_purpose_of_this_example()
    {
        //            test1(1);
        //            test1(1.1);
        //            test1(1.1f);
        //            test1(0xab);
    }

    private void test1(Number number)
    {
        System.out.println(number);
    }
}
