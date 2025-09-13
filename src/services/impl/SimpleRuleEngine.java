package services.impl;

import models.Expense;
import models.ExpenseType;
import services.RuleEngine;
import services.rules.ExpenseRule;
import services.rules.TripRule;
import services.rules.Violation;


import java.util.*;
import java.util.stream.Collectors;

public class SimpleRuleEngine implements RuleEngine {

    @Override
    public List<Violation> evaluate(
            List<Expense> expenses,
            Map<ExpenseType, List<ExpenseRule>> expenseRulesRegistry,
            List<ExpenseRule> allExpenseRulesRegistry,
            List<TripRule> tripRulesRegistry
    ) {
        Set<Violation> violationsResult = new HashSet<>();

        // 1. Check each expense against both type-specific rules and global rules
        for (Expense expense : expenses) {
            List<ExpenseRule> typeSpecificRules =
                    expenseRulesRegistry.getOrDefault(expense.getExpenseType(), List.of());

            checkExpenseAgainstRules(expense, typeSpecificRules, violationsResult);
            checkExpenseAgainstRules(expense, allExpenseRulesRegistry, violationsResult);
        }

        // 2. Check all expenses against trip rules
        tripRulesRegistry.stream()
                .map(rule -> rule.check(expenses))
                .flatMap(Optional::stream)
                .forEach(violationsResult::add);

        // Return as List (preserve deterministic order if needed)
        return violationsResult.stream().collect(Collectors.toList());
    }

    private void checkExpenseAgainstRules(
            Expense expense,
            List<ExpenseRule> rules,
            Set<Violation> violationsResult
    ) {
        rules.stream()
                .map(rule -> rule.check(expense))
                .flatMap(Optional::stream)
                .forEach(violationsResult::add);
    }
}


/*
*
package services.impl;

import models.Expense;
import models.ExpenseType;
import services.RuleEngine;
import services.rules.ExpenseRule;
import services.rules.TripRule;
import services.rules.Violation;


import java.util.*;
import java.util.stream.Collectors;

public class SimpleRuleEngine implements RuleEngine {

    @Override
    public List<Violation> evaluate(
            List<Expense> expenses,
            Map<ExpenseType, List<ExpenseRule>> expenseRulesRegistry,
            List<ExpenseRule> allExpenseRulesRegistry,
            List<TripRule> tripRulesRegistry
    ) {
        Set<Violation> violationsResult = new HashSet<>();

        // 1. Check each expense against both type-specific rules and global rules
        for (Expense expense : expenses) {
            List<ExpenseRule> typeSpecificRules =
                    expenseRulesRegistry.getOrDefault(expense.getExpenseType(), List.of());

            checkExpenseAgainstRules(expense, typeSpecificRules, violationsResult);
            checkExpenseAgainstRules(expense, allExpenseRulesRegistry, violationsResult);
        }

        // 2. Check all expenses against trip rules
        tripRulesRegistry.stream()
                .map(rule -> rule.check(expenses))
                .flatMap(Optional::stream)
                .forEach(violationsResult::add);

        // Return as list (preserve deterministic order if needed)
        return violationsResult.stream().collect(Collectors.toList());
    }

    private void checkExpenseAgainstRules(
            Expense expense,
            List<ExpenseRule> rules,
            Set<Violation> violationsResult
    ) {
        rules.stream()
                .map(rule -> rule.check(expense))
                .flatMap(Optional::stream)
                .forEach(violationsResult::add);
    }
}

* */
