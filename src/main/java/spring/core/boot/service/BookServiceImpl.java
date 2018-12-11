package spring.core.boot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.core.boot.dao.IBookRepo;
import spring.core.boot.model.Book;

@Service
public class BookServiceImpl implements IBookService {
	
	@Autowired
	private IBookRepo bookRepo;

	@Override
	public Long saveBook(Book book) {
		Book bookSaved=bookRepo.save(book);
		return bookSaved==null?-1:bookSaved.getBookid();
	}

	@Override
	public boolean deleteBook(long bookid) {
		boolean isDeleted=false;
		if(bookRepo.existsById(bookid))
		{
			bookRepo.deleteById(bookid);
			isDeleted=true;
		}
		return isDeleted;
		
	}

	@Override
	public Book getBook(long bookid) {
		Optional<Book> bookData= bookRepo.findById(bookid);
		return bookData.isPresent()?bookData.get():null;
		
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();

		
	}

	@Override
	public Book getBookwithtitle(String title) {
		return bookRepo.findByTitle(title);
	}

}
