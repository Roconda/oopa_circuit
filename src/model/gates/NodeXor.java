package model.gates;

import model.Node;

public class NodeXor extends Node {
	
	public NodeXor(int inputs, int outputs) {
		super(inputs, outputs);
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
