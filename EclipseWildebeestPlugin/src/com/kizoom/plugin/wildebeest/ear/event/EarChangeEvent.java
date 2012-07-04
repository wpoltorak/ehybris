package com.kizoom.plugin.wildebeest.ear.event;

import com.kizoom.plugin.wildebeest.ear.IEar;

public class EarChangeEvent implements IEarChangeEvent {

	private final IEar ear;

	private final int type;

	public EarChangeEvent(IEar ear, int type) {
		this.ear = ear;
		this.type = type;
	}

	public IEar getEar() {
		return ear;
	}

	public int getType() {
		return type;
	}

}
