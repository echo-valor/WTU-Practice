package view;

import model.dao.StudentDao;
import org.jb2011.lnf.beautyeye.ch3_button.BEButtonUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class ImportExcel extends JFrame implements ActionListener/*,PropertyChangeListener*/{
	private JFrame jf=new JFrame("导入到数据库");
	//private ProgressMonitor progressMonitor;
	public String filepath;
	public StudentDao studao;
	//public Task task;
	//public static int p;
	private TextField textpath=new TextField();
	private Font font1 = new Font("楷体", 0, 20);
	private Font font2=new Font("楷体", 0, 20);
	private Toolkit toolkit = Toolkit.getDefaultToolkit(); // 获得系统默认工具类
	private Dimension sc = toolkit.getScreenSize(); // 获得屏幕尺寸
	private JButton imbtn=new JButton("导入到数据库");
	private JLabel fname=new JLabel("文件：");
	private Container con = jf.getContentPane(); // 获得面板
	//	class Task extends SwingWorker<Void, Void> {
//        @Override
//        public Void doInBackground() {
//        	int progress=0;
//        	setProgress(0);
//			while(progress<100&&!isCancelled()) {
//				progress=p;
//				setProgress(Math.min(progress, 100));
//			}
//			return null;
//
//        }
//        @Override
//        public void done() {
//        	Toolkit.getDefaultToolkit().beep();
//        	imbtn.setEnabled(true);
//        	progressMonitor.setProgress(0);
//        }
//    }
	public ImportExcel() {
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




	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		filepath=textpath.getText().toString();
		try {
			studao.importDB(filepath);
		} catch (IOException | SQLException | InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
//		progressMonitor=new ProgressMonitor(ImportExcel.this, "正在执行", "", 0, 100);
//		progressMonitor.setProgress(0);
//
//		task=new Task();
//		task.addPropertyChangeListener(this);
//		task.execute();
//		imbtn.setEnabled(false);
//		try {
//			studao.importDB(filepath);
//		} catch (IOException | SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
	}
//	@Override
//	public void propertyChange(PropertyChangeEvent e) {
//		// TODO Auto-generated method stub
//		if("progress"==e.getPropertyName()) {
//			int progress=(Integer)e.getNewValue();
//			progressMonitor.setProgress(progress);
//			String message =
//		            String.format("Completed %d%%.\n", progress);
//			progressMonitor.setNote(message);
//			if(progressMonitor.isCanceled()||task.isDone()) {
//				Toolkit.getDefaultToolkit().beep();
//				if(progressMonitor.isCanceled()) {
//					task.cancel(true);
//					ShowMessageUtil.winMessage("任务取消！");
//
//				}else {
//					ShowMessageUtil.winMessage("任务完成！");
//				}
//				imbtn.setEnabled(true);
//			}
//		           
//		}
//	}
}
        
	

