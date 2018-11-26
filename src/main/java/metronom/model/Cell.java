package metronom.model;

public class Cell {

	private int row;
	private int column;
	private Player assignedPlayer;

	public Cell(int row, int column) {
        this.row = row;
        this.column = column;
    }

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public boolean isPlayerAssigned() {
		return this.assignedPlayer != null;
	}

	public Player getAssignedPlayer() {
		return assignedPlayer;
	}

	public Character getValue() {
		Character result = ' ';
		if (this.assignedPlayer!=null)
			result = this.assignedPlayer.getMarker();
		return result;
	}

	public void setAssignedPlayer(Player assignedPlayer) {
		this.assignedPlayer = assignedPlayer;
	}

	@Override
	public String toString() {
		return (row+1)+","+(column+1);
	}

}
