package Models;

import java.util.ArrayList;

public class ATM {
	private Menu menu;
	private static ATM instance = null;
	private ArrayList<DineroDisponible> dineroDisponible = new ArrayList<DineroDisponible>();
	private Cliente cliente;
	private Sesion sesion;
	private Mediator mediator;
	
	public ATM()
	{
		menu = Menu.INGRESARACC;
		dineroDisponible.add(new DineroDisponible(500, 20, Moneda.PESO));
		setCliente(new Cliente());
		setSesion(new Sesion());
		setMediator(new Mediator());
	}
	
    public static ATM getInstance() {
    	if (instance == null)
			instance = new ATM();
		return instance;
    }
	
	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public void setDineroDisponible(ArrayList<DineroDisponible> dineroDisponible) {
		this.dineroDisponible = dineroDisponible;
	}
	
	public ArrayList<DineroDisponible> getDineroDisponible() {
		return dineroDisponible;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
}
