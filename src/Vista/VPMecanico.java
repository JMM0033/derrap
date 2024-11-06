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

public class VPMecanico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Usuario usuario;
	private ConexionMySQL conexion;

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
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 214, 683);
		panelMenu.setBackground(new Color(140, 164, 179));
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inicio");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBackground(new Color(146, 171, 186));
		lblNewLabel.setBounds(0, 129, 214, 45);
		lblNewLabel.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		

		JLabel lblNewLabel2 = new JLabel("Órdenes de Trabajo");
		lblNewLabel2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel2.setBackground(new Color(146, 171, 186));
		lblNewLabel2.setBounds(0, 184, 214, 45);
		lblNewLabel2.setBorder(new EmptyBorder(0, 20, 0, 0));
		lblNewLabel2.setOpaque(true);
		lblNewLabel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblNewLabel2);
		

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
		
		lblNewLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Yay you clicked me");
            }

        });
		
		panelMenu.add(lblNewLabel);
		
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
		JPanel panel = new RoundedPanel(15,colorBoton);
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
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(lblNewLabel_7);
		
		JPanel ContenedorPrincipal = new JPanel();
		ContenedorPrincipal.setBounds(214, 50, 1052, 633);
		ContenedorPrincipal.setBackground(new Color(163, 188, 204));
		contentPane.add(ContenedorPrincipal);
		ContenedorPrincipal.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Buenos Días,");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 10, 135, 22);
		ContenedorPrincipal.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel(usuario.getNombre());
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(144, 10, 135, 22);
		ContenedorPrincipal.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Actualmente tienes");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 32, 121, 15);
		ContenedorPrincipal.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("X");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(132, 32, 10, 15);
		ContenedorPrincipal.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("órdenes de Reparacióbn Asignadas");
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
	}
}
