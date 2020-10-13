package js8ri.ch01.ex05;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class RamdaUsage {


	public static void main(String[] args){
		    JFrame frame = new JFrame();
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.getContentPane().setLayout(new FlowLayout());
		    frame.getContentPane().add(createButton());
		    frame.getContentPane().add(createButtonWithRamda());
		    frame.pack();
		    frame.setVisible(true);
	}

	public static JButton createButton() {
		JButton button = new JButton("button1");
	    button.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	        System.out.println("button1 without ramda.");
	      }
	    });
		return button;
	}

	public static JButton createButtonWithRamda() {
	    JButton button = new JButton("button2");
	    button.addActionListener( (ActionEvent e) ->{
	      System.out.println("button2 with ramda.");
	     } );
		return button;
	}
}