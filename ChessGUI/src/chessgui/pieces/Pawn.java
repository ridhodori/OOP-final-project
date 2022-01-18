package chessgui.pieces;

import chessgui.Board;
import java.awt.Component;
import javax.swing.JOptionPane;

public class Pawn extends Piece {

    private boolean has_moved;
    
    public Pawn(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
        has_moved = false;
    }
    
    public void setHasMoved(boolean has_moved)
    {
        this.has_moved = has_moved;
    }
    
    public boolean getHasMoved()
    {
        return has_moved;
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y){
        int dif_x = Math.abs(destination_x - this.getX());
        int dif_y = Math.abs(destination_y - this.getY());
        
        Piece p = board.getPiece(destination_x, destination_y);
        if(this.isWhite()){ //If white
            if(dif_y < 3 && destination_y > this.getY()){ //Check if destination is in move range
                if(dif_y == 1){ //1 step
                    if(dif_x == 0){ //Check if not diagonally
                        if(p==null)return true; //Check if no piece at destination
                    }else if(dif_x == 1){ //Check if move diagonally
                        if(p != null && p.isBlack()){ //Check if destination has a piece
                            if(p.toString().contains("King")){
                                Component frame = null;
                                JOptionPane.showMessageDialog(frame,"White Won!");
                                System.exit(0);
                            }
                            System.out.println(p);
                            return true;
                        }
                    }
                }else if(dif_y == 2 && !has_moved){ //2 step
                    if(dif_x == 0 && p==null) return true;
                }
            }
        }else{ //If black
            if(dif_y < 3 && destination_y < this.getY()){ //Check if destination is in move range
                if(dif_y == 1){ //1 step
                    if(dif_x == 0){ //Check if not diagonally
                        if(p==null)return true; //Check if no piece at destination
                    }else if(dif_x == 1){ //Check if move diagonally
                        if(p != null && p.isWhite()){ //Check if destination has a piece
                            if(p.toString().contains("King")){
                                Component frame = null;
                                JOptionPane.showMessageDialog(frame,"Black Won!");
                                System.exit(0);
                            }
                            System.out.println(p);
                            return true;
                        }
                    }
                }else if(dif_y == 2 && !has_moved){ //2 step
                    if(dif_x == 0 && p==null) return true;
                }
            }
        }
        return false;
    }
}
