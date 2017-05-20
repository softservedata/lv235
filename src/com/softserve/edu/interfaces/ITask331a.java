package com.softserve.edu.interfaces;

import java.util.List;

import com.softserve.edu.dto.Task331aDto;
import com.softserve.edu.main.IsNotNaturalNumberException;

/**
 * Interface for task #331a.
 */
public interface ITask331a {
	/**
	 * start method.
	 */
	void start();

	/**
	 * @return natural integer number.
	 * @throws IsNotNaturalNumberException.
	 */
	int naturalNumberInput() throws IsNotNaturalNumberException;

	/**
	 * @throws IsNotNaturalNumberException.
	 */
	void toConsole(List<Task331aDto> list) throws IsNotNaturalNumberException;
}
