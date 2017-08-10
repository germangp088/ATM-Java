package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.NumericContainerController;
import Models.ATM;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class RetiroView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private NumericContainerView numericContainerView;
    private NumericContainerController numericContainerController;

	public RetiroView()  {
		initComponents();
	}
	
	private void initComponents() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ATM.getInstance().getMediator().showMenu();
			}
		});
		requestFocusInWindow();
        setFocusable(true);
        requestFocus();
    	addKeyListener(new KeyAdapter() {
    		@Override
    		public void keyReleased(KeyEvent e) {
    			numericContainerController.ingresarValor(String.valueOf(e.getKeyChar()));
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
		setResizable(false);
		setBackground(new Color(51, 153, 204));
		setBounds(100, 100, 600, 421);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		NumericContainerView numericContainerView = new NumericContainerView("Introduzca monto a retirar:", false);

        numericContainerController = new NumericContainerController(numericContainerView);
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numericContainerView.getNumericValueView().getTextField().setText("");
				setVisible(false);
				ATM.getInstance().getMediator().showMenu();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnVolver)
						.addComponent(numericContainerView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(numericContainerView, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addComponent(btnVolver)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	public NumericContainerView getNumericContainerView() {
		return numericContainerView;
	}

	public void setNumericContainerView(NumericContainerView numericContainerView) {
		this.numericContainerView = numericContainerView;
	}
}
