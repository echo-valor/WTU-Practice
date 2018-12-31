package util;



import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import view.AddStudentInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prompt extends JFrame implements ActionListener{
	private JButton button1,button2;
	private JLabel promptsentence;
	private Font font;

	public Prompt() {
		setTitle("添加成功提示框");
		setSize(550,350);
		setLocationRelativeTo(null);//将容器显示在屏幕中央
		prompt();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//点击右上角的关闭，只关闭本窗口，不影响住窗口
		setVisible(true);//设置窗口可见
		setResizable(true);//设置窗口大小可以改变
	}

	public void prompt() {
		// TODO Auto-generated method stub
		setLayout(null);
		promptsentence = new JLabel("你输入的信息已经成功保存，是否继续添加？");
		font = new Font("楷体", Font.BOLD, 20);
		promptsentence.setFont(font);
		promptsentence.setBounds(50, 80, 450, 50);

		button1 = new JButton("是");
		button1.setBounds(150, 150, 70, 40);
		button1.setFont(font);
		button1.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.blue));//设置按钮的背景颜色

		button2 = new JButton("否");
		button2.setBounds(300, 150, 70, 40);
		button2.setFont(font);
		button2.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.red));//设置按钮的背景颜色


		add(promptsentence);
		add(button1);
		add(button2);

		button1.addActionListener(this);
		button2.addActionListener(this);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Prompt();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String cmd = e.getActionCommand();
		if(cmd.equals("是")) {
			dispose();
			AddStudentInfo.clearText();
		}
		else if(cmd.equals("否")) {
			dispose();

		}
	}


}
