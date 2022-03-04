package com.codingdojo.travelbudget1.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codingdojo.travelbudget1.models.Expense;
import com.codingdojo.travelbudget1.services.ExpenseService;

@Controller
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	// Renders the index.jsp
	@GetMapping("/expenses")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		
		model.addAttribute("expenses", expenseService.allExpenses());
		
		return "index.jsp";
	}
	
	// Renders the edit.jsp
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);			
		return "edit.jsp";
	}
	
	// Renders the show.jsp
	@GetMapping("/expenses/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("expense", expenseService.findExpense(id));
		model.addAttribute("expenses", expenseService.allExpenses());
		System.out.println("Hello There.");
		
		return "view.jsp";
	}

	//Allows the user to create an expense
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("expenses", expenseService.allExpenses());
			return "index.jsp";
		}
		System.out.println("Is this thing working?");
		expenseService.createExpense(expense);
		
		return "redirect:/expenses";
	}
	// Allows the user to edit an expense
    @PutMapping("/expenses/{id}")
    public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	model.addAttribute("expenses", expenseService.allExpenses());
            return "/expenses/edit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expenses";
        }
    }
    // Allows the user to delete an expense
    @RequestMapping(value="/expenses/{id}", method=RequestMethod.DELETE)
    public String delete(@PathVariable("id") Long id) {
    	expenseService.deleteExpense(id);
        return "redirect:/expenses";
    }
}
