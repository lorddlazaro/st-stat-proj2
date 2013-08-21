import java.awt.BorderLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;

public class InfoDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private String str;
	private String title;

	/**
	 * Dialog Constructor
	 */
	public InfoDialog(String str, String title) {
		this.str = str;
		this.title = title;
		initGUI();
	}
	
	private void initGUI() {
		setTitle(title);
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextArea txtAreaSpecs = new JTextArea();
			txtAreaSpecs.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
			txtAreaSpecs.setText(str);
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 414, 239);
			
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			
			txtAreaSpecs.setBounds(10, 10, 414, 207);
			txtAreaSpecs.setLineWrap(true);
			txtAreaSpecs.setEditable(false);
			txtAreaSpecs.setWrapStyleWord(true);
			txtAreaSpecs.setCaretPosition(0);
			scrollPane.setViewportView(txtAreaSpecs);
			
			contentPanel.add(scrollPane);
		}
	}

}
