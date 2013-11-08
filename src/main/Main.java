package main;
import model.Input;
import model.Node;
import model.Probe;
import model.gates.NodeAnd;
import model.gates.NodeNand;
import model.gates.NodeNor;
import model.gates.NodeNot;
import model.gates.NodeOr;
import model.gates.NodeXor;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Input A = new Input(false, 1);
		Input B = new Input(true, 1);
		Node N = new NodeXor(2, 1);
		Probe P = new Probe();
		A.addOutput(N);
		B.addOutput(N);
		N.addOutput(P);
		A.start();
		B.start();
		boolean result = P.getResult();
		if(result){
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

}
