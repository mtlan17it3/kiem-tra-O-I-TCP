package giuaky;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class bai1server {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai1server window = new bai1server();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public bai1server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Server");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnStart = new JButton("start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ServerSocket server=new ServerSocket(8016);
					server.getLocalPort();
					System.out.println("port already");
					Socket socketserver=server.accept();
					System.out.println("waiting");
					DataInputStream input=new DataInputStream(socketserver.getInputStream());
					String so1=input.readLine();
					String so2=input.readLine();
					int a=Integer.parseInt(so1);
					int b=Integer.parseInt(so2);
					int tong= a+b;
					DataOutputStream output=new DataOutputStream(socketserver.getOutputStream());
					output.writeBytes(String.valueOf(tong));

					input.close();
					output.close();
					socketserver.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}

			}
		});
		btnStart.setBounds(107, 104, 202, 23);
		frame.getContentPane().add(btnStart);
	}

}
