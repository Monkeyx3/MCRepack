package mcrepack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConfigurationManager extends JFrame 
{
    public ConfigurationManager()
    {
        setSize(300,600);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLayout(null);
        initGUIElements();
        setVisible(true);
    }
    
    private void initGUIElements()
    {
        panel = new JPanel();
        sp = new JScrollPane(panel);
        sp.setAutoscrolls(true);
        sp.setBounds(0, getInsets().top, getWidth()-5, 450);
        add(sp);
        
        save = new JButton("Save");
        cancel = new JButton("Cancel");
        
        save.setBounds(20, 500, 120, 30);
        cancel.setBounds(150, 500, 120, 30);
        add(save);
        add(cancel);
        
        cancel.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int opt = 
                        JOptionPane.showConfirmDialog(null, "Do you realy want to close and discard your changes?", "Close", 
                                                                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if (opt == 0) dispose();
            }
        });
    }
    
    private JPanel panel;
    private JScrollPane sp;
    private JButton save, cancel;
}
