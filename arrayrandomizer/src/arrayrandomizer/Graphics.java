package arrayrandomizer;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;


public class Graphics implements ActionListener{
	
	private static CaseMaker cm;
	private static JFrame f;
	private static JButton jb1;
	private static JButton jb2;
	private static JTextField j1;
	private static JTextField j2;
	private static ArrayList<JTextField> jtf;
	public Graphics() throws IOException 
	{
		f = new JFrame("Test Case Maker");//creating instance of JFrame  
        /* LAYOUT
         * 1. Size of Array
         * 2. Number Range
         * 3. Add button
         * 4. Show test case with OptionPane after adding
         * 5. After add it resets the jtextfield boxes
         * 6. Finish button that closes the file
         * 
         *  Optional
         * 7. make name if possible
         * 8. file directory
         *  
         *  Remember :: x-axis, y-axis, 
         */
		
		//instantiate instance variables
		cm = new CaseMaker();
		jtf = new ArrayList<JTextField>();
		
		//array size label
		JLabel ja1 = new JLabel("Enter the size of the array:");
		ja1.setBounds(10, 10, 170, 30 );
		ja1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		//number range label
		JLabel ja2 = new JLabel("Enter the number range:");
		ja2.setBounds(10, 45, 170, 30 );
		ja2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		
		//array size text field
		j1 = new JTextField("");
		j1.setBounds(170, 15, 200, 25);
		j1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtf.add(j1);
		
		//number range text field 
		j2 = new JTextField("");
		j2.setBounds(160, 50, 200, 25);
		j2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		jtf.add(j2);
		
		//write case button
		jb1 = new JButton("Write Case");
		jb1.setBounds(75, 90, 100, 40);
		jb1.addActionListener(this);

		//finish button
		jb2 = new JButton("Finish");
		jb2.setBounds(205, 90, 100, 40);
		jb2.addActionListener(this);
		
		//addlabels
		f.add(ja1); f.add(ja2);
	
		//addtextfields
		f.add(j1); f.add(j2);
		
		//addbuttons
		f.add(jb1); f.add(jb2);
	
		//make jframe
		f.setSize(400,190);//400 width and 300 height  
		f.setLayout(null);//using no layout managers  
		f.setVisible(true);//making the frame visible  
		f.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //closes the application when user presses the 'X'
		
		//make filewriter
	}
	
	public void actionPerformed(ActionEvent e)
	{
		//optionpane
		//reset textfields when done
		Object src = e.getSource();
		Boolean bool = isNumeric(); //returns whether the inputs are valid
		
		
		if(src == jb1) //write the case and stuff
		{
			if(bool) //checks if the inputs are valid
			{
				try 
				{
					cm.writeCases(Integer.parseInt(j1.getText().replaceAll("\\s+","")), Integer.parseInt(j2.getText().replaceAll("\\s+",""))); 
					//first parameter is the input from the array size jtextfield and trims any whitespace
					//second parameter is the input from the number range jtextfield and trims any whitespace
					JOptionPane.showMessageDialog(f, cm.toString(), "Generated Test Case", JOptionPane.INFORMATION_MESSAGE);
					reset();
					
				} catch (IOException e1) {
					System.out.println("ERROR IN JB1");
					e1.printStackTrace();
				}
			}
			
			else
			{
			    JOptionPane.showMessageDialog(f,"Invalid Input. Please Try Again.","Alert",JOptionPane.WARNING_MESSAGE);     
			}
		}
		else if(src == jb2) //makes the file
		{
			try 
			{
				cm.closeCase();
				JOptionPane.showMessageDialog(f, "Test Case File Successfully Generated!");
			} catch (IOException e1) {
				System.out.println("ERROR IN JB2");
				e1.printStackTrace();
			}
		}
		
	}
	
	public static boolean isNumeric() //checks whether or not either textfields has a valid input
	{ 
		try 
		{
			Integer.parseInt(j1.getText().replaceAll("\\s+",""));  
		    Integer.parseInt(j2.getText().replaceAll("\\s+",""));
		    return true;
		    
		} catch(NumberFormatException e){  
		    return false;  
		  }  
	}
	
	public void reset() {
		   for(JTextField field : jtf) {
		      field.setText("");
		   }
		}
}
