package component.modifier.changer;

import component.card.Card;
import component.modifier.Modifier;

abstract public class Changer<T> extends Modifier { // I'm not sorry haha

    protected T changeValue;

    public abstract T getChange();
    public abstract void setChange(T changeValue);

    public enum ChangeType {
        NUMBER,
        SUIT,
        MATERIAL
    }

    public ChangeType getChangeType() {
        return changeType;
    }

    protected ChangeType changeType;

    @Override
    public boolean isBlocking() {
        return false;
    }
}
