package nordiasoft.devoir.view.decouverte;

import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonViewer;

import nordiasoft.devoir.model.corba.element.ContextCorbaElement;
import nordiasoft.devoir.model.corba.element.CorbaElement;

public class DecouverteView {
	private DecouverteCommonNavigator commonNavigator_;
	private CommonViewer commonViewer_;

	private void openDecouverteView() throws PartInitException {
		commonNavigator_ = (DecouverteCommonNavigator) PlatformUI.getWorkbench().getActiveWorkbenchWindow()
				.getActivePage().showView("nordiasoft.devoir.view");

		commonViewer_ = commonNavigator_.getCommonViewer();
	}

	public void showNamingServiceObjects(CorbaElement corbaElement) {
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				try {
					openDecouverteView();

					addCorbaElement(corbaElement, commonNavigator_.getRoot());
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void addCorbaElement(CorbaElement corbaElement, Object parent) {
		commonViewer_.add(parent, corbaElement);
		
		if (corbaElement instanceof ContextCorbaElement) {
			addContextCorbaElement((ContextCorbaElement) corbaElement);
		}
	}
	
	private void addContextCorbaElement(ContextCorbaElement contextCorbaElement) {
		for (CorbaElement corbaElement : contextCorbaElement.getCorbaElements()) {
			addCorbaElement(corbaElement, contextCorbaElement);
		}
	}
}
