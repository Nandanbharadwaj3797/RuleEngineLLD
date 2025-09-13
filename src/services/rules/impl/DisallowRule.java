package services.rules.impl;


import models.Expense;
import services.rules.ExpenseRule;
import services.rules.Violation;

import java.util.Optional;



public class DisallowRule implements ExpenseRule {

    @Override
    public Optional<Violation> check(Expense e) {
        return Optional.of(Violation.of("Expense type " + e.getExpenseType() + "id:" + e.getExpenseId() + " is not allowed"));
    }
}
