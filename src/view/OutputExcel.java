package view;

import model.dao.StudentDao;
import model.vo.Student;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import util.ShowMessageUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

public class OutputExcel extends JFrame implements ActionListener {
	private JFrame jf=new JFrame("导出到excel");
	public String filepath;
	public StudentDao studao;
	private TextField textpath=new TextField();
	private Font font1 = new Font("楷体", 0, 20);
	private Font font2=new Font("楷体", 0, 20);
	private Toolkit toolkit = Toolkit.getDefaultToolkit(); // 获得系统默认工具类
	private Dimension sc = toolkit.getScreenSize(); // 获得屏幕尺寸
	private JButton imbtn=new JButton("导出到excel");
	private JLabel fname=new JLabel("文件：");
	private Container con = jf.getContentPane(); // 获得面板

	public OutputExcel() {
		// TODO Auto-generated constructor stub
		con.setLayout(null);
		jf.setSize(900, 500);
		jf.setLocation((sc.width - 900) / 2, (sc.height - 500) / 2);
		jf.setResizable(false);// 窗口大小不可变
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		con.setVisible(true);
		con.add(imbtn);
		con.add(textpath);
		con.add(fname);
		textpath.setBounds(300, 120, 300, 30);
		textpath.setFont(font2);
		fname.setBounds(150,107,300,60);
		fname.setFont(font2);
		imbtn.setBounds(350, 300, 200, 30);
		imbtn.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.lightBlue));
		imbtn.addActionListener(this);
		studao=StudentDao.getInstance();


	}
	//	public static void mainUi() {
//    	ImportExcel jTabbedPaneTest=new ImportExcel();
//
//    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==imbtn) {
			List<Student> list1=studao.queryallstudent();
			filepath=textpath.getText().toString();

			try {

				studao.WriteExcel(list1,filepath);
				ShowMessageUtil.winMessage("导出成功！");
				System.out.println("导出成功");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				System.out.println("导出失败");
				ShowMessageUtil.winMessage("导出失败！");
			}
		}
	}
}
