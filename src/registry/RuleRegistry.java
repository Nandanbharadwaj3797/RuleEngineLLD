package registry;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.ExpenseType;
import rules.ExpenseRule;
import rules.impl.DisallowRule;
import rules.impl.MaxAmountRule;

public class RuleRegistry {
    public static void getExpenseRulesRegistry() {
        Map<ExpenseType, List<ExpenseRule>> registry = new HashMap<>();

        registry.put(ExpenseType.RESTAURANT, List.of(
                new MaxAmountRule(75)
        ) );

        registry.put(ExpenseType.AIRFARE, List.of(
                new DisallowRule()
        ) );

    }

    public static List<ExpenseRule> getAllExpenseRulesRegistry() {
        return List.of(
                new MaxAmountRule(200)
        );
    }
}


/*
 *
 *
 * represent the above rules like a json config
 * {
 *   "expenseLeveRules": [
 *     {
 *       "expenseType": "RESTAURANT",
 *       "rules": [
 *         {
 *           "type": "DISALLOW",
 *           "maxAmount": 75
 *         }
 *       ]
 *     }
 *   ],
 *   "allExpenseRules": [
 *     {
 *       "type": "MAX_AMOUNT",
 *       "maxAmount": 200
 *     }
 *   ]
 * }
 */