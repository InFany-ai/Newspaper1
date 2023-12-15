package ua.nure.order.server.dao;

import java.util.Collection;

import ua.nure.order.entity.Book;

public interface BookDAO {
	public int addBook(Book item) throws DAOException;
	public Book deleteBook(int id) throws DAOException;
	
	public boolean updateBookCount(int id, int count) throws DAOException;

	public Collection<Book> findByTitle(String pattern);

	public Collection<Book> findByAuthor(String pattern);

	public Collection<Book> listBooks();

	public Book findById(Integer id) throws DAOException;

}
