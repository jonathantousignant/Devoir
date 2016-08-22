package nordiasoft.devoir.model.launcher.delegate;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.LaunchConfigurationDelegate;

import nordiasoft.devoir.model.launcher.attributes.CORBALaunchConfigurationAttributes;

public class CORBALaunchConfiguration extends LaunchConfigurationDelegate {

	@Override
	public void launch(ILaunchConfiguration configuration, String mode, ILaunch launch, IProgressMonitor monitor)
			throws CoreException {
		String attribute = configuration.getAttribute(CORBALaunchConfigurationAttributes.CONSOLE_TEXT,
				"Jonathan says \"RUN!\"");
		System.out.println(attribute);

	}

}
