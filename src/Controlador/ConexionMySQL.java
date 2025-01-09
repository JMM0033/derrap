package Controlador;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Cliente;
import Modelo.Usuario;

public class ConexionMySQL {
    
    private static final String CONTROLADOR = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3307/derrap";
    private static final String USUARIO = "root";
    private static final String PASS = "admin";
    
    Connection cn = null;
    Statement stm = null;
    ResultSet resultado = null;
    
    public Connection conectar() {
        try {
            cn = DriverManager.getConnection(URL, USUARIO, PASS);
            
        } catch (Exception e) {
            System.out.println("Conexion Fallida");
        }
        return cn;
    }
    
    public Usuario iniciarSesion(String usuario, String pass) {
        
            Usuario user = null;
            try {
                stm = cn.createStatement();
                resultado = stm.executeQuery("SELECT * FROM usuario WHERE dni = '"+usuario+"' AND pass = '"+pass+"';");
                while (resultado.next()) {
                    user = new Usuario(resultado.getInt("id"),resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("dni"),resultado.getString("telefono"),
                    		resultado.getString("email"),resultado.getString("pass"),resultado.getInt("estado"),resultado.getInt("rol"));
                }
                stm.close();
                return user;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return null;
            
            
    }
    
    public int contarUsuarios() {
    	int res = 0;
    	try {
            stm = cn.createStatement();
            resultado = stm.executeQuery("SELECT count(*) FROM cliente");
            resultado.next();
            res = resultado.getInt(1);
            stm.close();
            return res;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	
    	return res;
    	
    }
    
 
    
    public Cliente[] obtenerClientes() {
    	int numClientes = this.contarUsuarios();
    	int contador = 0;
    	Cliente [] clientes = new Cliente[numClientes];
    	Cliente cliente;
    	try {
            stm = cn.createStatement();
            resultado = stm.executeQuery("SELECT * FROM cliente");
            while (resultado.next()) {
                cliente = new Cliente(resultado.getInt("id"),resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("dni"),resultado.getString("telefono"),
                		resultado.getString("email"),resultado.getString("direccion"));
                clientes[contador]=cliente;
                contador++;
                
            }
            stm.close();
            return clientes;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	return clientes;
			
		}
    	
    

    
  
        
        
    }
    
