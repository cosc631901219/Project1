package MSR;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class NetSend implements Runnable{

	private DatagramSocket socket;
	private InetAddress address;
	private byte[] buf;
	private SenderScreen frame;
	private Message myMessage;
	
	public NetSend(SenderScreen f)
	{
		System.out.println("test4");
		try {
			socket = new DatagramSocket();
		} catch (SocketException e) {
			System.out.println("Error getting Datagram Socket");
			e.printStackTrace();
		}
        try {
			address = InetAddress.getByName("localhost");
		} catch (UnknownHostException e) {
			System.out.println("Error getting IP");
			e.printStackTrace();
		}
        frame = f;
	}
	
	public void SendMessage(String msg)
	{
		buf = msg.getBytes();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 8675);
		try {
			socket.send(packet);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		System.out.println("Test3");
		while(true)
		{
			myMessage = new Message(frame.txtField.getText(), frame.slider.getValue());
			SendMessage(myMessage.getXML());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	

}
