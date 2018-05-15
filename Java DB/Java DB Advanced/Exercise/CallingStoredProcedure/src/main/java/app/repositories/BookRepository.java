package app.repositories;

import app.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Procedure("usp_books_by_author")
    int getCountOfWrittenBooks(String first_name, String last_name);
}
