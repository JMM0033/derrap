package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;

import Controlador.*;
import Modelo.Usuario;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class VClientes extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usuario;
	private ConexionMySQL conexion;

	/**
	 * Create the frame.
	 */
	public VClientes(Usuario usuario, ConexionMySQL conexion) {
		this.usuario = usuario;
		this.conexion = conexion;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 214, 683);
		panelMenu.setBackground(new Color(140, 164, 179));
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblInicio = new JLabel("Inicio");
		lblInicio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInicio.setBackground(new Color(146, 171, 186));
		lblInicio.setBounds(0, 129, 214, 45);
		lblInicio.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblInicio.setOpaque(true);
		lblInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblInicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Yay you clicked me");
            }
        });
		panelMenu.add(lblInicio);
		

		JLabel lblOrdenes = new JLabel("Órdenes de Trabajo");
		lblOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOrdenes.setBackground(new Color(146, 171, 186));
		lblOrdenes.setBounds(0, 184, 214, 45);
		lblOrdenes.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblOrdenes.setOpaque(true);
		lblOrdenes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblOrdenes);
		

		JLabel lblCitas = new JLabel("Citas");
		lblCitas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCitas.setBackground(new Color(146, 171, 186));
		lblCitas.setBounds(0, 239, 214, 45);
		lblCitas.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblCitas.setOpaque(true);
		lblCitas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblCitas);
		

		JLabel lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClientes.setBackground(new Color(146, 171, 186));
		lblClientes.setBounds(0, 294, 214, 45);
		lblClientes.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblClientes.setOpaque(true);
		lblClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblClientes);
		
		JLabel lblVehiculos = new JLabel("Vehículos");
		lblVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVehiculos.setBackground(new Color(146, 171, 186));
		lblVehiculos.setBounds(0, 349, 214, 45);
		lblVehiculos.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblVehiculos.setOpaque(true);
		lblVehiculos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblVehiculos);
		
		JLabel lblAlmacen = new JLabel("Almacén");
		lblAlmacen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAlmacen.setBackground(new Color(146, 171, 186));
		lblAlmacen.setBounds(0, 404, 214, 45);
		lblAlmacen.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblAlmacen.setOpaque(true);
		lblAlmacen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblAlmacen);
		
		JLabel lblAdministracion = new JLabel("Administración");
		lblAdministracion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAdministracion.setBackground(new Color(146, 171, 186));
		lblAdministracion.setBounds(0, 459, 214, 45);
		lblAdministracion.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblAdministracion.setOpaque(true);
		lblAdministracion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblAdministracion);
		
		JLabel lblGestion = new JLabel("Gestión Usuarios");
		lblGestion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGestion.setBackground(new Color(146, 171, 186));
		lblGestion.setBounds(0, 514, 214, 45);
		lblGestion.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblGestion.setOpaque(true);
		lblGestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblGestion);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon = new ImageIcon(VClientes.class.getResource("/img/logoDerrap.png")); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(82, 119,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		lblNewLabel_8.setIcon(new ImageIcon(newimg));
		lblNewLabel_8.setBounds(0, 0, 214, 119);
		panelMenu.add(lblNewLabel_8);
		
		
		JLabel logoLetras = new JLabel("");
		logoLetras.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon2 = new ImageIcon(VClientes.class.getResource("/img/logoDerrapLetras.png")); // load the image to a imageIcon
		Image image2 = imageIcon2.getImage(); // transform it 
		Image newimg2 = image2.getScaledInstance(106, 49,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		logoLetras.setIcon(new ImageIcon(newimg2));
		logoLetras.setBounds(0, 628, 214, 45);
		panelMenu.add(logoLetras);
		
		
		
		JPanel panelMenuSup = new JPanel();
		panelMenuSup.setBounds(214, 0, 1052, 50);
		panelMenuSup.setBackground(new Color(124, 149, 165));
		contentPane.add(panelMenuSup);
		panelMenuSup.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Administrador");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setIcon(new ImageIcon(VClientes.class.getResource("/img/marcador-de-forma-negra (1).png")));
		lblNewLabel_6.setBounds(931, 10, 111, 30);
		panelMenuSup.add(lblNewLabel_6);
		
		Color colorBoton=new Color(140, 174, 145);
		JPanel panel = new RoundedPanel(15,colorBoton);
		panel.setOpaque(false);
		panel.setBounds(805, 10, 116, 30);
		panelMenuSup.add(panel);
		panel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		panel.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				VLogin vpLogin = new VLogin();
				vpLogin.setVisible(true);
				vpLogin.setResizable(false);
				dispose();
            }
		});
		
		JLabel lblNewLabel_7 = new JLabel("Cerrar Sesión");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNewLabel_7);
		
		JPanel ContenedorPrincipal = new JPanel();
		ContenedorPrincipal.setBounds(214, 50, 1052, 633);
		ContenedorPrincipal.setBackground(new Color(163, 188, 204));
		contentPane.add(ContenedorPrincipal);
		ContenedorPrincipal.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Clientes");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 10, 135, 22);
		ContenedorPrincipal.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 121, 1008, 490);
		panel_1.setBackground(new Color(154, 178, 193));
		ContenedorPrincipal.add(panel_1);
		ImageIcon imageIcon3 = new ImageIcon(VClientes.class.getResource("/img/buscarVehiculo.png")); // load the image to a imageIcon
		Image image3 = imageIcon3.getImage(); // transform it 
		Image newimg3 = image3.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon imageIcon4 = new ImageIcon(VClientes.class.getResource("/img/gestionCitas.png")); // load the image to a imageIcon
		Image image4 = imageIcon4.getImage(); // transform it 
		Image newimg4 = image4.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon imageIcon5 = new ImageIcon(VClientes.class.getResource("/img/buscarCliente.png")); // load the image to a imageIcon
		Image image5 = imageIcon5.getImage(); // transform it 
		Image newimg5 = image5.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon imageIcon6 = new ImageIcon(VClientes.class.getResource("/img/consultaAlmacen.png")); // load the image to a imageIcon
		Image image6 = imageIcon6.getImage(); // transform it 
		Image newimg6 = image6.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon imageIcon7 = new ImageIcon(VClientes.class.getResource("/img/gestionarPedidos.png")); // load the image to a imageIcon
		Image image7 = imageIcon7.getImage(); // transform it 
		Image newimg7 = image7.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon imageIcon8 = new ImageIcon(VClientes.class.getResource("/img/buscarVehiculo.png")); // load the image to a imageIcon
		Image image8 = imageIcon8.getImage(); // transform it 
		Image newimg8 = image8.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH);
	}
}
