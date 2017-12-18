package rseg105.project3.part2.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rseg105.project3.part2.domain.*;
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
}
