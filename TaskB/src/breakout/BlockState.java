package breakout;

import breakout.utils.Rect;

/**
 * Represents the state of a block in the breakout.good game.
 *
 * TODO spec
 * @immutable
 * @invar | getLocation() != null
 */
public class BlockState {
	
	/**
	 * TODO spec
	 * @invar | location != null
	 */
	private final Rect location;

	/**
	 * TODO
	 * @pre | location != null
	 * @post | getLocation().equals(location)
	 */
	public BlockState(Rect location) {
		this.location = location;
	}

	/**
	 * TODO
	 * @creates | result
	 */
	public Rect getLocation() {
		return location;
	}
	
}
