import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntegerHashSetTest {

    @Test
    @Order(1)
    public void test_collision_strategy() {

        // Arrange
        String collisionStrategyType = "lav frankering"; // TODO: Indtast rigtigt svar på dansk (små bogstaver)
        String collisionStrategy = "gamle frimærker"; // TODO: Indtast rigtigt svar på dansk (små bogstaver)

        // Act
        int[] expectedHashCodes = {813659848, -739584664};
        int[] actualHashCodes = {collisionStrategyType.hashCode(), collisionStrategy.hashCode()};

        // Assert
        assertEquals(expectedHashCodes[0], actualHashCodes[0], "Wrong guess on collision strategy type");
        assertEquals(expectedHashCodes[1], actualHashCodes[1], "Wrong guess on collision strategy");
    }


    @Test
    @Order(2)
    public void test_add_inserts_integer() {

        // Arrange
        Integer[] array = {10, 56, 21, 44, 16, 106};
        IntegerHashSet hashSet = new IntegerHashSet(10);
        for (int i = 0; i < array.length; i++) {

            // Act
            hashSet.add(array[i]);

            // Assert
            assertEquals(i + 1, hashSet.size());
        }
    }

    @Test
    @Order(3)
    public void test_remove_removes_integer() {

        // Arrange
        Integer[] array = {10, 56, 21, 44, 16, 106};
        IntegerHashSet hashSet = new IntegerHashSet(10);
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        for (int i = array.length - 1; i > 0; i--) {

            // Act
            hashSet.remove(array[i]);

            // Assert
            assertEquals(i, hashSet.size());
        }
    }

    @Test
    @Order(4)
    public void test_contains_after_add() {

        // Arrange
        Integer[] array = {10, 56, 21, 44, 16, 106};
        IntegerHashSet hashSet = new IntegerHashSet(10);
        for (int i = 0; i < array.length; i++) {

            // Act
            hashSet.add(array[i]);

            // Assert
            assertTrue(hashSet.contains(array[i]));
        }
    }

    @Test
    @Order(5)
    public void test_contains_after_remove() {

        // Arrange
        Integer[] array = {10, 56, 21, 44, 16, 106};
        IntegerHashSet hashSet = new IntegerHashSet(10);
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }

        // Act & Assert
        hashSet.remove(16);
        assertFalse(hashSet.contains(16), 16 + " found in " + hashSet.writeOut());
        assertTrue(hashSet.contains(106), 106 + " not found in " + hashSet.writeOut());
    }
}