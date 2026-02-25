package logic.movement;

import component.card.Card;
import util.GridPos;

public record CardMovement(
        Card card,
        GridPos from,
        GridPos to
) {}