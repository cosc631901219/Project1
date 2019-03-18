package MSR;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class RecieverScreen extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JTextField textMeasurment;
	private NetRecieve myRec;
	private Thread recThread;


	/**
	 * Create the frame.
	 */
	public RecieverScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(10, 11, 165, 52);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textMeasurment = new JTextField();
		textMeasurment.setEditable(false);
		textMeasurment.setBounds(10, 74, 165, 63);
		contentPane.add(textMeasurment);
		textMeasurment.setColumns(10);
		
		setupNet();
	}
	
	private void setupNet()
	{
		myRec = new NetRecieve(this);
		recThread = new Thread(myRec);
		recThread.start();
	}
	
	public void updateDisplay(Message myMessage)
	{
		//System.out.println("trying to update display");
		textField.setText(myMessage.getField());
		textMeasurment.setText(String.valueOf(myMessage.getMeasurement()));
	}
}
