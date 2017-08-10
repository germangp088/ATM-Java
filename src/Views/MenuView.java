package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controllers.MenuController;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class MenuView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private MenuController menuController = new MenuController();
	
	public MenuView() {
		initComponents();
	}
	
	private void initComponents() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				menuController.salir();
			}
		});
		setBackground(new Color(51, 153, 204));
		setBounds(100, 100, 420, 300);
        setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSolicitarSaldo = new JButton("1");
		btnSolicitarSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuController.solicitarSaldo();
			}
		});
		
		JButton btnRetiro = new JButton("2");
		btnRetiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuController.retirarDinero();
			}
		});
		
		JLabel lblBienvenidoseleccioneUnaOpcin = new JLabel("Bienvenido");
		lblBienvenidoseleccioneUnaOpcin.setFont(new Font("Tahoma", Font.PLAIN, 24));
		
		JLabel lblSeleccioneUnaOpcin = new JLabel("Seleccione una opci\u00F3n para operar");
		lblSeleccioneUnaOpcin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel = new JLabel("Solicitar Saldo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblRetiro = new JLabel("Retiro");
		lblRetiro.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnDeposito = new JButton("3");
		btnDeposito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuController.depositarSaldo();
			}
		});
		
		JButton btnSalir = new JButton("4");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				menuController.salir();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Dep\u00F3sito");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblSalir = new JLabel("Salir");
		lblSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(1)
							.addComponent(lblSeleccioneUnaOpcin))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(79)
							.addComponent(lblBienvenidoseleccioneUnaOpcin))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnSolicitarSaldo)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
									.addComponent(btnDeposito))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRetiro)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblRetiro)
									.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
									.addComponent(btnSalir)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblSalir))))
					.addGap(33))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(lblBienvenidoseleccioneUnaOpcin)
					.addGap(18)
					.addComponent(lblSeleccioneUnaOpcin)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSolicitarSaldo)
								.addComponent(lblNewLabel)
								.addComponent(btnDeposito))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnRetiro)
								.addComponent(lblRetiro)
								.addComponent(btnSalir)
								.addComponent(lblSalir)))
						.addComponent(lblNewLabel_1))
					.addContainerGap(69, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
