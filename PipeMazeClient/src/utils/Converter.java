package utils;

import java.io.File;

public class Converter {
	
	public static char[][] convertFileToCharArray(File file) {
		
		int rows = FileHandler.getNumRows(file);
		int cols = FileHandler.getFirstRow(file).length();

		if(rows <= 0 || cols <= 0)
			return null;
		
		char[][] matrix = new char[rows][cols];
		for(int i = 0; i < rows; i++)
		{
			String line = FileHandler.getRow(file, i);
			
			for(int j = 0; j < cols; j++)
			{
				matrix[i][j] = line.charAt(j);
			}
		}
		
		return matrix;
	}
}
