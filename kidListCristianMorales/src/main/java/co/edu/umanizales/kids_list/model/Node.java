package co.edu.umanizales.kids_list.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    private Kid data;
    private Node next;

    public Node(Kid data) {
        this.data = data;
    }
}
