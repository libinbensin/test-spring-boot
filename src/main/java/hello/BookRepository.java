package hello;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import javax.transaction.Transactional;

/**
 * Created by libinsalal on 2/8/16.
 */
@Transactional
public interface BookRepository extends CrudRepository<Book, Long> {

    Page<Book> findAll(Pageable pageable);

    Book findByName(String name);

    Book findById(long id);
}
