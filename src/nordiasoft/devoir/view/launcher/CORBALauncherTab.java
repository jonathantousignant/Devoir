package nordiasoft.devoir.view.launcher;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import nordiasoft.devoir.model.launcher.attributes.CORBALaunchConfigurationAttributes;

import org.eclipse.swt.widgets.Group;

public class CORBALauncherTab extends AbstractLaunchConfigurationTab {
	private Text text_;
	
	@Override
	public void createControl(Composite parent) {
	    
	    Composite comp = new Group(parent, SWT.BORDER);
	    setControl(comp);
	    
	    GridLayoutFactory.swtDefaults().numColumns(2).applyTo(comp);

	    Label label = new Label(comp, SWT.NONE);
	    label.setText("Console Text:");
	    GridDataFactory.swtDefaults().applyTo(label);

	    text_ = new Text(comp, SWT.BORDER);
	    text_.setMessage("Console Text");
	    GridDataFactory.fillDefaults().grab(true, false).applyTo(text_);
		
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
	    try {
	        String consoleText = configuration.getAttribute(CORBALaunchConfigurationAttributes.CONSOLE_TEXT,
	            "Simon says \"RUN!\"");
	        text_.setText(consoleText);
	      } catch (CoreException e) {
	        // ignore here
	      }
		
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
	    configuration.setAttribute(CORBALaunchConfigurationAttributes.CONSOLE_TEXT, text_.getText());
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "NordiaSoft CORBA lauch tab";
	}

}
