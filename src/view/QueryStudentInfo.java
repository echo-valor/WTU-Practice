package view;


import controller.StudentController;
import controller.impl.StudentControllerImpl;
import model.dao.StudentDao;
import model.vo.Student;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
@SuppressWarnings("serial")


public class QueryStudentInfo extends JFrame implements ActionListener {

	private JScrollPane panel;
	private JButton next,previous,first,last, query;
	private JButton modifyBtn,deleteBtn,exportExcelBtn,backBtn;

	private JLabel studentId;
	private JLabel studengName;
	private JLabel studentSex;
	private JLabel studentProvince;
	private JTextField studentIdContent;
	private JTextField studengNameContent;
	private JTextField studentSexContent;
	private JTextField studentProvinceContent;

	private JLabel label1,label2;	//	1.显示总页数和当前页数 2.每页显示数
	private JTable table;
	public int currentPage=1;		// 当前页
	public int totalPage=0;			// 总页数
	public int totalRowCount=0;		// 总行数
	public int pageCount;			// 每页显示数目
	public int column=0;
	public int restCount;			// 最后一页数目
	public Object[][] resultData;	// 结果集二维数组


	/*声明下拉菜单数据*/
	String []array =  {"20","30","40","50","60"};
	JComboBox box = new JComboBox(array);//将数组array放到下拉菜单中

	/*JTable表信息相关变量*/
	public List<Student> students=Student.students;
	public String[] columnNames={"学号","姓名","性别","生日","省份","兴趣","电话"};
	public DefaultTableModel model=null;//默认的表格控制模型

