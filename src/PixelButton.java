import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;


@SuppressWarnings({ "serial", "unused" })
public class PixelButton extends JButton
{

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//declarations
	private int row;
	private int col;
	
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//Constructors
	
	//Default
	public PixelButton()
	{
		super("");
	}
	
	//w row and column values
	public PixelButton(int r, int c)
	{
		super("");
		setRow(r);
		setCol(c);
		
	}

	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//getters and setters
	
	//row
	public int getRow()
	{
		return row;
	}

	public void setRow(int r)
	{
		row = r;
	}

	//Column
	public int getCol()
	{
		return col;
	}

	public void setCol(int c)
	{
		col = c;
	}

}
