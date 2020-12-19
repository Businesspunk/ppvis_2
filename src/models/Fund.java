package models;

import java.sql.ResultSet;
import java.util.Vector;

public class Fund {

    private String name;
    private int cost;
    private int index;

    public Fund(int index, String name, int cost)
    {
        this.name = name;
        this.cost = cost;
        this.index = index;
    }

    public String getName()
    {
        return name;
    }

    public int getCost()
    {
        return cost;
    }

    public int getIndex()
    {
        return index;
    }

    public static Vector<Fund> getFunds()
    {
        ResultSet result = new DataBase().makeQuery("select * from funds");

        Vector<Fund> funds = new Vector<Fund>();

        try{
            while( result.next() ){
                funds.add( new Fund(result.getInt(1), result.getString(2), result.getInt(3)) );
            }
            return funds;
        }catch(Exception e){ System.out.println(e);}

        return null;
    }

    public static Fund getFund( int fund_id )
    {
        ResultSet result = new DataBase().makeQuery("select * from funds where `id`="+fund_id);

        try{
            result.next();

            return new Fund(result.getInt(1), result.getString(2), result.getInt(3));
        }catch(Exception e){ System.out.println(e);}

        return null;
    }

    public void increase()
    {

    }
}
