package mcrepack;

import javax.swing.*;

public class MCRepack extends JFrame
{
    public MCRepack()
    {
        initWindow();
        setVisible(true);
    }
    
    private void initWindow()
    {
        setSize(600,400);
        setLocation(100,100);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MCRepack v0.0.1");
    }
    
    public static void main(String[] args) 
    {
        new MCRepack();
    }
}
