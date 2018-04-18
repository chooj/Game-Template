package application;
	
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;


public class Main extends Application {
	
	public static Scene scene;
	public static Pane pane;
	public static int width = 600, height = 600;
	public static boolean mousePressed = false, mouseReleased = false, keyPressed = false, keyReleased = false;
	public static boolean[] keyHeld = new boolean[222];
	public static double mouseX = -1.0, mouseY = -1.0;
	
	@Override
	public void start(Stage stage) {
		pane = new Pane();
		scene = new Scene(pane, width, height, true, SceneAntialiasing.BALANCED);
		scene.setFill(Color.WHITE);
		stage.setScene(scene);
		stage.show();
		//
		initialize();
		//
		runAnimation();
	}
	
	public static void initialize() {
	}
	
	public static void draw() {
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Infinitely loops through the draw and utilities methods.
	 */
	public static void runAnimation() {
		EventHandler<ActionEvent> eh = new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				updateUtilities();
				draw();
				updateReleased();
			}
		};
		Timeline tl = new Timeline(new KeyFrame(Duration.ONE, eh));
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.play();
	}
	
	/**
	 * Updates all mouse variables and all key variables.
	 */
	public static void updateUtilities() {
		scene.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				mousePressed = true;
			}
		});
		scene.setOnMouseMoved(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				mouseX = t.getSceneX();
				mouseY = t.getSceneY();
			}
		});
		scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				mouseX = t.getSceneX();
				mouseY = t.getSceneY();
			}
		});
		scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				mousePressed = false;
				mouseReleased = true;
			}
		});
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent t) {
				keyPressed = true;
				keyHeld[t.getCode().getCode() - 1] = true;
			}
		});
		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent t) {
				keyPressed = false;
				keyReleased = true;
				keyHeld[t.getCode().getCode() - 1] = false;
			}
		});
	}
	
	/**
	 * Sets mouseReleased and keyReleased to false at the end of each loop.
	 */
	public static void updateReleased() {
		mouseReleased = false;
		keyReleased = false;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
