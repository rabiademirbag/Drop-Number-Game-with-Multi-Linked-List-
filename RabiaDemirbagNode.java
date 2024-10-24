/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author rabia
 */
public class RabiaDemirbagNode<T> {
    public T value;
    public RabiaDemirbagNode<T> up;
    public RabiaDemirbagNode<T> down;
    public RabiaDemirbagNode<T> left;
    public RabiaDemirbagNode<T> right;
    int column;

    public RabiaDemirbagNode(T value) {
        this.value = value;
        this.up = null;
        this.down = null;
        this.left = null;
        this.right = null;
        this.column=0;
    }
}


   