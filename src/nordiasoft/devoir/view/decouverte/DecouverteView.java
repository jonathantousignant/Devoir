package nordiasoft.devoir.view.decouverte;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

import nordiasoft.devoir.model.corba.element.CorbaElement;
import nordiasoft.devoir.model.corba.element.ObjectCorbaElement;

public class DecouverteView {
	private DecouverteCommonNavigator commonNavigator_;

	private void openDecouverteView() {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				try {
					commonNavigator_ = (DecouverteCommonNavigator) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
							.getActivePage().showView("nordiasoft.devoir.view.decouverte");
					
					show();
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void showNamingServiceObjects(CorbaElement corbaElement) {
		openDecouverteView();
	}
	
	private void show() {
		commonNavigator_.getCommonViewer().add(commonNavigator_.getRoot(), new ObjectCorbaElement("Test", null));
		commonNavigator_.getCommonViewer().refresh();
	}
}
