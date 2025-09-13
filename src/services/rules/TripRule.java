package services.rules;
import models.Expense;

import java.util.List;
import java.util.Optional;



public interface TripRule {
    Optional<Violation> check(List<Expense> expenses);
}