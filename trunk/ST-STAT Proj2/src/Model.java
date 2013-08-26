import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import jstats.Statistic;

/**
 * MODEL:
 * Handles all functionalities
 */
public class Model {
	private int bigN;
	private int smallN;
	private int k;
	private int x1;
	private int x2;
	private double probability = 0;
	private ArrayList<Double> probList;
	private JFreeChart graph;
	private DefaultCategoryDataset dataset;

	/**
	 * Rounds of value to 4 decimal places
	 * @param value - value to be rounded off
	 * @return value rounded off to 4 decimal places
	 */
	public double roundOff(double value) {
		return (double) Math.round(value * 10000) / 10000;
	}

	/**
	 * Solves for the probability using Hypergeometric Distribution given N, n, k, and x
	 */
	public void solveHyperGeomDist() {
		probability = 0;
		probability = Statistic.combination(k, x1) * Statistic.combination(bigN-k, smallN-x1) / Statistic.combination(bigN, smallN);
	}

	/**
	 * Solves for the probability using Hypergeometric Distribution given N, n, k, and a range of values for x.
	 */
	public void solveHyperGeomRangeX() {
		probability = 0;
		probList = new ArrayList<Double>();

		for(int i = x1; i <= x2; i++) {
			/*probability += Statistic.combination(k1, i) * Statistic.combination(bigN-k1, smallN1-i) / Statistic.combination(bigN, smallN1);
			probList.add(roundOff(probability));*/

			probList.add(roundOff(Statistic.combination(k, i) * Statistic.combination(bigN-k, smallN-i) / Statistic.combination(bigN, smallN)));
		}

		for (int i = 0; i < probList.size(); i++) {
			probability += probList.get(i);
		}
	}

	/**
	 * Builds the data set for the graph
	 */
	public void createDataSet() {
		dataset = new DefaultCategoryDataset();
		int j = 0;
		for(int i = x1; i <= x2; i++) {
			//dataset.setValue(probList.get(j), Double.toString(probList.get(j)), Integer.toString(i));
			dataset.setValue(probList.get(j), "Probability", Integer.toString(i));
			j++;
		}
	}

	/**
	 * Creates the graph
	 * @param graphTitle - the title for the graph
	 */
	public void createGraph(String graphTitle) {
		graph = ChartFactory.createBarChart(graphTitle, "x", "Probability", dataset, PlotOrientation.VERTICAL, false, true, false);
	}

	/**
	 * Builds the dataset and creates the graph
	 * @param title - the title for the graph
	 */
	public void readyGraph(String title) {
		createDataSet();
		createGraph(title);
	}

	/*
	 * GETTERs and SETTERs
	 */

	public int getBigN() {
		return bigN;
	}

	public void setBigN(int bigN) {
		this.bigN = bigN;
	}

	public int getSmallN1() {
		return smallN;
	}

	public void setSmallN1(int smallN1) {
		this.smallN = smallN1;
	}

	public int getK1() {
		return k;
	}

	public void setK1(int k1) {
		this.k = k1;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}

	/*public JFreeChart getGraph() {
		return graph;
	}*/
	
	public ChartPanel getGraph() {
		return new ChartPanel(graph);
	}
	
	public ArrayList<Double> getProbList() {
		return probList;
	}
}
