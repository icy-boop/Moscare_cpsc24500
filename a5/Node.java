package a5;

    /**
     * a class called Node, which represents a node in the xy-coordinate.
     * Sets x and y to zero.
     * 3 constructors
     */
public class Node {
    private static final int MIN_VALUE = -100;
    private static final int MAX_VALUE = 100;
    
    private int x;
    private int y;

    public Node() {
        this(0, 0);
    }

    /**
     * Constructor with x and y coordinates.
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @throws IllegalArgumentException if x or y is out of range.
     */
    public Node(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Copy constructor.
     * @param other The node to copy.
     */
    public Node(Node other) {
        this(other.x, other.y);
    }

    /**
     * Setters and getters
     */
    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < MIN_VALUE || x > MAX_VALUE) {
            throw new IllegalArgumentException("X coordinate must be in the range [-100, 100]");
        }
        this.x = x;
    }
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate.
     * @param y The new y coordinate.
     * @throws IllegalArgumentException if y is out of range.
     */
    public void setY(int y) {
        if (y < MIN_VALUE || y > MAX_VALUE) {
            throw new IllegalArgumentException("Y coordinate must be in the range [-100, 100]");
        }
        this.y = y;
    }

    /**
     * Adds a given node to the caller node.
     */
    public void add(Node other) {
        int newX = this.x + other.x;
        int newY = this.y + other.y;
        if (newX < MIN_VALUE || newX > MAX_VALUE || newY < MIN_VALUE || newY > MAX_VALUE) {
            throw new IllegalArgumentException("Resulting coordinates are out of range.");
        }
        this.x = newX;
        this.y = newY;
    }

    /**
     * Overrides toString method to return a string that represents the Node.
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Overrides equals method to check for nodes equality.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Node)) return false;
        Node other = (Node) obj;
        return this.x == other.x && this.y == other.y;
    }
}
