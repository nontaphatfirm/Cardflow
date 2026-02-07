package component.level;

import component.card.Card;

import java.util.List;


public class LevelData {

    public final int width;
    public final int height;
    public final String levelName;

    public final List<Card> inputCards;
    public final List<Card> outputCards;

    private LevelTile[][] grid;

    public LevelTile[][] getGrid() {
        return grid;
    }

    public void setGrid(LevelTile[][] grid) {
        this.grid = grid;
    }

    public LevelData(
            String levelName,
            int width,
            int height,
            List<Card> inputCards,
            List<Card> outputCards,
            LevelTile[][] grid
    ) {
        this.levelName = levelName;
        this.width = width;
        this.height = height;
        this.inputCards = inputCards;
        this.outputCards = outputCards;
        this.grid = new LevelTile[1][1]; // Default initialize
    }

    @Override
    public String toString() {
        return  "Level: " + levelName
                + "\nwidth: "
                + width
                + "\nheight: "
                + height
                + "\ninputCards: "
                + inputCards
                + "\noutputCards: "
                + outputCards;
    }
}
