package nl.avans.oopa.model.gates;

import java.util.ArrayList;

import nl.avans.oopa.model.Node;

public class NodeXor extends Node {
	
	@SuppressWarnings("unused")
	private static NodeXor nodeXor = new NodeXor("XOR");
	
	public NodeXor() {
		super();
	}
	
	private NodeXor(String id){
		super(id);
	}
	
	@Override
	public boolean execute(ArrayList<Node> nodes){
		boolean first = nodes.get(0).getResult();
		boolean allTheSame = false;
		for(int i = 1; i < nodes.size(); i++){
			allTheSame = (nodes.get(i).getResult() == first) ? true : false; 
			
			if(!allTheSame) return !allTheSame;
		}
		return true;		
	}

	@Override
	public Node copy() {
		return new NodeXor();
	}
}
