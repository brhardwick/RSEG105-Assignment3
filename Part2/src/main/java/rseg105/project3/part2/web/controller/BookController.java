package rseg105.project3.part2.web.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Locale;

import com.google.common.collect.Lists;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.FieldError;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;
import rseg105.project3.part2.domain.*;
import rseg105.project3.part2.service.*;
import rseg105.project3.part2.web.form.Pagination;
import rseg105.project3.part2.web.util.*;

@RequestMapping("/Books")
@Controller
public class BookController {
    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookService BookService;
    private MessageSource messageSource;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        logger.info("Listing Books");

        List<Book> Books = BookService.findAll();
        uiModel.addAttribute("books", Books);

        return "Books/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        Book Book = BookService.findById(id);
        uiModel.addAttribute("book", Book);

        return "Books/show";
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
    public String update(@Valid Book book, BindingResult bindingResult, Model uiModel,
                         HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes,
                         Locale locale) {
        logger.info("Updating Book");
        if (bindingResult.hasErrors()) {
            
            logger.info("Has errors");
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors ) {
               logger.info (error.getObjectName() + " - " + error.getDefaultMessage());
            }

            uiModel.addAttribute("message", new Message("error",
                
                messageSource.getMessage("Book_save_fail", new Object[]{}, locale)));
            uiModel.addAttribute("book", book);
            return "Books/update";
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("Book_save_success", new Object[]{}, locale)));
        BookService.save(book);
        return "redirect:/Books/" + UrlUtil.encodeUrlPathSegment(book.getId().toString(),
                httpServletRequest);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("book", BookService.findById(id));
        return "Books/update";
    }

    @RequestMapping(params = "form", method = RequestMethod.POST)
    public String create(@Valid Book book, BindingResult bindingResult, Model uiModel, 
		HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, 
		Locale locale, @RequestParam(value="file", required=false) Part file) {
        logger.info("Creating Book");
        if (bindingResult.hasErrors()) {
            
            uiModel.addAttribute("message", new Message("error",
                    messageSource.getMessage("Book_save_fail", new Object[]{}, locale)));
            uiModel.addAttribute("book", book);
            return "Books/create";
        }
        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("Book_save_success", new Object[]{}, locale)));

        logger.info("Book id: " + book.getId());

        BookService.save(book);
        return "redirect:/Books/"  + UrlUtil.encodeUrlPathSegment(book.getId().toString(),
        httpServletRequest);
    }

    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        Book Book = new Book();
        uiModel.addAttribute("book", Book);

        return "Books/create";
    }

    @ResponseBody
    @RequestMapping(value = "/listgrid", method = RequestMethod.GET, produces="application/json")
    public Pagination listGrid(@RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "rows", required = false) Integer rows,
                                @RequestParam(value = "sidx", required = false) String sortBy,
                                @RequestParam(value = "sord", required = false) String order) {

          Sort sort = null;
        String orderBy = sortBy;
        logger.info ("Sorting by '"+orderBy +"'");

        if (orderBy != null && order != null) {
            if (order.equals("desc")) {
                sort = new Sort(Sort.Direction.DESC, orderBy);
            } else
                sort = new Sort(Sort.Direction.ASC, orderBy);
        }
    
        PageRequest pageRequest = null;

        if (sort != null) {
            pageRequest = new PageRequest(page - 1, rows, sort);
        } else {
            pageRequest = new PageRequest(page - 1, rows);
        }

        Page<Book> BookPage = BookService.findAllByPage(pageRequest);

        Pagination pagination = new Pagination();
        pagination.setCurrentPage(BookPage.getNumber() + 1);
        pagination.setTotalPages(BookPage.getTotalPages());
        pagination.setTotalRecords(BookPage.getTotalElements());

        pagination.setBookData(Lists.newArrayList(BookPage.iterator()));

        return pagination;
    }

    @Autowired
    public void setBookService(BookService BookService) {
        this.BookService = BookService;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
