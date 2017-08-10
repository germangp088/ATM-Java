package Models;

public class Cliente {
	private Cuenta cuenta;
	private String apellido;
	private String nombre;
	
	public Cliente()
	{
	}
	
	public Cliente(String nombre,String apellido, Cuenta cuenta)
	{
		this.cuenta = cuenta;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
    }
	
	public String getNombre() {
        return nombre;
    }

	public void setApellido(String apellido) {
		this.apellido = apellido;
    }
	
    public String getApellido() {
        return apellido;
    }

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
}
