package Views;

import java.awt.SystemColor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import Controllers.NumericContainerController;

public class NumericContainerView extends JPanel {

	private static final long serialVersionUID = 1L;
	private NumericContainerController numericContainerController = new NumericContainerController(this);
	private NumericPadView numericPadView = new NumericPadView(numericContainerController);
	private NumericValueView numericValueView;
	private boolean visiblePass;
	
	public NumericContainerView(String title, boolean visiblePass) {
		setVisiblePass(visiblePass);
        initComponents(title);
        visibleComponent(visiblePass);
	}
	
	private void initComponents(String title) {
		setBackground(SystemColor.activeCaptionBorder);

		setNumericValueView(new NumericValueView(title, isVisiblePass()));
		getNumericValueView().setBackground(SystemColor.controlHighlight);
		
		numericPadView.setBackground(SystemColor.controlHighlight);
		
        GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(numericPadView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(getNumericValueView(), GroupLayout.DEFAULT_SIZE, 311, Short.MAX_VALUE))
        			.addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(getNumericValueView(), GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(numericPadView, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
        			.addContainerGap())
        );
        this.setLayout(layout);
    }

	public NumericValueView getNumericValueView() {
		return numericValueView;
	}

	public void setNumericValueView(NumericValueView numericValueView) {
		this.numericValueView = numericValueView;
	}
	
	private void visibleComponent(boolean visiblePass) {
		this.getNumericValueView().getjNumericTxt().setVisible(visiblePass);
		this.getNumericValueView().getTextField().setVisible(!visiblePass);
	}

	public boolean isVisiblePass() {
		return this.visiblePass;
	}

	public void setVisiblePass(boolean visiblePass) {
		this.visiblePass = visiblePass;
	}
}
