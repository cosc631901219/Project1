package MSR;

import java.awt.EventQueue;

public class Reciever {
	
	private static RecieverScreen frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new RecieverScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public Reciever()
	{
	}
	
}