package services;



import models.Expense;
import models.ExpenseType;
import services.rules.ExpenseRule;
import services.rules.TripRule;
import services.rules.Violation;

import java.util.List;
import java.util.Map;



public interface RuleEngine {

    List<Violation> evaluate(
            List<Expense> expenses, // incoming expenses
            Map<ExpenseType, List<ExpenseRule>> expenseRulesRegistry, // expense rules registry
            List<ExpenseRule> allExpenseRulesRegistry, // all expense rules registry
            List<TripRule> tripRulesRegistry // trip rules registry
    );

}
