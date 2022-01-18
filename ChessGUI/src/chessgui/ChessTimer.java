/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgui;

/**
 *
 * @author user
 */
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class ChessTimer extends TimerTask{
    long blackTimeInSeconds;
    long whiteTimeInSeconds;
    Board board;
    JLabel title;
    JLabel empty;
    JLabel white;
    JLabel whiteTime;
    JLabel black;
    JLabel blackTime;
    
    public ChessTimer(long seconds, Board board){
        this.blackTimeInSeconds = seconds;
        this.whiteTimeInSeconds = seconds;
        this.board = board;
    }
    
    public void ShowTimer(){
        JFrame timerFrame = new JFrame();
        timerFrame.setTitle("Timer");
        timerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        timerFrame.setLocation(900, 180);
        timerFrame.setSize(100,120);
        timerFrame.setResizable(false);
        timerFrame.getContentPane().setLayout(new FlowLayout());
        
        title = new JLabel("TIMER");
        empty = new JLabel("                ");
        white = new JLabel("White : ");
        black = new JLabel("Black : ");
        if(whiteTimeInSeconds == 60*5){
            whiteTime = new JLabel("05:00");
            blackTime = new JLabel("05:00");
        }else if(whiteTimeInSeconds == 60*15){
            whiteTime = new JLabel("15:00");
            blackTime = new JLabel("15:00");
        }else if(whiteTimeInSeconds == 60*30){
            whiteTime = new JLabel("30:00");
            blackTime = new JLabel("30:00");
        }else{
            whiteTime = new JLabel("00:00");
            blackTime = new JLabel("00:00");
        }
        
        title.setFont(new Font("Courier", Font.BOLD, 12));
        
        timerFrame.getContentPane().add(title);
        timerFrame.getContentPane().add(empty);
        timerFrame.getContentPane().add(white);
        timerFrame.getContentPane().add(whiteTime);
        timerFrame.getContentPane().add(black);
        timerFrame.getContentPane().add(blackTime);
        
        timerFrame.setVisible(true);
    }
    
    @Override
    public void run(){
        String text = "";
        if(whiteTimeInSeconds == 0){
            this.cancel();
            Component frame = null;
            JOptionPane.showMessageDialog(frame,"Black Won!");
            System.exit(0);
        }else if(blackTimeInSeconds == 0){
            this.cancel();
            Component frame = null;
            JOptionPane.showMessageDialog(frame,"White Won!");
            System.exit(0);
        }
        if (board.getTurnCounter()%2 == 0) { //if genap or if white's turn
            if(whiteTimeInSeconds > 60){
                long sisa = whiteTimeInSeconds%60;
                if(whiteTimeInSeconds/60 > 9) {
                    if(sisa==0) text = whiteTimeInSeconds/60+":0"+sisa;
                    else if(sisa>9) text = whiteTimeInSeconds/60+":"+sisa;
                    else text = whiteTimeInSeconds/60+":0"+sisa;
                }else{
                    if(sisa==0) text = "0"+whiteTimeInSeconds/60+":0"+sisa;
                    else if(sisa>9) text = "0"+whiteTimeInSeconds/60+":"+sisa;
                    else text = "0"+whiteTimeInSeconds/60+":0"+sisa;
                }
            }else{
                if(whiteTimeInSeconds == 60)text = "01:00";
                else if(whiteTimeInSeconds>9){
                    text = "00:"+whiteTimeInSeconds;
                }else{
                    text = "00:0"+whiteTimeInSeconds;
                }
            }
            whiteTimeInSeconds--;
            whiteTime.setText(text);
        }else if(board.getTurnCounter()%2 == 1){ //if ganjil or if black's turn
            if(blackTimeInSeconds > 60){
                long sisa = blackTimeInSeconds%60;
                if(blackTimeInSeconds/60 > 9) {
                    if(sisa==0) text = blackTimeInSeconds/60+":0"+sisa;
                    else if(sisa>9) text = blackTimeInSeconds/60+":"+sisa;
                    else text = blackTimeInSeconds/60+":0"+sisa;
                }else{
                    if(sisa==0) text = "0"+blackTimeInSeconds/60+":0"+sisa;
                    else if(sisa>9) text = "0"+blackTimeInSeconds/60+":"+sisa;
                    else text = "0"+blackTimeInSeconds/60+":0"+sisa;
                }
            }else{
                if(blackTimeInSeconds == 60)text = "01:00";
                else if(blackTimeInSeconds>9){
                    text = "00:"+blackTimeInSeconds;
                }else{
                    text = "00:0"+blackTimeInSeconds;
                }
            }
            blackTimeInSeconds--;
            blackTime.setText(text);
        }
    }
}
