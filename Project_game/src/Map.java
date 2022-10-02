import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Map extends Pane {
    private int UNIT;
    private int size;
    private int[][] map;
    private Position start;

    public Map(){}

    public int[][] tDmassiv()/*читает файл и вернет в двумерном массиве*/
    {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        File file = new File("map.txt");
        if(file.exists()){
            try {
                Scanner scanner = new Scanner(new File("map.txt"));
                int i = 0;
                while (scanner.hasNextInt()){
                    arrayList.add(scanner.nextInt());//сохраняет в аррайлисте
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        size =  arrayList.get(0);//принимает первое число как размер карты(размер двумерного массива)
        arrayList.remove(0);//удаляет первое число чтобы получать точный размер карты
        map = new int[size][size];
        for (int i = 0;i<size;i++){
            for (int j = 0;j<size;j++){
                int y = size*i;
                map[i][j] = arrayList.get(y+j);//переобразить аррайлист в двумерный массив
            }
        }
        return map;
    }

    public GridPane takePane()/*заполняет и вернет панель карты*/
    {
        UNIT = 30;
        GridPane gridPane = new GridPane();

        for(int i = 0;i<tDmassiv().length;i++){
            for(int j = 0;j<tDmassiv().length;j++){
                Rectangle r = new Rectangle(UNIT,UNIT);
                if(tDmassiv()[i][j]==1){
                    r.setFill(Color.BLACK);
                }else {
                    r.setFill(Color.WHITE);
                }
                r.setStroke(Color.BLACK);
                gridPane.add(r,j,i);
            }
        }

        return gridPane;
    }

    public int getUNIT(){
        return UNIT;
    }

    public int getSize(){
        return size;
    }

    public int getValueAt(int x,int y){
        return x;
    }

    public Position getStartPosition()/*получает координаты числа 2* как стартовая позиция*/{
        start = new Position();
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(tDmassiv()[i][j]==2){
                    start.setX(i);
                    start.setY(j);
                }
            }
        }
        return start;
    }
}
