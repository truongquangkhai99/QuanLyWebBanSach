package bll;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import Model.Book;
import dao.BookDaoIplm;
import dao.IBookDao;
import dto.BookDto;

public class BookManagementImpl implements IBookManagement {
	
	 IBookDao bookDao = new BookDaoIplm();


	@Override
	public List<Book> getAllBooks() {
		List<BookDto> books = bookDao.getAllBooks();
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		List<Book> list = new ArrayList<>();
		
		for (BookDto bk : books) {
			Book book = new Book();
			book.setId(bk.getId());
			book.setTitle(bk.getTitle());
			book.setCategory(bk.getCategory());
			book.setDecription(bk.getDecription());
			book.setAuthor(bk.getAuthor());
			book.setPublisherDate(dateFormat.format(bk.getPublisherDate()));
			book.setPublisher(bk.getPublisher());
			book.setPrice(bk.getPrice());
			
			list.add(book);
		}
		return list;
	}

}
