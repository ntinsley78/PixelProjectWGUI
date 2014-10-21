//GUI Class  Created 6-18-2013 - Nick Tinsley - for OOP homework number3


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


@SuppressWarnings({ "serial", "unused" })
public class PixelGUI extends JFrame implements ChangeListener, ActionListener, MouseListener
{
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//Declarations
	
	//Buttons
	private PixelButton pixels; //pixel button 
	private JButton btnCreateBitmap; //button to create bitmap file
	private JButton btnSaveColor; //button to save color
	
	//buttons for colors
	private JButton btnPreview;
	private JButton btnColor1;
	private JButton btnColor2;
	private JButton btnColor3;
	private JButton btnColor4;
	private JButton btnColor5;
	
	//sliders
	private JSlider sldRValue; //slider for red
	private JSlider sldGValue; //slider for green
	private JSlider sldBValue; //slider for blue
	
	static int sliderMin=0; //slider min value
	static int sliderMax=255; //slider max value
	static int sliderInit=0; //initial start value
	
	
	//check boxes
	private JCheckBox cbAdvancedSettings; //checkbox for advance Settings
	
	//labels
	private JLabel lblRed; //label for red
	private JLabel lblGreen; //label for green
	private JLabel lblBlue; //label for blue
	
	//labels for colors 1 - 5 and preview
	private JLabel lblColor1;
	private JLabel lblColor2;
	private JLabel lblColor3;
	private JLabel lblColor4;
	private JLabel lblColor5;
	private JLabel lblPreview;
	
	//label for advanced settings
	private JLabel lblAdvance;
	
	
	//text boxes
	private JTextField tbRed; //text box for red
	private JTextField tbGreen; //text box for green
	private JTextField tbBlue; //text box for blue
	
	
	//menu bar
	private JMenuBar menuBar;
	private JMenu file;
	private JMenuItem close;
	
	
	//color pixel
	Color pixel1 = new Color (0,0,0); //get color of the pixel
	
	//counter for save clicks
	private int saveCounter = 0;
	private int counterTest = 1;
	private boolean set1 = false;
	private boolean set2 = false;
	private boolean set3 = false;
	private boolean set4 = false;
	private boolean set5 = false;
	
