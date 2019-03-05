package MSR;

// The basic format for a message that is self translatable from or to an XML string

public class Message {
	
	private double measurement;
	private String field;
	
	public Message(String s, double n)
	{
		field = s;
		measurement = n;
	}
	
	public Message(String s)
	{
		this.fromXML(s);
	}
	
	private void fromXML(String s)
	{
		String Left = s;
		int index = 0;
		while(index < Left.length()) // Please verify this logic in all future expansions
		{
			int temp;
			index = Left.indexOf('<',index);
			temp = Left.indexOf('>', index);
			field = Left.substring(index+1, temp-1);
			
			index = Left.indexOf('<', temp);
			String myMeas = Left.substring(temp+1, index);
			measurement = Double.parseDouble(myMeas);
			//Add more lines for checking for valid messages
					
		}
	}
	
	public String getXML()
	{
		String myS = new String('<'+field+'>'+String.valueOf(measurement)+'<' +'/'+field+'>');
		return myS;
	}
}
