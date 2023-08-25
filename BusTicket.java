package eticket;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Map.Entry;

public class BusTicket {

	public static void main(String[] args) {
		ValidStop vs = new ValidStop();
        Scanner sc = new Scanner(System.in);
        int ch = 0;
        try {
	        do
	        {
	            System.out.println("---------Welcome to Tamilnadu State Transport Corporation - Salem Region----------");
	            System.out.println("Please select your route");
	            System.out.println("1.Harur to Salem via Valasaiyur");
	            System.out.println("2.Harur to Salem via Dharmapuri");
	            System.out.println("3.Harur to Salem via Bommidi");
	            System.out.println("0.Exit");
	            System.out.print("Select your route: ");
	            ch = sc.nextInt();
	            sc.nextLine();
	            if(ch==0)
	            {
	                System.out.println("Thank You");
	                break;
	            }
	            switch (ch)
	            {
	                case 1:
	                	HashMap<Integer,String> rt = new HashMap<>();
	            		rt.put(141, "Gobinathampatti");
	            		rt.put(142, "Pappireddipatti");
	            		rt.put(143, "Achanguttapattipudur");
	            		rt.put(144, "Kunuporam");
	            		rt.put(145, "Valasaiyr");
	            		rt.put(146, "Ammapet");
	            		rt.put(147, "Salem");
	                    System.out.println("Please select the station");
	                    vs.selectA();
	                    System.out.print("Please enter your Destination: ");
	                    String stop_A = sc.nextLine();
	                    if(vs.vaildInput_A(stop_A)==true)
	                    {
		                    System.out.println("Time: "+vs.currentTime()+"\t\t\tID: "+vs.randomNumber());
		                    for(Entry<Integer, String> entry:rt.entrySet()) {
		            			if(entry.getValue().equalsIgnoreCase(stop_A)) {
		            				vs.busFare(entry.getKey());
		            				break;
		            			}
		            		}
		                    System.out.println("\t\t\tHappy Journey");
		                    System.out.println("\t\t-------Valid for 2 hours-------- ");
	                    }
	                    break;
	                case 2:
	                	HashMap<Integer,String> rw = new HashMap<>();
	                	rw.put(121, "Morappur");
	            		rw.put(122, "Odasalpatti");
	            		rw.put(123, "Dharmapuri");
	            		rw.put(124, "Nallampalli");
	            		rw.put(125, "Thoppur");
	            		rw.put(126, "Deevattipatti");
	            		rw.put(127, "Omalur");
	            		rw.put(128, "Salem");
	                    System.out.println("Please select the station");
	                    vs.selectB();
	                    System.out.print("Please enter your Destination: ");
	                    String stop_B = sc.nextLine();
	                    if(vs.vaildInput_B(stop_B)==true)
	                    {
		                    System.out.println("Time: "+vs.currentTime()+"\t\t\tID: "+vs.randomNumber());
		                    for(Entry<Integer, String> entry:rw.entrySet()) {
		            			if(entry.getValue().equalsIgnoreCase(stop_B)) {
		            				vs.busFareB(entry.getKey());
		            				break;
		            			}
		            		}
		                    System.out.println("\t\t\tHappy Journey");
		                    System.out.println("\t\t-------Valid for 2 hours-------- ");
	                    }
	                    break;
	                case 3:
	                	HashMap<Integer,String> rv = new HashMap<>();
	                	rv.put(151, "Morappur");
	            		rv.put(152, "Kambainallur");
	            		rv.put(153, "Kadathur");
	            		rv.put(154, "Bommidi");
	            		rv.put(155, "Deevattipatti");
	            		rv.put(156, "Omalur");
	            		rv.put(157, "Salem");
	                    System.out.println("Please select the station");
	                    vs.selectC();
	                    System.out.print("Please enter your Destination: ");
	                    String stop_C = sc.nextLine();
	                    if(vs.vaildInput_C(stop_C)==true) 
	                    {
		                    System.out.println("Time: "+vs.currentTime()+"\t\t\tID: "+vs.randomNumber());
		                    for(Entry<Integer, String> entry:rv.entrySet()) {
		            			if(entry.getValue().equalsIgnoreCase(stop_C)) {
		            				vs.busFareC(entry.getKey());
		            				break;
		            			}
		            		}
		                    System.out.println("\t\t\tHappy Journey");
		                    System.out.println("\t\t-------Valid for 2 hours-------- ");
	                    }
	                    break;
	                default:
	                    System.out.println("Enter Invalid Choice");
	            }
	            System.out.println("-------------------------------------------------------------------------------");
	        }while (true);
	        }
        catch(InputMismatchException e)
        {
        	System.out.println("Enter the correct option");
        }
        sc.close();

	}

}
