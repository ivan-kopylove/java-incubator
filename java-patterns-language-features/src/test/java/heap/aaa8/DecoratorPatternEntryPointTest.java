package heap.aaa8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.github.ivan.kopylove.commons.testing.TestBase;

class DecoratorPatternEntryPointTest extends TestBase
{
    @Test
    void main()
    {
        Window decoratedWindow = new HorizontalScrollbarDecorator(new VerticalScrollBarDecorator(new SimpleWindow()));

        System.out.println(decoratedWindow.getDescription());

        assertEquals("simple window, including vertical scrollbars, including horizontal scrollbars", decoratedWindow.getDescription());
    }
}
