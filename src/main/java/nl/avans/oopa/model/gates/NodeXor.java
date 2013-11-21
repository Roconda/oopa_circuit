package nl.avans.oopa.model.gates;

import java.util.ArrayList;

import nl.avans.oopa.model.Node;

public class NodeXor extends Node {
	
	public NodeXor() {
		super();
	}
	
	@Override
	public boolean execute(ArrayList<Node> nodes){
		boolean first = inputs.get(0).getResult();
		boolean allTheSame = false;
		for(int i = 1; i < inputs.size(); i++){
			allTheSame = (inputs.get(i).getResult() == first) ? true : false; 
			
			if(!allTheSame) return !allTheSame;
		}
		return true;		
	}
}
