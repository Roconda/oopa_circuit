package nl.avans.oopa.model.gates;

import nl.avans.oopa.model.Node;

public class NodeNand extends Node {
	
	public NodeNand() {
		super();
	}
	
	@Override
	protected void execute(){
		for(Node n : inputs){
			//if even one input is false, AND returns true (reverse of AND).
			if(!n.getResult()){
				result = !false;
				return;
			}
		}
		result = !true;
	}
}
