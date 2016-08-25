package nordiasoft.devoir.controller;

import nordiasoft.devoir.model.MainModel;
import nordiasoft.devoir.view.MainView;

public class MainController {
	private MainModel mainModel_ = new MainModel();
	private MainView mainView_ = new MainView();
	
	public MainController() {
		mainModel_.getCorbaNamingService().addObserver(mainView_);
	}
}
