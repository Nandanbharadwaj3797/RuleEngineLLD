
import models.Expense;
import models.ExpenseType;
import registry.RuleRegistry;
import services.RuleEngine;
import services.rules.ExpenseRule;
import services.rules.TripRule;
import services.rules.Violation;

import java.util.List;
import java.util.Map;



public class RuleManagerRunner {

    private final RuleEngine ruleEngine;

    public RuleManagerRunner(RuleEngine ruleEngine) {
        this.ruleEngine = ruleEngine;
    }

    public void run(List<Expense> expenses) {
        Map<ExpenseType, List<ExpenseRule>> expenseRulesRegistry = RuleRegistry.getExpenseRulesRegistry();
        List<ExpenseRule> allExpenseRulesRegistry = RuleRegistry.getAllExpenseRulesRegistry();
        List<TripRule> tripRulesRegistry = RuleRegistry.getAllTripRulesRegistry();

        List<Violation> violations = ruleEngine.evaluate(expenses, expenseRulesRegistry, allExpenseRulesRegistry, tripRulesRegistry);

        for(Violation violation : violations) {
            System.out.println(violation.getMessage());
        }
    }
}