package bookshop.services.impl;

import bookshop.entities.Author;
import bookshop.repositories.api.AuthorRepository;
import bookshop.services.api.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Hristo Skipernov on 21/07/2017.
 */

@Transactional
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }

    @Override
    public Author findById(long id) {
        return this.authorRepository.findOne(id);
    }

    @Override
    public Author create(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public List<Author> createAll(Iterable<Author> authors) {
        return this.authorRepository.save(authors);
    }

    @Override
    public void deleteById(long id) {
        this.authorRepository.delete(id);
    }

    @Override
    public List<Author> findAllByOrderByBooksDesc() {
        return this.authorRepository.findAuthorsByOrOrderByBooksDesc();
    }

    @Override
    public List<Author> findAuthorsByBooksReleaseDateBefore1990() {
        return this.authorRepository.findAuthorsByBooksReleaseDateBefore1990();
    }
}