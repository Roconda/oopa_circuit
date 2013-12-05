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
			Object node = Class.forName("nl.avans.oopa.model.gates.NodeOr");
			NodeOr or = (NodeOr) node;
		} catch(Exception e){
			System.out.println("whoops");
		}
	}
}
