package utility;

import algorithmElements.AlgorithmElement;
import algorithmElements.Decision;
import algorithmElements.SymbolVisualStyle;
import algorithmElements.FlatVisualStyle;

public class DecisionCreator implements ElementCreator
{

	@Override
	public AlgorithmElement create() {
		return new Decision(new FlatVisualStyle());
	}

	@Override
	public AlgorithmElement create(SymbolVisualStyle defaultVisualStyle) {
		return new Decision(new FlatVisualStyle(defaultVisualStyle));
	}

}
