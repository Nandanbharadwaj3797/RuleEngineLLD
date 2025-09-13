package services.rules.impl;


import models.Expense;

import services.rules.TripRule;
import services.rules.Violation;
import utils.ExpenseUtils;

import java.util.List;
import java.util.Optional;


public class TripTotalMaxRule implements TripRule {
    private final double maxAmount;

    // constructor
    public TripTotalMaxRule(double maxAmount) {
        this.maxAmount = maxAmount;
    }

    @Override
    public Optional<Violation> check(List<Expense> expenses) {
        if(!ExpenseUtils.areAllExpensesOfSameTrip(expenses)) {
            return Optional.of(Violation.of("Expenses are not of the same trip"));
        }
        double total = 0;
        for(Expense expense : expenses) {
            total += expense.getAmountUsd();
        }
        if(total > maxAmount) {
            return Optional.of(Violation.of("Trip total exceeds the maximum amount"));
        }

        return Optional.empty();
    }
}