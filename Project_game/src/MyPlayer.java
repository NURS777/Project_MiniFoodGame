import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

public class MyPlayer implements Player{
    private Circle ball;
    public Map map;
    private GridPane gridPane;
    private Position position;

    public MyPlayer(Map map,Circle circle) {
        this.map = map;
        this.ball = circle;
        gridPane = map.takePane();
        position = new Position(map.getStartPosition().getX(),map.getStartPosition().getY());
    }

    @Override
    public void moveRight() {
        if(position.equals(position.getX()+1)&&map.tDmassiv()[position.getY()][position.getX()+1]!=1){
            position.setX(position.getX()+1);
            GridPane.setColumnIndex(ball,position.getX());}
        else {
            System.out.println("Invalid position");
        }
    }

    @Override
    public void moveLeft() {
        if(position.equals(position.getX()-1)&&map.tDmassiv()[position.getY()][position.getX()-1]!=1){
            position.setX(position.getX()-1);
            GridPane.setColumnIndex(ball,position.getX());
            GridPane.setRowIndex(ball,position.getY());}
        else {
            System.out.println("Invalid position");
        }
    }

    @Override
    public void moveUp() {
        if(position.equals(position.getY()-1)&&map.tDmassiv()[getPosition().getY()-1][getPosition().getX()]!=1){
            position.setY(position.getY()-1);
            GridPane.setRowIndex(ball,position.getY());}
        else {
            System.out.println("Invalid position");
        }
    }

    @Override
    public void moveDown() {
        if(position.equals(position.getY()+1)&&map.tDmassiv()[getPosition().getY()+1][getPosition().getX()]!=1){
            position.setY(position.getY()+1);
            GridPane.setRowIndex(ball,position.getY());
        }
        else {
            System.out.println("Invalid position");
        }
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    public void setPosition(int x,int y) {
        this.position.setX(x);
        this.position.setY(y);
    }

    public void draw(){
        gridPane.add(ball,position.getX(),position.getY());
    }
    public void remove(){
        gridPane.getChildren().remove(ball);
    }
}
