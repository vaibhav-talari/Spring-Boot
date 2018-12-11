package spring.core.boot;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import spring.core.boot.dao.IBookRepo;
import spring.core.boot.model.Book;
import spring.core.boot.service.BookServiceImpl;
import spring.core.boot.service.IBookService;

@RunWith(SpringRunner.class)
public class IBookServiceTest {
	
	@TestConfiguration
	static class BookServiceImplUnitTest{
		@Bean
		public IBookService bookService(){
			return new BookServiceImpl();
		}
	}
	
	@Autowired
	private IBookService bookService;
	@MockBean
	private IBookRepo bookRepo;
	
	private Book[] books;

	@Before
	public void setUp() {
		books=new Book[] {
				new Book(1001, "Book1", 200, 4, LocalDate.now().minusDays(7)),
				new Book(1005, "Book3", 500, 9, LocalDate.now().minusDays(3)),
				new Book(1009, "Book5", 600, 2, LocalDate.now().minusDays(5)),

		};
		Mockito.when(bookRepo.findByTitle(books[2].getTitle()))
		.thenReturn(books[2]);
	}
	
	@Test
	public void whenFind_withTitle() {
		Book actual=bookService.getBookwithtitle(books[2].getTitle());
		Book expected=books[2];
		assertThat(actual).isEqualTo(expected);


	}
}