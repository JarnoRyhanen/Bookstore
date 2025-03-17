package home.jarnobookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import home.jarnobookstore.domain.Category;
import home.jarnobookstore.domain.CategoryRepository;

@SpringBootTest(classes = JarnobookstoreApplication.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Test
    public void createNewCategory() {
        Category category = new Category("Test category");
        categoryRepository.save(category);
        assertThat(category.getCategoryId()).isNotNull();
    }

    @Test
    public void searchCategoryByName() {
        Category category = categoryRepository.findCategoryByName("Test category");
        assertThat(category).isNotNull();
    }

    @Test
    public void deleteCategory() {
        Category category = categoryRepository.findCategoryByName("Test category");
        categoryRepository.delete(category);
    
        Category deletedCategory = categoryRepository.findCategoryByName("Test category");
        assertThat(deletedCategory).isNull(); 
    }
    @Test
    public void searchCategoryByNameAfterDeletetion() {
        Category category = categoryRepository.findCategoryByName("Test category");
        assertThat(category).isNull();
    }
}
