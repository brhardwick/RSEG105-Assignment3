package rseg105.project3.part1.web.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;

import com.google.common.collect.Lists;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import rseg105.project3.part1.domain.Book;
import rseg105.project3.part1.model.Message;
import rseg105.project3.part1.service.BookService;
import rseg105.project3.part1.web.form.Pagination;
import rseg105.project3.part1.web.util.UrlUtil;

@RequestMapping("/Books")
@Controller
public class BookController {
    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    private BookService BookService;
    private MessageSource messageSource;

    //This endpoint returns the list view and injects a list of books into the view
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model uiModel) {
        List<Book> Books = BookService.findAll();
        uiModel.addAttribute("books", Books);
        return "Books/list";
    }

    //This endpoint returns the show view and injects a single book into the view
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable("id") Long id, Model uiModel) {
        Book Book = BookService.findById(id);
        uiModel.addAttribute("book", Book);
        return "Books/show";
    }

    //This endpoint gets the update view
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("book", BookService.findById(id));
        return "Books/update";
    }

    //This endpoint gets the create view
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String createForm(Model uiModel) {
        Book Book = new Book();
        uiModel.addAttribute("book", Book);

        return "Books/create";
    }

    //This endpoint is the actual update method, called from the form elements on the front end
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
    public String update(@Valid Book book, BindingResult bindingResult, Model uiModel,
                         HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes,
                         Locale locale) {
        
        if (bindingResult.hasErrors()) {
            
            logger.info("The book had some validation errors");
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors ) {
               logger.info (error.getObjectName() + " - " + error.getDefaultMessage());
            }

            //Since the save was not successful, we inject a message taken from the i18n localization 
            uiModel.addAttribute("message", new Message("error",messageSource.getMessage("Book_save_fail", new Object[]{}, locale)));
            uiModel.addAttribute("book", book);
            //Return the same screen
            return "Books/update";
        }
        uiModel.asMap().clear();

        //Since validation was successful, we redirect to the show endpoint, and inject the success message from i18n
        redirectAttributes.addFlashAttribute("message", new Message("success", messageSource.getMessage("Book_save_success", new Object[]{}, locale)));
        BookService.save(book);
        return "redirect:/Books/" + UrlUtil.encodeUrlPathSegment(book.getId().toString(),httpServletRequest);
    }

    //Similar to the update, this endpoint is doing the actual creation in the database, called from the form on the frontend
    @RequestMapping(params = "form", method = RequestMethod.POST)
    public String create(@Valid Book book, BindingResult bindingResult, Model uiModel, 
		HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes, 
		Locale locale) {
        
        if (bindingResult.hasErrors()) {
            
            logger.info("The book had some validation errors");
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors ) {
               logger.info (error.getObjectName() + " - " + error.getDefaultMessage());
            }

            //inject a message and book back into the creation screen (the book is partial in this case)
            uiModel.addAttribute("message", new Message("error", messageSource.getMessage("Book_save_fail", new Object[]{}, locale)));
            uiModel.addAttribute("book", book);
            return "Books/create";
        }

        uiModel.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("Book_save_success", new Object[]{}, locale)));

        logger.info("Book created");
        BookService.save(book);
        return "redirect:/Books/"  + UrlUtil.encodeUrlPathSegment(book.getId().toString(),   httpServletRequest);
    }

   //The listgrid endpoint is called from the JQGrid ajax call. It takes each property from the url and uses it in our 
   ///pagination class to modify the output.
    @ResponseBody
    @RequestMapping(value = "/listgrid", method = RequestMethod.GET, produces="application/json")
    public Pagination listGrid(@RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "rows", required = false) Integer rows,
                                @RequestParam(value = "sidx", required = false) String sortBy,
                                @RequestParam(value = "sord", required = false) String order) {

        Sort sort = null;
        String orderBy = sortBy;        

        //The trigger for when to order asc or desc
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
