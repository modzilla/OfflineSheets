package xyz.offlinesheets.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ResultPanel extends Panel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 185318332808351605L;
	private String name, desc;
	private ClickHandler ch;
	public ResultPanel(String partname, String description, ClickHandler onclick){
		super();
		this.name = partname;
		this.desc = description;
		this.ch = onclick;
		
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
		this.setPreferredSize(new Dimension(437,53));
		this.setVisible(true);
	}

	private void mouseEnter(){
		this.setBackground(Color.lightGray);
	}
	private void mouseLeave(){
		this.setBackground(Color.white);
	}
	

}
