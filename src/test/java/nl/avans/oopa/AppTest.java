package nl.avans.oopa;

import nl.avans.oopa.model.Factory;
import nl.avans.oopa.model.Node;
import nl.avans.oopa.model.gates.*;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testNor()
    {        
		Input A = new Input(true);
		Input B = new Input(false);
		Node N = new NodeNor();
		Probe P = new Probe();
		A.addOutput(N);
		B.addOutput(N);
		N.addOutput(P);
		boolean result = P.getResult();
		
		
		assertFalse(result);
		
		Input A2 = new Input(false);
		Input B2 = new Input(false);
		Node N2 = new NodeNor();
		Probe P2 = new Probe();
		A2.addOutput(N2);
		B2.addOutput(N2);
		N2.addOutput(P2);
		boolean result2 = P2.getResult();
		
		
		assertTrue(result2);
		
		Input A3 = new Input(false);
		Input B3 = new Input(true);
		Node N3 = new NodeNor();
		Probe P3 = new Probe();
		A3.addOutput(N3);
		B3.addOutput(N3);
		N3.addOutput(P3);
		boolean result3 = P3.getResult();
		
		
		assertFalse(result3);
    }
    
    public void testNot() {
		Input A = new Input(false);
		Input B = new Input(false);
		Node N = new NodeOr();
		Probe P = new Probe();
		A.addOutput(N);
		B.addOutput(N);
		N.addOutput(P);
		boolean result = P.getResult();
		
		assertFalse(result);
		
		Input A2 = new Input(true);
		Input B2 = new Input(true);
		Node N2 = new NodeOr();
		Probe P2 = new Probe();
		A2.addOutput(N2);
		B2.addOutput(N2);
		N2.addOutput(P2);
		boolean result2 = P2.getResult();
		
		assertTrue(result2);
		
		Input A3 = new Input(true);
		Input B3 = new Input(false);
		Node N3 = new NodeOr();
		Probe P3 = new Probe();
		A3.addOutput(N3);
		B3.addOutput(N3);
		N3.addOutput(P3);
		boolean result3 = P3.getResult();
		
		assertTrue(result3);
	}
    
    public void testAnd() {
		Input A = new Input(false);
		Input B = new Input(false);
		Node N = new NodeAnd();
		Probe P = new Probe();
		A.addOutput(N);
		B.addOutput(N);
		N.addOutput(P);
		boolean result = P.getResult();
		
		assertFalse(result);
		
		Input A1 = new Input(false);
		Input B1 = new Input(true);
		Node N1 = new NodeAnd();
		Probe P1 = new Probe();
		A1.addOutput(N1);
		B1.addOutput(N1);
		N1.addOutput(P1);
		boolean result1 = P1.getResult();
		
		assertFalse(result1);
		
		Input A3 = new Input(true);
		Input B3 = new Input(true);
		Node N3 = new NodeAnd();
		Probe P3 = new Probe();
		A3.addOutput(N3);
		B3.addOutput(N3);
		N3.addOutput(P3);
		boolean result3 = P3.getResult();
		
		assertTrue(result3);
    }
    
    public void testOr() {
		Input A = new Input(false);
		Input B = new Input(false);
		Node N = new NodeOr();
		Probe P = new Probe();
		A.addOutput(N);
		B.addOutput(N);
		N.addOutput(P);
		boolean result = P.getResult();
		
		assertFalse(result);
		
		Input A1 = new Input(false);
		Input B1 = new Input(true);
		Node N1 = new NodeOr();
		Probe P1 = new Probe();
		A1.addOutput(N1);
		B1.addOutput(N1);
		N1.addOutput(P1);
		boolean result1 = P1.getResult();
		
		assertTrue(result1);
		
		Input A3 = new Input(true);
		Input B3 = new Input(true);
		Node N3 = new NodeAnd();
		Probe P3 = new Probe();
		A3.addOutput(N3);
		B3.addOutput(N3);
		N3.addOutput(P3);
		boolean result3 = P3.getResult();
		
		assertTrue(result3);
    }
    
    public void testNand() {
		Input A = new Input(false);
		Input B = new Input(false);
		Node N = new NodeNand();
		Probe P = new Probe();
		A.addOutput(N);
		B.addOutput(N);
		N.addOutput(P);
		boolean result = P.getResult();
		
		assertTrue(result);
		
		Input A1 = new Input(false);
		Input B1 = new Input(true);
		Node N1 = new NodeNand();
		Probe P1 = new Probe();
		A1.addOutput(N1);
		B1.addOutput(N1);
		N1.addOutput(P1);
		boolean result1 = P1.getResult();
		
		assertTrue(result1);
		
		Input A3 = new Input(true);
		Input B3 = new Input(true);
		Node N3 = new NodeNand();
		Probe P3 = new Probe();
		A3.addOutput(N3);
		B3.addOutput(N3);
		N3.addOutput(P3);
		boolean result3 = P3.getResult();
		
		assertFalse(result3);
    }
    
    public void testXor() {
		Input A = new Input(false);
		Input B = new Input(false);
		Node N = new NodeXor();
		Probe P = new Probe();
		A.addOutput(N);
		B.addOutput(N);
		N.addOutput(P);
		boolean result = P.getResult();
		
		assertFalse(result);
		
		Input A1 = new Input(false);
		Input B1 = new Input(true);
		Node N1 = new NodeXor();
		Probe P1 = new Probe();
		A1.addOutput(N1);
		B1.addOutput(N1);
		N1.addOutput(P1);
		boolean result1 = P1.getResult();
		
		assertTrue(result1);
		
		Input A3 = new Input(true);
		Input B3 = new Input(true);
		Node N3 = new NodeXor();
		Probe P3 = new Probe();
		A3.addOutput(N3);
		B3.addOutput(N3);
		N3.addOutput(P3);
		boolean result3 = P3.getResult();
		
		assertFalse(result3);
    }
    
    public void testFactory() {
		
    	
		Node xor = Factory.create("AND");
		Node probe = Factory.create("PROBE");
		Node inA = Factory.create("INPUT_HIGH");
		Node inB = Factory.create("INPUT_HIGH");
		inA.addOutput(xor);
		inB.addOutput(xor);
		xor.addOutput(probe);
		
		assertTrue(probe.getResult());

    }
}
