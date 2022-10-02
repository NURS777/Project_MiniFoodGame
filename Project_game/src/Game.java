import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class Game extends Application {
    private static Player player;
    private static Food food;
    @Override
    public void start(Stage stage) throws Exception {
        Map map = new Map();
        System.out.println(map.tDmassiv().length);
        GridPane gridPane = map.takePane();
        Circle circle = new Circle(15);
        circle.setFill(Color.RED);
        circle.setStroke(Color.BLACK);

        MyPlayer myPlayer = new MyPlayer(map,circle);
        myPlayer.draw();
        gridPane.getChildren().add(circle);

        Circle circle1 = new Circle(8);
        circle1.setFill(Color.GREEN);
        circle1.setStroke(Color.BLACK);
        Food food = new Food(map,circle1);
        food.createFood();
        gridPane.getChildren().add(circle1);

        Scene scene = new Scene(gridPane);
        AtomicInteger score = new AtomicInteger();
        scene.setOnKeyPressed(keyEvent -> {

                if (keyEvent.getCode() == KeyCode.UP) {
                    myPlayer.moveUp();
                } else if (keyEvent.getCode() == KeyCode.DOWN) {
                    myPlayer.moveDown();
                } else if (keyEvent.getCode() == KeyCode.RIGHT) {
                    myPlayer.moveRight();
                } else if (keyEvent.getCode() == KeyCode.LEFT) {
                    myPlayer.moveLeft();
                }
            if(GridPane.getColumnIndex(circle1)==GridPane.getColumnIndex(circle)&&
                    GridPane.getRowIndex(circle1)==GridPane.getRowIndex(circle)){
                score.set(score.get() + 1);
                food.createFood();
                gridPane.getChildren().add(circle1);
                if(score.get()==5){
                    food.remove();
                    gridPane.getChildren().remove(circle1);
                    System.out.println(score);
                }
            };
        });

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
