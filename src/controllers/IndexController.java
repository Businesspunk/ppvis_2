package controllers;
import views.*;
import models.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.*;
import java.util.*;

public class IndexController {

    protected FundController fundController;
    protected TargetController TargetController;
    protected DashbordView frame;

    IndexController(FundController fundController, TargetController TargetController)
    {
        this.fundController = fundController;
        this.TargetController = TargetController;
    }

    public void getMainDashbord()
    {
        frame = new DashbordView(Fund.getFunds(), this);
    }

    public void reloadDashbord(){
        frame.dispose();
        getMainDashbord();
    }

    public FundController getFundController()
    {
        return fundController;
    }

    public TargetController getTargetController() {
        return TargetController;
    }
}

