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

import javax.swing.JSlider;

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
	
	private JLabel lblSmallN1;
	private JTextField txtSmallN;
	
	private JLabel lblK1;
	private JTextField txtK;
	
	private JLabel lblX;
	private JTextField txtX1;	
	private JLabel lblTo3;
	private JTextField txtX2;
	
	private JLabel lblK2;
	private JLabel lblSmallN2;
	private JSlider sldrSmallN;
	private JSlider sldrK;
	
	private JButton btnSolve;
	private JLabel lblProbability;
	
	private JTable tblProbDist;
	private JPanel graphImgPanel;

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
		inputPanel.setBounds(10, 0, 197, 300);
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
		lblSmallN1 = new JLabel("n:");
		lblSmallN1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSmallN1.setBounds(10, 60, 25, 27);
		lblSmallN1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		inputPanel.add(lblSmallN1);
		
		txtSmallN = new JTextField();
		txtSmallN.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		txtSmallN.setHorizontalAlignment(SwingConstants.CENTER);
		txtSmallN.setBounds(39, 60, 60, 27);
		txtSmallN.setColumns(10);
		inputPanel.add(txtSmallN);
		
		// k: [input k1] to [input k2]
		lblK1 = new JLabel("k:");
		lblK1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblK1.setBounds(10, 98, 25, 27);
		lblK1.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		inputPanel.add(lblK1);
		
		txtK = new JTextField();
		txtK.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		txtK.setHorizontalAlignment(SwingConstants.CENTER);
		txtK.setColumns(10);
		txtK.setBounds(39, 98, 60, 27);
		inputPanel.add(txtK);
		
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
		
		// slider for n
		lblSmallN2 = new JLabel("n:");
		lblSmallN2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblSmallN2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		lblSmallN2.setBounds(10, 169, 25, 27);
		inputPanel.add(lblSmallN2);
		
		sldrSmallN = new JSlider();
		sldrSmallN.setValue(0);
		sldrSmallN.setMinimum(0);
		sldrSmallN.setMaximum(0);
		sldrSmallN.setMinorTickSpacing(1);
		sldrSmallN.setSnapToTicks(true);
		sldrSmallN.setPaintTicks(true);
		sldrSmallN.setPaintLabels(true);
		sldrSmallN.setBounds(39, 174, 148, 26);
		inputPanel.add(sldrSmallN);
		
		// slider for k
		lblK2 = new JLabel("k:");
		lblK2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblK2.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		lblK2.setBounds(10, 207, 25, 27);
		inputPanel.add(lblK2);
			
		sldrK = new JSlider();
		sldrK.setValue(0);
		sldrK.setSnapToTicks(true);
		sldrK.setPaintTicks(true);
		sldrK.setPaintLabels(true);
		sldrK.setMinorTickSpacing(1);
		sldrK.setMinimum(0);
		sldrK.setMaximum(0);
		sldrK.setBounds(39, 208, 148, 26);
		inputPanel.add(sldrK);
		
		// SOLVE Button
		btnSolve = new JButton("Solve!");
		btnSolve.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		btnSolve.setBounds(10, 245, 177, 35);
		inputPanel.add(btnSolve);
		
		/*
		 * GRAPH PANEL
		 */
		graphPanel = new JPanel();
		graphPanel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		graphPanel.setBorder(new TitledBorder(new LineBorder(null, 1, true), "Graph", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		graphPanel.setBounds(206, 0, 553, 400);
		graphPanel.setLayout(null);
		
		// Display graph
		graphImgPanel = new JPanel();
		graphImgPanel.setBounds(10, 21, 533, 368);
		graphPanel.add(graphImgPanel);
		
		/*
		 * ANSWER PANEL
		 */
		answerPanel = new JPanel();
		answerPanel.setBounds(10, 301, 197, 99);
		answerPanel.setLayout(null);
		answerPanel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		answerPanel.setBorder(new TitledBorder(new LineBorder(null, 1, true), "Answer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		// Answer
		lblProbability = new JLabel("ANSWER");
		lblProbability.setHorizontalAlignment(SwingConstants.CENTER);
		lblProbability.setFont(new Font("Segoe UI Symbol", Font.BOLD, 36));
		lblProbability.setBounds(10, 11, 177, 77);
		answerPanel.add(lblProbability);
		
		/*
		 * PROBABILITY DISTRIBUTION PANEL
		 */
		probDistPanel = new JPanel();
		probDistPanel.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 16));
		probDistPanel.setBorder(new TitledBorder(new LineBorder(null, 1, true), "Probability Distribution Table", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		probDistPanel.setBounds(10, 404, 749, 84);
		probDistPanel.setLayout(null);
		
		tblProbDist = new JTable();
		tblProbDist.setRowSelectionAllowed(false);
		tblProbDist.setBounds(10, 21, 729, 52);
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
	 * SLIDER AddListener Method
	 */
	
	public void addSldrNListener(ChangeListener listener, int min, int max) {
		sldrSmallN.addChangeListener(listener);
		sldrSmallN.setMinimum(min);
		sldrSmallN.setMaximum(max);
		sldrSmallN.setValue(min);
	}
	
	public void addSldrKListener(ChangeListener listener, int min, int max) {
		sldrK.addChangeListener(listener);
		sldrK.setMinimum(min);
		sldrK.setMaximum(max);
		sldrK.setValue(min);
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
	public void drawGraph(ChartPanel graph) {
		graphPanel.removeAll();
		graph.setBounds(10, 21, 533, 368);
		graphPanel.add(graph);
		graphPanel.validate();
		validate();
	}
	
	public void setTblProbDist(Object[][] probValue, Object[] xValue) {
		tblProbDist = new JTable(probValue, xValue);
		tblProbDist.setBounds(10, 21, 729, 52);
		tblProbDist.setRowSelectionAllowed(false);
		probDistPanel.add(tblProbDist);
		validate();
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
		return Integer.parseInt(txtSmallN.getText());
	}
	
	/**
	 * @return input value for lower bound k
	 */
	public int getK1() {
		return Integer.parseInt(txtK.getText());
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
	
	public JTextField getTxtSmallN() {
		return txtSmallN;
	}
	
	public JTextField getTxtK() {
		return txtK;
	}
	
	public JTextField getTxtX1() {
		return txtX1;
	}
	
	public JTextField getTxtX2() {
		return txtX2;
	}
	
	public JTable getTblProbDist() {
		return tblProbDist;
	}
	
	public JSlider getSldrSmallN() {
		return sldrSmallN;
	}
	
	public JSlider getSldrK() {
		return sldrK;
	}
}
