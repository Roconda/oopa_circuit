package model;

public class Input {

	private boolean value;
	private Node[] outputs;
	private int outputCounter = 0;
	
	public Input(boolean value, int outputs){
		this.value = value;
		this.outputs = new Node[outputs];
	}
	
	public void addOutput(Node node){
		if(outputCounter < outputs.length){
			outputs[outputCounter] = node;
			outputCounter++;
		}
	}
	
	public void start(){
		for(int i = 0; i < outputs.length; i++){
			outputs[i].addInput(value);
		}
	}
}
