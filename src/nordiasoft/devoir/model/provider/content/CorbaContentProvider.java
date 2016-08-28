package nordiasoft.devoir.model.provider.content;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import nordiasoft.devoir.model.corba.element.ContextCorbaElement;
import nordiasoft.devoir.model.corba.element.CorbaElement;
import nordiasoft.devoir.model.corba.element.RootCorbaElement;

public class CorbaContentProvider implements ITreeContentProvider {
	private static final Object[] EMPTY_ARRAY = new Object[0];

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object arg1, Object arg2) {
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		Object[] objects = EMPTY_ARRAY;

		if (parentElement instanceof ContextCorbaElement) {
			objects = ((ContextCorbaElement) parentElement).getCorbaElements().toArray();
		} else if (parentElement instanceof RootCorbaElement) {
			Object tmpObjects[] = { ((RootCorbaElement) parentElement).getContextCorbaElement() };

			objects = tmpObjects;
		}

		return objects;
	}

	@Override
	public Object[] getElements(Object element) {
		return getChildren(element);
	}

	@Override
	public Object getParent(Object element) {
		Object object = null;

		if (element instanceof CorbaElement) {
			object = ((CorbaElement) element).getParent();
		}

		return object;
	}

	@Override
	public boolean hasChildren(Object element) {
		return element instanceof ContextCorbaElement;
	}

}
