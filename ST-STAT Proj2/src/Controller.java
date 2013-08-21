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
		this.myView.addMenuItemAboutListener(new MenuItemAboutListener());
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
			
			myView.getTxtSmallN1().setText(null);
			myView.getTxtSmallN1().setBackground(Color.WHITE);
			
			myView.getTxtSmallN2().setText(null);
			myView.getTxtSmallN2().setBackground(Color.WHITE);
			
			myView.getTxtK1().setText(null);
			myView.getTxtK1().setBackground(Color.WHITE);
			
        	myView.getTxtK2().setText(null);
        	myView.getTxtK2().setBackground(Color.WHITE);
        	
        	myView.getTxtX1().setText(null);
        	myView.getTxtX1().setBackground(Color.WHITE);
        	
        	myView.getTxtX2().setText(null);
        	myView.getTxtX2().setBackground(Color.WHITE);
        	
        	System.out.println("Clear Fields");
		}
	}
	
	/**
	 * Listener for SPECIFICATIONS menu item.
	 * Displays the project specifications
	 */
	class MenuItemSpecsListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			System.out.println("View Specs");
		}
	}
	
	/**
	 * Listener for ABOUT menu item.
	 * Displays what this project is about
	 */
	class MenuItemAboutListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			System.out.println("About");
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
	        int index = pane.getSelectedIndex();
	        
	        System.out.println("selectedIndex = " + index);
	        
	        switch(index) {
	        case 0: // FIXED PARAMETERS
	        	myView.getTab1().add(myView.getInputPanel());
	        	myView.getTab1().add(myView.getContentPanel());
	        	myView.getTab1().add(myView.getAnswerPanel());
	        	myView.getTab1().add(myView.getProbDistPanel());
	        	
	        	myView.getTxtSmallN2().setEditable(false);
	        	myView.getTxtK2().setEditable(false);
	        	myView.getTxtX2().setEditable(false);
	        	
	        	myView.addBtnSolveListener(new SolveTab1Listener());
	        	break;
	        case 1: // RANGE OF 'x'
	        	myView.getTab2().add(myView.getInputPanel());
	        	myView.getTab2().add(myView.getContentPanel());
	        	myView.getTab2().add(myView.getAnswerPanel());
	        	myView.getTab2().add(myView.getProbDistPanel());
	        	
	        	myView.getTxtSmallN2().setEditable(false);
	        	myView.getTxtK2().setEditable(false);
	        	myView.getTxtX2().setEditable(true);
	        	
	        	myView.addBtnSolveListener(new SolveTab2Listener());
	        	break;
	        case 2: // 'n' INCREASES
	        	myView.getTab3().add(myView.getInputPanel());
	        	myView.getTab3().add(myView.getContentPanel());
	        	myView.getTab3().add(myView.getAnswerPanel());
	        	myView.getTab3().add(myView.getProbDistPanel());
	        	
	        	myView.getTxtSmallN2().setEditable(true);
	        	myView.getTxtK2().setEditable(false);
	        	myView.getTxtX2().setEditable(false);
	        	
	        	myView.addBtnSolveListener(new SolveTab3Listener());
	        	break;
	        case 3: // 'k' INCREASES
	        	myView.getTab4().add(myView.getInputPanel());
	        	myView.getTab4().add(myView.getContentPanel());
	        	myView.getTab4().add(myView.getAnswerPanel());
	        	myView.getTab4().add(myView.getProbDistPanel());
	        	
	        	myView.getTxtSmallN2().setEditable(false);
	        	myView.getTxtK2().setEditable(true);
	        	myView.getTxtX2().setEditable(false);
	        	
	        	myView.addBtnSolveListener(new SolveTab4Listener());
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
			myView.getTxtSmallN1().setBackground(Color.WHITE);
			myModel.setSmallN1(myView.getSmallN1());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtSmallN1().setBackground(Color.PINK);
			valid = false;
		}
		
		try {
			myView.getTxtK1().setBackground(Color.WHITE);
			myModel.setK1(myView.getK1());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtK1().setBackground(Color.PINK);
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
			if (myModel.getX1() <= myModel.getSmallN1() && myModel.getX1() <= myModel.getK1()) {
				valid = true;
			} else {
				JOptionPane.showMessageDialog(myView, "x <= n ; x <= k", "Error!", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
		}
		
		return valid;
	}
	
	/**
	 * Checks if input for the upper bound of n is valid
	 * @return true if field for upper bound of n is not empty and lower bound n <= upper bound n
	 */
	private boolean isInputN2Valid() {
		boolean valid = false;
		
		try {
			myView.getTxtSmallN2().setBackground(Color.WHITE);
			myModel.setSmallN2(myView.getSmallN2());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtSmallN2().setBackground(Color.PINK);
			valid = false;
		}
		
		if (valid) {
			if(myModel.getSmallN1() <= myModel.getSmallN2()) {
				valid = true;
			} else {
				JOptionPane.showMessageDialog(myView, "n1 <= n2", "Error!", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
		}
		
		return valid;
	}
	
	/**
	 * Checks if input for the upper bound of k is valid
	 * @return true if field for upper bound of k is not empty and lower bound k <= upper bound k
	 */
	private boolean isInputK2Valid() {
		boolean valid = false;
		
		try {
			myView.getTxtK2().setBackground(Color.WHITE);
			myModel.setK2(myView.getK2());
			valid = true;
		} catch (Exception ex) {
			myView.getTxtK2().setBackground(Color.PINK);
			valid = false;
		}
		
		if (valid) {		
			if(myModel.getK1() <= myModel.getK2()) {
				valid = true;
			} else {
				JOptionPane.showMessageDialog(myView, "k1 <= k2", "Error!", JOptionPane.ERROR_MESSAGE);
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
			if(myModel.getX1() <= myModel.getX2()) {
				valid = true;
			} else {
				JOptionPane.showMessageDialog(myView, "x1 <= x2", "Error!", JOptionPane.ERROR_MESSAGE);
				valid = false;
			}
		}
		
		return valid;
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
				System.out.println(isMainInputValid());
				myModel.solveHyperGeomDist();
				myView.setProbability(myModel.roundOff(myModel.getProbability()));
			}
			
			System.out.println("Solve: Tab 1");
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
				myView.setProbability(myModel.roundOff(myModel.getProbability()));
			}
			
			System.out.println("Solve: Tab 2");
		}	
	}
	
	/**
	 * Listener for Solve Button in TAB 3
	 */
	class SolveTab3Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			if(isMainInputValid() && isInputN2Valid()) {				
				//myModel.solveHyperGeomRangeX();
				myView.setProbability("N/A");
			}
			
			System.out.println("Solve: Tab 3");
		}	
	}
	
	/**
	 * Listener for Solve Button in TAB 4
	 */
	class SolveTab4Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			if(isMainInputValid() && isInputK2Valid()) {				
				//myModel.solveHyperGeomRangeX();
				myView.setProbability("N/A");
			}
			
			System.out.println("Solve: Tab 4");
		}	
	}
}
