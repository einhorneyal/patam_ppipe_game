package pipeGame;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import server.ClientHandler;
import server.Server;

public class PipePraiorityMultiClientServer implements Server {
    static int TCP_SERVER_PORT = 38;
    private ServerSocket serverSocket;
    private boolean stop = false;
	private int counter = 0;
	
	
	
    public PipePraiorityMultiClientServer(int port) {
    	this.TCP_SERVER_PORT = port;
    	 
    }
    public PipePraiorityMultiClientServer() {
    	this.TCP_SERVER_PORT = 38;

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
        serverSocket = new ServerSocket(PipePraiorityMultiClientServer.TCP_SERVER_PORT);
        serverSocket.setSoTimeout(1000);
        //System.out.println("Server connected - waiting");
        while (!stop) {
            try {
                Socket aClient = serverSocket.accept();
                ExecutorService threadpool = Executors.newFixedThreadPool(10);
                ThreadPoolExecutor tpe =  new ThreadPoolExecutor(1, 5, 10, TimeUnit.SECONDS,
            			new PriorityBlockingQueue<Runnable>());
                if(aClient != null) 
                {
                    
					tpe.execute(new PipePriorityRunnable(aClient.getInputStream().available()) {
						@Override
						public void run() {
							try {
				                updateCounter();
			                	System.out.println(counter);
			                	clientHandler.handle(aClient.getInputStream(), aClient.getOutputStream());
								aClient.close();
								
				            } catch (IOException e) {
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
		Server s = new PipePraiorityMultiClientServer();
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
