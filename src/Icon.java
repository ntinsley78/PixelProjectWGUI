//#####################################
 //ICON class  Created 5-30-2013 - Nick Tinsley - for OOP homework number1

import java.util.ArrayList;


public class Icon
{
	//Declarations
	private ArrayList <ArrayList <Pixel>> icon;

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//Constructors

	//Default Constructor	
	public Icon() throws ExceptionList
	{
		this(40,40);
	}
	
	//Constructor to build an Icon with defined rows and columns
	public Icon(int row, int col) throws ExceptionList  
	{
		icon = new ArrayList<ArrayList<Pixel>>();
		
		for (int r =0; r<row; r++)
		{
			ArrayList < Pixel > tempList = new ArrayList<Pixel>();
			
			for (int c =0; c<col; c++)
			{
				Pixel tempPixel = new Pixel(255,255,255); //default pixel will be #000000
				tempList.add(tempPixel);
			}
			icon.add(tempList);
		}
	}
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	// Set colors for the Icons
	public void setRed (int row, int col, int r) throws ExceptionList
	{
		icon.get(row).get(col).setRed(r);
	}

	public void setGreen (int row, int col, int g) throws ExceptionList
	{
		icon.get(row).get(col).setGreen(g);
	}
	
	public void setBlue (int row, int col, int b) throws ExceptionList
	{
		icon.get(row).get(col).setBlue(b);
	}
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//Method to print out the pixel
	public void printIcon() throws ExceptionList
	{
	
		if (icon.size() > 0) //if the icon size is greater than 0 then print else throw exception
		{
			double rowSize = icon.size(); //number  of rows for traversing
			double colSize = icon.get(0).size(); //size of columns for traversing
			
			
			for (int r = 0; r<rowSize; r++) //traverse each row
			{
				for (int c = 0 ; c< colSize; c++) //traverse each column
				{
					System.out.print(icon.get(r).get(c).printHex() + " "); //print hex code for each pixel
				} 
				System.out.println();
			}
		}
		else 
		{
			throw new ExceptionList("OutOfBounds");	
		}
	}
	
	//Create bitmap
	public void createBitmap() throws ExceptionList
	{
		if (icon.size() > 0) //if the icon size is greater than 0 then print else throw exception
		{
			
			int rowSize = icon.size(); //number  of rows for traversing
			int colSize = icon.get(0).size(); //size of columns for traversing
			BitmapCreator bmp = new BitmapCreator(rowSize,colSize);
		
			for (int r = 0; r<rowSize; r++) //traverse each row
			{
				for (int c = 0 ; c< colSize; c++) //traverse each column
				{
					bmp.addPixel(r,c,icon.get(r).get(c).getRed(), icon.get(r).get(c).getGreen(), icon.get(r).get(c).getBlue()); //print hex code for each pixel
				} 
				//System.out.println();
			}
			bmp.writeToFile("c:\\Icon"+System.currentTimeMillis()+".bmp");
		}
		else 
		{
			
			throw new ExceptionList("OutOfBounds");
			
		}				
	}
}

