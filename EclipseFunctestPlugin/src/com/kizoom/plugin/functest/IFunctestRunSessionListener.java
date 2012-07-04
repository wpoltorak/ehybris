package com.kizoom.plugin.functest;

public interface IFunctestRunSessionListener {

	void sessionAdded(FunctestRunSession testRunSession);

	void sessionRemoved(FunctestRunSession testRunSession);

}
