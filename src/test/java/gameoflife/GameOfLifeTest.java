package gameoflife;

import java.awt.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import gameoflife.GameOfLife;

public class GameOfLifeTest {

	private GameOfLife game;

	@Before
	public void initialize() {
		game = new GameOfLife();
	}
	
	@Test
	public void shouldHandleOneAliveCell() {
		// given
		game.makeCellAlive(new Point(1, 1));
		game.nextCycleOfLife();
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(0, aliveCells);
	}
	
	@Test
	public void shouldHandleTwoAliveCells() {
		// given
		game.makeCellAlive(new Point(1, 2));
		game.makeCellAlive(new Point(1, 3));
		game.nextCycleOfLife();
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(0, aliveCells);
	}
	
	@Test
	public void shouldHandleThreeAliveCells() {
		// given
		game.makeCellAlive(new Point(1, 2));	
		game.makeCellAlive(new Point(2, 1));
		game.makeCellAlive(new Point(2, 2));
		game.nextCycleOfLife();
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(4, aliveCells);
	}
//	
	@Test
	public void shouldHandleThreeAliveCellsInRow() {
		// given
		game.makeCellAlive(new Point(1, 2));	
		game.makeCellAlive(new Point(2, 2));
		game.makeCellAlive(new Point(3, 2));
		game.nextCycleOfLife();
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(3, aliveCells);
	}
	
	@Test
	public void shouldHandleFourAliveCellsRepresentedAsSquare() {
		// given
		game.makeCellAlive(new Point(1, 1));	
		game.makeCellAlive(new Point(1, 2));
		game.makeCellAlive(new Point(2, 1));
		game.makeCellAlive(new Point(2, 2));
		game.nextCycleOfLife();
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(4, aliveCells);
	}
	
	@Test
	public void shouldHandleFourAliveCellsRepresentedAsSnake() {
		// given
		game.makeCellAlive(new Point(1, 2));
		game.makeCellAlive(new Point(2, 1));
		game.makeCellAlive(new Point(2, 2));
		game.makeCellAlive(new Point(3, 1));
		game.nextCycleOfLife();
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(6, aliveCells);
	}
	
	@Test
	public void shouldHandleSequanceOfSixAliveCells() {
		// given
		game.makeCellAlive(new Point(1, 2));
		game.makeCellAlive(new Point(1, 3));
		game.makeCellAlive(new Point(2, 0));
		game.makeCellAlive(new Point(2, 1));
		game.makeCellAlive(new Point(2, 2));
		game.makeCellAlive(new Point(3, 3));
		game.nextCycleOfLife();
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(5, aliveCells);
	}
	
	@Test
	public void shouldHandleSequanceOfSixAliveCellsAfterTwoCycles() {
		// given
		game.makeCellAlive(new Point(1, 2));
		game.makeCellAlive(new Point(1, 3));
		game.makeCellAlive(new Point(2, 0));
		game.makeCellAlive(new Point(2, 1));
		game.makeCellAlive(new Point(2,1));
		game.makeCellAlive(new Point(2, 2));
		game.makeCellAlive(new Point(3, 3));
		game.nextCycleOfLife();
		game.nextCycleOfLife();
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(5, aliveCells);
	}
	
	@Test
	public void shouldHandleThreeCellsOnBoardBorderInColumn() {
		// given
		game.makeCellAlive(new Point(0, 0));
		game.makeCellAlive(new Point(1, 0));
		game.makeCellAlive(new Point(2, 0));
		game.nextCycleOfLife();
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(2, aliveCells);
	}
	
	@Test
	public void shouldHandleThreeCellsOnBoardBorder() {
		// given
		game.makeCellAlive(new Point(0, 0));
		game.makeCellAlive(new Point(1, 0));
		game.makeCellAlive(new Point(0, 1));
		game.nextCycleOfLife();
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(4, aliveCells);
	}
	
	@Test
	public void shouldHandleBeaconPatternAfterOneCycle() {
		// given
		int boardDimension = 7;
		GameOfLife game = new GameOfLife(boardDimension);
		game.makeCellAlive(new Point(1, 1));
		game.makeCellAlive(new Point(1, 2));
		game.makeCellAlive(new Point(2, 1));
		game.makeCellAlive(new Point(3, 4));
		game.makeCellAlive(new Point(4, 3));
		game.makeCellAlive(new Point(4, 4));
		game.nextCycleOfLife();
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(8, aliveCells);
	}
	
	@Test
	public void shouldHandleBeaconPatternAfterTwoCycles() {
		// given
		int boardDimension = 7;
		GameOfLife game = new GameOfLife(boardDimension);
		
		game.makeCellAlive(new Point(1, 1));
		game.makeCellAlive(new Point(1, 2));
		game.makeCellAlive(new Point(2, 1));
		game.makeCellAlive(new Point(3, 4));
		game.makeCellAlive(new Point(4, 3));
		game.makeCellAlive(new Point(4, 4));
		game.nextCycleOfLife();
		game.nextCycleOfLife();
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(6, aliveCells);
	}
	
	@Test
	public void shouldHandleDieHardPattern() {
		// given
		int boardDimension = 150;
		GameOfLife game = new GameOfLife(boardDimension);
		game.makeCellAlive(new Point(100, 100));
		game.makeCellAlive(new Point(100, 101));
		game.makeCellAlive(new Point(101, 101));
		game.makeCellAlive(new Point(101, 105));
		game.makeCellAlive(new Point(101, 106));
		game.makeCellAlive(new Point(101, 107));
		game.makeCellAlive(new Point(99, 106));
		for(int i = 0; i < 130; i++){
			game.nextCycleOfLife();
		}
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(0, aliveCells);
	}
	
	@Test
	public void shouldHandleR_PentominoPattern() {
		// given
		int boardDimension = 200;
		GameOfLife game = new GameOfLife(boardDimension);
		game.makeCellAlive(new Point(100, 100));
		game.makeCellAlive(new Point(100, 101));
		game.makeCellAlive(new Point(101, 99));
		game.makeCellAlive(new Point(101, 100));
		game.makeCellAlive(new Point(102, 100));
		for(int i = 0; i < 1103; i++){
			game.nextCycleOfLife();
		}
		// when
		int aliveCells = game.getNumberOfAliveCells();
		// then
		Assert.assertEquals(110, aliveCells);
	}

}
