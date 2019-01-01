package application;

public class ServerConfig {
	String serverIP ;
	int portNumber ;
	
	public ServerConfig(String IP,int port) {
		this.setServerIP(IP);
		this.setPortNumber(port);
	}
	public ServerConfig() {
		this.setServerIP("127.0.0.1");
		this.setPortNumber(32);
	
	}

	public String getServerIP() {
		return serverIP;
	}

	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(int portNumber) {
		this.portNumber = portNumber;
	}
	
}
