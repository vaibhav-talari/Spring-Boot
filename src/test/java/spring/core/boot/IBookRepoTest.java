package spring.core.boot;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import spring.core.boot.dao.IBookRepo;
import spring.core.boot.model.Book;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class IBookRepoTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private IBookRepo bookRepo;
	
		
	private Book[] books;
	
	@Before
	public void setUp()
	{
		books=new Book[] {
				new Book(1001, "Book1", 200, 4, LocalDate.now().minusDays(7)),
				new Book(1005, "Book3", 500, 9, LocalDate.now().minusDays(3)),
				new Book(1009, "Book5", 600, 2, LocalDate.now().minusDays(5)),

		};
		for(Book bks:books)
			entityManager.persist(bks);
	}
	
	@After
	public void tearDown() {
		for(Book bks:books)
			entityManager.remove(bks);
	}
	
	@Test
	public void whenFindBookByTitle_returnMatchingBook() {
		Book actual=bookRepo.findByTitle("Book3");
		Book expected=books[1];
		assertThat(actual).isEqualTo(expected);

		
	}
	
	

}
