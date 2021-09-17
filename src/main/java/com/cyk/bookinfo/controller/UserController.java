package com.cyk.bookinfo.controller;

import com.cyk.bookinfo.entity.User;
import com.cyk.bookinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.validation.Valid;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("reg")
    public String toReg(User user) {
        return "user/reg";
    }

    @PostMapping("reg")
    public String doReg(@Valid User user, BindingResult result, Model model, @RequestParam("photox") Part part, HttpServletRequest request) throws IOException {
//        System.out.println(user);
        //数据校验
        if (result.hasFieldErrors()) {
            return "user/reg";
        }
        String realPath = request.getServletContext().getRealPath("/upload");
        String ext = part.getSubmittedFileName().substring(part.getSubmittedFileName().lastIndexOf("."));
        String newFileName = UUID.randomUUID() + ext;
        part.write(realPath + "/" + newFileName);
        //把用户填写的信息传递给jsp
        model.addAttribute("user", user);
        //向数据库保存数据
        user.setPhoto(newFileName);
        userService.saveUser(user);
        return "user/login";
    }

    @GetMapping("login")
    public String toLogin(User user) {
        return "user/login";
    }

    @PostMapping("login")
    public String doLogin(User user, BindingResult result, Model model, HttpSession session) throws IOException {
        //向数据库保存数据
        User dbUser = userService.findUserByNameAndPwd(user);
        if (dbUser == null) {
            return "user/login";
        } else {
            session.setAttribute("user", dbUser);
        }
        return "welcome";
    }

    @RequestMapping("exit")
    public String exit(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:../user/login";
    }
}
