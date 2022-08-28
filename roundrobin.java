package com.myfirstjava.program;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class roundrobin {
	//public static Socket[] servers = new Socket [3];
	public static int server_index = 0;
	public static void main(String args[]) {
		LinkedList<Socket> s = new LinkedList<Socket>();
	try {
			int portNumber = 5500;
			ServerSocket serverSocket = new ServerSocket(portNumber);
			Socket conn = serverSocket.accept();
			
			InputStream in = conn.getInputStream();
			OutputStream out = conn.getOutputStream();
			DataInputStream din=new DataInputStream(in);
			DataOutputStream dout=new DataOutputStream(out);
			
			s.add(new Socket("127.0.0.1",12345));
	  	    s.add(new Socket("127.0.0.1",5000));
			s.add(new Socket("127.0.0.1",4040));
			
			 server_index++;
				if (server_index >= s.size()) {
			    	server_index = 0;
				}
				Socket selected = s.get(server_index);
				
				//selected.out.writeInt(32);
				
				
			/*for (int i = 0; s.size() <= 3; i++) {
				 Socket ser = s.get(i);
				 servers[i] = ser;
			 }*/
			//System.out.println(s.size());
			//	System.out.println(servers);
			//create linkedlist to store the connections other servers
			//list.add(new Socket(!ip","port")
			//BufferedInputStream bin=new BufferedInputStream(in);
			//BufferedReader br = new BufferedReader(isr);
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}

