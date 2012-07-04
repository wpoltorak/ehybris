package com.kizoom.plugin.wildebeest.ear.event;

import com.kizoom.plugin.wildebeest.ear.IEar;

public interface IEarChangeEvent {

	public static final int ADDED = 1;
	public static final int DELETED = 2;
	public static final int RENAMED = 4;

	IEar getEar();
	
	int getType();
}
