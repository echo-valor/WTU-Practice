package view;
import controller.impl.StudentControllerImpl;
import model.dao.StudentDao;
import model.vo.Student;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
class ImportTxt implements ActionListener{
	String filename=null;
	boolean flag=true;
	private JTextArea area = new JTextArea(5,5) ;	// 定义文本区
	private JFrame frame = new JFrame("请选择文件") ;
	private JButton open = new JButton("打开文件") ;

	private JButton insert = new JButton("导入") ;
	private JLabel label = new JLabel("现在没有打开的文件") ;
	private JPanel butPan = new JPanel() ;
	public ImportTxt(){
		open.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.lightBlue));
		insert.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.lightBlue));
		this.butPan.add(open) ;	// 在面板中加入按钮
		this.butPan.add(insert) ;	// 在面板中加入按钮
		this.frame.setLayout(new BorderLayout(3,3)) ;
		this.frame.add(this.label,BorderLayout.NORTH) ;
		this.frame.add(this.butPan,BorderLayout.SOUTH) ;
		this.frame.add(new JScrollPane(this.area),BorderLayout.CENTER) ;
		this.frame.setSize(600,600) ;
		this.frame.setLocation(400,100);
		frame.getContentPane().setBackground(Color.gray);
		this.frame.setVisible(true) ;
		this.frame.addWindowListener(
				new WindowAdapter()	{
					public void windowClosing(WindowEvent e){
						frame.setVisible(false);
					}
				}
		) ;
		this.open.addActionListener(this) ;
		this.insert.addActionListener(this) ;
	}
	public void actionPerformed(ActionEvent e){
		List<Student> list3=new ArrayList<Student>();
		List<Student> list4=new ArrayList<Student>();
		//boolean flag=false;
		File file = null ;	// 接收文件
		int result = 0 ;	// 接收操作状态
		JFileChooser fileChooser = new JFileChooser() ;	// 文件选择框
		if(e.getSource()==this.open){	// 表示执行的是打开操作
			this.area.setText("") ;	// 打开将文字区域的内容清空
			fileChooser.setApproveButtonText("确定") ;
			fileChooser.setDialogTitle("打开文件") ;
			result = fileChooser.showOpenDialog(this.frame) ;
			if(result==JFileChooser.APPROVE_OPTION){	// 选择的是确定按钮
				file = fileChooser.getSelectedFile() ;	// 得到选择的文件
				this.label.setText("选择的文件名称为：" +file.getName()) ;
				filename=file.getPath();
			}else if(result==JFileChooser.CANCEL_OPTION){
				this.label.setText("没有选择任何文件") ;
			}else{
				this.label.setText("操作出现错误") ;
			}

		}
		if(e.getSource()==this.insert){	// 判断是否是导入操作
			//filename=file.getPath();
			StudentDao s=new StudentDao();
			list3=s.queryallstudent();
			StudentControllerImpl sc=new StudentControllerImpl();
			try {
				list4=sc.ReadFromTxt(filename);
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			next:for(int i=0;i<list3.size();i++) {
				for(int j=0;j<list4.size();j++) {
					if(list3.get(i).getsId().equals(list4.get(j).getsId())) {
						flag=false;
						break next;
					}
				}
			}
			if(flag==false) {
				JOptionPane.showMessageDialog(null, "文件中某些行的学号在数据库中已存在，请检查","消息提示",JOptionPane.WARNING_MESSAGE);
			}else {
				StudentDao s1=new StudentDao();
				try {
					s1.insertfromtxt(filename);
				} catch (IOException | SQLException e1) {

					e1.printStackTrace();
				}

				JOptionPane.showMessageDialog(null, "成功导入"+list4.size()+"条数据到数据库中","消息提示",JOptionPane.WARNING_MESSAGE);
			}


		}
	}

}



