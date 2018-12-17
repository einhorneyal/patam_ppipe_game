package com.patam.server.logic.algo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

import com.patam.server.exceptions.MatrixException;
import com.patam.server.logic.Matrix;
import com.patam.server.logic.Searchable;
import com.patam.server.logic.Searcher;
import com.patam.server.logic.State;
import com.patam.server.pipeGame.PipeSearchable;
import com.patam.server.pipeGame.PipeState;

public class HC_DFS implements Searcher {
	
	Stack<State> open;
	HashSet<String> visited; // a set of states already evaluated

	@Override
	public ArrayList<State> search(Searchable searchable) {
		System.out.println("Starting HC_DFS");
		visited = new HashSet<String>();
		open = new Stack<State>();
		open.push(searchable.getInitialState());
		
		while(!open.isEmpty())
		{
			State v = open.pop();
			//visited.add(v.toString());
			//System.out.println("adding to Visited list: " + v.toString());
			
			//System.out.println("This is V that we poped");
			v.print();
			if(!visited.contains(v))
			{
				if(searchable.isGoal(v))
				{
					//System.out.println("done! goal");
					return searchable.backTrack(v);
				}
				ArrayList<State> list = new ArrayList<State>();
				list = v.getNeighbors();
				//System.out.println("Printing list before reorer");
				printList(list);
				//System.out.println("Printing list After reorer");
				list.sort(searchable.getComp());//diffrence between dfs to 
				printList(list);
				//System.out.println("This is v's neighbors");
				
				for(State s:list)
				{
					if(!visited.contains(s.toString())){
						s.setCameFrom(v);
						//System.out.println("p: " + v.getLocation().toString());
						open.push(s);
						//System.out.println("me:" + s.getLocation().toString());
					}
				}
			}
		}
		
		return null;
	}


  	public void printList(ArrayList<State> list)
	{
		if(list !=null){
			for(State s1: list)
			{
				s1.print();
				//System.out.println("----- cost: " + s1.getCost());
				try{
					//System.out.print("p:");
					//s1.getCameFrom().getLocation().print();
				}catch(Exception e){}
			}
		}
	}

  	
  	
  	public static void main(String[]args)
	{
		File file = new File("C:\\test\\level7.txt");
		File file2 = new File("C:\\test\\level2.txt");
		File file3 = new File("C:\\test\\level7.txt");

	    try {
			Matrix mat = new Matrix(file3);
			//mat.print();
			Matrix mat2 = new Matrix(file2);
			State s = new PipeState(mat);
			State t = new PipeState(mat2);
			//System.out.println(s.equals(t));
			//System.out.println(s.toString());
			PipeSearchable ps = new PipeSearchable(s);
			//ArrayList<State> list =ps.getAllPossibleStates(ps.getFirstState());
			HC_DFS dfs=  new HC_DFS();
			dfs.printList(dfs.search(ps));
		} catch (MatrixException e) {
			e.printStackTrace();
		}
	}
}
