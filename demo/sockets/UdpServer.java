import java.net.*;
import java.io.*;

public class UdpServer {
    public static void main( String args[] ) {
	if ( args.length != 2 ) {
	    System.err.println( "usage: java UdpServer port size" );
	    return;
	}
	int port = Integer.parseInt( args[0] );
	int size = Integer.parseInt( args[1] );
	byte multiplier = 1;
	try {
	    // create a socket
	    DatagramSocket socket = new DatagramSocket( port );

	    while ( true ) {
		byte[] data = new byte[size];       // prepare a packet
		DatagramPacket packet               // create a packet
		    = new DatagramPacket( data, data.length );
		
		socket.receive( packet );           // receive data
		data = packet.getData( );
		for ( int i = 0; i < size; i++ )    // modify data
		    data[i] *= multiplier;
		packet.setData( data );

		socket.send( packet );              // send data

		multiplier++;
	    }

	} catch( Exception e ) {
	    e.printStackTrace( );
	}
    }
}
