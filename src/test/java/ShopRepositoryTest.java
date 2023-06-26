import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShopRepositoryTest {
    @Test
    public void testRemoveWhenProductExist() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Носки", 100);
        Product product2 = new Product(20, "Трусы", 200);
        Product product3 = new Product(300, "Майка", 300);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(20);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveWhenProductNotExist() {

        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Носки", 100);
        Product product2 = new Product(20, "Трусы", 200);
        Product product3 = new Product(300, "Майка", 300);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,() -> repo.remove(2234));
    }
}