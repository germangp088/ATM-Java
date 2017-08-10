package Views;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controllers.NumericContainerController;

public class NumericPadView  extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton buttonCE = new JButton("CE");
    private JButton button0 = new JButton("0");
    private JButton buttonOK = new JButton("OK");
    private JButton buttonDEL = new JButton("DEL");
    private NumericContainerController numericContainerController;
    
    public NumericPadView(NumericContainerController numericContainerController) {
    	this.numericContainerController = numericContainerController;
    	initComponents();
    	
    }

    private void initComponents() {
    	setSize(220, 250);
        setLayout(new GridLayout(5, 3, 2, 2));
        for (int i = 1; i < 10; i++) {
            addButton(new JButton(String.valueOf(i)));
        }
        add(new JLabel());
        addButton(button0);
        add(new JLabel());
        addButton(buttonCE);
        addButton(buttonDEL);
        addButton(buttonOK);
        setVisible(true);
	}

	private void addButton(JButton button) {
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingresarValor(evt,button.getText());
            }
        });
        add(button);
    }
    
	private void ingresarValor(ActionEvent evt, String string) {
		if (numericContainerController.isPass()) {
			numericContainerController.ingresarValorPassword(string);
		} else {
			numericContainerController.ingresarValor(string);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
	}
}