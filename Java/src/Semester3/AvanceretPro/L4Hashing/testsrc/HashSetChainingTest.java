import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashSetChainingTest {

    @Test
    public void test_remove_existing_element() {

        // Arrange
        HashSetChaining names = new HashSetChaining(13);
        names.add("Harry");
        names.add("Sue");
        names.add("Nina");
        names.add("Susannah");
        names.add("Larry");

        // Act & Assert
        assertEquals(5, names.size());
        assertTrue(names.remove("Nina"));
        assertEquals(4, names.size());
    }

    @Test
    public void test_remove_nonexistent_element() {

        // Arrange
        HashSetChaining names = new HashSetChaining(13);
        names.add("Harry");
        names.add("Sue");
        names.add("Nina");
        names.add("Susannah");
        names.add("Larry");

        // Act & Assert
        assertEquals(5, names.size());
        assertFalse(names.remove("Esben"));
        assertEquals(5, names.size());
    }

    @Test
    void test_loadFactor() {

        // Arrange
        HashSetChaining names = new HashSetChaining(5);

        // Act & Assert
        assertEquals(0.0, names.loadFactor(), 0.01);
        names.add("Harry");
        assertEquals(0.2, names.loadFactor(), 0.01);
        names.add("Sue");
        assertEquals(0.4, names.loadFactor(), 0.01);

    }

    @Test
    void test_rehash() {
        // Arrange
        HashSetChaining names = new HashSetChaining(10);
        names.add("Harry");
        names.add("Sue");
        names.add("Nina");
        names.add("Susannah");
        names.add("Larry");
        names.add("Eve");
        names.add("Sarah");
        names.writeOut();

        // Act & Assert
        assertEquals(0.7, names.loadFactor(), 0.01);
        names.add("Adam");
        assertEquals(0.4, names.loadFactor(), 0.01);
        names.writeOut();
    }
}