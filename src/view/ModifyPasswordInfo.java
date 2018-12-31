package view;

import model.dao.UserDao;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class ModifyPasswordInfo implements ActionListener {
	private JPasswordField y = new JPasswordField();
	private JPasswordField x = new JPasswordField();
	private JPasswordField q = new JPasswordField();
	private JLabel ypsd = new JLabel("原密码:");
	private JLabel xpsd = new JLabel("新密码:");
	private JLabel qpsd = new JLabel("确认密码:");
	private JFrame frame = new JFrame("请输入密码信息");
	private JButton modify = new JButton("修改");
	private JButton exit = new JButton("取消");
	private JButton back = new JButton("返回");
	Font fnt = new Font("Serief", Font.PLAIN + Font.BOLD, 17);

	public ModifyPasswordInfo() {
		ypsd.setBounds(40, 0, 100, 80);
		xpsd.setBounds(40, 90, 100, 80);
		qpsd.setBounds(40, 195, 100, 80);
		y.setBounds(120, 28, 200, 30);
		x.setBounds(120, 118, 200, 30);
		q.setBounds(120, 223, 200, 30);
		modify.setBounds(19, 300, 80, 30);
		exit.setBounds(139, 300, 80, 30);
		back.setBounds(259, 300, 80, 30);
		modify.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.lightBlue));
		exit.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.green));
		back.setUI(new BEButtonUI()
				.setNormalColor(BEButtonUI.NormalColor.green));
		ypsd.setFont(fnt);
		xpsd.setFont(fnt);
		qpsd.setFont(fnt);
		this.frame.add(ypsd);
		this.frame.add(xpsd);
		this.frame.add(qpsd);
		this.frame.add(y);
		this.frame.add(x);
		this.frame.add(q);
		this.frame.add(modify);
		this.frame.add(exit);
		this.frame.add(back);
		this.frame.setLayout(null);
		this.frame.setSize(450, 430);
		this.frame.setLocation(400, 100);
		// this.frame.getContentPane().setBackground(Color.green);
		this.frame.setVisible(true);
		this.frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
			}
		});
		this.modify.addActionListener(this);
		this.exit.addActionListener(this);
		this.back.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == this.modify) {// 判断是否是修改操作
			String xpd = null;
			String qpd = null;
			String ypd = null;
			ypd = new String(y.getPassword());
			xpd = new String(x.getPassword());
			qpd = new String(q.getPassword());
			if (!(ypd.equals(Login.ypsd))) {
				JOptionPane.showMessageDialog(null, "原密码不正确", "消息提示",
						JOptionPane.WARNING_MESSAGE);
			} else if (!(xpd.equals(qpd))) {
				JOptionPane.showMessageDialog(null, "两次密码不一致，请检查", "消息提示",
						JOptionPane.WARNING_MESSAGE);
			}
			/*
			 * else if(!(xpd.matches(
			 * "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9][A-Za-z0-9]{6,10}$"))) {
			 * JOptionPane.showMessageDialog(null,
			 * "两次密码不一致，请检查","消息提示",JOptionPane.WARNING_MESSAGE); }
			 */
			else {
				UserDao ud = new UserDao();
				try {
					ud.modifypassword(xpd);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "修改成功", "消息提示",
						JOptionPane.WARNING_MESSAGE);
			}
		}
		if (e.getSource() == this.exit) { // 判断是否是取消操作
			x.setText("");
			q.setText("");
		}
		if (e.getSource() == this.back) { // 判断是否是返回操作
			frame.setVisible(false);
		}
	}
}
