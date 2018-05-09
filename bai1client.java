package giuaky;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class bai1client {

	private JFrame frame;
	private JTextField so1;
	private JTextField so2;
	private JTextField kq;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bai1client window = new bai1client();
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
	public bai1client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Client");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblFirstNumber = new JLabel("First number");
		lblFirstNumber.setBounds(33, 32, 94, 14);
		frame.getContentPane().add(lblFirstNumber);
		
		JLabel lblSecondNumber = new JLabel("second number");
		lblSecondNumber.setBounds(33, 78, 94, 14);
		frame.getContentPane().add(lblSecondNumber);
		
		JLabel lblResultFromServer = new JLabel("result from server");
		lblResultFromServer.setBounds(33, 130, 94, 14);
		frame.getContentPane().add(lblResultFromServer);
		
		so1 = new JTextField();
		so1.setBounds(148, 29, 86, 20);
		frame.getContentPane().add(so1);
		so1.setColumns(10);
		
		so2 = new JTextField();
		so2.setBounds(148, 75, 86, 20);
		frame.getContentPane().add(so2);
		so2.setColumns(10);
		
		kq = new JTextField();
		kq.setBounds(148, 127, 86, 20);
		frame.getContentPane().add(kq);
		kq.setColumns(10);
		
		JButton btnSend = new JButton("send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Socket socketclient=new Socket("localhost",8016);
					int a=Integer.parseInt(so1.getText());
					int b=Integer.parseInt(so2.getText());
					DataOutputStream dout=new DataOutputStream(socketclient.getOutputStream());
					dout.writeBytes(a+"\n");
					dout.writeBytes(b+"\n");
					
					DataInputStream dis=new DataInputStream(socketclient.getInputStream());
					
					String tong = dis.readLine();
					kq.setText(tong);
					socketclient.close();
					dout.close();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println(e2.getMessage());
				}

			}
		});
		btnSend.setBounds(269, 78, 89, 23);
		frame.getContentPane().add(btnSend);
		
		JButton btnExit = new JButton("exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(269, 126, 89, 23);
		frame.getContentPane().add(btnExit);
	}
}
