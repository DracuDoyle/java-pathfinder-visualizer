package com.pathfinder.visualizer.model;


public class Cell {

    // Atributos

    private int row;
    private int column;
    private CellState state;
    private int weight;

    // Constructor

    public Cell( int row, int column ) {
        this.row = row;
        this.column = column;
        this.state = CellState.EMPTY;
        this.weight = 1;
    }

    // Setters y Getters
    
    public int getRow() { return row; }
    public int getColumn() { return column; }

    public void setState( CellState state ) { this.state = state; }
    public CellState getState() { return state; }

    public int getWeight() { return weight; }
    public void setWeight( int weight ) { this.weight = weight; }
    
}
