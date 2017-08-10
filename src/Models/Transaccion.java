package Models;

import java.util.Date;

public class Transaccion {
	private Cliente cliente;
	private double monto;
	private Moneda moneda;
	private Date fecha;
	
	public Transaccion(Cliente cliente, double monto, Moneda moneda, Date fecha)
	{
		setCliente(cliente);
		setMonto(monto);
		setMoneda(moneda);
		setFecha(fecha);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
