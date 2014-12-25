/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktopapplication1;

import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Vaibhav
 */
public class Amount {
    public static long  Money = 5,diffDays, diffHours, diffMinutes, diff,servicetax,cost,parktime;
  public int round;
    
  private Component frame;
  
  public long calc_amount(String dateStart, String dateStop, String Name, String Vehicle)
   {
   
   SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy_HH:mm");
    Date d1 = null;
    Date d2 = null;
    try {
			d1 = format.parse(dateStart);
			d2 = format.parse(dateStop);
 
                        diff = d2.getTime() - d1.getTime();
			diffMinutes = diff / (60 * 1000) % 60;
                        diffHours = diff / (60 * 60 * 1000) % 24;
			diffDays = diff / (24 * 60 * 60 * 1000);
 
			System.out.print(diffDays + " days, ");
			System.out.print(diffHours + " hours, ");
			System.out.print(diffMinutes + " minutes, ");
 
		} catch (Exception e) {
                    diffDays = 0;
                    diffHours=0;
                    diffMinutes=0;
			System.out.println(e);
		}
                parktime = diffDays*24+diffHours;
           Money = (diffDays*120)+(diffHours*5);
           if (diffMinutes>=30)
           {
           Money = Money+5;
           }
            
           if(Money==0)
           {
           Money=10;
           }
           cost = Money;
           servicetax = (Money*5)/100;
           System.out.println("\n"+servicetax);
           round = (int) servicetax;
           servicetax = (long) round;
           System.out.println("Rounded: "+servicetax);
           Money = Money+servicetax;
           
           JOptionPane.showMessageDialog(frame,
            "Name : "+Name+"\nVehicle No. : "+Vehicle+"\n------------------------------------\n-- VALET PARKING BILL GENERATED --\n------------------------------------\nTotal Time :\n Hours: "+parktime+"\nTotal Minutes: "+diffMinutes+"\n-----------------------------------\nParking Cost: "+cost+"\nService Tax (5%): "+servicetax+"\n----------------------------------\nTotal = "+Money+"",
            "Parking Bill",
            JOptionPane.INFORMATION_MESSAGE);
           
           System.out.println(Money); 
            return Money; 
   
   }
   
   
    
}
