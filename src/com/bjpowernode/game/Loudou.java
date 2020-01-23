package com.bjpowernode.game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Loudou extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	private int dijiguan;
	int remainTimes = 0; // ʱ��
	int x1 = 0;
	int y1 = 30;
	int x2 = 60;
	int y2 = 150;
	Thread nThread1;//�߳�
	JLabel overJLabel = new JLabel();
	JDialog dialog = new JDialog();

	public Loudou() {
		nThread1 = new Thread(this);				
		nThread1.start();
		this.setLayout(null);
		this.add(overJLabel);
		overJLabel.setBounds(0, 0, 200, 50);
		overJLabel.setForeground(Color.white);
	}

	public void setdijiguan(int x) {
		this.dijiguan = x;
	}

	public void paintComponent(Graphics g) // ��������
	{
		super.paintComponent(g);
						
		g.setColor(Color.green);
		for (int i = 0; i < 56; i++) {
			g.drawLine(x1 + i / 2 + 2, y1 + i, x2 - i / 2 - 2, y1 + i);
		}
		
		if (remainTimes < 55) {
			for (int i = 0; i < remainTimes; i++) {
				g.drawLine(x1 + i / 2 + 2, y2 - i - 1, x2 - i / 2 - 2, y2 - i
						- 1);
			}
			g.drawLine((x1 + x2) / 2, (y1 + y2) / 2, (x1 + x2) / 2, y2 - 2);
			g.drawLine((x1 + x2) / 2 + 1, (y1 + y2) / 2 + 1, (x1 + x2) / 2 + 1,y2 - 2);//��������
			g.setColor(getBackground());
			for (int i = 0; i < remainTimes; i++) {
				g.drawLine(x1 + i / 2 + 2, y1 + i, x2 - i / 2 - 2, y1 + i);//�����ϱߵĵ�����
			}
		}
		if (remainTimes >= 50 && remainTimes <= 55)
			overJLabel.setText(55-remainTimes +"s");
		
		if (remainTimes == 56) 
			overJLabel.setText("OVER");
	}

	public void setTimes(int x) {
		this.remainTimes = x;
	}

	public int getTimes() {
		return remainTimes;
	}

	public void run() {
		while (dijiguan < 20) {
			if (remainTimes == 0) {
				JOptionPane.showMessageDialog(null, "��Ϸ��ʼ��");
			}
			if (remainTimes == 56) {
				JOptionPane.showMessageDialog(null, "ʱ�䵽����Ϸ������");
			}
			
			remainTimes++;
			repaint();
			
			try {
				if (dijiguan < 6)
					Thread.sleep(1500 - dijiguan * 100);
				if (dijiguan >= 6 && dijiguan <= 8)
					Thread.sleep(1000 - (dijiguan - 5) * 50);
				if (dijiguan > 8)
					Thread.sleep(850 - (dijiguan - 8) * 20);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

