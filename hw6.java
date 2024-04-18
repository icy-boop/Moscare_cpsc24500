import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

interface INode {
    void add(INode node) throws IllegalArgumentException;
}

class Node implements INode {
    private int x;
    private int y;

    public Node() {
        this(0, 0);
    }

    public Node(int x, int y) {
        setX(x);
        setY(y);
    }

    public Node(Node node) {
        this(node.getX(), node.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        if (x < -100 || x > 100) {
            throw new IllegalArgumentException("Invalid value for x");
        }
        this.x = x;
    }

    public void setY(int y) {
        if (y < -100 || y > 100) {
            throw new IllegalArgumentException("Invalid value for y");
        }
        this.y = y;
    }

    @Override
    public void add(INode node) throws IllegalArgumentException {
        if (node instanceof Node) {
            Node n = (Node) node;
            setX(getX() + n.getX());
            setY(getY() + n.getY());
        } else {
            throw new IllegalArgumentException("Cannot add different types of nodes");
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node other = (Node) obj;
        return this.x == other.x && this.y == other.y;
    }
}

class ThreeDNode extends Node {
    private int z;

    public ThreeDNode() {
        this(0, 0, 0);
    }

    public ThreeDNode(int x, int y, int z) {
        super(x, y);
        setZ(z);
    }

    public ThreeDNode(ThreeDNode node) {
        this(node.getX(), node.getY(), node.getZ());
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        if (z < -100 || z > 100) {
            throw new IllegalArgumentException("Invalid value for z");
        }
        this.z = z;
    }

    @Override
    public void add(INode node) throws IllegalArgumentException {
        if (node instanceof ThreeDNode) {
            ThreeDNode n = (ThreeDNode) node;
            super.add(n);
            setZ(getZ() + n.getZ());
        } else {
            throw new IllegalArgumentException("Cannot add different types of nodes");
        }
    }

    @Override
    public String toString() {
        return "(" + getX() + ", " + getY() + ", " + z + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ThreeDNode)) {
            return false;
        }
        ThreeDNode other = (ThreeDNode) obj;
        return super.equals(obj) && this.z == other.z;
    }
}

class NodeFactory {
    private static final Random rand = new Random();

    public static Node createRandomNode() {
        return new Node(rand.nextInt(201) - 100, rand.nextInt(201) - 100);
    }

    public static ThreeDNode createRandomThreeDNode() {
        return new ThreeDNode(rand.nextInt(201) - 100, rand.nextInt(201) - 100, rand.nextInt(201) - 100);
    }
}

class Nodes {
    private ArrayList<INode> nodeList;

    public Nodes() {
        nodeList = new ArrayList<>();
    }

    public void fill(int size) {
        nodeList.clear();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            if (rand.nextBoolean()) {
                nodeList.add(NodeFactory.createRandomNode());
            } else {
                nodeList.add(NodeFactory.createRandomThreeDNode());
            }
        }
    }

    public void clear() {
        nodeList.clear();
    }

    public int countNodes() {
        int count = 0;
        for (INode node : nodeList) {
            if (node instanceof Node) {
                count++;
            }
        }
        return count;
    }

    public int countThreeDNodes() {
        int count = 0;
        for (INode node : nodeList) {
            if (node instanceof ThreeDNode) {
                count++;
            }
        }
        return count;
    }

    public void sort() {
        nodeList.sort(new NodeComparator());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (INode node : nodeList) {
            sb.append(node).append("\n");
        }
        return sb.toString();
    }

    private static class NodeComparator implements Comparator<INode> {
        @Override
        public int compare(INode o1, INode o2) {
            int sum1 = sum(o1);
            int sum2 = sum(o2);
            return Integer.compare(sum1, sum2);
        }

        private int sum(INode node) {
            if (node instanceof ThreeDNode) {
                ThreeDNode threeDNode = (ThreeDNode) node;
                return threeDNode.getX() + threeDNode.getY() + threeDNode.getZ();
            } else {
                Node n = (Node) node;
                return n.getX() + n.getY();
            }
        }
    }
}

class Sorter {
    public static void main(String[] args) {
        Nodes nodes = new Nodes();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Fill");
            System.out.println("2. Clear");
            System.out.println("3. Count Nodes");
            System.out.println("4. Count ThreeDNodes");
            System.out.println("5. Sort");
            System.out.println("6. Display");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter size: ");
                    int size = scanner.nextInt();
                    nodes.fill(size);
                    break;
                case 2:
                    nodes.clear();
                    break;
                case 3:
                    System.out.println("Number of Nodes: " + nodes.countNodes());
                    break;
                case 4:
                    System.out.println("Number of ThreeDNodes: " + nodes.countThreeDNodes());
                    break;
                case 5:
                    nodes.sort();
                    break;
                case 6:
                    System.out.println(nodes);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 7);
        scanner.close();
    }
}
