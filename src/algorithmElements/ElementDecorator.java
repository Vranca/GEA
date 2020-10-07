/***********************************************************************
 * Module:  ElementDecorator.java
 * Author:  User
 * Purpose: Defines the Class ElementDecorator
 ***********************************************************************/

package algorithmElements;

public abstract class ElementDecorator implements AlgorithmElement
{
	protected AlgorithmElement algorithmElement = null;

	public final AlgorithmElement getAlgorithmElement()
	{
		return algorithmElement;
	}
	
	public final void setAlgorithmElement(AlgorithmElement algorithmElement)
	{
		this.algorithmElement = algorithmElement;
	}
	   
}