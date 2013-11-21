package nl.avans.oopa.model;

import java.util.ArrayList;

public class Probe extends Node {

	public Probe() {
		super();
	}
	
	@Override
	public boolean execute(ArrayList<Node> inputs){
		return inputs.get(0).getResult();
	}

}
