package heap.a735;

class IndicatorAdapterImpl implements IndicatorAdapter// what's wrong with that interface?
{

    private final Indicator indicator;

    IndicatorAdapterImpl(Indicator indicator)
    {
        this.indicator = indicator;
    }

    @Override
    public double getTemperature()
    {
        double temperature = indicator.getTemperature();
        return convert(temperature);
    }

    private double convert(double temperature)
    {
        return temperature * 1.8 + 32;
    }
}
