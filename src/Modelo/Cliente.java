package Modelo;

public class Cliente {

	int id;
	String nombre;
	String apellidos;
	String dni;
	String telefono;
	String correo;
	String direccion;
	
	public  Cliente(int id, String n, String a, String d, String t, String c, String dir) {
		this.id = id;
		this.nombre = n;
		this.apellidos = a;
		this.dni = d;
		this.telefono = t;
		this.correo = c;
		this.direccion = dir;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
