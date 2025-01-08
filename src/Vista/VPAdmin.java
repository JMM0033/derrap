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
import java.awt.CardLayout;

public class VPAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usuario;
	private ConexionMySQL conexion;
	private JPanel cardPanel = new JPanel();
	private JPanel contenedorPrincipal = new JPanel();
	JPanel contenedorVehiculos = new JPanel();
	JPanel contenedorClientes = new JPanel();
	JPanel contenedorUsuarios = new JPanel();
	JPanel panel,btnAgregarCliente;
	JLabel lblInicio;
	JLabel lblClientes;
	JLabel lblVehiculos;
	JLabel lblGestion;

	/**
	 * Create the frame.
	 */
	public VPAdmin(Usuario usuario, ConexionMySQL conexion) {
		this.usuario = usuario;
		this.conexion = conexion;
		//-----
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);

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
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(124, 149, 165));
		panel_1_1.setBounds(27, 59, 1000, 547);
		contenedorUsuarios.add(panel_1_1);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(27, 59, 1000, 547);

		panel_1.setBackground(new Color(124, 149, 165));
		contenedorClientes.add(panel_1);
		
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
					

					
					JPanel panel_1_1_1 = new JPanel();
					panel_1_1_1.setBackground(new Color(124, 149, 165));
					panel_1_1_1.setBounds(27, 59, 1000, 547);
					contenedorVehiculos.add(panel_1_1_1);
					
					JLabel lblVehiculos_1 = new JLabel("Vehiculos");
					lblVehiculos_1.setForeground(new Color(234, 234, 234));
					lblVehiculos_1.setFont(new Font("Tahoma", Font.BOLD, 20));
					lblVehiculos_1.setBounds(10, 10, 235, 22);
					contenedorVehiculos.add(lblVehiculos_1);
					

		
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
		btnAgregarCliente.setBounds(889, 15, 138, 30);
		contenedorClientes.add(btnAgregarCliente);
		btnAgregarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgregarCliente.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1 = new JLabel("Agregar Cliente +");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAgregarCliente.add(lblNewLabel_7_1);
		btnAgregarCliente.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				System.out.println("pulsado");
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
