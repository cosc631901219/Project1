package MSR;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class NetRecieve implements Runnable {
	 
    private DatagramSocket socket;
    private boolean running;
    private byte[] buf = new byte[256];
    private RecieverScreen myScreen;
 
    public NetRecieve(RecieverScreen mys) {
    	myScreen = mys;
        try {
			socket = new DatagramSocket(8675);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
    public void run() {
        running = true;
 
        while (running) {
        	//System.out.println("Making new temp packet");
            DatagramPacket packet 
              = new DatagramPacket(buf, buf.length);
            try {
				socket.receive(packet);
				//System.out.println("got packet");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
             
            /*InetAddress address = packet.getAddress();
            int port = packet.getPort();
            packet = new DatagramPacket(buf, buf.length, address, port);*/
            String received 
              = new String(packet.getData(), 0, packet.getLength());
            //myScreen.textField.setText(received);
            Message myMessage = new Message(received);
            //System.out.println(myMessage.getField());
            myScreen.updateDisplay(myMessage);
           
        }
        socket.close();
    }
}