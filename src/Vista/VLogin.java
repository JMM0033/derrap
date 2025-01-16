package Vista;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.nio.channels.NonWritableChannelException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import Controlador.JTextFieldLimit;
import Modelo.Usuario;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import Controlador.ConexionMySQL;


public class VLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldUsuario;
	private JPasswordField passwordField;
	
	public Usuario usuario = null;
	public ConexionMySQL conexion = new ConexionMySQL();
	public Connection conect = null;
	public PreparedStatement stmt = null;
	private boolean isDialogOpen = false;
	boolean connected = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VLogin frame = new VLogin();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VLogin() {		
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Derrap");
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBounds(274, 111, 632, 537);
		panelLogin.setOpaque(false);
		contentPane.add(panelLogin);
		
		JLabel lblDerrapLogo = new JLabel();
		lblDerrapLogo.setBounds(275, 380, 200, 150);
		ImageIcon lblDerrapLogoIcon = new ImageIcon(VLogin.class.getResource("/img/derrapDrawLogo.png"));
		Image lblDerrapLogoImage = lblDerrapLogoIcon.getImage();
		Image newlblDerrapLogo = lblDerrapLogoImage.getScaledInstance(164, 124, Image.SCALE_DEFAULT);
		lblDerrapLogo.setIcon(new ImageIcon(newlblDerrapLogo));
		panelLogin.add(lblDerrapLogo);
		
		JLabel lblForgetPswd = new JLabel("<HTML><U>¿Has olvidado tu contraseña?</U></HTML>");
		lblForgetPswd.setForeground(new Color(255, 255, 255));
		lblForgetPswd.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblForgetPswd.setBounds(265, 360, 200, 30);
		lblForgetPswd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblForgetPswd.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "❌En Desarrollo❌", "En Desarrollo", JOptionPane.ERROR_MESSAGE);
				
			};
		});
		panelLogin.add(lblForgetPswd);
		// lblLoginButton.addMouseListener(new MouseListener()
		
		JLabel lblLoginButton = new JLabel();
		lblLoginButton.setBounds(382, 325, 95, 30);
		ImageIcon lblLoginButtonIcon = new ImageIcon(VLogin.class.getResource("/img/Button.png"));
		Image lblLoginButtonImage = lblLoginButtonIcon.getImage();
		Image newlblLoginButton = lblLoginButtonImage.getScaledInstance(72, 24, Image.SCALE_DEFAULT);
		lblLoginButton.setIcon(new ImageIcon(newlblLoginButton));
		lblLoginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		
		lblLoginButton.addMouseListener(new MouseAdapter() {
			@Override
            public void mouseClicked(MouseEvent e) {
				conectar();
            }
		});
		
		
		panelLogin.add(lblLoginButton);
		
		JLabel lblLockLogo = new JLabel();
		lblLockLogo.setBounds(248, 282, 20, 20);
		ImageIcon lblLockIcon = new ImageIcon(VLogin.class.getResource("/img/Lock.png"));
		Image lblLockImage = lblLockIcon.getImage();
		Image newlblLock = lblLockImage.getScaledInstance(18, 18, Image.SCALE_DEFAULT);
		lblLockLogo.setIcon(new ImageIcon(newlblLock));
		panelLogin.add(lblLockLogo);
		
		JLabel lblUserLogo = new JLabel();
		lblUserLogo.setBounds(248, 207, 20, 20);
		ImageIcon lblUserIcon = new ImageIcon(VLogin.class.getResource("/img/User.png"));
		Image lblUserImage = lblUserIcon.getImage();
		Image newlblUser = lblUserImage.getScaledInstance(18, 18, Image.SCALE_DEFAULT);
		lblUserLogo.setIcon(new ImageIcon(newlblUser));
		panelLogin.add(lblUserLogo);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(270, 282, 187, 24);
		passwordField.setMargin(new Insets(0, 5, 0, 0));
		panelLogin.add(passwordField);
		
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textFieldUsuario.setBounds(270, 205, 187, 24);
		textFieldUsuario.setMargin(new Insets(0, 5, 0, 0));
		panelLogin.add(textFieldUsuario);
		// Clase para limitar los caracteres
		textFieldUsuario.setDocument
		(new JTextFieldLimit(24));
		

		textFieldUsuario.setColumns(10);
		
		JLabel lblDerrLogo = new JLabel();
		lblDerrLogo.setBounds(103, 55, 496, 60);
		ImageIcon lblDerrLogoIcon = new ImageIcon(VLogin.class.getResource("/img/derrapLetterLogo.png"));
		Image lblDerrLogoImage = lblDerrLogoIcon.getImage();
		Image newlblDerrLogo = lblDerrLogoImage.getScaledInstance(496, 60, Image.SCALE_DEFAULT);
		lblDerrLogo.setIcon(new ImageIcon(newlblDerrLogo));
		
		panelLogin.add(lblDerrLogo);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(new Color(255, 255, 255));
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(250, 175, 55, 34);
		panelLogin.add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contraseña");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(250, 250, 83, 34);
		panelLogin.add(lblPassword);
		
		JLabel lblRecAzul = new JLabel();
		lblRecAzul.setBounds(99, 27, 500, 500);
		ImageIcon lblRecAzulIcon = new ImageIcon(VLogin.class.getResource("/img/recLogin.png"));
		Image lblRecAzulImage = lblRecAzulIcon.getImage();
		Image newlblRecAzul = lblRecAzulImage.getScaledInstance(500, 500, Image.SCALE_DEFAULT);
		lblRecAzul.setIcon(new ImageIcon(newlblRecAzul));
		
		JLabel bg = new JLabel();
		bg.setBounds(0, 0, 1280, 720);
		ImageIcon bgIcon = new ImageIcon(VLogin.class.getResource("/img/loginBG.png"));
		Image bgImage = bgIcon.getImage();
		Image newBG = bgImage.getScaledInstance(1280, 720, Image.SCALE_DEFAULT);
		bg.setIcon(new ImageIcon(newBG));

		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		panelLogin.setLayout(null);
		contentPane.add(bg);
		panelLogin.add(lblRecAzul);
		
		
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
		  .addKeyEventDispatcher(new KeyEventDispatcher() {
		      @Override
		      public boolean dispatchKeyEvent(KeyEvent e) {
		            if (isDialogOpen) {
		                return false;
		            }
		            if (!connected) {
			            if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getID() == KeyEvent.KEY_PRESSED) {
			                conectar();
			            }
						
					}

		            return false;
		      }
		});
		
	}
	
	public void conectar() {
		conexion.conectar();
		 usuario = conexion.iniciarSesion(textFieldUsuario.getText(), new String(passwordField.getPassword()));
		if (usuario == null) {
			isDialogOpen = true;
			JOptionPane.showMessageDialog(null, "Los datos introducidos son incorrectos", "Error", JOptionPane.ERROR_MESSAGE); 
            isDialogOpen = false;
		} else {
			textFieldUsuario.setText("");
			passwordField.setText("");
			connected = true;
			if (usuario.getRol()==0) { //Administrador
				VPAdmin vpAdmin = new VPAdmin(usuario,conexion);
				vpAdmin.setVisible(true);
				vpAdmin.setResizable(false);
				dispose();
				
			}else if (usuario.getRol() == 1) { //Mecánico
				VPMecanico vpMec = new VPMecanico(usuario,conexion);
				vpMec.setVisible(true);
				vpMec.setResizable(false);
				dispose();
			}
		}
		
	}
	
}
