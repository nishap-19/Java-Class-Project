

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.*;

public class SeatButtonsFinal extends JPanel 
	{
			//Array List to store seats
			static ArrayList <String> list = new ArrayList <String>();
			
			//Total Price of the seats
			static int total_price = 0;
			
			static WriteToFile write = new WriteToFile();
			
			static Random rng = new Random();
			static int resID = rng.nextInt(90000) + 10000;
			static ArrayList <String> unavailableSeats;
			static File sfile = new File (System.getProperty("user.dir") + "/Reservations/" + resID + ".txt");
			
			public static void ReadSeats1()
			{
				//#############################################
				//Grab existing reserved seats
				//#############################################
				ArrayList <String> seats_taken = write.grabAllResID();
				ArrayList <String> seats_taken2 = new ArrayList <String> ();
				File folder = new File(System.getProperty("user.dir") + "/Reservations/");
				
				if (folder.exists())
				{
					//Loop through the different file 
					String s = "";
					for (int x = 0; x < seats_taken.size(); x++)
					{
						
						File file = new File(System.getProperty("user.dir") + "/Reservations/" + seats_taken.get(x) + ".txt");
						s+= " ";
						if (file.exists())
						{
							try {
					            Scanner input = new Scanner(System.in); 

					            input = new Scanner(file);
					            input.useDelimiter("]");

					            while (input.hasNextLine()) 
					            {	
					            	s += input.next();
					            	break;
					            }
					            input.close();

					        } catch (Exception ex) {
					            ex.printStackTrace();
					        }
						}
						
					}
					s = s.replace("[", "");
					s = s.replace(",", "");
					Scanner scan = new Scanner (s);
					
					while(scan.hasNext())
					{
						seats_taken2.add(scan.next());
					}
					
				}	
				//#############################################
				unavailableSeats = seats_taken2;
			}
		
		//creates each seat as a JRadioButton	
		static JRadioButton A1 = new JRadioButton(), B1 = new JRadioButton(),
				C1 = new JRadioButton(), D1 = new JRadioButton(),
				E1 = new JRadioButton(), F1 = new JRadioButton();

		static JRadioButton A2 = new JRadioButton(), B2 = new JRadioButton(),
				C2 = new JRadioButton(), D2 = new JRadioButton(),
				E2 = new JRadioButton(), F2 = new JRadioButton();

		static JRadioButton A3 = new JRadioButton(), B3 = new JRadioButton(),
				C3 = new JRadioButton(), D3 = new JRadioButton(),
				E3 = new JRadioButton(), F3 = new JRadioButton();

		static JRadioButton A4 = new JRadioButton(), B4 = new JRadioButton(),
				C4 = new JRadioButton(), D4 = new JRadioButton(),
				E4 = new JRadioButton(), F4 = new JRadioButton();

		static JRadioButton A5 = new JRadioButton(), B5 = new JRadioButton(),
				C5 = new JRadioButton(), D5 = new JRadioButton(),
				E5 = new JRadioButton(), F5 = new JRadioButton();

		static JRadioButton A6 = new JRadioButton(), B6 = new JRadioButton(),
				C6 = new JRadioButton(), D6 = new JRadioButton(),
				E6 = new JRadioButton(), F6 = new JRadioButton();

		static JRadioButton A7 = new JRadioButton(), B7 = new JRadioButton(),
				C7 = new JRadioButton(), D7 = new JRadioButton(),
				E7 = new JRadioButton(), F7 = new JRadioButton();

		static JRadioButton A8 = new JRadioButton(), B8 = new JRadioButton(),
				C8 = new JRadioButton(), D8 = new JRadioButton(),
				E8 = new JRadioButton(), F8 = new JRadioButton();

		static JRadioButton A9 = new JRadioButton(), B9 = new JRadioButton(),
				C9 = new JRadioButton(), D9 = new JRadioButton(),
				E9 = new JRadioButton(), F9 = new JRadioButton();

		static JRadioButton A10 = new JRadioButton(), B10 = new JRadioButton(),
				C10 = new JRadioButton(), D10 = new JRadioButton(),
				E10 = new JRadioButton(), F10 = new JRadioButton();

		static JRadioButton A11 = new JRadioButton(), B11 = new JRadioButton(),
				C11 = new JRadioButton(), D11 = new JRadioButton(),
				E11 = new JRadioButton(), F11 = new JRadioButton();

		static JRadioButton A12 = new JRadioButton(), B12 = new JRadioButton(),
				C12 = new JRadioButton(), D12 = new JRadioButton(),
				E12 = new JRadioButton(), F12 = new JRadioButton();

		static JRadioButton A13 = new JRadioButton(), B13 = new JRadioButton(),
				C13 = new JRadioButton(), D13 = new JRadioButton(),
				E13 = new JRadioButton(), F13 = new JRadioButton();

		//puts all of the seats into an array list
		static JRadioButton[][] seats = { { A1, B1, C1, D1, E1, F1 },
				{ A2, B2, C2, D2, E2, F2 }, { A3, B3, C3, D3, E3, F3 },
				{ A4, B4, C4, D4, E4, F4 }, { A5, B5, C5, D5, E5, F5 },
				{ A6, B6, C6, D6, E6, F6 }, { A7, B7, C7, D7, E7, F7 },
				{ A8, B8, C8, D8, E8, F8 }, { A9, B9, C9, D9, E9, F9 },
				{ A10, B10, C10, D10, E10, F10 },
				{ A11, B11, C11, D11, E11, F11 },
				{ A12, B12, C12, D12, E12, F12 },
				{ A13, B13, C13, D13, E13, F13 } };
		
		//creates JButtons for Checkout, Reset, and Exit for the user to interact with
		JButton checkout = new JButton("Checkout"), reset = new JButton("Reset"), exit = new JButton("Exit");
		ButtonPressed co = new ButtonPressed(), rst = new ButtonPressed(), ext = new ButtonPressed();
		
		//creates labels of space to place before and after the Checkout, Reset, and Exit buttons
		JLabel last1 = new JLabel(""), last2 = new JLabel(""), last3 = new JLabel(""), last4 = new JLabel(""), last5 = new JLabel(""), last6 = new JLabel(""), last7 = new JLabel(""), last8 = new JLabel("");
		//creates an array list of spaces
		JLabel[] lasts = {last1, last2, last3, last4, last5, last6, last7, last8};
		
		//creates an action listener for each seat button
		SeatSelected A1L = new SeatSelected(), B1L = new SeatSelected(),
				C1L = new SeatSelected(), D1L = new SeatSelected(),
				E1L = new SeatSelected(), F1L = new SeatSelected();

		SeatSelected A2L = new SeatSelected(), B2L = new SeatSelected(),
				C2L = new SeatSelected(), D2L = new SeatSelected(),
				E2L = new SeatSelected(), F2L = new SeatSelected();

		SeatSelected A3L = new SeatSelected(), B3L = new SeatSelected(),
				C3L = new SeatSelected(), D3L = new SeatSelected(),
				E3L = new SeatSelected(), F3L = new SeatSelected();

		SeatSelected A4L = new SeatSelected(), B4L = new SeatSelected(),
				C4L = new SeatSelected(), D4L = new SeatSelected(),
				E4L = new SeatSelected(), F4L = new SeatSelected();

		SeatSelected A5L = new SeatSelected(), B5L = new SeatSelected(),
				C5L = new SeatSelected(), D5L = new SeatSelected(),
				E5L = new SeatSelected(), F5L = new SeatSelected();

		SeatSelected A6L = new SeatSelected(), B6L = new SeatSelected(),
				C6L = new SeatSelected(), D6L = new SeatSelected(),
				E6L = new SeatSelected(), F6L = new SeatSelected();

		SeatSelected A7L = new SeatSelected(), B7L = new SeatSelected(),
				C7L = new SeatSelected(), D7L = new SeatSelected(),
				E7L = new SeatSelected(), F7L = new SeatSelected();

		SeatSelected A8L = new SeatSelected(), B8L = new SeatSelected(),
				C8L = new SeatSelected(), D8L = new SeatSelected(),
				E8L = new SeatSelected(), F8L = new SeatSelected();

		SeatSelected A9L = new SeatSelected(), B9L = new SeatSelected(),
				C9L = new SeatSelected(), D9L = new SeatSelected(),
				E9L = new SeatSelected(), F9L = new SeatSelected();

		SeatSelected A10L = new SeatSelected(), B10L = new SeatSelected(),
				C10L = new SeatSelected(), D10L = new SeatSelected(),
				E10L = new SeatSelected(), F10L = new SeatSelected();

		SeatSelected A11L = new SeatSelected(), B11L = new SeatSelected(),
				C11L = new SeatSelected(), D11L = new SeatSelected(),
				E11L = new SeatSelected(), F11L = new SeatSelected();

		SeatSelected A12L = new SeatSelected(), B12L = new SeatSelected(),
				C12L = new SeatSelected(), D12L = new SeatSelected(),
				E12L = new SeatSelected(), F12L = new SeatSelected();

		SeatSelected A13L = new SeatSelected(), B13L = new SeatSelected(),
				C13L = new SeatSelected(), D13L = new SeatSelected(),
				E13L = new SeatSelected(), F13L = new SeatSelected();
		
		//puts all the seat action listeners into an array list
		SeatSelected[][] listeners = { { A1L, B1L, C1L, D1L, E1L, F1L },
					{ A2L, B2L, C2L, D2L, E2L, F2L }, { A3L, B3L, C3L, D3L, E3L, F3L },
					{ A4L, B4L, C4L, D4L, E4L, F4L }, { A5L, B5L, C5L, D5L, E5L, F5L },
					{ A6L, B6L, C6L, D6L, E6L, F6L }, { A7L, B7L, C7L, D7L, E7L, F7L },
					{ A8L, B8L, C8L, D8L, E8L, F8L }, { A9L, B9L, C9L, D9L, E9L, F9L },
					{ A10L, B10L, C10L, D10L, E10L, F10L },
					{ A11L, B11L, C11L, D11L, E11L, F11L },
					{ A12L, B12L, C12L, D12L, E12L, F12L },
					{ A13L, B13L, C13L, D13L, E13L, F13L } };
		
		//creates an array list of seat names
		static String[][] allSeats = {{"A1", "B1", "C1", "D1", "E1", "F1"},
				{"A2", "B2", "C2", "D2", "E2", "F2"}, {"A3", "B3", "C3", "D3", "E3", "F3"},
				{"A4", "B4", "C4", "D4", "E4", "F4"}, {"A5", "B5", "C5", "D5", "E5", "F5"},
				{"A6", "B6", "C6", "D6", "E6", "F6"}, {"A7", "B7", "C7", "D7", "E7", "F7"},
				{"A8", "B8", "C8", "D8", "E8", "F8"}, {"A9", "B9", "C9", "D9", "E9", "F9"},
				{"A10", "B10", "C10", "D10", "E10", "F10"},
				{"A11", "B11", "C11", "D11", "E11", "F11"},
				{"A12", "B12", "C12", "D12", "E12", "F12"},
				{"A13", "B13", "C13", "D13", "E13", "F13"}};
		
		//creates a group to put all of the seats in so that the user can choose only one seat at a time
		ButtonGroup group = new ButtonGroup();
		
		public SeatButtonsFinal() {
			super(new BorderLayout());

			checkout.addActionListener(co); 
			reset.addActionListener(rst);
			exit.addActionListener(ext);
			
			// Group the radio buttons.
			for (int row = 0; row < seats.length; row++)
				{
					for (int col = 0; col < seats[row].length; col++)
						{
							group.add(seats[row][col]);
						}
				}

			// Register a listener for the radio buttons.
			
			for (int row = 0; row<seats.length; row++)
				{
					for (int col = 0; col<seats[0].length; col++)
						{
							seats[row][col].addActionListener(listeners[row][col]);
						}
				}

			// Put the radio buttons in a column in a panel.
			JPanel radioPanel = new JPanel(new GridLayout(16, 11));

			//creates the labels for each column header
			JLabel aisle = new JLabel("   ");
			JLabel blank = new JLabel("   ");
			JLabel seatA = new JLabel("  A");
			JLabel seatB = new JLabel("  B");
			JLabel seatC = new JLabel("  C");
			JLabel seatD = new JLabel("  D");
			JLabel seatE = new JLabel("  E");
			JLabel seatF = new JLabel("  F");
			JLabel blank2 = new JLabel ("");
			JLabel section = new JLabel("Class");
			JLabel blank3 = new JLabel ("");
			JLabel price = new JLabel ("Price");

			//adds the labels to the panel
			radioPanel.add(blank);
			radioPanel.add(seatA);
			radioPanel.add(seatB);
			radioPanel.add(seatC);
			radioPanel.add(aisle);
			radioPanel.add(seatD);
			radioPanel.add(seatE);
			radioPanel.add(seatF);
			radioPanel.add(blank2);
			radioPanel.add(section);
			radioPanel.add(blank3);
			radioPanel.add(price);

			//creates a label for each row
			JLabel row1 = new JLabel("Row 1  ");
			JLabel row2 = new JLabel("Row 2  ");
			JLabel row3 = new JLabel("Row 3  ");
			JLabel row4 = new JLabel("Row 4  ");
			JLabel row5 = new JLabel("Row 5  ");
			JLabel row6 = new JLabel("Row 6  ");
			JLabel row7 = new JLabel("Row 7  ");
			JLabel row8 = new JLabel("Row 8  ");
			JLabel row9 = new JLabel("Row 9  ");
			JLabel row10 = new JLabel("Row 10  ");
			JLabel row11 = new JLabel("Row 11  ");
			JLabel row12 = new JLabel("Row 12  ");
			JLabel row13 = new JLabel("Row 13  ");
			
			//creates an array list of row labels
			JLabel[] labels = {row1, row2, row3, row4, row5, row6, row7, row8, row9, row10, row11, row12, row13};
			
			//aisle separator labels
			JLabel a1 = new JLabel(" | "), a2 = new JLabel(" | "), a3 = new JLabel(" | "), a4 = new JLabel(" | "), a5 = new JLabel(" | "), a6 = new JLabel(" | "), a7 = new JLabel(" | "), a8 = new JLabel(" | "), a9 = new JLabel(" | "), a10 = new JLabel(" | "), a11 = new JLabel(" | "), a12 = new JLabel(" | "), a13 = new JLabel(" | ");
			//data separator labels
			JLabel b1 = new JLabel(" | "), b2 = new JLabel(" | "), b3 = new JLabel(" | "), b4 = new JLabel(" | "), b5 = new JLabel(" | "), b6 = new JLabel(" | "), b7 = new JLabel(" | "), b8 = new JLabel(" | "), b9 = new JLabel(" | "), b10 = new JLabel(" | "), b11 = new JLabel(" | "), b12 = new JLabel(" | "), b13 = new JLabel(" | ");
			//class type labels
			JLabel s1 = new JLabel("First"), s2 = new JLabel("First"), s3 = new JLabel("Business"), s4 = new JLabel("Business"), s5 = new JLabel("Business"), s6 = new JLabel("Business"), s7 = new JLabel("Business"), s8 = new JLabel("Economy"), s9 = new JLabel("Economy"), s10 = new JLabel("Economy"), s11 = new JLabel("Economy"), s12 = new JLabel("Economy"), s13 = new JLabel("Economy");
			//data separator labels
			JLabel m1 = new JLabel("  "), m2 = new JLabel("  "), m3 = new JLabel("  "), m4 = new JLabel("  "), m5 = new JLabel("  "), m6 = new JLabel("  "), m7 = new JLabel("  "), m8 = new JLabel("  "), m9 = new JLabel("  "), m10 = new JLabel("  "), m11 = new JLabel("  "), m12 = new JLabel("  "), m13 = new JLabel("  ");
			//price labels
			JLabel p1 = new JLabel("$507"), p2 = new JLabel("$507"), p3 = new JLabel("$420"), p4 = new JLabel("$420"), p5 = new JLabel("$420"), p6 = new JLabel("$420"),p7 = new JLabel("$420"), p8 = new JLabel("$250"), p9 = new JLabel("$250"), p10 = new JLabel("$250"), p11 = new JLabel("$250"), p12 = new JLabel("$250"), p13 = new JLabel("$250");
			//data separator labels
			JLabel e1 = new JLabel(""), e2 = new JLabel(""), e3 = new JLabel(""), e4 = new JLabel(""), e5 = new JLabel(""), e6 = new JLabel(""), e7 = new JLabel(""), e8 = new JLabel(""), e9 = new JLabel(""), e10 = new JLabel(""), e11 = new JLabel(""), e12 = new JLabel(""), e13 = new JLabel("");
			
			//creates an array list of aisle separators
			JLabel[] aisles = {a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13};
			//creates an array list of data separators
			JLabel[] blanks = {b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13};
			//creates an array list of class types
			JLabel[] sections = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13};
			//creates an array list of blanks to separate data fields
			JLabel[] more = {m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13};
			//creates an array list of prices
			JLabel[] prices = {p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13};
			//creates an array list of blank space to place between the seats and buttons
			JLabel[] extraRow = {e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13};
			
			for (int row = 0; row<seats.length; row++)
				{
					for (int col = 0; col<seats[0].length+6; col++)
						{
							//adds header row of labels to panel
							if (col==0)
								radioPanel.add(labels[row]);
							//adds first three seat radio buttons in a row to panel
							else if(col>0 && col<4)
								radioPanel.add(seats[row][col-1]);
							//adds row labels to panel
							else if (col==4)
								radioPanel.add(aisles[row]);
							//adds last three seat radio buttons in a row to panel
							else if (col>4 && col<8)
								radioPanel.add(seats[row][col-2]);
							//adds data separators between radio buttons to represent aisle in plane to panel
							else if (col==8)
								radioPanel.add(blanks[row]);
							//adds seat class type to panel
							else if (col==9)
								radioPanel.add(sections[row]);
							//adds a blank space to panel to separate class type and prices
							else if (col==10)
								radioPanel.add(more[row]);
							//adds prices of each each to panel
							else if (col==11)
								radioPanel.add(prices[row]);
						}
				}
			
			//adds a blank row to the panel to separate the plane diagram from the checkout, reset, and exit buttons
			for (int col = 0; col<12; col++)
			{
				radioPanel.add(extraRow[col]);
			}
			
			for (int col = 0; col<10; col++)
				{
					//adds Checkout button to panel
					if (col==3)
						radioPanel.add(checkout);
					//adds Reset button to panel
					else if (col==6)
						radioPanel.add(reset);
					//adds Exit button to panel
					else if (col==9)
						radioPanel.add(exit);
					//adds space labels before the Checkout button
					else if (col<3)
						radioPanel.add(lasts[col]);
					//adds space label between the Checkout button and Reset button
					else if (col<6)
						radioPanel.add(lasts[col-1]);
					//adds space label between the Rest button and Exit button
					else
						radioPanel.add(lasts[col-2]);
				}
			

			add(radioPanel, BorderLayout.LINE_START);
			setBorder(BorderFactory.createEmptyBorder(50, 50, 30, 30));
		}

		/** Listens to the radio buttons. */
		private class SeatSelected implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{

				JRadioButton myButton = findSeat();
				
				String question = "Is seat " + getSeat() + " the one you want?";
				
				int confirm = JOptionPane.showConfirmDialog(null,
						question);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
						myButton.setEnabled(false);
						group.clearSelection();
						list.add(getSeat());
						total_price = write.getPrice(list);
						write.writeSeatsTaken(String.valueOf(resID), list, total_price);
					}
				else
					{
						group.clearSelection();
					}
			}
			//locates the button that sent the event
			public JRadioButton findSeat()
			{
				for (int row = 0; row<listeners.length; row++)
					{
						for (int col = 0; col<listeners[0].length; col++)
							{
								if (this == listeners[row][col])
									return seats[row][col];
							}
						
					}
				return new JRadioButton();
			}
			
			
			public String getSeat()
			{
				String seat = "";
				
				for (int row = 0; row<listeners.length; row++)
					{
						for (int col = 0; col<listeners[0].length; col++)
							{
								if (this == listeners[row][col])
									seat = allSeats[row][col];
							}
					
					}
				
				return seat;
			}
		}
		
		private class ButtonPressed implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				if (this==co)
					{
						javax.swing.SwingUtilities.invokeLater(new Runnable() 
							{
								public void run()
									{
										reset.setEnabled(false);
										checkout.setEnabled(false);
										InfoFrontEnd.toInfo();
									}
							}
						);
					}
					//send to info screen
				else if (this==rst)
				{
					
					reset();
				}
				else
					{
						
						sfile.delete();
						System.exit(0);
					}
					//release seats & reset
			}
		}
		

		/**
		 * Create the GUI and show it. For thread safety, this method should be
		 * invoked from the event-dispatching thread.
		 */
		
		
		public static void createAndShowGUI()
			{
			
			ArrayList <String> seats_taken = write.grabAllResID();
			boolean duplicate = false;
			while(true)
			{
				for(int i = 0; i < seats_taken.size(); i++)
				{
					if (resID == Integer.parseInt(seats_taken.get(i)))
						duplicate = true;
				}
				if (duplicate == true)
				{
					resID = rng.nextInt(90000) + 10000;
				}
				else	 
					break;
			}
			JFrame frame = new JFrame("Flight Reservation");
				
				frame.addWindowListener(new java.awt.event.WindowAdapter() 
					{
						public void windowClosing(java.awt.event.WindowEvent e) 
							{
								sfile.delete();
								System.exit(0);
							}
					}
				);
				//ArrayList <String> seats_taken = write.grabAllResID();
				
				
				// Create and set up the window.
				
				//frame.setDefaultCloseOperation(close());
				
				ReadSeats1();
				if (unavailableSeats!=null)
					for (int i = 0; i < unavailableSeats.size(); i++)
					{
						for (int x = 0; x < allSeats.length; x++)
							{
								for (int y = 0; y < allSeats[0].length; y++)
									{
										if (unavailableSeats.get(i).equals(allSeats[x][y]))
											seats[x][y].setEnabled(false);
												
									}
							}
					}
				
				
				
				
				// Create and set up the content pane.
				JComponent newContentPane = new SeatButtonsFinal();
				newContentPane.setOpaque(true); // content panes must be opaque
				frame.setContentPane(newContentPane);

				// Display the window.
				frame.pack();
				frame.setVisible(true);
			}
		
		
		public void reset()
			{
				ArrayList <String> arr = InfoFrontEnd.seatsChosen();
				for (int i = 0; i < arr.size(); i++)
					{
						for (int x = 0; x < allSeats.length; x++)
							{
								for (int y = 0; y < allSeats[0].length; y++)
									{
										if (arr.get(i).equals(allSeats[x][y]))
											seats[x][y].setEnabled(true);
												
									}
							}
					}
				sfile.delete();
				list = new ArrayList <String>();
			}

		public static void main (String[] args)
			{
				// Schedule a job for the event-dispatching thread:
				// creating and showing this application's GUI.
				javax.swing.SwingUtilities.invokeLater(new Runnable() 
					{
						public void run()
							{
								createAndShowGUI();
							}
					}
				);
			}
	}