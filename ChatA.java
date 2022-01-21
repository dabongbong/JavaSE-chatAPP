package com.koreait.project0825.event4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatA extends JFrame implements ActionListener, KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	JButton bt;
	ChatB chatB;
	ChatC chatC;
	
	public ChatA() {
		//생성
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(15);
		bt = new JButton("open");
		
		//스타일 
		area.setPreferredSize(new Dimension(280, 320));
		area.setBackground(Color.YELLOW);
		//조립
		setLayout(new FlowLayout());
		add(scroll);
		add(t_input);
		add(bt);
		//윈도우 설정
		this.setBounds(200, 100, 300, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//버튼과 리스너와의 연결
		bt.addActionListener(this);
		t_input.addKeyListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		//System.out.println("나 눌렀어?");
		
		//대화 상대방 띄우기
		if(chatB == null) {
			chatB = new ChatB();
			chatB.setChatA(this);
		}
		if(chatC == null) {
			chatC = new ChatC();
			chatC.setChatA(this);
		}
		chatB.setChatC(chatC);
		chatC.setChatB(chatB);
		
		
	}
	public void keyPressed(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			String msg = t_input.getText();//입력값 가져오기 
			//ChatA+B의 area에 출력하자!!
			chatC.area.append("ChatA : " + msg + "\n");
			chatB.area.append("ChatA : " + msg + "\n");
			this.area.append("ChatA : " + msg + "\n");
			t_input.setText("");
		}
	}
	public static void main(String[] args) {
		new ChatA();
	}
}
