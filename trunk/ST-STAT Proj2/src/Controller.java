import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Controller {
	private View myView;
	private Model myModel;
	
	public Controller(View view, Model model) {
		this.myView = view;
		this.myModel = model;
		
		this.myView.addTabSelectionListener(new tabSelectionListener());
	}
	
	/**
	 * TAB SELECTION LISTENER
	 */
	class tabSelectionListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			JTabbedPane pane = (JTabbedPane) e.getSource();
	        int index = pane.getSelectedIndex();
	        
	        System.out.println("selectedIndex = " + index);
	        
	        if(index == 0) {
	        	myView.getTab1().add(myView.getInputPanel());
	        	myView.getTab1().add(myView.getContentPanel());
	        	myView.getTab1().add(myView.getAnswerPanel());
	        	myView.getTab1().add(myView.getProbDistPanel());
	        	myView.addBtnSolveListener(new solveTab1Listener());
	        } else if(index == 1) {
	        	myView.getTab2().add(myView.getInputPanel());
	        	myView.getTab2().add(myView.getContentPanel());
	        	myView.getTab2().add(myView.getAnswerPanel());
	        	myView.getTab2().add(myView.getProbDistPanel());
	        } else if(index == 2) {
	        	myView.getTab3().add(myView.getInputPanel());
	        	myView.getTab3().add(myView.getContentPanel());
	        	myView.getTab3().add(myView.getAnswerPanel());
	        	myView.getTab3().add(myView.getProbDistPanel());
	        } else if(index == 3) {
	        	myView.getTab4().add(myView.getInputPanel());
	        	myView.getTab4().add(myView.getContentPanel());
	        	myView.getTab4().add(myView.getAnswerPanel());
	        	myView.getTab4().add(myView.getProbDistPanel());
	        }
		}
	}
	
	class solveTab1Listener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			try {
				myModel.setBigN(myView.getBigN());
				myModel.setSmallN1(myView.getSmallN1());
				myModel.setK1(myView.getK1());
				myModel.setX1(myView.getX1());
				
				myModel.solveHyperGeomDist();
				
				myView.setProbability(myModel.getProbability());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}	
	}
}
