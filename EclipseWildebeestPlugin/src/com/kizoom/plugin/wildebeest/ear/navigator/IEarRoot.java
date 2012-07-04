package com.kizoom.plugin.wildebeest.ear.navigator;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IAdaptable;

import com.kizoom.plugin.wildebeest.ear.IEar;
import com.kizoom.plugin.wildebeest.ear.event.IEarChangeListener;

public interface IEarRoot extends IAdaptable {

	IEar[] getEars();

	IEar getEar(IProject project);

	boolean isEmpty();

	boolean containsEar(IProject project);

	void addEarChangeListener(IEarChangeListener listener);

	void removeEarChangeListener(IEarChangeListener listener);
}
