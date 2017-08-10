package Controllers;

import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Models.ATM;
import Models.Menu;
import Models.Moneda;
import Views.NumericContainerView;

public class NumericContainerController {
	private NumericContainerView numericContainerView;
	public NumericContainerController(NumericContainerView numericContainerView) {
		this.numericContainerView = numericContainerView;
	}

	public void ingresarValorPassword(String value) {
		JPasswordField jNumericTxt = numericContainerView.getNumericValueView().getjNumericTxt();
		if (value.matches("-?\\d+(\\.\\d+)?")) {
			if (jNumericTxt.getPassword().length < 5) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(jNumericTxt.getPassword());
				jNumericTxt.setText(getValueString(value, stringBuilder.toString()));
			}
			
		} else {
			jNumericTxt.setText(procesarEntrada(value, getPasswordFieldValue(jNumericTxt)));
		}
	}
	
	public void ingresarValor(String value) {
		JTextField jTextField = numericContainerView.getNumericValueView().getTextField();
		if (value.matches("-?\\d+(\\.\\d+)?")) {
			jTextField.setText(getValueString(value, jTextField.getText()));
			
		} else {
			jTextField.setText(procesarEntrada(value, jTextField.getText()));
		}
	}
	
	private String procesarEntrada(String value, String txtValue)
	{
		String fieldValue = "";
		switch (value) {
		case "\b":
		case "DEL":
			if (txtValue.length() > 0) {
				fieldValue = txtValue.substring(0, txtValue.length() - 1);
		    }
			return fieldValue;
		case "\n":
		case "OK":
			if (isPass()) {
				if (txtValue.length() == 5) {
					procesarEntradaNumerica(txtValue);
					txtValue = "";
				}
			} else {
				if (txtValue.length() > 0) {
					procesarEntradaNumerica(txtValue);
					txtValue = "";
				}
			}
			return txtValue;
		}
		return fieldValue;
	}
	
	private String getValueString(String value, String valueConcat)
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(valueConcat);
		stringBuilder.append(value);
		return stringBuilder.toString();
	}
	
	private String getPasswordFieldValue(JPasswordField jNumericTxt)
	{
		char[] str = jNumericTxt.getPassword();
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(str);
		return stringBuilder.toString();
	}
	
	private void procesarEntradaNumerica(String fieldValue)
	{
		switch (ATM.getInstance().getMenu()) {
			case INGRESARACC:
				ATM.getInstance()
					.getSesion()
					.setNroCuenta(Integer.parseInt(fieldValue));
				ATM.getInstance().setMenu(Menu.INGRESARNIP);
				numericContainerView.getNumericValueView().getjLblDesc().setText("Introduzca su NIP:");
				break;
			case INGRESARNIP:
				ATM.getInstance()
				.getSesion()
				.setNIP(Integer.parseInt(fieldValue));
				numericContainerView.getNumericValueView().getjLblDesc().setText("Introduzca un número de cuenta:");
				new ATMController().autenticarUsuario();
				break;
			case DEPOSITAR:
				ATM.getInstance().getCliente().getCuenta().depositar(Double.parseDouble(fieldValue), Moneda.PESO);
				break;
			case RETIRAR:
				numericContainerView.getNumericValueView().getjLblDesc().setText("Introduzca monto a retirar:");
				if (new ATMController().validarMontoAExtraer(Double.parseDouble(fieldValue),Moneda.PESO)) {
					ATM.getInstance().getCliente().getCuenta().extraer(Double.parseDouble(fieldValue), Moneda.PESO);
				}
				else {
					numericContainerView.getNumericValueView().getjLblDesc().setText("Dinero insufiente en ATM, ingrese otro monto:");
				}
				break;
			default:
				break;
		}		
	}
	
	public boolean isPass()
	{
		return numericContainerView.getNumericValueView().isPass();
	}
}
