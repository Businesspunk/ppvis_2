package models;

import java.sql.*;

public class DataBase {

    protected Connection connection;
    protected String username = "root";
    protected String password = "root";
    protected String table = "budget-management-system";

    public DataBase()
    {
        try{
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/"+table,username,password);
        }catch(Exception e){ System.out.println(e);}
    }

    public ResultSet makeQuery(String query)
    {
        try{
            Statement stmt = connection.createStatement();
            return stmt.executeQuery(query);

        }catch(Exception e){ System.out.println(e);}

        return null;
    }

    public int makeQueryUpdate(String query)
    {
        try{
            Statement stmt = connection.createStatement();
            return stmt.executeUpdate(query);

        }catch(Exception e){ System.out.println(e);}

        return 0;
    }

}
