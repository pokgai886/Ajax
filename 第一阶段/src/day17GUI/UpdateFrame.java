package day17GUI;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import day18con.etc.dao.UserDao;
import day18con.etc.entity.User;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;

public class UpdateFrame {

	private JFrame frame;
	private JTextField username;
	private JPasswordField userpwd;
	UserDao userdao=new UserDao();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UpdateFrame window = new UpdateFrame();
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
	public UpdateFrame(User user) {
		initialize(user);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User user) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel.setBounds(47, 72, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
		username = new JTextField();
		username.setEditable(false);
		username.setBounds(116, 69, 93, 21);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel label = new JLabel("\u5BC6  \u7801:");
		label.setBounds(47, 127, 54, 15);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u6027  \u522B:");
		label_1.setBounds(47, 175, 54, 15);
		frame.getContentPane().add(label_1);
		
		JRadioButton man = new JRadioButton("\u7537");
		buttonGroup.add(man);
		man.setBounds(107, 171, 121, 23);
		frame.getContentPane().add(man);
		
		JRadioButton woman = new JRadioButton("\u5973");
		buttonGroup.add(woman);
		woman.setBounds(107, 208, 121, 23);
		frame.getContentPane().add(woman);
		
		JButton button = new JButton("\u4FEE\u6539");
		//修改按钮点击事件
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1获取输入信息
				String name=username.getText();
				char[] ch=userpwd.getPassword();
				String pwd=new String(ch);
				String sex=man.isSelected()?man.getText():woman.getText();
				boolean flag=userdao.updateUser(new User(name,pwd,sex));
				if(flag) {
					JOptionPane.showMessageDialog(null, "修改成功");
					frame.dispose();
					mainFrame.query();
				}else {
					JOptionPane.showMessageDialog(null, "修改失败");
				}
			}
		});
		button.setBounds(249, 208, 93, 23);
		frame.getContentPane().add(button);
		
		userpwd = new JPasswordField();
		userpwd.setBounds(116, 124, 93, 21);
		frame.getContentPane().add(userpwd);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.setBounds(236, 127, 114, 23);
		frame.getContentPane().add(button_1);
		//显示原来的信息
		username.setText(user.getUname());
		userpwd.setText(user.getUpwd());
		if(user.getUsex().equals("男")) {
			man.setSelected(true);
		}else {
			woman.setSelected(true);
		}
	}
}
