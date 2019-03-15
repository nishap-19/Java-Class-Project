

//------------------------------------------------------------------------------------
//	Authors:		Joshua Lindberg, Ian Stacy, Jake Hollis, Jacob Waters
//	Program Name:	InfoFrontEnd
//------------------------------------------------------------------------------------

//Imports
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class InfoFrontEnd extends JPanel
{
	// Class level variables
	static ArrayList<String> arraySeat = new ArrayList<String>();
	
	static String fName	= "", lName = "", address = "", price = "", seats = "", credit = "", flightID;
	
	int	creditNumber = 00000000;
	
	static TextField textLabelFName, textLabelLName, textLabelAddress, 
	textLabelPrice, textLabelSeats, textLabelCredit, textLabelFlightID;
	
	static String submit = "Submit";
	
	static int resID = SeatButtonsFinal.resID;

	
	//Start of main program
	public InfoFrontEnd()
	{
		
		JPanel InfoPanel = new JPanel(new GridLayout(0, 1));
		
		JLabel label1 = new JLabel("First Name ");
		
		textLabelFName = new TextField(30);
		
		JLabel label2 = new JLabel("Last Name ");
		textLabelLName = new TextField(30);
		textLabelLName.setEditable(true);
		
		JLabel label3 = new JLabel("\nAddress");
		textLabelAddress = new TextField(30);
		textLabelAddress.setEditable(true);
		
		JLabel label4 = new JLabel("Price");
		// textLabelPrice = new TextField(seats, 30);
		textLabelPrice = new TextField(""
				+ WriteToFile.getPrice(SeatButtonsFinal.list), 10);
		textLabelPrice.setEditable(false);
		
		JLabel label5 = new JLabel("Seats");
		// textLabelSeats = new TextField("A1, A2, A3", 30);
		textLabelSeats = new TextField(seatsChosen().toString(), 30);
		textLabelSeats.setEditable(false);
		
		JComponent submission = createButtonPanel();
		
		JLabel label6 = new JLabel("Credit Card Number:");
		textLabelCredit = new TextField(20);
		textLabelCredit.setEditable(true);
		
		JLabel label7 = new JLabel("ID Number:");
		// textLabelFlightID = new TextField(20);
		textLabelFlightID = new TextField("" + resID, 20);
		textLabelFlightID.setEditable(false);
		
		seatsEqual();
		// Printing labels and text fields
		// Construction of applet
		InfoPanel.add(label1);
		InfoPanel.add(textLabelFName);
		InfoPanel.add(label2);
		InfoPanel.add(textLabelLName);
		InfoPanel.add(label3);
		InfoPanel.add(textLabelAddress);
		InfoPanel.add(label4);
		InfoPanel.add(textLabelPrice);
		InfoPanel.add(label5);
		InfoPanel.add(textLabelSeats);
		InfoPanel.add(label6);
		InfoPanel.add(textLabelCredit);
		InfoPanel.add(label7);
		InfoPanel.add(textLabelFlightID);
		
		InfoPanel.add(submission);
		add(InfoPanel, BorderLayout.LINE_START);
		setBorder(BorderFactory.createEmptyBorder(50, 50, 30, 30));
	}
	
	//Changes an applet to a Jframe.
	
	private static void createAndShowInfo()
	{
		// Create and set up the window.
		JFrame info = new JFrame("Passenger Info");
		
		info.addWindowListener(new java.awt.event.WindowAdapter()
		{
			public void windowClosing(java.awt.event.WindowEvent e)
			{
				SeatButtonsFinal.sfile.delete();
				System.exit(0);
			}
		});
		// Create and set up the content pane.
		JComponent myFrontEnd = new InfoFrontEnd();
		myFrontEnd.setOpaque(true);
		// content panes must be opaque
		info.setContentPane(myFrontEnd);
		
		// Display the window.
		info.pack();
		info.setVisible(true);
	}
	
	// Saves user input as variables and saves to file 
	// by calling method from reservation.
	public void actionSaveInfo()
	{
		fName = textLabelFName.getText();
		lName = textLabelLName.getText();
		address = textLabelAddress.getText();
		price = textLabelPrice.getText();
		seats = textLabelSeats.getText();
		credit = textLabelCredit.getText();
		Reservation custReservation = new Reservation(fName, lName, address,
				Integer.parseInt(credit), arraySeat, Double.parseDouble(price),
				SeatButtonsFinal.resID);
		custReservation.saveReservation();
	}
	
	// Creates a Submit Button from saving action.
	private JComponent createButtonPanel()
	{
		JPanel pan = new JPanel(new GridLayout(1, 0));
		JButton submitButton = new JButton("Submit");
		submitButton.setBackground(Color.red);
		submitButton.setForeground(Color.white);
		submitButton.addActionListener(new Saving());
		pan.add(submitButton);
		return pan;
	}
	
	// Converts the string array from reservations to a string.
	public void seatsEqual()
	{
		for (int index = 0; index < arraySeat.size(); index++)
		{
			seats += arraySeat.get(index);
		}
	}
	
	// runs the save info method
	public class Saving implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			actionSaveInfo();
			System.exit(0);
		}
	}
	
	//Getters for the program
	public ArrayList<String> getSeats()
	{
		return arraySeat;
	}
	
	public String getFName()
	{
		return fName;
	}
	
	public String getLName()
	{
		return lName;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public int getCardNumber()
	{
		return creditNumber;
	}
	
	//Links Front Ends
	public static void toInfo()
	{
		createAndShowInfo();
	}
	
	//Reads seats from file.
	public static ArrayList<String> seatsChosen()
	{
		// #############################################
		// Grab existing reserved seats
		// #############################################
		ArrayList<String> seats_taken2 = new ArrayList<String>();
		File folder = new File(System.getProperty("user.dir")
				+ "/Reservations/");
		
		if (folder.exists())
		{
			// Loop through the different file
			String s = "";
			
			File file = new File(System.getProperty("user.dir")
					+ "/Reservations/" + resID + ".txt");
			s += " ";
			if (file.exists())
			{
				try
				{
					Scanner input = new Scanner(System.in);
					
					input = new Scanner(file);
					input.useDelimiter("]");
					
					while (input.hasNextLine())
					{
						s += input.next();
						break;
					}
					input.close();
					
				}
				catch (Exception ex)
				{
					ex.printStackTrace();
				}
			}
			s = s.replace("[", "");
			s = s.replace(",", "");
			Scanner scan = new Scanner(s);
			
			while (scan.hasNext())
			{
				seats_taken2.add(scan.next());
			}
			
		}
		return seats_taken2;
	}
}