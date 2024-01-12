package com.example.bvnk_history_service.populator;

public interface Populator<S, T> {

	/**
	 * Populates the target object with the values from the source object.
	 *
	 * @param source the source object
	 * @param target the target object
	 */
	void populate(S source, T target);

}
