package chessgui.pieces;

import chessgui.Board;
import java.awt.Component;
import javax.swing.JOptionPane;

public class Knight extends Piece {

    public Knight(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y){
        int dif_x = Math.abs(destination_x - this.getX());
        int dif_y = Math.abs(destination_y - this.getY());
        
        Piece p = board.getPiece(destination_x, destination_y);
        if(dif_x == 0 || dif_y == 0){ //Knight can't move straight
            return false;   
        }else if(dif_x == dif_y){ //Knight can't move diagonal
            return false;  
        }else if(dif_x > 2 || dif_y > 2){ //knight can't move more than 2x
            return false;   
        }
        
        if(p!=null){
            if(p.isWhite() == this.isWhite()){ //Can't eat friend
                return false;
            }else if(p.toString().contains("King")){
                if(this.isWhite() && p.isBlack()){
                    Component frame = null;
                    JOptionPane.showMessageDialog(frame,"White Won!");
                    System.exit(0);
                }else if(this.isBlack() && p.isWhite()){
                    Component frame = null;
                    JOptionPane.showMessageDialog(frame,"Black Won!");
                    System.exit(0);
                }
            }
            System.out.println(p);
        }
        return true;
    }
}
