package heap.c085;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

class StreamSortTest
{
    /// First it sorts by what then by what?
    @Test
    void nullSafeChainedLambdaComparator()
    {
        List<ComparableObject> list = createObjectsWithNulls();
        list.sort(Comparator.nullsLast(Comparator.comparing(ComparableObject::getDate))
                            .thenComparing(Comparator.nullsLast(Comparator.comparing(ComparableObject::getStr))));
    }

    /// First it sorts by what then by what?
    @Test
    void chainedLambdaComparator()
    {
        List<ComparableObject> list = createObjects();
        list.sort(Comparator.comparing(ComparableObject::getDate).thenComparing(ComparableObject::getStr));
    }

    private List<ComparableObject> createObjects()
    {
        return new ArrayList<>(Arrays.asList(new ComparableObject("str1", new Date(), 4),
                                             new ComparableObject("str2", new Date(55555555), 3),
                                             new ComparableObject("str3", new Date(55555555), 6)

        ));
    }

    private List<ComparableObject> createObjectsWithNulls()
    {
        return new ArrayList<>(Arrays.asList(null,
                                             new ComparableObject("str1", new Date(), 4),
                                             new ComparableObject("str2", new Date(55555555), 3),
                                             new ComparableObject("str3", new Date(55555555), 6),
                                             null));
    }
}
