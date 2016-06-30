
public class Water extends Tile {
	boolean hit = false;

	public void print() {
		if (hit == false) {
			System.out.print("- ");
		} else {
			System.out.print(". ");
		}
	}

	public boolean shootAt() {
		hit = true;
		return true;
	}
}
