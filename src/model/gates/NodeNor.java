package model.gates;

import model.Node;

public class NodeNor extends Node {

	public NodeNor(int inputs, int outputs) {
		super(inputs, outputs);
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
