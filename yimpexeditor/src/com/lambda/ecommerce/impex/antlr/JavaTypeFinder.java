package com.lambda.ecommerce.impex.antlr;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;

import com.lambda.ecommerce.impex.YImpex;
import com.lambda.impex.ast.TypeDescription;
import com.lambda.impex.ast.TypeFinder;
import com.lambda.plugin.YCore;
import com.lambda.plugin.core.IPlatformInstallation;
import com.lambda.plugin.utils.StringUtils;

//TODO add synchor
public class JavaTypeFinder implements TypeFinder {

	public static final int JALO_SEARCH = 1;
	public static final int MODEL_SEARCH = 2;
	public static final int ENUM_SEARCH = 4;
	public static final int TRANSLATOR_SEARCH = 8;
	public static final int SPECIAL_TRANSLATOR_SEARCH = 16;
	public static final int DECORATOR_SEARCH = 32;
	public static final int PROCESSOR_SEARCH = 64;

	private static final String JAVA_API_TYPE_PREFIX = "java.";
	private static final String MODEL_SUFFIX = "Model";
	private static final String PLATFORM_PROJECT_NAME = "platform";
	private static final String PLATFORM_JALO_PACKAGE = "de.hybris.platform*.jalo*";
	private static final String PLATFORM_ENUM_PACKAGE = "*.enums*";
	private static final String PLATFORM_MODEL_PACKAGE = "*.model*";
	private static final Pattern GENERIC_CLASS = Pattern.compile(".*<(([a-zA-Z0-9\\.\\$]+))>$");
	private static final String[] PRIMITIVES = new String[] { "int", "long", "byte", "short", "boolean", "char",
			"float", "double", };
	private static final String[] COLLECTIONS = new String[] { "java.util.Collection", "java.util.List",
			"java.util.Set", };
	private final Map<String, IType> typeCache = new HashMap<>();
	private final Map<String, IType> modifierTypeCache = new HashMap<>();
	private final JavaFieldCollector fieldCollector = new JavaFieldCollector();
	private IJavaProject project;
	private final Map<String, String> jaloClasses = new HashMap<>();
	private final Map<String, IJavaSearchScope> scopes = new HashMap<String, IJavaSearchScope>();

	{
		jaloClasses.put("GenericItem", "de.hybris.platform.jalo.GenericItem");
	}

	public JavaTypeFinder() {
	}

	// "de.hybris.platform.impex.jalo.imp.ImportProcessor"
	@Override
	public Object findDecoratorType(String fullName) {
		if (StringUtils.isEmpty(fullName)) {
			return null;
		}

		if (modifierTypeCache.containsKey(fullName)) {
			return modifierTypeCache.get(fullName);
		}
		int lastIndexOf = fullName.lastIndexOf('.');
		String className = fullName.substring(lastIndexOf + 1);
		String packageName = fullName.substring(0, lastIndexOf);
		try {
			IJavaSearchScope scope = getHierarchyScope(
					"de.hybris.platform.impex.jalo.header.AbstractImpExCSVCellDecorator");
			return searchModifierType(className, scope);
		} catch (CoreException e) {
			YImpex.logError(e);
		}
		return null;
	}

	@Override
	public Object findTranslatorType(String fullName) {
		// de.hybris.platform.impex.jalo.translators.AbstractValueTranslator
		if (StringUtils.isEmpty(fullName)) {
			return null;
		}

		if (modifierTypeCache.containsKey(fullName)) {
			return modifierTypeCache.get(fullName);
		}
		int lastIndexOf = fullName.lastIndexOf('.');
		String className = fullName.substring(lastIndexOf + 1);
		String packageName = fullName.substring(0, lastIndexOf);
		try {
			IJavaSearchScope scope = getHierarchyScope(
					"de.hybris.platform.impex.jalo.translators.AbstractValueTranslator");
			return searchModifierType(className, scope);

		} catch (CoreException e) {
			YImpex.logError(e);
		}
		return null;
	}

