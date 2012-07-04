package com.kizoom.plugin.wildebeest.ear.navigator;
//package com.kizoom.plugin.navigator;
//
//import org.eclipse.core.internal.events.ILifecycleListener;
//import org.eclipse.core.internal.events.LifecycleEvent;
//import org.eclipse.core.internal.events.ResourceChangeEvent;
//import org.eclipse.core.internal.events.ResourceStats;
//import org.eclipse.core.internal.resources.IManager;
//import org.eclipse.core.resources.IProject;
//import org.eclipse.core.resources.IResourceChangeEvent;
//import org.eclipse.core.resources.IResourceChangeListener;
//import org.eclipse.core.runtime.Assert;
//import org.eclipse.core.runtime.CoreException;
//import org.eclipse.core.runtime.IProgressMonitor;
//import org.eclipse.core.runtime.ISafeRunnable;
//import org.eclipse.core.runtime.SafeRunner;
//
//public class EarNotificationManager implements IManager, ILifecycleListener {
//
//	private ResourceChangeListenerList listeners;
//	private final EarRoot root;
//
//	public EarNotificationManager(EarRoot root) {
//		this.root = root;
//	}
//
//	@Override
//	public void shutdown(IProgressMonitor monitor) throws CoreException {
//		root.addLifecycleListener(this);
//	}
//
//	public void addListener(IResourceChangeListener listener, int eventMask) {
//		listeners.add(listener, eventMask);
//	}
//
//	@Override
//	public void startup(IProgressMonitor monitor) throws CoreException {
//		listeners = new ResourceChangeListenerList();
//	}
//
//	@Override
//	public void handleEvent(LifecycleEvent event) throws CoreException {
//		switch (event.kind) {
//			case LifecycleEvent.PRE_PROJECT_CLOSE:
//				if (!listeners.hasListenerFor(IResourceChangeEvent.PRE_CLOSE))
//					return;
//				IProject project = (IProject) event.resource;
//				notify(listeners.getListeners(), new ResourceChangeEvent(workspace, IResourceChangeEvent.PRE_CLOSE, project),
//						true);
//				break;
//			case LifecycleEvent.PRE_PROJECT_MOVE:
//				// only notify deletion on move if old project handle is going
//				// away
//				if (event.resource.equals(event.newResource))
//					return;
//				// fall through
//			case LifecycleEvent.PRE_PROJECT_DELETE:
//				if (!listeners.hasListenerFor(IResourceChangeEvent.PRE_DELETE))
//					return;
//				project = (IProject) event.resource;
//				notify(listeners.getListeners(), new ResourceChangeEvent(root, IResourceChangeEvent.PRE_DELETE, project), true);
//				break;
//			case LifecycleEvent.PRE_PROJECT_REFRESH:
//				if (!listeners.hasListenerFor(IResourceChangeEvent.PRE_REFRESH))
//					return;
//				project = (IProject) event.resource;
//				notify(listeners.getListeners(), new ResourceChangeEvent(root, IResourceChangeEvent.PRE_REFRESH, project), true);
//				break;
//		}
//	}
//
//	private void notify(ResourceChangeListenerList.ListenerEntry[] resourceListeners, final IResourceChangeEvent event,
//			final boolean lockTree) {
//		int type = event.getType();
//		for (int i = 0; i < resourceListeners.length; i++) {
//			if ((type & resourceListeners[i].eventMask) != 0) {
//				final IResourceChangeListener listener = resourceListeners[i].listener;
//				if (ResourceStats.TRACE_LISTENERS)
//					ResourceStats.startNotify(listener);
//				SafeRunner.run(new ISafeRunnable() {
//					public void handleException(Throwable e) {
//						// exception logged in SafeRunner#run
//					}
//
//					public void run() throws Exception {
//						listener.resourceChanged(event);
//					}
//				});
//				if (ResourceStats.TRACE_LISTENERS)
//					ResourceStats.endNotify();
//			}
//		}
//	}
//
//	private static class ResourceChangeListenerList {
//
//		static class ListenerEntry {
//			int eventMask;
//			IResourceChangeListener listener;
//
//			ListenerEntry(IResourceChangeListener listener, int eventMask) {
//				this.listener = listener;
//				this.eventMask = eventMask;
//			}
//		}
//
//		/**
//		 * The empty array singleton instance.
//		 */
//		private static final ListenerEntry[] EMPTY_ARRAY = new ListenerEntry[0];
//
//		private int count1 = 0;
//		private int count2 = 0;
//		private int count4 = 0;
//		private int count8 = 0;
//		private int count16 = 0;
//		private int count32 = 0;
//
//		/**
//		 * The list of listeners. Maintains invariant: listeners != null.
//		 */
//		private volatile ListenerEntry[] listeners = EMPTY_ARRAY;
//
//		/**
//		 * Adds the given listener to this list. Has no effect if an identical
//		 * listener is already registered.
//		 * 
//		 * @param listener
//		 *          the listener
//		 * @param mask
//		 *          event types
//		 */
//		public synchronized void add(IResourceChangeListener listener, int mask) {
//			Assert.isNotNull(listener);
//			if (mask == 0) {
//				remove(listener);
//				return;
//			}
//			ResourceChangeListenerList.ListenerEntry entry = new ResourceChangeListenerList.ListenerEntry(listener, mask);
//			final int oldSize = listeners.length;
//			// check for duplicates using identity
//			for (int i = 0; i < oldSize; ++i) {
//				if (listeners[i].listener == listener) {
//					removing(listeners[i].eventMask);
//					adding(mask);
//					listeners[i] = entry;
//					return;
//				}
//			}
//			adding(mask);
//			// Thread safety: copy on write to protect concurrent readers.
//			ListenerEntry[] newListeners = new ListenerEntry[oldSize + 1];
//			System.arraycopy(listeners, 0, newListeners, 0, oldSize);
//			newListeners[oldSize] = entry;
//			// atomic assignment
//			this.listeners = newListeners;
//		}
//
//		private void adding(int mask) {
//			if ((mask & 1) != 0)
//				count1++;
//			if ((mask & 2) != 0)
//				count2++;
//			if ((mask & 4) != 0)
//				count4++;
//			if ((mask & 8) != 0)
//				count8++;
//			if ((mask & 16) != 0)
//				count16++;
//			if ((mask & 32) != 0)
//				count32++;
//		}
//
//		/**
//		 * Returns an array containing all the registered listeners. The resulting
//		 * array is unaffected by subsequent adds or removes. If there are no
//		 * listeners registered, the result is an empty array singleton instance (no
//		 * garbage is created). Use this method when notifying listeners, so that
//		 * any modifications to the listener list during the notification will have
//		 * no effect on the notification itself.
//		 * <p>
//		 * Note: Clients must not modify the returned list
//		 * 
//		 * @return the list of registered listeners that must not be modified
//		 */
//		public ListenerEntry[] getListeners() {
//			return listeners;
//		}
//
//		public boolean hasListenerFor(int event) {
//			if (event == 1)
//				return count1 > 0;
//			if (event == 2)
//				return count2 > 0;
//			if (event == 4)
//				return count4 > 0;
//			if (event == 8)
//				return count8 > 0;
//			if (event == 16)
//				return count16 > 0;
//			if (event == 32)
//				return count32 > 0;
//			return false;
//		}
//
//		/**
//		 * Removes the given listener from this list. Has no effect if an identical
//		 * listener was not already registered.
//		 * 
//		 * @param listener
//		 *          the listener to remove
//		 */
//		public synchronized void remove(IResourceChangeListener listener) {
//			Assert.isNotNull(listener);
//			final int oldSize = listeners.length;
//			for (int i = 0; i < oldSize; ++i) {
//				if (listeners[i].listener == listener) {
//					removing(listeners[i].eventMask);
//					if (oldSize == 1) {
//						listeners = EMPTY_ARRAY;
//					} else {
//						// Thread safety: create new array to avoid affecting concurrent
//						// readers
//						ListenerEntry[] newListeners = new ListenerEntry[oldSize - 1];
//						System.arraycopy(listeners, 0, newListeners, 0, i);
//						System.arraycopy(listeners, i + 1, newListeners, i, oldSize - i - 1);
//						// atomic assignment to field
//						this.listeners = newListeners;
//					}
//					return;
//				}
//			}
//		}
//
//		private void removing(int mask) {
//			if ((mask & 1) != 0)
//				count1--;
//			if ((mask & 2) != 0)
//				count2--;
//			if ((mask & 4) != 0)
//				count4--;
//			if ((mask & 8) != 0)
//				count8--;
//			if ((mask & 16) != 0)
//				count16--;
//			if ((mask & 32) != 0)
//				count32--;
//		}
//	}
//}
