package nl.avans.oopa.model.gates;

import nl.avans.oopa.model.Node;

public class NodeXor extends Node {
	
	public NodeXor(int inputs) {
		super(inputs);
	}
	
	@Override
	protected void execute(){
		boolean first = inputs[0];
		boolean allTheSame = false;
		for(int i = 1; i < inputs.length; i++){
			if(inputs[i] == first){
				allTheSame = true;
			} else {
				allTheSame = false;
			}
		}
		if(allTheSame){
			result = false;
		} else {
			result = true;
		}
	}
}
