package it.unibo.game.app.model.dynamic;

import java.util.Optional;

import it.unibo.game.app.api.Brick;
import it.unibo.game.app.api.BrickType;
import it.unibo.game.app.api.Level;
import it.unibo.game.app.api.MovingObject;
import it.unibo.game.app.api.BoundingBox.Corner;
import it.unibo.game.app.api.BoundingBox.Side;
import it.unibo.game.app.model.ball.*;
import it.unibo.game.app.model.pad.Pad;
import it.unibo.game.app.model.CircleBoundingBox;
import it.unibo.game.app.model.RectBoundingBox;

public class Collision {
    private Level level;

    public Collision(Level lev){
        this.level = lev;
    }
    public void CollideWithEdges(MovingObject b, Double h, Double w){
        b.setBoundingBox(new CircleBoundingBox(b));
        if(b.getBoundingBox().getBox().get(Corner.LEFT_DOWN).getX() <= 0.5 ||b.getBoundingBox().getBox().get(Corner.RIGHT_DOWN).getX() >= w-1){
            b.getPhysics().changeDirection(Side.LEFT_RIGHT);
        }
         if(b.getBoundingBox().getBox().get(Corner.LEFT_UP).getY() <= 0.5 ){
            b.getPhysics().changeDirection(Side.UP_DOWN);
        }
    }

    public Optional<Integer> collideWithBrick(MovingObject b){
			b.setBoundingBox(new CircleBoundingBox(b));
        for (Brick obj : level.getRound().getBrick()) {
					obj.setBoundingBox(new RectBoundingBox(b));
           var opt = b.getBoundingBox().collideWith(obj.getBoundingBox());
            
            if(opt.isPresent()){
                if(obj.getType()==BrickType.NORMAL){
                       this.level.getScore().increaseScore();
                }else{
                    this.level.getScore().resetPoints();
                }
                b.getPhysics().changeDirection(opt.get());
                return Optional.of(level.getRound().getBrick().indexOf(obj));
            }
        }
        return Optional.empty();
    }

    public boolean CollideWithPad (MovingObject b, MovingObject p){
			b.setBoundingBox(new CircleBoundingBox(b));
        p.setBoundingBox(new RectBoundingBox(p));
        if(b.getBoundingBox().collideWith(p.getBoundingBox()).equals(Optional.of(Side.UP_DOWN))) {

            b.getPhysics().changeDirection(Side.UP_DOWN);
            return true;
        }
        return false;
    }
   
    public int getScore(){
        return this.level.getScore().getScore();
    }
}
