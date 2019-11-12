import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author banve02
 * 
 *         Given nxn board place n queen on this board so that they dont attack
 *         each other. One solution is to find any placement of queens which do
 *         not attack each other. Other solution is to find all placements of
 *         queen on the board.
 *
 */
public class NQueens {

	public static void main(String[] args) {
		int n = 5;
		nQueensPositions(n);
	}

	private static void nQueensPositions(int n) {
		int row = 0, col = 0;

		Map<Integer, Position> map = new HashMap<>();
		getNQueensPos(row, col, map, n);
		System.out.println(map.values());
	}

	private static boolean getNQueensPos(int row, int col, Map<Integer, Position> map, int n) {
		if (n == row)
			return true;
		
		//Increment the column value if the column is not safe put the queen
		for (; col < n; col++) {
			if (validPosition(row, col, map)) {
				Position pos = new Position(row, col);
//				System.out.println(row + " --MAP-- " + col);
				map.put(row, pos);
				if (getNQueensPos(row + 1, 0, map, n)) {
					return true;
				}
			}
		}
		//Return false so that it moves back to previous row
//		System.out.println("false");
		return false;
	}

	private static boolean validPosition(int row, int col, Map<Integer, Position> map) {
//		System.out.println(row + "  --  " + col);
		boolean validPos = true;
		// Consider only the rows which are less than the current row
		// For each row check col and row positions
		for (int i = 0; i < row; i++) {
			Position pos = map.get(i);
			int r = pos.getRow();
			int c = pos.getCol();
			if (row == r || col == c || row - col == r - c || row + col == r + c) {
				validPos = false;
				break;
			}
		}
		return validPos;
	}
}

class Position {
	int row;
	int col;

	public Position(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public String toString() {
		return "[ " + row + " , " + col + " ]";
	}

}