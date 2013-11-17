package nl.avans.oopa.model;

public class Input extends Node{
	
	public Input(boolean value){
		super();
		result = value;
	}
	
	public void addOutput(Node node){
		outputs.add(node);
		node.addInput(this);
		sendValue();
	}
	
	public void changeValue(boolean value){
		this.result = value;
		sendValue();
	}
	
	private void sendValue(){
		distributeResult();
	}
}
