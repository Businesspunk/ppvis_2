package controllers;

import models.DataBase;
import models.Fund;
import models.Payment;
import views.*;

import javax.swing.*;

import java.sql.ResultSet;
import java.util.Vector;

public class FundController {

    public InsertSalesView InsertSalesView;
    protected IndexController indexController;
    protected WithdrawView WithdrawView;
    protected TransferView TransferView;

    public void setIndexController(IndexController indexController)
    {
        this.indexController = indexController;
    }

    public IndexController getFundController() {
        return indexController;
    }

    public void getInsertSales()
    {
        InsertSalesView = new InsertSalesView(this);
    }

    public void insert( int sum )
    {
        Payment payment = new Payment(sum, "input");
        insertSales(payment);
    }

    public void withdraw(int costAdded, Fund fund)
    {
        DataBase db = new DataBase();
        ResultSet result = db.makeQuery("SELECT * FROM `funds` WHERE `id`="+fund.getIndex());

        try{
            result.next();
            int cost = result.getInt(3) - costAdded;
            db.makeQueryUpdate("UPDATE `funds` SET `cost`="+cost+" WHERE `id`="+fund.getIndex());
            WithdrawView.close();
            successEnded();
        }catch(Exception e){ System.out.println(e);}
    }

    public void withdrawPayment( int cost, int fund_id )
    {
        Fund fund = Fund.getFund(fund_id);
        withdraw(cost, fund);
    }

    public void getWithdraw()
    {
        Vector<Fund> funds = Fund.getFunds();

        WithdrawView = new WithdrawView(this, funds);
    }

    protected void insertSales(Payment payment)
    {
        DataBase db = new DataBase();
        ResultSet result = db.makeQuery("SELECT * FROM `funds` WHERE `id`=1");

        try{
            result.next();
            int cost = result.getInt(3) + payment.getCost();
            db.makeQueryUpdate("UPDATE `funds` SET `cost`="+cost+" WHERE `id`=1");
            InsertSalesView.close();
            successEnded();
        }catch(Exception e){ System.out.println(e);}
    }

    public void getTransfer()
    {
        Vector<Fund> funds = Fund.getFunds();
        TransferView = new TransferView(this, funds);
    }

    public void makeTransfer( int sum, int from_id, int to_id )
    {
        Fund from = Fund.getFund(from_id);
        Fund to = Fund.getFund(to_id);

        transfer(sum, from, to);
    }

    public void transfer(int sum, Fund from, Fund to)
    {
        DataBase db = new DataBase();
        ResultSet result = db.makeQuery("SELECT * FROM `funds` WHERE `id`="+from.getIndex());

        try{
            result.next();
            int cost = result.getInt(3) - sum;
            db.makeQueryUpdate("UPDATE `funds` SET `cost`="+cost+" WHERE `id`="+from.getIndex());

            ResultSet result_update = db.makeQuery("SELECT * FROM `funds` WHERE `id`="+to.getIndex());
            result_update.next();
            cost = result_update.getInt(3) + sum;
            db.makeQueryUpdate("UPDATE `funds` SET `cost`="+cost+" WHERE `id`="+to.getIndex());

            TransferView.close();
            successEnded();
        }catch(Exception e){ System.out.println(e);}
    }

    public void successEnded()
    {
        indexController.reloadDashbord();
        JOptionPane.showMessageDialog(InsertSalesView, "Счет успешно обновлен");
    }
}
