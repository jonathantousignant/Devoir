package nordiasoft.devoir.view.decouverte;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import nordiasoft.devoir.model.contentprovider.CorbaElementContentProvider;
import nordiasoft.devoir.model.corba.element.CorbaElement;
import nordiasoft.devoir.view.labelprovider.DecouverteLabelProvider;

public class DecouverteView extends ViewPart {
	private static TreeViewer viewer_;
	private CorbaElement corbaElement_;
	
	private final static String ID = "nordiasoft.devoir.view";

	@Override
	public void createPartControl(Composite parent) {
		viewer_ = new TreeViewer(parent);
		viewer_.setContentProvider(new CorbaElementContentProvider());
		viewer_.setLabelProvider(new DecouverteLabelProvider());
		viewer_.setSorter(new ViewerSorter());	
	}

	@Override
	public void setFocus() {
		viewer_.getControl().setFocus();
	}

	private void openDecouverteView() throws PartInitException {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(ID);
	}

	public void showNamingServiceObjects(CorbaElement corbaElement) {
		corbaElement_ = corbaElement;
		
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				try {
					openDecouverteView();
					
					viewer_.setInput(corbaElement_);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
