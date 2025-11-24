public class Position {
    private int x_;
    private int y_;

    public Position(int x, int y) {
        this.x_ = x;
        this.y_ = y;
    }

    public int getX() {
        return x_;
    }
    public int getY() {
        return y_;
    }

    @Override //overrides the Object.equals() method. all classes inherit object class.
    public boolean equals(Object o) {
        if (this == o) return true; // checks if they are the same object in memory

        if (o == null) return false; // checks if the other bject is null

        if (getClass() != o.getClass()) return false; // checks if both are Position objects

        Position p = (Position) o; // casts o to position (it already is)
        return x_ == p.getX() && y_ == p.getY(); //checks if the positions are the same.
    }
}