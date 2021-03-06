package application;

import javafx.scene.Group;

public interface GameObject {
	
	/**
	 * Initializes the object and all relevant variables.
	 */
	public void init();
	
	/**
	 * Updates the object's location and status as the timeline progresses.
	 */
	public void update();
	
	/**
	 * Returns a Group of Nodes representing the object.
	 * @return Object drawing
	 */
	public Group components();
	
}
