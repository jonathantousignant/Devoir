package nordiasoft.devoir.view;

import java.util.Observable;
import java.util.Observer;

import nordiasoft.devoir.controller.communication.TreeViewerInputCommunication;
import nordiasoft.devoir.view.decouverte.DecouverteView;

public class MainView implements Observer {
	private DecouverteView decouverteView_ = new DecouverteView();

	public DecouverteView getDecouverteView() {
		return decouverteView_;
	}

	@Override
	public void update(Observable o, Object arg) {
		if (arg instanceof TreeViewerInputCommunication) {
			decouverteView_.showNamingServiceObjects(((TreeViewerInputCommunication) arg).getInput());
		}
	}

}
