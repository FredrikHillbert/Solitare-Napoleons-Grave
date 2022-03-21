import java.awt.Color;
import java.awt.Graphics;

public class SavePile extends PileOfCards{
	
	
public SavePile(int[]xy) {
	super(xy);
	cardValueAllowed = 6;
	isDraggable = true;
}


@Override
public void paintComponent(Graphics g) {
	if(deck.size() == 0) {
		g.setColor(Color.ORANGE.darker());
		g.fillRect(x, y, width, height);
		
	} else {
		for(Card currentCard : deck) {
			currentCard.paintComponent(g);
		}
	}
}
}
