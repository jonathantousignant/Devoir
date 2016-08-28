package nordiasoft.devoir.model.provider;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;

import nordiasoft.devoir.controller.communication.TreeViewerProviderCommunication;
import nordiasoft.devoir.model.provider.content.CorbaContentProvider;
import nordiasoft.devoir.model.provider.label.CorbaLabelProvider;

public class CorbaProvider {
	private IContentProvider contentProvider = new CorbaContentProvider();
	private ILabelProvider labelProvider = new CorbaLabelProvider();

	public TreeViewerProviderCommunication getTreeViewerProvider() {
		return new TreeViewerProviderCommunication(contentProvider, labelProvider);
	}
}
