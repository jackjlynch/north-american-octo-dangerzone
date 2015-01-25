package com.wharnal.naod;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.graphics.GL20;
import com.gushikustudios.rube.RubeScene;
import com.gushikustudios.rube.loader.RubeSceneLoader;
//import com.wharnal.naod.input.AccelerometerInputHandler;
import com.gushikustudios.rube.loader.serializers.utils.RubeImage;
import com.wharnal.naod.dataobjs.Hans;
import com.wharnal.naod.input.HansInputHandler;
import com.wharnal.naod.GameWorld;

public class NaodGame extends ApplicationAdapter {
	private OrthographicCamera camera;
	private OrthographicCamera debugCamera;
	private SpriteBatch batch;
	private World world;
	private GameWorld gameWorld;
	private Box2DDebugRenderer debugRenderer;
//	private AccelerometerInputHandler accelerometerInput;

	@Override
	public void create() {

		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();

		//RubeSceneLoader loader = new RubeSceneLoader();
		//RubeScene scene = loader.loadScene(Gdx.files.internal("maps/trustfall.json"));
		//gameWorld = new GameWorld(scene);

		world = new World(new Vector2(0, -10), true);
		BodyDef hansDef = new BodyDef();
		hansDef.type = BodyDef.BodyType.DynamicBody;
		hansDef.position.set(2f, 10f);
		Body hansBody = world.createBody(hansDef);

		CircleShape hansCircle = new CircleShape();
		hansCircle.setRadius(1);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = hansCircle;
		fixtureDef.density = 0.5f;
		fixtureDef.friction = 0.4f;
		fixtureDef.restitution = 0.6f;

		Fixture hansFixture = hansBody.createFixture(fixtureDef);

		hansCircle.dispose();



		RubeImage hansImage = new RubeImage();
		hansImage.angleInRads = 0;
		hansImage.center.set(1, 5);
		hansImage.file = "images/standinball.png";
		hansImage.body = hansBody;
		Hans hans = new Hans(hansImage);
		gameWorld = new GameWorld(hans);

		camera = new OrthographicCamera(w, h);
		camera.position.set(w / 2, h / 2, 0);
		camera.update();

		w /= GameWorld.METERS_TO_PIXELS;
		h /= GameWorld.METERS_TO_PIXELS;
		debugCamera = new OrthographicCamera(w, h);
		debugCamera.position.set(w / 2, h / 2, 0f);
		debugCamera.update();
		debugRenderer = new Box2DDebugRenderer();

		batch = new SpriteBatch();
		//world = scene.getWorld();

		Gdx.input.setInputProcessor(new HansInputHandler(gameWorld.getHans()));
		//accelerometerInput = new AccelerometerInputHandler(gameWorld.getHans());

	}

	@Override
	public void dispose() {
		batch.dispose();

	}

	@Override
	public void render() {

		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		gameWorld.update();
		gameWorld.draw(batch);

		debugRenderer.render(world, debugCamera.combined);


		world.step(Gdx.graphics.getDeltaTime(), 12, 4); //update physics world
		//accelerometerInput.handleInput();

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
