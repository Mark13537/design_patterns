package structural;

public class Adapter {
    public static void main(String[] args) {
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        hole.fits(rpeg); // true

        SquarePeg small_sqpeg = new SquarePeg(5);
        SquarePeg large_sqpeg = new SquarePeg(10);
        // hole.fits(small_sqpeg); // this won't compile (incompatible types)

        SquarePegAdapter small_sqpeg_adapter = new SquarePegAdapter(small_sqpeg);
        SquarePegAdapter large_sqpeg_adapter = new SquarePegAdapter(large_sqpeg);

        System.out.println(hole.fits(small_sqpeg_adapter)); // true
        System.out.println(hole.fits(large_sqpeg_adapter)); // false
    }
}

class RoundHole {
    private int radius;

    RoundHole(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg) {
        return this.getRadius() >= peg.getRadius();
    }
}

class RoundPeg {
    private int radius;

    RoundPeg(int radius) {
        this.radius = radius;

    }

    public int getRadius() {
        return this.radius;
    }
}

class SquarePeg {
    private int width;

    SquarePeg(int width) {
        this.width = width;
    }

    public int getWidth() {
        return this.width;
    }
}

class SquarePegAdapter extends RoundPeg {

    private SquarePeg peg;

    SquarePegAdapter(SquarePeg peg) {
        super(0); // TODO: proper fix needed here
        this.peg = peg;
    }

    public int getRadius() {
        return (int) (peg.getWidth() * Math.sqrt(2) / 2);
    }

}