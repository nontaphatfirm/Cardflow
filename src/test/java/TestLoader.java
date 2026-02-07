import static org.junit.jupiter.api.Assertions.*;

import component.level.LevelData;
import logic.LevelLoader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestLoader {

    @Test
    void testLoadLevel() {
        System.out.println("Loading level");

        assertDoesNotThrow(() -> {
            LevelData levelData = LevelLoader.loadLevel(1);
            System.out.println(levelData);
        });

        assertThrows(Exception.class, () -> {
            LevelData levelData = LevelLoader.loadLevel(-1);
        });
    }



}
