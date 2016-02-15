import java.awt.*;
import java.awt.event.*;

import javax.swing.AbstractAction;
import javax.swing.JButton;

public class UserInterface extends Frame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private TextField textField;

	public void setTextField(String textField) {
		this.textField.setText(textField);
		;
	}

	public UserInterface() {

		super.setLayout(new GridLayout(0, 1));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) (screenSize.getWidth() / 2.3) + 100;
		int y = 100;

		super.setLocation(x, y);

		textField = new TextField("Starting", 40);
		textField.setEditable(false);
		add(textField);

		JButton btnEnd = new JButton(new AbstractAction("end") {

			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(ABORT);
			}
		});

		add(btnEnd);

		setTitle("Monitor screen changes");
		setSize(550, 100);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

}