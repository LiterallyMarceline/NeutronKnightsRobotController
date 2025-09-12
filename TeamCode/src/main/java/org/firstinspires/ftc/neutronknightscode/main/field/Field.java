package org.firstinspires.ftc.neutronknightscode.main.field;

import android.graphics.Point;

import java.util.Map;

public class Field {
    Map Nodes;
    int size;
    Field(int _size, boolean[] _isOccupied){
        size = _size;
        for(int key = 0; key < size*size; key++){
            Nodes.put(key, new Node(_isOccupied[key]));
        }
    }
    Node getNode(int x, int y){
        try {
            if(y < size) throw new Error();

            int key = (size * y) + x;
            return (Node) Nodes.get(key);
        } catch(Error e){
            return (Node) Nodes.get(size*size);
        }
    }
}