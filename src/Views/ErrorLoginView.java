package Views;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.ATM;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class ErrorLoginView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ErrorLoginView() {
		initComponents();
	}
	
	private void initComponents() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				ATM.getInstance().getMediator().showInit();
			}
		});
		setBackground(new Color(51, 153, 204));
		setTitle("Error");
    	getContentPane().setBackground(new Color(51, 153, 204));
		setBounds(100, 100, 450, 300);
        setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblErrorAlIngresar = new JLabel("Error Al Ingresar sus credenciales, intentelo nuevamente.");
		lblErrorAlIngresar.setBackground(new Color(51, 153, 204));
		lblErrorAlIngresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblErrorAlIngresar.setForeground(new Color(128, 0, 0));
		lblErrorAlIngresar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("Volver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ATM.getInstance().getMediator().showInit();
				setVisible(false);
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblErrorAlIngresar, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblErrorAlIngresar, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnNewButton))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
