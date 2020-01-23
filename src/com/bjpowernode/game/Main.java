package com.bjpowernode.game;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	public Main() {
		LianLianKanJPanel llk = new LianLianKanJPanel();
		add(llk);

	}
	
	public static void main(String[] args) {
		
	String lookAndFeel ="javax.swing.plaf.metal.MetalLookAndFeel";//swing 外观和感觉
		try {
			UIManager.setLookAndFeel(lookAndFeel);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Main frame = new Main();
		frame.setTitle("连连看");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 560, 430);
		frame.setLocation(440, 100);
//		frame.setSize(600, 500);
		frame.setSize(540, 440);
		frame.setVisible(true);

	}

}

