package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import Controlador.*;
import Modelo.Cliente;
import Modelo.Usuario;
import Modelo.Vehiculo;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VPAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public Usuario usuario;
	ConexionMySQL conexion;
	private JPanel cardPanel = new JPanel();
	private JPanel contenedorPrincipal = new JPanel();
	JPanel contenedorVehiculos = new JPanel();
	JPanel contenedorClientes = new JPanel();
	JPanel contenedorUsuarios = new JPanel();
	JPanel panel,btnAgregarCliente;
	JLabel lblInicio;
	JLabel lblClientes;
	RoundedPanel btnEditarVehiculo,btnRecargar_2;
	JLabel lblVehiculos;
	JLabel lblGestion;
    DefaultTableModel dtm;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	JPanel panel_1_1;
	JPanel panel_1;
	RoundedPanel btnEditarCliente;
	RoundedPanel btnRecargar;
	private DefaultTableModel tableModel;
	private DefaultTableModel tableModel2;
	private DefaultTableModel tableModel3;
	RoundedPanel btnAgregarVehiculo;
	RoundedPanel btnVerCliente;
	int filaSeleccionadaClientes,filaSeleccionadaVehiculos,filaSeleccionadaUsuarios;
	Cliente [] clientes;
	Vehiculo [] vehiculos;
	Usuario [] usuarios;
	RoundedPanel btnEliminarCliente;
	RoundedPanel btnRecargar_1;
	RoundedPanel btnEliminarVehiculo;
	JPanel panel_1_1_1;
	/**
	 * Create the frame.
	 */
	public VPAdmin(Usuario usuario, ConexionMySQL conexion) {
		this.usuario = usuario;
		this.conexion = conexion;
		setTitle("Derrap");
		//-----
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
        toFront();

		ImageIcon imageIcon3 = new ImageIcon(VPAdmin.class.getResource("/img/buscarVehiculo.png")); // load the image to a imageIcon
		Image image3 = imageIcon3.getImage(); // transform it 
		Image newimg3 = image3.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		ImageIcon imageIcon4 = new ImageIcon(VPAdmin.class.getResource("/img/gestionCitas.png")); // load the image to a imageIcon
		Image image4 = imageIcon4.getImage(); // transform it 
		Image newimg4 = image4.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		ImageIcon imageIcon5 = new ImageIcon(VPAdmin.class.getResource("/img/buscarCliente.png")); // load the image to a imageIcon
		Image image5 = imageIcon5.getImage(); // transform it 
		Image newimg5 = image5.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		ImageIcon imageIcon6 = new ImageIcon(VPAdmin.class.getResource("/img/consultaAlmacen.png")); // load the image to a imageIcon
		Image image6 = imageIcon6.getImage(); // transform it 
		Image newimg6 = image6.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		ImageIcon imageIcon7 = new ImageIcon(VPAdmin.class.getResource("/img/gestionarPedidos.png")); // load the image to a imageIcon
		Image image7 = imageIcon7.getImage(); // transform it 
		Image newimg7 = image7.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		ImageIcon imageIcon8 = new ImageIcon(VPAdmin.class.getResource("/img/buscarVehiculo.png")); // load the image to a imageIcon
		Image image8 = imageIcon8.getImage(); // transform it 
		Image newimg8 = image8.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		CardLayout cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);
		
		cardPanel.setBounds(214, 50, 1052, 633);
		cardPanel.setBackground(new Color(255, 255, 255));
		
		contenedorPrincipal.setBounds(214, 50, 1052, 633);
		contenedorPrincipal.setBackground(new Color(90, 126, 143));
		cardPanel.add(contenedorPrincipal,"pagPrincipal");
		contenedorPrincipal.setLayout(null);

		contenedorClientes.setBackground(new Color(90, 126, 143));
		cardPanel.add(contenedorClientes, "pagClientes");
		contenedorClientes.setLayout(null);
		
		contenedorVehiculos.setBackground(new Color(90, 126, 143));
		cardPanel.add(contenedorVehiculos, "pagVehiculos");
		contenedorVehiculos.setLayout(null);
		
		contenedorUsuarios.setBackground(new Color(90, 126, 143));
		cardPanel.add(contenedorUsuarios, "pagUsuarios");
		contenedorUsuarios.setLayout(null);
		
		panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(124, 149, 165));
		panel_1_1.setBounds(27, 59, 1000, 547);
		contenedorUsuarios.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		
		
		panel_1 = new JPanel();
		panel_1.setBounds(27, 59, 1000, 547);

		panel_1.setBackground(new Color(124, 149, 165));
		contenedorClientes.add(panel_1);
		panel_1.setLayout(null);
		

		
		btnEditarCliente = new RoundedPanel(15, new Color(76, 87, 92));
		btnEditarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarCliente.setOpaque(false);
		btnEditarCliente.setVisible(false);
		btnEditarCliente.setBounds(635, 15, 148, 30);
		contenedorClientes.add(btnEditarCliente);
		btnEditarCliente.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblEditarCliente = new JLabel("Editar Cliente");
		lblEditarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarCliente.setForeground(new Color(220, 220, 220));
		lblEditarCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEditarCliente.add(lblEditarCliente);
		
		btnEliminarCliente = new RoundedPanel(15, new Color(76, 87, 92));
		btnEliminarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarCliente.setOpaque(false);
		btnEliminarCliente.setVisible(false);
		btnEliminarCliente.setBounds(477, 15, 148, 30);
		contenedorClientes.add(btnEliminarCliente);
		btnEliminarCliente.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblEliminarCliente = new JLabel("Eliminar Cliente");
		lblEliminarCliente.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarCliente.setForeground(new Color(220, 220, 220));
		lblEliminarCliente.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminarCliente.add(lblEliminarCliente);
		
		panel_1_1_1 = new JPanel();
		panel_1_1_1.setBackground(new Color(124, 149, 165));
		panel_1_1_1.setBounds(27, 59, 1000, 547);
		contenedorVehiculos.add(panel_1_1_1);
		panel_1_1_1.setLayout(null);
		
		btnEliminarVehiculo = new RoundedPanel(15, new Color(76, 87, 92));
		btnEliminarVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEliminarVehiculo.setOpaque(false);
    	btnEliminarVehiculo.setVisible(false);
		btnEliminarVehiculo.setBounds(477, 15, 148, 30);
		contenedorVehiculos.add(btnEliminarVehiculo);
		btnEliminarVehiculo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblEliminarVehiculo = new JLabel("Eliminar Vehiculo");
		lblEliminarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEliminarVehiculo.setForeground(new Color(220, 220, 220));
		lblEliminarVehiculo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEliminarVehiculo.add(lblEliminarVehiculo);
		
		btnAgregarVehiculo = new RoundedPanel(15, new Color(76, 87, 92));
		btnAgregarVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarVehiculo.setOpaque(false);
		btnAgregarVehiculo.setBounds(793, 15, 148, 30);
		contenedorVehiculos.add(btnAgregarVehiculo);
		btnAgregarVehiculo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblAgregarVehiculo = new JLabel("Agregar Vehiculo +");
		lblAgregarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgregarVehiculo.setForeground(new Color(220, 220, 220));
		lblAgregarVehiculo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregarVehiculo.add(lblAgregarVehiculo);
		
		btnEditarVehiculo = new RoundedPanel(15, new Color(76, 87, 92));
		btnEditarVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarVehiculo.setOpaque(false);
		btnEditarVehiculo.setVisible(false);
		btnEditarVehiculo.setBounds(635, 15, 148, 30);
		contenedorVehiculos.add(btnEditarVehiculo);
		btnEditarVehiculo.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblEditarVehiculo = new JLabel("Editar Vehiculo");
		lblEditarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditarVehiculo.setForeground(new Color(220, 220, 220));
		lblEditarVehiculo.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnEditarVehiculo.add(lblEditarVehiculo);
		
		btnVerCliente = new RoundedPanel(15, new Color(76, 87, 92));
		btnVerCliente.setOpaque(false);
		btnVerCliente.setVisible(false);
		btnVerCliente.setBounds(319, 15, 148, 30);
		contenedorVehiculos.add(btnVerCliente);
		btnVerCliente.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_1_1 = new JLabel("Consultar Cliente");
		lblNewLabel_7_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_1_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVerCliente.add(lblNewLabel_7_1_1_1);
		
		
		
		crearTablaClientes();
		crearTablaVehiculos();
		crearTablaUsuarios();
		
		
		JLabel lblNewLabel = new JLabel("Clientes");
		lblNewLabel.setForeground(new Color(234, 234, 234));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 10, 107, 22);
		contenedorClientes.add(lblNewLabel);
		contentPane.add(cardPanel);
		
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Buenos Días,");
		lblNewLabel_1.setBackground(new Color(220, 220, 220));
		lblNewLabel_1.setForeground(new Color(234, 234, 234));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 10, 135, 22);
		contenedorPrincipal.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(usuario.getNombre());
		lblNewLabel_2.setBackground(new Color(220, 220, 220));
		lblNewLabel_2.setForeground(new Color(234, 234, 234));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(144, 10, 162, 22);
		contenedorPrincipal.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Actualmente tienes");
		lblNewLabel_3.setBackground(new Color(220, 220, 220));
		lblNewLabel_3.setForeground(new Color(234, 234, 234));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 32, 121, 15);
		contenedorPrincipal.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("X");
		lblNewLabel_4.setBackground(new Color(240, 240, 240));
		lblNewLabel_4.setForeground(new Color(234, 234, 234));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(132, 32, 10, 15);
		contenedorPrincipal.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("órdenes de Reparacióbn Asignadas");
		lblNewLabel_5.setBackground(new Color(220, 220, 220));
		lblNewLabel_5.setForeground(new Color(234, 234, 234));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(142, 32, 220, 15);
		contenedorPrincipal.add(lblNewLabel_5);
		
		JLabel lblBuscarVehiculo = new JLabel("");
		lblBuscarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		lblBuscarVehiculo.setIcon(new ImageIcon(newimg3));
		lblBuscarVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBuscarVehiculo.setBounds(60, 150, 169, 180);
		contenedorPrincipal.add(lblBuscarVehiculo);
		
				JLabel lblGestionCitas = new JLabel("");
				lblGestionCitas.setHorizontalAlignment(SwingConstants.CENTER);
				lblGestionCitas.setIcon(new ImageIcon(newimg4));
				lblGestionCitas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblGestionCitas.setBounds(441, 150, 169, 180);
				contenedorPrincipal.add(lblGestionCitas);
				

				JLabel lblBuscarCliente = new JLabel("");
				lblBuscarCliente.setHorizontalAlignment(SwingConstants.CENTER);
				lblBuscarCliente.setIcon(new ImageIcon(newimg5));
				lblBuscarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblBuscarCliente.setBounds(823, 150, 169, 180);
				contenedorPrincipal.add(lblBuscarCliente);
				
					JLabel lblConsultaAlmacen = new JLabel("");
					lblConsultaAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
					lblConsultaAlmacen.setIcon(new ImageIcon(newimg6));
					lblConsultaAlmacen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					lblConsultaAlmacen.setBounds(60, 398, 169, 180);
					contenedorPrincipal.add(lblConsultaAlmacen);
					
					JLabel lblGestionarPedidos = new JLabel("");
					lblGestionarPedidos.setHorizontalAlignment(SwingConstants.CENTER);
					lblGestionarPedidos.setIcon(new ImageIcon(newimg7));
					lblGestionarPedidos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					lblGestionarPedidos.setBounds(441, 398, 169, 180);
					contenedorPrincipal.add(lblGestionarPedidos);
					
					JLabel lblBuscarVehiculos = new JLabel("");
					lblBuscarVehiculos.setHorizontalAlignment(SwingConstants.CENTER);
					lblBuscarVehiculos.setIcon(new ImageIcon(newimg8));
					lblBuscarVehiculos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					lblBuscarVehiculos.setBounds(823, 398, 169, 180);
					contenedorPrincipal.add(lblBuscarVehiculos);
					
					JLabel lblGestionDeUsuarios = new JLabel("Gestión de Usuarios");
					lblGestionDeUsuarios.setForeground(new Color(234, 234, 234));
					lblGestionDeUsuarios.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblGestionDeUsuarios.setBounds(10, 10, 235, 22);
					contenedorUsuarios.add(lblGestionDeUsuarios);
					

					

					
					
					JLabel lblVehiculos_1 = new JLabel("Vehiculos");
					lblVehiculos_1.setForeground(new Color(234, 234, 234));
					lblVehiculos_1.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblVehiculos_1.setBounds(10, 10, 235, 22);
					contenedorVehiculos.add(lblVehiculos_1);
					
					btnRecargar_1 = new RoundedPanel(15, new Color(76, 87, 92));
					btnRecargar_1.setOpaque(false);
					btnRecargar_1.setBounds(951, 15, 76, 30);
					contenedorVehiculos.add(btnRecargar_1);
					btnRecargar_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
					btnRecargar_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					
					JLabel lblRecargar_1 = new JLabel("Recargar");
					lblRecargar_1.setHorizontalAlignment(SwingConstants.CENTER);
					lblRecargar_1.setForeground(new Color(220, 220, 220));
					lblRecargar_1.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnRecargar_1.add(lblRecargar_1);
					
					
					btnRecargar_2 = new RoundedPanel(15, new Color(76, 87, 92));
					btnRecargar_2.setOpaque(false);
					btnRecargar_2.setBounds(951, 15, 76, 30);
					contenedorUsuarios.add(btnRecargar_2);
					btnRecargar_2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
					btnRecargar_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					
					JLabel lblRecargar_2 = new JLabel("Recargar");
					lblRecargar_2.setHorizontalAlignment(SwingConstants.CENTER);
					lblRecargar_2.setForeground(new Color(220, 220, 220));
					lblRecargar_2.setFont(new Font("Tahoma", Font.BOLD, 12));
					btnRecargar_2.add(lblRecargar_2);
					

					

					

					

	

		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 214, 683);
		panelMenu.setBackground(new Color(140, 164, 179));
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		lblInicio = new JLabel("Inicio");
		lblInicio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInicio.setBackground(new Color(90, 126, 143));
		lblInicio.setForeground(new Color(220, 220, 220));
		lblInicio.setBounds(0, 129, 214, 45);
		lblInicio.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblInicio.setOpaque(true);
		lblInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		

		lblClientes = new JLabel("Clientes");
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClientes.setForeground(new Color(0, 0, 0));
		lblClientes.setBackground(new Color(146, 171, 186));
		lblClientes.setBounds(0, 294, 214, 45);
		lblClientes.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblClientes.setOpaque(true);
		lblClientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblClientes);
		
		lblVehiculos = new JLabel("Vehículos");
		lblVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVehiculos.setForeground(new Color(0, 0, 0));
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
		
		lblGestion = new JLabel("Gestión Usuarios");
		lblGestion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGestion.setForeground(new Color(0, 0, 0));
		lblGestion.setBackground(new Color(146, 171, 186));
		lblGestion.setBounds(0, 514, 214, 45);
		lblGestion.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblGestion.setOpaque(true);
		lblGestion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblGestion);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon = new ImageIcon(VPAdmin.class.getResource("/img/logoDerrap.png")); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(82, 119,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		lblNewLabel_8.setIcon(new ImageIcon(newimg));
		lblNewLabel_8.setBounds(0, 0, 214, 119);
		panelMenu.add(lblNewLabel_8);
		
		
		JLabel logoLetras = new JLabel("");
		logoLetras.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon2 = new ImageIcon(VPAdmin.class.getResource("/img/logoDerrapLetras.png")); // load the image to a imageIcon
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
		lblNewLabel_6.setIcon(new ImageIcon(VPAdmin.class.getResource("/img/marcador-de-forma-negra (1).png")));
		lblNewLabel_6.setBounds(931, 10, 111, 30);
		panelMenuSup.add(lblNewLabel_6);
		
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                setEnabled(true);  // Habilitar la ventana principal nuevamente
            }
        });
        
		//BOTONES
		Color colorBoton=new Color(76, 87, 92);
		Color colorBotonEntrar=new Color(39, 47, 51);
		panel = new RoundedPanel(15,colorBoton);
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
			
			@Override
			public void mouseEntered (MouseEvent e) {
				((RoundedPanel) panel).cambiarColor(colorBotonEntrar);
				panel.setBackground(colorBotonEntrar);
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				((RoundedPanel) panel).cambiarColor(colorBoton);
				panel.setBackground(colorBoton);
				
			}
		});
		
		btnAgregarCliente = new RoundedPanel(15,colorBoton);
		btnAgregarCliente.setOpaque(false);
		btnAgregarCliente.setBounds(793, 15, 148, 30);
		contenedorClientes.add(btnAgregarCliente);
		btnAgregarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarCliente.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		

		
		JLabel lblNewLabel_7_1 = new JLabel("Agregar Cliente +");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregarCliente.add(lblNewLabel_7_1);
		
		btnRecargar = new RoundedPanel(15, new Color(76, 87, 92));
		btnRecargar.setOpaque(false);
		btnRecargar.setBounds(951, 15, 76, 30);
		contenedorClientes.add(btnRecargar);
		btnRecargar.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		btnRecargar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel lblRecargar = new JLabel("Recargar");
		lblRecargar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRecargar.setForeground(new Color(220, 220, 220));
		lblRecargar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRecargar.add(lblRecargar);
		

		

		
		btnEditarCliente.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				crearVentanaEditarCliente();
				
            }
			
		

			@Override
			public void mouseEntered (MouseEvent e) {
				((RoundedPanel) btnEditarCliente).cambiarColor(colorBotonEntrar);
				btnEditarCliente.setBackground(colorBotonEntrar);
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				((RoundedPanel) btnEditarCliente).cambiarColor(colorBoton);
				btnEditarCliente.setBackground(colorBoton);
				
			}
		});
		
		btnEditarVehiculo.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				crearVentanaEditarVehiculo();
				
            }
			
		

			@Override
			public void mouseEntered (MouseEvent e) {
				((RoundedPanel) btnEditarVehiculo).cambiarColor(colorBotonEntrar);
				btnEditarVehiculo.setBackground(colorBotonEntrar);
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				((RoundedPanel) btnEditarVehiculo).cambiarColor(colorBoton);
				btnEditarVehiculo.setBackground(colorBoton);
				
			}
		});
		
		btnVerCliente.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				crearVentanaVerCliente();
				
            }
			
		

			@Override
			public void mouseEntered (MouseEvent e) {
				((RoundedPanel) btnVerCliente).cambiarColor(colorBotonEntrar);
				btnVerCliente.setBackground(colorBotonEntrar);
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				((RoundedPanel) btnVerCliente).cambiarColor(colorBoton);
				btnVerCliente.setBackground(colorBoton);
				
			}
		});
		
		
		btnEliminarCliente.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				int opcion = JOptionPane.showConfirmDialog(
			            panel_1,                                
			            "¿Seguro que quieres eliminar el usuario?",              
			            "Eliminar",                     
			            JOptionPane.OK_CANCEL_OPTION       
			        );
				 if (opcion == JOptionPane.OK_OPTION) {
					 conexion.eliminarCliente(clientes[filaSeleccionadaClientes].getId());
						crearTablaClientes();
				 }
            }
			
		

			@Override
			public void mouseEntered (MouseEvent e) {
				((RoundedPanel) btnEliminarCliente).cambiarColor(colorBotonEntrar);
				btnEliminarCliente.setBackground(colorBotonEntrar);
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				((RoundedPanel) btnEliminarCliente).cambiarColor(colorBoton);
				btnEliminarCliente.setBackground(colorBoton);
				
			}
		});
		
		btnEliminarVehiculo.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				int opcion = JOptionPane.showConfirmDialog(
			            panel_1,                                
			            "¿Seguro que quieres eliminar el Vehículo?",              
			            "Eliminar",                     
			            JOptionPane.OK_CANCEL_OPTION       
			        );
				 if (opcion == JOptionPane.OK_OPTION) {
					 conexion.eliminarVehiculo(vehiculos[filaSeleccionadaVehiculos].getId());
						crearTablaVehiculos();
				 }
            }
			
		

			@Override
			public void mouseEntered (MouseEvent e) {
				((RoundedPanel) btnEliminarVehiculo).cambiarColor(colorBotonEntrar);
				btnEliminarVehiculo.setBackground(colorBotonEntrar);
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				((RoundedPanel) btnEliminarVehiculo).cambiarColor(colorBoton);
				btnEliminarVehiculo.setBackground(colorBoton);
				
			}
		});
		
		btnRecargar.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				crearTablaClientes();
            }
			
			@Override
			public void mouseEntered (MouseEvent e) {
				((RoundedPanel) btnRecargar).cambiarColor(colorBotonEntrar);
				btnRecargar.setBackground(colorBotonEntrar);
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				((RoundedPanel) btnRecargar).cambiarColor(colorBoton);
				btnRecargar.setBackground(colorBoton);
				
			}
		});
		
		btnRecargar_2.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				crearTablaUsuarios();
            }
			
			@Override
			public void mouseEntered (MouseEvent e) {
				((RoundedPanel) btnRecargar_2).cambiarColor(colorBotonEntrar);
				btnRecargar_2.setBackground(colorBotonEntrar);
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				((RoundedPanel) btnRecargar_2).cambiarColor(colorBoton);
				btnRecargar_2.setBackground(colorBoton);
				
			}
		});
		
		btnRecargar_1.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				crearTablaVehiculos();
            }
			
			@Override
			public void mouseEntered (MouseEvent e) {
				((RoundedPanel) btnRecargar_1).cambiarColor(colorBotonEntrar);
				btnRecargar_1.setBackground(colorBotonEntrar);
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				((RoundedPanel) btnRecargar_1).cambiarColor(colorBoton);
				btnRecargar_1.setBackground(colorBoton);
				
			}
		});

		btnAgregarCliente.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				crearVentanaAgregarCliente();
            }
			
			@Override
			public void mouseEntered (MouseEvent e) {
				((RoundedPanel) btnAgregarCliente).cambiarColor(colorBotonEntrar);
				btnAgregarCliente.setBackground(colorBotonEntrar);
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				((RoundedPanel) btnAgregarCliente).cambiarColor(colorBoton);
				btnAgregarCliente.setBackground(colorBoton);
				
			}
		});
		
		btnAgregarVehiculo.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				crearVentanaAgregarVehiculo();
            }
			
			@Override
			public void mouseEntered (MouseEvent e) {
				((RoundedPanel) btnAgregarVehiculo).cambiarColor(colorBotonEntrar);
				btnAgregarVehiculo.setBackground(colorBotonEntrar);
			}
			
			@Override
			public void mouseExited (MouseEvent e) {
				((RoundedPanel) btnAgregarVehiculo).cambiarColor(colorBoton);
				btnAgregarVehiculo.setBackground(colorBoton);
				
			}
		});
		
		
		
		
		JLabel lblNewLabel_7 = new JLabel("Cerrar Sesión");
		lblNewLabel_7.setForeground(new Color(220, 220, 220));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNewLabel_7);

		
		//Funcionalidad Menú
		lblClientes.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel,"pagClientes");
				colorMenu();
				lblClientes.setBackground(new Color(90, 126, 143));
				lblClientes.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblClientes.setForeground(new Color(220, 220, 220));
            }
		});

		lblInicio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
        		cardLayout.show(cardPanel,"pagPrincipal");
				colorMenu();
				lblInicio.setBackground(new Color(90, 126, 143));
				lblInicio.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblInicio.setForeground(new Color(220, 220, 220));
            }
        });

		lblVehiculos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
        		cardLayout.show(cardPanel,"pagVehiculos");
				colorMenu();
				lblVehiculos.setBackground(new Color(90, 126, 143));
				lblVehiculos.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblVehiculos.setForeground(new Color(220, 220, 220));
            }
        });

		lblGestion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
        		cardLayout.show(cardPanel,"pagUsuarios");
				colorMenu();
				lblGestion.setBackground(new Color(90, 126, 143));
				lblGestion.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblGestion.setForeground(new Color(220, 220, 220));
            }
        });
	}
	
	protected void crearVentanaEditarCliente() {
		VForm vForm = new VForm(clientes[filaSeleccionadaClientes],this,1);
		 Point location = getLocation();
		 Dimension size = getSize();
		 int nuevax = (location.x + size.width / 2) - vForm.getWidth() / 2;
		 int nuevay = (location.y + size.height / 2) - vForm.getHeight() / 2;
		 vForm.setLocation(nuevax,nuevay);
		 vForm.setVisible(true);
		 setEnabled(false);
	}
	
	protected void crearVentanaVerCliente() {
		System.out.println(filaSeleccionadaVehiculos);
		Cliente c = conexion.obtenerClienteCoche(vehiculos[filaSeleccionadaVehiculos].getCliente_id());
		VForm vForm = new VForm(c,this,2);
		 Point location = getLocation();
		 Dimension size = getSize();
		 int nuevax = (location.x + size.width / 2) - vForm.getWidth() / 2;
		 int nuevay = (location.y + size.height / 2) - vForm.getHeight() / 2;
		 vForm.setLocation(nuevax,nuevay);
		 vForm.setVisible(true);
		 setEnabled(false);
	}
	
	protected void crearVentanaEditarVehiculo() {
		VForm2 vForm2 = new VForm2(vehiculos[filaSeleccionadaVehiculos],this,1);
		 Point location = getLocation();
		 Dimension size = getSize();
		 int nuevax = (location.x + size.width / 2) - vForm2.getWidth() / 2;
		 int nuevay = (location.y + size.height / 2) - vForm2.getHeight() / 2;
		 vForm2.setLocation(nuevax,nuevay);
		 vForm2.setVisible(true);
		 setEnabled(false);
	}
	
	protected void crearVentanaAgregarCliente() {
		VForm vForm = new VForm(null,this,0);
		 Point location = getLocation();
		 Dimension size = getSize();
		 int nuevax = (location.x + size.width / 2) - vForm.getWidth() / 2;
		 int nuevay = (location.y + size.height / 2) - vForm.getHeight() / 2;
		 vForm.setLocation(nuevax,nuevay);
		 vForm.setVisible(true);
		 setEnabled(false);
	}
	
	protected void crearVentanaAgregarVehiculo() {
		VForm2 vForm2 = new VForm2(null,this,0);
		 Point location = getLocation();
		 Dimension size = getSize();
		 int nuevax = (location.x + size.width / 2) - vForm2.getWidth() / 2;
		 int nuevay = (location.y + size.height / 2) - vForm2.getHeight() / 2;
		 vForm2.setLocation(nuevax,nuevay);
		 vForm2.setVisible(true);
		 setEnabled(false);
	}


	public void crearTablaClientes() {
		
		int crearTabla = conexion.contarClientes();
		Object array [] [] = new Object [crearTabla][9];
		System.out.println(array.length);
		clientes = conexion.obtenerClientes();
		System.out.println(crearTabla);
		for (int i = 0; i<crearTabla;i++) {
			array[i][0]=clientes[i].getNombre();
			array[i][1]=clientes[i].getApellidos();
			array[i][2]=clientes[i].getDni();
			array[i][3]=clientes[i].getTelefono();
			array[i][4]=clientes[i].getCorreo();
			array[i][5]=clientes[i].getDireccion();
		}
		
		if (table_1 == null) {
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBackground(new Color(124, 149, 165));
			scrollPane.setBorder(BorderFactory.createEmptyBorder());
			scrollPane.getViewport().setOpaque(false);
			scrollPane.setBounds(10, 5, 980, 532);
			panel_1.add(scrollPane);
			table_1 = new JTable();
			table_1.setForeground(new Color(234, 234, 234));
			table_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			table_1.setBorder(null);
			table_1.setBackground(new Color(90, 126, 143));
			table_1.setShowHorizontalLines(false);
			table_1.setShowGrid(false);
			scrollPane.setViewportView(table_1);
		    table_1.getTableHeader().setReorderingAllowed(false);
		    
			table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                    filaSeleccionadaClientes = table_1.getSelectedRow();

	                    if (filaSeleccionadaClientes != -1) { // Asegurarse de que se haya seleccionado una columna
	                    	btnEditarCliente.setVisible(true);
	                    	btnEliminarCliente.setVisible(true);
	                    	

	                    }
	                }
	            }
	        });
		}

        String[] columnNames = {
            "Nombre", "Apellidos", "DNI", "Teléfono", "Correo Electrónico", "Dirección"
        };

        // Crear un nuevo modelo si no está creado aún
        tableModel = new DefaultTableModel(array, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // No permitir la edición de celdas
            }
        };
        tableModel.setRowCount(0); // Limpiar las filas anteriores
        for (int i = 0; i < crearTabla; i++) {
            tableModel.addRow(array[i]); // Agregar las nuevas filas
        }

        table_1.setModel(tableModel);

	    // Refrescar la vista
	    btnEditarCliente.setVisible(false);
    	btnEliminarCliente.setVisible(false);
	    tableModel.fireTableDataChanged(); 
	    table_1.revalidate(); 
	    table_1.repaint();  
	    panel_1.revalidate();  
	    panel_1.repaint();
	    

		        
	}

	
