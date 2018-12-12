package test5;
import java.io.*;
import java.net.*;
import java.util.*;

public class ChatHandler implements Runnable {

  protected Socket socket;
  protected ObjectInputStream dataIn;
  protected ObjectOutputStream dataOut;
  protected Thread listener;
  protected  Vector handlers = new Vector ();
  private   boolean  keepListening = true;

  public ChatHandler (Socket socket) {
    this.socket = socket;
  }

  public synchronized void start () {
    if (listener == null) {
      try {
        dataIn  = new ObjectInputStream(socket.getInputStream ());
        dataOut = new ObjectOutputStream(socket.getOutputStream ());

        listener = new Thread (this);
        listener.start ();
      }
      catch ( IOException ioException ) {
         ioException.printStackTrace();
    }
  }
 }

  public synchronized void stop () {
    if (listener != null) {
      try {
        if (listener != Thread.currentThread ())
          listener.interrupt ();
        listener = null;
        dataOut.close ();
        socket.close ();
      } catch (IOException ignored) {
      }
    }
  }

  public void run () {

    String message = "";
    try {
      handlers.addElement (this);
      while ( keepListening ) {
         message = (String)dataIn.readObject ();

           if (message.equals("DISCONNECT")) {
              dataOut.writeObject(message);
              dataOut.flush ();
              stopListening();
             }
           else
             broadcast(message);
      }

    } catch ( ClassNotFoundException classNotFoundException ) {
    }
      catch (EOFException ignored) {
    } catch (IOException ex) {
      if (listener == Thread.currentThread ())
        ex.printStackTrace ();
    } finally {
      handlers.removeElement (this);
    }

      try {
         dataIn.close();
      }

      catch ( IOException ioException ) {
         ioException.printStackTrace();
      }

    stop ();
  }

  protected void broadcast (String message) {
    synchronized (handlers) {
      Enumeration enumer = handlers.elements ();
      while (enumer.hasMoreElements ()) {
        ChatHandler handler = (ChatHandler) enumer.nextElement ();
        try {
          handler.dataOut.writeObject(message);
          handler.dataOut.flush ();
        } catch (IOException ex) {
          handler.stop ();
        }
      }
    }
  }


   public void stopListening()
   {
      keepListening = false;
   }
}
