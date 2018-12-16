package com.patam.server.util;

import java.io.File;

import com.patam.server.exceptions.MatrixException;
import com.patam.server.logic.Problem;


public interface MatrixConvertor {
	public char[][] convert(File file) throws MatrixException;
	public Problem convert(String s) throws MatrixException;
	public String reConvert(Problem p) throws MatrixException;
}
