public class comparableCircle extends Circle implements Comparable<Circle> {
    public int compareTo(Circle c) {
        if (getRadius() > c.getRadius()) {
            return 1;
        } else if (getRadius() < c.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    } 
    public int equals(Circle c) {
        if (getRadius() == c.getRadius()) {
            return 1;
        } else {
            return 0;
        }
    }
}
