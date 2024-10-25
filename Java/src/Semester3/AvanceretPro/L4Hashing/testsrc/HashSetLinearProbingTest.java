import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashSetLinearProbingTest {

        //Beklager koden er lidt off set, men brugte bare generate test fra klassen og så fastsætter den med lidt spaces
    @Test
    void contains() {
        // Arrange
        HashSetLinearProbing names = new HashSetLinearProbing(13);
        names.add("Arnold");
        names.add("Sylvester");
        names.add("Stallone");
        names.add("Ripley");
        names.add("Slikolaj");

        // Act & Assert
        assertTrue(names.contains("Ripley"));
        assertFalse(names.contains("Esben"));
    }

    @Test
    void add() {
        // Arrange
        HashSetLinearProbing names = new HashSetLinearProbing(13);
        names.add("Arnold");
        names.add("Stallone");
        names.add("Sylvester");
        names.add("Slikolaj");
        names.add("Ripley");

        // Act & Assert
        assertEquals(5, names.size());
        assertTrue(names.contains("Ripley"));
        assertTrue(names.add("Esben"));
        assertEquals(6, names.size());
    }

    @Test
    void remove() {
        // Arrange
        HashSetLinearProbing names = new HashSetLinearProbing(13);
        names.add("Arnold");
        names.add("Sylvester");
        names.add("Stallone");
        names.add("Ripley");
        names.add("Slikolaj");

        // Act & Assert
        assertEquals(5, names.size());
        assertTrue(names.remove("Ripley"));
        assertEquals(4, names.size());
        assertFalse(names.remove("Esben"));
        assertEquals(4, names.size());
    }

    @Test
    void size() {
        // Arrange
        HashSetLinearProbing names = new HashSetLinearProbing(13);
        names.add("Arnold");
        names.add("Sylvester");
        names.add("Stallone");
        names.add("Ripley");
        names.add("Slikolaj");

        // Act & Assert
        assertEquals(5, names.size());
        names.remove("Ripley");
        assertEquals(4, names.size());
        names.remove("Slikolaj");
        assertEquals(3, names.size());
    }

    @Test
    void writeOut() {
        // Arrange
        HashSetLinearProbing names = new HashSetLinearProbing(13);
        names.add("Arnold");
        names.add("Sylvester");
        names.add("Stallone");
        names.add("Ripley");
        names.add("Slikolaj");

        // Act & Assert
        names.writeOut();
    }
}