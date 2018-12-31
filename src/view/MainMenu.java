package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;


/*
 * 登陆成功后主界面
 */
public class MainMenu extends JFrame implements ActionListener{
	private JFrame mainmenu;
	private JTextArea text;
	private JMenu menuFile1, menuFile2, menuFile3;
	private JMenuBar menuBar1;
	private JMenuItem addStudentInfo,queryStudentInfo, modifyPassword,Exit;
	private JMenuItem importExcel,importTxt, outputExcel,outputTxt;
	private JMenuItem aboutSystem,help;
	public MainMenu() {

		mainmenu();
	}

	public void mainmenu() {
		// TODO Auto-generated method stub
		text = new JTextArea();
		text.setEditable(true);
		mainmenu = new JFrame("欢迎使用WTU学生信息管理系统 - 欢迎" + "用户" );
		mainmenu.setSize(1265, 856);

		mainmenu.getContentPane().add(new JScrollPane(text));


		//====================>基本操作
		menuFile1 = new JMenu("基本操作(0)");
		Font font = new Font("楷体",Font.BOLD,16);
		menuFile1.setFont(font);
		menuFile1.setIcon(new ImageIcon("src/images/icons/base1.png"));
		menuFile1.setMnemonic('O');
		//menuFile.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.ALT_MASK));

		add(menuFile1);

		menuBar1 = new JMenuBar();

		addStudentInfo = new JMenuItem("增加",new ImageIcon("src/images/icons/add.png"));
		addStudentInfo.setMnemonic('H');
		addStudentInfo.setAccelerator(KeyStroke.getKeyStroke('H',java.awt.Event.CTRL_MASK));
		menuFile1.add(addStudentInfo);

		queryStudentInfo = new JMenuItem("查询",new ImageIcon("src/images/icons/query.png"));
		queryStudentInfo.setMnemonic('Q');
		queryStudentInfo.setAccelerator(KeyStroke.getKeyStroke('Q',java.awt.Event.CTRL_MASK));
		menuFile1.add(queryStudentInfo);

		modifyPassword = new JMenuItem("密码修改",new ImageIcon("src/images/icons/modifyPassword.png"));
		modifyPassword.setMnemonic('M');
		modifyPassword.setAccelerator(KeyStroke.getKeyStroke('M',java.awt.Event.CTRL_MASK));
		menuFile1.add(modifyPassword);

		Exit = new JMenuItem("退出",new ImageIcon("src/images/icons/exit.png"));
		Exit.setMnemonic('E');
		Exit.setAccelerator(KeyStroke.getKeyStroke('E',java.awt.Event.CTRL_MASK));
		menuFile1.add(Exit);

		menuBar1.add(menuFile1);

		//====================>导入导出
		menuFile2 = new JMenu("导入导出(0)");
		menuFile2.setFont(font);
		menuFile2.setIcon(new ImageIcon("src/images/icons/base2.png"));
		menuFile2.setMnemonic('O');
		//menuFile.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.ALT_MASK));
		importExcel = new JMenuItem("从excel导入",new ImageIcon("src/images/icons/import.png"));
		importExcel.setMnemonic('H');
		importExcel.setAccelerator(KeyStroke.getKeyStroke('H',java.awt.Event.CTRL_MASK));
		menuFile2.add(importExcel);

		importTxt = new JMenuItem("从txt导入",new ImageIcon("src/images/icons/output.png"));
		importTxt.setMnemonic('H');
		importTxt.setAccelerator(KeyStroke.getKeyStroke('H',java.awt.Event.CTRL_MASK));
		menuFile2.add(importTxt);

		outputExcel = new JMenuItem("从excel导出",new ImageIcon("src/images/icons/import1.png"));
		outputExcel.setMnemonic('H');
		outputExcel.setAccelerator(KeyStroke.getKeyStroke('H',java.awt.Event.CTRL_MASK));
		menuFile2.add(outputExcel);

		outputTxt = new JMenuItem("从txt导出",new ImageIcon("src/images/icons/output1.png"));
		outputTxt.setMnemonic('H');
		outputTxt.setAccelerator(KeyStroke.getKeyStroke('H',java.awt.Event.CTRL_MASK));
		menuFile2.add(outputTxt);


		menuBar1.add(menuFile2);

		//====================>帮助
		menuFile3 = new JMenu("帮助(0)");
		menuFile3.setFont(font);
		menuFile3.setIcon(new ImageIcon("src/images/icons/base3.png"));
		menuFile3.setMnemonic('O');
		//menuFile.setAccelerator(KeyStroke.getKeyStroke('O',java.awt.Event.ALT_MASK));
		aboutSystem = new JMenuItem("关于本系统",new ImageIcon("src/images/icons/about.png"));
		aboutSystem.setMnemonic('H');
		aboutSystem.setAccelerator(KeyStroke.getKeyStroke('H',java.awt.Event.CTRL_MASK));
		menuFile3.add(aboutSystem);

		help = new JMenuItem("系统帮助",new ImageIcon("src/images/icons/help.png"));
		help.setMnemonic('H');
		help.setAccelerator(KeyStroke.getKeyStroke('H',java.awt.Event.CTRL_MASK));
		menuFile3.add(help);

		menuBar1.add(menuFile3);




		addStudentInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("=======>用户选择了‘添加学生信息’菜单项");
				AddStudentInfo addStudentInfo = new AddStudentInfo();
			}
		});


		queryStudentInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("=======>用户选择了‘查询学生信息’菜单项");
				QueryStudentInfo queryStudentInfo = new QueryStudentInfo();
			}
		});

		modifyPassword.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("=======>用户选择了‘修改密码’菜单项");
				ModifyPasswordInfo modifyPasswordInfo = new ModifyPasswordInfo();
			}
		});


		Exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("=======>用户选择了‘退出’菜单项");
				System.exit(1);
			}
		});

		importExcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("=======>用户选择了‘导入到excel’菜单项");
				ImportExcel importExcel =new ImportExcel();

			}
		});
		importTxt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("=======>用户选择了‘导入到txt’菜单项");
				ImportTxt importTxt = new ImportTxt();
			}
		});
		outputExcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("=======>用户选择了‘导出到excel’菜单项");
				OutputExcel outputExcel = new OutputExcel();
			}
		});
		outputTxt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("=======>用户选择了‘导出到txt’菜单项");
				OutputTxt outputTxt = new OutputTxt();
			}
		});
		aboutSystem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("=======>用户选择了‘关于系统’菜单项");
				AboutSystem aboutSystem = new AboutSystem();
			}
		});
		help.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("=======>用户选择了‘帮助’菜单项");
				Help help = new Help();
			}
		});


		mainmenu.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent arg0) {
				System.exit(1);
			}
		});

		mainmenu.setJMenuBar(menuBar1);
		mainmenu.setVisible(true);
		mainmenu.setLocation(250, 50);
		addStudentInfo.addActionListener(this);
		queryStudentInfo.addActionListener(this);
		modifyPassword.addActionListener(this);
		Exit.addActionListener(this);
		importExcel.addActionListener(this);
		importTxt.addActionListener(this);
		outputExcel.addActionListener(this);
		outputTxt.addActionListener(this);
		aboutSystem.addActionListener(this);
		help.addActionListener(this);
	}



	public static void main(String[] args) {
		new MainMenu();

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {


	}

}