public void crearTablaVehiculos() {
		
		int crearTabla = conexion.contarVehiculos();
		Object array2 [] [] = new Object [crearTabla][6];
		vehiculos = conexion.obtenerVehiculos();
		for (int i = 0; i<crearTabla;i++) {
			array2[i][0]=vehiculos[i].getMatricula();
			array2[i][1]=vehiculos[i].getMarca();
			array2[i][2]=vehiculos[i].getModelo();
			array2[i][3]=vehiculos[i].getAno();
			array2[i][4]=vehiculos[i].getColor();
		}
		
		
		if (table_2 == null) {
			JScrollPane scrollPane2 = new JScrollPane();
			scrollPane2.setBackground(new Color(124, 149, 165));
			scrollPane2.setBorder(BorderFactory.createEmptyBorder());
			scrollPane2.getViewport().setOpaque(false);
			scrollPane2.setBounds(10, 5, 980, 532);
			panel_1_1_1.add(scrollPane2);
			table_2 = new JTable();
			table_2.setForeground(new Color(234, 234, 234));
			table_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
			table_2.setBorder(null);
			table_2.setBackground(new Color(90, 126, 143));
			table_2.setShowHorizontalLines(false);
			table_2.setShowGrid(false);
			scrollPane2.setViewportView(table_2);
			table_2.getTableHeader().setReorderingAllowed(false);
		    
			table_2.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                    filaSeleccionadaVehiculos = table_2.getSelectedRow();

	                    if (filaSeleccionadaVehiculos != -1) { // Asegurarse de que se haya seleccionado una columna
	                    	btnEditarVehiculo.setVisible(true);
	                    	btnEliminarVehiculo.setVisible(true);
	                    	btnVerCliente.setVisible(true);
	                    	

	                    }
	                }
	            }
	        });
		}

        String[] columnNames = {
            "Matrícula", "Marca", "Modelo", "Año", "Color"
        };

        // Crear un nuevo modelo si no está creado aún
        tableModel2 = new DefaultTableModel(array2, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // No permitir la edición de celdas
            }
        };
        tableModel2.setRowCount(0); // Limpiar las filas anteriores
        for (int i = 0; i < crearTabla; i++) {
            tableModel2.addRow(array2[i]); // Agregar las nuevas filas
        }

        table_2.setModel(tableModel2);

	    // Refrescar la vista
	    btnEditarVehiculo.setVisible(false);
    	btnEliminarVehiculo.setVisible(false);
    	btnVerCliente.setVisible(false);
	    tableModel2.fireTableDataChanged(); 
	    table_2.revalidate(); 
	    table_2.repaint();  
	    panel_1_1_1.revalidate();  
	    panel_1_1_1.repaint();
	    

		        
	}

