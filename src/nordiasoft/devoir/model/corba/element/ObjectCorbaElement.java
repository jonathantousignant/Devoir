package nordiasoft.devoir.model.corba.element;

public class ObjectCorbaElement extends CorbaElement {

	public ObjectCorbaElement(String name, CorbaElement parent) {
		super(name, parent);
	}

	@Override
	public String toString() {
		return "Object ".concat(name_);
	}

}
