package com.patam.server.managment;

import com.patam.server.logic.Problem;
import com.patam.server.logic.Solution;

public interface Solver {
	public Solution solve(Problem problem);
	public Problem createProblem(Problem problem);
	
}
