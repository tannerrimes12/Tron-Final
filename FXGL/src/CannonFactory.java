import com.almasb.fxgl.entity.EntityFactory;

public class CannonFactory implements EntityFactory {

    @Spawns("cannon")
    public Entity newCannon(SpawnData data) {
        return Entities.builder()
                .type(CannonType.CANNON)
                .from(data)
                .viewFromNode(new Rectangle(70, 30, Color.BLUE))
                .with(new LiftComponent(Duration.seconds(1), 150, true))
                .build();
    }

    @Spawns("bullet")
    public Entity newBullet(SpawnData data) {
        PhysicsComponent physics = new PhysicsComponent();
        physics.setFixtureDef(new FixtureDef().density(0.05f));
        physics.setBodyType(BodyType.DYNAMIC);

        physics.setOnPhysicsInitialized(() -> {
            Point2D mousePosition = FXGL.getInput().getMousePositionWorld();

            physics.setLinearVelocity(mousePosition.subtract(data.getX(), data.getY()).normalize().multiply(800));
        });

        return Entities.builder()
                .type(CannonType.BULLET)
                .from(data)
                .viewFromNodeWithBBox(new Rectangle(25, 25, Color.BLUE))
                .with(physics, new CollidableComponent(true))
                .with(new ExpireCleanComponent(Duration.seconds(4)))
                .build();
    }

    @Spawns("basketBarrier")
    public Entity newBasketBarrier(SpawnData data) {
        return Entities.builder()
                .type(CannonType.BASKET)
                .from(data)
                .viewFromNodeWithBBox(new Rectangle(100, 300, Color.RED))
                .with(new PhysicsComponent())
                .build();
    }

    @Spawns("basketGround")
    public Entity newBasketGround(SpawnData data) {
        return Entities.builder()
                .type(CannonType.BASKET)
                .from(data)
                .viewFromNodeWithBBox(new Rectangle(300, 5, Color.TRANSPARENT))
                .with(new PhysicsComponent(), new CollidableComponent(true))
                .build();
    }
}