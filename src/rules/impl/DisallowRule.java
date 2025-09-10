package rules.impl;


import java.util.Optional;

import models.Expense;
import rules.ExpenseRule;
import rules.Violation;

public class DisallowRule implements ExpenseRule {

    @Override
    public Optional<Violation> check(Expense e) {
        return Optional.of(Violation.of("Expense type " + e.getExpenseType() + " is not allowed"));
    }
}
