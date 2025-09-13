package utils;

import models.Expense;

import java.util.List;

public class ExpenseUtils {
    public static boolean   areAllExpensesOfSameTrip(List<Expense> expenses) {
        if (expenses == null || expenses.isEmpty()) {
            return true; // or false, depending on your requirements
        }
        String tripId = expenses.get(0).getTripId();
        for (Expense expense : expenses) {
            if (!expense.getTripId().equals(tripId)) {
                return false;
            }
        }
        return true;
    }
}
