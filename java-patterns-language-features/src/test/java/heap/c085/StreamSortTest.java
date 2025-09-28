package heap.c085;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.github.ivan.kopylove.commons.testing.TestBase;
class StreamSortTest extends TestBase
{
    @DisplayName("what is the purpose of this example?")
    void what_is_the_purpose_of_this_example() throws InterruptedException
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
