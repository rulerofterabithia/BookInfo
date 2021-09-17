package com.cyk.bookinfo.controller;

import com.cyk.bookinfo.entity.Book;
import com.cyk.bookinfo.entity.Type;
import com.cyk.bookinfo.service.BookService;
import com.cyk.bookinfo.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private TypeService typeService;

    @RequestMapping("list")
    public String list(Model model, @RequestParam(required = false, defaultValue = "1") int pageNum, @RequestParam(required = false, defaultValue = "2") int pageSize) {
        //准备数据
        PageInfo<Book> pageInfo = bookService.findAllBooks(pageNum, pageSize);
        model.addAttribute("pageInfo", pageInfo);
        return "book/list";
    }

    @RequestMapping("del")
    public String del(int id) {
        bookService.delBookById(id);
        return "redirect:../book/list";
    }

    @GetMapping("add")
    public String toAdd(Book book, Model model) {
        List<Type> types = typeService.findAll();
        model.addAttribute("types", types);
        return "book/add";
    }

    @PostMapping("add")
    public String doAdd(Book book, BindingResult result, Model model, @RequestParam("photox") Part part, HttpServletRequest request) throws IOException {
        //1.数据校验
        if (result.hasFieldErrors()) {
            return "book/add";
        }
        String realPath = request.getServletContext().getRealPath("/upload");
        String ext = part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
        String newFileName = UUID.randomUUID() + ext;
        part.write(realPath + "/" + newFileName);
        //2.向数据库保存数据
        book.setPhoto(newFileName);
        bookService.saveBook(book);
        return "redirect:../book/list";
    }

    @GetMapping("edit")
    public String toEdit(Book book, int id, Model model) {
        List<Type> types = typeService.findAll();
        model.addAttribute("types", types);
        book = bookService.findBookById(id);
        model.addAttribute("book", book);
        return "book/edit";
    }

    @PostMapping("edit")
    public String doEdit(Book book, BindingResult result, Model model, @RequestParam("photox") Part part, HttpServletRequest request) throws IOException {
        //1.数据校验
        if (result.hasFieldErrors()) {
            return "book/edit";
        }
        if(!StringUtils.isEmpty(part.getSubmittedFileName())){
            String realPath = request.getServletContext().getRealPath("/upload");
            String ext = part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
            String newFileName = UUID.randomUUID() + ext;
            part.write(realPath + "/" + newFileName);
            //2.向数据库保存数据
            book.setPhoto(newFileName);
        }

        bookService.updateBook(book);
        return "redirect:../book/list";
    }
}
