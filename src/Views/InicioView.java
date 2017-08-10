package Views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import Controllers.NumericContainerController;

public class InicioView extends JFrame {

	private static final long serialVersionUID = 1L;
    private JLabel jBienvenidoLbl;
    private NumericContainerView numericContainerView;
    private NumericContainerController numericContainerController;
	
    
    public InicioView() {
        initComponents();
    }
                       
    private void initComponents() {
    	requestFocusInWindow();
        setFocusable(true);
        requestFocus();
    	addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyReleased(KeyEvent e) {
    			numericContainerController.ingresarValorPassword(String.valueOf(e.getKeyChar()));
    		}
    	});
    	addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				requestFocusInWindow();
		        setFocusable(true);
		        requestFocus();
			}
		});
    	getContentPane().setBackground(new Color(51, 153, 204));
        jBienvenidoLbl = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("ATM");
        setResizable(false);


        jBienvenidoLbl.setFont(new Font("Tahoma", 0, 36));
        jBienvenidoLbl.setText("Bienvenido a ATM DaVinci");
        setNumericContainerView(new NumericContainerView("Introduzca un número de cuenta:", true));
        numericContainerController = new NumericContainerController(numericContainerView);
        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(217, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jBienvenidoLbl)
        					.addGap(205))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(numericContainerView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(273))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(64)
        			.addComponent(jBienvenidoLbl)
        			.addGap(45)
        			.addComponent(numericContainerView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(139, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        pack();
    }

	public NumericContainerView getNumericContainerView() {
		return numericContainerView;
	}

	public void setNumericContainerView(NumericContainerView numericContainerView) {
		this.numericContainerView = numericContainerView;
	}
}
