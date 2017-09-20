/*
 * This file is created by jTeX library.
 *
 * jTeX is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * jTeX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with jTeX.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.usajusaj.jtex.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Matej Usaj
 */
public class TeXWriter extends BufferedWriter
{
  private static final int DEFAULT_BUF_SIZE = 20*1000*1000;
  
  private boolean headerWritten;
  private boolean closed;
  
  private TeXWriter(Writer out, int bufSize)
  {
    /* 20MB buffer */
    super(out, bufSize);
  }

  /**
   * Get jTeX file writer instance. Buffer size is 20MB
   * 
   * @param filePath Path to the output file
   * 
   * @return Instance of jTeX file writer
   * 
   * @throws TeXInvalidFileException Path is a directory
   * @throws TeXIOException Problem writing to disk
   */
  public static TeXWriter getInstance(String filePath)
  throws TeXInvalidFileException, TeXIOException
  {
    return getInstance(filePath, DEFAULT_BUF_SIZE);
  }
  
  /**
   * Get jTeX file writer instance with given buffer size
   * 
   * @param filePath Path to the output file
   * @param bufSize  Buffer size
   * 
   * @return Instance of jTeX file writer
   * 
   * @throws TeXInvalidFileException Path is a directory
   * @throws TeXIOException Problem writing to disk
   */
  public static TeXWriter getInstance(String filePath, int bufSize)
  throws TeXInvalidFileException, TeXIOException
  {
    File f = new File(filePath);
    if (f.isDirectory()) throw new TeXInvalidFileException("Path: " + filePath + " is a directory!");
    try {
      return new TeXWriter(new FileWriter(f), bufSize);
    } catch (IOException e) {
      throw new TeXIOException("Error creating " + filePath);
    }
  }
  
  /**
   * Flushes buffer to disk
   * 
   * @throws TeXIOException Problem writing to disk
   */
  @Override
  public void flush() throws TeXIOException
  {
    try {
      super.flush();
    } catch (IOException e) {
      close();
      throw new TeXIOException("Error flushing data to disk!", e);
    }
  }
  
  /**
   * Writes string to buffer
   * 
   * @throws TeXIOException Problem writing
   */
  @Override
  public void write(String s) throws TeXIOException
  {
    try {
      super.write(s);
    } catch (IOException e) {
      close();
      throw new TeXIOException("Error writing!", e);
    }
  }
  
  /**
   * Writes string with a new line at the end to buffer
   * 
   * @throws TeXIOException Problem writing
   */
  public void writel(String s) throws TeXIOException
  {
    write(s);
    newLine();
  }
  
  /**
   * Writes new line to buffer
   * 
   * @throws TeXIOException Problem writing
   */
  @Override
  public void newLine() throws TeXIOException
  {
    try {
      super.newLine();
    } catch (IOException e) {
      close();
      throw new TeXIOException("Error writing!", e);
    }
  }

  /**
   * Closes the file
   * 
   * @throws TeXIOException Problem writing
   */
  @Override
  public void close() throws TeXIOException
  {
    try {
      super.close();
    } catch (IOException e) {
      throw new TeXIOException("Error closing file!", e);
    } finally {
      try {
        setClosed();
        finalize();
      } catch (Throwable e){}
    }
  }
  
  @Override
  protected void finalize() throws Throwable
  {
    super.finalize();
    headerWritten = true;
    closed = true;
  }
  
  public boolean isHeaderWritten()
  {
    return headerWritten;
  }
  
  public void setHeaderWritten()
  {
    headerWritten = true;
  }

  public boolean isClosed()
  {
    return closed;
  }

  public void setClosed()
  {
    closed = true;
  }
}
