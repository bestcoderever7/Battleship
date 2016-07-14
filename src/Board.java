
public class Board {
	Tile[][] tiles = new Tile[10][10];
	boolean[][] board = new boolean[10][10];
	int shotsFired = 0;
	int hitCount = 0;
	int shipCount = 10;

	public Board() {
		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].length; j++) {
				tiles[i][j] = new Water();
			}
		}
		for (int x = 0; x < tiles.length; x++) {
			for (int y = 0; y < tiles[x].length; y++) {
				tiles[x][y].print(x, y, board);
			}
			System.out.print("\n");
		}
	}

	public boolean isOccupied(int i, int j) {
		if (tiles[i][j] instanceof Ship) {
			return true;
		} else {
			return false;
		}
	}

	public void shootAt(int i, int j) {
		if (isOccupied(i, j) == true) {
			Ship s = (Ship) tiles[i][j];
			if (s.shootAt(i, j) == true) {
				hitCount++;
			}
			if (s.isSunk() == true) {
				shipCount--;
			}
		}
		board[i][j] = true;
		shotsFired++;
	}

	public boolean isGameOver() {
		if (getShipCount() > 0) {
			return false;
		} else {
			return true;
		}

	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public int getShotFired() {
		return shotsFired;
	}

	public void setShotFired(int shotFired) {
		this.shotsFired = shotFired;
	}

	public int getHitCount() {
		return hitCount;
	}

	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}

	public int getShipCount() {
		return shipCount;
	}

	public void setShipCount(int shipCount) {
		this.shipCount = shipCount;
	}
}
