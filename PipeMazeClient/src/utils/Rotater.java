 package utils;

public class Rotater {
	
	public static char[][] rotate(char[][] lvl,int row, int col){
		char tmpChar = lvl[row][col];
		
		switch(tmpChar) {
		case 'L':
			lvl[row][col] = 'F';
			break;
		case 'J':
			lvl[row][col] = 'L';
			break;
		case '7':
			lvl[row][col] = 'J';
			break;
		case 'F':
			lvl[row][col] = '7';
			break;
		case '-':
			lvl[row][col] = '|';
			break;
		case '|':
			lvl[row][col] = '-';
			break;
		}
		
		return lvl;
	}
}
