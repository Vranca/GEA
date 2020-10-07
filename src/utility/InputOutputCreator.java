package utility;

import algorithmElements.AlgorithmElement;
import algorithmElements.InputOutput;
import algorithmElements.SymbolVisualStyle;
import algorithmElements.FlatVisualStyle;

public class InputOutputCreator implements ElementCreator
{

	@Override
	public AlgorithmElement create() {
		return new InputOutput(new FlatVisualStyle());
	}

	@Override
	public AlgorithmElement create(SymbolVisualStyle defaultVisualStyle) {
		return new InputOutput(new FlatVisualStyle(defaultVisualStyle));
	}

}
