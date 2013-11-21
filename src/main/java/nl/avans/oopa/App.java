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
		Input A = new Input(true);
		Input B = new Input(false);
		Node N = new NodeNor();
		Probe P = new Probe();
		A.addOutput(N);
		B.addOutput(N);
		N.addOutput(P);
		boolean result = P.getResult();
		if(result){
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		B.changeValue(false);
		result = P.getResult();
		if(result){
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}
}
