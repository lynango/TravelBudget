package com.codingdojo.travelbudget1.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.travelbudget1.models.Expense;
import com.codingdojo.travelbudget1.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;
	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	// retrieves all the expenses
	public List<Expense> allExpenses() {
        return expenseRepository.findAll();
    }
    // creates an expense
    public Expense createExpense(Expense b) {
        return expenseRepository.save(b);
    }
    // retrieves an expense
    public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
    // edits an expense
	public Expense updateExpense(Expense b) {
		return expenseRepository.save(b);
	}
	// deletes an expense
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
}
