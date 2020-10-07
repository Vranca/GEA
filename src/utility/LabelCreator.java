package utility;

import algorithmElements.AlgorithmElement;
import algorithmElements.FlatVisualStyle;
import algorithmElements.SymbolVisualStyle;
import algorithmElements.TextLabel;

public class LabelCreator implements ElementCreator
{

	@Override
	public AlgorithmElement create() {
		// TODO Auto-generated method stub
		return new TextLabel(new FlatVisualStyle());
	}

	@Override
	public AlgorithmElement create(SymbolVisualStyle defaultVisualStyle) {
		// TODO Auto-generated method stub
		return new TextLabel(defaultVisualStyle);
	}

}
