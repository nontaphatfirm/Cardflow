package application.view;

import javafx.scene.layout.StackPane;

public abstract class View {

    protected StackPane root;

    public StackPane getRoot() { return root; }
    public void setRoot(StackPane root) { this.root = root; }

    public View() {
        setRoot(new StackPane());
    }

}
