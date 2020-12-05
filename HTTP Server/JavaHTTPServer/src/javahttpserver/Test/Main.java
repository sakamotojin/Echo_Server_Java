/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javahttpserver.Test;

/**
 *
 * @author Sakamoto Jin
 */
import java.util.logging.ErrorManager;
import java.util.logging.Filter;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class LogWindow extends JFrame {
  private JTextArea textArea = new JTextArea();

  public LogWindow() {
    super("");
    setSize(300, 300);
    add(new JScrollPane(textArea));
    setVisible(true);
  }

  public void showInfo(String data) {
    textArea.append(data);
    this.validate();
  }
}

class WindowHandler extends Handler {
  private LogWindow window = null;

  private Formatter formatter = null;

  private Level level = null;

  private static WindowHandler handler = null;

  private WindowHandler() {
    LogManager manager = LogManager.getLogManager();
    String className = this.getClass().getName();
    String level = manager.getProperty(className + ".level");
    setLevel(level != null ? Level.parse(level) : Level.INFO);
    if (window == null)
      window = new LogWindow();
  }

  public static synchronized WindowHandler getInstance() {
    if (handler == null) {
      handler = new WindowHandler();
    }
    return handler;
  }

  public  Formatter getFormatter(){
      if(formatter==null) formatter = new SimpleFormatter();
      return formatter;
  }
  public synchronized void publish(LogRecord record) {
    String message = null;
    if (!isLoggable(record))
      return;
    message = getFormatter().format(record);
    window.showInfo(message);
  }

  public void close() {
  }

  public void flush() {
  }
}

public class Main {
  private WindowHandler handler = null;

  private Logger logger = null;

  public Main() {
      try{
            handler = WindowHandler.getInstance();
            logger = Logger.getLogger("logging.handler");
            logger.addHandler(handler);
      }
      catch(Exception e){
          System.out.println(e);
      }
      if(logger==null) {
          System.out.println("Logger null");
      }
  }

  public void logMessage() {
    
    logger.info("Hello from ...");
  }

  public static void main(String args[]) {
    Main demo = new Main();
    if(demo==null){
        System.out.println("demo null");
    }
    demo.logMessage();
    WindowHandler h = WindowHandler.getInstance();
    LogRecord r = new LogRecord(Level.WARNING, "The Handler publish method...");
    h.publish(r);
  }
}
