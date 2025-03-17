package home.jarnobookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import home.jarnobookstore.web.BookController;

@SpringBootTest
class JarnobookstoreApplicationTests {

	private final BookController bookController;

	@Autowired
	public JarnobookstoreApplicationTests(BookController bookController) {
		this.bookController = bookController;
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void controllerLoads() throws Exception {
		assertThat(bookController).isNotNull();
	}

}
