package com.elmerhd.jtyper;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author elmerhd
 */
public class JTyper {
    
    private JTyperKeyMaster typerKeyMaster;
    
    private String text;
    
    public JTyper(String text) throws AWTException {
        this.typerKeyMaster = new JTyperKeyMaster();
        this.text = text;
    }
    
    public void start(int startDelay, int typeDelay) throws InterruptedException{
        Thread.sleep(startDelay);
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < text.length(); i++) {
                    char c = text.charAt(i);
                    typerKeyMaster.typeKey(c);
                    typerKeyMaster.delay(typeDelay);
                }
            }
        }).start();
    }
    
    public static void main(String[] args) throws AWTException, InterruptedException, MalformedURLException, URISyntaxException, ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JTyperHelper.launchApp();       
    }
    
    
    
}
