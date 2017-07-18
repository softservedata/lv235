package com.softserve.edu.registrator.data.external;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.softserve.edu.registrator.tools.exception.GeneralCustomException;

public final class CSVUtils implements IExternalData {
    
    private static class CSVFactory implements IRowFactory {
        public List<String> updateRow(List<String> row) {
            return row;
        }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

	private final String CSV_SPLIT_BY = ",";
	private IRowFactory rowFactory; 
	private String filename;
	private String path;
	
	public CSVUtils(String filename) {
	    this.filename = filename;
	    this.path = this.getClass().getResource(filename).getPath().substring(1);
	    this.rowFactory = new CSVFactory();
	}
	
	public IRowFactory getRowFactory() {
	    return this.rowFactory;
	}
	
	public String getFilename() {
        return this.filename;
    }

	public String getPath() {
        return this.path;
    }

	public List<List<String>> getAllCells() {
	    return getAllCells(path);
	}

    public List<List<String>> getAllCells(String path) {
		List<List<String>> allCells = new ArrayList<List<String>>();
		String row;
		// List<String> row;
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(path));
			while ((row = bufferedReader.readLine()) != null) {
				allCells.add(Arrays.asList(row.split(CSV_SPLIT_BY)));
			}
		} catch (FileNotFoundException e) {
			throw new GeneralCustomException(String.format(FILE_NOT_FOUND_EXCEPTION, path), e);
		} catch (IOException e) {
			throw new GeneralCustomException(String.format(FILE_NOT_READ_EXCEPTION, path), e);
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					throw new GeneralCustomException(String.format(FILE_NOT_CLOSE_EXCEPTION, path), e);
				}
			}
		}
		return allCells;
	}

}
