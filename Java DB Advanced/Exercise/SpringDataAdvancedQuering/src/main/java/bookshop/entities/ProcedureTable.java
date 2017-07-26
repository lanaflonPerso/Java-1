package bookshop.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Hristo Skipernov on 20/07/2017.
 */

@Entity
@Table(name = "procedures")
@NamedStoredProcedureQuery(name = "booksByAuthor",
        procedureName = "usp_books_by_author",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "first_name", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.IN, name = "last_name", type = String.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT, name = "count", type = Integer.class)
        })
public class ProcedureTable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procedure_table_id")
    private long id;

}