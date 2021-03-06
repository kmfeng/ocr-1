package ocr.info;

import java.io.Serializable;

/**
 * Representation of a Grid
 *
 * @author Jonathan Reimels
 * @version 1.0.0
 */
public class Grid implements Serializable {
	/**
	 * generated Serial Version UID
	 */
	private static final long serialVersionUID = 5568527630676326642L;

	// instance variables
	private boolean[][] _grid;
	private int _size = Constants.GRID_SIZE;

	/**
	 * Constructor - Set the size of the grid (grids are square, the size of a single side)
	 * @param size
	 */
	public Grid(int size) {
		_size = size;
		_grid = new boolean[_size][_size];
		clear();
	}

	/**
	 * Get the size of the grid (grids are square, the size of a single side)
	 * @return size
	 */
	public int getSize() {
		return _size;
	}

	/**
	 * Clone the current instance
	 */
	@Override
	public Grid clone() {
		Grid grid = new Grid(_size);
		for (int row = 0; row < _size; row++) {
			for (int col = 0; col < _size; col++) {
				Coordinate coord = new Coordinate(row, col);
				try {
					grid.setValue(coord, _grid[row][col]);
				} catch (Exception ex) {
					grid = null;
				}
			}
		}
		return grid;
	}

	/**
	 * Get the value of a coordinate
	 * @param coord - The coordinate to get
	 * @return boolean value of coordinate
	 * @throws Exception
	 */
	public boolean getValue(Coordinate coord) throws Exception {
		// check that coordinate is within the grid
		if (coord.getRow() < 0 || coord.getRow() >= _size || coord.getCol() < 0 || coord.getCol() >= _size) {
			throw new Exception("Invalid row or col number");
		}

		// return the value at the coordinate
		return _grid[coord.getRow()][coord.getCol()];
	}

	/**
	 * Set the value at a coordinate
	 * @param coord - The coordinate to set
	 * @param value - The boolean value to set
	 * @throws Exception
	 */
	public void setValue(Coordinate coord, boolean value) throws Exception {
		// set value at coordinate
		_grid[coord.getRow()][coord.getCol()] = value;
	}

	/**
	 * Clear all values in grid
	 */
	public void clear() {
		for (int i = 0; i < _size; i++) {
			for (int j = 0; j < _size; j++) {
				_grid[i][j] = false;
			}
		}
	}
}

