package com.wharnal.naod.dataobjs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.TimeUtils;
import com.gushikustudios.rube.loader.serializers.utils.RubeImage;

public class Hans extends Entity {
    private Vector2 accelerationForce;
    private Vector2 jumpForce;
    private boolean aDown;
    private boolean dDown;
    private boolean jump;
    private long jumpTime;
    private double MAX_JUMP_TIME = 500;

    public Hans(RubeImage image) {
        super(image);
        accelerationForce = new Vector2(0, 0);
        jumpForce = new Vector2(0, (float) 500);
    }

    public void update() {
        super.update();
        //physicsObject.applyForce(accelerationForce, physicsObject.getPosition(), true);

        //jump(); used for jumping farther when you hold the key in conjunction with startJump()
    }


    public void jump() {
        //boolean onGround = false;

        physicsObject.applyForce(jumpForce, physicsObject.getPosition(), true);
    }
/*
 * 
 * for jumping longer when you hold down the key
 * 
	public void startJump(boolean jump) {
		this.jump = jump;
		if(jump) {
			jumpTime  = TimeUtils.millis();
		}
	}
	
	public void jump() {
		if(jump) {
			if (TimeUtils.millis() - jumpTime <= MAX_JUMP_TIME) {
				physicsObject.applyForce(jumpForce.scl(1), physicsObject.getPosition(), true);
				System.out.println("jumping");
				System.out.println(physicsObject.getLinearVelocity().y);
			}
			else {
				jump = false;
			}
		}
	}
	*/

    public void setAccelerationForce(Vector2 accelerationForce) {
        this.accelerationForce = accelerationForce;
    }

    public void move(double direction) {
        accelerationForce.x += direction;
    }


}
