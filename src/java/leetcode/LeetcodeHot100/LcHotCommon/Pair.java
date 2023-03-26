package leetcode.LeetcodeHot100.LcHotCommon;

import java.util.Objects;

public class Pair<T> {

    public T x;
    public T y;

    public Pair(T x, T y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "x=" + this.x.toString() + ", y=" + this.y.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Pair<T> pair = (Pair<T>) obj;
        return this.x.equals(pair.x) && this.y.equals(pair.y);
    }

    public static void main(String[] args) {
        Pair<Integer> pair = new Pair<>(0, 0);
        System.out.println(pair.x);
    }

}
