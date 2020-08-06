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
		frame.setLocationRelativeTo(null);//���ô�����ʾ������
		frame.setResizable(false);//���ò�����������ڴ�С
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
		//��
		index=getRandom();
		cai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1.��ȡ�û������ֵ
				int num=Integer.parseInt(text_num.getText());
				//��ȡ�����
				if(index==num) {
					text_con.setText("��ϲ������");
				}else if(index>num) {
					text_con.setText("��̫С��");

				}else {
					text_con.setText("��̫����");

				}
			
			}
		});
		cai.setBounds(23, 166, 93, 23);
		frame.getContentPane().add(cai);
		
		JButton reset = new JButton("\u91CD\u7F6E");
		//���ð�ť�����¼�
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//1��������
				text_num.setText("");
				//2��дtable��ֵ
				text_con.setText("������1��10�������");
				//���»�������
				index=getRandom();
				JOptionPane.showMessageDialog(null, "�����»�ȡ�����");
				//4��ȡ����
				text_num.grabFocus();
			}
		});
		reset.setBounds(154, 166, 93, 23);
		frame.getContentPane().add(reset);
		
		JButton exit = new JButton("\u9000\u51FA");
		//�˳���ť�ĵ���¼� 
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�˳���");
				if(n==0) {
					System.exit(0);//�˳�����

				}
				
			}
		});
		exit.setBounds(285, 166, 93, 23);
		frame.getContentPane().add(exit);
		
		JLabel show = new JLabel("\u7B2C\u4E00\u4E2A\u7A97\u53E3");
		show.setBounds(23, 76, 78, 15);
		frame.getContentPane().add(show);
		
		JButton login = new JButton("\u767B\u5F55");
		//��¼��ť���¼�
		
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//show.setText("�ѵ��");
				show.setText("����"+i+++"��");

			}
		});
		login.setBounds(8, 114, 93, 23);
		frame.getContentPane().add(login);
	}
	/*
	 * ��ȡ�����
	 */
	public int getRandom() {
		return (int)(Math.random()*10+1);
		
	}
}
