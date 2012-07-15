package mcrepack;

import java.awt.*;
import java.awt.event.*;

public class MCRepackTrayIcon 
{
    public MCRepackTrayIcon(final MCRepack main)
    {
        if (SystemTray.isSupported())
        {
            final SystemTray tray = SystemTray.getSystemTray();
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Image image = toolkit.getImage("res/icon.png");
            
            PopupMenu popup = new PopupMenu();
            MenuItem show = new MenuItem("Show");
            MenuItem exit = new MenuItem("Exit");
            final TrayIcon icon = new TrayIcon(image, "MCRepack", popup);
            popup.add(show);
            popup.add(exit);
            
            
            icon.setImageAutoSize(true);
            try
            {
               tray.add(icon); 
            } catch (Exception e){}
            
            show.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    main.setVisible(true);
                    tray.remove(icon);                
                }
            });
            
            exit.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    main.dispose();
                    System.exit(1);
                }
            });
        }
    }
}
