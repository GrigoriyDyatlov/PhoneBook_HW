import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.PhoneBook;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PhoneBookTest {
    private PhoneBook phoneBook = null;

    @BeforeEach
    public void newPhoneBook() {
        this.phoneBook = new PhoneBook();
    }

    @Test
    public void testAdd() {
        int result = phoneBook.add("Kolya", "+7-913-913-91-91");

        Assertions.assertEquals(1, result);
    }

    @Test
    public void testExpectedException() throws IllegalStateException {
        int result = phoneBook.add("Kolya", "+7-913-913-91-91");

        IllegalStateException exception = assertThrows(IllegalStateException.class, () ->
                phoneBook.add("Kolya", "+7-913-913-91-91"));

        assertEquals("This number already added.", exception.getMessage());
    }

    @Test
    public void testFindByNumber() {
        phoneBook.add("Kolya", "+7-913-913-91-91");

        String result = phoneBook.findByNumber("+7-913-913-91-91");

        Assertions.assertEquals("Kolya", result);
    }

    @Test
    public void testFindByName (){
        phoneBook.add("Kolya", "+7-913-913-91-91");

        String result = phoneBook.findByName("Kolya");

        assertEquals("+7-913-913-91-91", result);
    }
}
