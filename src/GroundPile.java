import java.awt.Graphics;

public class GroundPile extends PileOfCards {

	public GroundPile(int[]xy) {
		
		super(xy);
		
		isDraggable = true;
	}
	
	@Override
	public boolean CanCardBeAdded(int x) {
		
		return deck.size() == 0;
		
	}
	
	
}
