package engine;

public enum TickPhase {
    MOVEMENT,
    MODIFY;

    private static final TickPhase[] VALUES = values();

    public TickPhase next() {
        return VALUES[(ordinal() + 1) % VALUES.length];
    }
}