package nl.avans.oopa.model.gates;

import java.util.ArrayList;

import nl.avans.oopa.model.Node;

public class NodeNot extends Node {
	
	@SuppressWarnings("unused")
	private static NodeNot nodeNot = new NodeNot("NOT");
	
	public NodeNot() {
		super();
		setNeededInputs(1);
	}
	
	private NodeNot(String id){
		super(id);
	}
	
	@Override
	public boolean execute(ArrayList<Node> inputs){
		//not only takes one input, thus only looks at first entry in array.
		return !inputs.get(0).getResult();
	}

	@Override
	public Node copy() {
		return new NodeNot();
	}
}
