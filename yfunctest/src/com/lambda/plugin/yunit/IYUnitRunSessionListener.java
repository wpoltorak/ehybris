package com.lambda.plugin.yunit;

public interface IYUnitRunSessionListener {

	void sessionAdded(YUnitRunSession testRunSession);

	void sessionRemoved(YUnitRunSession testRunSession);

}
