package com.iesam.digLibrary.features.resources.books.data;

import com.iesam.digLibrary.features.resources.books.data.local.BooksFileLocalDataSource;
import com.iesam.digLibrary.features.resources.books.domain.BooksRepository;

import com.iesam.digLibrary.features.resources.books.domain.Books;

import java.util.List;


public class BooksDataRepository implements BooksRepository {

    private BooksFileLocalDataSource localDataSource;

    public BooksDataRepository(BooksFileLocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public void saveBook(Books resource) {
        localDataSource.save(resource);
    }

    @Override
    public void deleteBook(int id) {
        localDataSource.delete(id);
    }
    @Override
    public void updateBook(Books book){
        deleteBook(book.id);
        saveBook(book);
    }

    @Override
    public List<Books> getAllBooks() {
        return localDataSource.findAll();
    }

    @Override
    public Books geBookById(int id) {
        return localDataSource.findById(id);
    }
}
