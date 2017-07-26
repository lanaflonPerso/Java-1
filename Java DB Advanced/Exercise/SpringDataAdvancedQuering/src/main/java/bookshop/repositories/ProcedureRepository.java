package bookshop.repositories;

import bookshop.entities.ProcedureTable;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProcedureRepository extends CrudRepository<ProcedureTable, Long> {

    @Procedure(name = "booksByAuthor")
    int getCountBooksByAuthor(@Param("first_name") String firstName, @Param("last_name") String lastName);
 }