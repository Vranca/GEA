package tests;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import algorithmElements.AlgorithmElement;
import algorithmElements.FlatVisualStyle;
import algorithmElements.Terminal;
import models.WorkspaceModel;

public class getIdTest
{

	@Test
	public void test() {
	
		int id1 = 4;
		int id2 = 2;
		int id3 = 1;
		int id4 = 3;
		int id5 = 5;		
		int incorectId = 1;
		
		WorkspaceModel model = new WorkspaceModel();
		java.util.List<AlgorithmElement> algorithmElements = new Vector<AlgorithmElement>();
		algorithmElements.add(new Terminal(new FlatVisualStyle()));
		algorithmElements.add(new Terminal(new FlatVisualStyle()));
		algorithmElements.add(new Terminal(new FlatVisualStyle()));
		algorithmElements.add(new Terminal(new FlatVisualStyle()));
		algorithmElements.add(new Terminal(new FlatVisualStyle()));
		
		model.setAlgorithmElements(algorithmElements);
		
		
	
		
	
		model.removeAlgorithmElements(algorithmElements.get(2));
		
		
		incorectId = model.getId();
		
		Boolean isCorrectId1 = id1 == incorectId;
		Boolean isCorrectId2 = id2 == incorectId;
		Boolean isCorrectId3 = id3 == incorectId;
		Boolean isCorrectId4 = id4 == incorectId;
		Boolean isCorrectId5 = id5 == incorectId;
		
		assertFalse(isCorrectId1);
		assertFalse(isCorrectId2);
		assertFalse(isCorrectId3);
		assertTrue(isCorrectId4);
		assertFalse(isCorrectId5);
		
	}

}
