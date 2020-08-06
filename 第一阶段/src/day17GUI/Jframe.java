package day17GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Jframe {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jframe window = new Jframe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Jframe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 41, 296, 159);
		frame.getContentPane().add(scrollPane);
		//创建表格模板
		table = new JTable();
		//显示列名
		String[] col= {"  编号", "  姓名"};
		Object[][] data=new Object[5][2];
		table.setModel(new DefaultTableModel(
				data,
			col
		));
		scrollPane.setViewportView(table);
	}
}
