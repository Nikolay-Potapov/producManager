package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private Book item1 = new Book("Ф. Достоевский");
    private Book item2 = new Book("А. Сакс");
    private Book item3 = new Book("Л. Толстой");
    private Book item4 = new Book("А. Чехов");
    private Smartphone item5 = new Smartphone("Samsung");
    private Smartphone item6 = new Smartphone("Meizu");
    private Smartphone item7 = new Smartphone("Honor");
    private Smartphone item8 = new Smartphone("huawei");


    @Test
    void EmptyBasket() {
        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void saveOneItem() {
        repository.save(item2);
        Product[] expected = new Product[]{item2};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveSomeItems() {
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
        Product[] expected = new Product[]{item3, item4, item5, item6};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


}