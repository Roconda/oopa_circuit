package nl.avans.oopa.model.gates;

import java.util.ArrayList;

import nl.avans.oopa.model.Node;

public class Input extends Node{
	public Input(boolean value){
		super();
		setResult(value);
	}
	
	public void changeValue(boolean value){
		setResult(value);
	}

	@Override
	public boolean execute(ArrayList<Node> inputs) {
		//is never called in Input, but needs to be implemented
		return false;
	}
}
