package view;

import javax.swing.*;
import java.awt.*;



public class AboutSystem extends JFrame{
	private JLabel jlabel1,jlabel2,jlabel3,jlabel4,jlabel5,jlabel6;
	private Font font;
	public AboutSystem() {
		setTitle("关于本系统");//设置容器标题
		setSize(600, 450);//设置容器大小
		setLocationRelativeTo(null);//将容器显示在屏幕中央
		AboutSystem();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//点击右上角的关闭，只关闭本窗口，不影响住窗口
		setVisible(true);//设置窗口可见
		setResizable(true);//设置窗口大小可以改变
	}
	private void AboutSystem() {
		// TODO Auto-generated method stub
		setLayout(null);//以绝对布局的方式布局
		font = new Font("楷体", Font.BOLD, 20);
		jlabel1 = new JLabel("学生管理系统");
		jlabel1.setBounds(230, 50, 150, 50);
		jlabel1.setFont(font);
		jlabel2 = new JLabel("软件11604班");
		jlabel2.setBounds(240, 100, 150, 50);
		jlabel2.setFont(font);
		jlabel3 = new JLabel("1604240906，1604241020,1604241030,1604241011");
		jlabel3.setBounds(50, 150, 550, 50);
		jlabel3.setFont(font);
		jlabel6 = new JLabel("1604240928");
		jlabel6.setBounds(240, 170, 150, 50);
		jlabel6.setFont(font);

		jlabel4 = new JLabel("黄若婷,李林峰，王健恺，梁泽，胡旭东");
		jlabel4.setBounds(100, 220, 450, 50);
		jlabel4.setFont(font);
		jlabel5 = new JLabel("2018-12-28");
		jlabel5.setBounds(250, 270, 150, 50);
		jlabel5.setFont(font);

		add(jlabel1);
		add(jlabel2);
		add(jlabel3);
		add(jlabel6);
		add(jlabel4);
		add(jlabel5);

	}

	public static void main(String[] args){
		new AboutSystem();
	}
}
