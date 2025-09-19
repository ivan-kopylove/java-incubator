package heap.a735;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/// Adapter is converter.
/// facets:
/// - patterns
/// - adapter
class AdapterPatternExampleRunner
{
    @Test
    void what_does_this_example_demonstrate()
    {
        Indicator celsius = new CelsiusScaleThermometer();
        IndicatorAdapter indicatorAdapter = new IndicatorAdapterImpl(celsius);

        assertEquals(68.0, indicatorAdapter.getTemperature(), 0.0);
    }
}
