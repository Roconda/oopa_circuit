package nl.avans.oopa.model.gates;

import nl.avans.oopa.model.Node;

public class NodeNand extends Node {
	
	public NodeNand(int inputs) {
		super(inputs);
	}
	
	@Override
	protected void execute(){
		for(int i = 0; i < inputs.length; i++){
			//if even one input is false, NAND returns true.
			if(!inputs[i]){
				result = true;
				return;
			}
		}
		result = false;
	}
}
