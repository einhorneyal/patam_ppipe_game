package pipeGame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import server.ClientHandler;
import server.Server;

public class PipeSimpleServerExecutor implements Server {
    static int TCP_SERVER_PORT = 32;
    private ServerSocket serverSocket;
    private boolean stop = false;
	private int counter = 0;

    public PipeSimpleServerExecutor(int port) {
    	this.TCP_SERVER_PORT = port;
    }
    public PipeSimpleServerExecutor() {
    	this.TCP_SERVER_PORT = 32;
    }
    
    
    @Override
    public void start(ClientHandler clientHandler){
    	new Thread(() -> {
            try {
                startServer(clientHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    
	}
    
    private void startServer(ClientHandler clientHandler) throws IOException {
        serverSocket = new ServerSocket(PipeSimpleServerExecutor.TCP_SERVER_PORT);
        serverSocket.setSoTimeout(1000);
        //System.out.println("Server connected - waiting");
        while (!stop) {
            try {
                Socket aClient = serverSocket.accept();
                ExecutorService threadpool = Executors.newFixedThreadPool(10);
                if(aClient != null) 
                {
                    //System.out.println("client connected");
                    threadpool.submit(new Runnable() {
    					
    					@Override
    					public void run() {
    						
    						try {
    							System.out.println(counter);
    							updateCounter();
    							clientHandler.handle(aClient.getInputStream(), aClient.getOutputStream());
    							aClient.close();
    							
    						} catch (IOException e) {
    							// TODO Auto-generated catch block
    							e.printStackTrace();
    						}
    						
    					}
    				});
                }
                
                
                
            } catch (SocketTimeoutException e) {
//                //System.out.println("Client did not connect...");
            }
        }
        serverSocket.close();
    }

	@Override
	public synchronized void stop() {
		stop=true;
	}

	public synchronized void updateCounter() 
	{
		this.counter++;
	}
	
	public static void main(String[] args)
	{
		Server s = new PipeSimpleServerExecutor();
		s.start(new PipeSimpleClientHandler());
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
        s.stop();
        //System.out.println("Closed server");
	}
}
