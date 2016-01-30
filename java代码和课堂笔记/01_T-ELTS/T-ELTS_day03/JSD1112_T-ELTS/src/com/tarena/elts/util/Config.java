package com.tarena.elts.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * Config ��ȡϵͳ�������ļ�
 */
public class Config {
  private Properties table = new Properties();
    
  public Config(String file) {
    try {
      table.load(new FileInputStream(file));
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  public int getInt(String key){
    return Integer.parseInt(table.getProperty(key));
  }
  public String getString(String key){
    return table.getProperty(key);
  }
  public double getDouble(String key){
    return Double.parseDouble(table.getProperty(key));
  }
}
