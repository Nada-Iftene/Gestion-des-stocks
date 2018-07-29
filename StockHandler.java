import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class StockHandler extends JFrame {

	private JPanel contentPane;
	private JTextField nameField;
	private JTextField categoryField;
	private JTextField codeField;
	private JTextField priceField;
	private JTextField deleteField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockHandler frame = new StockHandler();
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
	public StockHandler() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNom.setHorizontalAlignment(SwingConstants.CENTER);
		lblNom.setBounds(85, 97, 56, 16);
		contentPane.add(lblNom);
		
		nameField = new JTextField();
		nameField.setBounds(161, 95, 116, 22);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblType = new JLabel("Cat\u00E9gorie:");
		lblType.setHorizontalAlignment(SwingConstants.CENTER);
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblType.setBounds(65, 147, 76, 16);
		contentPane.add(lblType);
		
		categoryField = new JTextField();
		categoryField.setColumns(10);
		categoryField.setBounds(161, 145, 116, 22);
		contentPane.add(categoryField);
		
		JLabel lblCode = new JLabel("Code:");
		lblCode.setHorizontalAlignment(SwingConstants.CENTER);
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCode.setBounds(85, 193, 56, 16);
		contentPane.add(lblCode);
		
		codeField = new JTextField();
		codeField.setColumns(10);
		codeField.setBounds(161, 191, 116, 22);
		contentPane.add(codeField);
		
		JLabel lblPrix = new JLabel("Prix:");
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrix.setBounds(85, 242, 56, 16);
		contentPane.add(lblPrix);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(161, 240, 116, 22);
		contentPane.add(priceField);
		
		JLabel lblHome = new JLabel("Gestion du stock");
		lblHome.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHome.setHorizontalAlignment(SwingConstants.CENTER);
		lblHome.setBounds(85, 31, 192, 22);
		contentPane.add(lblHome);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(308, 93, 240, 245);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"nom", "cat\u00E9gorie", "code", "prix"
			}
		));
		DefaultTableModel model = (DefaultTableModel) table.getModel()
;		scrollPane.setViewportView(table);

JLabel som = new JLabel("00.00");
som.setHorizontalAlignment(SwingConstants.RIGHT);
som.setBounds(461, 383, 64, 14);
contentPane.add(som);

JLabel lblNewLabel_1 = new JLabel("La somme :");
lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
lblNewLabel_1.setBounds(351, 383, 76, 14);
contentPane.add(lblNewLabel_1);
		
		JButton addButton = new JButton("Ajouter le produit");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				float price = Float.valueOf(priceField.getText());
			    int cod = Integer.valueOf(codeField.getText());
			    
				Produit prd = new Produit(
						nameField.getText(),
						categoryField.getText(),
						cod,
						price
						);
				
				Object[] a = {prd.getNom(),
							  prd.getCategory(),
							  prd.getCode(),
							  prd.getPrix() };
							 
				model.addRow(a);
				
				nameField.setText("");
				categoryField.setText("");
				priceField.setText("");
				codeField.setText("");
			}
		});

		addButton.setBounds(85, 317, 192, 25);
		contentPane.add(addButton);
		
		
		JLabel label = new JLabel("Nom:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(85, 377, 56, 16);
		contentPane.add(label);
		
		deleteField = new JTextField();
		deleteField.setColumns(10);
		deleteField.setBounds(161, 375, 116, 22);
		contentPane.add(deleteField);
		
		JButton deleteButton = new JButton("Supprimer le produit");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String search = deleteField.getText();
				int index = 0;
				
				boolean found = false;
				for(int i=0;i < model.getRowCount();i++){
					if(search.equals(model.getValueAt(i, 0))){
						index = i;
						found = true;
						
					}
				}
				if(found == true){
					model.removeRow(index);
					
				}
			}
		});
		deleteButton.setBounds(85, 418, 192, 25);
		contentPane.add(deleteButton);
		
		
	}
}
