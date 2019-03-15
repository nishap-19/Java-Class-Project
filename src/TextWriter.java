
import java.io.*;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TextWriter 
{
	public static void write(File file,String text,boolean x)
	{
		//###################################
		//Write to a file
		//###################################
		if (x == false)
		{
			try{
			    PrintWriter writer = new PrintWriter(new FileWriter(file,true));
			    writer.append(text);
			    writer.close();
			} catch (IOException e) 
			{}
		}
		else if (x == true)
		{
			file.delete();
			try{
			    PrintWriter writer = new PrintWriter(new FileWriter(file,true));
			    writer.write(text);
			    writer.close();
			} catch (IOException e) 
			{}
		}
		//###################################
	}
	//###################################
	//Not Working
	//###################################
	public static void writeToLine(File file, String text, int line)
	{
		//Init Values
		int line2 = 0;
        String before_text = "";
        String after_text = "";
		//Read from a file
		//Grab all the lines before the specified line
		//########################################################################
		try 
		{
            Scanner input = new Scanner(System.in);
            input = new Scanner(file);            
            
            //Read from file before the specific line
            //##############################################
            while (input.hasNextLine()) 
            {
            	line2 ++;
            	if (line2 < line)
            	{
            		before_text += input.next() + "\n";//Grab all the text before the line
            	}
            	else if (line2 == line)
            	{
            		line2++;
            		input.nextLine();
            	}
            	else if (line2 > line)
            	{
            		after_text += input.next() + "\n";//Grab all the text after the line
            	}
            }
            //##############################################
            input.close();
        } catch (Exception ex) 
		{
            ex.printStackTrace();
		}
		//########################################################################
		//Write to a file
		//###################################
		try{
			PrintWriter writer = new PrintWriter(file);
			writer.write(before_text);
			writer.write(text);
			writer.write(after_text);
			writer.close();
		} catch (IOException e) 
		{}
		//###################################
	}
}
