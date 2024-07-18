package com.asta.expense.controller;

import com.asta.expense.mapper.IncomeMapper;
import com.asta.expense.model.Income;
import com.asta.expense.payload.dto.IncomeForm;
import com.asta.expense.service.income.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("income")
public class IncomeController {

    private static final String INCOME_ADD_PAGE = "admin/add-income";
    private static final String INCOME_LIST_PAGE = "admin/list-income";
    private static final String INCOME_EDIT_PAGE = "admin/edit-income";

    @Autowired
    @Qualifier("IncomeMapper")
    IncomeMapper incomeMapper;
    @Autowired
    IncomeService incomeService;


    @GetMapping("/list")
    public String incomeListPage(ModelMap model) {
        List<Income> incomes = incomeService.listAllIncomes();
        List<IncomeForm> incomeForms = incomeMapper.listIncomeForm(incomes);
        model.addAttribute("incomes", incomeForms);
        return INCOME_LIST_PAGE;
    }


    @GetMapping("/add")
    public String showAddPage(Model model) {
        IncomeForm incomeForm = new IncomeForm();
        model.addAttribute("incomeForm", incomeForm);
        return INCOME_ADD_PAGE;
    }

    @PostMapping("/post")
    public String saveIncome(@ModelAttribute("incomeForm") IncomeForm incomeForm, RedirectAttributes redirectAttributes) throws IOException {
        Income income = incomeMapper.map(incomeForm);
        incomeService.saveIncome(income);
        redirectAttributes.addFlashAttribute("savedSuccess", true);
        return "redirect:/income/list";
    }

    @GetMapping("/{id}/edit")
    public String editIncome(Model model, @PathVariable Long id) {
        Optional<Income> income = incomeService.getIncomeById(id);
        IncomeForm incomeForm = incomeMapper.remap(income.get());
        model.addAttribute("incomeForm", incomeForm);
        return INCOME_EDIT_PAGE;
    }

    @PostMapping("/update")
    public String updateIncome(@ModelAttribute("incomeForm") IncomeForm incomeForm, RedirectAttributes redirectAttributes) {
        Optional<Income> getIncome = incomeService.getIncomeById(Long.valueOf(incomeForm.getId()));
        Income updateIncome = incomeMapper.map(incomeForm, getIncome.get());
        incomeService.updateIncome(updateIncome);
        redirectAttributes.addFlashAttribute("savedSuccess", true);
        return "redirect:/income/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteIncome(@PathVariable String id) {
        Income income = incomeService.deleteIncome(Long.valueOf(id));
        return "redirect:/income/list";
    }
}
