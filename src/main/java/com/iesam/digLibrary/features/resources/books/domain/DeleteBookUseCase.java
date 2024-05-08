package com.iesam.digLibrary.features.resources.books.domain;

public class DeleteBookUseCase {
    private BooksRepository repository;

    public DeleteBookUseCase(BooksRepository repository) {
        this.repository = repository;
    }
    public void execute(int id){
        repository.deleteBook(id);
    }
}
