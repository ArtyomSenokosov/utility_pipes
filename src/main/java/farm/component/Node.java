package main.java.farm.component;

import java.util.Comparator;
import java.util.Objects;

public class Node implements Comparable<Node>, Comparator<Node> {

    public int flag;
    public int distance;
    public Node hub;
    public Node parent;
    public boolean isUndecided = false;

    public Node(int flag, int distance) {
        this.flag = flag;
        this.distance = distance;
    }

    public Node(int flag, int distance, Node hub, Node parent) {
        this.flag = flag;
        this.distance = distance;
        this.hub = hub;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Node node = (Node) object;
        return flag == node.flag &&
                distance == node.distance &&
                Objects.equals(hub, node.hub) &&
                Objects.equals(parent, node.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flag, distance, hub, parent);
    }

    @Override
    public int compare(Node objectOne, Node objectTwo) {
        return Integer.compare(objectOne.distance, objectTwo.distance);

    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.distance, node.distance);
    }
}