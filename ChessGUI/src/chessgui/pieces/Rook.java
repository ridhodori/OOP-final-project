package chessgui.pieces;

import chessgui.Board;
import java.awt.Component;
import javax.swing.JOptionPane;

public class Rook extends Piece {

    public Rook(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        int dif_x = Math.abs(destination_x - this.getX());
        int dif_y = Math.abs(destination_y - this.getY());
        
        Piece x = board.getPiece(destination_x, destination_y);
        if(this.getX() != destination_x && this.getY() != destination_y){ //Rook can only move straight line
            return false;
        }else if(dif_x==1 || dif_y == 1){ //If 1 step
            if(x != null && x.isWhite() == this.isWhite()){//Can't eat friend
                return false;
            }
        }else if(destination_y > this.getY()){ //Downwards
            for(int i=0;i<dif_y-1;i++){
                Piece p = board.getPiece(this.getX(), this.getY() + i+1);
                if(p != null){
                    return false;
                }
            }
        }else if(destination_y < this.getY()){ //Upwards
            for(int i=0;i<dif_y-1;i++){
                Piece p = board.getPiece(this.getX(), this.getY() - i-1);
                if(p != null){
                    return false;
                }
            }
        }else if(destination_x > this.getX()){ //Right
            for(int i=0;i<dif_x-1;i++){
                Piece p = board.getPiece(this.getX() + i+1, this.getY());
                if(p != null){
                    return false;
                }
            }
        }else if(destination_x < this.getX()){ //Left
            for(int i=0;i<dif_x-1;i++){
                Piece p = board.getPiece(this.getX() - i-1, this.getY());
                if(p != null){
                    return false;
                }
            }
        }
        
        if(x!=null){
            if(x.isWhite() == this.isWhite()){ //Can't eat friend
                return false;
            }else if(x.toString().contains("King")){
                if(this.isWhite() && x.isBlack()){
                    Component frame = null;
                    JOptionPane.showMessageDialog(frame,"White Won!");
                    System.exit(0);
                }else if(this.isBlack() && x.isWhite()){
                    Component frame = null;
                    JOptionPane.showMessageDialog(frame,"Black Won!");
                    System.exit(0);
                }
            }
            System.out.println(x);
        }
        return true;
    }
}
