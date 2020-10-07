package utility;

import algorithmElements.AlgorithmElement;
import algorithmElements.SymbolVisualStyle;
import algorithmElements.Terminal;
import algorithmElements.FlatVisualStyle;

public class TerminalCreator implements ElementCreator
{

	@Override
	public AlgorithmElement create() {
		return new Terminal(new FlatVisualStyle());
	}

	@Override
	public AlgorithmElement create(SymbolVisualStyle defaultVisualStyle) {
		return new Terminal(new FlatVisualStyle(defaultVisualStyle));
	}

}
