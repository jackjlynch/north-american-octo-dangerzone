package com.wharnal.naod;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Array;
import com.gushikustudios.rube.RubeScene;
import com.gushikustudios.rube.loader.serializers.utils.RubeImage;
import com.wharnal.naod.dataobjs.Entity;
import com.wharnal.naod.dataobjs.Hans;

public class GameWorld {
    private Array<Entity> entities;
    private RubeScene scene;
    private Hans hans;
    public static final int METERS_TO_PIXELS = 64;

    GameWorld(RubeScene scene) {
        this.scene = scene;
        entities = new Array<Entity>();

        if(scene.getImages() !=  null)
            for(RubeImage r : scene.getImages()) {
                r.file = r.file.substring(r.file.indexOf("images"));
                if(r.name.matches("hans")) {
                    hans = new Hans(r);
                    entities.add(hans);
                }
                else
                    entities.add(new Entity(r));
            }
    }

    GameWorld(Hans hans) {
        this.hans = hans;
        entities = new Array<Entity>();
        entities.add(hans);
    }

    public void update() {
        for(Entity e : entities)
            e.update();
    }

    public void createEntity(Texture sprite, Body physicsObject) {
    }

    public void draw(SpriteBatch batch) {
        batch.begin();
        for(Entity e : entities) { //draw sprites
            e.draw(batch);
        }
        batch.end();
    }

    public Hans getHans() {
        return hans;
    }

    //public boolean isOnGround(Entity entity) {

    //}

}
