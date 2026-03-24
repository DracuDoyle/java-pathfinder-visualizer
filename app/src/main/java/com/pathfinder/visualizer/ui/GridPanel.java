package com.pathfinder.visualizer.ui;


import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import com.pathfinder.visualizer.model.*;


public class GridPanel extends JPanel {

    private Maze maze;

    public GridPanel( Maze maze ) { this.maze = maze; }

    @Override
    protected void paintComponent( Graphics g ) {

        super.paintComponent( g );

        // Ancho y Largo de cada celda
        int cellWidth = getWidth() / maze.getColumns();
        int cellHeight = getHeight() / maze.getRows();

        for( int i = 0; i < maze.getRows(); i++ ) {
            for( int j = 0; j < maze.getColumns(); j++ ) {
                
                // Obtener color
                Cell current = maze.getCell( i, j );
                CellState currentState = current.getState();

                Color color = switch( currentState ) {
                    case EMPTY -> Color.WHITE;
                    case WALL -> Color.BLACK;
                    case START -> Color.GREEN;
                    case TARGET -> Color.RED;
                    case VISITED -> Color.BLUE;
                    case INPATH -> Color.YELLOW;
                };

                // Obtener coordenadas dentro de la grilla
                int x = current.getColumn() * cellWidth;
                int y = current.getRow() * cellHeight;

                // Dibujar cada celda en la grilla
                g.setColor( color );
                g.fillRect( x, y, cellWidth, cellHeight );
                g.setColor( Color.GRAY );
                g.drawRect( x, y, cellWidth, cellHeight );
            
            }
        }
    
    }

}
