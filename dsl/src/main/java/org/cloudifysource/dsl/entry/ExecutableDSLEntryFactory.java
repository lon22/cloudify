/*******************************************************************************
 * Copyright (c) 2012 GigaSpaces Technologies Ltd. All rights reserved
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/

package org.cloudifysource.dsl.entry;

import groovy.lang.Closure;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/***********
 * Factory class for creating an executable DSL entry from a DSL value.
 * 
 * @author barakme
 * @since 2.2.0
 * 
 */
public final class ExecutableDSLEntryFactory {

	private ExecutableDSLEntryFactory() {
		// private constructor to prevent instantiation
	}

	@SuppressWarnings("unchecked")
	public static ExecutableEntriesMap createEntriesMap(final Object arg, final Object entryName) {
		
		final ExecutableEntriesMap result = new ExecutableEntriesMap();
		copyElementsToEntriesMap(arg, entryName, result);
		return result;
		
	}
	/****************
	 * Created an executable entry from a DSL value. The argument must be from one of the supported types.
	 * 
	 * @param arg the dsl value.
	 * @param entryName the dsl entry name.
	 * @return the executable entry wrapper for the given arg.
	 */
	@SuppressWarnings("unchecked")
	public static ExecutableDSLEntry createEntry(final Object arg, final Object entryName) {
		if (arg instanceof Closure<?>) {
			return new ClosureExecutableEntry((Closure<?>) arg);
		} else if (arg instanceof String) {
			return new StringExecutableEntry((String) arg);
		} else if (arg instanceof List<?>) {
			return new ListExecutableEntry((List<String>) arg);
		} else if (arg instanceof Map<?, ?>) {
			
			// verify types of keys and objects, and create a new map with wrapper entry objects for each value.
			final MapExecutableEntry result = new MapExecutableEntry();
			copyElementsToEntriesMap(arg, entryName, result);
			return result;
		}
		throw new IllegalArgumentException("The entry: " + entryName
				+ " is not a valid executable entry: The given value: " + arg + " is of type: "
				+ arg.getClass().getName() + " which is not a valid type for an executable entry");

	}

	private static void copyElementsToEntriesMap(final Object arg, final Object entryName,
			final Map<String, ExecutableDSLEntry> result) {
		final Map<Object, Object> originalMap = (Map<Object, Object>) arg;
		final Set<Entry<Object, Object>> entries = originalMap.entrySet();
		
		for (final Entry<Object, Object> entry : entries) {
			if (!(entry.getKey() instanceof String)) {
				throw new IllegalArgumentException("Entry " + entryName
						+ " has a sub entry key which is not a string. Subentry was: " + entry.getKey());
			}
			// RECURSIVE CALL!
			final ExecutableDSLEntry executableEntry = createEntry(entry.getValue(), entry.getKey());
			result.put((String) entry.getKey(), executableEntry);

		}
	}

}
