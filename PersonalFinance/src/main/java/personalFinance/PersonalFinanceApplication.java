package personalFinance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import personalFinance.entity.Category;
import personalFinance.repository.CategoryRepository;

@SpringBootApplication
public class PersonalFinanceApplication implements CommandLineRunner{

	@Autowired
	private CategoryRepository repository;
	
    public static void main(String[] args) {
        SpringApplication.run(PersonalFinanceApplication.class, args);
    }

	@Override
	public void run(String... arg0) throws Exception {
		
		repository.deleteAll();

		// save a couple of categories
		repository.save(new Category("Entertainment", "Entertainment"));
		repository.save(new Category("Rent", "Rent payment"));
		repository.save(new Category("Rent 2", "Rent payment"));

		// fetch all categories
		System.out.println("Categories found with findAll():");
		System.out.println("-------------------------------");
		for (Category category : repository.findAll()) {
			System.out.println(category);
		}
		System.out.println();

		// fetch an individual category
		System.out.println("Categories found with findByName('Rent'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByName("Rent"));

		
	}
}


