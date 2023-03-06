import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductTest {

    @Test
    public void shouldSetBookAuthor(){
        Book book = new Book(1, "Duna", 100, "Gerbert");
        book.setId(1);
        book.setName("Duna");
        book.setPrice(100);
        book.setAuthor("Gerbert");

        int expectedId = 1;
        int actualId = book.getId();
        String expectedName = "Duna";
        String actualName = book.getName();
        int expectedPrice = 100;
        int actualPrice = book.getPrice();
        String expectedAuthor = "Gerbert";
        String actualAuthor = book.getAuthor();

        Assertions.assertEquals(expectedId, actualId);
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedPrice, actualPrice);
        Assertions.assertEquals(expectedAuthor, actualAuthor);
    }

    @Test
    public void shouldSetBook() {
        Product book = new Product();
        book.setId(1);
        book.setName("Duna");
        book.setPrice(100);

        int expectedId = 1;
        int actualId = book.getId();
        String expectedName = "Duna";
        String actualName = book.getName();
        int expectedPrice = 100;
        int actualPrice = book.getPrice();

        Assertions.assertEquals(expectedId, actualId);
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void shouldSetSmartphoneProducer(){
        Smartphone smartphone = new Smartphone(2, "Iphone SE", 10_000, "Apple");
        smartphone.setId(2);
        smartphone.setName("Iphone SE");
        smartphone.setPrice(10_000);
        smartphone.setProducer("Apple");

        int expectedId = 2;
        int actualId = smartphone.getId();
        String expectedName = "Iphone SE";
        String actualName = smartphone.getName();
        int expectedPrice = 10_000;
        int actualPrice = smartphone.getPrice();
        String expectedAuthor = "Apple";
        String actualAuthor = smartphone.getProducer();

        Assertions.assertEquals(expectedId, actualId);
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedPrice, actualPrice);
        Assertions.assertEquals(expectedAuthor, actualAuthor);
    }

    @Test
    public void shouldSetSmartphone() {
        Product smartphone = new Product();
        smartphone.setId(2);
        smartphone.setName("Iphone SE");
        smartphone.setPrice(10_000);

        int expectedId = 2;
        int actualId = smartphone.getId();
        String expectedName = "Iphone SE";
        String actualName = smartphone.getName();
        int expectedPrice = 10_000;
        int actualPrice = smartphone.getPrice();

        Assertions.assertEquals(expectedId, actualId);
        Assertions.assertEquals(expectedName, actualName);
        Assertions.assertEquals(expectedPrice, actualPrice);
    }



}
