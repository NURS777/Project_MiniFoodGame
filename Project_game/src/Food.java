// IntelliJ API Decompiler stub source generated from a class file
// Implementation of methods is not available

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Food {
    private Timeline timeline;
    private Map map;
    private javafx.scene.layout.Pane foodPane;
    private Player player;
    private javafx.scene.shape.Circle circle;
    private Position foodPosition;
    private javafx.scene.control.Label seconds;
    private final int timer = 5;
    private int numOfCircles;
    private Integer time;
    private int points;
    private int size;

    public Food(Map map, Circle circle) {
        this.map = map;
        this.circle = circle;
        foodPosition = map.getStartPosition();
        circle.setTranslateX(5);
    }

    public int getPoints() {
        return points;
    }

    public void getPos(){
        int randomX = (int) (Math.random() * 6);
        int randomY = (int) (Math.random() * 6);
        if(map.tDmassiv()[randomX][randomY]==0){
            foodPosition.setX(randomX);
            foodPosition.setY(randomY);
        }else {
            foodPosition = getPosition();
        }
    }

    public Position getPosition() {
        int randomX = (int) (Math.random() * 6);
        int randomY = (int) (Math.random() * 6);
        if(map.tDmassiv()[randomX][randomY]==1){
            foodPosition.setX(randomX);
            foodPosition.setY(randomY);
        }else {
            getPos();
        }

        return foodPosition;
    }

    public void createFood() {


        map.takePane().add(circle,getPosition().getX(),getPosition().getY());
        Thread tr = new Thread();
        seconds = new Label();
        seconds.setStyle("-fx-font-size: 4px;");
        seconds.setTextFill(Color.BLACK);
        foodPane = new Pane(circle);
        map.takePane().add(foodPane,getPosition().getX(),getPosition().getY());
    }

    public void setTimer() {
        if (timeline != null) {
            timeline.stop();
        }
        time = timer;

        // update timerLabel
        seconds.setText(time.toString());
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(1),
                        new EventHandler() {
                            @Override
                            public void handle(Event event) {
                                time--;
                                // update timerLabel
                                seconds.setText(
                                        time.toString());
                                if (time <= 0) {
                                    timeline.stop();
                                    remove();
                                }
                            }
                        }));
        timeline.playFromStart();
    }

    public void remove(){
        map.takePane().getChildren().remove(getPosition().getX(),getPosition().getY());
    }
}
