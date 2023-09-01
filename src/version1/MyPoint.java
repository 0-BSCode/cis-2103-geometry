/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package version1;

/**
 *
 * @author User
 */
public class MyPoint {
    private int x;
    private int y;

    public MyPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public double getDistance(MyPoint p) {
        double x_dist = Math.pow(p.x - this.x, 2);
        double y_dist = Math.pow(p.y - this.y, 2);
        double dist = Math.sqrt(x_dist + y_dist);
        return dist;
    }
   
    public double getDistance(int x, int y) {
        double x_dist = Math.pow(x - this.x, 2);
        double y_dist = Math.pow(y - this.y, 2);
        double dist = Math.sqrt(x_dist + y_dist);
        return dist;
    }

    public double getDistance() {
        double x_dist = Math.pow(this.x, 2);
        double y_dist = Math.pow(this.y, 2);
        double dist = Math.sqrt(x_dist + y_dist);
        return dist;
    }
    
    /*
    * 0 - Origin
    * 1 - Quadrant 1
    * 2 - Quadrant 2
    * 3 - Quadrant 3
    * 4 - Quadrant 4
    * 5 - X-Axis
    * 6 - Y-Axis
    */
    public int getQuadrant() {
        int res = 0;
        
        if (this.x > 0) {
            if (this.y > 0) {
                res = 1;
            } else if (this.y < 0) {
                res = 4;
            } else {
                res = 6;
            }
        } else if (this.x < 0) {
            if (this.y > 0) {
                res = 2;
            } else if (this.y < 0) {
                res = 3;
            } else {
                res = 6;
            }
        } else {
            if (this.y != 0) {
                res = 5;
            }
        }
        
        return res;
    }
    
    public double getAngle() {
        double x_coord = Math.abs(this.x);
        double y_coord = Math.abs(this.y);
        double angle = Math.toDegrees(Math.atan(y_coord / x_coord));

        switch (this.getQuadrant()) {
            case 2:
                angle += 90;
                break;
            case 3:
                angle += 180;
                break;
            case 4:
                angle += 270;
                break;
            case 5:
                angle = this.x > 0.0 ? 0.0 : 180.0;
                break;
            case 6:
                angle = this.y > 0.0 ? 90.0 : 180.0;
                break;
        }
        
        return angle;
    }
    
    public void displayPoint() {
        String msg = String.format("(%d,%d)\n", this.x, this.y);
        System.out.println(msg);
    }
    
    @Override
    public String toString() {
        String msg = String.format("(x,y): (%d,%d)", this.x, this.y);
        return msg;
    }
}
