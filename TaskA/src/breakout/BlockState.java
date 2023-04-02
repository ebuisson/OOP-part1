package breakout;

import breakout.utils.Rect;

/**
 * Represents the state of a block in the breakout.good game.
 *
 * @immutable
 * @invar | getLocation() != null
 */
public class BlockState {
	
	/**
	 * @invar | location != null
	 */
	private final Rect location;

	/**
	 * @pre | location != null
	 * @post | getLocation().equals(location)
	 */
	public BlockState(Rect location) {
		this.location = location;
	}

	/**
	 * @creates | result
	 */
	public Rect getLocation() {
		return location;
	}
	
}
