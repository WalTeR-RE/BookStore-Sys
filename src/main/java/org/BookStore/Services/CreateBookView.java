
package org.BookStore.Services;
import org.BookStore.Login;
import org.BookStore.MAIN_FORMM;
import org.BookStore.PlaceOrder_Form;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class CreateBookView extends JLabel{
    Image cover ;
    ImageIcon coverIcon;
    private static JFrame MainFrame;

    public static void setMainFrame(JFrame mainFrame) {
        MainFrame = mainFrame;
    }

    public CreateBookView(String coverPath , String title, float AvgRev){
        this.setText(title);
        this.setSize(150,228);
        cover = new ImageIcon(getClass().getResource(coverPath)).getImage();
        coverIcon = new ImageIcon(cover.getScaledInstance(150,228,Image.SCALE_SMOOTH));
        int borderThickness = 5 ;
        Color borderColor =Color.WHITE;
        int width = coverIcon.getIconWidth() + (2*borderThickness);
        int height = coverIcon.getIconHeight() + (2*borderThickness);
        BufferedImage borderedImage =new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g= borderedImage.createGraphics();
        g.setColor(borderColor);
        g.fillRect(0, 0, width, height);
        g.drawImage(coverIcon.getImage(), borderThickness,borderThickness,null);
        g.dispose();
        ImageIcon borderedIcon = new ImageIcon (borderedImage.getScaledInstance(150,228, Image.SCALE_SMOOTH));
        this.setIcon(borderedIcon);
        this.setFont(new Font ("Tw Cen MT Condensed", Font.BOLD, 16));
        this.setVerticalTextPosition(JLabel.BOTTOM);
        this.setHorizontalTextPosition(JLabel.CENTER);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        this.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                PlaceOrder_Form.setBookID(title);
                PlaceOrder_Form orderForm = new PlaceOrder_Form();
                ImageIcon image;
                image = new ImageIcon(getClass().getResource("/images/icons8-book-94.png"));
                orderForm.setIconImage(image.getImage());
                orderForm.setVisible(true);
                orderForm.pack();
                orderForm.setResizable(false);
                orderForm.setLocationRelativeTo(null);
                MainFrame.dispose();
            }
            @Override
            public void mouseEntered(MouseEvent e){
                setText("<HTML><u style=\"text-decoration: none; color: blue;\" onmouseover=\"this.style.textDecoration='underline'; this.style.color='red';\" onmouseout=\"this.style.textDecoration='none'; this.style.color='blue';\">"+title+"</U></HTML>");
                setToolTipText("Average Review: "+AvgRev);
            }

            @Override
            public void mouseExited(MouseEvent e){
                setText(title);
            }

        });
    }
    
    
    
    
    
    
    
    
}
