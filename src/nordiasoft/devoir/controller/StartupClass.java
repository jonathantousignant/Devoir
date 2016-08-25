package nordiasoft.devoir.controller;

import org.eclipse.ui.IStartup;

public class StartupClass implements IStartup {

	@Override
	public void earlyStartup() {
		new MainController();
	}

}

