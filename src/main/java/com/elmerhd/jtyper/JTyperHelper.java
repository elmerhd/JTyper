package com.elmerhd.jtyper;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author elmerhd
 */
public class JTyperHelper {
    public static Font POPUP_MENU_ITEM_FONT = new Font("Monospaced", Font.PLAIN, 16);

    public static void launchApp() throws MalformedURLException, URISyntaxException {
        TrayIcon trayIcon = null;
        if (SystemTray.isSupported()) {
            File appFolder = new File(".jtyper");
            if (!appFolder.exists()) {
                appFolder.mkdirs();
            }
            Settings settings = new Settings();
            
            URI uri = JTyper.class.getResource("/com/elmerhd/jtyper/icons8-keyboard-100.png").toURI();
            Image image = Toolkit.getDefaultToolkit().getImage(uri.toURL());
            settings.setIconImage(image);
            SystemTray tray = SystemTray.getSystemTray();
            
            PopupMenu popup = new PopupMenu();
            
            MenuItem preferencesMenuItem = new MenuItem("Preferences");
            preferencesMenuItem.setFont(POPUP_MENU_ITEM_FONT);
            preferencesMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    settings.setLocationRelativeTo(null);
                    settings.setVisible(true);
                }
            });
            popup.add(preferencesMenuItem);
            
            MenuItem typeFromFileMenuItem = new MenuItem("Type From File");
            typeFromFileMenuItem.setFont(POPUP_MENU_ITEM_FONT);
            typeFromFileMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser chooser = new JFileChooser(appFolder);
                    int choice = chooser.showOpenDialog(null);
                    if (choice == JFileChooser.OPEN_DIALOG) {
                        try {
                            String fileContents = new String(Files.readAllBytes(Paths.get(chooser.getSelectedFile().getAbsolutePath())));
                            JTyper jTyper = new JTyper(fileContents);
                            jTyper.start(settings.getStartDelay(), settings.getTypeDelay());
                        } catch (AWTException | InterruptedException | IOException ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "JTyper", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
            popup.add(typeFromFileMenuItem);
            
            MenuItem typeFromTextMenuItem = new MenuItem("Type From Text");
            typeFromTextMenuItem.setFont(POPUP_MENU_ITEM_FONT);
            typeFromTextMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String text = "";
                    JTextArea textArea = new JTextArea(text);
                    textArea.setColumns(30);
                    textArea.setRows(10);
                    textArea.setLineWrap(true);
                    textArea.setWrapStyleWord(true);
                    textArea.setSize(new Dimension(800, 500));
                    int choice = JOptionPane.showConfirmDialog(null, new JScrollPane(textArea), "Input Text", JOptionPane.OK_CANCEL_OPTION);
                    
                    if (choice == JOptionPane.OK_OPTION) {
                        try {
                            text = textArea.getText();
                            JTyper jTyper = new JTyper(text);
                            jTyper.start(settings.getStartDelay(), settings.getTypeDelay());
                        } catch (AWTException | InterruptedException  ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "JTyper", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
            });
            popup.add(typeFromTextMenuItem);
            
            MenuItem exitMenuItem = new MenuItem("Quit");
            exitMenuItem.setFont(POPUP_MENU_ITEM_FONT);
            exitMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            popup.add(exitMenuItem);
            
            trayIcon = new TrayIcon(image, "JTyper", popup);
            //trayIcon.addActionListener(listener);
            trayIcon.setImageAutoSize(true);
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.err.println(e);
            }
            
        }
    }
}
