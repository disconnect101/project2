 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package musicplayer;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.sql.*;
import static musicplayer.musicGUI.songlist;


/**
 *
 * @author acer
 */
public class MusicPlayer {
  FileInputStream FIS;
  BufferedInputStream BIS;
  public Player player;
  public long pauseLocation;
   public long songTotalLength;
   public long songTotalLength1;
   public String fileLocation;
  public void Stop(){
      if(player!=null){
          player.close();
          pauseLocation=0;
          songTotalLength=0;
          musicGUI.Display.setText("");
          
          
      }
      
  }
  

  
  
  public void Pause(){
      if(player!=null){
           try {           
             pauseLocation = FIS.available();
               songTotalLength = songTotalLength1;
         
          player.close();
           } 
           catch (IOException ex) {
              
           }
          
      }
      
  }
    public void Resume(){
        try {
                     

            FIS = new FileInputStream(fileLocation);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
            FIS.skip(songTotalLength-pauseLocation);
        }catch (Exception e){
        System.out.println(e.getMessage());}
        new Thread(){
            @Override
            public void run(){
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                  
                }
            }
        }.start();
      
      
      
  }
    /**
     *
     * @param path
     */
    public void Play(String path){
        try {
            FIS = new FileInputStream(path);
            BIS = new BufferedInputStream(FIS);
            player = new Player(BIS);
          songTotalLength = FIS.available();
          songTotalLength1 = songTotalLength;
          fileLocation = path+"";
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        new Thread(){
            @Override
            public void run(){
                try {
                    
                    player.play();
                    if(player.isComplete()&&musicGUI.count==1){
                        Play(fileLocation);
                    }
                    if(player.isComplete())
                    {
                         musicGUI.Display.setText("");
                        
                    }
                } catch (JavaLayerException ex) {
                  
                }
            }
        }.start();
        
        
      
      
      
  }
                }

class MPdao {
    public void addsong(int i,String s) throws Exception
    {
        String url="jdbc:mysql://localhost:3306/abc";
        String username="root";
        String password="mysql!!";
        String query="insert into Mplayer values (" + i + ",'" + s + "',0)";
        query = query.replaceAll("\\\\","\\\\\\\\");
        System.out.println(query);
        
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        st.executeUpdate(query);
                
        st.close();
        con.close();        
    }
    
    public String retrieve(int i) throws Exception
    {
        String url="jdbc:mysql://localhost:3306/abc";
        String username="root";
        String password="mysql!!";
        String query="select fpath from Mplayer where idx="+i;
        String query1="SELECT COUNT(*) AS RowCnt FROM Mplayer";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        Statement st2 = con.createStatement();           
        ResultSet rs = st.executeQuery(query);
        ResultSet rs2 = st2.executeQuery(query1);
        
        rs.next();
        rs2.next();        
        
        if(rs2.getInt("RowCnt")==0)
        {
            return null;
        }
        
        String path = rs.getString("fpath");
        System.out.println(path);
                
        st.close();
        con.close();   
        
        return path;
    }
    
    public int count() throws Exception
    {
        String url="jdbc:mysql://localhost:3306/abc";
        String username="root";
        String password="mysql!!";
        
        String query1="SELECT COUNT(*) AS RowCnt FROM Mplayer";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        
        ResultSet rs2 = st.executeQuery(query1);
        
        
        rs2.next();
        
        int count = rs2.getInt("RowCnt");
        
                
        st.close();
        con.close();   
        
        return count;
    }
    
    int isFav(int i) throws Exception
    {
        String url="jdbc:mysql://localhost:3306/abc";
        String username="root";
        String password="mysql!!";
        
        String query1="select fav from Mplayer where idx="+i;
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,username,password);
        Statement st = con.createStatement();
        
        ResultSet rs2 = st.executeQuery(query1);
        
        
        rs2.next();
        
        int fav = rs2.getInt("fav");
        
                
        st.close();
        con.close();   
        
        return fav;
    }
    
   
}




   
   
