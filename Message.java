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
		//field = s;
		//System.out.println(s);
		this.fromXML(s);
	}
	
	private void fromXML(String s)
	{
		int fIndex, rIndex;
		String temp;
		fIndex = s.indexOf("<");
		rIndex = s.indexOf(">");
		field = s.substring(fIndex+1, rIndex);
		fIndex = rIndex;
		rIndex = s.indexOf("<", fIndex);
		temp = s.substring(fIndex+1, rIndex);
		measurement = Double.valueOf(temp);
		//System.out.println(measurement);
	}
	
	public String getXML()
	{
		String myS = new String('<'+field+'>'+String.valueOf(measurement)+'<' +'/'+field+'>');
		return myS;
	}

	public double getMeasurement() {
		return measurement;
	}

	public void setMeasurement(double measurement) {
		this.measurement = measurement;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
}
