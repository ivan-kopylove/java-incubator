package heap.a789;

import com.github.ivan.kopylove.commons.testing.TestBase;
import org.junit.jupiter.api.Test;

class FacadeExampleTest extends TestBase
{

    @Test
    void withoutFacade()
    {
        FuelInjector injector = new FuelInjector();
        AirflowController airflowController = new AirflowController();
        CatalyticConverter coolingController = new CatalyticConverter();
        CatalyticConverter catalyticConverter = new CatalyticConverter();
        Starter starter = new Starter();

        //start engine
        airflowController.takeAir();
        injector.on();
        injector.inject();
        starter.start();
        coolingController.on();
        catalyticConverter.on();

        //stop engine
        injector.off();
        catalyticConverter.off();
        coolingController.off();
        airflowController.off();
    }

    @Test
    void usingFacade()
    {
        CarEngineFacade engineFacade = new CarEngineFacade();
        engineFacade.startEngine();
        engineFacade.stopEngine();
    }

    class CarEngineFacade
    {
        FuelInjector       injector           = new FuelInjector();
        AirflowController  airflowController  = new AirflowController();
        CatalyticConverter coolingController  = new CatalyticConverter();
        CatalyticConverter catalyticConverter = new CatalyticConverter();
        Starter            starter            = new Starter();

        void startEngine()
        {
            airflowController.takeAir();
            injector.on();
            injector.inject();
            starter.start();
            coolingController.on();
            catalyticConverter.on();
        }

        void stopEngine()
        {
            injector.off();
            catalyticConverter.off();
            coolingController.off();
            airflowController.off();
        }
    }

    class FuelInjector
    {
        void on()
        {
        }

        void off()
        {
        }

        void inject()
        {
        }
    }

    class Starter
    {
        void start()
        {
        }
    }

    class AirflowController
    {

        void takeAir()
        {
        }

        void off()
        {
        }
    }

    class CatalyticConverter
    {
        void on()
        {
        }

        void off()
        {
        }
    }

    class CoolingController
    {
        void foo()
        {
        }

        void cool()
        {
        }

        void stop()
        {
        }
    }
}
