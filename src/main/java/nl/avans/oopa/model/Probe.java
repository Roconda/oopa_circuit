package nl.avans.oopa.model;

public class Probe extends Node {

	public Probe() {
		super(1, 0);
	}
	
	@Override
	public void addInput(boolean input){
		result = input;
	}

}
