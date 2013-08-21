import jstats.Statistic;


public class Model {
	private double bigN;
	private double smallN1;
	private double smallN2;
	private double k1;
	private double k2;
	private double x1;
	private double x2;
	private double probability;
	
	public void solveHyperGeomDist() {
		probability = Statistic.combination(k1, x1) * Statistic.combination(bigN-k1, smallN1-x1) / Statistic.combination(bigN, smallN1);
	}
	
	/**
	 * GETTERs and SETTERs
	 */
	public double getBigN() {
		return bigN;
	}

	public void setBigN(double bigN) {
		this.bigN = bigN;
	}

	public double getSmallN1() {
		return smallN1;
	}

	public void setSmallN1(double smallN1) {
		this.smallN1 = smallN1;
	}

	public double getSmallN2() {
		return smallN2;
	}

	public void setSmallN2(double smallN2) {
		this.smallN2 = smallN2;
	}

	public double getK1() {
		return k1;
	}

	public void setK1(double k1) {
		this.k1 = k1;
	}

	public double getK2() {
		return k2;
	}

	public void setK2(double k2) {
		this.k2 = k2;
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}
	
	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}
}
