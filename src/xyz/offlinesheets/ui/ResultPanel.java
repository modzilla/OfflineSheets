package xyz.offlinesheets.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import xyz.offlinesheets.db.Datasheet;

public class ResultPanel extends JPanel {

	private static final long serialVersionUID = 185318332808351605L;
	private String name, desc;
	private ResultClickedEvent ch;
	//FIXME: #01: Add Constructor without args
	
	public ResultPanel(Datasheet part, ResultClickedEvent e){
		super();
		this.name = part.getName();
		//TODO: #01: Implement Tag Concatting and Displaying
		this.desc = part.getTags().get(0);
		this.ch = e;
		
		this.setBackground(Color.WHITE);
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				mouseEnter();
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				mouseLeave();
			}
			@Override
			public void mouseClicked(MouseEvent arg0){
				ch.clicked();
			}
		});
		JLabel lblResultPart = new JLabel(name);		
		JLabel lblResultDesc = new JLabel(desc);
		
		GroupLayout gl_resultBox = new GroupLayout(this);
		
		gl_resultBox.setHorizontalGroup(
			gl_resultBox.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_resultBox.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_resultBox.createParallelGroup(Alignment.LEADING)
						.addComponent(lblResultDesc)
						.addComponent(lblResultPart))
					.addContainerGap(213, Short.MAX_VALUE))
		);
		gl_resultBox.setVerticalGroup(
			gl_resultBox.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_resultBox.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblResultPart)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblResultDesc)
					.addContainerGap())
		);
		lblResultPart.setVisible(true);
		lblResultDesc.setVisible(true);
		this.setLayout(gl_resultBox);
		this.setPreferredSize(new Dimension(443,53));
		this.setVisible(true);
		Border x = BorderFactory.createEtchedBorder();
		this.setBorder(x);
	
	}

	private void mouseEnter(){
		this.setBackground(Color.lightGray);
	}
	private void mouseLeave(){
		this.setBackground(Color.white);
	}
	public void setResult(Datasheet d){
		this.name = d.getName();
		//TODO: #01: Implement Tag Concatting and Displaying
		this.desc = d.getTags().get(0);
	}

	

}
