package com.elmerhd.jtyper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class JTyperKeyMaster {

    private Map<Character, JTyperKey> keyStrokeMap;
    private Robot robot;
    public JTyperKeyMaster() throws AWTException{
        robot = new Robot();
        keyStrokeMap = new HashMap<Character,JTyperKey>(){{
            put('\n',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_ENTER, true));
            put('\t',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_TAB, false));
            put('\r',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_HOME, false));
            put(' ',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_SPACE, false));
            put('!',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_1, true));
            put('"',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_QUOTE, true));
            put('#',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_3, true));
            put('$',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_4, true));
            put('%',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_5, true));
            put('&',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_7, true));
            put('\'',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_QUOTE, false));
            put('(',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_9, true));
            put(')',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_0, true));
            put('*',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_8, true));
            put('+',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_EQUALS, true));
            put(',',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_COMMA, false));
            put('-',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_MINUS, false));
            put('.',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_PERIOD, false));
            put('/',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_SLASH, false));
            for(int i=(int)'0';i<=(int)'9';i++){
                put((char)i,new JTyperKey(keyStrokeMap, robot, i, false));
            }
            put(':',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_SEMICOLON, true));
            put(';',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_SEMICOLON, false));
            put('<',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_COMMA, true));
            put('=',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_EQUALS, false));
            put('>',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_PERIOD, true));
            put('?',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_SLASH, true));
            put('@',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_2, true));
            for(int i=(int)'A';i<=(int)'Z';i++){
                put((char)i,new JTyperKey(keyStrokeMap, robot, i, true));
            }
            put('[',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_OPEN_BRACKET, false));
            put('\\',new JTyperKey(keyStrokeMap, robot,KeyEvent.VK_BACK_SLASH, false));
            put(']',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_CLOSE_BRACKET, false));
            put('^',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_6, true));
            put('_',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_MINUS, true));
            put('`',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_BACK_QUOTE, false));
            for(int i=(int)'A';i<=(int)'Z';i++){
                put((char)(i+((int)'a'-(int)'A')),new JTyperKey(keyStrokeMap, robot, i, false));
            }
            put('{',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_OPEN_BRACKET, true));
            put('|',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_BACK_SLASH, true));
            put('}',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_CLOSE_BRACKET, true));
            put('~',new JTyperKey(keyStrokeMap, robot, KeyEvent.VK_BACK_QUOTE, true));
        }};
    }
    public void typeKey(char key){
        if (keyStrokeMap.containsKey(key)){
            keyStrokeMap.get(key).type();
        } else {
            System.err.println("'"+key+"': has no mapping");
        }
    }
    
    public void delay(int ms) {
        robot.delay(ms);
    }
    
    
}