	/*
	 * 窗体及表的建立
	 */
	public QueryStudentInfo(){
		super("学生信息查询统计");
		this.setSize(1040,680);

		JLabel queryDate;


		Font font = new Font("楷体", Font.CENTER_BASELINE, 12);

		studentId = new JLabel("学号");
		studentId.setBounds(100, 30, 40, 30);
		studentId.setFont(font);

		studentIdContent = new JTextField();
		studentIdContent.setBounds(145, 30, 100, 30);


		studengName = new JLabel("学生姓名");
		studengName.setBounds(270, 30, 70, 30);
		studengName.setFont(font);

		studengNameContent = new JTextField();
		studengNameContent.setBounds(341, 30, 100, 30);



		//“姓名”，“性别”，“省份”
		studentProvince = new JLabel("省份");
		studentProvince.setBounds(100, 65, 40, 30);
		studentProvince.setFont(font);

		studentProvinceContent = new JTextField();
		studentProvinceContent.setBounds(145, 65, 100, 30);

		studentSex = new JLabel("学生性别");
		studentSex.setBounds(270, 65, 70, 30);
		studentSex.setFont(font);

		studentSexContent = new JTextField();
		studentSexContent.setBounds(341, 65, 100, 30);

		/*queryDate = new JLabel("请选择查询日期：");
		queryDate.setBounds(220, 30, 400, 40);
		queryDate.setFont(font);
		queryDate.setForeground(Color.BLACK);*/



		query = new JButton("查询");
		query.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.lightBlue));
		query.setBounds(500, 30, 95, 30);
		//query.setFont(font);
		query.setForeground(Color.blue);
		ImageIcon icon1 = new ImageIcon("src/images/query2.png");
		query.setIcon(icon1);

		table=new JTable();
		box.setBounds(890, 105, 100, 20);
		label2 = new JLabel("每页显示条数:");
		label2.setBounds(800, 93, 120, 50);
		panel=new JScrollPane();//设置滚动条
		panel.setViewportView(table);
		panel.setBounds(42, 136, 950, 420);


		first = new JButton("第一页");
		first.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.green));
		first.setBounds(44, 570, 90,30);
		previous=new JButton("上一页");
		previous.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.green));
		previous.setBounds(164,570, 90, 30);
		next=new JButton("下一页");
		next.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.green));
		next.setBounds(284, 570, 90, 30);
		last = new JButton("最后一页");
		last.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.green));
		last.setBounds(404, 570, 90, 30);


		modifyBtn = new JButton("修改");
		modifyBtn.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.green));
		modifyBtn.setBounds(524, 570, 90,30);
		deleteBtn=new JButton("删除");
		deleteBtn.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.green));
		deleteBtn.setBounds(644,570, 90, 30);
		exportExcelBtn=new JButton("导出到Excel");
		exportExcelBtn.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.green));
		exportExcelBtn.setBounds(764, 570, 120, 30);
		backBtn = new JButton("返回");
		backBtn.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.green));
		backBtn.setBounds(908, 570, 90, 30);



		/*添加监听*/
		previous.addActionListener(this);
		next.addActionListener(this);


		first.addActionListener(this);
		last.addActionListener(this);
		query.addActionListener(this);

		backBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});


		exportExcelBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				OutputExcel excel = new OutputExcel();

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		modifyBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {

				int selectedRowIndex = 7;
				selectedRowIndex = table.getSelectedRow();
				if(selectedRowIndex == -1){
					JOptionPane.showMessageDialog(null, "请在表格中选中一条数据","消息提示",JOptionPane.WARNING_MESSAGE);
				}else{
					String sid = table.getValueAt(selectedRowIndex, 0).toString();
					String sname = table.getValueAt(selectedRowIndex, 1).toString();
					String ssex = table.getValueAt(selectedRowIndex, 2).toString();
					String sbirthday = table.getValueAt(selectedRowIndex, 3).toString();
					String sprovince = table.getValueAt(selectedRowIndex, 4).toString();
					String shobby = table.getValueAt(selectedRowIndex, 5).toString();
					String sphone = table.getValueAt(selectedRowIndex, 6).toString();

					EditStudentInfo editStudentInfo = new EditStudentInfo(sid, sname, ssex, sbirthday, sprovince, shobby, sphone);

				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});


		deleteBtn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("===========================================>用户点击了查询菜单中的‘删除’按钮");

				int selectedRowIndex = 7;
				selectedRowIndex = table.getSelectedRow();
				if(selectedRowIndex == -1){
					JOptionPane.showMessageDialog(null, "请在表格中选中一条数据","消息提示",JOptionPane.WARNING_MESSAGE);
				}else{
					String sid = table.getValueAt(selectedRowIndex, 0).toString();

					StudentController studentController = new StudentControllerImpl();
					boolean flag = studentController.deleteStudentController(sid);
					if(flag){
						JOptionPane.showMessageDialog(null, "删除学生信息成功","消息提示",JOptionPane.QUESTION_MESSAGE);
					}else{
						JOptionPane.showMessageDialog(null, "删除学生信息失败", "消息提示", JOptionPane.WARNING_MESSAGE);
					}
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		label1=new JLabel();
		label1.setBounds(420, 400, 180, 60);

		this.getContentPane().setLayout(null);

		this.getContentPane().add(box);//获取内容面板，再对其加入组件
		this.getContentPane().add(label2);
		this.getContentPane().add(panel);
		this.getContentPane().add(previous);
		this.getContentPane().add(next);
		this.getContentPane().add(first);
		this.getContentPane().add(last);
		this.getContentPane().add(label1);


		this.getContentPane().add(studentId);
		this.getContentPane().add(studentIdContent);
		this.getContentPane().add(studengName);
		this.getContentPane().add(studengNameContent);
		this.getContentPane().add(studentSex);
		this.getContentPane().add(studentSexContent);
		this.getContentPane().add(studentProvince);
		this.getContentPane().add(studentProvinceContent);

		this.getContentPane().add(modifyBtn);
		this.getContentPane().add(deleteBtn);
		this.getContentPane().add(exportExcelBtn);
		this.getContentPane().add(backBtn);

		this.getContentPane().add(query);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		/*从MySQL数据库中获取数据*/
		try{
			StudentDao commoditySaleDetailDao = new StudentDao();
			ResultSet rs = commoditySaleDetailDao.queryAll();
			ResultSetMetaData   metaData;
			metaData = rs. getMetaData();
			int number=metaData.getColumnCount();
			while(rs.next()){
				String sId = rs.getString(1);
				String sName = rs.getString(2);
				String sSex = rs.getString(3);
				String sBirthday = rs.getString(4);
				String sProvince = rs.getString(5);
				String sHobby = rs.getString(6);
				String sPhone = rs.getString(7);


				Student s = new Student(sId, sName, sSex, sBirthday, sProvince, sHobby, sPhone);


				Student.students.add(s);
			}
		}
		catch (SQLException ex) {
			String[] options3 ={"新建MyTable数据表","取消"};
			int strength3 = JOptionPane.showOptionDialog(null,"表MyTable不存在!", "信息", JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE, null, options3, options3[0]);
			if(strength3 == javax.swing.JOptionPane.YES_OPTION){
				System.out.println("The Table not exsits.");
			}
			if(strength3 == javax.swing.JOptionPane.INFORMATION_MESSAGE){
				System.exit(0);
			}

		}

		/**
		 * 事件监听
		 */
		/*下拉菜单事件监听*/
		box.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String Str=(String) box.getSelectedItem();
				pageCount=Integer.parseInt(Str);
				initTable();
				System.out.println(pageCount);

			}
		});


	}

	/**
	 * 获取下一页
	 */
	public int getNextPage(){
		if(this.currentPage!=this.totalPage){
			return ++currentPage;
		}
		return -1;
	}

	/**
	 * 获取上一页
	 */
	public int getPreviousPage(){
		if(this.currentPage!=1){
			return --currentPage;
		}
		return -1;
	}

	/**
	 * 获取最后一页
	 */
	public int getLastPage(){
		currentPage = totalPage;
		return currentPage;
	}

	/**
	 * 获取第一页
	 */
	public int getFirstPage(){
		currentPage = 1;
		return currentPage;
	}

	/**
	 * 获取总页数
	 *
	 *
	 */
	public int getTotolPage(){
		return this.totalPage;
	}

	/**
	 * 获取当前页
	 */
	public int getCurrentPage(){
		return this.currentPage;
	}

	/**
	 * 获得原始数据集
	 * @param students
	 * @return String sId, String sName, String sSex, String sBirthday,
	String sProvince, String sHobby, String sPhone
	 */
	public Object[][] getData(List<Student> students){
		if(students.size()>0){
			Object[][] data=new Object[students.size()][4];
			for(int i=0;i<students.size();i++){
				Student s=students.get(i);
				Object[] a={s.getsId(),s.getsName(),s.getsSex(),s.getsBirthday(),s.getsProvince(),s.getsHobby(), s.getsPhone()};//把List**的数据赋给Object数组
				data[i]=a;//把数组的值赋给二维数组的一行
			}
			return data;
		}
		return null;
	}

	/**
	 * 初始化结果集
	 * @param data
	 */
	public void initResultData(Object[][] data){
		if(data!=null){
			String Str=(String) box.getSelectedItem();
			pageCount=Integer.parseInt(Str);
			resultData=data;//总的结果集
			column=data[0].length;//表的列数
			totalRowCount=data.length;//表的长度
			totalPage=totalRowCount%pageCount==0?totalRowCount/pageCount:totalRowCount/pageCount+1;//结果集的总页数
			restCount=totalRowCount%pageCount==0?pageCount:totalRowCount%pageCount;//最后一页的数据数
			label1.setText("总共"+totalRowCount+"记录|当前第"+currentPage+"页");
		}else{
			restCount=0;
		}
	}

	/**
	 * 获取分页数据
	 * @return
	 */
	public Object[][] getPageData(){
		Object[][] currentPageData=new Object[pageCount][column];//构造每页数据集
		if(this.getCurrentPage()<this.totalPage){//如果当前页数小于总页数，那么每页数目应该是规定的数pageCount
			for(int i=pageCount*(this.getCurrentPage()-1);i<pageCount*(this.getCurrentPage()-1)+pageCount;i++){
				for(int j=0;j<column;j++){
					//把结果集中对应每页的每一行数据全部赋值给当前页的每一行的每一列
					currentPageData[i%pageCount][j]=resultData[i][j];
				}
			}
		}else{
			//在动态改变数据结果集的时候，如果当前页没有数据了，则回到前一页（一般针对最后一页而言）
			if(pageCount*(this.getCurrentPage()-1)>=totalRowCount)this.currentPage--;
			for(int i=pageCount*(this.getCurrentPage()-1);i<pageCount*(this.getCurrentPage()-1)+restCount;i++){
				for(int j=0;j<column;j++){
					currentPageData[i%pageCount][j]=resultData[i][j];
				}
			}
		}
		return currentPageData;
	}

	/**
	 * 初始化表格数据
	 */
	public void initTable(){
		Object[][] data=getData(students);
		if(data!=null){
			initResultData(data);
			model=new DefaultTableModel(getPageData(),columnNames);
		}else{
			//如果结果集中没有数据，那么就用空来代替数据集中的每一行
			initResultData(data);
			Object[][] nothing={{},{},{},{},{}};
			model=new DefaultTableModel(nothing,columnNames);
			totalRowCount=0;
		}
		table.setModel(model);
		table.setRowHeight(20);
		DefaultTableCellRenderer r=new DefaultTableCellRenderer();
		r.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, r);
	}

	/**
	 * 按钮事件
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//String ItemName = e.getActionCommand();
		String[] data = new String[4];
		JButton button=(JButton) e.getSource();
		if(button.equals(first)){
			int i=getFirstPage();
			if(i==-1)return;
		}
		if(button.equals(previous)){
			int i=getPreviousPage();
			if(i==-1)return;
		}
		if(button.equals(next)){
			int i=getNextPage();
			if(i==-1)return;
		}
		if(button.equals(last)){
			int i=getLastPage();
			if(i==-1)return;
		}

		/*this.getContentPane().add(modifyBtn);
		this.getContentPane().add(deleteBtn);
		this.getContentPane().add(exportExcelBtn);
		this.getContentPane().add(backBtn);*/
		if(button.equals(modifyBtn)){

		}
		if(button.equals(deleteBtn)){

		}
		if(button.equals(exportExcelBtn)){

		}
		if(button.equals(backBtn)){
			setVisible(false);
		}

		if(button.equals(query)){

			data[0] = studentIdContent.getText();
			data[1] = studengNameContent.getText();
			data[2] = studentProvinceContent.getText();
			data[3] = studentSexContent.getText();

			StudentController studentController = new StudentControllerImpl();
			ResultSet rs = null;
			rs = studentController.queryForCondition(data);
			if(rs==null){
				JOptionPane.showMessageDialog(null, "依据该条件没有查询到相应的信息","消息提示",JOptionPane.WARNING_MESSAGE);
				initTable();
			}else{
				try{
					ResultSetMetaData  metaData;
					metaData = rs.getMetaData();
					int number=metaData.getColumnCount();
					students.clear();
					while(rs.next()){
						String sId = rs.getString(1);
						String sName = rs.getString(2);
						String sSex = rs.getString(3);
						String sBirthday = rs.getString(4);
						String sProvince = rs.getString(5);
						String sHobby = rs.getString(6);
						String sPhone = rs.getString(7);


						Student s = new Student(sId, sName, sSex, sBirthday, sProvince, sHobby, sPhone);


						Student.students.add(s);
					}
				}catch (SQLException ex) {
					String[] options3 ={"新建MyTable数据表","取消"};
					int strength3 = JOptionPane.showOptionDialog(null,"表MyTable不存在!", "信息", JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE, null, options3, options3[0]);
					if(strength3 == javax.swing.JOptionPane.YES_OPTION){
						System.out.println("The Table not exsits.");
					}
					if(strength3 == javax.swing.JOptionPane.INFORMATION_MESSAGE){
						System.exit(0);
					}

				}

				initTable();
			}


		}
		Object[][] currentPageData=new Object[pageCount][column];//构造每页数据集

		if(this.getCurrentPage()==1){
			for(int i=pageCount*(this.getCurrentPage()-1);i<pageCount*(this.getCurrentPage()-1)+restCount;i++){

				for(int j=0;j<column;j++){
					currentPageData[i%pageCount][j]=resultData[i][j];
				}
			}
		}else{
			if(this.getCurrentPage()<this.totalPage){//如果当前页数小于总页数，那么每页数目应该是规定的数pageCount
				for(int i=pageCount*(this.getCurrentPage()-1);i<pageCount*(this.getCurrentPage()-1)+pageCount;i++){
					for(int j=0;j<column;j++){
						//把结果集中对应每页的每一行数据全部赋值给当前页的每一行的每一列
						currentPageData[i%pageCount][j]=resultData[i][j];
					}
				}
			}else{
				//在动态改变数据结果集的时候，如果当前页没有数据了，则回到前一页（一般针对最后一页而言）
				System.out.println(this.getCurrentPage());
				if(pageCount*(this.getCurrentPage()-1)>=totalRowCount)this.currentPage--;
				for(int i=pageCount*(this.getCurrentPage()-1);i<pageCount*(this.getCurrentPage()-1)+restCount;i++){
					/*if(i==-20){
						System.out.println("i=-20 ");
						i=0;

					}*/
					for(int j=0;j<column;j++){
						currentPageData[i%pageCount][j]=resultData[i][j];
					}
				}
			}
		}



		DefaultTableModel model=new DefaultTableModel(currentPageData,columnNames);
		table.setModel(model);
		label1.setText("总共"+totalRowCount+"记录|当前第"+currentPage+"页");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		QueryStudentInfo q = new QueryStudentInfo();
	}
}  

