package nl.avans.oopa.model.gates;

import java.util.ArrayList;

import nl.avans.oopa.model.Node;

public class Input extends Node{
	
	@SuppressWarnings("unused")
	static private Input highInput = new Input(true,"INPUT_HIGH");
	@SuppressWarnings("unused")
	static private Input lowInput = new Input(false,"INPUT_LOW");
	
	public Input(boolean value){
		super();
		setResult(value);
	}
	
	private Input(boolean value, String id){
		super(id);
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

	@Override
	public Node copy() {
		return new Input(this.getResult());
	}
}
