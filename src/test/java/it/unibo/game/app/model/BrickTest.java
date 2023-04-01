package it.unibo.game.app.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.model.levels.ThirdLevel;

public class BrickTest {

  @Test
  void testObstacle() {
    Level l = new ThirdLevel();
    int maxRes = l.getRound().getBrick().stream().filter(x -> x.getRes().isPresent())
        .mapToInt(x -> x.getRes().get()).max().getAsInt();
    long obstacles = l.getRound().getBrick().stream()
        .filter(x -> x.getType().equals(BrickType.OBSTACLE)).count();
    int i = 0;
    Iterator<Brick> it;
    while (i < maxRes) {
      it = l.getRound().getBrick().iterator();
      while (it.hasNext()) {
        Brick b = it.next();
        b.hit();
        if (b.isDestroyed()) {
          it.remove();
        }
      }
      i++;
    }
    assertTrue(l.getRound().getBrick().size() == (int) obstacles && l.getRound()
        .getBrick().stream().allMatch(x -> x.getType().equals(BrickType.OBSTACLE)));

  }
}