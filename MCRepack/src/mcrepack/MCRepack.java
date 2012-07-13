package mcrepack;

import javax.swing.*;
import java.io.*;
import java.awt.event.*;

public class MCRepack extends JFrame implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e);
    }
    
    public MCRepack()
    {
        setSize(600,600);
        //setLocation(100,100);
        setLayout(null);
        //setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initGUIElements();
        getOperatingSystem();
    }
    
    private void initGUIElements()
    {
        startRealm = new JButton("Start");
        stopRealm = new JButton("Stop");
        restartRealm = new JButton("Restart");
        confServer = new JButton("Configuration");
        menuBar = new JMenuBar();
        file = new JMenu("File");
        exit = new JMenuItem("Exit");
        
        startRealm.setBounds(10, 500, 130, 30);
        stopRealm.setBounds(150, 500, 130, 30);
        restartRealm.setBounds(300, 500, 130, 30);
        confServer.setBounds(450, 500, 130, 30);
        menuBar.setBounds(0, getInsets().top, getWidth(), 20);
        
        add(startRealm);
        add(stopRealm);
        add(restartRealm);
        add(confServer);
        menuBar.add(file);
        file.add(exit);
        add(menuBar);
    }
    
    private void getOperatingSystem()
    {
        try
        {
            is = new FileInputStream("data.bin");
            ois = new ObjectInputStream(is);
            options = (int[])ois.readObject();
            setVisible(true);
            setTitle("MCRepack for "+ (options[1] == 0 ? "Windows" : "Linux"));
        } 
        
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            final JFrame opt = new JFrame();
            opt.setSize(180, 200);
            JButton ok = new JButton("OK");
            opt.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            opt.setLayout(null);
            final JComboBox _os = new JComboBox();
            final JCheckBox _su = new JCheckBox("Are you admin?");
            _os.addItem("Windows");
            _os.addItem("Linux");
            
            _os.setBounds(5, 15, 140, 25);
            _su.setBounds(5, 50, 150, 25);
            ok.setBounds(25, 80, 100, 30);
            
            opt.add(_os);
            opt.add(_su);
            opt.add(ok);
            
            ok.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    options = new int[2];
                    options[0] = _su.isSelected() ? 1 : 0;
                    options[1] = _os.getSelectedIndex();
                    try
                    {
                        os = new FileOutputStream("data.bin");
                        oos = new ObjectOutputStream(os);
                        oos.writeObject(options);
                    } catch (Exception io){System.out.println(io);}
                    opt.dispose();
                    setVisible(true);
                    setTitle("MCRepack for "+ (options[1] == 0 ? "Windows" : "Linux"));
                }
            });
            
            opt.setVisible(true);
        }
    }
    
    public static void main(String[] args) 
    {
        new MCRepack();
    }
    
    private ObjectInputStream ois;
    private InputStream is;
    private ObjectOutputStream oos;
    private OutputStream os;
    private int[] options;
    private JButton startRealm, stopRealm, restartRealm, confServer;
    private JMenuBar menuBar;
    private JMenu file;
    private JMenuItem exit;
}
