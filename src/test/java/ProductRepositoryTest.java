import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {

    ProductRepository repo = new ProductRepository();


    Product product1 = new Product(1, "Book 1", 100);
    Product product2 = new Product(2, "Smartphone 1", 10_00);
    Product product3 = new Product(3, "Smartphone 2", 5_000);
    Product product4 = new Product(4, "Book 2", 1_000);
    Product product5 = new Product(5, "Book 3", 500);



    @Test
    public void shouldAddFilmNull() {
        Product[] expected = {};
        Product[] actual = repo.getProduct();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveToId() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.removeById(product2.getId());

        Product[] expected = {product1, product3, product4, product5};
        Product[] actual = repo.getProduct();
        Assertions.assertArrayEquals(expected, actual);
    }
}