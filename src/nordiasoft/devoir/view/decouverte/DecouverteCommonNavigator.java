package nordiasoft.devoir.view.decouverte;

import org.eclipse.ui.navigator.CommonNavigator;

import nordiasoft.devoir.model.corba.element.RootCorbaElement;

public class DecouverteCommonNavigator extends CommonNavigator {
	private Object root;

	@Override
	protected Object getInitialInput() {
		return root = new RootCorbaElement("Naming Service");
	}

	public Object getRoot() {
		return root;
	}
	
	
}
