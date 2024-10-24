/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author rabia
 */
public class RabiaDemirbagMultiLinkedList<T> {

    private RabiaDemirbagNode<T> head;
    private int rows;
    private int columns;
    private int[] columnCounts;

    public RabiaDemirbagMultiLinkedList(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        head = new RabiaDemirbagNode<>(null);
        RabiaDemirbagNode<T> current = head;
        for (int i = 0; i < columns; i++) {
            current.down = new RabiaDemirbagNode<>(null);
            current.down.up = current;
            current = current.down;
        }
        columnCounts = new int[columns];
    }
    
    

    public void add(int column, T value) {
        if (columnCounts[column] == rows) {
            mergeTiles();
            print();
            return;

        }
        RabiaDemirbagNode<T> node = new RabiaDemirbagNode<>(value);
        RabiaDemirbagNode<T> current = head.down;
        for (int i = 0; i < column; i++) {
            current = current.down;
        }
        while (current.right != null) {
            current = current.right;
        }
        current.right = node;
        node.left = current;
        node.column = column;
        columnCounts[column]++;
    }

    public void slideDown() {
        RabiaDemirbagNode<T> current = head.right;
        while (current != null) {
            RabiaDemirbagNode<T> row = current.down;
            while (row != null) {
                if (row.value == null && row.up != null && row.up.value != null) {
                    row.value = row.up.value;
                    row.up.value = null;
                }
                row = row.down;
            }
            current = current.right;
        }
    }

    public void print() {
        RabiaDemirbagNode<T> row = head.down;
        while (row != null) {
            RabiaDemirbagNode<T> current = row.right;
            while (current != null) {
                if (current.value == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(current.value + " ");
                }
                current = current.right;
            }
            System.out.println(" ");
            row = row.down;
        } 
        System.out.println("---------------");
    }
 
    public void mergeTiles() {
        RabiaDemirbagNode<T> row = head.down;
        while (row != null) {
            RabiaDemirbagNode<T> current = row.right;
            while (current != null && current.right != null) {
                if (current.value != null) {
                    RabiaDemirbagNode<T> temp = current.right;
                    while (temp != null && temp.value == null) {
                        temp = temp.right;
                    }
                    if (temp != null && current.value.equals(temp.value)) {
                        current.value = (T) Integer.valueOf((Integer) current.value * 2);
                        temp.value = null;
                        slideDown();
                        columnCounts[current.column]--;

                    }
                }
                current = current.right;
            }
            row = row.down;

        }
    }

    public static void main(String[] args) {
        RabiaDemirbagMultiLinkedList<Integer> grid = new RabiaDemirbagMultiLinkedList<>(5, 7);

        grid.add(0, 2);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(3, 2);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(1, 4);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(2, 2);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(4, 4);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(1, 2);
        grid.slideDown();

        grid.mergeTiles();
        grid.print();

        grid.add(4, 4);
        grid.slideDown();

        grid.mergeTiles();
        grid.print();

        grid.add(0, 8);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(0, 8);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(1, 32);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(2, 2);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(2, 64);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(3, 16);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(1, 64);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(2, 32);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(0, 16);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(4, 16);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(2, 32);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(1, 64);
        grid.slideDown();
        grid.mergeTiles();

        grid.add(3, 8);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(3, 4);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(3, 2);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(3, 2);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(1, 2);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(2, 64);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(2, 32);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(2, 16);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(2, 8);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(2, 8);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(1, 4);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(1, 8);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

        grid.add(1, 4);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();
        
        
        grid.add(1, 2);
        grid.slideDown();
        grid.mergeTiles();
        grid.print();

    }
}
 