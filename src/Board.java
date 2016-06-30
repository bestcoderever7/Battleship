
public class Board {
	Tile[][] tiles = new Tile[10][10];
	int shotFired;
	int hitCount;
	int shipCount;
	public Board()
	{
		for(int i = 0; i < tiles.length; i++)
		{
			for(int j = 0; j < tiles[i].length; j++)
			{
				tiles[i][j] = new Water();
			}
		}
		for(int x = 0; x < tiles.length; x++)
		{
			for(int y = 0; y < tiles[x].length; y++)
			{
				tiles[x][y].print();
			}
			System.out.print("\n");
		}
	}
	public Tile[][] getTiles() {
		return tiles;
	}
	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}
	public int getShotFired() {
		return shotFired;
	}
	public void setShotFired(int shotFired) {
		this.shotFired = shotFired;
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
