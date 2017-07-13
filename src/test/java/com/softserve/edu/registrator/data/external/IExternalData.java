package com.softserve.edu.registrator.data.external;

import java.util.List;

public interface IExternalData {
    String FILE_NOT_FOUND_EXCEPTION = "File %s could not be found";
    String FILE_NOT_READ_EXCEPTION = "File %s could not be read";
    String FILE_NOT_CLOSE_EXCEPTION = "File %s could not be closed";
    
    String getPath();
    
    List<List<String>> getAllCells();
    
	List<List<String>> getAllCells(String path);

}
