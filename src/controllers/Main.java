package controllers;

public class Main {

    public static void main(String[] args) {

        FundController FundController = new FundController();
        TargetController TargetController = new TargetController();

        IndexController IndexController = new IndexController(FundController, TargetController);

        FundController.setIndexController(IndexController);

        IndexController.getMainDashbord();
    }
}
