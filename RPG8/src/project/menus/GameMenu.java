package project.menus;


import project.directors.Game;
import project.menus.selections.NewGameSelection;

public class GameMenu extends VerticalMenu{


	public static final int SELECTION_HEIGHT = 200;
	
	
	public GameMenu(int width, int height, Game game) {
		super(width, height);
		NewGameSelection ngs = new NewGameSelection(width, SELECTION_HEIGHT, game);
		selections.add(0,ngs);
		NewGameSelection ngs2 = new NewGameSelection(width, SELECTION_HEIGHT, game);
		selections.add(1,ngs2);
		selections.get(selectIndex).setSelect(true);
	}

	@Override
	public void addSelections() {
		
		
	}


}
