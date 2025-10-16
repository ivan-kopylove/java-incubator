package heap.af6c;

import java.util.function.Predicate;

class PredicateCreator
{
    static <T> Predicate<T> build(Predicate<T> predicate)
    {
        return value -> {
            return predicate.test(value);
        };
    }
}
