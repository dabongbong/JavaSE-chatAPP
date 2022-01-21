package com.koreait.project0825.event4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatC extends JFrame implements KeyListener{
	JTextArea area;
	JScrollPane scroll;
	JTextField t_input;
	ChatA chatA; //null
	ChatB chatB;
	
	public ChatC() {
		//생성
		area = new JTextArea();
		scroll = new JScrollPane(area);
		t_input = new JTextField(15);
		
		
		//스타일 
		area.setPreferredSize(new Dimension(280, 320));
		area.setBackground(Color.GREEN);
		//조립
		setLayout(new FlowLayout());
		add(scroll);
		add(t_input);
		//윈도우 설정
		this.setBounds(800, 100, 300, 400);
		setVisible(true);
		
		t_input.addKeyListener(this);
	}
	
	//누군가에 의해 ChatA를 넘겨받을 수 있는 Setter메서드 정의.
	public void setChatA(ChatA chatA) {
		this.chatA = chatA;
	}
	public void setChatB(ChatB chatB ) {
		this.chatB = chatB;
	}
	public void keyPressed(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			//ChatA의 area에 입력값 대입.
			String msg = t_input.getText();
			chatA.area.append("ChatC : " + msg + "\n");
			chatB.area.append("ChatC : " + msg + "\n");
			
			this.area.append("ChatC : " + msg + "\n");
			t_input.setText("");
		}
	}
	
}
