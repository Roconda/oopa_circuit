package nl.avans.oopa.model.gates;

import java.util.ArrayList;

import nl.avans.oopa.model.Node;

public class Probe extends Node {
	
	@SuppressWarnings("unused")
	private static Probe probe = new Probe("PROBE");

	public Probe() {
		super();
		setNeededInputs(1);
	}
	
	private Probe(String id){
		super(id);
	}
	
	@Override
	public boolean execute(ArrayList<Node> inputs){
		return inputs.get(0).getResult();
	}

	@Override
	public Node copy() {
		return new Probe();
	}

}
