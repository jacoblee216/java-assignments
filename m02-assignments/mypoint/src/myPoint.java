public class myPoint {
    private double x;
    private double y;
    myPoint() {
        x = 0;
        y = 0;
    }
    myPoint(double x, double y) {
        this.x = getX(x);
        this.y = getY(y);
    }
    public double getX(double x) {
        return x;
    }
    public double getY(double y) {
        return y;
    }
    public double distance(myPoint p) {
        return Math.sqrt((x - p.x) * (x - p.x) + (y - p.y) * (y - p.y));
    }
    public double distance(double x, double y) {
        return Math.sqrt((this.x - x) * (this.x - x) + (this.y - y) * (this.y - y));
    }
    public static double distance(myPoint p, myPoint q) {
        return Math.sqrt((p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y));
    }
    public static void main(String[] args) {
        myPoint p1 = new myPoint();
        myPoint p2 = new myPoint(10, 30.5);
        System.out.println(p1.distance(p2));
        System.out.println(p1.distance(10, 30.5));
    }
}
