package utility;

import algorithmElements.AlgorithmElement;
import algorithmElements.Process;
import algorithmElements.SymbolVisualStyle;
import algorithmElements.FlatVisualStyle;

public class ProcessCreator implements ElementCreator
{

	@Override
	public AlgorithmElement create() {
		return new Process(new FlatVisualStyle());
	}

	@Override
	public AlgorithmElement create(SymbolVisualStyle defaultVisualStyle) {
		return new Process(new FlatVisualStyle(defaultVisualStyle));
	}

}
