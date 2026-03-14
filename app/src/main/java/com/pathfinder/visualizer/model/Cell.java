package com.pathfinder.visualizer.model;


public class Cell {

    // Atributos

    private int row;
    private int column;
    private CellState state;

    // Constructor

    public Cell( int row, int column ) {
        this.row = row;
        this.column = column;
        this.state = CellState.EMPTY;
    }

    // Setters y Getters
    
    public int getRow() { return row; }
    public int getColumn() { return column; }

    public void setState( CellState state ) { this.state = state; }
    public CellState getState() { return state; }
    
}
