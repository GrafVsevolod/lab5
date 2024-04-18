package models;

public class Coordinates {
    private static Long x;

    private Double y;

    public Coordinates(Long x, Double y){
        this.x = x;
        this.y = y;
    }

    public Long getX(){
        return x;
    }

    public Double getY(){
        return y;
    }

    public void setX(Long x){
        this.x =  x;
    }

    public void setY(Double y){
        this.y = y;
    }
}
