package chessgui.pieces;

import chessgui.Board;
import java.awt.Component;
import javax.swing.JOptionPane;

public class Queen extends Piece {

    public Queen(int x, int y, boolean is_white, String file_path, Board board)
    {
        super(x,y,is_white,file_path, board);
    }
    
    @Override
    public boolean canMove(int destination_x, int destination_y)
    {
        int dif_x = Math.abs(destination_x - this.getX());
        int dif_y = Math.abs(destination_y - this.getY());
        
        Piece x = board.getPiece(destination_x, destination_y);
        if((dif_x == 0 && dif_y != 0) || (dif_y == 0 && dif_x != 0)){ //Check if there is a piece in the way (straight) (rook movement)
            if(destination_y > this.getY()){ //downwards
                for(int i=1;i<dif_y;i++){
                    Piece p = board.getPiece(getX(), this.getY() + i);
                    if(p != null){
                        return false;
                    }
                }
            }else if(destination_y < this.getY()){ //upwards
                for(int i=1;i<dif_y;i++){
                    Piece p = board.getPiece(getX(), this.getY() - i);
                    if(p != null){
                        return false;
                    }
                }
            }else if(destination_x > this.getX()){ //right
                for(int i=1;i<dif_x;i++){
                    Piece p = board.getPiece(getX() + i, this.getY());
                    if(p != null){
                        return false;
                    }
                }
            }else if(destination_x < this.getX()){ //left
                for(int i=1;i<dif_x;i++){
                    Piece p = board.getPiece(getX() - i, this.getY());
                    if(p != null){
                        return false;
                    }
                }
            }
        }else{ //Check if there is a piece in the way (diagonally) (bishop movement)
            if(destination_x < this.getX() && destination_y > this.getY()){ //Diagonal left-down
                for(int i=1;i<dif_x;i++){
                    Piece p = board.getPiece(getX() - i, getY() + i);
                    if(p != null){
                        return false;
                    }
                }
            }else if(destination_x > this.getX() && destination_y > this.getY()){ //Diagonal right-down
                for(int i=1;i<dif_x;i++){
                    Piece p = board.getPiece(getX() + i, getY() + i);
                    if(p != null){
                        return false;
                    }
                }
            }else if(destination_x > this.getX() && destination_y < this.getY()){ //Diagonal right-up
                for(int i=1;i<dif_x;i++){
                    Piece p = board.getPiece(getX() + i, getY() - i);
                    if(p != null){
                        return false;
                    }
                }
            }else if(destination_x < this.getX() && destination_y < this.getY()){ //Diagonal left-up
                for(int i=1;i<dif_x;i++){
                    Piece p = board.getPiece(getX() - i, getY() - i);
                    if(p != null){
                        return false;
                    }
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
