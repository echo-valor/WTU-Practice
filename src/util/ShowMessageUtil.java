package util;

		import javax.swing.JOptionPane;

public class ShowMessageUtil {

	public static void winMessage(String str) {
		JOptionPane.showMessageDialog(null, str, "导出Excel",
				JOptionPane.INFORMATION_MESSAGE);
	}
}

