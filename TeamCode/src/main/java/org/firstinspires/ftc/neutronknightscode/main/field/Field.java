package org.firstinspires.ftc.neutronknightscode.main.field;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Map;

public class Field {
    ArrayList<Node> Nodes;
    int size;
    int total = 0;
    Field(int _size, boolean[] _isOccupied){
        size = _size;
        for(int y = 1; y <= size; y++) {
            for (int x = 1; x <= size; x++) {
                Nodes.add(new Node(x,y,_isOccupied[total]));
                total++;
            }
        }
    }
    Node getNode(int x, int y){
        try {
            if(y < size) throw new Error();

            int key = (size * y) + x;
            return (Node) Nodes.get(key);
        } catch(Error e){
            return (Node) Nodes.get(size*size-1);
        }
    }
}