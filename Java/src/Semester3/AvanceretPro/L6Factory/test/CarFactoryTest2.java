import factorymethod.*;
import factorymethod.Factories.CarFactory;
import factorymethod.Factories.FordFactory;
import factorymethod.Factories.TeslaFactory;
import factorymethod.Factories.VolkswagenFactory;
import org.junit.jupiter.api.Test;

class CarFactoryTest2 {
    @Test
    void test_createcar_opgave3(){
        //Arrange
        CarFactory fordFactory = new FordFactory();
        CarFactory teslaFactory = new TeslaFactory();
        CarFactory volkswagenFactory = new VolkswagenFactory();

        //Act

    }
}

}