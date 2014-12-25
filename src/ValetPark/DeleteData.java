/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ValetPark;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Vaibhav
 */
public class DeleteData {
    PreparedStatement ps;
   
    public int Remove(String what)
    {
      
         int updated_row_count =0;
        try
        {
        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
         Connection con = DriverManager.getConnection("jdbc:odbc:valet");
         String del;   
        if(what.equals("All Out Vehicle"))
        {
        del = "Delete from valet.dbo.ValetInfo where Status = 'OUT'";
        
        }
        else if(what.equals("Out Past Days"))
        {
            String timeStamp = new SimpleDateFormat("dd/MM/YYYY").format(Calendar.getInstance().getTime());
            
            del = "Delete from valet.dbo.ValetInfo where Status = 'OUT' and Exit_Time NOT LIKE '"+timeStamp+"%'";
     
        }
        else
        {
        del = "Select * from valet.dbo.ValetInfo";
        
        }
        ps = con.prepareStatement(del);
        ps.execute();
        updated_row_count = ps.getUpdateCount(); 
       
        
        
        }
        catch(Exception ex)
        {
        System.out.println("Connection Not Established !! Unable to Delete");
        
        }
        
        return updated_row_count;
    }
    
    
    
}
