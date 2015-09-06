package xyz.offlinesheets.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import xyz.offlinesheets.db.Datasheet;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Window.Type;

public class PDFrame extends JFrame implements Runnable {

	private static final long serialVersionUID = 7919839152546820119L;
	private JPanel contentPane;
	private Datasheet x;
	
	public PDFrame() {
		setType(Type.POPUP);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				try {
					Thread.currentThread().join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		setTitle("PDFrame");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNotYet = new JLabel("Not yet");
		contentPane.add(lblNotYet, BorderLayout.CENTER);
	}
	public PDFrame(Datasheet x){
		setTitle("PDFrame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNotYet = new JLabel(x.getName());
		contentPane.add(lblNotYet, BorderLayout.CENTER);
		this.x = x;
	}
	public static void showPDF(Datasheet x){

	}
	@Override
	public void run() {		
		PDFrame f = new PDFrame(x);
		f.setVisible(true);
	}

}
