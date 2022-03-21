import java.util.List;

public class faceDownPile extends PileOfCards {
	
	public faceDownPile(int[]xy) {
		
		super(xy);
		
		isDraggable = false;
		
		createANewDeck();
	}
	
	private void createANewDeck() {
		List<String> faceNames = Card.getValidFaceNames();
		for(String faceName : faceNames) {
			
			    	  		deck.add(new Card(faceName));
			
			deck.get(deck.size()-1).setPosition(getPosition());
		}
	}

}
