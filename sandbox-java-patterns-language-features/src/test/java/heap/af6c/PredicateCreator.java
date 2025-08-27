package heap.af6c;

import java.util.function.Predicate;

class PredicateCreator
{
    public static <T> Predicate<T> build(Predicate<T> predicate)
    {
        return value -> {
            return predicate.test(value);
        };
    }
}
