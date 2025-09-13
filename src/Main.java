import models.Expense;
import models.ExpenseType;
import services.impl.SimpleRuleEngine;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {


        List<Expense> expenses = new ArrayList<>();

        expenses.add(new Expense("1", "1", 10.0, ExpenseType.RESTAURANT));
        expenses.add(new Expense("2", "1", 50.0, ExpenseType.RESTAURANT));
        expenses.add(new Expense("3", "1", 100.0, ExpenseType.RESTAURANT));

        RuleManagerRunner ruleManagerRunner = new RuleManagerRunner(new SimpleRuleEngine());

        ruleManagerRunner.run(expenses);
    }
}