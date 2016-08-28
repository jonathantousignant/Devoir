package nordiasoft.devoir.controller.communication;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ILabelProvider;

public class TreeViewerProviderCommunication {
	private IContentProvider contentProvider;
	private ILabelProvider labelProvider;

	public TreeViewerProviderCommunication(IContentProvider contentProvider, ILabelProvider labelProvider) {
		this.contentProvider = contentProvider;
		this.labelProvider = labelProvider;
	}

	public IContentProvider getContentProvider() {
		return contentProvider;
	}

	public ILabelProvider getLabelProvider() {
		return labelProvider;
	}
}
