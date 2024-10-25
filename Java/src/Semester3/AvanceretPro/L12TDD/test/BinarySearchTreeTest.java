import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BinarySearchTreeTest {

    @Test
    @Order(1)
    void test_preorder_print() {

        // Arrange
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(45);
        tree.insert(22);
        tree.insert(11);
        tree.insert(15);
        tree.insert(30);
        tree.insert(25);
        tree.insert(77);
        tree.insert(90);
        tree.insert(88);

        // Act
        String expected = "45 22 11 15 30 25 77 90 88";
        String actual = tree.preorder();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @Order(2)
    public void test_balanced_true() {

        // Arrange
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(45);
        tree.insert(22);
        tree.insert(11);
        tree.insert(15);
        tree.insert(30);
        tree.insert(25);
        tree.insert(77);
        tree.insert(90);
        tree.insert(88);

        // Act
        boolean expectedBalanced = true;
        boolean actualBalanced = tree.balanced();

        // Assert
        assertEquals(expectedBalanced, actualBalanced);
    }

    @Test
    @Order(3)
    public void test_balanced_false() {

        // Arrange
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(45);
        tree.insert(22);
        tree.insert(11);
        tree.insert(15);
        tree.insert(30);
        tree.insert(25);
        tree.insert(77);

        // Act
        boolean expectedBalanced = false;
        boolean actualBalanced = tree.balanced();

        // Assert
        assertEquals(expectedBalanced, actualBalanced);
    }
}