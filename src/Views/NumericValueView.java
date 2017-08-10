package Views;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JTextField;

public class NumericValueView  extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel jLblDesc;
    private JPasswordField jNumericTxt;
    private JTextField textField;
    private boolean pass;
    public NumericValueView(String title, boolean pass) {
    	setPass(pass);
        initComponents(title);
    }
                
    private void initComponents(String title) {

        setjNumericTxt(new JPasswordField());
        setjLblDesc(new JLabel());
        getjLblDesc().setFont(new Font("Tahoma", Font.PLAIN, 18));

        getjNumericTxt().setEditable(false);

        getjLblDesc().setText(title);
        
        setTextField(new JTextField());
        getTextField().setEditable(false);
        getTextField().setColumns(10);

        GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(27)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jNumericTxt, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
        				.addComponent(jLblDesc)
        				.addComponent(getTextField()))
        			.addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(21)
        			.addComponent(jLblDesc)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jNumericTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(getTextField(), GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(15, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }

	public JLabel getjLblDesc() {
		return jLblDesc;
	}

	public void setjLblDesc(JLabel jLblDesc) {
		this.jLblDesc = jLblDesc;
	}

	public JPasswordField getjNumericTxt() {
		return jNumericTxt;
	}

	public void setjNumericTxt(JPasswordField jNumericTxt) {
		this.jNumericTxt = jNumericTxt;
	}

	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public boolean isPass() {
		return pass;
	}

	public void setPass(boolean pass) {
		this.pass = pass;
	}
}