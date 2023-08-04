
package GUI;

import ComDecom.Compressor;
import ComDecom.Decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Compress and Decompress");
        compressButton=new JButton("Select file to compress");
        compressButton.setBounds(100, 100, 200, 30);
        compressButton.addActionListener(this);
        
        decompressButton=new JButton("Select file to decompress");
        decompressButton.setBounds(500, 100, 200, 30);
        decompressButton.addActionListener(this);
        
        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(1000,500);
        this.getContentPane().setBackground(Color.GREEN);
        this.setVisible(true);

    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Compressor.method(file);
                    JOptionPane.showMessageDialog(null,"Compressed Sucessfully!");
                } catch(IOException ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
         if(e.getSource()==decompressButton){
            JFileChooser fileChooser=new JFileChooser();
            int response=fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION)
            {
                File file=new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    Decompressor.method(file);
                    JOptionPane.showMessageDialog(null,"Decompressed Sucessfully!");

                } catch(IOException ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
    
}
