package com.kizoom.plugin.wildebeest.ear.navigator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.PlatformObject;

import com.kizoom.plugin.wildebeest.ear.Ear;
import com.kizoom.plugin.wildebeest.ear.IEar;
import com.kizoom.plugin.wildebeest.ear.event.EarChangeEvent;
import com.kizoom.plugin.wildebeest.ear.event.IEarChangeEvent;
import com.kizoom.plugin.wildebeest.ear.event.IEarChangeListener;

public class EarRoot extends PlatformObject implements IEarRoot {

	private final Map<String, IEar> ears = Collections
			.synchronizedMap(new HashMap<String, IEar>(16));

	private List<IEarChangeListener> listeners = new ArrayList<IEarChangeListener>();

	// protected final Set<ILifecycleListener> lifecycleListeners = new
	// HashSet<ILifecycleListener>(10);

	public EarRoot() {

	}

	public IEar[] getEars() {
		return ears.values().toArray(new IEar[ears.size()]);
	}

	public IEar getEar(IProject project) {
		return ears.get(project.getName());
	}

	public boolean isEmpty() {
		return ears.isEmpty();
	}

	public void addEarChangeListener(IEarChangeListener listener) {
		listeners.add(listener);
	}

	public void removeEarChangeListener(IEarChangeListener listener) {
		listeners.remove(listener);
	}

	private void notify(List<IEarChangeListener> listeners, final EarChangeEvent event) {
		for (final IEarChangeListener listener : listeners) {
			listener.earChanged(event);
//			SafeRunner.run(new ISafeRunnable() {
//				public void handleException(Throwable e) {
//					ExceptionHandler.log(e, "Invalid error occured");
//				}
//
//				public void run() throws Exception {
//					listener.earChanged(event);
//				}
//			});
		}
	}

	public IEar createEar(IProject project) {
		if (project == null)
			throw new IllegalArgumentException(
					"Cannot create ear for null project.");
		if (ears.containsKey(project.getName()))
			throw new IllegalArgumentException("Ear '" + project.getName()
					+ "' already exist.");
		Ear ear = new Ear(project, this);
		ears.put(ear.getName(), ear);
		notify(listeners, new EarChangeEvent(ear, IEarChangeEvent.ADDED));
		return ear;
	}

	public boolean containsEar(IProject project) {
		return ears.containsKey(project.getName());
	}

	public void deleteEar(IProject project) {
		IEar ear = ears.remove(project.getName());
		notify(listeners, new EarChangeEvent(ear, IEarChangeEvent.DELETED));
	}

	public void renameEar(IProject project) {
		String key = null;
		for (Entry<String, IEar> entry : ears.entrySet()) {
			if (entry.getValue().getProject() == project) {
				key = entry.getKey();
				break;
			}
		}
		if (key != null) {
			IEar ear = ears.remove(key);
			ears.put(project.getName(), ear);
			notify(listeners, new EarChangeEvent(ear, IEarChangeEvent.RENAMED));
		}
	}

	public void clear() {
		ears.clear();
	}
}
