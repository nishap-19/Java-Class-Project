

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class WriteToFile 
{
	public static void writeSeatsTaken(String resID, ArrayList list, int total_price)
	{
		File folder = new File(System.getProperty("user.dir") + "/Reservations/");
		folder.mkdir();
		File file = new File(System.getProperty("user.dir") + "/Reservations/" + resID + ".txt");
		if (file.exists())
			file.delete();
		
		try
		{
		    PrintWriter writer = new PrintWriter(new FileWriter(file,true));
		    writer.append(String.valueOf(list) + "\tSeats Booked");
		    writer.append("\r\n");
		    writer.append(String.valueOf(total_price) + "\tReservation Price");
		    writer.close();
		    
		} catch (IOException e) 
		{}
	}
	public static ArrayList <String> grabAllResID()
	{
		File folder = new File(System.getProperty("user.dir") + "/Reservations/");
		File[] listOfFiles = folder.listFiles();
		ArrayList list = new ArrayList();
		
		if (listOfFiles != null)
		{
		    for (int i = 0; i < listOfFiles.length; i++) 
		    {
		      if (listOfFiles[i].isFile()) 
		      {
		        list.add(listOfFiles[i].getName().substring(0,listOfFiles[i].getName().length()-4));
		      }
		      else if (listOfFiles[i].isDirectory()) {
		        System.out.println(listOfFiles[i].getName());
		      }
		    }
		}
		return list;
	}
	public static int getPrice(ArrayList <String> list)
	{
		int total_price = 0;
		
		for (int i = 0; i < list.size(); i++)
		{
			if(list.size() > 0)
			{
				if (list.get(i).substring(1,2).equals("8") || list.get(i).substring(1,2).equals("9") || (list.get(i).length()>2&&(list.get(i).substring(1,3).equals("10") || list.get(i).substring(1,3).equals("11")|| list.get(i).substring(1,3).equals("12")|| list.get(i).substring(1,3).equals("13"))))
					{
						System.out.println(list.get(i).substring(1,2));
						total_price += 250;
					}
				else if (list.get(i).substring(1,2).equals("1") || list.get(i).substring(1,2).equals("2"))
					{
						System.out.println(list.get(i).substring(1,2));
						total_price += 507;
					}
				
				else if (list.get(i).substring(1,2).equals("3") || list.get(i).substring(1,2).equals("4") || list.get(i).substring(1,2).equals("5") || list.get(i).substring(1,2).equals("6")|| list.get(i).substring(1,2).equals("7"))
					{
						System.out.println(list.get(i).substring(1,2));
						total_price += 420;
					}
				
				
			}
		}
		return total_price;
	}

}
	

