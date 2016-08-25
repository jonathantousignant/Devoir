package nordiasoft.devoir.model.launcher;

import java.util.Observer;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;

import nordiasoft.devoir.controller.attributes.CorbaLaunchConfigurationAttributes;
import nordiasoft.devoir.model.util.MyObservable;

public class CorbaLaunchConfiguration extends LaunchConfigurationDelegate {
	private static MyObservable observable = new MyObservable();
	
	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		observable.setChanged();
		observable.notifyObservers(getORBInitialReferenceAttribut(configuration));
	}
	
	private String getORBInitialReferenceAttribut(ILaunchConfiguration configuration) throws CoreException {
		return configuration.getAttribute(CorbaLaunchConfigurationAttributes.ORB_INITIAL_REFERENCE, "");
	}
	
	public static void addObserver(Observer observer) {
		observable.addObserver(observer);
	}

}
