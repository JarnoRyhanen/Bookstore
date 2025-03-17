package home.jarnobookstore;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import home.jarnobookstore.domain.Book;
import home.jarnobookstore.domain.Category;
import home.jarnobookstore.domain.BookRepository;
import home.jarnobookstore.domain.CategoryRepository;

@SpringBootTest(classes = JarnobookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void createNewBook() {

        Category category = new Category("Fiction");
        categoryRepository.save(category);

        Book book = new Book("Test book", "Maija Meikäläinen",
                2020, "asjdkjasd", 20.00, category);

        bookRepository.save(book);
        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void findBookByTitle() {
        List<Book> books = bookRepository.findBookByTitle("Test book");
        assertThat(books.get(0)).isNotNull();
    }

    @Test
    public void deleteBook() {
        List<Book> books = bookRepository.findBookByTitle("Test book");

        Book book = books.get(0);
        bookRepository.delete(book);

        List<Book> newBooks = bookRepository.findBookByTitle("Test book");
        assertThat(newBooks).hasSize(0);

    }
}