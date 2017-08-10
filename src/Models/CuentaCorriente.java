package Models;

import Controllers.ATMController;

public class CuentaCorriente extends Cuenta {

	public CuentaCorriente(int nroCuenta, int NIP, double saldo) {
		super(nroCuenta, NIP, saldo);
	}

	@Override
	public void extraer(double monto, Moneda moneda) {
		ATMController ATMController = new ATMController();
		double total = ATMController.getDineroDisponible(moneda);
		if (saldo >= monto && total >= monto) {
			saldo -= total;
			ATMController.extraer(monto, moneda);
		}
	}

	@Override
	public String getDescripcion() {
		return "Numero de cuenta " + getNroCuenta();
	}

	@Override
	public void depositar(double monto, Moneda moneda) {
		saldo += monto;
		new ATMController().generarTransaccion(monto, moneda);
	}
}
