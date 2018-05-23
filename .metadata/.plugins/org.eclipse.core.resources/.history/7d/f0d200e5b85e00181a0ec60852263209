import java.time.Duration;
import java.util.ResourceBundle.Control;

import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.components.PositionComponent;
import com.almasb.fxgl.entity.components.TypeComponent;
import com.sun.javafx.geom.Point2D;

public class PlayerControl extends Control {

    private PositionComponent position;
    private int maxBombs = 1;
    private int bombsPlaced = 0;

    public void moveRight() {
        if (canMove(new Point2D(40, 0)))
            position.translateX(TronApp.TILE_SIZE);
    }

    public void moveLeft() {
        if (canMove(new Point2D(-40, 0)))
            position.translateX(TronApp.TILE_SIZE);
    }

    public void moveUp() {
        if (canMove(new Point2D(0, -40)))
            position.translateY(TronApp.TILE_SIZE);
    }

    public void moveDown() {
        if (canMove(new Point2D(0, 40)))
            position.translateY(TronApp.TILE_SIZE);
    }

    private boolean canMove(Point2D direction) {
        Point2D newPosition = position.getValue().add(direction);

        return FXGL.getApp()
                .getGameScene()
                .getViewport()
                .getVisibleArea()
                .contains(newPosition)

                &&

                FXGL.getApp()
                        .getGameWorld()
                        .getEntitiesAt(newPosition)
                        .stream()
                        .filter(e -> e.hasComponent(TypeComponent.class))
                        .map(e -> e.getComponent(TypeComponent.class))
                        .noneMatch(type -> type.isType(BombermanType.BRICK)
                                || type.isType(BombermanType.WALL)
                                || type.isType(BombermanType.BOMB));
    }
}