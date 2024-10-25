import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WhiskeyStoreTest {

    @Test
    @Order(1)
    public void test_getWhiskies_returns_correct_type() {

        // Arrange
        WhiskeyStore whiskeyStore = new WhiskeyStore();

        // Act
        whiskeyStore.addWhisky(new Whiskey("Jack Daniel's", "USA", "Natural", 40));
        whiskeyStore.addWhisky(new Whiskey("Jim Beam Double Oak", "USA", "Natural", 43));
        whiskeyStore.addWhisky(new Whiskey("Buffalo Trace", "USA", "Natural", 40));
        whiskeyStore.addWhisky(new Whisky("Port Askaig", "Scotland", "Natural", 100));

        // Assert
        List whiskies = whiskeyStore.getWhiskies();
        for (Object whiskey : whiskies) {
            assertTrue(whiskey instanceof Whiskey, whiskey.toString() + " is not an instance of Whiskey");
        }
    }

    @Test
    @Order(2)
    public void test_getWhiskies_returns_valid_abv() {

        // Arrange
        WhiskeyStore whiskeyStore = new WhiskeyStore();

        // Act
        whiskeyStore.addWhisky(new Whiskey("Jack Daniel's", "USA", "Natural", 40));
        whiskeyStore.addWhisky(new Whiskey("Jim Beam Double Oak", "USA", "Natural", 43));
        whiskeyStore.addWhisky(new Whiskey("Buffalo Trace", "USA", "Natural", 40));
        whiskeyStore.addWhisky(new Whisky("Port Askaig", "Scotland", "Natural", 100));

        // Assert
        List whiskies = whiskeyStore.getWhiskies();
        for (Object whiskey : whiskies) {
            if (whiskey instanceof Whiskey) {
                assertTrue(((Whiskey) whiskey).getAlcohol() != 100, "No whiskey contains 100% alcohol (ABV)");
            }
        }
    }
}