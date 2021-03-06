package com.assignment.business_layer.report;

import com.assignment.business_layer.entity.Groceries;
import com.assignment.business_layer.entity.Login;

import java.sql.Timestamp;

public class WeeklyReport implements Report {
    @Override
    public String computeReport(Login login) {
        int countPurchased = 0;
        int countExpired = 0;
        int countConsumed = 0;

        int caloriesConsumed = 0;
        int caloriesWasted = 0;

        Timestamp now = new Timestamp(System.currentTimeMillis());

        for (Groceries g : login.getGroceryLists()) {
            if (((now.getTime() - g.getPurchase_date().getTime()) / 86400000) <= 7) {
                countPurchased++;
            }
            if (g.getConsumption_date() != null) {
                if (((now.getTime() - g.getConsumption_date().getTime()) / 86400000) <= 7) {
                    countConsumed++;
                    caloriesConsumed += g.getCalories() * g.getQuantity();
                }
            }
            if (now.getTime() > g.getExpiration_date().getTime()) {
                if (((now.getTime() - g.getExpiration_date().getTime()) / 86400000) <= 7) {
                    countExpired++;
                    caloriesWasted += g.getCalories() * g.getQuantity();
                }
            }

        }

        String content = "User: " + login.getUsername() + "\n"
                + " Weekly report" + "\n"
                + " Goal: " + login.getGoal() + "\n"
                + " Number of groceries purchased in the last week: " + countPurchased + "\n"
                + " Number of groceries consumed in the last week: " + countConsumed + "\n"
                + " Number of groceries expired in the last week: " + countExpired + "\n"
                + " Number of calories consumed in the last week: " + caloriesConsumed + "\n"
                + " Number of calories wasted in the last week: " + caloriesWasted + "\n";

        return content;
    }

    ;
}
