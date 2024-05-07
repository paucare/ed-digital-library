package com.iesam.digLibrary.features.resources.books.domain;

public class SaveBookUseCase {

    private BooksRepository repository;

    public SaveBookUseCase(BooksRepository repository) {
        this.repository = repository;
    }
    public void execute(Books resource){
        repository.saveBook(resource);
    }
}
