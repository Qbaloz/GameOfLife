package boardVizualization;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import cells.Cells;

public class Board {
	
	private ArrayList<List<Integer>> board;
	
	public Board(int dimension){
		createBoard(dimension);
	}
	
	public void createBoard(int dimension){
		board = new ArrayList<List<Integer>>();
		for(int i = 0; i < dimension; i++){
			board.add(i, new ArrayList<Integer>(Collections.nCopies(dimension, 0)));
		}
	}
	
	public void displayBoard(){
		for (List<Integer> list : board) {
		    for (Integer i : list) {
		        System.out.print(i+"  ");
		    }
		    System.out.println();
		}
	}
	
	public void updateBoard(Cells cells){
		
		for (Entry<Point, Integer> e : cells.cells.entrySet()) {
		    Point key = e.getKey();
		    Integer value = e.getValue();
		    if(value.equals(1)){
		    	board.get(key.x).set(key.y, 1);
		    }else{
		    	board.get(key.x).set(key.y, 0);
		    }   
		}
	}
	
}