	@Override
	public Object findProcessorType(String fullName) {
		// de.hybris.platform.impex.jalo.imp.ImportProcessor
		if (StringUtils.isEmpty(fullName)) {
			return null;
		}

		if (modifierTypeCache.containsKey(fullName)) {
			return modifierTypeCache.get(fullName);
		}
		int lastIndexOf = fullName.lastIndexOf('.');
		String className = fullName.substring(lastIndexOf + 1);
		String packageName = fullName.substring(0, lastIndexOf);
		try {
			IJavaSearchScope scope = getHierarchyScope("de.hybris.platform.impex.jalo.imp.ImportProcessor");
			return searchModifierType(className, scope);
		} catch (CoreException e) {
			YImpex.logError(e);
		}
		return null;
	}
	
	@Override
	public Object findSpecialTranslatorType(String fullName) {
		// de.hybris.platform.impex.jalo.translators.SpecialValueTranslator
		if (StringUtils.isEmpty(fullName)) {
			return null;
		}

		if (modifierTypeCache.containsKey(fullName)) {
			return modifierTypeCache.get(fullName);
		}
		int lastIndexOf = fullName.lastIndexOf('.');
		String className = fullName.substring(lastIndexOf + 1);
		String packageName = fullName.substring(0, lastIndexOf);
		try {
			IJavaSearchScope scope = getHierarchyScope(
					"de.hybris.platform.impex.jalo.translators.SpecialValueTranslator");
			return searchModifierType(className, scope);
		} catch (CoreException e) {
			YImpex.logError(e);
		}
		return null;
	}

