import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(1, "Носки", 10);
    Product product2 = new Product(2, "Трусы", 20);
    Product product3 = new Product(3, "Майка", 30);

    @BeforeEach
    public void Product() {
        repo.add(product1);
        repo.add(product2);
    }

    @Test
    public void allProduct() {
        repo.findAll();
        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void addProduct() {
        repo.add(product3);
        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeProduct() {
        repo.removeById(1);
        Product[] expected = {product2};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeNonExistingProduct() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(4);
        });
    }
}