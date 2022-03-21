import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class DiscardPile extends PileOfCards {
	

		  public DiscardPile(int[] xy) {
		    super(xy);
		    isDraggable = true;
		  }

		  public void emptyPile() {
		    deck.clear();
		  }
}
	
