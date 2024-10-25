import org.junit.jupiter.api.Test;
import java.util.HashSet;
import static org.junit.jupiter.api.Assertions.*;

class BilTest {

    @Test
    public void test_equals() {

        // Arrange
        Car øse1 = new Car("EH22333", "Volvo", "Voldsom", "Rød");
        Car øse2 = new Car("EH22333", "Volvo", "Voldsom", "Rød");

        // Act & assert
        assertTrue(øse1.equals(øse2));
        øse1.setRegNumber("EH22444");
        assertFalse(øse1.equals(øse2));
    }

    @Test
    public void test_hashCode() {

        // Arrange
        Car øse1 = new Car("EH22333", "Volvo", "Voldsom", "Rød");
        Car øse2 = new Car("EH22333", "Volvo", "Voldsom", "Rød");
        HashSet<Car> øser = new HashSet<>();

        // Act & assert
        øser.add(øse1);
        assertEquals(1, øser.size());
        assertFalse(øser.add(øse2));
        assertEquals(1, øser.size());
    }
}