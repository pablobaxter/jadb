package se.vidstige.jadb;

import java.io.IOException;

public class AndroidDevice {
	private final String serial;
	private Transport transport;
	
	AndroidDevice(String serial, String type, Transport transport) {
		this.serial = serial;
		this.transport = transport;
	}	
	
	public String getSerial()
	{
		return serial;		
	}

	public String getStatus() throws IOException, JadbException {
		transport.send(getPrefix() +  "get-state");
		transport.verifyResponse();
		return transport.readString();
	}	
	
	private String getPrefix() {
		//return "host-serial:" + serial + ":";
		return "host-local:";
	}

	@Override
	public String toString()
	{
		return "Android Device with serial " + serial;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serial == null) ? 0 : serial.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AndroidDevice other = (AndroidDevice) obj;
		if (serial == null) {
			if (other.serial != null)
				return false;
		} else if (!serial.equals(other.serial))
			return false;
		return true;
	}
}
