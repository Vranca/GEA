package utility;

import algorithmElements.AlgorithmElement;
import algorithmElements.PredefinedProcess;
import algorithmElements.SymbolVisualStyle;
import algorithmElements.FlatVisualStyle;

public class PredefinedProcessCreator implements ElementCreator
{

	@Override
	public AlgorithmElement create() {
		return new PredefinedProcess(new FlatVisualStyle());
	}

	@Override
	public AlgorithmElement create(SymbolVisualStyle defaultVisualStyle) {
		return new PredefinedProcess(new FlatVisualStyle(defaultVisualStyle));
	}

}
