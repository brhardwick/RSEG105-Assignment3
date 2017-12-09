package rseg105.project3.part1.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rseg105.project3.part1.domain.*;
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}
