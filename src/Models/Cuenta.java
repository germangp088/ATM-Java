package Models;

public abstract class Cuenta {
	private int nroCuenta;
	private int NIP;
    protected double saldo;
    
    public Cuenta(int nroCuenta, int NIP, double saldo) {
    	this.nroCuenta = nroCuenta;
        this.NIP = NIP;
        this.saldo = saldo;
    }
    
    @Override
    public String toString() {
        return getDescripcion() + ", el saldo es: $" + saldo;
    }
    public abstract void depositar(double monto, Moneda moneda);
    
    public abstract void extraer(double monto, Moneda moneda);
    
    public abstract String getDescripcion();

	public int getNIP() {
		return NIP;
	}

	public void setNIP(int NIP) {
		this.NIP = NIP;
	}

	public void setNroCuenta(int nroCuenta) {
    	this.nroCuenta = nroCuenta;
	}
	
	public int getNroCuenta() {
		return nroCuenta;
	}
}
