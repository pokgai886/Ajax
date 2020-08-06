package day17GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.etc.service.Userdaoservice;

import day18con.etc.dao.UserDao;
import day18con.etc.entity.User;

import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterFrame {

	private JFrame frame;
	private JTextField username;
	private JPasswordField userpwd;
	//UserDao userdao=new UserDao();
	Userdaoservice userdao=new Userdaoservice();


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterFrame window = new RegisterFrame();
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
	public RegisterFrame() {
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
		frame.setLocationRelativeTo(null);
		
		JLabel username000 = new JLabel("\u7528\u6237\u540D:");
		username000.setBounds(10, 75, 65, 15);
		frame.getContentPane().add(username000);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801:");
		lblNewLabel_1.setBounds(10, 125, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u6027  \u522B:");
		label.setBounds(10, 176, 54, 15);
		frame.getContentPane().add(label);
		
		username = new JTextField();
		username.setBounds(58, 72, 66, 21);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		userpwd = new JPasswordField();
		userpwd.setBounds(58, 122, 66, 21);
		frame.getContentPane().add(userpwd);
		
		JRadioButton man = new JRadioButton("\u7537");
		man.setBounds(53, 172, 121, 23);
		frame.getContentPane().add(man);
		
		JRadioButton woman = new JRadioButton("\u5973");
		woman.setBounds(58, 206, 121, 23);
		frame.getContentPane().add(woman);
		frame.setVisible(true);
		
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		/**
		 * 注册按钮点击事件
		 */
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//1 获取注册信息
			//用户名
				String uname=username.getText();
			//密码
				char[] ch=userpwd.getPassword();
				String pwd=new String(ch);
			//性别
				String sex=man.isSelected()?man.getText():woman.getText();
			//2调用数据库选框性别
				int n=userdao.registerUser(new User(uname,pwd,sex));
				if(n==0) {
					JOptionPane.showMessageDialog(null, "注册成功");
				}else if(n==2){
					JOptionPane.showMessageDialog(null, "注册失败,用户名已经存在");
				}else if(uname=="00" || pwd.equals(null)){
					JOptionPane.showMessageDialog(null, "注册失败");
				}
			
			
			}
		});
		btnNewButton.setBounds(10, 229, 93, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
