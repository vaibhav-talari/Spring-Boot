package spring.core.boot.service;

import java.util.List;

import spring.core.boot.model.Book;

public interface IBookService {
	
	public Long saveBook(Book book);
	public boolean deleteBook(long bookid);
	public Book getBook(long bookid);
	public List<Book> getAllBooks();
	public Book getBookwithtitle(String title);


}
