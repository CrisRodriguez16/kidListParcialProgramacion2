package co.edu.umanizales.kids_list.model;

import lombok.Data;
import lombok.Setter;

@Data
public class NodeDE {
    private Kid data;
    private NodeDE next;
    private NodeDE prev;

    public NodeDE(Kid data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
