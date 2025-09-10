package rules;

import models.Expense;

import java.util.Optional;



public interface ExpenseRule {
    Optional<Violation> check(Expense e);
}
