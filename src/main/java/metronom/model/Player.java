package metronom.model;

public class Player {

	private Character marker;
	private boolean isHuman;


	public Player(Character marker, boolean isHuman) {
		this.marker = marker;
		this.isHuman = isHuman;
	}

	public Character getMarker() {
		return marker;
	}

	public boolean isHuman() {
		return isHuman;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return marker != null ? marker.equals(player.marker) : player.marker == null;
    }

}
