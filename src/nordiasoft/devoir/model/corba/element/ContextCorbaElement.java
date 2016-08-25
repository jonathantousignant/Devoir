package nordiasoft.devoir.model.corba.element;

import java.util.ArrayList;
import java.util.List;

public class ContextCorbaElement extends CorbaElement {
	private List<CorbaElement> corbaElements = new ArrayList<>();
	
	public ContextCorbaElement(String name, CorbaElement parent) {
		super(name, parent);
	}

	public void addCorbaElement(CorbaElement corbaElement) {
		corbaElements.add(corbaElement);
	}
	
	public List<CorbaElement> getCorbaElements() {
		return corbaElements;
	}

	@Override
	public String toString() {
		String string = "Context ".concat(name_);
		
		for (CorbaElement corbaElement : corbaElements) {
			string = string.concat(corbaElement.toString());
		}
		
		return string;
	}
}
