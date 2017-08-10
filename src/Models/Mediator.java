package Models;

import Views.DepositoView;
import Views.ErrorLoginView;
import Views.InicioView;
import Views.MenuView;
import Views.RetiroView;
import Views.SaldoView;

public class Mediator {
	private InicioView inicioView;
	private MenuView menuView;
	private SaldoView saldoView;
	private DepositoView depositoView;
	private RetiroView retiroView;

	public Mediator()
	{
		setInicioView(new InicioView());
		setMenuView(new MenuView());
		setSaldoView(new SaldoView());
		setDepositoView(new DepositoView());
		setRetiroView(new RetiroView());
	}
	
	public InicioView getInicioView() {
		return inicioView;
	}

	public void setInicioView(InicioView inicioView) {
		this.inicioView = inicioView;
	}
	
	public void errorLogin()
	{
		ATM.getInstance().setMenu(Menu.INGRESARACC);
		inicioView.setVisible(false);
		ErrorLoginView errorLoginView = new ErrorLoginView();
		errorLoginView.setVisible(true);
	}

	public void showInit() {
		ATM.getInstance().setMenu(Menu.INGRESARACC);
		changeVisible(false, true, false, false, false);
	}
	
	public void showMenu() {
		ATM.getInstance().setMenu(Menu.MENU);
		changeVisible(false, false,true, false, false);
	}
	
	public void showSaldo() {
		ATM.getInstance().setMenu(Menu.SALDO);
		changeVisible(true, false,false, false, false);
	}
	
	public void showDeposit() {
		ATM.getInstance().setMenu(Menu.DEPOSITAR);
		changeVisible(false, false,false, true, false);
	}
	
	public void showRetiro() {
		ATM.getInstance().setMenu(Menu.RETIRAR);
		changeVisible(false, false,false, false, true);
	}
	
	private void changeVisible(Boolean saldo, Boolean inicio, Boolean menu, Boolean deposito, Boolean retiro)
	{
		saldoView.setVisible(saldo);
		inicioView.setVisible(inicio);
		menuView.setVisible(menu);
		depositoView.setVisible(deposito);
		retiroView.setVisible(retiro);
	}

	public MenuView getMenuView() {
		return menuView;
	}

	public void setMenuView(MenuView menuView) {
		this.menuView = menuView;
	}

	public SaldoView getSaldoView() {
		return saldoView;
	}

	public void setSaldoView(SaldoView saldoView) {
		this.saldoView = saldoView;
	}

	public DepositoView getDepositoView() {
		return depositoView;
	}

	public void setDepositoView(DepositoView depositoView) {
		this.depositoView = depositoView;
	}

	public RetiroView getRetiroView() {
		return retiroView;
	}

	public void setRetiroView(RetiroView retiroView) {
		this.retiroView = retiroView;
	}
}
