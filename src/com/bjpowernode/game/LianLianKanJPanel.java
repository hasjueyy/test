package com.bjpowernode.game;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class LianLianKanJPanel extends JPanel implements ActionListener,ItemListener {

	private static final long serialVersionUID = 1L;//���л�ʱΪ�˱��ְ汾�ļ����ԣ����ڰ汾����ʱ�����л��Ա��ֶ����Ψһ�ԡ�
		private int[][] map = new int[8][8];//8*8��������
		private int kind, randomx, randomy, randomx1, randomy1; // ���࣬���x
		private int coordinatex, coordinatey, coordinatex1, coordinatey1; // ����X
		private Point lineStart = new Point(0, 0);
		private int clicktimes;
		private int jishushengyu;//����ʣ��
		private int Kinds = 4;
		private int score;
		private int guanshu;//����

		
		Loudou ld = new Loudou();// ©��
		

		JButton BlockButton[][] = new JButton[8][8];//
		Choice difficultChoice = new Choice();
		JButton newgameButton = new JButton("���¿�ʼ");
		JButton reLoad = new JButton("ˢ��");

		ImageIcon ii = new ImageIcon("src/im/bk.jpg");

		ImageIcon aIcon = new ImageIcon("src/im/1.gif");
		ImageIcon bIcon = new ImageIcon("src/im/2.gif");
		ImageIcon cIcon = new ImageIcon("src/im/3.gif");
		ImageIcon dIcon = new ImageIcon("src/im/4.gif");
		ImageIcon eIcon = new ImageIcon("src/im/5.gif");
		ImageIcon fIcon = new ImageIcon("src/im/6.gif");
		ImageIcon gIcon = new ImageIcon("src/im/7.gif");
		ImageIcon hIcon = new ImageIcon("src/im/8.gif");
		ImageIcon iIcon = new ImageIcon("src/im/9.gif");
		ImageIcon jIcon = new ImageIcon("src/im/10.gif");
		ImageIcon kIcon = new ImageIcon("src/im/11.gif");
		ImageIcon lIcon = new ImageIcon("src/im/12.gif");
		ImageIcon mIcon = new ImageIcon("src/im/13.gif");
		ImageIcon nIcon = new ImageIcon("src/im/14.gif");
		ImageIcon oIcon = new ImageIcon("src/im/15.gif");

		public LianLianKanJPanel() {

			this.setLayout(null);

			newMap();
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					BlockButton[i][j] = new JButton();
					add(BlockButton[i][j]);
					BlockButton[i][j].addActionListener(this);//������
					BlockButton[i][j].setBounds(30 + j * 40, 30 + i * 40, 31,34);
				//	BlockButton[i][j].setBorderPainted(false);
				//  BlockButton[i][j].setVisible(true);
				}
			}
			difficultChoice.add("��");
			difficultChoice.add("�е�");
			difficultChoice.add("����");
			difficultChoice.add("��̬");

			newgameButton.setBounds(map[0].length * 40 + 80, 40, 100, 20);
			newgameButton.setBackground(Color.white);
			newgameButton.setBorderPainted(false); //ȥ�߿�
			reLoad.setBounds(map[0].length * 40 + 100, 80, 60, 20);
			reLoad.setBackground(Color.white);
			reLoad.setBorderPainted(false);
			difficultChoice.setBounds(map[0].length * 40 + 100, 120, 60, 20);
			difficultChoice.addItemListener(this);
			newgameButton.addActionListener(this);
			reLoad.addActionListener(this);

			this.add(newgameButton);
			this.add(reLoad);
			this.add(difficultChoice);

			// /-------------------------©��
			ld.setBounds(map[0].length * 40 + 100, 200, 70, 150);// ©��
			ld.setBackground(Color.black);
			this.add(ld);
	

		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			//�Ǹ���JPanel��ķ���,�����������ñ���ɫ�ػ�һ��,������������

			g.drawImage(ii.getImage(), 0, 0, this);
			//���������ı��ַ���
			g.setColor(Color.white);
			g.drawString("�÷�: " + score, 430, 165);
			g.drawString("�� " + (guanshu + 1) + " ��", 430, 190);
			
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					switch (map[i][j]) {
					case 0:
						
						BlockButton[i][j].setVisible(false);
						break;
					case 1:
						BlockButton[i][j].setIcon(aIcon);
						break;
					case 2:
						BlockButton[i][j].setIcon(bIcon);
						break;
					case 3:
						BlockButton[i][j].setIcon(cIcon);
						break;
					case 4:
						BlockButton[i][j].setIcon(dIcon);
						break;
					case 5:
						BlockButton[i][j].setIcon(eIcon);
						break;
					case 6:
						BlockButton[i][j].setIcon(fIcon);
						break;
					case 7:
						BlockButton[i][j].setIcon(gIcon);
						break;
					case 8:
						BlockButton[i][j].setIcon(hIcon);
						break;
					case 9:
						BlockButton[i][j].setIcon(iIcon);
						break;
					case 10:
						BlockButton[i][j].setIcon(jIcon);
						break;
					case 11:
						BlockButton[i][j].setIcon(kIcon);
						break;
					case 12:
						BlockButton[i][j].setIcon(lIcon);
						break;
					case 13:
						BlockButton[i][j].setIcon(mIcon);
						break;
					case 14:
						BlockButton[i][j].setIcon(nIcon);
						break;
					case 15:
						BlockButton[i][j].setIcon(oIcon);
						break;
					default:
						break;
					}

				}

			}

		}
		//����
		public void chongzai() {  
			jishushengyu = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (map[i][j] > 0) {
						jishushengyu++;
					}
				}
			}

			int[][] map1 = new int[8][8];
			this.map = map1;
			Random random = new Random();

			for (int i = 0; i < jishushengyu / 2; i++) {
				kind = random.nextInt(Kinds) + 1;//0��3+1  === 1��4
				do {				
					randomx1 = random.nextInt(8);//0-8�����
					randomy1 = random.nextInt(8);
				} while (map[randomy1][randomx1] > 0);

				map[randomy1][randomx1] = kind;
				
				do {
					randomx = random.nextInt(8);
					randomy = random.nextInt(8);
				} while (map[randomy][randomx] > 0);

				map[randomy][randomx] = kind;
				
			}
			
			repaint();
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					
					BlockButton[i][j].setVisible(true);
				}
			}
			
			
		}

		public void newGame() {

			// JOptionPane.showMessageDialog(null,"�㰴�˿�ʼ��ť");
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					BlockButton[i][j].setEnabled(true);
					BlockButton[i][j].setVisible(true);
				}
			}
			int[][] map = new int[8][8];
			this.map = map;
			newMap();
			ld.setTimes(0);
			score = 0;
			guanshu = 0;
			ld.setdijiguan(guanshu);
		}

		public void guoguan() {
			int jishushengyu2 = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (map[i][j] > 0) {
						jishushengyu2++;
					}
				}
			}
			if (jishushengyu2 == 0) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						BlockButton[i][j].setEnabled(true);
						BlockButton[i][j].setVisible(true);
					}
				}
				int[][] map = new int[8][8];
				this.map = map;
				newMap();
				
				ld.setTimes(0);
				guanshu++;
				ld.setdijiguan(guanshu);
				reLoad.setEnabled(true);
			}

		}

		public void newMap() {
			ArrayList<Integer> numbers = new ArrayList<Integer>();//����
			for (int i = 0; i < Kinds; i++) {
				numbers.add(i + 1);//�ӵ��б�β��
				numbers.add(i + 1);
			}//ÿһ�����²��ֵ�ʱ���ܱ�֤һ����ǰ�����Ѷ��е�ͼƬ����
			
			Random random = new Random();
			int temp = 0;
			for (int i = 0; i < 32- Kinds; i++) {
				temp = random.nextInt(Kinds) + 1;//0~kinds-1֮���������ڼ�1
				numbers.add(temp);
				numbers.add(temp);

			}
			Collections.shuffle(numbers);//�������ԭ����˳��
			map = new int[8][8];
			temp = 0;

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					//JOptionPane.showMessageDialog(null, numbers.get(temp));
					map[i][j] = numbers.get(temp++).intValue();//get�������ص�i��Ԫ�أ�intvalue ����int����
					
				}

			}

		}

		public void itemStateChanged(ItemEvent e) {
			// TODO �Զ����ɵķ������
			if (e.getSource() == difficultChoice) {
				String selected = difficultChoice.getSelectedItem();
				if (selected == "��") {
					Kinds = 4;
					newGame();
					repaint();
				} else if (selected == "�е�") {
					Kinds = 8;
					newGame();
					repaint();
				} else if (selected == "����") {
					Kinds = 12;
					newGame();
					repaint();
				} else if (selected == "��̬") {
					Kinds = 15;
					newGame();
					repaint();
				}
			}
		}

		public void actionPerformed(ActionEvent e) {
			// TODO �Զ����ɵķ������
			
			if (ld.getTimes() >56) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						BlockButton[j][i].setEnabled(false);
					}
				}
			}
			if (e.getSource() == reLoad) {
				chongzai();
				reLoad.setEnabled(false);
			}
			if (e.getSource() == newgameButton) {
				newGame();
				reLoad.setEnabled(true);
			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (e.getSource() == BlockButton[j][i]) {
						clicktimes++; // ����Ĵ���
						lineStart.move(i, j);
						if (clicktimes % 2 == 1) {
							coordinatex1 = i;
							coordinatey1 = j;
							BlockButton[coordinatey1][coordinatex1].setEnabled(false);
							BlockButton[coordinatey][coordinatex].setEnabled(true);

						//	BlockButton[j][i].setEnabled(false);
						}
						if (clicktimes % 2 == 0) {
							
							coordinatex = i;
							coordinatey = j;
							BlockButton[coordinatey][coordinatex].setEnabled(false);
							BlockButton[coordinatey1][coordinatex1].setEnabled(true);
						}
					}

				}
			}

			this.requestFocus();
			clearBlock();

			/*
			 * for (int i = 0; i < 8; i++) { for (int j = 0; j < 8; j++) {
			 * BlockButton[j][i].setEnabled(true); }
			 * 
			 * }
			 */

			repaint();

		}

		// --------------------------------------------------------------------------
		// �ж���һ��֮����ͼƬ֮���Ƿ�ȫ���ǿհ׻�ֱ������
		private boolean containsAllOrNoneZeroInColumn(int posX1, int posY1,
				int posX2, int posY2) {
			// ֱ������,����������հ�
			if (Math.abs(posY1 - posY2) == 0) {
				return true;
			}
			int a = posY1 < posY2 ? posY1 : posY2;
			int b = posY1 < posY2 ? posY2 : posY1;//yֵ:aС b��
			for (int j = a + 1; j < b; j++) {
				if (map[posX1][j] != 0) {
					return false;
				}
			}
			return true;
		}

		// �ж���һ��֮����ͼƬ֮���Ƿ�ȫ���ǿհ׻�ֱ������
		private boolean containsAllOrNoneZeroInRow(int posX1, int posY1,
				int posX2, int posY2) {
			// ֱ������,����������հ�
			if (Math.abs(posX1 - posX2) == 0) {
				return true;
			}
			int a = posX1 < posX2 ? posX1 : posX2;
			int b = posX1 < posX2 ? posX2 : posX1;
			for (int i = a + 1; i < b; i++) {
				if (map[i][posY1] != 0) {
					return false;
				}
			}
			return true;
		}

		// �Ƿ����һֱ������
		private boolean isLinkByOneLine(int posX1, int posY1, int posX2,
				int posY2) {

			if (posX1 != posX2 && posY1 != posY2) {
				return false;
			}
			if (posX1 == posX2) {
				if (containsAllOrNoneZeroInColumn(posX1, posY1, posX2, posY2)) {
					return true;
				}
			}
			if (posY1 == posY2) {
				if (containsAllOrNoneZeroInRow(posX1, posY1, posX2, posY2)) {
					return true;
				}
			}
			return false;
		}

		// �Ƿ������ֱ������
		private boolean isLinkByTwoLines(int posX1, int posY1, int posX2,
				int posY2) {
			if (posX1 != posX2 && posY1 != posY2) {
				// x1,y1 to x2,y1 to x2,y2
				if (containsAllOrNoneZeroInRow(posX1, posY1, posX2, posY1)
						&& map[posX2][posY1] == 0
						&& containsAllOrNoneZeroInColumn(posX2, posY1, posX2,
								posY2)) {
					return true;
				}
				// x1,y1 to x1,y2 to x2,y2
				if (containsAllOrNoneZeroInColumn(posX1, posY1, posX1, posY2)
						&& map[posX1][posY2] == 0
						&& containsAllOrNoneZeroInRow(posX1, posY2, posX2,
								posY2)) {
					return true;
				}

			}
			return false;
		}

		// �Ƿ������ֱ������
		private boolean isLinkByThreeLines(int posX1, int posY1, int posX2,
				int posY2) {
			if (isOnSameEdge(posX1, posY1, posX2, posY2)) {
				return true;
			}
			if (isOnThreeLinesLikeArc(posX1, posY1, posX2, posY2)) {
				return true;
			}
			if (isOnThreeLinesLikeZigzag(posX1, posY1, posX2, posY2)) {
				return true;
			}
			return false;
		}

		// �Ƿ������ֱ������,��U��
		private boolean isOnThreeLinesLikeArc(int posX1, int posY1, int posX2,
				int posY2) {
			if (isOnUpArc(posX1, posY1, posX2, posY2)) {
				return true;
			}
			if (isOnDownArc(posX1, posY1, posX2, posY2)) {
				return true;
			}
			if (isOnLeftArc(posX1, posY1, posX2, posY2)) {
				return true;
			}
			if (isOnRightArc(posX1, posY1, posX2, posY2)) {
				return true;
			}
			return false;
		}

		// ��
		private boolean isOnUpArc(int posX1, int posY1, int posX2, int posY2) {
			// Y --> 0
			int lessY = posY1 < posY2 ? posY1 : posY2; //��Сy
			for (int j = lessY - 1; j >= 0; j--) {
				if (containsAllOrNoneZeroInRow(posX1, j, posX2, j)
						&& containsAllOrNoneZeroInColumn(posX1, posY1, posX1, j)
						&& containsAllOrNoneZeroInColumn(posX2, posY2, posX2, j)
						&& map[posX1][j] == 0 && map[posX2][j] == 0) {
					return true;
				}
			}

			if (isOnSameEdge(posX1, 0, posX2, 0)
					&& containsAllOrNoneZeroInColumn(posX1, posY1, posX1, 0)
					&& containsAllOrNoneZeroInColumn(posX2, posY2, posX2, 0)
					&& (map[posX1][0] == 0 && map[posX2][0] == 0
							|| map[posX1][0] == 0
							&& map[posX2][0] == map[posX2][posY2] || map[posX1][0] == map[posX1][posY1]
							&& map[posX2][0] == 0)) {
				return true;
			}

			return false;
		}

		// ��
		private boolean isOnDownArc(int posX1, int posY1, int posX2, int posY2) {
			int moreY = posY1 < posY2 ? posY2 : posY1;
			for (int j = moreY + 1; j <= 8 - 1; j++) {
				if (containsAllOrNoneZeroInRow(posX1, j, posX2, j)
						&& containsAllOrNoneZeroInColumn(posX1, posY1, posX1, j)
						&& containsAllOrNoneZeroInColumn(posX2, posY2, posX2, j)
						&& map[posX1][j] == 0 && map[posX2][j] == 0) {
					return true;
				}
			}
			if (isOnSameEdge(posX1, 8 - 1, posX2, 8 - 1)
					&& containsAllOrNoneZeroInColumn(posX1, posY1, posX1, 8 - 1)
					&& containsAllOrNoneZeroInColumn(posX2, posY2, posX2, 8 - 1)
					&& (map[posX1][8 - 1] == 0 && map[posX2][8 - 1] == 0
							|| map[posX1][8 - 1] == map[posX1][posY1]
							&& map[posX2][8 - 1] == 0 || map[posX1][8 - 1] == 0
							&& map[posX2][8 - 1] == map[posX2][posY2])) {
				return true;
			}
			return false;
		}

		// �w
		private boolean isOnLeftArc(int posX1, int posY1, int posX2, int posY2) {
			int lessX = posX1 < posX2 ? posX1 : posX2;
			for (int i = lessX - 1; i >= 0; i--) {
				if (containsAllOrNoneZeroInColumn(i, posY1, i, posY2)
						&& containsAllOrNoneZeroInRow(i, posY1, posX1, posY1)
						&& containsAllOrNoneZeroInRow(i, posY2, posX2, posY2)
						&& map[i][posY1] == 0 && map[i][posY2] == 0) {
					return true;
				}
			}

			if (isOnSameEdge(0, posY1, 0, posY2)
					&& containsAllOrNoneZeroInRow(0, posY1, posX1, posY1)
					&& containsAllOrNoneZeroInRow(0, posY2, posX2, posY2)
					&& (map[0][posY1] == 0 && map[0][posY2] == 0
							|| map[0][posY1] == map[posX1][posY1]
							&& map[0][posY2] == 0 || map[0][posY1] == 0
							&& map[0][posY2] == map[posX2][posY2])) {
				return true;
			}

			return false;
		}

		// ��
		private boolean isOnRightArc(int posX1, int posY1, int posX2, int posY2) {
			int moreX = posX1 < posX2 ? posX2 : posX1;
			for (int i = moreX + 1; i <= 8 - 1; i++) {
				if (containsAllOrNoneZeroInColumn(i, posY1, i, posY2)
						&& containsAllOrNoneZeroInRow(i, posY1, posX1, posY1)
						&& containsAllOrNoneZeroInRow(i, posY2, posX2, posY2)
						&& map[i][posY1] == 0 && map[i][posY2] == 0) {
					return true;
				}
			}

			if (isOnSameEdge(8 - 1, posY1, 8 - 1, posY2)
					&& containsAllOrNoneZeroInRow(posX1, posY1, 8 - 1, posY1)
					&& containsAllOrNoneZeroInRow(posX2, posY2, 8 - 1, posY2)
					&& (map[8 - 1][posY1] == 0 && map[8 - 1][posY2] == 0
							|| map[8 - 1][posY1] == map[posX1][posY1]
							&& map[8 - 1][posY2] == 0 || map[8 - 1][posY1] == 0
							&& map[8 - 1][posY2] == map[posX2][posY2])) {
				return true;
			}

			return false;
		}

		// �Ƿ������ֱ������,��֮����N
		private boolean isOnThreeLinesLikeZigzag(int posX1, int posY1,
				int posX2, int posY2) {
			if (isOnZigzagWith1Row2Cols(posX1, posY1, posX2, posY2)) {
				return true;
			}
			if (isOnZigzagWith2Rows1Col(posX1, posY1, posX2, posY2)) {
				return true;
			}

			return false;
		}

		// �Ƿ������ֱ������,��֮����, ����һ�� Z
		private boolean isOnZigzagWith2Rows1Col(int posX1, int posY1,
				int posX2, int posY2) {
			int moreX = posX1 < posX2 ? posX2 : posX1;
			int lessX = posX1 < posX2 ? posX1 : posX2;
			for (int i = lessX + 1; i < moreX; i++) {
				if (containsAllOrNoneZeroInColumn(i, posY1, i, posY2)
						&& containsAllOrNoneZeroInRow(i, posY1, posX1, posY1)
						&& containsAllOrNoneZeroInRow(i, posY2, posX2, posY2)
						&& map[i][posY1] == 0 && map[i][posY2] == 0) {
					return true;
				}
			}
			return false;
		}

		// �Ƿ������ֱ������,��֮����, һ������
		private boolean isOnZigzagWith1Row2Cols(int posX1, int posY1,
				int posX2, int posY2) {
			int moreY = posY1 < posY2 ? posY2 : posY1;
			int lessY = posY1 < posY2 ? posY1 : posY2;
			for (int j = lessY + 1; j < moreY; j++) {
				if (containsAllOrNoneZeroInRow(posX1, j, posX2, j)
						&& containsAllOrNoneZeroInColumn(posX1, posY1, posX1, j)
						&& containsAllOrNoneZeroInColumn(posX2, posY2, posX2, j)
						&& map[posX1][j] == 0 && map[posX2][j] == 0) {
					return true;
				}
			}
			return false;
		}

		// �Ƿ�����Ϸ�����4���ߵ�ͬһ����
		private boolean isOnSameEdge(int posX1, int posY1, int posX2, int posY2) {
			if ((posY1 == posY2 && posY2 == 0)
					|| (posY1 == posY2 && posY2 == 8 - 1)
					|| (posX1 == posX2 && posX2 == 0)
					|| (posX1 == posX2 && posX2 == 8 - 1)) {
				return true;
			}

			return false;
		}

		// --------------------------------------------------------------------------
		public boolean ifcanTouch(int posX1, int posY1, int posX2, int posY2) {

			if (isLinkByOneLine(posX1, posY1, posX2, posY2)) {
				return true;
			}
			// �Ƿ������ֱ������
			if (isLinkByTwoLines(posX1, posY1, posX2, posY2)) {
				return true;
			}
			// �Ƿ������ֱ������
			if (isLinkByThreeLines(posX1, posY1, posX2, posY2)) {
				return true;
			}

			return false;

		}

		public void clearBlock() {
			if (clicktimes >=2) {
			
				if (map[coordinatey1][coordinatex1] == map[coordinatey][coordinatex]
						&& !((coordinatex1 == coordinatex) && (coordinatey1 == coordinatey))) {
					
					if (ifcanTouch(coordinatey1, coordinatex1, coordinatey,
							coordinatex)) {
						
						if (map[coordinatey1][coordinatex1] > 0)
							score = score + 10;
						
						map[coordinatey1][coordinatex1] = 0;
						map[coordinatey][coordinatex] = 0;
						guoguan();
					}
				}
			}
		}
	}

