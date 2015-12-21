package cells;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map.Entry;

public class Cells {

	public HashMap<Point, Integer> cells = new HashMap<Point, Integer>();
	public HashMap<Point, Integer> numberOfFriends = new HashMap<Point, Integer>();

	public void initialization(Point location){
		cells.put(location, 0);
		numberOfFriends.put(location, 0);
	}
	
	public void makeAlive(Point location) {
		cells.put(location, 1);
	}

	public void makeDead(Point location) {
		cells.put(location, 0);
	}

	public void setStatus(Point location, int status) {
		numberOfFriends.put(location, status);
	}

	public int getStatus(Point location) {
		int status = 0;
		boolean locationAbroad = location.x < 0 || location.y < 0 || location.x > (Math.sqrt(cells.size()) - 1)
				|| location.y > Math.sqrt(cells.size()) - 1;
				
		if (locationAbroad) {
			status = 0;
		} else {
			status = cells.get(location);
		}
		return status;
	}
	
	public int getNumberOfFriends(Point location) {
		int status = 0;
		status = numberOfFriends.get(location);	
		return status;
	}

	public int getNumberOfAliveCells(){
		int aliveCells = 0;
        for (Entry<Point, Integer> entry : cells.entrySet())
        {
            Integer value = entry.getValue();
		    if(value.equals(1)){
		    	aliveCells++;
		    }
        }
        return aliveCells;
	}

}
