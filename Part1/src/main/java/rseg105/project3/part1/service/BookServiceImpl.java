package rseg105.project3.part1.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import rseg105.project3.part1.repository.*;
import rseg105.project3.part1.domain.*;
@Repository
@Transactional
@Service("BookService")
public class BookServiceImpl implements BookService {
    private BookRepository BookRepository;

    
    @Transactional(readOnly=true)
    public List<Book> findAll() {
        return Lists.newArrayList(BookRepository.findAll());
    }

    
    @Transactional(readOnly=true)
    public Book findById(Long id) {
        return BookRepository.findOne(id);
    }

    
    public Book save(Book Book) {
        return BookRepository.save(Book);
    }

    @Autowired
    public void setBookRepository(BookRepository BookRepository) {
        this.BookRepository = BookRepository;
    }

    
    @Transactional(readOnly=true)
    public Page<Book> findAllByPage(Pageable pageable) {
        return BookRepository.findAll(pageable);
    }

}
