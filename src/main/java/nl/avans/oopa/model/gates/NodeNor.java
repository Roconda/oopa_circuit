package nl.avans.oopa.model.gates;

import nl.avans.oopa.model.Node;

public class NodeNor extends Node {

	public NodeNor(int inputs) {
		super(inputs);
	}
	
	@Override
	protected void execute(){
		for(int i = 0; i < inputs.length; i++){
			//if even one result is true, NOR returns false.
			if(inputs[i]){
				result = false;
				return;
			}
		}
		result = true;
	}
}
