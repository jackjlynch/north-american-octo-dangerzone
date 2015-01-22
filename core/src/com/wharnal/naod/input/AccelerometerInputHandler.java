package com.wharnal.naod.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.wharnal.naod.dataobjs.Hans;

public class AccelerometerInputHandler {
    private Hans hans;

    public AccelerometerInputHandler(Hans hans) {
        this.hans = hans;
    }

    public void handleInput() {
        hans.setAccelerationForce(new Vector2(Gdx.input.getAccelerometerY(), - Gdx.input.getAccelerometerX()));
    }

}