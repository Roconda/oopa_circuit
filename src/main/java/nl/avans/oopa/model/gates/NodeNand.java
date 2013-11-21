package nl.avans.oopa.model.gates;

import java.util.ArrayList;

import nl.avans.oopa.model.Node;

public class NodeNand extends Node {
	
	public NodeNand() {
		super();
	}
	
	@Override
	public boolean execute(ArrayList<Node> inputs){
		for(Node n : inputs){
			//if even one input is false, AND returns true (reverse of AND).
			if(!n.getResult()){
				return !false;
			}
		}
		return !true;
	}
}
