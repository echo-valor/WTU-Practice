package view;

import model.dao.StudentDao;
import model.vo.Student;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;
import util.Prompt;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class AddStudentInfo extends JFrame implements ActionListener,ItemListener {
	//学生信息添加界面容器
	private JFrame AddInterface;

	private static JTextField SidText,SnameText,SbirthdayText,
			SphoneText;//1.学生id输入框，
	//2.学生姓名输入框,3.学生出生日期输入框，4.学生联系电话输入框

	private JButton Save,Cancel,Return;//1.保存按钮，2.取消按钮,3.返回按钮


	private JLabel Sid,Sname,Ssex,Sbirthday,Sprovince,Shobby,Sphone;//1.显示“编号”文字，
	//2.显示“姓名”文字，3.显示“性别”文字，4.显示“出生日期”文字，5.显示“地址”文字，6.显示“兴趣爱好”文字
	//7.显示“联系电话”文字

	private JRadioButton SexButton1,SexButton2;//性别单选按钮
	private static ButtonGroup SexButton;//创建按钮组

	private static JComboBox SprovinceComboBox;//省份下拉列表框


	private static JCheckBox hobby1,hobby2,hobby3,hobby4,hobby5,hobby6,
			hobby7,hobby8,hobby9,hobby10,hobby11,hobby12;//兴趣多选框


	private JPanel checkbox;//创建兴趣复选框面板
	private Font font1,font2;//字体设置


	private String[] province = {"黑龙江省","辽宁省","吉林省","河北省","河南省","湖北省","湖南省",
			"山东省","山西省","陕西省","安徽省","浙江省","江苏省","福建省","广东省","海南省",
			"四川省","云南省","贵州省","青海省","甘肃省","江西省","台湾省"};

	public AddStudentInfo() {
		setTitle("添加学生信息");//设置容器标题
		setSize(850, 650);//设置容器大小
		setLocationRelativeTo(null);//将容器显示在屏幕中央
		AddStudentInfoInterface();//布局界面函数
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//点击右上角的关闭，只关闭本窗口，不影响住窗口
		setVisible(true);//设置窗口可见
		setResizable(true);//设置窗口大小可以改变
	}
	private void AddStudentInfoInterface() {
		// TODO Auto-generated method stub
		setLayout(null);//以绝对布局的方式布局

		font1 = new Font("楷体", Font.BOLD, 20);

		//设置各个组件的位置，字体
		Sid = new JLabel("学号:");//设置Sid的文字
		Sid.setBounds(250,30,150,50);//设置文在所在的位置
		Sid.setFont(font1);//设置字体
		SidText = new JTextField();//设置输入框
		SidText.setBounds(new Rectangle(350, 40, 150, 30));//设置位置
		SidText.setFont(font1);//设置字体

		Sname = new JLabel("姓名:");
		Sname.setBounds(250,90,150,50);
		Sname.setFont(font1);
		SnameText = new JTextField();
		SnameText.setBounds(new Rectangle(350, 100, 150, 30));
		SnameText.setFont(font1);


		Ssex = new JLabel("性别:");
		Ssex.setBounds(250, 150, 150, 50);
		Ssex.setFont(font1);
		SexButton = new ButtonGroup();
		SexButton1 = new JRadioButton("男");
		SexButton1.setBounds(350,160,50,30);
		SexButton1.setFont(font1);
		SexButton2 = new JRadioButton("女");
		SexButton2.setBounds(450, 160, 50, 30);
		SexButton2.setFont(font1);



		Sbirthday = new JLabel("出生日期:");
		Sbirthday.setBounds(250, 210,150,50);
		Sbirthday.setFont(font1);
		SbirthdayText = new JTextField();
		SbirthdayText.setBounds(350,220,150,30);
		SbirthdayText.setFont(font1);

		Sprovince = new JLabel("所在省份:");
		Sprovince.setBounds(250, 270, 150, 50);
		Sprovince.setFont(font1);
		SprovinceComboBox = new JComboBox(province);
		SprovinceComboBox.setBounds(350,280,150,30);
		SprovinceComboBox.setFont(font1);



		Shobby = new JLabel("兴趣爱好:");
		Shobby.setBounds(250,330,150,50);
		Shobby.setFont(font1);


		hobby1 = new JCheckBox("足球");
		hobby1.setFont(font1);
		hobby2 = new JCheckBox("篮球");

		hobby2.setFont(font1);
		hobby3 = new JCheckBox("乒乓球");

		hobby3.setFont(font1);
		hobby4 = new JCheckBox("看电影");

		hobby4.setFont(font1);
		hobby5 = new JCheckBox("羽毛球");

		hobby5.setFont(font1);
		hobby6 = new JCheckBox("游泳");

		hobby6.setFont(font1);
		hobby7 = new JCheckBox("旅游");

		hobby7.setFont(font1);
		hobby8 = new JCheckBox("唱歌");

		hobby8.setFont(font1);
		hobby9 = new JCheckBox("拍照");

		hobby9.setFont(font1);
		hobby10 = new JCheckBox("打游戏");

		hobby10.setFont(font1);
		hobby11 = new JCheckBox("逛街");

		hobby11.setFont(font1);
		hobby12 = new JCheckBox("看书");

		hobby12.setFont(font1);
		checkbox = new JPanel();
		checkbox.setLayout(new GridLayout(3,4));
		checkbox.add(hobby1);
		checkbox.add(hobby2);
		checkbox.add(hobby3);
		checkbox.add(hobby4);
		checkbox.add(hobby5);
		checkbox.add(hobby6);
		checkbox.add(hobby7);
		checkbox.add(hobby8);
		checkbox.add(hobby9);
		checkbox.add(hobby10);
		checkbox.add(hobby11);
		checkbox.add(hobby12);
		checkbox.setBounds(350, 335, 390, 130);

		Sphone = new JLabel("联系电话:");
		Sphone.setBounds(250, 460, 150, 50);
		Sphone.setFont(font1);
		SphoneText = new JTextField();
		SphoneText.setBounds(350, 470, 150, 30);
		SphoneText.setFont(font1);


		font2 = new Font("楷体",Font.BOLD,15);
		Save = new JButton("保存");
		Save.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.blue));//设置按钮的背景颜色
		Save.setBounds(new Rectangle(250, 520, 70,30));
		Save.setFont(font2);
		Cancel = new JButton("取消");
		Cancel.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.red));
		Cancel.setBounds(new Rectangle(350, 520, 70, 30));
		Cancel.setFont(font2);
		Return = new JButton("返回");
		Return.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.green));
		Return.setBounds(new Rectangle(450, 520, 70, 30));
		Return.setFont(font2);

		//将各个组将添加到容器里面
		add(Sid);
		add(SidText);

		add(Sname);
		add(SnameText);


		SexButton.add(SexButton1);
		SexButton.add(SexButton2);
		add(Ssex);
		add(SexButton1);
		add(SexButton2);


		add(Sbirthday);
		add(SbirthdayText);

		add(Sprovince);
		add(SprovinceComboBox);

		add(Shobby);
		add(checkbox);

		add(Sphone);
		add(SphoneText);

		add(Save);
		add(Cancel);
		add(Return);

		//为各个组件添加事件监听器
		SidText.addActionListener(this);
		SnameText.addActionListener(this);
		SbirthdayText.addActionListener(this);
		SprovinceComboBox.addItemListener(this);
		hobby1.addItemListener(this);
		hobby2.addItemListener(this);
		hobby3.addItemListener(this);
		hobby4.addItemListener(this);
		hobby5.addItemListener(this);
		hobby6.addItemListener(this);
		hobby7.addItemListener(this);
		hobby8.addItemListener(this);
		hobby9.addItemListener(this);
		hobby10.addItemListener(this);
		hobby11.addItemListener(this);
		hobby12.addItemListener(this);
		SphoneText.addActionListener(this);
		Save.addActionListener(this);
		Cancel.addActionListener(this);
		Return.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String sid,sname,sbirthday,sphone;
		sid = SidText.getText();//得到输入框中的数据保存下来
		sname = SnameText.getText();//得到输入框中的数据保存下来
		sbirthday = SbirthdayText.getText();//得到输入框中的数据保存下来
		sphone = SphoneText.getText();//得到输入框中的数据保存下来
		String cmd = e.getActionCommand();//得到按钮上的标签
		if(e.getSource() == SidText) {
			SnameText.requestFocus();
		}
		else if(e.getSource() ==  SnameText) {
			SbirthdayText.requestFocus();
		}
		else if(e.getSource() == SbirthdayText) {
			SphoneText.requestFocus();
		}
		else if(e.getSource() == SphoneText) {
			Save.requestFocus();
			if(sid.equals("")) {
				JOptionPane.showMessageDialog(null, "学号不能为空！","消息提示",JOptionPane.WARNING_MESSAGE);//错误提示框
				return;
			}
			if(!isNumeric(sid) || sid.length() != 10) {
				JOptionPane.showMessageDialog(null, "学号格式不正确！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			StudentDao studentdao = new StudentDao();
			int count = studentdao.queryForsidinformation(sid);
			if(count != 0) {
				JOptionPane.showMessageDialog(null, "你输入的学号已经存在，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(sname.equals("")) {
				JOptionPane.showMessageDialog(null, "姓名不能为空！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(!SexButton1.isSelected() && !SexButton2.isSelected()) {//isSelected()，如果按钮被选中返回true
				JOptionPane.showMessageDialog(null, "请选择性别！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(sbirthday.equals("")) {
				JOptionPane.showMessageDialog(null, "出生日期不能为空！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(isDate(sbirthday) == false) {
				JOptionPane.showMessageDialog(null, "出生日期格式不合法，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(!hobby1.isSelected() && !hobby2.isSelected() &&
					!hobby3.isSelected() && !hobby4.isSelected() &&
					!hobby5.isSelected() && !hobby6.isSelected() &&
					!hobby7.isSelected() && !hobby8.isSelected() &&
					!hobby9.isSelected() && !hobby10.isSelected() &&
					!hobby11.isSelected() && !hobby12.isSelected() ) {
				JOptionPane.showMessageDialog(null, "兴趣爱好不能为空！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(sphone.equals("")) {
				JOptionPane.showMessageDialog(null, "手机号码不能为空！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(isMobile(sphone) == false || sphone.length() != 11) {
				JOptionPane.showMessageDialog(null, "手机号码格式不正确，请重新下输入！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}


			Student student = new Student();
			student.setsId(sid);
			student.setsName(sname);
			//student.setSsex(ssex);

			if(SexButton1.isSelected()) {//获取单选按钮选中的情况，保存到student中
				student.setsSex(SexButton1.getText());
			}else {
				student.setsSex(SexButton2.getText());
			}
			student.setsProvince((String)SprovinceComboBox.getSelectedItem());//得到下拉列表中的内容保存到student中



			student.setsBirthday(sbirthday);
			student.setsPhone(sphone);
			StringBuffer hobby = new StringBuffer();


			if(hobby1.isSelected()) {
				hobby.append(hobby1.getText()+"，");
			}
			if(hobby2.isSelected()) {
				hobby.append(hobby2.getText()+"，");
			}
			if(hobby3.isSelected()) {
				hobby.append(hobby3.getText()+"，");
			}
			if(hobby4.isSelected()) {
				hobby.append(hobby4.getText()+"，");
			}
			if(hobby5.isSelected()) {
				hobby.append(hobby5.getText()+"，");
			}
			if(hobby6.isSelected()) {
				hobby.append(hobby6.getText()+"，");
			}
			if(hobby7.isSelected()) {
				hobby.append(hobby7.getText()+"，");
			}
			if(hobby8.isSelected()) {
				hobby.append(hobby8.getText()+"，");
			}
			if(hobby9.isSelected()) {
				hobby.append(hobby9.getText()+"，");
			}
			if(hobby10.isSelected()) {
				hobby.append(hobby10.getText()+"，");
			}
			if(hobby11.isSelected()) {
				hobby.append(hobby11.getText()+"，");
			}
			if(hobby12.isSelected()) {
				hobby.append(hobby12.getText());
			}

			if(hobby.charAt(hobby.length()-1)=='，') {//判断复选框最后一个选择了什么，然后去掉“，”
				hobby.deleteCharAt(hobby.length()-1);
			}
			student.setsHobby(hobby.toString());

//			System.out.println(hobby.toString());

			StudentDao addstudentdao = new StudentDao();
			boolean flag = addstudentdao.insertstudentinformation(student);//将数据插入数据库
			if(flag == true) {
				new Prompt();//添加成功，显示提示框
			}
		}

		if(cmd.equals("保存")) {
			if(sid.equals("")) {
				JOptionPane.showMessageDialog(null, "学号不能为空！","消息提示",JOptionPane.WARNING_MESSAGE);//错误提示框
				return;
			}
			if(!isNumeric(sid) || sid.length() != 10) {
				JOptionPane.showMessageDialog(null, "学号格式不正确！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			StudentDao studentdao = new StudentDao();
			int count = studentdao.queryForsidinformation(sid);
			if(count != 0) {
				JOptionPane.showMessageDialog(null, "你输入的学号已经存在，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(sname.equals("")) {
				JOptionPane.showMessageDialog(null, "姓名不能为空！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(!SexButton1.isSelected() && !SexButton2.isSelected()) {//isSelected()，如果按钮被选中返回true
				JOptionPane.showMessageDialog(null, "请选择性别！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(sbirthday.equals("")) {
				JOptionPane.showMessageDialog(null, "出生日期不能为空！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(isDate(sbirthday) == false) {
				JOptionPane.showMessageDialog(null, "出生日期格式不合法，请重新输入！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(!hobby1.isSelected() && !hobby2.isSelected() &&
					!hobby3.isSelected() && !hobby4.isSelected() &&
					!hobby5.isSelected() && !hobby6.isSelected() &&
					!hobby7.isSelected() && !hobby8.isSelected() &&
					!hobby9.isSelected() && !hobby10.isSelected() &&
					!hobby11.isSelected() && !hobby12.isSelected() ) {
				JOptionPane.showMessageDialog(null, "兴趣爱好不能为空！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(sphone.equals("")) {
				JOptionPane.showMessageDialog(null, "手机号码不能为空！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}
			if(isMobile(sphone) == false || sphone.length() != 11) {
				JOptionPane.showMessageDialog(null, "手机号码格式不正确，请重新下输入！","消息提示",JOptionPane.WARNING_MESSAGE);
				return;
			}


			Student student = new Student();
			student.setsId(sid);
			student.setsName(sname);
			//student.setSsex(ssex);

			if(SexButton1.isSelected()) {//获取单选按钮选中的情况，保存到student中
				student.setsSex(SexButton1.getText());
			}else {
				student.setsSex(SexButton2.getText());
			}
			student.setsProvince((String)SprovinceComboBox.getSelectedItem());//得到下拉列表中的内容保存到student中



			student.setsBirthday(sbirthday);
			student.setsPhone(sphone);
			StringBuffer hobby = new StringBuffer();


			if(hobby1.isSelected()) {
				hobby.append(hobby1.getText()+"，");
			}
			if(hobby2.isSelected()) {
				hobby.append(hobby2.getText()+"，");
			}
			if(hobby3.isSelected()) {
				hobby.append(hobby3.getText()+"，");
			}
			if(hobby4.isSelected()) {
				hobby.append(hobby4.getText()+"，");
			}
			if(hobby5.isSelected()) {
				hobby.append(hobby5.getText()+"，");
			}
			if(hobby6.isSelected()) {
				hobby.append(hobby6.getText()+"，");
			}
			if(hobby7.isSelected()) {
				hobby.append(hobby7.getText()+"，");
			}
			if(hobby8.isSelected()) {
				hobby.append(hobby8.getText()+"，");
			}
			if(hobby9.isSelected()) {
				hobby.append(hobby9.getText()+"，");
			}
			if(hobby10.isSelected()) {
				hobby.append(hobby10.getText()+"，");
			}
			if(hobby11.isSelected()) {
				hobby.append(hobby11.getText()+"，");
			}
			if(hobby12.isSelected()) {
				hobby.append(hobby12.getText());
			}

			if(hobby.charAt(hobby.length()-1)=='，') {//判断复选框最后一个选择了什么，然后去掉“，”
				hobby.deleteCharAt(hobby.length()-1);
			}
			student.setsHobby(hobby.toString());

//			System.out.println(hobby.toString());

			StudentDao addstudentdao = new StudentDao();
			boolean flag = addstudentdao.insertstudentinformation(student);//将数据插入数据库
			if(flag == true) {
				new Prompt();//添加成功，显示提示框
			}
		}
		else if(cmd.equals("取消")) {
			clearText();//点击取消按钮，清空输入框和选择
		}
		else if(cmd.equals("返回")) {
			dispose();//点击返回按钮，销毁当前窗口
		}
	}

	public static  void clearText() {
		// TODO Auto-generated method stub
		SidText.setText("");//清空输入框
		SnameText.setText("");//清空输入框
		SexButton.clearSelection();//清空输入框
		SbirthdayText.setText("");//清空输入框
		SprovinceComboBox.setSelectedIndex(0);//取消选择
		hobby1.setSelected(false);//取消选择
		hobby2.setSelected(false);//取消选择
		hobby3.setSelected(false);//取消选择
		hobby4.setSelected(false);//取消选择
		hobby5.setSelected(false);//取消选择
		hobby6.setSelected(false);//取消选择
		hobby7.setSelected(false);//取消选择
		hobby8.setSelected(false);//取消选择
		hobby9.setSelected(false);//取消选择
		hobby10.setSelected(false);//取消选择
		hobby11.setSelected(false);//取消选择
		hobby12.setSelected(false);//取消选择
		SphoneText.setText("");//清空输入框
	}
	//判断Sid是否为纯数字
	public static boolean isNumeric(String str) {
		for (int i = str.length(); --i >= 0;) {
			int chr = str.charAt(i);//把str的第i个char值赋值给chr
			if (chr < 48 || chr > 57){
				return false;
			}

		}
		return true;
	}
	//判断出生日期的合法性
	public boolean isDate(String date)
	{
		/**
		 * 判断日期格式和范围
		 */
		String rexp = "^((\\d{2}(([02468][048])"
				+ "|([13579][26]))[\\-\\/\\s]?"
				+ "((((0?[13578])|(1[02]))[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])|(3[01])))"
				+ "|(((0?[469])|(11))[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])|(30)))"
				+ "|(0?2[\\-\\/\\s]?((0?[1-9])"
				+ "|([1-2][0-9])))))|(\\d{2}(([02468][1235679])"
				+ "|([13579][01345789]))[\\-\\/\\s]?"
				+ "((((0?[13578])|(1[02]))[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])|(3[01])))"
				+ "|(((0?[469])|(11))[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])|(30)))"
				+ "|(0?2[\\-\\/\\s]?((0?[1-9])"
				+ "|(1[0-9])|(2[0-8]))))))";

		Pattern pat = Pattern.compile(rexp);   //把规则编译成模式对象

		Matcher mat = pat.matcher(date);    //通过模式对象得到匹配器对象

		boolean dateType = mat.matches();  //对匹配目标进行检测

		return dateType;
	}
	public static boolean isMobile(final String sphone) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号把规则编译成模式对象
		m = p.matcher(sphone);//通过模式对象得到匹配器对象
		b = m.matches();//对匹配目标进行检测
		return b;
	}


	public static void main(String[] args) {
		new AddStudentInfo();
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}




}
