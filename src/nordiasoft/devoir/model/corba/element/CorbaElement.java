package nordiasoft.devoir.model.corba.element;

public abstract class CorbaElement {
	protected String name_;
	private CorbaElement parent_;

	public CorbaElement(String name) {
		this.name_ = name;
		this.parent_ = this;
	}

	public CorbaElement(String name, CorbaElement parent) {
		this.name_ = name;
		this.parent_ = parent;
	}

	public String getName() {
		return name_;
	}

	public CorbaElement getParent() {
		return parent_;
	}

	@Override
	public abstract String toString();
}
