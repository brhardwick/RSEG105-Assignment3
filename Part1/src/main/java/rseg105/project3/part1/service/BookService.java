package rseg105.project3.part1.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rseg105.project3.part1.domain.*;

public interface BookService {
    List<Book> findAll();
    Book findById(Long id);
    Book save(Book Book);
    Page<Book> findAllByPage(Pageable pageable);
}
