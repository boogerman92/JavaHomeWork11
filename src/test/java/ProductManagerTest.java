import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(1, "Book 1", 1_800, "Author 1");
    Product product2 = new Book(2, "Book 2", 1_500, "Author 2");
    Product product3 = new Smartphone(3, "Smartphone 1", 50_000, "manufacturer 1");
    Product product4 = new Smartphone(4, "Smartphone 2", 40_000, "manufacturer 3");
    Product product5 = new Smartphone(5, "Smartphone 2", 40_000, "manufacturer 2");

    @BeforeEach
    public void addProduct() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
        manager.addProduct(product5);
    }

    @Test // Проверка добавления товаров в массив и вывод
    public void shouldAddFilm() {
        Product[] expected = {product1, product2, product3, product4, product5};
        Product[] actual = repo.getProduct();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка поиска товара Book
    public void shouldSearchByBookName() {
        Product[] actual = manager.searchBy("Book 1");
        Product[] expected = new Product[]{product1};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка поиска товара Book
    public void shouldSearchByBookNameNull() {
        Product[] actual = manager.searchBy("Book 4");
        Product[] expected = new Product[]{};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка поиска товара Smartphone
    public void shouldSearchBySmartphoneName() {
        Product[] actual = manager.searchBy("Smartphone 1");
        Product[] expected = new Product[]{product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка поиска товара Smartphone
    public void shouldSearchBySmartphoneNameNull() {
        Product[] actual = manager.searchBy("Smartphone 4");
        Product[] expected = new Product[]{};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test // Проверка поиска товара Smartphone
    public void shouldSearchBySmartphoneFewName() {
        Product[] actual = manager.searchBy("Smartphone 2");
        Product[] expected = new Product[]{product4, product5};

        Assertions.assertArrayEquals(expected, actual);
    }
}