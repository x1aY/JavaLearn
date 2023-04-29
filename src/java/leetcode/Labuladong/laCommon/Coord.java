package leetcode.Labuladong.laCommon;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Coord {

    public int x;
    public int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveCoord(Coord coord) {
        this.x += coord.x;
        this.y += coord.y;
    }

    @Override
    public String toString() {
        return "x=" + this.x + ", y=" + this.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Coord coord = (Coord) obj;
        return this.x == coord.x && this.y == coord.y;
    }

    public static void main(String[] args) {
        // 顺时针
        Map<Coord, Coord> clockwiseDirMap = new HashMap<Coord, Coord>() {
            {
                put(new Coord(0, 1), new Coord(1, 0));
                put(new Coord(1, 0), new Coord(0, -1));
                put(new Coord(0, -1), new Coord(-1, 0));
                put(new Coord(-1, 0), new Coord(0, 1));
            }
        };
        System.out.println(clockwiseDirMap.isEmpty());
    }

}