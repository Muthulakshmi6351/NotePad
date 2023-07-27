
package notepadapp;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuBar;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;


public class NotePad  implements ActionListener{
    
    JFrame frame1 = new JFrame("My NotePad");
        
        
    //JMenuBar
    JMenuBar menubar = new JMenuBar();
    //Menu
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu fnt = new JMenu("Font");
    JMenu theme = new JMenu("Theme");
    //MenuItem
    //FILE
    JMenuItem newfile = new JMenuItem("New");
    JMenuItem newwindowfile = new JMenuItem("New Window");
    JMenuItem openfile = new JMenuItem("Open");
    JMenuItem savefile = new JMenuItem("Save");
    JMenuItem printfile = new JMenuItem("Print");
    JMenuItem closefile = new JMenuItem("Close");
    //EDIT
   
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem selectall = new JMenuItem("Select All");
    //FONT
    JMenuItem fsize = new JMenuItem("Font Size");
    JMenuItem ffamily = new JMenuItem("Font Family");
    JMenuItem fstyle = new JMenuItem("Font Style");
    JMenuItem fcolor = new JMenuItem("Font Color");
    //THEME
    JMenuItem classic = new JMenuItem("Classic");
    JMenuItem day = new JMenuItem("Day");
    JMenuItem dark = new JMenuItem("Dark");
    JMenuItem night = new JMenuItem("Night");
    //TextArea
    JTextArea textarea = new JTextArea();
    //Font 
    Font menuFont = new Font("Calibri", Font.BOLD, 20);
    Font menuitemFont = new Font("Calibri", Font.BOLD, 15);
    Font textareaFont = new Font("SansSerif", Font.PLAIN, 30);
    
    

   //Font-style,size,family
    Font newFont ;
    int[] stylevalue = {Font.PLAIN, Font.BOLD, Font.ITALIC};
    int fntsize =30;
    int fntstyle;
    String fontFamily, fontSize, fontStyle;
    String fontFamilyValues[] = {"Agency FB", "Antiqua", "Architect", "Arial", "Calibri", "Comic Sans", "Courier", "Cursive", "Impact", "Serif"};
    String fontSizeValues[] = {"5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55", "60", "65", "70"};
    String[] fontStyleValues = {"PLAIN", "BOLD", "ITALIC"};
    JList fontFamilyList = new JList(fontFamilyValues);
    JList fontStyleList = new JList(fontStyleValues);
    JList fontSizeList = new JList(fontSizeValues);

