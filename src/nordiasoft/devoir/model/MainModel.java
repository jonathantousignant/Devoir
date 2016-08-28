package nordiasoft.devoir.model;

import nordiasoft.devoir.model.corba.CorbaNamingService;
import nordiasoft.devoir.model.launcher.CorbaLaunchConfiguration;

public class MainModel {
	private CorbaNamingService corbaNamingService_ = new CorbaNamingService();

	public MainModel() {
		CorbaLaunchConfiguration.addObserver(corbaNamingService_);
	}

	public CorbaNamingService getCorbaNamingService() {
		return corbaNamingService_;
	}
}
