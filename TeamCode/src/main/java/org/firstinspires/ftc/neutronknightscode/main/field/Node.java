package org.firstinspires.ftc.neutronknightscode.main.field;

import java.lang.reflect.Array;
import java.util.Map;

public class Node {

    public float eval;
    public int x;
    public int y;
    public boolean isOccupied;
    public Node[] adjacentNodes;
    public Node(int _x, int _y, boolean _isOccupied){
        eval = 0;
        x = _x;
        y = _y;
        isOccupied = _isOccupied;
    }
    public void addAdjacentNodes(Node[] _adjacentNodes){
        adjacentNodes = _adjacentNodes;
    }
    public Node[] getAdjacentNodes() {
        return adjacentNodes;
    }
}
