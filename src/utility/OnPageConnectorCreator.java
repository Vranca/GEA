package utility;

import algorithmElements.AlgorithmElement;
import algorithmElements.OnPageConnector;
import algorithmElements.SymbolVisualStyle;
import algorithmElements.FlatVisualStyle;

public class OnPageConnectorCreator implements ElementCreator
{

	@Override
	public AlgorithmElement create() {
		return new OnPageConnector(new FlatVisualStyle());
	}

	@Override
	public AlgorithmElement create(SymbolVisualStyle defaultVisualStyle) {
		return new OnPageConnector(new FlatVisualStyle(defaultVisualStyle));
	}
	
}
