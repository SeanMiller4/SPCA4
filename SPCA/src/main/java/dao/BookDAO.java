package dao;

import java.util.List;

import SPCA.SPCA.Book;

public interface BookDAO extends CommonDAO<Book, Integer> {
	List<Book> searchByTitle(String title);
}