package nl.avans.oopa.model.gates;

import nl.avans.oopa.model.Node;

public class NodeOr extends Node {
	
	public NodeOr(int inputs, int outputs) {
		super(inputs, outputs);
	}
	
	@Override
	protected void execute(){
		for(int i = 0; i < inputs.length; i++){
			//if even one result is true, OR returns true.
			if(inputs[i]){
				result = true;
				return;
			}
		}
		result = false;
	}
}
