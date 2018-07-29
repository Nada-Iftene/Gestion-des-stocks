import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 335, 403);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		userName = new JTextField();
		userName.setBounds(113, 73, 98, 20);
		contentPane.add(userName);
		userName.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(113, 149, 98, 20);
		contentPane.add(password);
		
		JLabel lblNewLabel = new JLabel("User name");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 42, 127, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassWord = new JLabel("Password");
		lblPassWord.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassWord.setBounds(95, 118, 127, 20);
		contentPane.add(lblPassWord);
		
		JLabel message = new JLabel("Welcome");
		message.setFont(new Font("Tahoma", Font.PLAIN, 16));
		message.setHorizontalAlignment(SwingConstants.CENTER);
		message.setBounds(37, 17, 248, 14);
		contentPane.add(message);
		
		JLabel help = new JLabel("");
		help.setHorizontalAlignment(SwingConstants.CENTER);
		help.setBounds(51, 316, 224, 14);
		contentPane.add(help);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String pwd = String.valueOf(password.getPassword());
				if(userName.getText().matches("admin") && pwd.matches("azerty")){
					StockHandler sth = new StockHandler();
					sth.setVisible(true);
					setVisible(false);
				//message.setText("welcome admin !");
				}
				else{
					message.setText("Wrong user name or password");
				}
				
				
			}
		});
		btnLogin.setBounds(22, 261, 103, 23);
		contentPane.add(btnLogin);
		
		JButton btnForGetPassword = new JButton("Forgot password");
		btnForGetPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				help.setText("your password is azerty");
			}
		});
		btnForGetPassword.setBounds(179, 261, 130, 23);
		contentPane.add(btnForGetPassword);
		
		
		
		
	}
}
