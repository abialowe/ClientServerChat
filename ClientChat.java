//Abi Lowe
//COSC 331
//Due: 04/23/17

package chat;

import java.io.*;
import java.net.*;
public class ClientChat
{
  private static Socket sock;

public static void main(String[] args) throws Exception
  {
     sock = new Socket("192.168.56.1", 3000);											// reads from keyboard with keyRead object
     BufferedReader keyRead = new BufferedReader(new InputStreamReader(System.in));	// sends to client with pwrite object
     OutputStream ostream = sock.getOutputStream(); 
     PrintWriter pwrite = new PrintWriter(ostream, true);							// receives from server receiveRead object
     InputStream istream = sock.getInputStream();
     BufferedReader receiveRead = new BufferedReader(new InputStreamReader(istream));
 
     System.out.println("Press 'Enter' to start the Chat!");
     System.out.println(sock + " is the IP address");
 
     String receiveMessage, sendMessage;               
     while(true)
     {
        sendMessage = keyRead.readLine();  // reads input from keyboard
        pwrite.println(sendMessage);       // sends message to server 
        pwrite.flush();                    // "flush" the data
        if((receiveMessage = receiveRead.readLine()) != null) //receive message from server
        {
            System.out.println(receiveMessage); // displaying at DOS prompt
            
        }         
      }               
    }                    
}   