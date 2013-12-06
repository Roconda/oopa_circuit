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
		try{
			System.out.println("starting");
			Node xor = Factory.create("AND");
			Node probe = Factory.create("PROBE");
			Node inA = Factory.create("INPUT_HIGH");
			Node inB = Factory.create("INPUT_HIGH");
			inA.addOutput(xor);
			inB.addOutput(xor);
			xor.addOutput(probe);
			if(probe.getResult()){
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} catch(Exception e){
			System.out.println("whoops");
		}
	}
}
