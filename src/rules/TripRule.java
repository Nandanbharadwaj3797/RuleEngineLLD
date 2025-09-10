package rules;


import java.util.List;
import java.util.Optional;

import models.Expense;

public interface TripRule {
    Optional<List<Violation>> check(List<Expense> expenses);
}