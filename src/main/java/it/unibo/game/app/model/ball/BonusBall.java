package it.unibo.game.app.model.ball;

import it.unibo.game.Pair;
import it.unibo.game.app.api.Physics;
import it.unibo.game.app.model.GameObjectImpl;
import it.unibo.game.app.api.MovingObject;

public class BonusBall extends GameObjectImpl implements MovingObject{

    private Physics bonusBallPhysics;
    private int height;
    private int width;
    private int radius;

    public BonusBall(Pair<Double,Double> coord, int h, int w, int r) {
        this.height = h;
        this.width = w;
        this.radius = r;
        this.setPos(centerCalculate(coord));        
    }
    private Pair<Double,Double> centerCalculate(Pair<Double,Double> c) {
        return new Pair<Double,Double>(c.getX() + (this.height/2), c.getY() + (this.width/2));
    }
    public int gerRadius() {
        return this.radius;
    }

    @Override
    public Physics getPhysics() {
        throw new UnsupportedOperationException("Unimplemented method 'getPhysics'");
    }
    
}