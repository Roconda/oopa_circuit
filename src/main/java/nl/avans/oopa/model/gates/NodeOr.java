package nl.avans.oopa.model.gates;

import nl.avans.oopa.model.Node;

public class NodeOr extends Node {
	
	public NodeOr() {
		super();
	}
	
	@Override
	protected void execute(){
		for(Node n : inputs){
			//if even one result is true, OR returns true.
			if(n.getResult()){
				result = true;
				return;
			}
		}
		result = false;
	}
}
