package Controllers;

import java.util.Date;

import Models.ATM;
import Models.Banco;
import Models.DineroDisponible;
import Models.Moneda;
import Models.Sesion;

public class ATMController {
	public void autenticarUsuario()
	{
		if(autenticarUsuario(ATM.getInstance().getSesion()))
		{
			ATM.getInstance().getMediator().showMenu();
		}
		else
		{
			ATM.getInstance().setSesion(new Sesion());
			ATM.getInstance().getMediator().errorLogin();
		}
	}
	
	public boolean validarMontoAExtraer(double monto, Moneda moneda) {
		double montoAExtraer = monto;
		for (DineroDisponible dineroDisponibleATM : ATM.getInstance().getDineroDisponible()) {
			if (dineroDisponibleATM.getMoneda() == moneda) {
				while (montoAExtraer > 0) {
					montoAExtraer -= dineroDisponibleATM.getValor();
				}
			}
		}
		return montoAExtraer == 0;
	}
	
	public void extraer(double monto, Moneda moneda) {
		double montoAExtraer = monto;
		for (DineroDisponible dineroDisponibleATM : ATM.getInstance().getDineroDisponible()) {
			if (dineroDisponibleATM.getMoneda() == moneda) {
				while (montoAExtraer > 0 && dineroDisponibleATM.getCantidad() > 0) {
					montoAExtraer -= dineroDisponibleATM.getValor();
					dineroDisponibleATM.setCantidad(dineroDisponibleATM.getCantidad()-1);;
				}
			}
		}
		generarTransaccion(monto, moneda);
	}

	public void generarTransaccion(double monto, Moneda moneda) {
		Banco.getInstance().agregarTransaccion(ATM.getInstance().getCliente(), monto, moneda, new Date());
	}

	//Obtiene el dinero disponible en el ATM segun la moneda pedida.
	public double getDineroDisponible(Moneda moneda) {
		double total = 0;
		for (DineroDisponible dineroDisponibleATM : ATM.getInstance().getDineroDisponible()) {
			if (dineroDisponibleATM.getMoneda() == moneda) {
				total += dineroDisponibleATM.getValor() * dineroDisponibleATM.getCantidad();
			}
		}
		return total;
	}
	
	public boolean autenticarUsuario(Sesion sesion)
	{
		ATM.getInstance().setCliente(Banco.getInstance().getCliente(sesion));
		return ATM.getInstance().getCliente() != null;
	}
}
