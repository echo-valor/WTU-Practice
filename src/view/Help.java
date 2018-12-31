package view;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;

public class Help extends JFrame{
	private JFrame jframe;//窗口对象
	private JTextArea area;//文本域对象
	private JScrollPane pane;//滚动条
	private JLabel jlabel;
	private Font font;
	public Help(){
		setTitle("系统帮助");//设置容器标题
		setSize(450, 450);//设置容器大小
		setLocationRelativeTo(null);//将容器显示在屏幕中央
		Help();
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//点击右上角的关闭，只关闭本窗口，不影响住窗口
		setVisible(true);//设置窗口可见
		setResizable(true);//设置窗口大小可以改变
	}
	private void Help(){
		// TODO Auto-generated method stub
		area = new JTextArea();
		File file = new File("G:\\eclipse1Workplace\\Practice\\src\\docs\\学生管理系统.txt");
		Long filelength = file.length();
		byte[] filecontent = new byte[filelength.intValue()];

		try {
			FileInputStream in = new FileInputStream(file);
			in.read(filecontent);
			area.setText(new String(filecontent,"GBK"));


		}catch(Exception e) {
			e.printStackTrace();
		}
		font = new Font("楷体", Font.BOLD, 15);
		area.setFont(font);

		area.setLineWrap(true);//如果内容过长，自动换行，在文本域加上滚动条，水平和垂直滚动条始终出现。
		area.setWrapStyleWord(true);// 激活断行不断字功能
		pane=new JScrollPane(area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		add(pane);

	}
	public static void main(String[] args) {
		new Help();
	}
}
