package services.rules;

import models.Expense;

import java.util.Optional;



public interface ExpenseRule {
    Optional<services.rules.Violation> check(Expense e);
}
