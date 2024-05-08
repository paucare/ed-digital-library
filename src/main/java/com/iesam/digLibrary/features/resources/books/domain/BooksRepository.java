package com.iesam.digLibrary.features.resources.books.domain;

import java.util.List;

public interface BooksRepository {
    public void saveBook(Books resource);
    public void deleteBook(int id);
    public List<Books> getAllBooks();
    public Books geBookById(int id);
}
