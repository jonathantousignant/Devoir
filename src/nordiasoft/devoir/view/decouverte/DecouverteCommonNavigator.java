package nordiasoft.devoir.view.decouverte;

import org.eclipse.ui.navigator.CommonNavigator;

public class DecouverteCommonNavigator extends CommonNavigator {
	private Object root;

	@Override
	protected Object getInitialInput() {
		return root = super.getInitialInput();
	}

	public Object getRoot() {
		return root;
	}
	
	
}
