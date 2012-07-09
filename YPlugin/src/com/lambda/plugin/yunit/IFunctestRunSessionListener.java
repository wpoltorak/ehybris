package com.lambda.plugin.yunit;

public interface IFunctestRunSessionListener {

	void sessionAdded(FunctestRunSession testRunSession);

	void sessionRemoved(FunctestRunSession testRunSession);

}
