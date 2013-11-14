package nl.avans.oopa.model;

public class Node {
	
	protected boolean[] inputs;
	protected Node[] outputs;
	private int inputCounter = 0;
	private int outputCounter = 0;
	protected boolean result = false;
	
	public Node(int inputs, int outputs){
		this.inputs = new boolean[inputs];
		this.outputs = new Node[outputs];
	}
	
	public void addInput(boolean input){
		if (inputCounter < inputs.length){
			inputs[inputCounter] = input;
			inputCounter++;
			if(inputCounter == inputs.length){
				execute();
				distributeResult();
			}
		}
	}
	
	public void addOutput(Node node){
		if(outputCounter < outputs.length){
			outputs[outputCounter] = node;
			outputCounter++;
		}
	}
	
	protected void execute(){
		//The default node will always return true, just because...
		result = true;
	}
	
	protected void distributeResult(){
		for(int i = 0; i < outputs.length; i++){
			outputs[i].addInput(result);
		}
	}
	
	public boolean getResult(){
		return result;
	}
}
