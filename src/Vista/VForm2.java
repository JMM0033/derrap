package Vista;



import java.awt.Cursor;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;

import javax.swing.JFrame;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import Controlador.RoundedPanel;
import Modelo.Cliente;
import Modelo.Vehiculo;

import javax.swing.JLabel;

import javax.swing.JOptionPane;



import java.awt.Font;

import java.awt.Image;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;

import javax.swing.JTextArea;

import java.awt.Color;
import javax.swing.SwingConstants;



public class VForm2 extends JFrame {



	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	private JTextField textField;

	private JTextField textField_1;

	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private Vehiculo vehiculo;
	private VPAdmin vpAdmin;
	int opcion;
	private JPanel btnAceptar;
	private JPanel btnCancelar;
	private JTextField textField_6;

	public VForm2(Vehiculo v, VPAdmin vpAdmin, int opcion) {//Opcion 0 = Nuevo Cliente ;; Opcion 1 = Editar Cliente
		this.vehiculo = v;
		this.vpAdmin = vpAdmin;
		this.opcion = opcion;

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);

		setBounds(100, 100, 320, 480);

		contentPane = new JPanel();

		contentPane.setBackground(new Color(209, 215, 222));

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));



		setContentPane(contentPane);

		contentPane.setLayout(null);

		


		

		JLabel lblNewLabel_1 = new JLabel("Matrícula");

		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_1.setBounds(58, 69, 150, 14);

		contentPane.add(lblNewLabel_1);

		

		textField = new JTextField();

		textField.setBounds(58, 83, 203, 24);


		textField.setColumns(10);

		

		textField_1 = new JTextField();

		textField_1.setColumns(10);

		textField_1.setBounds(58, 131, 203, 24);


		

		JLabel lblNewLabel_1_1 = new JLabel("Marca");

		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_1_1.setBounds(58, 117, 106, 14);

		contentPane.add(lblNewLabel_1_1);

		

		JLabel lblNewLabel_1_1_1 = new JLabel("Modelo");

		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		lblNewLabel_1_1_1.setBounds(58, 165, 53, 14);

		contentPane.add(lblNewLabel_1_1_1);

		

		textField_2 = new JTextField();

		textField_2.setColumns(10);

		textField_2.setBounds(58, 179, 203, 24);

		

		

		

		

		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(58, 227, 203, 24);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Año");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_1.setBounds(58, 213, 106, 14);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(58, 323, 203, 24);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Color");
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2.setBounds(58, 309, 133, 14);
		contentPane.add(lblNewLabel_1_1_1_2);
		

		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("ID del Cliente");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1_2_1.setBounds(58, 261, 133, 14);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(58, 275, 203, 24);

		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));

		lblNewLabel.setBounds(10, 28, 286, 19);

		contentPane.add(lblNewLabel);

		if (opcion == 1) {
			setTitle("Editar Vehiculo");
			lblNewLabel.setText("Editar Vehiculo");
			textField.setText(vehiculo.getMatricula());
			textField_1.setText(vehiculo.getMarca());
			textField_2.setText(vehiculo.getModelo());
			textField_3.setText(""+vehiculo.getAno());
			textField_4.setText(vehiculo.getColor());
			textField_5.setEnabled(false);
			textField_5.setText(""+vehiculo.getCliente_id());

		}else if (opcion == 0) {
			setTitle("Crear Vehiculo");
			lblNewLabel.setText("Crear Vehiculo");
			
		}
		

		contentPane.add(textField);
		contentPane.add(textField_1);
		contentPane.add(textField_2);
		contentPane.add(textField_3);
		contentPane.add(textField_4);
		contentPane.add(textField_5);
		Color colorBoton=new Color(76, 87, 92);
        Color colorBotonEntrar=new Color(39, 47, 51);
        
        btnAceptar = new RoundedPanel(15,colorBoton);
        btnAceptar.setOpaque(false);
        btnAceptar.setBounds(188, 403, 108, 30);
        btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnAceptar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
        
        JLabel lblNewLabel_7_1 = new JLabel("Aceptar");
        lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7_1.setForeground(new Color(220, 220, 220));
        lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnAceptar.add(lblNewLabel_7_1);
		contentPane.add(btnAceptar);
        btnAceptar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
				if (opcion == 1) {
					vpAdmin.conexion.editarVehiculo(textField.getText(),textField_1.getText(),textField_2.getText(),Integer.parseInt(textField_3.getText()),textField_4.getText(),vehiculo.getId());
					vpAdmin.crearTablaVehiculos();
					dispose();
				}else if (opcion == 0) {
					vpAdmin.conexion.crearVehiculo(textField.getText(),textField_1.getText(),textField_2.getText(),Integer.parseInt(textField_3.getText()),Integer.parseInt(textField_5.getText()),textField_4.getText());
					vpAdmin.crearTablaVehiculos();
					dispose();
				}
                
            }
            
            @Override
            public void mouseEntered (MouseEvent e) {
                ((RoundedPanel) btnAceptar).cambiarColor(colorBotonEntrar);
                btnAceptar.setBackground(colorBotonEntrar);
            }
            
            @Override
            public void mouseExited (MouseEvent e) {
                ((RoundedPanel) btnAceptar).cambiarColor(colorBoton);
                btnAceptar.setBackground(colorBoton);
                
            }
        });
        
        btnCancelar = new RoundedPanel(15,colorBoton);
        btnCancelar.setOpaque(false);
        btnCancelar.setBounds(70, 403, 108, 30);
        btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancelar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
        
        JLabel lblNewLabel_7_2 = new JLabel("Cancelar");
        lblNewLabel_7_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7_2.setForeground(new Color(220, 220, 220));
        lblNewLabel_7_2.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCancelar.add(lblNewLabel_7_2);
		contentPane.add(btnCancelar);
		
		
        
        btnCancelar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				dispose();
                
            }
            
            @Override
            public void mouseEntered (MouseEvent e) {
                ((RoundedPanel) btnCancelar).cambiarColor(colorBotonEntrar);
                btnCancelar.setBackground(colorBotonEntrar);
            }
            
            @Override
            public void mouseExited (MouseEvent e) {
                ((RoundedPanel) btnCancelar).cambiarColor(colorBoton);
                btnCancelar.setBackground(colorBoton);
                
            }
        });
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // Hacer visible nuevamente la ventana principal
                vpAdmin.setEnabled(true);
                vpAdmin.toFront();
            }
        });

		

	}
}

