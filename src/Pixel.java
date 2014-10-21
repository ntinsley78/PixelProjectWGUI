//#####################################
//PIXEL class  Created 5-30-2013 - Nick Tinsley - for OOP homework number1  

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class Pixel 
{
	// declarations
	private int rgb = 0; //one RGB value
			
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//Constructors
	
	//default constructor, default is 000000
	public Pixel() throws ExceptionList
	{
		this (0,0,0);
	}
		
	// constructor, with variables
	public Pixel(int r, int g, int b) throws ExceptionList 
	{
		rgb = 0;
		setRed(r);
		setGreen(g);
		setBlue(b);
					
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//Getters and Setters

	//Red Value
	public int getRed()
	{
		return rgb>>>16;
	}

	
	public void setRed(int r) throws ExceptionList
	{
	
		if (r >= 0 && r <= 255) //if value is greater that 255 make it equal 255 - black
		{
			int g = getGreen(); //get green
			int b = getBlue(); //get blue
			r = r << 16;
			g = g << 8;
			rgb = r + g + b;
		}
		else
		{
			// throw exception
			throw new ExceptionList(r + " is not a valid number, number must be between 0 and 255");
		}
	}


//Green Value
	public int getGreen()
	{
		int temp = rgb << 16;
		return temp>>>24;
	}

	public void setGreen(int g) throws ExceptionList
	{
		if (g >= 0 && g <= 255) //if value is greater that 255 or less than 0 throw exception.
		{
			int r = getRed();
			int b = getBlue(); //get blue
			r = r << 16;
			g = g << 8;
			rgb = r + g + b;
		}
		else
		{
			// throw exception
			throw new ExceptionList(g + " is not a valid number, number must be between 0 and 255");
		}
	}


//Blue Value
	public int getBlue()
	{
		int temp = rgb << 24;
		return temp>>>24;
	}

	public void setBlue(int b) throws ExceptionList
	{
		if (b >= 0 && b <= 255) //if value is greater that 255 or less than 0 throw exception
		{
			int r = getRed();	//get red
			int g = getGreen(); //get green
			r = r << 16;
			g = g << 8;
			rgb = r + g + b;
		}
		else
		{
			// throw exception
			throw new ExceptionList(b + " is not a valid number, number must be between 0 and 255");
		}
			
	}
	
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//Functions and Methods	
	
	
	//Function to turn value into Hex
	public String printHex()
	{
		
		String r =  Integer.toHexString(getRed());	//convert red value to hex
		//JOptionPane.showMessageDialog(null, r); 	//for test to see what Hex value was outputting
		String g = Integer.toHexString(getGreen());	//convert green value to hex
		//JOptionPane.showMessageDialog(null, g);	//for test to see what Hex value was outputting
		String b = Integer.toHexString(getBlue());	//convert blue value to hex
		//JOptionPane.showMessageDialog(null, b);	//for test to see what Hex value was outputting
		String retVal;
		
		//if value is 0-9(0,1,2,etc) then add a zero in front as a filler to make 00, 01, 02 etc	
		while (r.length() == 1) 
		{
			r = '0' + r;  //add filler
		}
		
		while (g.length() == 1) 
		{
			
			g = "0" + g;
		}
		
		while (b.length() == 1)
		{
			
			b = '0' + b;
		}
		//JOptionPane.showMessageDialog(null,"#" + r +  g  + b); //test to see what the value was
		retVal = "#" + r + g + b;
		
		return retVal;
	}

	



	
}
