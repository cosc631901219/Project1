package MSR;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

@SuppressWarnings("serial")
public class SenderScreen extends JFrame {

	private JPanel contentPane;
	public JTextField txtField;
	private JTextField textMeasurment;
	public JSlider slider;
	public NetSend mysend;
	private Thread sThread;

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
		
		setUpNetwork();

	}
	
	private void setUpNetwork()
	{
		mysend = new NetSend(this);
		sThread = new Thread(mysend);
		sThread.start();
			
	}
}
