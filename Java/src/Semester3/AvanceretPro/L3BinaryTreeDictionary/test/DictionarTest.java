import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


public class DictionarTest {
    Dictionary<Integer, String> dictionary;

    @Test
    void get(){
        // arrange
        Dictionary<Integer, String> dictionary = new DictionaryBST<>();
        dictionary.put(83, "Liber-tea");
        dictionary.put(25, "Democracy");
        dictionary.put(99, "Havmåge");
        dictionary.put(93, "Brosten");
        dictionary.put(100, "Fiskehaj");
        dictionary.put(12, "Dommedag");
        dictionary.put(82, "Slikolajs fødselsår");


        // act
        String expected = "Democracy";
        String actual = dictionary.get(25);

        // assert
        assertEquals(expected, actual);
    }
    @Test
    void isEmpty_true(){
        // arrange
        Dictionary<Integer, String> dictionary = new DictionaryBST<>();

        // act
        boolean expected = true;
        boolean actual = dictionary.isEmpty();

        // assert
        assertEquals(expected, actual);
    }
    @Test
    void isEmpty_false(){
        // arrange
        Dictionary<Integer, String> dictionary = new DictionaryBST<>();
        dictionary.put(59, "Smørkrans");
        // act
        boolean expected = false;
        boolean actual = dictionary.isEmpty();

        // assert
        assertEquals(expected, actual);
    }
    @Test
    void test_put_returnValue(){
        // arrange
        Dictionary<Integer, String> dictionary = new DictionaryBST<>();
        dictionary.put(83, "Liber-tea");
        dictionary.put(25, "Democracy");
        dictionary.put(99, "Freedom");

        // act
        String expected = "Freedom";
        String actual = dictionary.put(99, "Terminator");

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void test_remove(){
        // arrange
        Dictionary<Integer, String> dictionary = new DictionaryBST<>();
        dictionary.put(83, "Liber-tea");
        dictionary.put(25, "Democracy");
        dictionary.put(99, "Havmåge");
        dictionary.put(93, "Brosten");
        dictionary.put(100, "Fiskehaj");
        dictionary.put(12, "Dommedag");
        dictionary.put(82, "Slikolajs fødselsår");


        // act
        String expected = "Democracy";
        String actual = dictionary.remove(25);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void test_size(){
        // arrange
        Dictionary<Integer, String> dictionary = new DictionaryBST<>();
        // act & assert
        assertEquals(0, dictionary.size());
        dictionary.put(83, "Liber-tea");
        assertEquals(1, dictionary.size());
        dictionary.put(25, "Democracy");
        assertEquals(2, dictionary.size());
        dictionary.put(99, "Havmåge");
        assertEquals(3, dictionary.size());
        dictionary.put(93, "Brosten");
        assertEquals(4, dictionary.size());
        dictionary.put(100, "Fiskehaj");
        assertEquals(5, dictionary.size());
        dictionary.put(12, "Dommedag");
        assertEquals(6, dictionary.size());
        dictionary.put(82, "Slikolajs fødselsår");
        assertEquals(7, dictionary.size());
    }
    @BeforeEach
    public void setUp() throws Exception {
        dictionary = new DictionaryBST<>();
    }
    
    @Test
    public void test() {
        assertTrue(dictionary.isEmpty());
        assertEquals(0, dictionary.size());

        dictionary.put(8, "hans");
        dictionary.put(3, "viggo");
        
        assertFalse(dictionary.isEmpty());
        assertEquals(2, dictionary.size());

        assertEquals("hans", dictionary.get(8));

        dictionary.put(7, "bent");
        dictionary.put(2, "lene");
        
        assertFalse(dictionary.isEmpty());
        assertEquals(4, dictionary.size());
        
        assertEquals("viggo", dictionary.remove(3));

        assertEquals(3, dictionary.size());
        
        assertEquals("hans", dictionary.put(8, "Ida"));
        assertEquals("Ida", dictionary.get(8));

    }

    
    
}
