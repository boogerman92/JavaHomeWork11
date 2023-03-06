import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Book 1", 1_800, "Author 1");
    Product product2 = new Smartphone(2, "Smartphone 1", 10_000, "Apple");
    Product product3 = new Smartphone(3, "Smartphone 2", 5_000, "Samsung");
    Product product4 = new Book(4, "Book 2", 1_000, "Author 2");
    Product product5 = new Book(5, "Book 2", 1_000, "Author 3");

    @BeforeEach
    public void addProduct() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
    }

    @Test
    public void shouldAddProduct() {
        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.getProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookName() {
        Product[] actual = manager.searchBy("Book 1");
        Product[] expected = new Product[]{product1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookNameNegative() {
        Product[] actual = manager.searchBy("Book 4");
        Product[] expected = new Product[]{};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneName() {
        Product[] actual = manager.searchBy("Smartphone 1");
        Product[] expected = new Product[]{product2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphoneNameNegative() {
        Product[] actual = manager.searchBy("Smartphone 4");
        Product[] expected = new Product[]{};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByBookFewName() {
        Product[] actual = manager.searchBy("Book 2");
        Product[] expected = new Product[]{product4, product5};

        Assertions.assertArrayEquals(expected, actual);
    }
}