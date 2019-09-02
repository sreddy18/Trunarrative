package managers;

import dataProviders.ConfigFileReader;

/**This Class is maintain single insatnce of class at a time rather than creating many objects of the same class**/
public class FileReaderManager {
 
 private static FileReaderManager fileReaderManager = new FileReaderManager();
 private static ConfigFileReader configFileReader;
 
 private FileReaderManager() {
 }
 
 public static FileReaderManager getInstance( ) {
       return fileReaderManager;
 }
 
 public ConfigFileReader getConfigReader() {
 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
 }
}