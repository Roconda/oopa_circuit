package model.gates;

import model.Node;

public class NodeNand extends Node {
	
	public NodeNand(int inputs, int outputs) {
		super(inputs, outputs);
	}
	
	@Override
	protected void execute(){
		for(int i = 0; i < inputs.length; i++){
			//if even one result is false, NAND returns true.
			if(!inputs[i]){
				result = true;
				return;
			}
		}
		result = false;
	}
}
