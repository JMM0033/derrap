package Vista;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;

public class VForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VForm frame = new VForm();
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
	public VForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 320, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(209, 215, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Añadir Cita");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(93, 28, 115, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Matrícula");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(58, 69, 53, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(58, 83, 203, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(58, 131, 203, 24);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Fecha");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(58, 117, 53, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Hora");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(58, 165, 53, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(58, 179, 203, 24);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_2 = new JLabel("Motivo");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(58, 213, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(58, 227, 203, 79);
		contentPane.add(textArea);
		
		JLabel lblAceptar = new JLabel();
		lblAceptar.setBounds(237, 438, 71, 30);
		ImageIcon lblAceptarIcon = new ImageIcon(VForm.class.getResource("/img/ButtonAñadir.png"));
		Image lblAceptarImage = lblAceptarIcon.getImage();
		Image newlblAceptar = lblAceptarImage.getScaledInstance(71, 30, Image.SCALE_DEFAULT);
		lblAceptar.setIcon(new ImageIcon(newlblAceptar));
		lblAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblAceptar.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				}
			});
		
		contentPane.add(lblAceptar);
		
		
		
		JLabel lblCancelar = new JLabel();
		lblCancelar.setBounds(143, 438, 71, 30);
		ImageIcon lblCancelarIcon = new ImageIcon(VForm.class.getResource("/img/ButtonCancelar.png"));
		Image lblCancelarImage = lblCancelarIcon.getImage();
		Image newlblCancelar = lblCancelarImage.getScaledInstance(71, 30, Image.SCALE_DEFAULT);
		lblCancelar.setIcon(new ImageIcon(newlblCancelar));
		lblCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		lblCancelar.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				}
			});
		
		contentPane.add(lblCancelar);
		
	}
}
