package Controllers;

import Models.ATM;
import Models.Cuenta;
import Models.Sesion;

public class MenuController {
	public void salir()
	{
		ATM.getInstance().setSesion(new Sesion());
		ATM.getInstance().getMediator().showInit();
	}
	
	public void solicitarSaldo()
	{
		Cuenta cuenta = ATM.getInstance().getCliente().getCuenta();
		ATM.getInstance().getMediator().getSaldoView()
										.getjSaldoAccLbl()
										.setText(cuenta.toString());
		ATM.getInstance().getMediator().showSaldo();
	}
	
	public void depositarSaldo()
	{
		ATM.getInstance().getMediator().showDeposit();
	}

	public void retirarDinero() {
		ATM.getInstance().getMediator().showRetiro();
	}
}
