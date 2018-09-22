package java_socket;


import java.awt.*;
import java.io.*;
import java.net.*;
import java.nio.channels.ScatteringByteChannel;

import javax.swing.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class ServerForm extends JFrame implements ActionListener {

	public int port = 9110;

	// 申明变量
	JLabel labelPort;
	JTextField txtPort;
	JButton buttonStart;
	JButton buttonDisconnect;
	JLabel label;
	TextArea textMain;

	JLabel imagePos;

	// ************************************设置登陆窗口方法***********************************
	public ServerForm() {

		this.setTitle("聊天室服务器端控制窗口");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font myfont = new Font("宋体", Font.PLAIN, 12);

		// 设置标签
		labelPort = new JLabel("端口号：");
		labelPort.setFont(myfont);

		Icon image = new ImageIcon("image/webchat.jpg");
		imagePos = new JLabel(image);

		// 设置按钮组件
		buttonStart = new JButton("启动");
		buttonStart.setFont(myfont);
		buttonStart.setBackground(new Color(0, 155, 0));
		buttonStart.setToolTipText("启动服务器");
		buttonStart.addActionListener(this);

		buttonDisconnect = new JButton("断开");
		buttonDisconnect.setFont(myfont);
		buttonDisconnect.setBackground(new Color(0, 155, 0));
		buttonDisconnect.setToolTipText("断开服务器 ");
		buttonDisconnect.addActionListener(this);

		// 设置文本框
		txtPort = new JTextField();
		txtPort.setToolTipText("输入要使用的端口号");
		// 显示状态窗口
		String message2 = "********************************聊天室人员变更情况******************************************\n\n";
		textMain = new TextArea(message2, 110, 300, TextArea.SCROLLBARS_VERTICAL_ONLY);
		textMain.setEditable(false); // 聊天文本域不可写
		textMain.setBackground(new Color(225, 225, 225));

		// 设置框架窗口布局管理为空布局管理
		JPanel panelObj = new JPanel();
		getContentPane().add(panelObj);
		panelObj.setLayout(null);

		// 手工设置各控件的大小和位置
		txtPort.setBounds(new Rectangle(100, 20, 180, 20));
		labelPort.setBounds(new Rectangle(40, 20, 60, 20));

		buttonStart.setBounds(new Rectangle(300, 20, 60, 20));
		buttonDisconnect.setBounds(new Rectangle(430, 20, 60, 20));
		textMain.setBounds(new Rectangle(120, 70, 550, 320));
		imagePos.setBounds(new Rectangle(0, 0, 320, 160));

		// 把各组件加到框架窗口中
		panelObj.add(labelPort);
		panelObj.add(txtPort);
		panelObj.add(buttonStart);
		panelObj.add(buttonDisconnect);
		panelObj.add(textMain);
		panelObj.add(imagePos);

		setResizable(false);
		setSize(800, 600);
		Dimension us = this.getSize();
		// 获取屏幕的尺寸
		Dimension them = Toolkit.getDefaultToolkit().getScreenSize();
		int newX = (them.width - us.width) / 2;
		int newY = (them.height - us.height) / 2;
		this.setLocation(newX, newY);
		setVisible(true);
	}

	// ***********************************按钮事件****************************************
	public void actionPerformed(ActionEvent even) {
		Server server = null;
		boolean flag = true;
		JButton obj = (JButton) even.getSource();

		if (obj == buttonStart) { // 启动
			String n = txtPort.getText();
			for (int i = 0; i < n.length(); i++) {
				if (!Character.isDigit(n.charAt(i))) {
					flag = false;
				}
			}
			if (flag) {
				port = Integer.parseInt(n);
				// 启动服务
				server = new Server(port);
				//Connection connect = new Connection(this);
			} else {
				JOptionPane.showMessageDialog(this, "输入的不是数字", "提示!", JOptionPane.CANCEL_OPTION);
			}

		} else if (obj == buttonDisconnect) { // 断开
			System.exit(0);// 直接关掉JVM
		}
	}

	// *********************************main()方法
	public static void main(String args[]) {
		new ServerForm();
	}

}