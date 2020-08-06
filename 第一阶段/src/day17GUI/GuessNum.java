package day17GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessNum {

	private JFrame frame;
	private JTextField text_num;
	int index;
	int i=1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuessNum window = new GuessNum();
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
	public GuessNum() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLocationRelativeTo(null);//设置窗口显示在中央
		frame.setResizable(false);//设置不允许调整窗口大小
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		text_num = new JTextField();
		text_num.setBounds(45, 20, 333, 33);
		frame.getContentPane().add(text_num);
		text_num.setColumns(10);
		
		JLabel text_con = new JLabel("\u8BF7\u8F93\u51651\u523010\u4EE5\u5185\u7684\u6570\u5B57");
		text_con.setBounds(154, 88, 136, 21);
		frame.getContentPane().add(text_con);
		
		JButton cai = new JButton("\u731C");
		//猜
		index=getRandom();
		cai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1.获取用户输入的值
				int num=Integer.parseInt(text_num.getText());
				//获取随机数
				if(index==num) {
					text_con.setText("恭喜猜中了");
				}else if(index>num) {
					text_con.setText("猜太小了");

				}else {
					text_con.setText("猜太大了");

				}
			
			}
		});
		cai.setBounds(23, 166, 93, 23);
		frame.getContentPane().add(cai);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		//重置按钮单击事件
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1清空输入框
				text_num.setText("");
				//2重写table的值
				text_con.setText("请输入1到10的随机数");
				//从新获得随机数
				index=getRandom();
				JOptionPane.showMessageDialog(null, "已重新获取随机数");
				//4获取焦点
				text_num.grabFocus();
			}
		});
		reset.setBounds(154, 166, 93, 23);
		frame.getContentPane().add(reset);
		
		JButton exit = new JButton("\u9000\u51FA");
		//退出按钮的点击事件 
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(null, "确定要退出吗");
				if(n==0) {
					System.exit(0);//退出程序

				}
				
			}
		});
		exit.setBounds(285, 166, 93, 23);
		frame.getContentPane().add(exit);
		
		JLabel show = new JLabel("\u7B2C\u4E00\u4E2A\u7A97\u53E3");
		show.setBounds(23, 76, 78, 15);
		frame.getContentPane().add(show);
		
		JButton login = new JButton("\u767B\u5F55");
		//登录按钮的事件
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//show.setText("已点击");
				show.setText("你点击"+i+++"次");

			}
		});
		login.setBounds(8, 114, 93, 23);
		frame.getContentPane().add(login);
	}
	/*
	 * 获取随机数
	 */
	public int getRandom() {
		return (int)(Math.random()*10+1);
		
	}
}
