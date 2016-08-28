package nordiasoft.devoir.model.provider.label;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import nordiasoft.devoir.model.corba.element.ContextCorbaElement;
import nordiasoft.devoir.model.corba.element.CorbaElement;
import nordiasoft.devoir.model.corba.element.ObjectCorbaElement;

public class CorbaLabelProvider extends LabelProvider implements ILabelProvider {

	@Override
	public Image getImage(Object element) {
		Image image = null;
		if (element instanceof ContextCorbaElement) {
			image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FOLDER);
		} else if (element instanceof ObjectCorbaElement) {
			image = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
		}

		return image;
	}

	@Override
	public String getText(Object element) {
		String text = "";
		if (element instanceof CorbaElement) {
			text = ((CorbaElement) element).getName();
		}
		return text;
	}
}
