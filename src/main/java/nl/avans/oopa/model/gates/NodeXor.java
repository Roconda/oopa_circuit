package nl.avans.oopa.model.gates;

import nl.avans.oopa.model.Node;

public class NodeXor extends Node {
	
	public NodeXor() {
		super();
	}
	
	@Override
	protected void execute(){
		//needs more than one input to work
		if(inputs.size() <= 1){
			result = false;
			return;
		}
		
		boolean first = inputs.get(0).getResult();
		boolean allTheSame = false;
		for(int i = 1; i < inputs.size(); i++){
			if(inputs.get(i).getResult() == first){
				allTheSame = true;
			} else {
				allTheSame = false;
			}
			if(!allTheSame){
				result = true;
				return;
			}
		}
		result = true;		
	}
}
