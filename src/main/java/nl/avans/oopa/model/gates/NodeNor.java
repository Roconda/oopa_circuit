package nl.avans.oopa.model.gates;

import java.util.ArrayList;

import nl.avans.oopa.model.Node;

public class NodeNor extends Node {

	public NodeNor() {
		super();
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
}
