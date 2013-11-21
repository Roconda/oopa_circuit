package nl.avans.oopa.model.gates;

import java.util.ArrayList;

import nl.avans.oopa.model.Node;

public class NodeNot extends Node {
	
	public NodeNot() {
		super();
	}
	
	@Override
	public boolean execute(ArrayList<Node> inputs){
		//not only takes one input, thus only looks at first entry in array.
		return !inputs.get(0).getResult();
	}
}
