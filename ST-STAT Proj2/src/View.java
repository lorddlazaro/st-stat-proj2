import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeListener;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JTable;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

/**
 * VIEW:
 * Handles all GUI related code
 */
public class View extends JFrame {
	private JPanel contentPane;
	
	private JMenuBar menuBar;
	private JMenu mnProject;
	private JMenuItem mntmClearFields;
	private JMenuItem mntmSpecifications;
	private JMenuItem mntmHelp;
	
	private JTabbedPane tabbedPane;
	private JPanel tab1;
	private JPanel tab2;
	private JPanel tab3;
	private JPanel tab4;
	
	private JPanel inputPanel;
	private JPanel graphPanel;
	private JPanel answerPanel;
	private JPanel probDistPanel;
	
	private JLabel lblBigN;
	private JTextField txtBigN;
	
	private JLabel lblSmallN;
	private JTextField txtSmallN1;
	private JLabel lblTo1;
	private JTextField txtSmallN2;
	
	private JLabel lblK;
	private JTextField txtK1;
	private JLabel lblTo2;
	private JTextField txtK2;
	
	private JLabel lblX;
	private JTextField txtX1;	
	private JLabel lblTo3;
	private JTextField txtX2;
	
	private JButton btnSolve;
	private JLabel lblProbability;
	
	private JTable tblProbDist;
	private JTabbedPane graphTabs;
	
	private int graphCtr = 1;

	/**
	 * View Constructor
	 */
	public View() {
		initGUI();
	}
	
