package com.iesam.digLibrary.features.resources.books.domain;

public class GetBookByIdUseCase {
    private BooksRepository repository;

    public GetBookByIdUseCase(BooksRepository repository) {
        this.repository = repository;
    }
    public Books execute(int id){
        return repository.geBookById(id);
    }
}
