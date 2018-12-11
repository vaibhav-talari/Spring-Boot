package spring.core.boot;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import spring.core.boot.dao.ISubjectRepo;
import spring.core.boot.model.Book;
import spring.core.boot.model.Subject;
import spring.core.boot.service.ISubjectService;
import spring.core.boot.service.SubjectServiceImpl;

@RunWith(SpringRunner.class)

public class ISubjectServiceTest {
	
	@TestConfiguration
	static class SubjectServiceImplUnitTest{
		@Bean
		public ISubjectService subjectService(){
			return new SubjectServiceImpl();
		}
	}
	

	@Autowired
	private ISubjectService SubjectService;
	@MockBean
	private ISubjectRepo subjectRepo;
	private Subject[] subjects;
	
	private Book[] books=new Book[] {
			new Book(1001, "Book1", 200, 4, LocalDate.now().minusDays(7)),
			new Book(1005, "Book3", 500, 9, LocalDate.now().minusDays(3))

	};
	
	Set<Book> mySet = new HashSet<Book>(Arrays.asList(books));

	
	@Before
	public void setUp()
	{
		subjects=new Subject[] {
				new Subject(100932,"Subject1",500,mySet),
				new Subject(100955,"Subject3",500,mySet),
				new Subject(100972,"Subject5",599)
		};
		Mockito.when(subjectRepo.findAllByDuration(500))
		.thenReturn(Arrays.asList(subjects[0],subjects[1]));
	}
	
	@Test
	public void whenFind_withDuration()
	{
		List<Subject> actual=SubjectService.getSubjectwithduration(500);
		List<Subject> expected=Arrays.asList(subjects[0],subjects[1]);
		assertThat(actual).isEqualTo(expected);

	}
}
