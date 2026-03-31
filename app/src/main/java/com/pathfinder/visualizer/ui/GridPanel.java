package com.pathfinder.visualizer.ui;


import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import com.pathfinder.visualizer.model.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.SwingUtilities;



public class GridPanel extends JPanel {


    private Maze maze;
    private Cell startCell;
    private Cell targetCell;
    private Boolean stateRightClick;


    public GridPanel( Maze maze ) {
        
        this.maze = maze;
        this.startCell = null;
        this.targetCell = null;
        this.stateRightClick = false;

        addMouseListener( new MouseAdapter() {
            // Click izquierdo = pintar paredes
            @Override
            public void mousePressed( MouseEvent e ) { handleMouseEvent( e ); }
        } );

        addMouseMotionListener( new MouseMotionAdapter() {
            // Click izquierdo + movimiento = pintar paredes
            @Override
            public void mouseDragged( MouseEvent e ) { handleMouseEvent( e ); }
        } );
    
    }


    private void handleMouseEvent( MouseEvent e ) {
        
        // Con click izquierdo
        // e.getButton() == MouseEvent.BUTTON1
        if( SwingUtilities.isLeftMouseButton( e ) ) {
            
            // Ancho y Largo de cada celda
            int cellWidth = getWidth() / maze.getColumns();
            int cellHeight = getHeight() / maze.getRows();

            // Obtener coordenadas dentro de la grilla
            int col = e.getX() / cellWidth;
            int row = e.getY() / cellHeight;

            // Obtener celda y convertirla en pared
            Cell current = maze.getCell( row, col );
            current.setState( CellState.WALL );

            repaint();
        
        }

        // Con click derecho
        if( SwingUtilities.isRightMouseButton( e ) ) {
            
            // Ancho y Largo de cada celda
            int cellWidth = getWidth() / maze.getColumns();
            int cellHeight = getHeight() / maze.getRows();

            // Obtener coordenadas dentro de la grilla
            int col = e.getX() / cellWidth;
            int row = e.getY() / cellHeight;

            // Obtener celda
            Cell current = maze.getCell( row, col );

            // Primer click derecho = START
            if( startCell == null ) {

                startCell = current;
                current.setState( CellState.START );

            // Segundo click derecho = TARGET
            } else if( targetCell == null  ) {
                
                targetCell = current;
                current.setState( CellState.TARGET );
            
            // Alternar clicks entre START y TARGET
            } else {

                if( stateRightClick == false ) {
                    
                    startCell.setState( CellState.EMPTY );
                    startCell = current;
                    current.setState( CellState.START );
                    stateRightClick = true;

                } else if( stateRightClick == true ) {

                    targetCell.setState( CellState.EMPTY );
                    targetCell = current;
                    current.setState( CellState.TARGET );
                    stateRightClick = false;
                
                }

            }

            repaint();

        }
    
    }


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
