package nordiasoft.devoir.model.corba.element;

public class RootCorbaElement {
	private ContextCorbaElement contextCorbaElement_;

	public RootCorbaElement(ContextCorbaElement contextCorbaElement) {
		this.contextCorbaElement_ = contextCorbaElement;
	}

	public ContextCorbaElement getContextCorbaElement() {
		return contextCorbaElement_;
	}
}
