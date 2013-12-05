package nl.avans.oopa.model.gates;

import java.util.ArrayList;

import nl.avans.oopa.model.Node;

public class Probe extends Node {

	public Probe() {
		super();
	}
	
	@Override
	public boolean execute(ArrayList<Node> inputs){
		return inputs.get(0).getResult();
	}

}
