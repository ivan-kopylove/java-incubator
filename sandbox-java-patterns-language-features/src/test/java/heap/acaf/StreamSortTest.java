package heap.acaf;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

/**
 * java streams playground
 * <p>
 * The default implementation of smth.
 */
class StreamSortTest
{
    /**
     * First it sorts by what then by what?
     */
    @Test
    void nullSafeChainedLambdaComparator()
    {
        List<ComparableObject> list = DataProvider.createObjectsWithNulls();
        list.sort(Comparator.nullsLast(Comparator.comparing(ComparableObject::getDate))
                            .thenComparing(Comparator.nullsLast(Comparator.comparing(ComparableObject::getStr))));
    }

    /**
     * First it sorts by what then by what?
     */
    @Test
    void chainedLambdaComparator()
    {
        List<ComparableObject> list = DataProvider.createObjects();
        list.sort(Comparator.comparing(ComparableObject::getDate).thenComparing(ComparableObject::getStr));
    }
}
