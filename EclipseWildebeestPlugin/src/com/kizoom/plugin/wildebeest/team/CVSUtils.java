package com.kizoom.plugin.wildebeest.team;

import org.eclipse.team.internal.ccvs.core.ICVSRepositoryLocation;

@SuppressWarnings("restriction")
public class CVSUtils {

	public static boolean isCompatible(ICVSRepositoryLocation location, ICVSRepositoryLocation oldLocation) {
		if (!location.getHost().equals(oldLocation.getHost()))
			return false;
		if (!location.getRootDirectory().equals(oldLocation.getRootDirectory()))
			return false;
		// if (location.equals(oldLocation))
		// return false;
		return true;
	}
}
