import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * CONTROLLER:
 * This links the VIEW and the MODEL
 */
public class Controller {
	private View myView;
	private Model myModel;
	
	private int tabIndex = 0;
	
	/**
	 * Controller Constructor
	 * @param view - GUI
	 * @param model - Functionalities
	 */
	public Controller(View view, Model model) {
		this.myView = view;
		this.myModel = model;
		
		this.myView.addMenuItemClearFieldsListener(new MenuItemClrFldsListener());
		this.myView.addMenuItemSpecificationsListener(new MenuItemSpecsListener());
		this.myView.addMenuItemHelpListener(new MenuItemHelpListener());
		this.myView.addTabSelectionListener(new TabSelectListener());
	}
	
	/*
	 * MENU ITEM LISTENERS
	 */
	
	/**
	 * Listener for CLEAR FIELDS menu item.
	 * Clears the fields
	 */
	class MenuItemClrFldsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			myView.getTxtBigN().setText(null);
			myView.getTxtBigN().setBackground(Color.WHITE);
			
			myView.getTxtSmallN().setText(null);
			myView.getTxtSmallN().setBackground(Color.WHITE);
			
			myView.getTxtK().setText(null);
			myView.getTxtK().setBackground(Color.WHITE);
        	
        	myView.getTxtX1().setText(null);
        	myView.getTxtX1().setBackground(Color.WHITE);
        	
