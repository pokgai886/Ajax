package day17GUI;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import day18con.etc.dao.UserDao;
import day18con.etc.entity.User;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JMenuItem;

public class mainFrame {

	private JFrame frame;
	private static JTable table_1;
	private JTextField username;
	UserDao userdao=new UserDao();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					mainFrame window = new mainFrame();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public mainFrame(String uname) {
		initialize(uname);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String uname) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lable = new JLabel("\u6B22\u8FCE\u6765\u5230\u4E3B\u9875\u9762");
		lable.setBounds(10, 10, 154, 15);
		frame.getContentPane().add(lable);
		lable.setText("��ӭ"+uname+"������ҳ��");
		
		JButton button = new JButton("\u4FEE\u6539\u4FE1\u606F");
		button.setBounds(174, 6, 93, 23);
		//�޸���Ϣ
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("\u7528\u6237\u540D:");
		label.setBounds(10, 47, 54, 15);
		frame.getContentPane().add(label);
		
		JButton button_1 = new JButton("\u67E5\u8BE2");
		//��ѯ��ť�¼�
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1�ж��û����Ƿ�Ϊ��
				String name=username.getText();
				if(name.equals("") || name.trim()==null) {
					//��ѯȫ��
					query();
				}else {
					//��Ϊ�վ�ģ����ѯ
					List<User> list= new UserDao().queryLikeAll(name);

					String[] col= {"�û����","�û���","����","�Ա�"};
					Object[][] data=new Object[list.size()][4];
					for(int i=0;i<list.size();i++) {
						User user=list.get(i);
						data[i][0]=user.getUid();
						data[i][1]=user.getUname();
						data[i][2]=user.getUpwd();
						data[i][3]=user.getUsex();
					}
					table_1.setModel(new DefaultTableModel(
						data,
						col
					));
				}
			}
		});
		button_1.setBounds(224, 43, 93, 23);
		frame.getContentPane().add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 72, 318, 243);
		frame.getContentPane().add(scrollPane);
		//�������ģ��
		table_1 = new JTable();
		query();
		
		scrollPane.setViewportView(table_1);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(table_1, popupMenu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539");
		//�޸�
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//��ȡ��ǰID,�õ���������
				Object obj=table_1.getValueAt(table_1.getSelectedRow(), 0);
				User user=userdao.queryById((int)obj);
				UpdateFrame updateframe=new UpdateFrame(user);
			}
		});
		popupMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("\u5220\u9664");
		//ɾ����ť����¼�
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(null,"�Ƿ�Ҫɾ��","ɾ����ʾ��",JOptionPane.YES_NO_OPTION);
				if(n==0) {
					Object obj=table_1.getValueAt(table_1.getSelectedRow(), 0);
				boolean flag=userdao.deleUser((Integer)obj);
				if(flag) {
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
					query();
				}else {
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��");
				}
				
				
				}
			}
		});
		popupMenu.add(menuItem_1);
		
		username = new JTextField();
		username.setBounds(60, 44, 104, 21);
		frame.getContentPane().add(username);
		username.setColumns(10);
		frame.setVisible(true);
	}
	public static void query() {
		String[] col= {"�û����","�û���","����","�Ա�"};
		List<User> list=new UserDao().queryAll();
		Object[][] data=new Object[list.size()][4];
		for(int i=0;i<list.size();i++) {
			User user=list.get(i);
			data[i][0]=user.getUid();
			data[i][1]=user.getUname();
			data[i][2]=user.getUpwd();
			data[i][3]=user.getUsex();
		}
		table_1.setModel(new DefaultTableModel(
			data,
			col
		));
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
