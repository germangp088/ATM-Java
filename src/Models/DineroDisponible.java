package Models;

public class DineroDisponible implements IValorizado {
	private Moneda moneda;
	private int cantidad;
	private int valor;
	public DineroDisponible(int cantidad, int valor, Moneda moneda)
	{
		this.cantidad = cantidad;
		this.valor = valor;
		this.moneda = moneda;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getValor() {
		return valor;
	}
	
	public void setValor(int valor) {
		this.valor = valor;
	}

	public Moneda getMoneda() {
		return moneda;
	}

	public void setMoneda(Moneda moneda) {
		this.moneda = moneda;
	}
}
