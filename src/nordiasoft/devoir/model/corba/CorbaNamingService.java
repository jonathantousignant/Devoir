package nordiasoft.devoir.model.corba;

import java.util.Observable;
import java.util.Observer;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.Binding;
import org.omg.CosNaming.BindingHolder;
import org.omg.CosNaming.BindingIterator;
import org.omg.CosNaming.BindingIteratorHolder;
import org.omg.CosNaming.BindingListHolder;
import org.omg.CosNaming.BindingType;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import nordiasoft.devoir.model.corba.element.ContextCorbaElement;
import nordiasoft.devoir.model.corba.element.CorbaElement;
import nordiasoft.devoir.model.corba.element.ObjectCorbaElement;
import nordiasoft.devoir.model.corba.element.RootCorbaElement;

public class CorbaNamingService extends Observable implements Observer {

	private NamingContextExt getNamingService(String args[]) {
		ORB orb = ORB.init(args, null);

		org.omg.CORBA.Object objRef = orb.string_to_object(args[0]);
		return NamingContextExtHelper.narrow(objRef);
	}

	private void getNamingServiceObjects(String args[]) {
		try {
			setChanged();
			
			notifyObservers(exploreNamingService("Service de nom", getNamingService(args)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private CorbaElement exploreNamingService(String rootName, NamingContext context)
			throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {
		RootCorbaElement rootCorbaElement = new RootCorbaElement(rootName);
		
		exploreNamingService(rootName, context, rootCorbaElement, 0);
		
		return rootCorbaElement;
	}
	
	private CorbaElement exploreNamingService(String contextName, NamingContext context, ContextCorbaElement parent, int treeDepth)
			throws InvalidName, NotFound, CannotProceed, org.omg.CosNaming.NamingContextPackage.InvalidName {

		ContextCorbaElement contextCorbaElement = new ContextCorbaElement(contextName, parent);

		BindingListHolder blh = new BindingListHolder();
		BindingIteratorHolder bih = new BindingIteratorHolder();

		context.list(0, blh, bih);

		BindingIterator bit = bih.value;

		boolean remains = true;
		
		while (remains) {
			BindingHolder biholder = new BindingHolder();
			
			remains = bit.next_one(biholder);
			
			Binding binding = biholder.value;

			NameComponent[] name = binding.binding_name;

			if (binding.binding_type == BindingType.ncontext) {
				NamingContext tmpContext = NamingContextHelper.narrow(context.resolve(binding.binding_name));
				contextCorbaElement.addCorbaElement(exploreNamingService(name[0].id, tmpContext, contextCorbaElement, treeDepth + 1));
			} else {
				if (name.length == 1) {
					contextCorbaElement.addCorbaElement(new ObjectCorbaElement(name[0].id, contextCorbaElement));
				}
			}
		}

		return contextCorbaElement;
	}

	private String[] getArgs(Object arg) {
		String args[] = new String[1];
		args[0] = (String) arg;

		return args;
	}

	@Override
	public void update(Observable o, Object arg) {
		getNamingServiceObjects(getArgs(arg));
	}
}
