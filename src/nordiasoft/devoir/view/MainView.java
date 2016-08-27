package nordiasoft.devoir.view;

import java.util.Observable;
import java.util.Observer;

import nordiasoft.devoir.model.corba.element.RootCorbaElement;
import nordiasoft.devoir.view.decouverte.DecouverteView;

public class MainView implements Observer {
	private DecouverteView decouverteView_ = new DecouverteView();

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof RootCorbaElement) {
			decouverteView_.showNamingServiceObjects((RootCorbaElement) arg);
		}
	}

}
