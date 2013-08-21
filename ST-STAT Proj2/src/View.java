import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import java.awt.Font;
import java.awt.event.KeyEvent;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;


public class View extends JFrame {

	private JPanel contentPane;
	
	private JMenuBar menuBar;
	private JMenu mnProjSpecs;
	private JMenu mnHelp;
	
	private JTabbedPane tabbedPane;
	private JPanel tab1;
	private JPanel tab2;
	private JPanel tab3;
	private JPanel tab4;
	
	private JPanel inputPanel;
	private JPanel contentPanel;
	private JPanel answerPanel;
	private JPanel probDistPanel;
	
	private JLabel lblBigN;
	private JTextField txtBigN;
	
	private JLabel lblSmallN;
	private JTextField txtSmallN1;
	private JLabel lblTo1;
	private JTextField txtSmallN2;
	
	private JLabel lblK;
	private JLabel lblX;
	private JTextField txtK1;
	private JTextField txtX1;
	
	private JLabel lblTo2;
	private JTextField txtK2;
	private JLabel lblTo3;
	private JTextField txtX2;
	private JButton btnSolve;
	

	/**
	 * Create the frame.
	 */
	public View() {
		initGUI();
	}
	
	private void initGUI() {
		/**
		 * FRAME PROPERTIES
		 */
		setTitle("Hypergeometric Distribution");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		
		/**
		 * MENU
		 */
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnProjSpecs = new JMenu("Project Specifications");
		menuBar.add(mnProjSpecs);
		
		mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		/**
		 * INPUT PANEL
		 */
		inputPanel = new JPanel();
		inputPanel.setBorder(new TitledBorder(new LineBorder(null, 1, true), "Input", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		inputPanel.setBounds(10, 0, 197, 221);
		inputPanel.setLayout(null);
		
		// N: [input]
		lblBigN = new JLabel("N:");
		lblBigN.setHorizontalAlignment(SwingConstants.TRAILING);
		lblBigN.setBounds(10, 22, 25, 27);
		lblBigN.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		inputPanel.add(lblBigN);
		
		txtBigN = new JTextField();
		txtBigN.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		txtBigN.setHorizontalAlignment(SwingConstants.CENTER);
		txtBigN.setBounds(39, 22, 60, 27);
		inputPanel.add(txtBigN);
		txtBigN.setColumns(10);
		
		// n: [input n1] to [input n2]
		lblSmallN = new JLabel("n:");
		lblSmallN.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSmallN.setBounds(10, 60, 25, 27);
		lblSmallN.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		inputPanel.add(lblSmallN);
		
		txtSmallN1 = new JTextField();
		txtSmallN1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		txtSmallN1.setHorizontalAlignment(SwingConstants.CENTER);
		txtSmallN1.setBounds(39, 60, 60, 27);
		txtSmallN1.setColumns(10);
		inputPanel.add(txtSmallN1);
		
		lblTo1 = new JLabel("to");
		lblTo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblTo1.setBounds(98, 60, 25, 27);
		inputPanel.add(lblTo1);
		
		txtSmallN2 = new JTextField();
		txtSmallN2.setHorizontalAlignment(SwingConstants.CENTER);
		txtSmallN2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		txtSmallN2.setColumns(10);
		txtSmallN2.setBounds(122, 60, 60, 27);
		inputPanel.add(txtSmallN2);
		
		// k: [input k1] to [input k2]
		lblK = new JLabel("k:");
		lblK.setHorizontalAlignment(SwingConstants.TRAILING);
		lblK.setBounds(10, 98, 25, 27);
		lblK.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		inputPanel.add(lblK);
		
		txtK1 = new JTextField();
		txtK1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		txtK1.setHorizontalAlignment(SwingConstants.CENTER);
		txtK1.setColumns(10);
		txtK1.setBounds(39, 98, 60, 27);
		inputPanel.add(txtK1);
		
		lblTo2 = new JLabel("to");
		lblTo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblTo2.setBounds(98, 98, 25, 27);
		inputPanel.add(lblTo2);
		
		txtK2 = new JTextField();
		txtK2.setHorizontalAlignment(SwingConstants.CENTER);
		txtK2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		txtK2.setColumns(10);
		txtK2.setBounds(122, 98, 60, 27);
		inputPanel.add(txtK2);
		
		// x: [input x1] to [input x2]
		lblX = new JLabel("x:");
		lblX.setHorizontalAlignment(SwingConstants.TRAILING);
		lblX.setBounds(10, 136, 25, 27);
		lblX.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		inputPanel.add(lblX);
		
		txtX1 = new JTextField();
		txtX1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		txtX1.setHorizontalAlignment(SwingConstants.CENTER);
		txtX1.setColumns(10);
		txtX1.setBounds(39, 136, 60, 27);
		inputPanel.add(txtX1);
		
		lblTo3 = new JLabel("to");
		lblTo3.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo3.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 14));
		lblTo3.setBounds(98, 136, 25, 27);
		inputPanel.add(lblTo3);
		
		txtX2 = new JTextField();
		txtX2.setHorizontalAlignment(SwingConstants.CENTER);
		txtX2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		txtX2.setColumns(10);
		txtX2.setBounds(122, 136, 60, 27);
		inputPanel.add(txtX2);
		
		// SOLVE Button
		btnSolve = new JButton("Solve!");
		btnSolve.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		btnSolve.setBounds(10, 174, 172, 35);
		inputPanel.add(btnSolve);
		
		/**
		 * CONTENT PANEL
		 */
		contentPanel = new JPanel();
		contentPanel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		contentPanel.setBorder(new TitledBorder(new LineBorder(null, 1, true), "Content", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.setBounds(206, 0, 553, 339);
		contentPanel.setLayout(null);
		
		/**
		 * ANSWER PANEL
		 */
		answerPanel = new JPanel();
		answerPanel.setBounds(10, 220, 197, 119);
		answerPanel.setLayout(null);
		answerPanel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		answerPanel.setBorder(new TitledBorder(new LineBorder(null, 1, true), "Answer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		/**
		 * PROBABILITY DISTRIBUTION PANEL
		 */
		probDistPanel = new JPanel();
		probDistPanel.setLayout(null);
		probDistPanel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		probDistPanel.setBorder(new TitledBorder(new LineBorder(null, 1, true), "Probability Distribution Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		probDistPanel.setBounds(10, 340, 749, 138);
		
		/**
		 * TABBED PANES
		 */
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		tabbedPane.addChangeListener(new tabSelectionListener());
		contentPane.add(tabbedPane);
		
		/**
		 * TAB 1: FIXED PARAMETERS
		 */
		tab1 = new JPanel();
		tab1.setLayout(null);
		tabbedPane.addTab("Fixed Parameters", null, tab1, null);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
		
		/**
		 * TAB 2: RANGE OF 'x'
		 */
		tab2 = new JPanel();
		tab2.setLayout(null);
		tabbedPane.addTab("Range of 'x'", null, tab2, null);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		/**
		 * TAB 3: 'n' INCREASES
		 */
		tab3 = new JPanel();
		tab3.setLayout(null);
		tabbedPane.addTab("'n' Increases", null, tab3, null);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		
		/**
		 * TAB 4: 'k' INCREASES
		 */
		tab4 = new JPanel();
		tab4.setLayout(null);
		tabbedPane.addTab("'k' Increases", null, tab4, null);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
	}
	
	/**
	 * GETTERs and SETTERs
	 */
	
	class tabSelectionListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
	        int index = pane.getSelectedIndex();
	        
	        System.out.println("selectedIndex = " + index);
	        
	        if(index == 0) {
	        	tab1.add(inputPanel);		
	    		tab1.add(contentPanel);
	    		tab1.add(answerPanel);
	    		//tab1.add(probDistPanel);
	        } else if(index == 1) {
	        	tab2.add(inputPanel);		
	    		tab2.add(contentPanel);
	    		tab2.add(answerPanel);
	    		tab2.add(probDistPanel);
	        } else if(index == 2) {
	        	tab3.add(inputPanel);		
	    		tab3.add(contentPanel);
	    		//tab3.add(answerPanel);
	    		//tab3.add(probDistPanel);
	        } else if(index == 3) {
	        	tab4.add(inputPanel);		
	    		tab4.add(contentPanel);
	    		//tab4.add(answerPanel);
	    		//tab4.add(probDistPanel);
	        }
		}
	}
}