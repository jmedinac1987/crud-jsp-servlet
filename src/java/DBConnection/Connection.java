/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBConnection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author jmedinac
 */
public class Connection {
    
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/usuario_jsp";
    private static String userName="root";
    private static String password="jorge";
    
    protected java.sql.Connection connect;
    protected PreparedStatement prepareStatement;
    protected ResultSet resulset;

    public Connection() 
    {
        connect();
    }
    
    private void connect()
    {
        try 
        {
            Class.forName(this.driver);
            this.connect = DriverManager.getConnection(this.url,this.userName, this.password);
        } 
        catch (ClassNotFoundException e) 
        {
            System.out.println(" Mysql jdbc driver - Exception: " + e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
    }
    
    protected void closeConnection()
    {
        if (this.connect != null)
        {
            try
            {
                this.connect.close();
            } 
            catch (Exception e) 
            {
                System.out.println("Exception: " + e.getMessage());
            }
       
        }
        
        if (this.prepareStatement != null)
        {
            try
            {
                this.prepareStatement.close();
            } 
            catch (Exception e) 
            {
                System.out.println("Exception: " + e.getMessage());
            }
        }
        
        if (this.resulset != null)
        {
            try
            {
                this.resulset.close();
            } 
            catch (Exception e) 
            {
                System.out.println("Exception: " + e.getMessage());
            }                        
        }
    }
    
}
