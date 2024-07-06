package com.asta.expense.controller;

import com.asta.expense.mapper.ExpenseMapper;
import com.asta.expense.model.Expense;
import com.asta.expense.payload.dto.ExpenseForm;
import com.asta.expense.service.expense.ExpenseService;
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
@RequestMapping("expense")
public class ExpenseController {

    private static final String EXPENSE_ADD_PAGE = "admin/add-expense";
    private static final String EXPENSE_LIST_PAGE = "admin/list-expense";
    private static final String EXPENSE_EDIT_PAGE = "admin/edit-expense";

    @Autowired
    @Qualifier("ExpenseMapper")
    ExpenseMapper expenseMapper;
    @Autowired
    ExpenseService expenseService;


    @GetMapping("/list")
    public String expenseListPage(ModelMap model) {
        List<Expense> expenses = expenseService.listAllExpenses();
        List<ExpenseForm> expenseForms = expenseMapper.listExpenseForm(expenses);
        model.addAttribute("expenses", expenseForms);
        return EXPENSE_LIST_PAGE;
    }


    @GetMapping("/add")
    public String showAddPage(Model model) {
        ExpenseForm expenseForm = new ExpenseForm();
        model.addAttribute("expenseForm", expenseForm);
        return EXPENSE_ADD_PAGE;
    }

    @PostMapping("/post")
    public String saveExpense(@ModelAttribute("expenseForm") ExpenseForm expenseForm, RedirectAttributes redirectAttributes) throws IOException {
        Expense expense = expenseMapper.map(expenseForm);
        expenseService.saveExpense(expense);
        redirectAttributes.addFlashAttribute("savedSuccess", true);
        return "redirect:/expense/list";
    }

    @GetMapping("/{id}/edit")
    public String editExpense(Model model, @PathVariable Long id) {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        ExpenseForm expenseForm = expenseMapper.remap(expense.get());
        model.addAttribute("expenseForm", expenseForm);
        return EXPENSE_EDIT_PAGE;
    }

    @PostMapping("/update")
    public String updateExpense(@ModelAttribute("expenseForm") ExpenseForm expenseForm, RedirectAttributes redirectAttributes) {
        Optional<Expense> getExpense = expenseService.getExpenseById(Long.valueOf(expenseForm.getId()));
        Expense updateExpense = expenseMapper.map(expenseForm, getExpense.get());
        expenseService.updateExpense(updateExpense);
        redirectAttributes.addFlashAttribute("savedSuccess", true);
        return "redirect:/expense/list";
    }

    @PostMapping(value = "/{id}/delete")
    @ResponseBody
    public Map<String, Boolean> deleteExpense(@PathVariable String id) {
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        Expense expense = expenseService.deleteExpense(Long.valueOf(id));
        if (expense == null) {
            map.put("Success", Boolean.FALSE);
        }
        map.put("Success", Boolean.TRUE);
        return map;
    }

}
