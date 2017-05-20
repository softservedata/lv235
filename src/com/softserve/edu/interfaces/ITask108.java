package com.softserve.edu.interfaces;

import com.softserve.edu.dto.Task108Dto;
import com.softserve.edu.main.IsNotNaturalNumberException;

public interface ITask108 {
	int naturalNumberInput() throws IsNotNaturalNumberException;

	void toConsole(Task108Dto d);

	void start();
}
