import java.awt.Color;
import java.awt.Graphics;

public class TheSixPile extends PileOfCards {

	
	public TheSixPile(int[]xy) {
		super(xy);
		cardValueAllowed = 6;
	}
	
	@Override
	public void alterDeckValue() {
		
		if(cardValueAllowed == 1) {
			cardValueAllowed = 6;
			
		}
		else {
			cardValueAllowed--;
		}
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if(deck.size() == 0) {
			g.setColor(Color.RED.darker());
			g.fillRect(x, y, width, height);
			
		} else {
			for(Card currentCard : deck) {
				currentCard.paintComponent(g);
			}
		}
	}
	
	
}
