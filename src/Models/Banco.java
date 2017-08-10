package Models;

import java.util.Date;
import java.util.ArrayList;

public class Banco {
	private static Banco instance = null;
    private ArrayList<Cliente> clientes;
    private ArrayList<Transaccion> transacciones;

    private Banco() {
    	clientes = new ArrayList<Cliente>();
    	transacciones =  new ArrayList<Transaccion>();
    	agregarCliente("German", "Dario", new CajaAhorro(12345,80000,8000));
    	agregarCliente("Pepe", "Pompin", new CajaAhorro(15451,45872,1));
    	agregarCliente("Ricardo", "Fort", new CuentaCorriente(57896,45623,1000000000));
    }
    
    public static Banco getInstance () {
    	if (instance == null)
			instance = new Banco ();
		return instance;
    }

    public void agregarCliente(String nombre, String apellido, Cuenta cuenta) {
    	clientes.add(new Cliente(nombre, apellido, cuenta));
    }

    public void agregarTransaccion(Cliente cliente, double monto, Moneda moneda, Date fecha){
    	transacciones.add(new Transaccion(cliente, monto, moneda, fecha));
    }
    
    public Cliente getCliente(Sesion sesion) {
    	Cliente client = null;
    	for (Cliente cliente : clientes) {
			if (cliente.getCuenta().getNroCuenta() == sesion.getNroCuenta() && cliente.getCuenta().getNIP() == sesion.getNIP()) {
				client = cliente;
			}
		}
        return client;
    }

	public ArrayList<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(ArrayList<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

}