public void crearTablaUsuarios() {
	
	int crearTabla = conexion.contarUsuarios();
	Object array3 [] [] = new Object [crearTabla][6];
	usuarios = conexion.obtenerUsuarios();
	for (int i = 0; i<crearTabla;i++) {
		array3[i][0]=usuarios[i].getNombre();
		array3[i][1]=usuarios[i].getApellido();
		array3[i][2]=usuarios[i].getDni();
		array3[i][3]=usuarios[i].getTelefono();
		array3[i][4]=usuarios[i].getEmail();
	}
	
	
	if (table_3 == null) {
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBackground(new Color(124, 149, 165));
		scrollPane3.setBorder(BorderFactory.createEmptyBorder());
		scrollPane3.getViewport().setOpaque(false);
		scrollPane3.setBounds(10, 5, 980, 532);
		panel_1_1.add(scrollPane3);
		table_3 = new JTable();
		table_3.setForeground(new Color(234, 234, 234));
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_3.setBorder(null);
		table_3.setBackground(new Color(90, 126, 143));
		table_3.setShowHorizontalLines(false);
		table_3.setShowGrid(false);
		scrollPane3.setViewportView(table_3);
		table_3.getTableHeader().setReorderingAllowed(false);
	    
		table_3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    filaSeleccionadaUsuarios = table_3.getSelectedRow();

                    if (filaSeleccionadaUsuarios != -1) { // Asegurarse de que se haya seleccionado una columna
                    	btnEditarVehiculo.setVisible(true);
                    	btnEliminarVehiculo.setVisible(true);
                    	btnVerCliente.setVisible(true);
                    	

                    }
                }
            }
        });
	}

    String[] columnNames = {
        "Nombre", "Apellido", "DNI", "Teléfono", "Mail"
    };

    // Crear un nuevo modelo si no está creado aún
    tableModel3 = new DefaultTableModel(array3, columnNames) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // No permitir la edición de celdas
        }
    };
    tableModel3.setRowCount(0); // Limpiar las filas anteriores
    for (int i = 0; i < crearTabla; i++) {
        tableModel3.addRow(array3[i]); // Agregar las nuevas filas
    }

    table_3.setModel(tableModel3);

    // Refrescar la vista
    btnEditarVehiculo.setVisible(false);
	btnEliminarVehiculo.setVisible(false);
	btnVerCliente.setVisible(false);
    tableModel3.fireTableDataChanged(); 
    table_3.revalidate(); 
    table_3.repaint();  
    panel_1_1.revalidate();  
    panel_1_1.repaint();
    

	        
}

	public void colorMenu(){
		lblInicio.setBackground(new Color(146, 171, 186));
		lblClientes.setBackground(new Color(146, 171, 186));
		lblVehiculos.setBackground(new Color(146, 171, 186));
		lblGestion.setBackground(new Color(146, 171, 186));
		
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblClientes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGestion.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblInicio.setForeground(new Color(0, 0, 0));
		lblClientes.setForeground(new Color(0, 0, 0));
		lblVehiculos.setForeground(new Color(0, 0, 0));
		lblGestion.setForeground(new Color(0, 0, 0));
		
		
		
	}
}
