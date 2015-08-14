package xyz.offlinesheets.ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import xyz.offlinesheets.db.Datasheet;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private int resultheight = 73, margin = 15, top = 85;
	private int currResultsShown = 0;
	private Logger log = Logger.getLogger("DEBUG");
	// TODO: #01: Cleanup
	ResultPanel dummy1 = new ResultPanel();
	ResultPanel dummy2 = new ResultPanel();
	ResultPanel dummy3 = new ResultPanel();
	ResultPanel dummy4 = new ResultPanel();
	GroupLayout gl_contentPane;
	private List<JPanel> panes = new ArrayList<>();
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		//FIXME: LOW: Implement "Actual Handler"
		log.setLevel(Level.FINEST);
		log.addHandler(new Handler() {

			@Override
			public void publish(LogRecord record) {
				if(record.getLevel() != Level.SEVERE)
					System.out.printf("[%s]>%s: %s\n" , record.getSourceMethodName(), record.getSourceClassName().replaceAll("class ", ""), record.getMessage());
				else
					System.err.printf("[%s]>%s: %s\n" , record.getSourceMethodName(), record.getSourceClassName().replaceAll("class ", ""), record.getMessage());
			}

			@Override
			public void flush() {
				// TODO Auto-generated method stub

			}

			@Override
			public void close() throws SecurityException {
				// TODO Auto-generated method stub

			}
		});
		//TODO: #02: Cleanup
		panes.add(dummy1);
		panes.add(dummy2);
		panes.add(dummy3);
		panes.add(dummy4);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("OfflineSheets");
		setBounds(100, 100, 475, 336);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				inputKeyEvent(arg0);
			}
		});
		textField.setColumns(10);

		gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(textField, GroupLayout.DEFAULT_SIZE, 443,
																Short.MAX_VALUE)
														.addGap(10))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(dummy1, GroupLayout.PREFERRED_SIZE, 443,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(10, Short.MAX_VALUE))
						.addGroup(
								gl_contentPane.createSequentialGroup()
										.addComponent(dummy2, GroupLayout.PREFERRED_SIZE, 443,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(10, Short.MAX_VALUE))
						.addGroup(
								gl_contentPane.createSequentialGroup()
										.addComponent(dummy3, GroupLayout.PREFERRED_SIZE, 443,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(10, Short.MAX_VALUE))
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(dummy4, GroupLayout.PREFERRED_SIZE, 443,
																GroupLayout.PREFERRED_SIZE)
														.addContainerGap(10, Short.MAX_VALUE)))));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane
								.createParallelGroup(
										Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(dummy1, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(dummy2, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(dummy3, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(dummy4,
												GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(17, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * This is the Key-Typed event, it (will) fetch(es) the stored Datasheets in
	 * the CouchDB Database and will Display the Results in the UI, also linking
	 * MouseClicked-Handlers to the Results
	 * 
	 * @param arg0
	 */
	protected void inputKeyEvent(KeyEvent arg0) {
		// This is handling the Modifier-KeyPresses (which wont start a query)
		if ((arg0.isShiftDown() || arg0.isControlDown() || arg0.isAltDown() || arg0.isAltGraphDown())
				&& ((((arg0.getKeyCode() ^ 17) == 0) || (arg0.getKeyCode() ^ 18) == 0)
						|| (arg0.getKeyCode() ^ 16) == 0)) {
			log.logp(Level.FINEST, this.getClass().toString(), "inputKeyEvent", "Modifier but no key -not querying");
			return;
		}

		log.finest("[inputKeyEvent]: KeyPressEvent: (int)" + arg0.getKeyCode());
		// TODO: #00: QUERY FOR RESULTS

		// FIXME: #-1: Temporary Results
		List<Datasheet> results = new ArrayList<>();
		List<String> tags = new ArrayList<>();
		tags.add("IC");
		tags.add("GENERAL PURPOSE");
		results.add(new Datasheet("LM741", tags, new File(""), ""));
		results.add(new Datasheet("BC784", tags, new File(""), ""));
		results.add(new Datasheet("OPA133", tags, new File(""), ""));
		results.add(new Datasheet("REF01", tags, new File(""), ""));

		showResult(0, results.get(0));
		showResult(1, results.get(1));
		showResult(2, results.get(2));
		showResult(3, results.get(3));

	}

	public void showResult(int index, Datasheet result) {
		log.finest("[showResult]: Showing result at " + index);
		ResultPanel x = new ResultPanel(result, null);
		gl_contentPane.replace(panes.get(index), x);
		panes.set(index, x);
	}
}
