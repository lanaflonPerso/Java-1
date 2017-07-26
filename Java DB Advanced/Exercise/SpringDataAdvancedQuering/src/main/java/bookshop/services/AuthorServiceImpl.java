package bookshop.services;

import bookshop.entities.Author;
import bookshop.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public Author createOne(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public List<Author> createMany(Iterable<Author> authors) {
        return this.authorRepository.save(authors);
    }

    @Override
    public Author updateOne(Author author) {
        return this.authorRepository.save(author);
    }

    @Override
    public List<Author> updateMany(Iterable<Author> authors) {
        return this.authorRepository.save(authors);
    }

    @Override
    public void deleteById(long id) {
        this.authorRepository.delete(id);
    }

    @Override
    public List<String> getAuthorsSearch(String substr1, String substr2) {
        return this.authorRepository.getAuthorsSearch(substr1, substr2);
    }

}
