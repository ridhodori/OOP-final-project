package chessgui.pieces;

import chessgui.Board;
import java.awt.Component;
import javax.swing.JOptionPane;

public class King extends Piece {

    public King(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y){
        int dif_x = Math.abs(destination_x - this.getX());
        int dif_y = Math.abs(destination_y - this.getY());
        
        Piece p = board.getPiece(destination_x, destination_y);
        if(this.isWhite()){ //If white
            if((dif_x == 1 && dif_y == 1) || (dif_x==1 && dif_y==0) || (dif_y==1 && dif_x==0)){ //Check if destination in range
                if(p==null)return true;
                else{
                    if(p.isBlack()){
                        if(p.toString().contains("King")){
                            Component frame = null;
                            JOptionPane.showMessageDialog(frame,"White Won!");
                            System.exit(0);
                        }
                        System.out.println(p);
                        return true;
                    }
                }
            }
        }else{ //If black
            if((dif_x == 1 && dif_y == 1) || (dif_x==1 && dif_y==0) || (dif_y==1 && dif_x==0)){ //Check if destination in range
                if(p==null)return true;
                else{
                    if(p.isWhite()){
                        if(p.toString().contains("King")){
                            Component frame = null;
                            JOptionPane.showMessageDialog(frame,"Black Won!");
                            System.exit(0);
                        }
                        System.out.println(p);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
