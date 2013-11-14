package nl.avans.oopa;

import nl.avans.oopa.model.*;
import nl.avans.oopa.model.gates.*;

/**
 * Hello world!
 *
 */
public class App 
{
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
