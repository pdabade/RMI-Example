package hello;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server implements Hello{

	/**
	 * @param args
	 */
	public Server() {}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println("Starting Server");
		    Server obj = new Server();
	 
		    Registry registry = LocateRegistry.createRegistry(2006);
	            System.out.println("Created registry");
	 
		    Hello stub = (Hello) UnicastRemoteObject.exportObject(obj, 0);
	            System.out.println("Exported Server");
	 
		    // Bind the remote object's stub in the registry
		    registry.rebind("Hello", stub);
	        System.out.println("Bound Server to \"Hello\"");
	 		
		}catch(Exception e)
		{
			System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
		}
		
	}

		public String sayHello() throws RemoteException {
		// TODO Auto-generated method stub
		return "Hello! :)";
	}

}
