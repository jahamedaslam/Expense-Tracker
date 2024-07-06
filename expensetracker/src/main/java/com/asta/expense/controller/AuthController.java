package com.asta.expense.controller;

import com.asta.expense.mapper.AppUserMapper;
import com.asta.expense.model.AppUser;
import com.asta.expense.payload.dto.AppUserForm;
import com.asta.expense.service.appuser.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class AuthController {


    private static final String LOGIN = "admin/login";
    private static final String REGISTER = "admin/register";

    @Autowired
    @Qualifier("AppUserMapper")
    AppUserMapper appUserMapper;
    @Autowired
    AppUserService appUserService;


    @GetMapping("/")
    public String getLogin() {
        return LOGIN;
    }

    @GetMapping("/register")
    public String getRegister() {
        return REGISTER;
    }


    @PostMapping("/register-save")
    public String showRegisterPage(@ModelAttribute("registerForm") AppUserForm appUserForm, RedirectAttributes redirectAttributes) {
        AppUser appUser = appUserMapper.map(appUserForm);
        appUserService.saveAppUser(appUser);
        redirectAttributes.addFlashAttribute("savedSuccess", true);
        return "redirect:/appUser/list";
    }

    @PostMapping("/login")
    public String showLoginPage(@ModelAttribute("loginForm") AppUserForm appUserForm, RedirectAttributes redirectAttributes) {
        Optional<AppUser> appUser = appUserService.getAppUserByUsername(appUserForm.getUsername());
        boolean isUser = appUserMapper.checkAppUser(appUserForm, appUser.get());
        if (isUser) {
            redirectAttributes.addFlashAttribute("Login Successfully", true);
        } else {
            redirectAttributes.addFlashAttribute("Login Failed", false);
        }
        return "redirect:/appUser/list";
    }

}
