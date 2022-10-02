public class Position {
    private int x;
    private int y;

    public Position(){};

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean equals(int a){
        Map map = new Map();
        boolean z = true;
        for(int i = 0;i<map.tDmassiv().length;i++){
            for(int j = 0;j<map.tDmassiv().length;j++){
                if(a==i||a==j){
                    z = true;
                    break;
                }
                else {
                    z = false;
                }
            }
        }
        return z;
    }
}
