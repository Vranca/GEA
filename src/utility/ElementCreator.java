package utility;


import algorithmElements.AlgorithmElement;
import algorithmElements.SymbolVisualStyle;

public  interface ElementCreator 
{
	 AlgorithmElement create();
	 AlgorithmElement create(SymbolVisualStyle defaultVisualStyle);
}