package Controlador;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.protocol.a.NativeConstants.StringLengthDataType;

import Modelo.Cliente;
import Modelo.Usuario;
import Modelo.Vehiculo;

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
    
    public int contarVehiculos() {
    	int res = 0;
    	try {
            stm = cn.createStatement();
            resultado = stm.executeQuery("SELECT count(*) FROM vehiculo");
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
    
    public Vehiculo[] obtenerVehiculos() {
    	int numVehiculos = this.contarVehiculos();
    	int contador = 0;
    	Vehiculo [] vehiculos = new Vehiculo[numVehiculos];
    	Vehiculo vehiculo;
    	try {
            stm = cn.createStatement();
            resultado = stm.executeQuery("SELECT * FROM vehiculo");
            while (resultado.next()) {
                vehiculo = new Vehiculo(resultado.getInt("id"),resultado.getString("matricula"),resultado.getString("marca"),resultado.getString("modelo"),resultado.getInt("ano"),
                		resultado.getInt("clientes_id"),resultado.getString("color"));
                vehiculos[contador]=vehiculo;
                contador++;
                
            }
            stm.close();
            return vehiculos;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	return vehiculos;
			
		}
    	
    

    public void editarCliente(String nuevoNombre, String nuevosApellidos, int nuevoTelefono, String nuevaDireccion, String nuevoDni, String nuevoEmail, int id) {
    	try {
            String query = "UPDATE cliente SET nombre = '" + nuevoNombre + "', apellido = '" + nuevosApellidos + 
                    "', telefono = '" + nuevoTelefono + "', email = '" + nuevoEmail + 
                    "', direccion = '" + nuevaDireccion + "', dni = '" + nuevoDni + 
                    "' WHERE id = " + id;
            cn.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	
    }
    
    public void editarVehiculo(String nuevaMatricula, String nuevaMarca, String nuevoModelo, int nuevoAno, String nuevoColor, int id) {
        try {
            String query = "UPDATE vehiculo SET matricula = '" + nuevaMatricula + "', marca = '" + nuevaMarca + 
                           "', modelo = '" + nuevoModelo + "', ano = " + nuevoAno + 
                           ", color = '" + nuevoColor + "' WHERE id = " + id;
            
            cn.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void crearCliente(String nombre, String apellido, int telefono, String direccion, String dni, String email) {
    	try {
    		stm = cn.createStatement();
            resultado = stm.executeQuery("SELECT id FROM cliente ORDER BY id DESC LIMIT 1;");
            resultado.next();
            int id = resultado.getInt(1) + 1;
            stm.close();
            String query2 = "INSERT INTO cliente (id, nombre, apellido, dni, telefono, email, direccion) " +
                    "VALUES ("+ id + ", '" + nombre + "', '" + apellido + "', '" + dni + "', " + telefono + ", '" + email + "', '" + direccion + "')";
            cn.createStatement().executeUpdate(query2);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	
    }
    
    public void crearVehiculo(String matricula, String marca, String modelo, int ano, int clientes_id, String color) {
        try {
            stm = cn.createStatement();

            resultado = stm.executeQuery("SELECT id FROM vehiculo ORDER BY id DESC LIMIT 1;");
            resultado.next(); 
            int id = resultado.getInt(1) + 1;
            System.out.println(id);

            stm.close();

            String query = "INSERT INTO vehiculo (id, matricula, marca, modelo, ano, clientes_id, color) " +
                           "VALUES (" + id + ", '" + matricula + "', '" + marca + "', '" + modelo + "', " + ano + ", " + clientes_id + ", '" + color + "')";

           
            cn.createStatement().executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    
    public void eliminarCliente(int id) {
    	try {
            String query = "DELETE FROM cliente WHERE id = " + id + ";";
            cn.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	
    }
    
    public void eliminarVehiculo(int id) {
    	try {
            String query = "DELETE FROM vehiculo WHERE id = " + id + ";";
            cn.createStatement().executeUpdate(query);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	
    }

	public Cliente obtenerClienteCoche(int filaSeleccionadaVehiculos) {
    	Cliente cliente = null;
    	try {
            stm = cn.createStatement();
            resultado = stm.executeQuery("SELECT c.* FROM cliente c JOIN vehiculo v ON c.id = v.clientes_id WHERE v.id = '"+filaSeleccionadaVehiculos+"';");
            while (resultado.next()) {
                cliente = new Cliente(resultado.getInt("id"),resultado.getString("nombre"),resultado.getString("apellido"),resultado.getString("dni"),resultado.getString("telefono"),
                		resultado.getString("email"),resultado.getString("direccion"));
  
            }
            stm.close();
            return cliente;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	return cliente;
	}
  
        
        
    }
    
