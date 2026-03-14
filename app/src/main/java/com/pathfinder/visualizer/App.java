package com.pathfinder.visualizer;


import com.pathfinder.visualizer.model.*;
import com.pathfinder.visualizer.algorithm.*;


public class App {

    public static void main( String[] args ) {

        Maze maze = new Maze( 5, 5 );

        Cell start = maze.getCell( 0, 0 );
        Cell target = maze.getCell( 4, 4 );

        start.setState( CellState.START );
        target.setState( CellState.TARGET );

        BFS bfs = new BFS();
        bfs.execute( maze, start, target );

        for( int i = 0; i < 5; i++ ) {
            for( int j = 0; j < 5; j++ ) {
                Cell cell = maze.getCell( i, j );
                switch( cell.getState() ) {
                    case START   -> System.out.print( "S " );
                    case TARGET  -> System.out.print( "T " );
                    case INPATH  -> System.out.print( "* " );
                    case VISITED -> System.out.print( "· " );
                    default      -> System.out.print( ". " );
                }
            }
            System.out.println();
        }
    
    }

}
