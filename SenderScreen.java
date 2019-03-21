package MSR;


import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JRadioButton;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class SenderScreen extends JFrame {

	private JPanel contentPane;
	public JTextField txtField;
	private JTextField textMeasurment;
	public JSlider slider;
	public NetSend mysend;
	private Thread sThread;
	private JTextField txtIp;

	/**
	 * Create the frame.
	 */
	public SenderScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtField = new JTextField();
		txtField.setText("field");
		txtField.setBounds(82, 37, 163, 47);
		contentPane.add(txtField);
		txtField.setColumns(10);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(0, 0, 1, 1);
		contentPane.add(desktopPane);
		
		textMeasurment = new JTextField();
		textMeasurment.setEditable(false);
		textMeasurment.setBounds(82, 151, 92, 37);
		contentPane.add(textMeasurment);
		textMeasurment.setColumns(10);
		
		slider = new JSlider();
		textMeasurment.setText(String.valueOf(slider.getValue()));
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				textMeasurment.setText(String.valueOf(slider.getValue()));
			}
		});
		slider.setBounds(82, 117, 200, 23);
		contentPane.add(slider);

		//the container for the iptextsever  box 
    	JPanel panel = new JPanel();
		panel.setBounds(82, 205, 163, 47);
		panel.setLayout(null);
		panel.setVisible(false);
		contentPane.add(panel);
		//the iptext box
		txtIp = new JTextField();
		panel.add(txtIp);
		txtIp.setText("IP");
		txtIp.setBounds(0, 0, 162, 46);
		txtIp.setColumns(10);
		//radio button local
		JRadioButton rdbtnLocalhost = new JRadioButton("localhost", true);
                 	 rdbtnLocalhost.addItemListener(new ItemListener() {
		             @Override
		             public void itemStateChanged(ItemEvent event) {
		             int state = event.getStateChange();
		             if (state == ItemEvent.SELECTED) {
		 
		            // not show ip when the button is selected
		            	 panel.setVisible(false);

		            } else if (state == ItemEvent.DESELECTED) {
		 
		            // not show ip else when the button is deselected
		            	panel.setVisible(false); 
		           }
		           }
	        	   }
			       );
 	    rdbtnLocalhost.setBounds(319, 37, 111, 23);
		contentPane.add(rdbtnLocalhost);
		
		//radio button sever 
		JRadioButton rdbtnServer = new JRadioButton("server");
	            	 rdbtnServer.addItemListener(new ItemListener() {
               	    @Override
	      		    public void itemStateChanged(ItemEvent event) {
       		        int state = event.getStateChange();
       		        if (state == ItemEvent.SELECTED) {
	            		 
	                // show ip when the button is selected
       		        	panel.setVisible(true);

      		        } else if (state == ItemEvent.DESELECTED) {
	            		 
	  	            // not show ip else when the button is deselected
      		        	panel.setVisible(false);
	            		 
       		        }
          		    }
            		}
	            	);
	            	  
		rdbtnServer.setBounds(319, 76, 111, 23);//the position in the contentPane 
		contentPane.add(rdbtnServer);

		
		//radio group
		ButtonGroup rGroup = new ButtonGroup();
		rGroup.add(rdbtnLocalhost);
		rGroup.add(rdbtnServer);
		
		
		
		
		
		
		setUpNetwork();

	}
	
	private void setUpNetwork()
	{
		mysend = new NetSend(this);
		sThread = new Thread(mysend);
		sThread.start();
			
	}
}