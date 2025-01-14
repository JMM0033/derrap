package Vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VFormCrud extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public VFormCrud() {
		setBackground(new Color(209, 215, 222));
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Añadir Cita");
		lblNewLabel.setBounds(0, 11, 304, 29);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Matrícula");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(61, 66, 203, 19);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(61, 96, 203, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(61, 126, 203, 19);
		getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(61, 156, 203, 19);
		getContentPane().add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hora");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(61, 186, 203, 19);
		getContentPane().add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(61, 216, 203, 19);
		getContentPane().add(textField_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Motivo Cita");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(61, 246, 203, 19);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(61, 277, 203, 77);
		getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBackground(new Color(105, 107, 110));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(138, 407, 75, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnAadir = new JButton("Añadir");
		btnAadir.setBackground(new Color(105, 107, 110));
		btnAadir.setBounds(223, 407, 71, 23);
		getContentPane().add(btnAadir);

	}
}