	//icon
	Icon icon = null;
		
	
	//GUI Constructor
	public PixelGUI(int r, int c) throws ExceptionList 
	{
		//@@@@@@@@@@@@@@@@@@@@@@@@@
		// Build GUI for Pixel Program
		super ("Icon Creator " + r + " x " + c); //name of program
		
		//test
		icon = new Icon(r, c);
		
		setSize(new Dimension(800,600)); //size of form
		setIconImage(new ImageIcon("test.png").getImage());
		//setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);

		//*************************		
		//create buttons
		
		//save color,,, needs to go away but will work on that soon
		btnSaveColor = new JButton("Save Color");
		btnSaveColor.addActionListener(this);
		btnSaveColor.setToolTipText("Click save to save the current color.  Click on the Current or Color(s) 2-5 to use that color to draw.");

		//save bitmap
		btnCreateBitmap = new JButton("Save Icon");
		btnCreateBitmap.addActionListener(this);
		btnCreateBitmap.setToolTipText("File will be saved in the root of C:, file format is: ICON%dateandtime%.bmp");
		
		//the last five used colors, button one will be a panel to show the current color being made
		btnColor1 = new JButton(); 
		btnColor1.setBackground(Color.white);
		btnColor1.addActionListener(this);
		btnColor1.addMouseListener(this);
		btnColor1.setToolTipText("Left Click to get color, right click to save color after initial saving");

		btnColor2 = new JButton();
		btnColor2.setBackground(Color.white);
		btnColor2.addActionListener(this);
		btnColor2.addMouseListener(this);
		btnColor2.setToolTipText("Left Click to get color, right click to save color after initial saving");
		
		btnColor3 = new JButton();
		btnColor3.setBackground(Color.white);
		btnColor3.addActionListener(this);
		btnColor3.addMouseListener(this);
		btnColor3.setToolTipText("Left Click to get color, right click to save color after initial saving");
		
		btnColor4 = new JButton();
		btnColor4.setBackground(Color.white);
		btnColor4.addActionListener(this);
		btnColor4.addMouseListener(this);
		btnColor4.setToolTipText("Left Click to get color, right click to save color after initial saving");
		
		btnColor5 = new JButton();
		btnColor5.setBackground(Color.white);
		btnColor5.addActionListener(this);
		btnColor5.addMouseListener(this);
		btnColor5.setToolTipText("Left Click to get color, right click to save color after initial saving");
			
		
		//*************************
		//create sliders
		//font for sliders
		Font sliderFont = new Font ("Serif", Font.ITALIC, 15);
		
		//red slider
		sldRValue = new JSlider(JSlider.HORIZONTAL,sliderMin, sliderMax, sliderInit); 
		sldRValue.setMajorTickSpacing(255);
		sldRValue.setMinorTickSpacing(1);
		sldRValue.setPaintTicks(true);
		sldRValue.setPaintLabels(true);
		sldRValue.setFont(sliderFont);
		sldRValue.addChangeListener(this);
		
		//green slider
		sldGValue = new JSlider(JSlider.HORIZONTAL, sliderMin,sliderMax,sliderInit);
		sldGValue.setMajorTickSpacing(255);
		sldGValue.setMinorTickSpacing(1);
		sldGValue.setPaintTicks(true);
		sldGValue.setPaintLabels(true);
		sldGValue.setFont(sliderFont);
		sldGValue.addChangeListener(this);
		
		//blue slider
		sldBValue = new JSlider(JSlider.HORIZONTAL, sliderMin, sliderMax, sliderInit);
		sldBValue.setMajorTickSpacing(255);
		sldBValue.setMinorTickSpacing(1);
		sldBValue.setPaintTicks(true);
		sldBValue.setPaintLabels(true);
		sldBValue.setFont(sliderFont);
		sldBValue.addChangeListener(this);
		
		
		//Preview had to put after the sliders to get the background color
		btnPreview = new JButton();
		btnPreview.setBackground(new Color(sldRValue.getValue(),sldGValue.getValue(),sldBValue.getValue()));
		
		
		//*************************
		//create check boxes
		cbAdvancedSettings = new JCheckBox();
		
		//*************************
		//create labels
		lblRed = new JLabel("Red value");
		lblRed.setToolTipText("Drag slider or type in value for red.  Value must be between 0 and 255");
		
		lblGreen = new JLabel ("Green Value");
		lblGreen.setToolTipText("Drag slider or type in value for green.  Value must be between 0 and 255");
		
		lblBlue = new JLabel ("Blue Value");
		lblBlue.setToolTipText("Drag slider or type in value for Blue.  Value must be between 0 and 255");
		
		lblColor1 = new JLabel(" Color 1:");
		
		lblColor2 = new JLabel(" Color 2:");
		
		lblColor3 = new JLabel(" Color 3:");
		
		lblColor4 = new JLabel(" Color 4:");
		
		lblColor5 = new JLabel(" Color 5:");
		
		lblPreview = new JLabel(" Current Color ");
		
		lblAdvance = new JLabel ("Advance Settings");
		lblAdvance.setToolTipText("Click here to turn on advanced settings.  After Turning on advance Settings right click any button to see the advanced setting menu");
		
		
		//*************************
		//create text boxes
		tbRed = new JTextField (3);
		tbRed.setText(Integer.toString(sldRValue.getValue()));
		tbRed.addActionListener(this);
		
		tbGreen = new JTextField (3);
		tbGreen.setText(Integer.toString(sldGValue.getValue()));
		tbGreen.addActionListener(this);
		
		tbBlue = new JTextField(3);
		tbBlue.setText(Integer.toString(sldBValue.getValue()));
		tbBlue.addActionListener(this);
		
		
		//************************
		//Menu bar
		menuBar =new JMenuBar();
		
		//menus
		file = new JMenu();
		
		menuBar.add(file);
		
		//menu items
		close = new JMenuItem();
		
		file.add(close);

		
		//@@@@@@@@@@@@@@@@@@@@@@@@@
		//JFrames

		//*************************
		//north
		JPanel northPanel = new JPanel();
		northPanel.add(menuBar);	
		
		//*************************
		//east, sliders and slider values
		
		JPanel eastPanel = new JPanel(); //JPanel for the sliders 
		eastPanel.setLayout(new GridLayout(0,1));
		
		eastPanel.add(lblRed);
		eastPanel.add(sldRValue);
		eastPanel.add(tbRed);
		
		eastPanel.add(lblGreen);
		eastPanel.add(sldGValue);
		eastPanel.add(tbGreen);
		
		eastPanel.add(lblBlue);
		eastPanel.add(sldBValue);
		eastPanel.add(tbBlue);

		//*************************
		//south, saved colors and control buttons, and possibly check box for more mode
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1,8));
		southPanel.add(btnCreateBitmap);
		
		//color 1
		southPanel.add(lblColor1);
		southPanel.add(btnColor1);
		//color 2
		southPanel.add(lblColor2);
		southPanel.add(btnColor2);
		//color 3
		southPanel.add(lblColor3);
		southPanel.add(btnColor3);
		//color 4
		southPanel.add(lblColor4);
		southPanel.add(btnColor4);
		//color5
		southPanel.add(lblColor5);
		southPanel.add(btnColor5);
		//advanced settings
		southPanel.add(lblAdvance);
		southPanel.add(cbAdvancedSettings);
		
		
		//*************************
		//west
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout (2,2));
		westPanel.add(lblPreview);
		westPanel.add(btnPreview);
		
		
		//*************************
		//center
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(r,c));
						
		//create a button for each row and column, builds pixel
		for (int i = 0; i <r ; i++)
		{
 			for (int j = 0; j<c; j++)
			{
				 pixels = new PixelButton(i,j);
				 centerPanel.add(pixels);
				 pixels.setBackground(Color.white);
				 pixels.addActionListener(this);
				 pixels.addMouseListener(this);
			}
					
		}
		
		//@@@@@@@@@@@@@@@@@@@@@@@@@
		//Build Form \ content pane
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(eastPanel, BorderLayout.EAST);
		getContentPane().add(centerPanel, BorderLayout.CENTER);
		getContentPane().add(southPanel,BorderLayout.SOUTH);
		getContentPane().add(westPanel,BorderLayout.WEST);		
		
		
		pack();
		
		//*************************
		//default Close Operation set to exit on close
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		
		
		//*************************
		//show Content Pane
		setVisible(true); 
	}
	
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//Event watcher.

	//If sliders change make text box the value of slider

	@Override
	public void stateChanged(ChangeEvent e)
	{
		//to get the slider changes
		
		JSlider source = (JSlider)e.getSource();
		Color pixel2 = new Color (sldRValue.getValue(), sldGValue.getValue(), sldBValue.getValue()); //get color of the pixel
		
		if (e.getSource() == sldRValue)
		{
			System.out.println("red moved");
			tbRed.setText(Integer.toString(sldRValue.getValue()));
			btnPreview.setBackground(pixel2);
			
		}
		else if (e.getSource() == sldGValue)
		{
			System.out.println("green moved");
			tbGreen.setText(Integer.toString(sldGValue.getValue()));
			btnPreview.setBackground(pixel2);
			
		}
		else if (e.getSource() == sldBValue)
		{
			System.out.println("blue moved");
			tbBlue.setText(Integer.toString(sldBValue.getValue()));
			btnPreview.setBackground(pixel2);
		}
	}
	 
	 
	 //events for buttons  pixels and text boxes
	@Override
	public void actionPerformed(ActionEvent e)
	{
		pixel1 = btnPreview.getBackground(); //default to preview
		
		//Actions for Buttons
		if (e.getSource() == btnColor1)
		{
			pixel1 = btnColor1.getBackground();//get color when current color is clicked
			sldRValue.setValue(pixel1.getRed());
			sldGValue.setValue(pixel1.getGreen());
			sldBValue.setValue(pixel1.getBlue());
			
		}
		else if (e.getSource() == btnColor2)
		{
			pixel1 = btnColor2.getBackground(); //get color when color 2 is clicked
			sldRValue.setValue(pixel1.getRed());
			sldGValue.setValue(pixel1.getGreen());
			sldBValue.setValue(pixel1.getBlue());
		}
		else if (e.getSource() == btnColor3)
		{
			pixel1 = btnColor3.getBackground(); //get color when color 3 is clicked
			sldRValue.setValue(pixel1.getRed());
			sldGValue.setValue(pixel1.getGreen());
			sldBValue.setValue(pixel1.getBlue());
		}
		else if (e.getSource() == btnColor4)
		{
			pixel1 = btnColor4.getBackground(); //get color when color 4 is clicked
			sldRValue.setValue(pixel1.getRed());
			sldGValue.setValue(pixel1.getGreen());
			sldBValue.setValue(pixel1.getBlue());
		}
		else if (e.getSource()== btnColor5)
		{
			pixel1 = btnColor5.getBackground(); //get color when color 5 is clicked
			sldRValue.setValue(pixel1.getRed());
			sldGValue.setValue(pixel1.getGreen());
			sldBValue.setValue(pixel1.getBlue());
		}
		
		if(e.getSource() instanceof PixelButton) //if the button was a pixel button
		{
			PixelButton pressed = (PixelButton)e.getSource(); //get source of the button
				
			try
			{
				//put RGB Value into the Icon object
				icon.setRed(pressed.getRow(), pressed.getCol(), pixel1.getRed());
				icon.setGreen(pressed.getRow(), pressed.getCol(), pixel1.getGreen());
				icon.setBlue(pressed.getRow(), pressed.getCol(), pixel1.getBlue());
				
				//draw button on screen
				pressed.setBackground(pixel1); //set background to the new color
				
				//save color to the color palette
				if (btnPreview.getBackground() == btnColor1.getBackground())
				{
					// do nothing
				}
				else
				{
					saveColor(pixel1, counterTest);
					counterTest ++;
					
				}
				if	(btnPreview.getBackground()==btnColor2.getBackground()) 
				{
					//do nothing
				}
				else
				{
					saveColor(pixel1, counterTest);
					counterTest ++;
					
				}
				if ( btnPreview.getBackground() == btnColor3.getBackground() )   
				{
					
				}
				else
				{
					saveColor(pixel1, counterTest);
					counterTest ++;
					
				}
				if (btnPreview.getBackground() == btnColor4.getBackground())
				{
					
				}
				else
				{
					saveColor(pixel1, counterTest);
					counterTest ++;
					
				}
				if(btnPreview.getBackground() == btnColor5.getBackground())
				{
					
				}
				else
				{
					saveColor(pixel1, counterTest);
					counterTest ++;
					
				}
			
				//print the icon to the console, for logging.
				icon.printIcon();
			} 
			catch (ExceptionList e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println("color was set R" + sldRValue.getValue() + " ,G" + sldGValue.getValue() + " ,B" + sldBValue.getValue()); //log that the button was changed to the color
		}
		
		if(e.getSource() == btnCreateBitmap)
		{
			try
			{
				icon.createBitmap();
			} catch (ExceptionList e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		//Actions for Text boxes
		if (e.getSource() == tbRed) //if value in tbRed was changed
		{
			System.out.println("tbRed was changed");
			sldRValue.setValue(Integer.valueOf(tbRed.getText())); //set r slider to the value in tbRed
		}
		
		else if (e.getSource() == tbGreen)//if value in tbGreen was changed
		{
			System.out.println("tbGreen was changed");
			sldGValue.setValue(Integer.valueOf(tbGreen.getText())); //set g slider to the value in tbGreen
		}
		else if (e.getSource() == tbBlue) //if value in tbBlue was changed
		{
			System.out.println("tbBlue was changed");
			sldBValue.setValue(Integer.valueOf(tbBlue.getText())); //set r slider to the value in tbBlue
		}
		
			
	}

//Mouse clicking actions

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (SwingUtilities.isRightMouseButton(e) && cbAdvancedSettings.isSelected())
		{ 
			System.out.println("right click was used");
			try
			{
				PixelGUITab advanceMenu = new PixelGUITab();
			} catch (IOException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource() == btnColor1 && SwingUtilities.isRightMouseButton(e) )
		{
			set1 = false;
			pixel1 = btnPreview.getBackground();
			saveCounter = 0;
			saveColor(pixel1, 1);
		}
		else if(e.getSource() == btnColor2 && SwingUtilities.isRightMouseButton(e) )
		{
			set2 = false;
			pixel1 = btnPreview.getBackground();
			saveCounter = 1;
			saveColor(pixel1, 2);
		}
		else if(e.getSource() == btnColor3 && SwingUtilities.isRightMouseButton(e) )
		{
			set3 = false;
			pixel1 = btnPreview.getBackground();
			saveCounter = 2;
			saveColor(pixel1 , 3);
		}
		else if(e.getSource() == btnColor4 && SwingUtilities.isRightMouseButton(e) )
		{
			set4 = false;
			pixel1 = btnPreview.getBackground();
			saveCounter = 3;
			saveColor(pixel1 , 4);
		}
		else if(e.getSource() == btnColor5 && SwingUtilities.isRightMouseButton(e) )
		{
			set5 = false;
			pixel1 = btnPreview.getBackground();
			saveCounter = 4;
			saveColor(pixel1, 5);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0)
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
	//************************
	//Functions
	
	//function to save the color
	private void saveColor(Color p, int c)
	{
		saveCounter ++;
		
		if (c == 1 )
		{
			btnColor1.setBackground(p);
			//saveCounter ++;
			set1 = true;
		}
		else if (c == 2  )
		{
			btnColor2.setBackground(p);
			//saveCounter ++;
			set2 = true;
		}
		else if (c ==3  )
		{
			btnColor3.setBackground(p);
			//saveCounter ++;
			set3 = true;
		}
		else if (c == 4 )
		{
			btnColor4.setBackground(p);
			//saveCounter ++;
			set4 = true;
		}
		else if (c == 5  )
		{
			btnColor5.setBackground(p);
			//saveCounter ++;
			set5 = true;
		}
		else if (saveCounter > 5)
		{
			//btnColor1.setBackground(p);
			saveCounter = 0;
			saveColor (p, saveCounter);
		}
		
	}

}//end of class
