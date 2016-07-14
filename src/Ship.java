
public abstract class Ship extends Tile {
	int shipRow;
	int shipCol;
	int length;
	boolean horizontal;
	boolean[] hits = new boolean[length];

	public boolean shootAt(int x, int y) {
		if (horizontal == true) {
			if (x != shipRow) {
				return false;
			} else {
				int distance = y - shipCol;
				if (distance > -1 && distance < (length + 1)) {
					hits[distance] = true;
					return true;
				} else {
					return false;
				}
			}
		} else {
			if (y != shipCol) {
				return false;
			} else {
				int distance = x - shipRow;
				if (distance > -1 && distance < (length + 1)) {
					hits[distance] = true;
					return true;
				} else {
					return false;
				}
			}
		}
	}

	public boolean isSunk() {
		int index = -1;
		for (boolean b : hits) {
			index++;
			if (b == false) {
				break;
			}
			if (index == hits.length - 1) {
				return true;
			}
		}
		return false;
	}

	public boolean okToPlaceShipAt(int i, int j, boolean isHorizontal, Board board) {
		boolean okay = true;
		if (isHorizontal == true) {
			for (int k = 0; k < getLength() - 1; k++) {
				if (board.isOccupied(i, j + k) == true) {
					okay = false;
				}
			}
		} else {
			for (int k = 0; k < getLength() - 1; k++) {
				if (board.isOccupied(i + k, j) == true) {
					okay = false;
				}
			}
		}
		return okay;
	}

	public void placeShipAt(int i, int j, boolean isHorizontal, Board board) {
		if (isHorizontal == true) {
			for (int k = 0; k < getLength() - 1; k++) {
				board.getTiles()[i][j + k] = this;
			}
		} else {
			for (int k = 0; k < getLength() - 1; k++) {
				board.getTiles()[i + k][j] = this;
			}
		}
		setShipCol(j);
		setShipRow(i);
		setHorizontal(isHorizontal);
	}

	public void print(int x, int y, boolean[][] board) {
		// if(horizontal == true)
		// {
		// int distance = x - shipRow;
		// if(hits[distance] == true)
		// {
		//
		// }
		// }
		if (board[x][y] == false) {
			System.out.println(". ");
		} else {
			if (isSunk() == false) {
				System.out.println("S ");
			} else {
				System.out.println("X ");
			}
		}
	}

	public abstract boolean shipType();

	public boolean[] getHits() {
		return hits;
	}

	public void setHits(boolean[] hits) {
		this.hits = hits;
	}

	public int getShipRow() {
		return shipRow;
	}

	public void setShipRow(int shipRow) {
		this.shipRow = shipRow;
	}

	public int getShipCol() {
		return shipCol;
	}

	public void setShipCol(int shipCol) {
		this.shipCol = shipCol;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public boolean isHorizontal() {
		return horizontal;
	}

	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
}