    public NotePad(){
        //Frame
        frame1.setBounds(50,50,1200,800);
        Image img=Toolkit.getDefaultToolkit().createImage("C:\\Users\\acer\\Pictures\\Notepad.png");
        frame1.setIconImage(img);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //MenuBar
        frame1.setJMenuBar(menubar); //Set the MenuBar in Top
        
        menubar.add(file);
        menubar.add(edit);
        menubar.add(fnt);
        menubar.add(theme);
        
        //MenuItem-FILE
        file.add(newfile);
        file.add(newwindowfile);
        file.addSeparator();
        file.add(openfile);
        file.add(savefile);
        file.add(printfile);
        file.addSeparator();
        file.add(closefile);
        
        //MenuItem-EDIT
     
        edit.add(copy);
        edit.add(cut);
        edit.add(paste);
        edit.addSeparator();
        edit.add(selectall);
        
        //MenuItem-FONT
        fnt.add(fsize);
        fnt.add(ffamily);
        fnt.add(fstyle);
        fnt.add(fcolor);
        
        //MenuItem-THEME
        theme.add(classic);
        theme.add(day);
        theme.add(dark);
        theme.add(night);
        
        //Font-MenuBar
        file.setFont(menuFont);
        edit.setFont(menuFont);
        fnt.setFont(menuFont);
        theme.setFont(menuFont);
        
        //Font-MenuItem
        newfile.setFont(menuitemFont);
        newwindowfile.setFont(menuitemFont);
        openfile.setFont(menuitemFont);
        savefile.setFont(menuitemFont);
        printfile.setFont(menuitemFont);
        closefile.setFont(menuitemFont);
        
        copy.setFont(menuitemFont);
        cut.setFont(menuitemFont);
        paste.setFont(menuitemFont);
        selectall.setFont(menuitemFont);
        
        fsize.setFont(menuitemFont);
        ffamily.setFont(menuitemFont);
        fstyle.setFont(menuitemFont);
        fcolor.setFont(menuitemFont);
        
        classic.setFont(menuitemFont);
        day.setFont(menuitemFont);
        dark.setFont(menuitemFont);
        night.setFont(menuitemFont);
        
        //TextArea
        textarea.setVisible(true);
        textarea.setFont(textareaFont);
        JScrollPane scroll = new JScrollPane(textarea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(10, 10, 1170, 710);
        frame1.add(scroll);
        
        //Add ActionListener
        newfile.addActionListener(this);
        newwindowfile.addActionListener(this);
        openfile.addActionListener(this);
        savefile.addActionListener(this);
        printfile.addActionListener(this);
        closefile.addActionListener(this);

        copy.addActionListener(this);
        cut.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);

        fsize.addActionListener(this);
        ffamily.addActionListener(this);
        fstyle.addActionListener(this);
        fcolor.addActionListener(this);

        classic.addActionListener(this);
        day.addActionListener(this);
        dark.addActionListener(this);
        night.addActionListener(this);
        
        //select only one option
        fontFamilyList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontStyleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontSizeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //ShortKey
        //file
        newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));
        newwindowfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,ActionEvent.CTRL_MASK));
        openfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));
        savefile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));
        printfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        closefile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0));
        //edit
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK)); 
    }
    public static void main(String[] args) {
        new NotePad().frame1.setVisible(true);  
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("New"))
        {
                textarea.setText(null);
        }
        else if(e.getActionCommand().equals("New Window"))
        {
            NewWindow nw = new NewWindow();
            nw.run(); 
        }
        else if(e.getActionCommand().equals("Open"))
        {
           JFileChooser filechooser = new JFileChooser();
           filechooser.setAcceptAllFileFilterUsed(false);
           int option = filechooser.showOpenDialog(frame1);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = filechooser.getSelectedFile();
                    Scanner sc = new Scanner(file);
                    while (sc.hasNext()) {
                        textarea.append(sc.nextLine() + "\n");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
           
        }
        else if(e.getActionCommand().equals("Save"))
        {
            JFileChooser filechooser = new JFileChooser();
            int option = filechooser.showSaveDialog(frame1);
            if (option == JFileChooser.APPROVE_OPTION) {
                try {
                    File file = filechooser.getSelectedFile();
                    FileWriter filewriter = new FileWriter(file);
                    String data = textarea.getText();
                    filewriter.write(data);
                    filewriter.close();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
           
            }
        }
        else if(e.getActionCommand().equals("Print"))
        {
            try {
                textarea.print();
            } catch (PrinterException ex) {
                Logger.getLogger(NotePad.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getActionCommand().equals("Close"))
        {
           frame1.dispose();
           
        }
        else if(e.getActionCommand().equals("Copy"))
        {
           textarea.copy();
        }
        else if(e.getActionCommand().equals("Cut"))
        {
           textarea.cut();
        }
        else if(e.getActionCommand().equals("Paste"))
        {
           textarea.paste();
        }
        else if(e.getActionCommand().equals("Select All"))
        {
           textarea.selectAll();
        }
        else if(e.getActionCommand().equals("Font Size"))
        {
            JOptionPane.showConfirmDialog(null, fontSizeList, "Choose Font Size", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            fontSize = String.valueOf(fontSizeList.getSelectedValue());
            fntsize = Integer.parseInt(fontSize);
            newFont = new Font(fontFamily, fntstyle, fntsize);
            textarea.setFont(newFont);
           
        }
        else if(e.getActionCommand().equals("Font Family"))
        {
            JOptionPane.showConfirmDialog(null, fontFamilyList, "Choose Font Family", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            fontFamily = String.valueOf(fontFamilyList.getSelectedValue());
            newFont = new Font(fontFamily, fntstyle, fntsize);
            textarea.setFont(newFont);
        }
        else if(e.getActionCommand().equals("Font Style"))
        {
            JOptionPane.showConfirmDialog(null, fontStyleList, "Choose Font Style", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            fntstyle = stylevalue[fontStyleList.getSelectedIndex()];
            newFont = new Font(fontFamily, fntstyle, fntsize);
            textarea.setFont(newFont);   
        }
        else if(e.getActionCommand().equals("Font Color"))
        {
            Color color = JColorChooser.showDialog(frame1, "Choose the Color", Color.black);
            textarea.setForeground(color); 
        }
        else if(e.getActionCommand().equals("Classic"))
        {
           Color c2 = new Color(27,89,146);
           textarea.setBackground(c2);
           textarea.setForeground(Color.white);
           menubar.setBackground(c2);
           file.setForeground(Color.WHITE);
           edit.setForeground(Color.WHITE);
           fnt.setForeground(Color.WHITE);
           theme.setForeground(Color.WHITE);
        }
        else if(e.getActionCommand().equals("Day"))
        {
           textarea.setBackground(Color.white);
           textarea.setForeground(Color.black);
           menubar.setBackground(Color.white);
           file.setForeground(Color.black);
           edit.setForeground(Color.black);
           fnt.setForeground(Color.black);
           theme.setForeground(Color.black);
          
        }
        else if(e.getActionCommand().equals("Dark"))
        {
            Color c1 = new Color(23,33,43);
            textarea.setBackground(c1);
            textarea.setForeground(Color.BLUE);
            menubar.setBackground(c1);
            file.setForeground(Color.blue);
            edit.setForeground(Color.blue);
            fnt.setForeground(Color.blue);
            theme.setForeground(Color.blue);  
        }
        else if(e.getActionCommand().equals("Night"))
        {
            textarea.setBackground(Color.black);
            textarea.setForeground(Color.WHITE);
            menubar.setBackground(Color.black);
            file.setForeground(Color.WHITE);
            edit.setForeground(Color.WHITE);
            fnt.setForeground(Color.WHITE);
            theme.setForeground(Color.WHITE);
          
        }
        
    }
         
}