package nl.avans.oopa.model.gates;

import java.util.ArrayList;

import nl.avans.oopa.model.Node;

public class NodeNor extends Node {
	
	@SuppressWarnings("unused")
	private static NodeNor nodeNor = new NodeNor("NOR");

	public NodeNor() {
		super();
	}
	
	private NodeNor(String id){
		super(id);
	}
	
	@Override
	public boolean execute(ArrayList<Node> inputs){
		for(Node n : inputs){
			//if even one result is true, OR returns false (reverse of OR).
			if(n.getResult()){
				return !true;
			}
		}
		return !false;
	}

	@Override
	public Node copy() {
		return new NodeNor();
	}
}
