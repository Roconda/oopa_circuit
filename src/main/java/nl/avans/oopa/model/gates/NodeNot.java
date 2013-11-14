package nl.avans.oopa.model.gates;

import nl.avans.oopa.model.Node;

public class NodeNot extends Node {
	
	public NodeNot() {
		super(1);
	}
	
	@Override
	protected void execute(){
		//not only takes one input, thus only looks at first entry in array.
		result = !inputs[0];
	}
}
