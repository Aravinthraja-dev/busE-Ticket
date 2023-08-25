package eticket;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class ValidStop extends BusTicket{
	
	Scanner sc = new Scanner(System.in);
	int tickets = 1;
	private Connection con;
	
    public ValidStop(){
        try
        {
             this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void selectA(){
        try {
            String q = "select route_A from bus";
            PreparedStatement pst = con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            while (rs.next()==true)
            {
                String a = rs.getString("route_A");
                System.out.println(a);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void selectB(){
    	try {
    		String q = "select route_B from bus";
    		PreparedStatement pst = con.prepareStatement(q);
    		ResultSet rs = pst.executeQuery();
    		while (rs.next()==true)
    		{
    			String a = rs.getString("route_B");
    			System.out.println(a);
    		}
            }
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	}
    }
    public void selectC(){
    	try {
    		String q = "select route_C from bus";
    		PreparedStatement pst = con.prepareStatement(q);
    		ResultSet rs = pst.executeQuery();
    		while (rs.next()==true)
    		{
    			String a = rs.getString("route_C");
    			System.out.println(a);
    		}
    	}
    	catch (SQLException e)
    	{
    		e.printStackTrace();
    	}
    }

    public boolean vaildInput_A(String stop){
        try 
        {
        	String q = "select route_A from bus";
            PreparedStatement pst = con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            int count=0;
            while (rs.next()==true)
            {
                String a = rs.getString("route_A");
                if(stop.equalsIgnoreCase(a)) {
                	count++;
                }
                
            }
            if(count==1)
            {
            	System.out.print("Enter total number of Tickets: ");
                tickets = sc.nextInt();
            	System.out.println("\n\tTamilnadu State Transport Corporation - Salem Region");
            	return true;
            }
            else 
            {
            	System.out.println("You enter wrong route\nEnter the route in the list");
            }
            
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean vaildInput_B(String stop){
        try {
            String q = "select route_B from bus";
            PreparedStatement pst = con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while (rs.next()==true)
            {
                String a = rs.getString("route_B");
                if(stop.equalsIgnoreCase(a)) {
                	count++;
                }
            }
            if(count==1)
            {
            	System.out.print("Enter total number of Tickets: ");
                tickets = sc.nextInt();
                System.out.println("\n\tTamilnadu State Transport Corporation - Salem Region");
                return true;
            }
            else {
            	System.out.println("You enter wrong route\nEnter the route in the list");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean vaildInput_C(String stop){
        try {
            String q = "select route_C from bus";
            PreparedStatement pst = con.prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            int count = 0;
            while (rs.next()==true)
            {
                String a = rs.getString("route_C");
                if(stop.equalsIgnoreCase(a)) {
                	count++;
                }
                
            }
            if(count==1)
            {
            	System.out.print("Enter total number of Tickets: ");
                tickets = sc.nextInt();
                System.out.println("\n\tTamilnadu State Transport Corporation - Salem Region");  
                return true;
            }
            else {
            	System.out.println("You enter wrong route\nEnter the route in the list");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public void busFare(int id)
	{
		String q = "select fromAndTo_route,routeFare from busFare where route_ID = ?";
		try {
			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()==true)
			{
				String a = rs.getString("fromAndTo_route");
				int b = rs.getInt("routeFare");
				System.out.println("Journey: "+a+" "+"\t\t\tRs: "+b*tickets);
				System.out.println("AD: "+tickets);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
    public void busFareB(int id)
	{
		String q = "select fromAndTo_route,routeFare from busFare_B where route_ID = ?";
		try {
			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()==true)
			{
				String a = rs.getString("fromAndTo_route");
				int b = rs.getInt("routeFare");
				System.out.println("Journey: "+a+" "+"\t\t\tRs: "+b*tickets);
				System.out.println("AD: "+tickets);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
    public void busFareC(int id)
	{
		String q = "select fromAndTo_route,routeFare from busFare_C where route_ID = ?";
		try {
			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()==true)
			{
				String a = rs.getString("fromAndTo_route");
				int b = rs.getInt("routeFare");
				System.out.println("Journey: "+a+" "+"\t\t\tRs: "+b*tickets);
				System.out.println("AD: "+tickets);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
    public String currentTime() 
    {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/mm/dd HH:mm:ss");
    	LocalDateTime now = LocalDateTime.now();
    	String dt = dtf.format(now);
    	return dt;
    }
    public int randomNumber()
    {
    	Random rand = new Random();
    	int randNum =1;
    	for(int i=1;i<=1;i++) {
    		randNum = rand.nextInt((1000-999)+250)+10000;
    	}
    	return randNum;
    }
   
}