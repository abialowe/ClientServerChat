//Abi Lowe
//COSC 331
//Due: 04/23/17

package chat;

import java.io.*;
import java.net.*;
public class ServerChat 
{
  private static ServerSocket sersock;

public static void main(String[] args) throws Exception
  {
      sersock = new ServerSocket(3000);
      System.out.println("Server ready. Load Client Chat.");
      Socket sock = sersock.accept( );                          						// reads from keyboard with keyRead object
      BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in)); 	// sends back to client with pwrite object
      OutputStream ostream = sock.getOutputStream(); 
      PrintWriter pwrite = new PrintWriter(ostream, true); 								// receives from server with receiveRead object
      InputStream istream = sock.getInputStream();
      BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
      String receiveMessage, sendMessage;               
      while(true)
      {
        if((receiveMessage = receiveRead.readLine()) != null)  
        {
           System.out.println(receiveMessage);         
        }         
        sendMessage = keyRead.readLine(); 
        pwrite.println(sendMessage);             
        pwrite.flush();																	//flushes data 
      }               
    }                    
}                        