	/**
	 * View content
	 */
	private void initGUI() {
		setResizable(false);
		/*
		 * FRAME PROPERTIES
		 */
		setTitle("Hypergeometric Probability Distribution");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		
		/*
		 * MENU
		 */
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnProject = new JMenu("Project");
		menuBar.add(mnProject);
		
		mntmClearFields = new JMenuItem("Clear Fields");
		mnProject.add(mntmClearFields);
		
		mntmSpecifications = new JMenuItem("Specifications");
		mnProject.add(mntmSpecifications);
		
		mntmHelp = new JMenuItem("Help");
		mnProject.add(mntmHelp);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		/*
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
		
		/*
		 * GRAPH PANEL
		 */
		graphPanel = new JPanel();
		graphPanel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		graphPanel.setBorder(new TitledBorder(new LineBorder(null, 1, true), "Graph", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		graphPanel.setBounds(206, 0, 553, 339);
		graphPanel.setLayout(null);
		
		// Display graph
		graphTabs = new JTabbedPane(JTabbedPane.TOP);
		graphTabs.setBounds(10, 21, 533, 307);
		graphPanel.add(graphTabs);
		
		/*
		 * ANSWER PANEL
		 */
		answerPanel = new JPanel();
		answerPanel.setBounds(10, 220, 197, 119);
		answerPanel.setLayout(null);
		answerPanel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		answerPanel.setBorder(new TitledBorder(new LineBorder(null, 1, true), "Answer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		// Answer
		lblProbability = new JLabel("ANSWER");
		lblProbability.setHorizontalAlignment(SwingConstants.CENTER);
		lblProbability.setFont(new Font("Segoe UI Symbol", Font.BOLD, 36));
		lblProbability.setBounds(10, 11, 177, 97);
		answerPanel.add(lblProbability);
		
		/*
		 * PROBABILITY DISTRIBUTION PANEL
		 */
		probDistPanel = new JPanel();
		probDistPanel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		probDistPanel.setBorder(new TitledBorder(new LineBorder(null, 1, true), "Probability Distribution Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		probDistPanel.setBounds(10, 340, 749, 138);
		probDistPanel.setLayout(null);
		
		tblProbDist = new JTable();
		tblProbDist.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		tblProbDist.setBounds(10, 21, 729, 106);
		probDistPanel.add(tblProbDist);
		
		/*
		 * TABBED PANES
		 */
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		contentPane.add(tabbedPane);		
		
		// TAB 1: FIXED PARAMETERS
		tab1 = new JPanel();
		tab1.setLayout(null);
		tabbedPane.addTab("Fixed Parameters", null, tab1, null);
		
		// TAB 2: RANGE OF 'x'
		tab2 = new JPanel();
		tab2.setLayout(null);
		tabbedPane.addTab("Range of 'x'", null, tab2, null);
		
		// TAB 3: 'n' INCREASES
		tab3 = new JPanel();
		tab3.setLayout(null);
		tabbedPane.addTab("'n' Increases", null, tab3, null);
		
		// TAB 4: 'k' INCREASES
		tab4 = new JPanel();
		tab4.setLayout(null);
		tabbedPane.addTab("'k' Increases", null, tab4, null);
		
		// DELETE THIS AFTER
		tab1.add(inputPanel);		
		tab1.add(graphPanel);
		tab1.add(answerPanel);
		tab1.add(probDistPanel);
	}	
	
	/*
	 * MENU ITEM AddListener METHODS
	 */

	/**
	 * Adds an action listener to the CLEAR FIELDS menu item
	 * @param listener - Action listener for CLEAR FIELDS menu item
	 */
	public void addMenuItemClearFieldsListener(ActionListener listener) {
		mntmClearFields.addActionListener(listener);
	}
	
	/**
	 * Adds an action listener to the SPECIFICATIONS menu item
	 * @param listener - Action listener for SPECIFICATIONS menu item
	 */
	public void addMenuItemSpecificationsListener(ActionListener listener) {
		mntmSpecifications.addActionListener(listener);
	}
	
	/**
	 * Adds an action listener to the ABOUT menu item
	 * @param listener - Action listener for ABOUT menu item
	 */
	public void addMenuItemHelpListener(ActionListener listener) {
		mntmHelp.addActionListener(listener);
	}
	
	/*
	 * TAB SELECTION AddListener METHOD
	 */
	
	/**
	 * Adds a change listener to the TABBED PANE
	 * @param listener - Change listener for the TABBED PANE
	 */
	public void addTabSelectionListener(ChangeListener listener) {
		tabbedPane.addChangeListener(listener);
	}
	
	/*
	 * SOLVE BUTTON AddListener METHOD
	 */
	
	/**
	 * Removes the all the current action listeners first before adding an action listener to the SOLVE BUTTON
	 * @param listener - Action listener for the SOLVE BUTTON
	 */
	public void addBtnSolveListener(ActionListener listener) {
		ActionListener[] list = btnSolve.getActionListeners();
		for(int i = 0; i < list.length; i++) {
			btnSolve.removeActionListener(list[i]);
		}
		
		btnSolve.addActionListener(listener);
	}
	
	/*
	 * DISPLAY RESULTs
	 */
	
	/**
	 * Sets the lblProbability to the computed probability
	 * @param probability - value to be set in lblProbability
	 */
	public void setProbability(double probability) {		
		lblProbability.setText(Double.toString(probability));
	}
	
	/**
	 * Sets the lblProbability to message
	 * @param str - message to be displayed
	 */
	public void setProbability(String str) {		
		lblProbability.setText(str);
	}
	
	/**
	 * Draws the graph to the UI
	 * @param graph - graph to be drawn
	 */
	public void drawGraph(JFreeChart graph) {
		graphTabs.addTab("Graph_"+graphCtr, null, new ChartPanel(graph), null);
		graphTabs.setSelectedIndex(graphCtr-1);
		graphCtr++;
	}
	
	/*
	 * GET INPUTS
	 */

	/**
	 * @return input value for N
	 */
	public int getBigN() {
		return Integer.parseInt(txtBigN.getText());
	}
	
	/**
	 * @return input value for lower bound n
	 */
	public int getSmallN1() {
		return Integer.parseInt(txtSmallN1.getText());
	}
	
	/**
	 * @return input value for upper bound n
	 */
	public int getSmallN2() {
		return Integer.parseInt(txtSmallN2.getText());
	}
	
	/**
	 * @return input value for lower bound k
	 */
	public int getK1() {
		return Integer.parseInt(txtK1.getText());
	}
	
	/**
	 * @return input value for upper bound k
	 */
	public int getK2() {
		return Integer.parseInt(txtK2.getText());
	}
	
	/**
	 * @return input value for lower bound x
	 */
	public int getX1() {
		return Integer.parseInt(txtX1.getText());
	}
	
	/**
	 * @return input value for upper bound x
	 */
	public int getX2() {
		return Integer.parseInt(txtX2.getText());
	}
	
	/*
	 * GET COMPONENTs
	 */
	
	public JPanel getTab1() {
		return tab1;
	}
	
	public JPanel getTab2() {
		return tab2;
	}
	
	public JPanel getTab3() {
		return tab3;
	}
	
	public JPanel getTab4() {
		return tab4;
	}
	
	public JPanel getInputPanel() {
		return inputPanel;
	}
	
	public JPanel getContentPanel() {
		return graphPanel;
	}
	
	public JPanel getAnswerPanel() {
		return answerPanel;
	}
	
	public JPanel getProbDistPanel() {
		return probDistPanel;
	}
	
	public JTextField getTxtBigN() {
		return txtBigN;
	}
	
	public JTextField getTxtSmallN1() {
		return txtSmallN1;
	}
	
	public JTextField getTxtSmallN2() {
		return txtSmallN2;
	}
	
	public JTextField getTxtK1() {
		return txtK1;
	}
	
	public JTextField getTxtK2() {
		return txtK2;
	}
	
	public JTextField getTxtX1() {
		return txtX1;
	}
	
	public JTextField getTxtX2() {
		return txtX2;
	}
}
