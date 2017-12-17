package rseg105.project3.part1.web.form;

import java.util.List;
import rseg105.project3.part1.domain.*;

public class Pagination {
    private int totalPages;
    private int currentPage;
    private long totalRecords;
    private List<Book> BookData;

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<Book> getBookData() {
        return BookData;
    }

    public void setBookData(List<Book> BookData) {
        this.BookData = BookData;
    }
}
