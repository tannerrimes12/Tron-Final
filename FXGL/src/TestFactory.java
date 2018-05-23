import com.almasb.fxgl.animation.Interpolators;
import com.almasb.fxgl.app.FXGL;
import com.almasb.fxgl.core.math.FXGLMath;
import com.almasb.fxgl.entity.*;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.entity.components.TimeComponent;
import com.almasb.fxgl.entity.view.EntityView;
import com.almasb.fxgl.extra.entity.components.ExpireCleanComponent;
import com.almasb.fxgl.extra.entity.components.HealthComponent;
import com.almasb.fxgl.extra.entity.components.OffscreenCleanComponent;
import com.almasb.fxgl.extra.entity.components.ProjectileComponent;
import com.almasb.fxgl.extra.entity.effect.EffectComponent;
import com.almasb.fxgl.physics.BoundingShape;
import com.almasb.fxgl.physics.HitBox;
import com.almasb.fxgl.texture.Texture;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.effect.Bloom;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class TestFactory implements EntityFactory
{
	@Spawns("player1")
	public Entity newPlayer(SpawnData data)
	{
		return Entities.builder()
				.type(PlayerType.PLAYER1)
				.from(data)
				.viewFromNode(new Rectangle(50, 50, Color.RED))
				.build();
	}
}
