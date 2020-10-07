package utility;

import algorithmElements.AlgorithmElement;
import algorithmElements.Annotation;
import algorithmElements.SymbolVisualStyle;
import algorithmElements.FlatVisualStyle;

public class AnnotationCreator implements ElementCreator
{

	@Override
	public AlgorithmElement create() {
		return new Annotation(new FlatVisualStyle());
	}

	@Override
	public AlgorithmElement create(SymbolVisualStyle defaultVisualStyle) {
		return new Annotation(new FlatVisualStyle(defaultVisualStyle));
	}
	
	

}
