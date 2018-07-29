import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
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
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
		JLabel text = new JLabel("Nada");
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setBounds(134, 33, 179, 14);
		contentPane.add(text);
		
		JButton btnClicMe = new JButton("Click me");
		btnClicMe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				text.setText("Tu m'as cliqué");
				
			}
		});
		btnClicMe.setBounds(154, 100, 89, 23);
		contentPane.add(btnClicMe);
		
		
	}
}
