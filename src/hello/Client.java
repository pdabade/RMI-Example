package hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
	Client() {}
	
	public static void main(String[] args)
	{
		String host = (args.length < 1)? null:args[0];
		try
		{
			Registry registry = LocateRegistry.getRegistry(host,2006);
			System.out.println("Registry located");
			Hello stub = (Hello)registry.lookup("Hello");
			System.out.println("Hello looked up");
			String response = stub.sayHello();
			System.out.println("Response : "+response);
		}catch(Exception e)
		{
			System.err.println("Client Exception : "+e);
			e.printStackTrace();
		}
	}

}
