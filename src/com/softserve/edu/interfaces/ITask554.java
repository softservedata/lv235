package com.softserve.edu.interfaces;

import java.util.List;

import com.softserve.edu.dto.Task554Dto;
import com.softserve.edu.main.IsNotNaturalNumberException;

public interface ITask554 {
	void start();

	int naturalNumberInput() throws IsNotNaturalNumberException;

	void toConsole(List<Task554Dto> list) throws IsNotNaturalNumberException;
}
