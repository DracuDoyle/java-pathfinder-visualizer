package com.pathfinder.visualizer.model;


import java.util.ArrayList;
import java.util.List;


public class Maze {

    // Atributos

    private int rows;
    private int columns;
    private Cell[][] grid;

    // Constructor

    public Maze( int rows, int columns ) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new Cell[ this.rows ][ this.columns ];
        fillGrid();
    }

    // Métodos

    private void fillGrid() {
        for( int i = 0; i < rows; i++ ) {
            for( int j = 0; j < columns; j++ ) {
                grid[ i ][ j ] = new Cell( i, j );
            }
        }
    }

    public List<Cell> getNeighbors( Cell cell ) {
        
        List<Cell> neighbors = new ArrayList<>();
        
        int x = cell.getRow();
        int y = cell.getColumn();

        // Derecha
        if( x + 1 < rows && grid[ x + 1 ][ y ].getState() != CellState.WALL ) {
            neighbors.add( grid[ x + 1 ][ y ] );
        }

        // Izquierda
        if( x - 1 >= 0 && grid[ x - 1 ][ y ].getState() != CellState.WALL ) {
            neighbors.add( grid[ x - 1 ][ y ] );
        }

        // Arriba
        if( y + 1 < columns && grid[ x ][ y + 1 ].getState() != CellState.WALL ) {
            neighbors.add( grid[ x ][ y + 1 ] );
        }

        // Abajo
        if( y - 1 >= 0 && grid[ x ][ y - 1 ].getState() != CellState.WALL ) {
            neighbors.add( grid[ x ][ y - 1 ] );
        }

        return neighbors;
    
    }

    // Setters y Getters
    
    public int getRows() { return rows; }
    public int getColumns() { return columns; }

    public Cell getCell( int row, int column ) { return grid[ row ][ column ]; }
    
}
