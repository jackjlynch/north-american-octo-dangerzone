package com.wharnal.naod.dataobjs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.gushikustudios.rube.loader.serializers.utils.RubeImage;
import com.wharnal.naod.GameWorld;

public class Entity {
    private RubeImage image;
    protected Body physicsObject;
    private Sprite sprite;


    public Entity(RubeImage image) {
        this.image = image;
        physicsObject = image.body;
        sprite = new Sprite(new Texture(Gdx.files.internal(image.file)));
        sprite.setOrigin(sprite.getWidth() / 2 - image.center.x * GameWorld.METERS_TO_PIXELS, sprite.getHeight() / 2 - image.center.y * GameWorld.METERS_TO_PIXELS);
        sprite.scale(- (1 - (image.height * GameWorld.METERS_TO_PIXELS) / sprite.getHeight()));
    }

    public void draw(SpriteBatch batch) {
        sprite.draw(batch);

    }

    public void update() {
        sprite.setPosition((physicsObject.getPosition().x + image.center.x) * GameWorld.METERS_TO_PIXELS  - sprite.getWidth() / 2, (physicsObject.getPosition().y + image.center.y) * GameWorld.METERS_TO_PIXELS - sprite.getHeight() / 2);
        sprite.setRotation((physicsObject.getAngle() + image.angleInRads) / (float) Math.PI * 180);
    }

}
