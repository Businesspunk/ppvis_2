package controllers;

import views.AddGoal;
import views.ReportView;

import java.time.LocalDateTime;

public class TargetController {

    protected ReportView ReportView;
    protected AddGoal AddGoal;

    public void getReport()
    {
        ReportView = new ReportView(this);
    }

    public void makeReport()
    {
        System.out.println("test");
    }

    public void getAddTarget()
    {
        AddGoal = new AddGoal(this);
    }
}
