import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings({"serial","unused"})

public class PixelMenuGui extends JFrame implements ActionListener

{

	//buttons
	private JButton btnOk;
	private JButton btnClose;
	
	//text boxes
	private JTextField tbRow;
	private JTextField tbColumn;

	//labels
	private JLabel lblRow;
	private JLabel lblColumn;
	
	public PixelMenuGui()  
	{
		
		super("Icon Creator Start Menu");
		//this.setDefaultLookAndFeelDecorated(true);
		setIconImage(new ImageIcon("test.png").getImage());
	
		//create buttons
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.requestFocus();
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(this);
		
		//create text fields
		tbRow = new JTextField(4);
		
		tbColumn = new JTextField(4);
		
		//create labels
		lblRow = new JLabel("Enter height of Icon (# of Pixels)");
		lblColumn = new JLabel("Enter the width of Icon (# of Pixels)");
		
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//JFrames
		//center
		JPanel centerFrame = new JPanel();
		centerFrame.setLayout(new GridLayout(2,2));
		centerFrame.add(lblRow);
		centerFrame.add(tbRow);
		centerFrame.add(lblColumn);
		centerFrame.add(tbColumn);
		
		//south
		JPanel southFrame = new JPanel();
		southFrame.setLayout(new FlowLayout());
		southFrame.add(btnOk);
		southFrame.add(btnClose);
		
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//build form
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(centerFrame, BorderLayout.CENTER); 
		getContentPane().add(southFrame,BorderLayout.SOUTH);
		getRootPane().setDefaultButton(btnOk); //set ok to focused button so client just has to hit enter on keyboard to start Icon
		
		//formats the Jframe
		pack();
		
		//set size and location
		//setSize(new Dimension (200,200));
		setLocationRelativeTo(null);
		
		
		//*************************
		//default Close Operation set to exit on close
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
				
		//*************************
		//show Content Pane
		setVisible(true); 
	}//end constructor

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnOk)
		{
				try
				{
					PixelGUI newGui = new PixelGUI(Integer.valueOf(tbRow.getText()),Integer.valueOf(tbColumn.getText()));
					dispose();
				} 
				catch (NumberFormatException | ExceptionList e1)
				{
					e1.printStackTrace();
				}				
			}
		else if (e.getSource() == btnClose)
		{
			dispose();
		}
		
	}

}//end of class
