package com.lambda.impex.ast;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.antlr.v4.runtime.Token;

public class MacroDefinitions {
	public static int index = 0;
	private NavigableMap<Integer, String> macroDefinitionsMap = new TreeMap<>();
	private SortedSet<String> cachedMacroDefinitions;
	private SortedSet<String> currentMacroDefinitions;
	private int offset;

	public MacroDefinitions() {
	}

	boolean isReferenced(Token token) {
		SortedSet<String> defs = getCachedMacroDefinitions(token);
		String text = token.getText();
		if (defs.isEmpty() || defs.first().length() > text.length() || defs.last().length() < text.length()){
			return false;
		}
		boolean contains = defs.contains(text);
		System.out.println((index++) + " " + contains + " " + defs.size() + " " + text);
//		if (!contains) {
//			defs.remove(defs.iterator().next());
//		}
		return contains;
	}

	private SortedSet<String> getCurrentMacroDefinitions(Token token) {
		if (currentMacroDefinitions != null) {
			currentMacroDefinitions = getByPreffix(currentMacroDefinitions, token.getText());
		} else {
			currentMacroDefinitions = getByPreffix(getCachedMacroDefinitions(token), token.getText());
		}
		return currentMacroDefinitions;
	}

	private SortedSet<String> getCachedMacroDefinitions(Token token) {
		if (cachedMacroDefinitions == null) {
			// beginning of the line
			int index = offset + token.getStartIndex() - token.getCharPositionInLine();
//			 cachedMacroDefinitions = new TreeSet(macroDefinitionsMap.headMap(index, false).values());
			cachedMacroDefinitions = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String str1, String str2) {
					int diff = str1.length() - str2.length();
					return diff == 0 ? str1.compareTo(str2) : diff;
				}
			});
			Collection<String> values = macroDefinitionsMap.headMap(index, false).values();
			String text = token.getText();
			for (String value : values) {
				if (value.startsWith(text)){
					cachedMacroDefinitions.add(value);
				}
			}
		}
		return cachedMacroDefinitions;
	}

	private static SortedSet<String> getByPreffix(SortedSet<String> myMap, String preffix) {
		return myMap.subSet(preffix, preffix + Character.MAX_VALUE);
	}

	void macrodef(Token token) {
		String text = token.getText();
		macroDefinitionsMap.put(offset + token.getStartIndex(), text);
	}

	void nextToken() {
		currentMacroDefinitions = null;
	}

	void clear() {
		cachedMacroDefinitions = null;
	}

	void update(int offset, int length, int delta) {
		print();
		index = 0;
		this.offset = offset;
		Integer firstMacroDefinitionToShift = macroDefinitionsMap.floorKey(offset + length - delta);
		if (firstMacroDefinitionToShift == null || firstMacroDefinitionToShift < offset) {
			return;
		}

		boolean toInclusive = offset == firstMacroDefinitionToShift;
		NavigableMap<Integer, String> subMap = macroDefinitionsMap.subMap(offset, true, firstMacroDefinitionToShift,
				toInclusive);
		subMap.clear();

		NavigableMap<Integer, String> tailToShift = macroDefinitionsMap.tailMap(firstMacroDefinitionToShift, !toInclusive);
		Map<Integer, String> shiftedMacroDefinitions = new HashMap<>();
		for (Iterator<Entry<Integer, String>> it = tailToShift.entrySet().iterator(); it.hasNext();) {
			Entry<Integer, String> entry = it.next();
			shiftedMacroDefinitions.put(entry.getKey() + delta, entry.getValue());
			it.remove();
		}
		macroDefinitionsMap.putAll(shiftedMacroDefinitions);
		print();
	}

	private void print() {
		System.out.print("[");
		for (Entry<Integer, String> string : macroDefinitionsMap.entrySet()) {
			System.out.print(string.getKey() + ":" + string.getValue() + ", ");
		}
		System.out.println("]");
		
	}

}
