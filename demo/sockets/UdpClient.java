import java.net.*;
import java.io.*;

public class UdpClient {
    public static void main( String args[] ) {
	if ( args.length != 3 ) {
	    System.err.println( "usage: java UdpClient port size server_ip" );
	    return;
	}
	int port = Integer.parseInt( args[0] );
	int size = Integer.parseInt( args[1] );
	try {
	    // create a socket
	    DatagramSocket socket = new DatagramSocket( port );

	    byte[] data = new byte[size];       // initialize data
	    for ( int i = 0; i < size; i++ )
		data[i] = ( byte )( i % 128 );

	    DatagramPacket packet               // create a packet
		= new DatagramPacket( data, data.length,
				      InetAddress.getByName( args[2] ), port );

	    socket.send( packet );              // send data
	    socket.receive( packet );           // receive data               
	    data = packet.getData( );
	    for ( int i = 0; i < size; i++ )    // print results
		System.out.println( data[i] );

	    socket.close( );                    // close the connection
	} catch( Exception e ) {
	    e.printStackTrace( );
	}
    }
}
