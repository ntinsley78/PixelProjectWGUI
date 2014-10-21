import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings({ "serial", "unused" })
public class PixelGUITab extends JFrame implements ActionListener //advanced settings menu 
{
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	//Declarations

	//buttons
	private JButton btnOk;
	
	//labels
	private JLabel lblConstruction;
	
	public PixelGUITab() throws IOException
	{
		super("Advanced Settings Menu");
		//this.setDefaultLookAndFeelDecorated(true);
		setIconImage(new ImageIcon("test.png").getImage());
		
		setLocationRelativeTo(null);
		
		//create buttons
		btnOk = new JButton(" OK ");
		btnOk.addActionListener(this);
		btnOk.requestFocus();
		
		//create labels
		lblConstruction = new JLabel ("This Feature is under construction will be available in next update");
		
		//panels for tabs
		JPanel loadImage = new JPanel();
		loadImage.add(lblConstruction);
		
		JPanel createImage = new JPanel();
		createImage.add(lblConstruction);
		
		//tabs
		JTabbedPane tabs = new JTabbedPane();
		
		tabs.addTab("Main", createImage);
		tabs.addTab("Load Image", loadImage);
		
		//south of main panel
		JPanel southFrame = new JPanel();
		southFrame.setLayout(new FlowLayout());
		southFrame.add(btnOk);
		
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//build form
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add(tabs);
		getContentPane().add(southFrame,BorderLayout.SOUTH);
		getRootPane().setDefaultButton(btnOk);
		
		//formats the Jframe
		pack();
				
		//*************************
		//default Close Operation set to exit on close
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		
		//set location and size
		setLocationRelativeTo(null);
		setSize(400,400);
		
		//*************************
		//show Content Pane
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnOk)
		{
				dispose();				
		}
	}

}//end of class	
	
	
	
	

