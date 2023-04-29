package leetcode.CodeCaprice.AA_array.D_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.HashMap;

public class B_SpiralOrder_54 {

    public static Map<Coord, Coord> dirMap = new HashMap<Coord, Coord>() {
        {
            put(new Coord(0, 1), new Coord(1, 0));
            put(new Coord(1, 0), new Coord(0, -1));
            put(new Coord(0, -1), new Coord(-1, 0));
            put(new Coord(-1, 0), new Coord(0, 1));
        }
    };

    private static class Coord {
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
    }

    public static List<Integer> MoveLen(int rows, int cols) {
        List<Integer> moveLen = new ArrayList<>();
        int i = cols, j = rows - 1;
        boolean isOdd = true;
        while (i != 0 && j != 0) {
            if (isOdd)
                moveLen.add(i--);
            else
                moveLen.add(j--);
            isOdd = !isOdd;
        }
        moveLen.add(i != 0 ? i : j);
        return moveLen;
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> elements = new ArrayList<>();
        int rows = matrix.length, cols = matrix[0].length;
        List<Integer> moveLen = MoveLen(rows, cols);

        Coord currCoord = new Coord(0, 0), currDir = new Coord(0, 1);
        for (Integer oneDirLen : moveLen) {
            for (int i = 0; i < oneDirLen; i++) {
                elements.add(matrix[currCoord.x][currCoord.y]);
                if (i + 1 == oneDirLen)
                    currDir = dirMap.get(currDir);
                currCoord.moveCoord(currDir);
            }
        }
        return elements;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        // int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
        System.out.println(spiralOrder(matrix).toString());

    }

}
