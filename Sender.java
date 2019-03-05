package MSR;

import java.awt.EventQueue;

public class Sender {
	private static SenderScreen frame;


	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SenderScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.out.println("test1");
		init();
		
	}
	
	private static void init()
	{
	}

}
