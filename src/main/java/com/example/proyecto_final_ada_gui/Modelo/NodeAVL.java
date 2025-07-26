package com.example.proyecto_final_ada_gui.Modelo;

public class NodeAVL {
    Task task;
    NodeAVL left, right;
    int height;

    public NodeAVL(Task t) {
        task = t;
        height = 1;
    }
}
