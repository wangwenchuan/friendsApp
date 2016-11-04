/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Wenchuan
 */
public class ReadRecord {
    
    private Connection conn;
    
     private ResultSet results;
    
    private Friends friend = new Friends();
    private int friendID;
    
    public ReadRecord(int friendID){
        try{
         Properties props = new Properties();//MWC
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }

        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        this.friendID=friendID;
        
        Class.forName(driver); 
        conn = DriverManager.getConnection(url, username, passwd);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
    
    public void doRead(){
        try {
            //set up a string to hold our query
            String query=" select * from friends where friendID = ? ";
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            //fill in the preparedstatement
            ps.setInt(1, friendID);
            //excute the query
            this.results=ps.executeQuery();
            
            this.results.next();
            
            friend.setFriendID(this.results.getInt("friendID"));
            friend.setFriendName(this.results.getString("friendName"));
            friend.setEmailAddr(this.results.getString("emailAddr"));
            friend.setAge(this.results.getInt("age"));
            friend.setFavoriteColor(this.results.getString("favoriteColor"));
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
     }
    public Friends getFriend(){
        
        return this.friend;
    }
    
}
