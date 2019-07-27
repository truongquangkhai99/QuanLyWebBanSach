package dao;

import java.util.List;

import Model.Book;
import dto.BookDto;

public interface IBookDao {
	
		
	public BookDto getBookById(Integer id);

	public BookDto getBookByBookName(String bookName);

	public List<BookDto> getAllBooks();

	public void insertBook(BookDto book);

	public void deleteBook(String title);

	public void updateBook(BookDto book);
	

	public List<BookDto> search(BookDto book); 
	
}
