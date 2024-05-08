package com.iesam.digLibrary.features.resources.books.domain;

import java.util.List;
    public class GetBooksUseCase {
        private BooksRepository repository;

        public GetBooksUseCase(BooksRepository repository) {
            this.repository = repository;
        }
        public List<Books> execute(){
            return repository.getAllBooks();
        }
    }

