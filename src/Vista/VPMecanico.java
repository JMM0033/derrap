package Vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

public class VPMecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usuario;
	private ConexionMySQL conexion;
	JLabel lblInicio;
	JLabel lblOrdenes;

	/**
	 * Create the frame.
	 */
	public VPMecanico(Usuario usuario, ConexionMySQL conexion) {
		this.usuario = usuario;
		this.conexion = conexion;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(214, 50, 1052, 633);
		contentPane.add(cardPanel);
		
		CardLayout cardLayout = new CardLayout();
		cardPanel.setLayout(cardLayout);
		
		
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
		

		lblOrdenes = new JLabel("Órdenes de Trabajo");
		lblOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOrdenes.setBackground(new Color(146, 171, 186));
		lblOrdenes.setBounds(0, 184, 214, 45);
		lblOrdenes.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblOrdenes.setOpaque(true);
		lblOrdenes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblOrdenes);
		

		JLabel lblVehiculos = new JLabel("Vehículos");
		lblVehiculos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblVehiculos.setBackground(new Color(146, 171, 186));
		lblVehiculos.setBounds(0, 239, 214, 45);
		lblVehiculos.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblVehiculos.setOpaque(true);
		lblVehiculos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblVehiculos);
		

		JLabel lblAlmacen = new JLabel("Almacén");
		lblAlmacen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAlmacen.setBackground(new Color(146, 171, 186));
		lblAlmacen.setBounds(0, 294, 214, 45);
		lblAlmacen.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblAlmacen.setOpaque(true);
		lblAlmacen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblAlmacen);
		

		

		lblOrdenes.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel,"ordenesTrabajo");
				colorMenu();
				lblOrdenes.setBackground(new Color(90, 126, 143));
				lblOrdenes.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblOrdenes.setForeground(new Color(220, 220, 220));
            }
		});
		
		lblInicio.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				cardLayout.show(cardPanel,"contenedorPrincipal");
				colorMenu();
				lblInicio.setBackground(new Color(90, 126, 143));
				lblInicio.setFont(new Font("Tahoma", Font.BOLD, 12));
				lblInicio.setForeground(new Color(220, 220, 220));
            }
		});
		
		panelMenu.add(lblInicio);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon = new ImageIcon(VPMecanico.class.getResource("/img/logoDerrap.png")); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(82, 119,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		lblNewLabel_8.setIcon(new ImageIcon(newimg));
		lblNewLabel_8.setBounds(0, 0, 214, 119);
		panelMenu.add(lblNewLabel_8);
		
		
		JLabel logoLetras = new JLabel("");
		logoLetras.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon2 = new ImageIcon(VPMecanico.class.getResource("/img/logoDerrapLetras.png")); // load the image to a imageIcon
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
		
		JLabel lblNewLabel_6 = new JLabel("Mecánico");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setIcon(new ImageIcon(VPMecanico.class.getResource("/img/marcador-de-forma-negra (1).png")));
		lblNewLabel_6.setBounds(966, 10, 76, 30);
		panelMenuSup.add(lblNewLabel_6);
		
		Color colorBoton=new Color(140, 174, 145);
		JPanel panel = new RoundedPanel(15, new Color(76, 87, 92));
		panel.setOpaque(false);
		panel.setBounds(840, 10, 116, 30);
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
		lblNewLabel_7.setForeground(new Color(220, 220, 220));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNewLabel_7);
		
		JPanel ContenedorPrincipal = new JPanel();
		ContenedorPrincipal.setBounds(214, 50, 1052, 633);
		ContenedorPrincipal.setBackground(new Color(90, 126, 143));
		ContenedorPrincipal.setLayout(null);
		cardPanel.add(ContenedorPrincipal, "contenedorPrincipal");
		
		JLabel lblNewLabel_1 = new JLabel("Buenos Días,");
		lblNewLabel_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 10, 135, 22);
		ContenedorPrincipal.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(usuario.getNombre());
		lblNewLabel_2.setForeground(new Color(220, 220, 220));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(144, 10, 135, 22);
		ContenedorPrincipal.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Actualmente tienes");
		lblNewLabel_3.setForeground(new Color(220, 220, 220));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 32, 121, 15);
		ContenedorPrincipal.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("X");
		lblNewLabel_4.setForeground(new Color(220, 220, 220));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(132, 32, 10, 15);
		ContenedorPrincipal.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("órdenes de Reparacióbn Asignadas");
		lblNewLabel_5.setForeground(new Color(220, 220, 220));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(142, 32, 220, 15);
		ContenedorPrincipal.add(lblNewLabel_5);
		
		JLabel lblBuscarVehiculo = new JLabel("");
		lblBuscarVehiculo.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon3 = new ImageIcon(VPMecanico.class.getResource("/img/buscarVehiculo.png")); // load the image to a imageIcon
		Image image3 = imageIcon3.getImage(); // transform it 
		Image newimg3 = image3.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		lblBuscarVehiculo.setIcon(new ImageIcon(newimg3));
		lblBuscarVehiculo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBuscarVehiculo.setBounds(60, 150, 169, 180);
		ContenedorPrincipal.add(lblBuscarVehiculo);

		JLabel lblOrdenTrabajo = new JLabel("");
		lblOrdenTrabajo.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon4 = new ImageIcon(VPMecanico.class.getResource("/img/ordenTrabajo.png")); // load the image to a imageIcon
		Image image4 = imageIcon4.getImage(); // transform it 
		Image newimg4 = image4.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		lblOrdenTrabajo.setIcon(new ImageIcon(newimg4));
		lblOrdenTrabajo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblOrdenTrabajo.setBounds(441, 150, 169, 180);
		ContenedorPrincipal.add(lblOrdenTrabajo);
		

		JLabel lblOrdenAsignada = new JLabel("");
		lblOrdenAsignada.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon5 = new ImageIcon(VPMecanico.class.getResource("/img/ordenAsignada.png")); // load the image to a imageIcon
		Image image5 = imageIcon5.getImage(); // transform it 
		Image newimg5 = image5.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		lblOrdenAsignada.setIcon(new ImageIcon(newimg5));
		lblOrdenAsignada.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblOrdenAsignada.setBounds(823, 150, 169, 180);
		ContenedorPrincipal.add(lblOrdenAsignada);
	
		JLabel lblConsultaAlmacen = new JLabel("");
		lblConsultaAlmacen.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon6 = new ImageIcon(VPMecanico.class.getResource("/img/consultaAlmacen.png")); // load the image to a imageIcon
		Image image6 = imageIcon6.getImage(); // transform it 
		Image newimg6 = image6.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		lblConsultaAlmacen.setIcon(new ImageIcon(newimg6));
		lblConsultaAlmacen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblConsultaAlmacen.setBounds(250, 398, 169, 180);
		ContenedorPrincipal.add(lblConsultaAlmacen);
		
		JLabel lblSolicitarPiezas = new JLabel("");
		lblSolicitarPiezas.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon imageIcon7 = new ImageIcon(VPMecanico.class.getResource("/img/solicitarPiezas.png")); // load the image to a imageIcon
		Image image7 = imageIcon7.getImage(); // transform it 
		Image newimg7 = image7.getScaledInstance(169, 180,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  / transform it back
		lblSolicitarPiezas.setIcon(new ImageIcon(newimg7));
		lblSolicitarPiezas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSolicitarPiezas.setBounds(632, 398, 169, 180);
		ContenedorPrincipal.add(lblSolicitarPiezas);
		
		JPanel ordenesTrabajo = new JPanel();
		ordenesTrabajo.setBackground(new Color(90, 126, 143));
		ordenesTrabajo.setBounds(214, 50, 1052, 633);
		cardPanel.add(ordenesTrabajo, "ordenesTrabajo");
		ordenesTrabajo.setLayout(null);
		
		JPanel orden1 = new JPanel();
		orden1.setBackground(new Color(140, 164, 179));
		orden1.setBounds(27, 59, 1000, 153);
		ordenesTrabajo.add(orden1);
		orden1.setLayout(null);
		
		JLabel lblNewLabel_9 = new JLabel("Matrícula");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9.setBounds(32, 11, 55, 14);
		orden1.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Fecha Ingreso");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10.setBounds(120, 11, 80, 14);
		orden1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("Hora");
		lblNewLabel_10_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_1.setBounds(227, 11, 46, 14);
		orden1.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_2 = new JLabel("Problema Descrito");
		lblNewLabel_10_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_2.setBounds(305, 11, 107, 14);
		orden1.add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_10_3 = new JLabel("Servicio");
		lblNewLabel_10_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_3.setBounds(453, 11, 46, 14);
		orden1.add(lblNewLabel_10_3);
		
		JLabel lblNewLabel_10_4 = new JLabel("Estado");
		lblNewLabel_10_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_4.setBounds(551, 11, 46, 14);
		orden1.add(lblNewLabel_10_4);
		
		JLabel lblNewLabel_10_5 = new JLabel("Piezas");
		lblNewLabel_10_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_5.setBounds(645, 11, 46, 14);
		orden1.add(lblNewLabel_10_5);
		
		JLabel lblNewLabel_10_6 = new JLabel("Informacion Cliente");
		lblNewLabel_10_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_6.setBounds(731, 11, 115, 14);
		orden1.add(lblNewLabel_10_6);
		
		JLabel lblNewLabel_10_7 = new JLabel("Hist. Vehiculo");
		lblNewLabel_10_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_7.setBounds(873, 11, 75, 14);
		orden1.add(lblNewLabel_10_7);
		
		JLabel lblNewLabel_9_1 = new JLabel("1234 ABC");
		lblNewLabel_9_1.setBounds(32, 28, 50, 14);
		orden1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_9_1_1 = new JLabel("08/10/2025");
		lblNewLabel_9_1_1.setBounds(125, 28, 64, 14);
		orden1.add(lblNewLabel_9_1_1);
		
		JLabel lblNewLabel_9_1_2 = new JLabel("12:00");
		lblNewLabel_9_1_2.setBounds(226, 28, 36, 14);
		orden1.add(lblNewLabel_9_1_2);
		
		JLabel lblNewLabel_9_1_1_1 = new JLabel("Problemas");
		lblNewLabel_9_1_1_1.setBounds(306, 28, 84, 14);
		orden1.add(lblNewLabel_9_1_1_1);
		
		JLabel lblNewLabel_9_1_1_2 = new JLabel("Mecánica");
		lblNewLabel_9_1_1_2.setBounds(454, 28, 50, 14);
		orden1.add(lblNewLabel_9_1_1_2);
		
		RoundedPanel panel_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1.setOpaque(false);
		panel_1.setBounds(768, 28, 46, 28);
		orden1.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1 = new JLabel("VER");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(lblNewLabel_7_1);
		
		RoundedPanel panel_1_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_1.setOpaque(false);
		panel_1_1.setBounds(885, 28, 46, 28);
		orden1.add(panel_1_1);
		panel_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_1 = new JLabel("VER");
		lblNewLabel_7_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_1.add(lblNewLabel_7_1_1);
		
		RoundedPanel panel_1_2 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_2.setOpaque(false);
		panel_1_2.setBounds(640, 28, 46, 28);
		orden1.add(panel_1_2);
		panel_1_2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_2 = new JLabel("VER");
		lblNewLabel_7_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_2.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_2.add(lblNewLabel_7_1_2);
		
		RoundedPanel panel_1_3 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_3.setOpaque(false);
		panel_1_3.setBounds(859, 114, 131, 28);
		orden1.add(panel_1_3);
		panel_1_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_3 = new JLabel("MODIFICAR ORDEN");
		lblNewLabel_7_1_3.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_3.add(lblNewLabel_7_1_3);
		
		RoundedPanel panel_1_3_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_3_1.setOpaque(false);
		panel_1_3_1.setBounds(715, 114, 131, 28);
		orden1.add(panel_1_3_1);
		panel_1_3_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_3_1 = new JLabel("DESASIGNAR ORDEN");
		lblNewLabel_7_1_3_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_3_1.add(lblNewLabel_7_1_3_1);
		
		RoundedPanel panel_1_3_2 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_3_2.setOpaque(false);
		panel_1_3_2.setBounds(572, 114, 131, 28);
		orden1.add(panel_1_3_2);
		panel_1_3_2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_3_2 = new JLabel("FINALIZAR ORDEN");
		lblNewLabel_7_1_3_2.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_3_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_3_2.add(lblNewLabel_7_1_3_2);
		
		JPanel orden2= new JPanel();
		orden2.setBackground(new Color(140, 164, 179));
		orden2.setBounds(27, 256, 1000, 153);
		ordenesTrabajo.add(orden2);
		orden2.setLayout(null);
		
		JPanel orden1_1 = new JPanel();
		orden1_1.setLayout(null);
		orden1_1.setBackground(new Color(140, 164, 179));
		orden1_1.setBounds(0, 0, 1000, 153);
		orden2.add(orden1_1);
		
		JLabel lblNewLabel_9_2 = new JLabel("Matrícula");
		lblNewLabel_9_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9_2.setBounds(32, 11, 55, 14);
		orden1_1.add(lblNewLabel_9_2);
		
		JLabel lblNewLabel_10_8 = new JLabel("Fecha Ingreso");
		lblNewLabel_10_8.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_8.setBounds(120, 11, 80, 14);
		orden1_1.add(lblNewLabel_10_8);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("Hora");
		lblNewLabel_10_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_1_1.setBounds(227, 11, 46, 14);
		orden1_1.add(lblNewLabel_10_1_1);
		
		JLabel lblNewLabel_10_2_1 = new JLabel("Problema Descrito");
		lblNewLabel_10_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_2_1.setBounds(305, 11, 107, 14);
		orden1_1.add(lblNewLabel_10_2_1);
		
		JLabel lblNewLabel_10_3_1 = new JLabel("Servicio");
		lblNewLabel_10_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_3_1.setBounds(453, 11, 46, 14);
		orden1_1.add(lblNewLabel_10_3_1);
		
		JLabel lblNewLabel_10_4_1 = new JLabel("Estado");
		lblNewLabel_10_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_4_1.setBounds(551, 11, 46, 14);
		orden1_1.add(lblNewLabel_10_4_1);
		
		JLabel lblNewLabel_10_5_1 = new JLabel("Piezas");
		lblNewLabel_10_5_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_5_1.setBounds(645, 11, 46, 14);
		orden1_1.add(lblNewLabel_10_5_1);
		
		JLabel lblNewLabel_10_6_1 = new JLabel("Informacion Cliente");
		lblNewLabel_10_6_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_6_1.setBounds(731, 11, 115, 14);
		orden1_1.add(lblNewLabel_10_6_1);
		
		JLabel lblNewLabel_10_7_1 = new JLabel("Hist. Vehiculo");
		lblNewLabel_10_7_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_7_1.setBounds(873, 11, 75, 14);
		orden1_1.add(lblNewLabel_10_7_1);
		
		JLabel lblNewLabel_9_1_3 = new JLabel("1234 ABC");
		lblNewLabel_9_1_3.setBounds(32, 28, 50, 14);
		orden1_1.add(lblNewLabel_9_1_3);
		
		JLabel lblNewLabel_9_1_1_3 = new JLabel("08/10/2025");
		lblNewLabel_9_1_1_3.setBounds(125, 28, 64, 14);
		orden1_1.add(lblNewLabel_9_1_1_3);
		
		JLabel lblNewLabel_9_1_2_1 = new JLabel("12:00");
		lblNewLabel_9_1_2_1.setBounds(226, 28, 36, 14);
		orden1_1.add(lblNewLabel_9_1_2_1);
		
		JLabel lblNewLabel_9_1_1_1_1 = new JLabel("Problemas");
		lblNewLabel_9_1_1_1_1.setBounds(306, 28, 84, 14);
		orden1_1.add(lblNewLabel_9_1_1_1_1);
		
		JLabel lblNewLabel_9_1_1_2_1 = new JLabel("Mecánica");
		lblNewLabel_9_1_1_2_1.setBounds(454, 28, 50, 14);
		orden1_1.add(lblNewLabel_9_1_1_2_1);
		
		RoundedPanel panel_1_4 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_4.setOpaque(false);
		panel_1_4.setBounds(768, 28, 46, 28);
		orden1_1.add(panel_1_4);
		panel_1_4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_4 = new JLabel("VER");
		lblNewLabel_7_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_4.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_4.add(lblNewLabel_7_1_4);
		
		RoundedPanel panel_1_1_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_1_1.setOpaque(false);
		panel_1_1_1.setBounds(885, 28, 46, 28);
		orden1_1.add(panel_1_1_1);
		panel_1_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_1_1 = new JLabel("VER");
		lblNewLabel_7_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_1_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_1_1.add(lblNewLabel_7_1_1_1);
		
		RoundedPanel panel_1_2_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_2_1.setOpaque(false);
		panel_1_2_1.setBounds(640, 28, 46, 28);
		orden1_1.add(panel_1_2_1);
		panel_1_2_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_2_1 = new JLabel("VER");
		lblNewLabel_7_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_2_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_2_1.add(lblNewLabel_7_1_2_1);
		
		RoundedPanel panel_1_3_3 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_3_3.setOpaque(false);
		panel_1_3_3.setBounds(859, 114, 131, 28);
		orden1_1.add(panel_1_3_3);
		panel_1_3_3.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_3_3 = new JLabel("MODIFICAR ORDEN");
		lblNewLabel_7_1_3_3.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_3_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_3_3.add(lblNewLabel_7_1_3_3);
		
		RoundedPanel panel_1_3_1_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_3_1_1.setOpaque(false);
		panel_1_3_1_1.setBounds(715, 114, 131, 28);
		orden1_1.add(panel_1_3_1_1);
		panel_1_3_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_3_1_1 = new JLabel("DESASIGNAR ORDEN");
		lblNewLabel_7_1_3_1_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_3_1_1.add(lblNewLabel_7_1_3_1_1);
		
		RoundedPanel panel_1_3_2_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_3_2_1.setOpaque(false);
		panel_1_3_2_1.setBounds(572, 114, 131, 28);
		orden1_1.add(panel_1_3_2_1);
		panel_1_3_2_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_3_2_1 = new JLabel("FINALIZAR ORDEN");
		lblNewLabel_7_1_3_2_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_3_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_3_2_1.add(lblNewLabel_7_1_3_2_1);
		
		JPanel orden1_1_1 = new JPanel();
		orden1_1_1.setLayout(null);
		orden1_1_1.setBackground(new Color(140, 164, 179));
		orden1_1_1.setBounds(27, 453, 1000, 153);
		ordenesTrabajo.add(orden1_1_1);
		
		JLabel lblNewLabel_9_2_1 = new JLabel("Matrícula");
		lblNewLabel_9_2_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_9_2_1.setBounds(32, 11, 55, 14);
		orden1_1_1.add(lblNewLabel_9_2_1);
		
		JLabel lblNewLabel_10_8_1 = new JLabel("Fecha Ingreso");
		lblNewLabel_10_8_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_8_1.setBounds(120, 11, 80, 14);
		orden1_1_1.add(lblNewLabel_10_8_1);
		
		JLabel lblNewLabel_10_1_1_1 = new JLabel("Hora");
		lblNewLabel_10_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_1_1_1.setBounds(227, 11, 46, 14);
		orden1_1_1.add(lblNewLabel_10_1_1_1);
		
		JLabel lblNewLabel_10_2_1_1 = new JLabel("Problema Descrito");
		lblNewLabel_10_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_2_1_1.setBounds(305, 11, 107, 14);
		orden1_1_1.add(lblNewLabel_10_2_1_1);
		
		JLabel lblNewLabel_10_3_1_1 = new JLabel("Servicio");
		lblNewLabel_10_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_3_1_1.setBounds(453, 11, 46, 14);
		orden1_1_1.add(lblNewLabel_10_3_1_1);
		
		JLabel lblNewLabel_10_4_1_1 = new JLabel("Estado");
		lblNewLabel_10_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_4_1_1.setBounds(551, 11, 46, 14);
		orden1_1_1.add(lblNewLabel_10_4_1_1);
		
		JLabel lblNewLabel_10_5_1_1 = new JLabel("Piezas");
		lblNewLabel_10_5_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_5_1_1.setBounds(645, 11, 46, 14);
		orden1_1_1.add(lblNewLabel_10_5_1_1);
		
		JLabel lblNewLabel_10_6_1_1 = new JLabel("Informacion Cliente");
		lblNewLabel_10_6_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_6_1_1.setBounds(731, 11, 115, 14);
		orden1_1_1.add(lblNewLabel_10_6_1_1);
		
		JLabel lblNewLabel_10_7_1_1 = new JLabel("Hist. Vehiculo");
		lblNewLabel_10_7_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_10_7_1_1.setBounds(873, 11, 75, 14);
		orden1_1_1.add(lblNewLabel_10_7_1_1);
		
		JLabel lblNewLabel_9_1_3_1 = new JLabel("1234 ABC");
		lblNewLabel_9_1_3_1.setBounds(32, 28, 50, 14);
		orden1_1_1.add(lblNewLabel_9_1_3_1);
		
		JLabel lblNewLabel_9_1_1_3_1 = new JLabel("08/10/2025");
		lblNewLabel_9_1_1_3_1.setBounds(125, 28, 64, 14);
		orden1_1_1.add(lblNewLabel_9_1_1_3_1);
		
		JLabel lblNewLabel_9_1_2_1_1 = new JLabel("12:00");
		lblNewLabel_9_1_2_1_1.setBounds(226, 28, 36, 14);
		orden1_1_1.add(lblNewLabel_9_1_2_1_1);
		
		JLabel lblNewLabel_9_1_1_1_1_1 = new JLabel("Problemas");
		lblNewLabel_9_1_1_1_1_1.setBounds(306, 28, 84, 14);
		orden1_1_1.add(lblNewLabel_9_1_1_1_1_1);
		
		JLabel lblNewLabel_9_1_1_2_1_1 = new JLabel("Mecánica");
		lblNewLabel_9_1_1_2_1_1.setBounds(454, 28, 50, 14);
		orden1_1_1.add(lblNewLabel_9_1_1_2_1_1);
		
		RoundedPanel panel_1_4_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_4_1.setOpaque(false);
		panel_1_4_1.setBounds(768, 28, 46, 28);
		orden1_1_1.add(panel_1_4_1);
		panel_1_4_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_4_1 = new JLabel("VER");
		lblNewLabel_7_1_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_4_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_4_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_4_1.add(lblNewLabel_7_1_4_1);
		
		RoundedPanel panel_1_1_1_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_1_1_1.setOpaque(false);
		panel_1_1_1_1.setBounds(885, 28, 46, 28);
		orden1_1_1.add(panel_1_1_1_1);
		panel_1_1_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_1_1_1 = new JLabel("VER");
		lblNewLabel_7_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_1_1_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_1_1_1.add(lblNewLabel_7_1_1_1_1);
		
		RoundedPanel panel_1_2_1_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_2_1_1.setOpaque(false);
		panel_1_2_1_1.setBounds(640, 28, 46, 28);
		orden1_1_1.add(panel_1_2_1_1);
		panel_1_2_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_2_1_1 = new JLabel("VER");
		lblNewLabel_7_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_2_1_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_2_1_1.add(lblNewLabel_7_1_2_1_1);
		
		RoundedPanel panel_1_3_3_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_3_3_1.setOpaque(false);
		panel_1_3_3_1.setBounds(859, 114, 131, 28);
		orden1_1_1.add(panel_1_3_3_1);
		panel_1_3_3_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_3_3_1 = new JLabel("MODIFICAR ORDEN");
		lblNewLabel_7_1_3_3_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_3_3_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_3_3_1.add(lblNewLabel_7_1_3_3_1);
		
		RoundedPanel panel_1_3_1_1_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_3_1_1_1.setOpaque(false);
		panel_1_3_1_1_1.setBounds(715, 114, 131, 28);
		orden1_1_1.add(panel_1_3_1_1_1);
		panel_1_3_1_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_3_1_1_1 = new JLabel("DESASIGNAR ORDEN");
		lblNewLabel_7_1_3_1_1_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_3_1_1_1.add(lblNewLabel_7_1_3_1_1_1);
		
		RoundedPanel panel_1_3_2_1_1 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_3_2_1_1.setOpaque(false);
		panel_1_3_2_1_1.setBounds(572, 114, 131, 28);
		orden1_1_1.add(panel_1_3_2_1_1);
		panel_1_3_2_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_3_2_1_1 = new JLabel("FINALIZAR ORDEN");
		lblNewLabel_7_1_3_2_1_1.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_3_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_3_2_1_1.add(lblNewLabel_7_1_3_2_1_1);
		
		JLabel lblrdenesDeTrabajo = new JLabel("Órdenes de trabajo");
		lblrdenesDeTrabajo.setForeground(new Color(234, 234, 234));
		lblrdenesDeTrabajo.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblrdenesDeTrabajo.setBounds(27, 11, 199, 22);
		ordenesTrabajo.add(lblrdenesDeTrabajo);
		
		RoundedPanel panel_1_3_4 = new RoundedPanel(15, new Color(76, 87, 92));
		panel_1_3_4.setOpaque(false);
		panel_1_3_4.setBounds(896, 20, 131, 28);
		ordenesTrabajo.add(panel_1_3_4);
		panel_1_3_4.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 7));
		
		JLabel lblNewLabel_7_1_3_4 = new JLabel("ASIGNAR ORDEN");
		lblNewLabel_7_1_3_4.setForeground(new Color(220, 220, 220));
		lblNewLabel_7_1_3_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1_3_4.add(lblNewLabel_7_1_3_4);
		
		
		
		
	}
	
	public void colorMenu(){
		lblInicio.setBackground(new Color(146, 171, 186));
		lblOrdenes.setBackground(new Color(146, 171, 186));
		
		lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblOrdenes.setFont(new Font("Tahoma", Font.PLAIN, 12));

		lblInicio.setForeground(new Color(0, 0, 0));
		lblOrdenes.setForeground(new Color(0, 0, 0));
		
		
		
	}
}
