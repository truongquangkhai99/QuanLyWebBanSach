package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.BookDto;

public class BookDaoIplm implements IBookDao{
	

	@Override
	public BookDto getBookById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookDto getBookByBookName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookDto> getAllBooks() {
		Connection connection = null;
		Statement stmt = null;
		try {
			connection = ConnectionFactory.getConnection();
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Book_Id,Book_Name, book.Description,categories.Category_Name,Book_Author, Book_Date, Book_Publisher,Price FROM book, categories WHERE book.Category_Id = categories.Category_Id");
			List<BookDto> books = new ArrayList<>();
			while (rs.next()) {
				BookDto bookDto = new BookDto();
				bookDto.setId(rs.getInt("Book_Id"));
				bookDto.setTitle(rs.getString("Book_Name"));
				
				bookDto.setDecription(rs.getString("book.Description"));
				bookDto.setAuthor(rs.getString("Book_Author"));
				bookDto.setCategory(rs.getString("categories.Category_Name"));
				bookDto.setPublisherDate(rs.getDate("Book_Date"));
				bookDto.setPublisher(rs.getString("Book_Publisher"));
				bookDto.setPrice(rs.getDouble("Price"));

				books.add(bookDto);
			}
			return books;
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public void insertBook(BookDto book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteBook(String title) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateBook(BookDto book) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookDto> search(BookDto book) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
