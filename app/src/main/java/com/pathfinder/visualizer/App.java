package com.pathfinder.visualizer;

import com.pathfinder.visualizer.model.*;;

public class App {

    public static void main( String[] args ) {

        Maze maze = new Maze( 5, 5 );
        Cell center = maze.getCell( 2, 2 );

        System.out.println( "Celda central: " + center.getRow() + "," + center.getColumn() );
        System.out.println( "Estado: " + center.getState() );
        System.out.println( "Vecinas: " + maze.getNeighbors( center ).size() );
    
    }

}
