package com.iesam.digLibrary.features.resources.books.domain;

public class UpdateBookUseCase {
    private BooksRepository repository;

    public UpdateBookUseCase(BooksRepository repository) {
        this.repository = repository;
    }
    public void execute(Books book){
        repository.updateBook(book);
    }
}
