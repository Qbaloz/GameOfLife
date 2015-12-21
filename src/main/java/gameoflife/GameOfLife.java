package gameoflife;

import java.awt.Point;
import java.util.Map.Entry;

import cells.Cells;

public class GameOfLife {

	public Cells cells = new Cells();

	public GameOfLife() {
		boardInitialization(5);
	}

	public GameOfLife(int dimension) {
		boardInitialization(dimension);
	}

	private void boardInitialization(int dimension) {
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				cells.initialization(new Point(i, j));
			}
		}
	}

	public void nextCycleOfLife() {
		calculateNumberOfFriends();
		applyGameRules();
	}

	private void applyGameRules() {
        for (Entry<Point, Integer> entry : cells.cells.entrySet())
        {
        	Point location = entry.getKey();
			boolean isCellAlive = cells.getStatus(location) == 1;
			boolean isCellDead = cells.getStatus(location) == 0;
			boolean friendsNumberRequiredToLive = cells.getNumberOfFriends(location) == 3;
			boolean friendsNumberRequiredToDie = cells.getNumberOfFriends(location) < 2
					|| cells.getNumberOfFriends(location) > 3;

			if (isCellAlive && friendsNumberRequiredToDie) {
				cells.makeDead(location);
			}
			if (isCellDead && friendsNumberRequiredToLive) {
				cells.makeAlive(location);
			}
        }
	}

	private void calculateNumberOfFriends() {
        for (Entry<Point, Integer> entry : cells.cells.entrySet())
        {
        	Point location = entry.getKey();
            Integer value = entry.getValue();
            calculateOnlyNearAliveCells(location, value);
        }
	}

	private void calculateOnlyNearAliveCells(Point location, Integer value) {
		int numberOfFriends;
		if (value == 1) {
			for (int i = location.x - 1; i <= location.x + 1; i++) {
				for (int j = location.y - 1; j <= location.y + 1; j++) {
					numberOfFriends = numberOfNeighborsAliveCells(new Point(i, j));
					cells.setStatus(new Point(i, j), numberOfFriends);
				}
			}
		}
	}

	private int numberOfNeighborsAliveCells(Point location) {
		int aliveCellsNearby = 0;
		for (int i = location.x - 1; i <= location.x + 1; i++) {
			for (int j = location.y - 1; j <= location.y + 1; j++) {
				if (cells.getStatus(new Point(i, j)) == 1) {
					aliveCellsNearby++;
				}
			}
		}

		if (cells.getStatus(location) == 1) {
			aliveCellsNearby--;
		}
		return aliveCellsNearby;
	}

	public void makeCellAlive(Point location) {
		cells.makeAlive(location);
	}

	public int getNumberOfAliveCells() {
		int aliveCells;
		aliveCells = cells.getNumberOfAliveCells();
		return aliveCells;
	}

}
