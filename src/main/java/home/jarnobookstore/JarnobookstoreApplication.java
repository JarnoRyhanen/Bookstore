package home.jarnobookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import home.jarnobookstore.domain.AppUser;
import home.jarnobookstore.domain.AppUserRepository;
import home.jarnobookstore.domain.Book;
import home.jarnobookstore.domain.BookRepository;
import home.jarnobookstore.domain.Category;
import home.jarnobookstore.domain.CategoryRepository;

@SpringBootApplication
public class JarnobookstoreApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JarnobookstoreApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(JarnobookstoreApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(JarnobookstoreApplication.class);

	@Bean
	public CommandLineRunner clr(BookRepository bookRepository, CategoryRepository categoryRepository,
			AppUserRepository appUserRepository) {
		return (args) -> {
			/*
			 * 
			 * appUserRepository.deleteAll();
			 * AppUser user1 = new AppUser("user", "user@user.com",
			 * "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
			 * "USER");
			 * 
			 * AppUser user2 = new AppUser("admin", "admin@admin.com",
			 * "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
			 * "ADMIN");
			 * System.out.println("SAVING USER 1");
			 * appUserRepository.save(user1);
			 * System.out.println("SAVING USER 2");
			 * appUserRepository.save(user2);
			 */

			log.info("fetch all users");
			for (AppUser user : appUserRepository.findAll()) {
				log.info(user.toString());
			}
			/*
			 * bookRepository.deleteAll();
			 * categoryRepository.deleteAll();
			 */

			/*
			 * Category category1 = new Category("Sci-fi");
			 * Category category2 = new Category("Fantasy");
			 * Category category3 = new Category("Manga");
			 * Category category4 = new Category("Literary classic");
			 * Category category5 = new Category("Nonfiction");
			 */
			/*
			 * categoryRepository.save(category1);
			 * categoryRepository.save(category2);
			 * categoryRepository.save(category3);
			 * categoryRepository.save(category4);
			 * categoryRepository.save(category5);
			 */

			log.info("fetch all categories");
			for (Category category : categoryRepository.findAll()) {
				log.info(category.toString());
			}

			/*
			 * bookRepository.save(new Book("good book 1", "Author 1", 2020, "dfvhzdvcjsgf",
			 * 50.32, category1));
			 * bookRepository.save(new Book("good book 2", "Author 2", 1999, "abcdeafttss2",
			 * 11.59, category2));
			 * bookRepository.save(new Book("good book 3", "Author 3", 2000, "123-12312322",
			 * 5.99, category1));
			 * bookRepository.save(new Book("good book 4", "Author 1", 2015, "mdkfdskfsjfd",
			 * 10.00, category5));
			 */
			log.info("fetch all books");
			for (Book book : bookRepository.findAll()) {
				System.out.println(book.toString());
			}
		};
	}

}