        	myView.getTxtX2().setText(null);
        	myView.getTxtX2().setBackground(Color.WHITE);
		}
	}
	
	/**
	 * Listener for SPECIFICATIONS menu item.
	 * Displays the project specifications
	 */
	class MenuItemSpecsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			String str = "Each group is tasked to develop a software (in C or Java) that simulates a hypergeometric probability distribution. This program can:\r\n1. Compute for the probability given a set of input parameters\r\n2. Compute for the total probability for a range of values for random variable x\r\n3. Show the probability in tabular form for the random variable x\r\n4. Graph the probability distribution\r\n5. Show a simulation of the graph as n increases (given a fixed N and k), and as k increases (given a fixed N and n)";
			new InfoDialog(str, "View Specifications");
		}
	}
	
	/**
	 * Listener for HELP menu item.
	 * Displays helpful information on how to navigate the project
	 */
	class MenuItemHelpListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String str = "Hypergeometric Distribution\r\n\r\nProbability of selecting 'x' successes from the 'k' items labeled successes and 'n-k' failures from 'N-k' items labeled failures when a random sample of size 'n' is selected from 'N' items.\r\n - Random sample of size 'n' is selected without replacement from 'N' items\r\n - 'k' of the 'N' items may be classified as successes and 'N-k' are classified as failures\r\n - applied in acceptance sampling where lots of materials or parts are sampled in order to determine whether or not the entire lot is accepted\r\n\r\n------------------------------\r\nGiven:\r\nN = total items\r\nn = sample size \r\nk = total number of successes\r\nx = number of successes in sample size\r\n\r\nh(x; N, n, k) = combination(k, x) * combination(N-k, n-x) / combination(N, n)\r\n\r\n------------------------------\r\nFixed Parameters\r\n- Input N, n, k, x\r\n\r\n------------------------------\r\nRange of 'x'\r\n- Input N, n, k, lowerbound x, upperbound x\r\n\r\n------------------------------\r\n'n' Increases\r\n- Input N, lowerbound n, upperbound  n, k, x\r\n\r\n------------------------------\r\n'k' Increases\r\n- Input N, n, lowerbound k, upperbound  k, x";
			new InfoDialog(str, "Help");
		}
	}
	
	/*
	 * TAB SELECTION LISTENER
	 */
	
	/**
	 * Listener for TAB SELECTION
	 */
	class TabSelectListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
	        tabIndex = pane.getSelectedIndex();
	        	        
	        switch(tabIndex) {
	        case 0: // FIXED PARAMETERS
	        	myView.getTab1().add(myView.getInputPanel());
	        	myView.getTab1().add(myView.getContentPanel());
	        	myView.getTab1().add(myView.getAnswerPanel());
	        	myView.getTab1().add(myView.getProbDistPanel());
	
	        	myView.getTxtSmallN().setEditable(true);
	        	myView.getTxtK().setEditable(true);
	        	myView.getTxtX1().setEditable(true);
	        	myView.getTxtX2().setEditable(false);
	        	myView.getSldrSmallN().setEnabled(false);
	        	myView.getSldrK().setEnabled(false);
	        	
	        	myView.addBtnSolveListener(new SolveTab1Listener());
	        	myView.validate();
	        	break;
	        case 1: // RANGE OF 'x'
	        	myView.getTab2().add(myView.getInputPanel());
	        	myView.getTab2().add(myView.getContentPanel());
	        	myView.getTab2().add(myView.getAnswerPanel());
	        	myView.getTab2().add(myView.getProbDistPanel());
	        	
	        	myView.getTxtSmallN().setEditable(true);
	        	myView.getTxtK().setEditable(true);
	        	myView.getTxtX1().setEditable(true);
	        	myView.getTxtX2().setEditable(true);
	        	myView.getSldrSmallN().setEnabled(false);
	        	myView.getSldrK().setEnabled(false);
	        	
	        	myView.addBtnSolveListener(new SolveTab2Listener());
	        	myView.validate();
	        	break;
	        case 2: // 'n' INCREASES
	        	myView.getTab3().add(myView.getInputPanel());
	        	myView.getTab3().add(myView.getContentPanel());
	        	myView.getTab3().add(myView.getAnswerPanel());
	        	myView.getTab3().add(myView.getProbDistPanel());
	        	
	        	myView.getTxtSmallN().setEditable(false);
	        	myView.getTxtK().setEditable(true);
	        	myView.getTxtX1().setEditable(false);
	        	myView.getTxtX2().setEditable(false);
	        	myView.getSldrSmallN().setEnabled(true);
	        	myView.getSldrK().setEnabled(false);
	        	
	        	myView.addBtnSolveListener(new SolveTab3Listener());
	        	myView.validate();
	        	break;
	        case 3: // 'k' INCREASES
	        	myView.getTab4().add(myView.getInputPanel());
	        	myView.getTab4().add(myView.getContentPanel());
	        	myView.getTab4().add(myView.getAnswerPanel());
	        	myView.getTab4().add(myView.getProbDistPanel());
	        	
	        	myView.getTxtSmallN().setEditable(true);
	        	myView.getTxtK().setEditable(false);
	        	myView.getTxtX1().setEditable(false);
	        	myView.getTxtX2().setEditable(false);
	        	myView.getSldrSmallN().setEnabled(false);
	        	myView.getSldrK().setEnabled(true);
	        	
	        	myView.addBtnSolveListener(new SolveTab4Listener());
	        	myView.validate();
	        	break;
	        }
		}
	}
	
	/*
	 * INPUT ERROR CHECKING
	 */
	
	/**
	 * Checks if inputs for N, n, k, and x are valid.
	 * @return true if fields for N, n, k, and x are not empty and if x <= n and x <= k
	 */
	private boolean isMainInputValid() {
		boolean valid = false;
		
		try {
			myView.getTxtBigN().setBackground(Color.WHITE);
			myModel.setBigN(myView.getBigN());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtBigN().setBackground(Color.PINK);
			valid = false;
		}
		
		try {
			myView.getTxtSmallN().setBackground(Color.WHITE);
			myModel.setSmallN1(myView.getSmallN1());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtSmallN().setBackground(Color.PINK);
			valid = false;
		}
		
		try {
			myView.getTxtK().setBackground(Color.WHITE);
			myModel.setK1(myView.getK1());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtK().setBackground(Color.PINK);
			valid = false;
		}
		
		try {
			myView.getTxtX1().setBackground(Color.WHITE);
			myModel.setX1(myView.getX1());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtX1().setBackground(Color.PINK);
			valid = false;
		}
		
		if (valid) {
			String str = "";
			
			// sample size <= population size
			if (!(myModel.getSmallN1() <= myModel.getBigN()))
				str = str.concat("n <= N");
			
			// total number of success <= population size
			if (!(myModel.getK1() <= myModel.getBigN()))
				str = str.concat("\nk <= N");
				
			// success in sample size <= population size
			if (!(myModel.getX1() < myModel.getBigN()))
				str = str.concat("\nx <= N");
			
			// success in sample size <= sample size
			if (!(myModel.getX1() <= myModel.getSmallN1()))
				str = str.concat("\nx <= n");
			
			// success in sample size <= total number of success
			if (!(myModel.getX1() <= myModel.getK1()))
				str = str.concat("\nx <= k");
			
			if (str.isEmpty()) {
				valid = true;
			} else {
				JOptionPane.showMessageDialog(myView, str, "Error!", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
		}
		
		return valid;
	}

	/**
	 * Checks if input for the upper bound of x is valid
	 * @return true if field for upper bound of x is not empty and lower bound x <= upper bound x
	 */
	private boolean isInputX2Valid() {
		boolean valid = false;
		
		try {
			myView.getTxtX2().setBackground(Color.WHITE);
			myModel.setX2(myView.getX2());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtX2().setBackground(Color.PINK);
			valid = false;
		}
		
		if (valid) {
			String str = "";
			
			// lower bound x < upper bound x
			if (!(myModel.getX1() < myModel.getX2()))
				str = str.concat("x1 < x2");

			// success in sample size <= sample size
			if (!(myModel.getX2() <= myModel.getK1()))
				str = str.concat("\nx2 <= k");
			
			// success in sample size <= total number of success
			if (!(myModel.getX2() <= myModel.getSmallN1()))
					str = str.concat("\nx2 <= n");
			
			if(str.isEmpty()) {
				valid = true;
			} else {
				JOptionPane.showMessageDialog(myView, str, "Error!", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
		}
		
		return valid;
	}

	private boolean isRangeNInputValid() {
		boolean valid = false;
		
		try {
			myView.getTxtBigN().setBackground(Color.WHITE);
			myModel.setBigN(myView.getBigN());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtBigN().setBackground(Color.PINK);
			valid = false;
		}
		
		try {
			myView.getTxtK().setBackground(Color.WHITE);
			myModel.setK1(myView.getK1());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtK().setBackground(Color.PINK);
			valid = false;
		}
		
		try {
			myView.getTxtX1().setBackground(Color.WHITE);
			myModel.setX1(1);
			myView.getTxtX1().setText(Integer.toString(myModel.getX1()));
			valid = true;
		} catch (Exception ex) {
			myView.getTxtX1().setBackground(Color.PINK);
			valid = false;
		}
		
		try {
			myView.getTxtX2().setBackground(Color.WHITE);
			myModel.setX2(myModel.getK1());
			myView.getTxtX2().setText(Integer.toString(myModel.getX2()));
			valid = true;
		} catch (Exception ex) {
			myView.getTxtX1().setBackground(Color.PINK);
			valid = false;
		}
		
		myModel.setSmallN1(myModel.getX2());
		myView.getTxtSmallN().setText(Integer.toString(myModel.getSmallN1()));
		
		if (valid) {
			String str = "";
			
			if (!(myModel.getK1() <= myModel.getBigN()))
				str = str.concat("k <= N");
			
			if (str.isEmpty()) {
				valid = true;
			} else {
				JOptionPane.showMessageDialog(myView, str, "Error!", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
		}
		
		return valid;
	}
	
	private boolean isRangeKInputValid() {
		boolean valid = false;
		
		try {
			myView.getTxtBigN().setBackground(Color.WHITE);
			myModel.setBigN(myView.getBigN());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtBigN().setBackground(Color.PINK);
			valid = false;
		}
		
		
		try {
			myView.getTxtSmallN().setBackground(Color.WHITE);
			myModel.setSmallN1(myView.getSmallN1());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtSmallN().setBackground(Color.PINK);
			valid = false;
		}
		
		try {
			myView.getTxtX1().setBackground(Color.WHITE);
			myModel.setX1(1);
			myView.getTxtX1().setText(Integer.toString(myModel.getX1()));
			valid = true;
		} catch (Exception ex) {
			myView.getTxtX1().setBackground(Color.PINK);
			valid = false;
		}
		
		try {
			myView.getTxtX2().setBackground(Color.WHITE);
			myModel.setX2(myModel.getSmallN1());
			myView.getTxtX2().setText(Integer.toString(myModel.getX2()));
			valid = true;
		} catch (Exception ex) {
			myView.getTxtX1().setBackground(Color.PINK);
			valid = false;
		}
		
		myModel.setK1(myModel.getX2());
		myView.getTxtK().setText(Integer.toString(myModel.getK1()));
		
		if (valid) {
			String str = "";
			
			if (!(myModel.getSmallN1() <= myModel.getBigN()))
				str = str.concat("n <= N");
			
			if (str.isEmpty()) {
				valid = true;
			} else {
				JOptionPane.showMessageDialog(myView, str, "Error!", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
		}
		
		return valid;
	}
	
	/*
	 * THIS IS THE PART WHERE THE TABLE GETS POPULATED BY THE VALUES FROM THE RANDOM VARIABLE X.
	 */
	
	public void populateTheProbDistTable() {
		String[] xValues = new String[myModel.getProbList().size()];
		Object[][] probValues = new Object[2][myModel.getProbList().size()];
		int j = 0;
		
		for(int i = myModel.getX1(); i <= myModel.getX2(); i++) {
			xValues[j] = "x = " + i;
			j++;
		}
		
		for(int i = 0; i < myModel.getProbList().size(); i++) {
			probValues[0][i] = xValues[i];
			probValues[1][i] = myModel.getProbList().get(i);
		}
		
		myView.setTblProbDist(probValues, xValues);
	}
	
	/*
	 * SLIDER LISTENER
	 */
	class SliderNListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			myView.getTxtSmallN().setText(Integer.toString(myView.getSldrSmallN().getValue()));
			myModel.setSmallN1(myView.getSldrSmallN().getValue());
			
			myModel.solveHyperGeomRangeX();
			myModel.readyGraph("Range of Values for Random Variable 'x'");
			myView.setProbability(myModel.roundOff(myModel.getProbability()));
			myView.drawGraph(myModel.getGraph());
			
			populateTheProbDistTable();
		}
		
	}
	
	class SliderKListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			myView.getTxtK().setText(Integer.toString(myView.getSldrK().getValue()));
			myModel.setK1(myView.getSldrK().getValue());
			
			myModel.solveHyperGeomRangeX();
			myModel.readyGraph("Range of Values for Random Variable 'x'");
			myView.setProbability(myModel.roundOff(myModel.getProbability()));
			myView.drawGraph(myModel.getGraph());
			
			populateTheProbDistTable();
		}
		
	}
	
	/*
	 * SOLVE BUTTON LISTENER
	 */

	/**
	 * Listener for Solve Button in TAB 1
	 */
	class SolveTab1Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {	
			if(isMainInputValid()) {
				myModel.solveHyperGeomDist();
				myView.setProbability(myModel.roundOff(myModel.getProbability()));
			}
		}	
	}
	
	/**
	 * Listener for Solve Button in TAB 2
	 */
	class SolveTab2Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			if(isMainInputValid() && isInputX2Valid()) {				
				myModel.solveHyperGeomRangeX();
				myModel.readyGraph("Range of Values for Random Variable 'x'");
				myView.setProbability(myModel.roundOff(myModel.getProbability()));
				myView.drawGraph(myModel.getGraph());
				
				populateTheProbDistTable();
			}	
		}	
	}
	
	/**
	 * Listener for Solve Button in TAB 3
	 */
	class SolveTab3Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			if(isRangeNInputValid()) {			
				myView.addSldrNListener(new SliderNListener(), myModel.getK1(), myModel.getBigN());
			}		
		}	
	}
	
	/**
	 * Listener for Solve Button in TAB 4
	 */
	class SolveTab4Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(isRangeKInputValid()) {				
				myView.addSldrKListener(new SliderKListener(), myModel.getX2(), myModel.getBigN());
			}
		}	
	}
}
