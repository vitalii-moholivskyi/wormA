package com.worm.controller;

import com.worm.controller.GUIConstants.states;
import com.worm.gui.MainFrame;
import com.worm.listeners.GetCashAction;
import com.worm.listeners.LoginAction;
import com.worm.model.User;

public class MainController {

	public MainController() {
		mainframe = MainFrame.getMainFrameInstance();
//		atm = ATM.getInstance();

	}

	public static MainController getMainControllerInstance() {
		if (maincontroller == null) {
			maincontroller = new MainController();
		}
		return maincontroller;
	}

	public User getUser() {
		return this.user;
	}

	public MainFrame getMainFrame() {
		return MainController.mainframe;
	}

	public void setState(states default1) {
		switch (default1) {
		case DEFAULT:
			setDefaultState();
			break;
		case LOGIN:
			setLoginState();
			break;
		case MAIN_MENU:
			setMainMenuState();
			break;
		case GET_CASH:
			setGettingCashState();
			break;
		case BLOCKED:
			setBlockedState();
			break;
		default:
			break;
		}
	}

	@SuppressWarnings("unused")
	private states getState() {
		return this.STATE;
	}

	@SuppressWarnings("static-access")
	private void setDefaultState() {
		this.mainframe.getScreenPanel().getScreen().setLabelOnArea("<html><center>Welcome to ~WOrM ATM!<br>Insert card to begin.</center>");
		this.mainframe.getScreenPanel().getScreen().setLeftCaptions(GUIConstants.getDefaultLeftCaptions());
		this.mainframe.getScreenPanel().getScreen().setRightCaptions(GUIConstants.getDefaultRightCaptions());
		// this.mainframe.getScreenPanel().getScreen().setAllCaptionsVisibility(false);
		// this.mainframe.getScreenPanel().setButtonListener(false, 3, new
		// LoginAction());
	}

	private void setLoginState() {
		MainController.mainframe.getScreenPanel().getScreen().setLabelAndTextFieldOnArea("Enter your PIN here: ");
		MainController.mainframe.getScreenPanel().getScreen().setLeftCaptions(GUIConstants.getLoginLeftCaptions());
		MainController.mainframe.getScreenPanel().getScreen().setRightCaptions(GUIConstants.getLoginRightCaptions());
		MainController.mainframe.getScreenPanel().setButtonListener(false, 3, new LoginAction());
	}

	private void setMainMenuState() {
		MainController.mainframe.getScreenPanel().getScreen().setLabelOnArea(
				"<html><center>Welcome to our ATM!<br>Here you can administrate your cards.<br>Choose an action below you want to perform.<center>");
		MainController.mainframe.getScreenPanel().getScreen().setLeftCaptions(GUIConstants.getMainMenuLeftCaptions());
		MainController.mainframe.getScreenPanel().getScreen().setRightCaptions(GUIConstants.getMainMenuRightCaptions());
		return;
	}

	private void setGettingCashState() {

		MainController.mainframe.getScreenPanel().setButtonListener(false, 3, new GetCashAction());
	}

	private void setBlockedState() {
		MainController.mainframe.getScreenPanel().getScreen().setLabelOnArea(
				"<html><center>Sorry, your card is blocked!<br>If you want to renew your card<br>or you don't know the reason of this, <br> please, contact the bank.<center>");
	}

	private static MainFrame mainframe;

//	private ATM atm;

	private User user;

	private states STATE = states.DEFAULT;

	private static MainController maincontroller;
}
