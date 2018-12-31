package view;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import model.dao.UserDao;
import model.vo.User;

import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import util.MD5Util;
public class Login extends JFrame implements ActionListener{
	public static String yuanname=null;
	public static String ypsd=null;
	MyJPanel mp;
	String username,password,login,quit;
	//=======================
	private JLabel jiemian;
	private JPanel jContentPane = null;
	private JButton jButton21 = null;
	private JButton jButton22 = null;
	private JTextField jTextField = null;
	private JTextField jPasswordField = null;
	static int storeUserId;// 登录用户名
	public static String storeUserName = null;// 登录用户名
	public static String storeUserPassword = null;// 登录密码
	static boolean RELOAD = true;// 重新登陆标记
	private JLabel jLabel_User = null;
	private JLabel jLabel_userName = null;
	private JLabel jLabel_password = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JLabel jLabel5 = null;


	int index;
	ImageIcon[] imgs = {
			new ImageIcon("src/images/1.jpg"),
			new ImageIcon("src/images/2.jpg"),
			new ImageIcon("src/images/3.jpg"),
			new ImageIcon("src/images/4.jpg"),
			new ImageIcon("src/images/5.jpg"),
	};
	public Login() {
		setForeground(new Color(255, 255, 255));
		mp = new MyJPanel();
		getContentPane().add(mp);
		mp.setBounds(0, 0, 1265, 420);
		this.setResizable(false);
		this.setSize(1265, 856);
		this.setTitle("欢迎登陆WTU学生信息管理系统");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("src/images/logo.jpg"));
		this.setLocationRelativeTo(null);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// 使用windows外观
		} catch (Exception e) {
			e.printStackTrace();
		}

		jiemian = new JLabel("欢迎使用WTU学生信息管理系统!");

		Font font = new Font("楷体",Font.BOLD,40);
		jiemian.setFont(font);
		jiemian.setBounds(290, 440,650, 50);
		jiemian.setForeground(Color.DARK_GRAY);
		getContentPane().add(jiemian);

		jButton21 = new JButton();
		jButton21.setBounds(new Rectangle(515, 625, 78, 26));
		jButton21.setText("登录");
		jButton21.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.green));
		getRootPane().setDefaultButton(jButton21);// 回车登录

		jButton22 = new JButton();
		jButton22.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.lightBlue));
		jButton22.setBounds(new Rectangle(610, 626, 78, 26));
		jButton22.setText("退出");

		jTextField = new JTextField(20);
		jTextField.setBounds(new Rectangle(520, 530, 154, 33));

		jPasswordField = new JPasswordField();
		jPasswordField.setBounds(new Rectangle(520, 570, 154, 33));

		Font font2 = new Font("楷体",Font.BOLD,15);
		jLabel_password = new JLabel();
		jLabel_password.setFont(font2);
		jLabel_password.setBounds(new Rectangle(429, 573, 71, 29));
		jLabel_password.setText("密 码：");
		jLabel_userName = new JLabel();
		jLabel_userName.setBounds(new Rectangle(429, 531, 71, 29));
		jLabel_userName.setFont(font2);
		jLabel_userName.setText("用户名：");
		jLabel_User = new JLabel();
		jLabel_User.setBounds(new Rectangle(810, 147, 635, 98));


		jLabel1 = new JLabel();
		Font font1 = new Font("楷体",Font.BOLD,10);
		jLabel1.setFont(font1);
		jLabel1.setBounds(new Rectangle(9, 703, 671, 29));
		jLabel1.setText("武汉纺织大学版权所有@ 2018 Copyrights all reserved 鄂ICP备15000386号 鄂公网安备42011102000704号");
		jLabel2 = new JLabel();
		jLabel2.setFont(font1);
		jLabel2.setBounds(new Rectangle(9, 733, 671, 29));
		jLabel2.setText("阳光校区：武汉市江夏区阳光大道1号 邮政编码：430200");
		jLabel3 = new JLabel();
		jLabel3.setFont(font1);
		jLabel3.setBounds(new Rectangle(9, 763, 671, 29));
		jLabel3.setText("南湖校区：武汉市洪山区纺织路1号 邮政编码：430073");
		jLabel4 = new JLabel();
		jLabel4.setFont(font1);
		jLabel4.setBounds(new Rectangle(9, 793, 671, 29));
		jLabel4.setText("东湖校区：武汉市武昌区东湖梨园渔光村1号 邮政编码：430077");


		ImageIcon ico=new ImageIcon("/src/images/weixin.png");
		ico.setImage(ico.getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
		jLabel5 = new JLabel(new ImageIcon(Login.class.getResource("/images/weixin.png")));
		jLabel5.setBounds(new Rectangle(1125, 703, 124, 119));

		jLabel_User.setIcon(new ImageIcon("src/images/user.gif"));
		jLabel_User.setText("User");

		jContentPane = new JPanel();// 新建jPanel面板
		jContentPane.setLayout(null);
		jContentPane.add(jLabel_userName, null);
		jContentPane.add(jLabel_password, null);
		jContentPane.add(jButton21, null);
		jContentPane.add(jButton22, null);
		jContentPane.add(jTextField, null);
		jContentPane.add(jPasswordField, null);
		jContentPane.add(jLabel_User, null);
		jContentPane.add(jLabel1, null);
		jContentPane.add(jLabel2, null);
		jContentPane.add(jLabel3, null);
		jContentPane.add(jLabel4, null);
		jContentPane.add(jLabel5, null);
		getContentPane().add(jContentPane);

		jTextField.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					jPasswordField.requestFocus();
				}
			}

		});

		jPasswordField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == KeyEvent.VK_ENTER){
					username = jTextField.getText();
					password = MD5Util.string2MD5(jPasswordField.getText());

					User user = new User();
					user.setUserName(username);
					user.setPassword(password);
					String s=user.getUserName();
					String p=jPasswordField.getText();
					UserDao userDao = new UserDao();
					int choice = 0;
					if(!userDao.checkUser(user)) {
						//Prompt tishi = new Prompt(1);
						JOptionPane.showMessageDialog(null, "用户名和密码错误","消息提示",JOptionPane.WARNING_MESSAGE);
					}else {
						setVisible(false);
						MainMenu MM = new MainMenu();
						yuanname = s;
						ypsd=p;

					}
				}


			}
		});

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

		Timer timer = new Timer(2000,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mp.repaint();
			}
		});
		timer.start();

		jTextField.addActionListener(this);
		jPasswordField.addActionListener(this);
		jButton21.addActionListener(this);
		jButton22.addActionListener(this);
	}
	public static void main(String[] args) {
		new Login();
	}
	class MyJPanel extends JPanel{
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.drawImage(imgs[index%imgs.length].getImage(), 0, 0,this);
			index++;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		username = jTextField.getText();
		password = MD5Util.string2MD5(jPasswordField.getText());

		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		String s=user.getUserName();
		String p=jPasswordField.getText();
		UserDao userDao = new UserDao();
		int choice = 0;

		if(e.getSource() == jButton21) {
			if(!userDao.checkUser(user)) {
				//Prompt tishi = new Prompt(1);
				JOptionPane.showMessageDialog(null, "用户名和密码错误","消息提示",JOptionPane.WARNING_MESSAGE);
			}else {
				setVisible(false);
				MainMenu MM = new MainMenu();
				yuanname = s;
				ypsd=p;

			}
		}else if(e.getSource() == jButton22) {
			System.exit(0);
		}
	}
}