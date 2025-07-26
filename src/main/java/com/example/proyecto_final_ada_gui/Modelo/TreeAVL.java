package com.example.proyecto_final_ada_gui.Modelo;

public class TreeAVL {
    private NodeAVL root;


    // metodos para la altura y el balanceo


    private int height(NodeAVL node) {
        return node == null ? 0 : node.height;
    }

    private int updateHeight(NodeAVL node) {
        return node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private int balanceFactor(NodeAVL node) {
        return node == null? 0 : height(node.left) - height(node.right);
    }


    private NodeAVL rotateRight(NodeAVL node) {
        NodeAVL x = node.left;
        NodeAVL T2 = x.right;

        x.right = node;
        node.left = T2;

        updateHeight(node);
        updateHeight(x);

        return x;
    }

    private NodeAVL rotateLeft(NodeAVL node) {
        NodeAVL x = node.right;
        NodeAVL T2 = x.left;

        x.left = node;
        node.right = T2;

        updateHeight(node);
        updateHeight(x);

        return x;
    }

    private NodeAVL balance(NodeAVL node) {
        int bf = balanceFactor(node);

        if (bf > 1) {
            if (balanceFactor(node.left) < 0)
                node.left = rotateLeft(node);
            return rotateRight(node);
        }
        if (bf < -1) {
            if (balanceFactor(node.right) > 0)
                node.right = rotateRight(node);
            return rotateLeft(node);
        }

        return node;
    }

    //metodos internos

    private NodeAVL insert(NodeAVL node, Task task) {
        if (node == null) return new NodeAVL(task);

        if (task.id < node.task.id) {
            node.left = insert(node.left, task);
        }
        else if (task.id > node.task.id) {
            node.right = insert(node.right, task);
        }
        else {
            return node;
        }

        updateHeight(node);

        return balance(node);

    }

    private NodeAVL search(NodeAVL node, int id) {
        if (node == null) return null;
        if (id < node.task.id) return search(node.left, id);
        if (id > node.task.id) return search(node.right, id);
        return node;
    }

    private NodeAVL getMin(NodeAVL node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private NodeAVL remove(NodeAVL node, int id) {
        if (node == null) return null;

        if (id < node.task.id)
            node.left = remove(node.left, id);
        else if (id > node.task.id)
            node.right = remove(node.right, id);
        else {
            if (node.left == null || node.right == null) {
                node = (node.left != null) ? node.left : node.right;
            } else {
                NodeAVL temp = getMin(node.right);
                node.task = temp.task;
                node.right = remove(node.right, temp.task.id);
            }
        }

        if (node == null) return null;
        updateHeight(node);

        return balance(node);
    }

    //metodos publicos
    public void insert(Task task) {
        root = insert(root, task);
    }
    public void remove(int id) {
        root = remove(root, id);
    }
    public Task search(int id) {
        NodeAVL node = search(root, id);
        return node == null ? null : node.task;
    }


    //Clases para pruebas

    public int altura() {
        return alturaRecursiva(root);
    }

    private int alturaRecursiva(NodeAVL nodo) {
        if (nodo == null) return 0;
        return 1 + Math.max(alturaRecursiva(nodo.left), alturaRecursiva(nodo.right));
    }


    public void inOrden() {
        inOrdenRecursivo(root);
        System.out.println(); // salto de línea
    }

    private void inOrdenRecursivo(NodeAVL nodo) {
        if (nodo != null) {
            inOrdenRecursivo(nodo.left);
            System.out.print("[" + nodo.task.id + ", " + nodo.task.description + "] ");
            inOrdenRecursivo(nodo.right);
        }
    }

}
