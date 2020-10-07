package utility;

import algorithmElements.AlgorithmElement;
import algorithmElements.OffPageConnector;
import algorithmElements.SymbolVisualStyle;
import algorithmElements.FlatVisualStyle;

public class OffPageConnectorCreator implements ElementCreator
{

	@Override
	public AlgorithmElement create() {
		return new OffPageConnector(new FlatVisualStyle());
	}

	@Override
	public AlgorithmElement create(SymbolVisualStyle defaultVisualStyle) {
		return new OffPageConnector(new FlatVisualStyle(defaultVisualStyle));
	}

}
