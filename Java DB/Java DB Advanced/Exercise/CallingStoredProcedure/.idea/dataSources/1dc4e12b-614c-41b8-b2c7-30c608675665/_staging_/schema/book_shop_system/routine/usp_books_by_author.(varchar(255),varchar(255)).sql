CREATE PROCEDURE usp_books_by_author(IN first_name VARCHAR(255), IN last_name VARCHAR(255), OUT count INT)
  BEGIN
    SET count := (SELECT count(b.book_id)
                  FROM authors AS a
                    INNER JOIN books AS b
                      ON a.author_id = b.author_id
                         AND a.first_name = first_name
                         AND a.last_name = last_name);
    SELECT count;
  END;
