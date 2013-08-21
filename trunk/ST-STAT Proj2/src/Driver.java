
public class Driver {

	public static void main(String[] args) {
		View myView = new View();
		Model myModel = new Model();
		Controller myController = new Controller(myView, myModel);
	}
}
