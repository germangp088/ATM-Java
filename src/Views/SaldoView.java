package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.ATM;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class SaldoView extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel jSaldoAccLbl;

	public SaldoView() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ATM.getInstance().getMediator().showMenu();
			}
		});
		setResizable(false);
		setBackground(new Color(51, 153, 204));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setjSaldoAccLbl(new JLabel(""));
		getjSaldoAccLbl().setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATM.getInstance().getMediator().showMenu();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnVolver, GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(jSaldoAccLbl)
					.addContainerGap(347, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addGap(91)
					.addComponent(jSaldoAccLbl)
					.addPreferredGap(ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
					.addComponent(btnVolver))
		);
		contentPane.setLayout(gl_contentPane);
	}

	public JLabel getjSaldoAccLbl() {
		return jSaldoAccLbl;
	}

	public void setjSaldoAccLbl(JLabel jSaldoAccLbl) {
		this.jSaldoAccLbl = jSaldoAccLbl;
	}
}
