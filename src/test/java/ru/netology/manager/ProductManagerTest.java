package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Book item1 = new Book(1, "Преступление и наказание", 444, "Ф. Достоевский");
    Book item2 = new Book(2, "Человек который перепутал жену со шляпой", 555, "А. Сакс");
    Book item3 = new Book(3, "Война и Мир", 666, "Л. Толстой");
    Book item4 = new Book(4, "Пари", 545, "А. Чехов");
    Smartphone item5 = new Smartphone(5, "А3", 16000, "Samsung");
    Smartphone item6 = new Smartphone(6, "Note8", 25000, "Meizu");
    Smartphone item7 = new Smartphone(7, "A9lite", 100000, "Honor");
    Smartphone item8 = new Smartphone(8, "nova 9", 11000, "huawei");


    @BeforeEach
    void manageAdd() {
        repository.save(item1);
        repository.save(item2);
        repository.save(item3);
        repository.save(item4);
        repository.save(item5);
        repository.save(item6);
        repository.save(item7);
        repository.save(item8);
    }


    @Test
    void searchByBookName() {
        Product[] expected = new Product[]{item3};
        Product[] actual = manager.searchBy("Война и Мир");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookAuthor() {
        Product[] expected = new Product[]{item2};
        Product[] actual = manager.searchBy("А. Сакс");
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookNotValidAuthor() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Ли Харпер");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = new Product[]{item5};
        Product[] actual = manager.searchBy("А3");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = new Product[]{item6};
        Product[] actual = manager.searchBy("Meizu");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneNotValidManufacturer() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy("Ohnor");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAddSomeItems() {
        Product[] expected = new Product[]{item1};
        Product[] actual = manager.searchBy("Ф. Достоевский");
        assertArrayEquals(expected, actual);
    }
}