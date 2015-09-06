package xyz.offlinesheets.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.Border;

import xyz.offlinesheets.db.Datasheet;
import xyz.offlinesheets.log.Log;

public class ResultPanel extends JPanel {

	private static final long serialVersionUID = 185318332808351605L;
	private Datasheet d;
	private ResultClickedEvent ch;
	//FIXME: #01: Add Constructor without args
	public ResultPanel(){
		init(true,false);
	}
	public ResultPanel(Datasheet part, ResultClickedEvent e){
		super();
		d = part;
		this.ch = e;		
		init(false, e != null ? true : false);
	}
	public void init(boolean blank,boolean haskey){
		this.setBackground(Color.WHITE);
		if(haskey)
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				ch.clicked();
			}
		});
		this.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseEntered(MouseEvent arg0) {
				mouseEnter();
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				mouseLeave();
			}
		});
		JLabel lblResultPart = new JLabel("");		
		JLabel lblResultDesc = new JLabel("");
		if(!blank){
		lblResultPart = new JLabel(d.getName());		
		lblResultDesc = new JLabel(concatTags(d.getTags()));		
		}

		
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
		this.setVisible(!blank);
		Border x = BorderFactory.createEtchedBorder();
		this.setBorder(x);
	}

	private void mouseEnter(){
		this.setBackground(Color.lightGray);
	}
	private void mouseLeave(){
		this.setBackground(Color.white);
	}
	public void setDatasheet(Datasheet d){
		this.d = d;
	}
	public Datasheet getDatasheet(){
		return d;		
	}
	public void setClickHandler(ResultClickedEvent e){
		this.ch = e;
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e){}			
			@Override
			public void mousePressed(MouseEvent e){}			
			@Override
			public void mouseExited(MouseEvent e){}			
			@Override
			public void mouseEntered(MouseEvent e){}			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				Log.finest("Pane clicked");
				ch.clicked();
			}
		});
			
	}
	private String concatTags(List<String> tags){
		String r = "";
		for(String x : tags)
			if(!tags.get(tags.size()-1).equalsIgnoreCase(x))
				r += x + "; ";
			else
				r += x;		
		return r;
	}

	

}
