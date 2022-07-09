package com.elmerhd.jtyper;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Map;

/**
 *
 * @author elmerhd
 */
public class JTyperKey {
    
    private Robot robot;
    private int code;
    private boolean isShifted;
    private Map<Character, JTyperKey> keyStrokeMap;
    public JTyperKey(Map<Character, JTyperKey> keyStrokeMap ,Robot robot, int keyCode, boolean pressShift){
        this.robot = robot;
        this.keyStrokeMap = keyStrokeMap;
        this.code = keyCode;
        this.isShifted = pressShift;
    }
    
    public void type(){
        if (this.isShifted) {
            this.robot.keyPress(KeyEvent.VK_SHIFT);
        }
        this.robot.keyPress(this.code);
        this.robot.keyRelease(this.code);
        if (this.isShifted) {
            this.robot.keyRelease(KeyEvent.VK_SHIFT);
        }
        if(this.code == KeyEvent.VK_ENTER){
            this.robot.keyPress(KeyEvent.VK_HOME);
            this.robot.keyRelease(KeyEvent.VK_HOME);
        }
    }
}
