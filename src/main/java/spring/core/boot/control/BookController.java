package spring.core.boot.control;

import java.util.Collections;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import spring.core.boot.model.Book;
import spring.core.boot.service.IBookService;

@Controller
@RequestMapping("/library")
public class BookController {
	
	@Autowired
	private IBookService bookService;
		
	@ModelAttribute("bookadd")
	public Book create()
	{
		return new Book();
	}
	
	@GetMapping("/addbook")
	public ModelAndView addBookView()
	{
		
		return new ModelAndView("book/addbook");
	}
	
	@PostMapping("/addbook")
	public ModelAndView addBookSave(@Valid @ModelAttribute("bookadd") Book book,BindingResult result )
	{
		ModelAndView modelbook=null;
		if(result.hasErrors())
		{
			modelbook=new ModelAndView("book/addbook","bookattribute",book);
		}
		else
		{
			bookService.saveBook(book);
			modelbook=new ModelAndView("redirect:/library/viewbooks");
		}
		return modelbook;
	}
	
	@GetMapping("/viewbooks")
	public ModelAndView listBooks()
	{
		ModelAndView searchmodel= new ModelAndView("book/showbooks","booklist",bookService.getAllBooks());
		return searchmodel;
	}
	
	@GetMapping("/searchbook")
	public ModelAndView searchBookview()
	{
		return new ModelAndView("book/searchbook");
	}
	
	@PostMapping("/searchbook")
	public ModelAndView searchBook(@RequestParam Long bookid)
	{
		Set<Book> book=Collections.singleton(bookService.getBook(bookid));
		return new ModelAndView("book/searchbook","singlebook",book);
	}

	
	@GetMapping("/deletebook")
	public ModelAndView deleteBook(@RequestParam(value="bookid") Long bookid )
	{
		bookService.deleteBook(bookid);		
		ModelAndView searchmodel= new ModelAndView("book/showbooks","booklist",bookService.getAllBooks());
		return searchmodel.addObject("redirect:/library/viewbooks");
	}
	
	@GetMapping("/delete")
	public ModelAndView deleteBook()
	{
		ModelAndView searchmodel= new ModelAndView("book/deletebook","booklist",bookService.getAllBooks());
		
		return searchmodel;
	}
	
	
	
}
