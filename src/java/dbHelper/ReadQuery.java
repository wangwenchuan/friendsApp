package dbHelper;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Friends;

public class ReadQuery {

    private Connection conn;
    private ResultSet results;

    public ReadQuery() {
        Properties props = new Properties();//MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void doRead(){
        try {
            String query = "Select * from friends order by friendID ASC";
            PreparedStatement ps = conn.prepareStatement(query);
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
  
    
    public String getHTMLtable(){
        String table="";
        table += "<table border=1>";
        
        try {
            while (this.results.next()){
                Friends friend =new Friends();
                friend.setFriendID(this.results.getInt("friendID"));
                friend.setFriendName(this.results.getString("friendName"));
                friend.setEmailAddr(this.results.getString("emailAddr"));
                friend.setAge(this.results.getInt("age"));
                friend.setFavoriteColor(this.results.getString("favoriteColor"));
                
                table +="<tr>";
                
                table +="<td>";
                table += friend.getFriendID();      
                table +="</td>";
                
                table +="<td>";
                table += friend.getFriendName();      
                table +="</td>";
                
                table +="<td>";
                table += friend.getEmailAddr();      
                table +="</td>";
                
                table +="<td>";
                table += friend.getAge();      
                table +="</td>";
                
                table +="<td>";
                table += friend.getFavoriteColor();      
                table +="</td>";
                
                table +="<td>";
                table += "<a href=update?friendID=" + friend.getFriendID()+ "> Update </a>" + "<a href=delete?friendID=" + friend.getFriendID()+ "> Delete </a>";
                table +="</td>";
               
                table +="</tr>";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReadQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table+="</table>";
        
        return table;
        
    }
    
}