	private IType searchModifierType(String className, IJavaSearchScope scope) {
		SearchEngine engine = new SearchEngine();
		final Set<IType> types = Collections.newSetFromMap(new ConcurrentHashMap<IType, Boolean>());
		try {
			final NullProgressMonitor monitor = new NullProgressMonitor();
			SearchPattern pattern = SearchPattern.createPattern(className, IJavaSearchConstants.CLASS,
					IJavaSearchConstants.DECLARATIONS, SearchPattern.R_EXACT_MATCH);
			SearchParticipant[] participants = new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() };
			SearchRequestor requestor = new SearchRequestor() {

				@Override
				public void acceptSearchMatch(SearchMatch match) throws CoreException {
					IType type = (IType) match.getElement();
					types.add(type);
					monitor.setCanceled(true);
				}
			};
			engine.search(pattern, participants, scope, requestor, monitor);

			if (!types.isEmpty()) {
				IType type = types.iterator().next();
				modifierTypeCache.put(type.getFullyQualifiedName(), type);
				return type;
			}
			return null;
		} catch (CoreException e) {
			YImpex.logError(e);
			return null;
		} catch (OperationCanceledException e) {
			return null;
		}
	}

	@Override
	public TypeDescription findBySimpleName(String typename) {
		IType type = findTypeBySimpleName(typename);
		return JavaTypeDescription.fromType(type, false, fieldCollector);
	}

	private IType findTypeBySimpleName(String typename) {
		if (jaloClasses.containsKey(typename)) {
			return getType(jaloClasses.get(typename), JALO_SEARCH);
		}
		return getType(typename, MODEL_SEARCH | ENUM_SEARCH);
	}

	@Override
	public TypeDescription findType(final String name) {

		if (isCollection(name)) {
			String collectionTypeName = getCollectionTypeName(name);
			if (isEmptyOrJavaType(collectionTypeName)) {
				return JavaTypeDescription.fromTypeName(name, true);
			}
			IType type = getType(collectionTypeName, isModel(collectionTypeName) ? MODEL_SEARCH : ENUM_SEARCH);
			return JavaTypeDescription.fromType(type, true, fieldCollector);
		} else if (isEmptyOrJavaType(name)) {
			return JavaTypeDescription.fromTypeName(name, false);
		}

		IType type = getType(name, isModel(name) ? MODEL_SEARCH : ENUM_SEARCH);
		return JavaTypeDescription.fromType(type, false, fieldCollector);
	}

	private boolean isModel(String name) {
		return name.endsWith(MODEL_SUFFIX);
	}

	private String getCollectionTypeName(String typename) {
		Matcher matcher = GENERIC_CLASS.matcher(typename);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return typename;
	}

	private static boolean isFullyQualifiedName(String name) {
		int index = name.lastIndexOf('.');
		return index > 0;
	}

	private IType getType(final String typename, int searchType) {
		if (StringUtils.isEmpty(typename)) {
			return null;
		}

		if (typeCache.containsKey(typename)) {
			return typeCache.get(typename);
		}

		if (isFullyQualifiedName(typename)) {
			IType type = null;
			try {
				type = getPlatformProject().findType(typename);
				typeCache.put(type.getElementName(), type);
			} catch (JavaModelException e) {
				YImpex.logError(e);
			}
			return type;
		}

		final Set<IType> types = Collections.newSetFromMap(new ConcurrentHashMap<IType, Boolean>());
		getType(typename, types, searchType);
		IType type = types.isEmpty() ? null : types.iterator().next();
		typeCache.put(typename, type);
		return type;
	}

	private void getType(final String typename, final Set<IType> result, int searchType) {
		SearchRequestor requestor = new SearchRequestor() {

			@Override
			public void acceptSearchMatch(SearchMatch match) throws CoreException {
				IType type = (IType) match.getElement();
				// TODO thread that feeds the list which is immediately returned
				System.out.println("found: " + type.getElementName());
				result.add(type);
			}
		};

		System.err.println("entered search " + decode(searchType) + "Type - find '" + typename + "'");
		long millis = System.currentTimeMillis();
		try {
			searchType(typename, SearchPattern.R_EXACT_MATCH, requestor, searchType);
		} finally {
			millis = System.currentTimeMillis() - millis;
			System.err.println(String.format("Took %d:%d:%d", TimeUnit.MILLISECONDS.toMinutes(millis),
					TimeUnit.MILLISECONDS.toSeconds(millis)
							- TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)),
					TimeUnit.MILLISECONDS.toMillis(millis)
							- TimeUnit.SECONDS.toMillis(TimeUnit.MILLISECONDS.toSeconds(millis))));
		}

	}

	public void searchType(final String typename, int matchRule, SearchRequestor requestor, int searchType) {
		IJavaProject project = getPlatformProject();
		if (!project.exists()) {
			return;
		}
		try {
			TypeDeclarationsFinderJob mFinder = null;
			TypeDeclarationsFinderJob eFinder = null;
			TypeDeclarationsFinderJob jFinder = null;
			if ((searchType & MODEL_SEARCH) == MODEL_SEARCH) {
				String tname = matchRule == SearchPattern.R_EXACT_MATCH ? ensureSuffix(typename, MODEL_SUFFIX)
						: typename;
				mFinder = new TypeDeclarationsFinderJob(tname, matchRule, requestor, PLATFORM_MODEL_PACKAGE);
				mFinder.setPriority(Job.SHORT);
				mFinder.schedule();
			}
			if ((searchType & JALO_SEARCH) == JALO_SEARCH) {
				jFinder = new TypeDeclarationsFinderJob(typename, matchRule, requestor, PLATFORM_JALO_PACKAGE);
				jFinder.setPriority(Job.SHORT);
				jFinder.schedule();
			}
			if ((searchType & ENUM_SEARCH) == ENUM_SEARCH) {
				eFinder = new TypeDeclarationsFinderJob(typename, matchRule, requestor, PLATFORM_ENUM_PACKAGE,
						IJavaSearchConstants.CLASS_AND_ENUM);
				eFinder.setPriority(Job.SHORT);
				eFinder.schedule();
			}

			if ((searchType & DECORATOR_SEARCH) == DECORATOR_SEARCH) {
				eFinder = new TypeDeclarationsFinderJob(typename, matchRule, requestor, PLATFORM_ENUM_PACKAGE,
						IJavaSearchConstants.CLASS_AND_ENUM);
				eFinder.setPriority(Job.SHORT);
				eFinder.schedule();
			}

			if (mFinder != null) {
				mFinder.join();
			}
			if (jFinder != null) {
				jFinder.join();
			}
			if (eFinder != null) {
				eFinder.join();
			}

		} catch (CoreException | InterruptedException e) {
			YImpex.logError(e);
		}
	}

	private String ensureSuffix(String typename, String suffix) {
		return typename.endsWith(suffix) ? typename : typename + suffix;
	}

	private IJavaSearchScope getPlatformScope() {
		if (!scopes.containsKey(PLATFORM_PROJECT_NAME)) {
			IJavaSearchScope platformScope = SearchEngine
					.createJavaSearchScope(new IJavaElement[] { getPlatformProject() }, IJavaSearchScope.SOURCES);
			scopes.put(PLATFORM_PROJECT_NAME, platformScope);
		}
		return scopes.get(PLATFORM_PROJECT_NAME);
	}

	private IJavaSearchScope getHierarchyScope(String fullName) throws CoreException {

		if (!scopes.containsKey(fullName)) {
			int lastIndexOf = fullName.lastIndexOf('.');
			String className = fullName.substring(lastIndexOf + 1);
			String packageName = fullName.substring(0, lastIndexOf);
			IType type = getPlatformProject().findType(packageName, className);
			IJavaSearchScope scope = SearchEngine.createHierarchyScope(type);
			scopes.put(fullName, scope);
			return scope;
		}
		return scopes.get(fullName);
	}

	private IJavaProject getPlatformProject() {
		if (project == null) {
			IPlatformInstallation platform = YCore.getDefault().getDefaultPlatform();
			project = platform != null ? platform.getProject()
					: JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()).getJavaProject(PLATFORM_PROJECT_NAME);
		}
		return project;
	}

	private boolean isEmptyOrJavaType(final String typename) {
		return typename == null || typename.startsWith(JAVA_API_TYPE_PREFIX) || isPrimitive(typename);
	}

	private static boolean isPrimitive(String typename) {
		for (String primitive : PRIMITIVES) {
			if (primitive.equals(typename)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCollection(String fullTypeName) {
		if (fullTypeName == null) {
			return false;
		}

		for (String collection : COLLECTIONS) {
			if (fullTypeName.startsWith(collection)) {
				return true;
			}
		}
		return false;
	}

	private String decode(int searchType) {
		String txt = "";
		if ((searchType & JALO_SEARCH) == JALO_SEARCH) {
			txt += "Jalo ";
		}
		if ((searchType & MODEL_SEARCH) == MODEL_SEARCH) {
			txt += "Model ";
		}
		if ((searchType & ENUM_SEARCH) == ENUM_SEARCH) {
			txt += "Enum ";
		}
		return txt;
	}

	private class TypeDeclarationsFinderJob extends Job {
		private final SearchPattern pattern;
		private final SearchParticipant[] participants;
		private final IJavaSearchScope scope;
		private final SearchRequestor requestor;

		public TypeDeclarationsFinderJob(String stringPattern, int matchRule, SearchRequestor requestor,
				String searchScope) throws CoreException {
			this(stringPattern, matchRule, requestor, searchScope, IJavaSearchConstants.CLASS);
		}

		public TypeDeclarationsFinderJob(String stringPattern, int matchRule, SearchRequestor requestor,
				String searchScope, int searchFor) throws CoreException {
			super("Java Type Search");
			this.requestor = requestor;
			this.pattern = SearchPattern.createPattern(stringPattern, searchFor, IJavaSearchConstants.DECLARATIONS,
					matchRule);
			this.participants = new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() };
			this.scope = getPlatformScope();
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			SearchEngine engine = new SearchEngine();
			try {
				engine.search(pattern, participants, scope, requestor, monitor);
				return Status.OK_STATUS;
			} catch (CoreException e) {
				YImpex.logError(e);
				return new Status(Status.ERROR, YImpex.ID, "Find java type returned error", e);
			} catch (OperationCanceledException e) {
				return Status.CANCEL_STATUS;
			}
		}
	}
}
