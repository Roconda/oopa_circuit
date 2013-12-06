package nl.avans.oopa.model.gates;

import java.util.ArrayList;

import nl.avans.oopa.model.Node;

public class NodeOr extends Node {
	
	@SuppressWarnings("unused")
	private static NodeOr nodeOr = new NodeOr("OR");
	
	public NodeOr() {
		super();
	}
	
	private NodeOr(String id){
		super(id);
	}
	
	@Override
	public boolean execute(ArrayList<Node> inputs){
		for(Node n : inputs){
			//if even one result is true, OR returns true.
			if(n.getResult()){
				return true;
			}
		}
		return false;
	}

	@Override
	public Node copy() {
		return new NodeOr();
	}
}
