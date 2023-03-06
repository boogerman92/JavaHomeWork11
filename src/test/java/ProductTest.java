import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

public class ProductTest {
    @Test
    public void Product(){
        ProductRepository repo = new ProductRepository();

        repo.addProduct(product1);

        Product[] expected = {product1};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);

    }

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(1, "Book 1", 100);
    Product product2 = new Product(2, "Smartphone 1", 10_000);
    Product product3 = new Product(3, "Smartphone 2", 5_000);
    Product product4 = new Product(4, "Book 2", 1_000);
    Product product5 = new Product(5, "Book 3", 500);

    @BeforeEach
    public void addProduct() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
    }


    @Test
    public void getProduct(){
        ProductRepository repo = new ProductRepository();

        repo.addProduct(product1);

        Product[] expected = {product1};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void deleteProduct(){

        repo.removeById(3);

        Product[] expected = {product1, product2, product4, product5};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addFiveProduct(){
        repo.addProduct(product1);
        repo.addProduct(product2);
        repo.addProduct(product3);
        repo.addProduct(product4);
        repo.addProduct(product5);


        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }



    @Test
    public void shouldSetBook(){
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
    public void shouldSetSmartphone(){
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
    public void shouldSearchBy() {

        manager.searchBy("Book 1");

        Product[] expected = {product1};
        Product[] actual = manager.searchBy("Book 1");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFalseSearchBy() {

        manager.searchBy("Book 4");

        Product[] expected = {};
        Product[] actual = manager.searchBy("Book 4");
        Assertions.assertArrayEquals(expected, actual);
    }




}
