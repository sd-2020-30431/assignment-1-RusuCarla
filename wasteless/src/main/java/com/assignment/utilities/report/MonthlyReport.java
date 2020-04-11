package com.assignment.utilities.report;

import com.assignment.entity.Login;

public class MonthlyReport implements Report{
    @Override
    public String computeReport(Login login){
        String content = "User: "+login.getUsername()+"/n"
                +"Monthly report"+"/n"
                +"Goal: "+login.getGoal();

        return content;
    };
}
