package org.firstinspires.ftc.neutronknightscode.main.field;

import java.lang.reflect.Array;
import java.util.Map;

public class Node {

    public float eval;
    public boolean isOccupied;
    public Node[] adjacentNodes;
    public Node(boolean _isOccupied){
        eval = 0;
        isOccupied = _isOccupied;
    }
    public void addAdjacentNodes(Node[] _adjacentNodes){
        adjacentNodes = _adjacentNodes;
    }
    public Node[] getAdjacentNodes() {
        return adjacentNodes;
    }
}
