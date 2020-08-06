package day17GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import day18con.etc.dao.UserDao;
import day18con.etc.entity.User;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame {

	private JFrame frame;
	private JTextField username;
	private JPasswordField userpwd;
	UserDao userdao=new UserDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame window = new LoginFrame();
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
	public LoginFrame() {
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
		
		username = new JTextField();
		username.setBounds(170, 82, 99, 21);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JButton button = new JButton("\u767B\u5F55");
		//��¼��ť����¼�
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1��ȡ�û���������
				String uname=username.getText();
				char[] ch=userpwd.getPassword();
				String pwd=new String(ch);
				//2�ж��û��������Ƿ�Ϊ��
				if(!uname.equals("") && !pwd.equals("")) {
					User user=userdao.login(uname,pwd);
					if(user!=null) {
						//a.������ʾ
						JOptionPane.showMessageDialog(null, "��½�ɹ�");
						//b.��ת����ҳ��
						mainFrame mf=new mainFrame(uname);
						//mf.query();
						//c���ص�ǰҳ��
						frame.setVisible(false);
					
					}else {
						//
						JOptionPane.showMessageDialog(null, "��½ʧ��");

					}
				}else {
					//��ʾ������Ϊ��
					JOptionPane.showMessageDialog(null, "�û��������벻��Ϊ��");
				}
				
			}
		});
		button.setBounds(60, 217, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterFrame rf=new RegisterFrame();
			}
		});
		button_1.setBounds(210, 217, 93, 23);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D:");
		lblNewLabel.setBounds(72, 85, 54, 15);
		frame.getContentPane().add(lblNewLabel);
		
		userpwd = new JPasswordField();
		userpwd.setBounds(170, 132, 99, 21);
		frame.getContentPane().add(userpwd);
		
		JLabel label = new JLabel("\u5BC6  \u7801:");
		label.setBounds(72, 135, 54, 15);
		frame.getContentPane().add(label);
	}
}
