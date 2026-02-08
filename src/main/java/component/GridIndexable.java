package component;

import java.awt.*;

public interface GridIndexable {

    Point getGridPos();
    void setGridPos(Point gridPos);

    boolean isBlocking(); // This varies between classes
}
