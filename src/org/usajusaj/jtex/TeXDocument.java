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
package org.usajusaj.jtex;

import java.util.Date;

import org.usajusaj.jtex.TeXClassOptionsEnum.OptionsClassArticle;
import org.usajusaj.jtex.io.TeXIOException;
import org.usajusaj.jtex.io.TeXInvalidFileException;
import org.usajusaj.jtex.io.TeXWriter;
import org.usajusaj.jtex.items.ITItem;
import org.usajusaj.jtex.items.TeXItemEvent;
import org.usajusaj.jtex.items.TeXItemEventListener;
import org.usajusaj.jtex.items.env.TeXEnvEnum;
import org.usajusaj.jtex.items.env.TeXEnvironmentImpl;
import org.usajusaj.jtex.util.TeXCommands;

/**
 * This is a document representing LaTeX file.<br><br>
 * Class and package definitions are taken from 
 * <a href="http://www.latex-project.org/guides/usrguide.pdf">
 * http://www.latex-project.org/guides/usrguide.pdf</a>
 * 
 * 
 * @author Matej Usaj
 */
public class TeXDocument implements TeXItemEventListener
{
  /* FIELD DECLARATIONS: */
  private TeXWriter writer;
  private ITClass texClass;
  private ITPackageCollection packages;
  private ITItem docEnvironment;
  
  /**
   * Initialize LaTeX document.
   * Keep in mind, that these options can still be changed before the
   * createPreamble() method is called. After that, any global options 
   * manipulation will have no effect!
   * 
   * @param filePath  Destination LaTeX file
   * @param c         Document class for this file
   * 
   * @throws TeXInvalidFileException Given path is a directory
   * @throws TeXIOException          Problem writing to disk
   */
  public TeXDocument(String filePath, ITClass c) 
  throws TeXInvalidFileException, TeXIOException
  {
    this (filePath, c, null);
  }

  /**
   * Initialize LaTeX document and set global options.
   * Keep in mind, that these options can still be changed before the
   * createPreamble() method is called. After that, any global options 
   * manipulation will have no effect!
   * 
   * @param filePath Destination LaTeX file
   * @param c        Document class for this file
   * @param p        Package collection for this document
   * 
   * @throws TeXInvalidFileException Given path is a directory
   * @throws TeXIOException          Problem writing to disk
   */
  public TeXDocument(String filePath, ITClass c, ITPackageCollection p) 
  throws TeXInvalidFileException, TeXIOException
  {
    writer = TeXWriter.getInstance(filePath);
    this.texClass = c;
    if (p != null) packages = p;
    ITItem.addListener(this);
  }
  
  /**
   * Writes preamble to file and sets preambleCreated variable.
   * 
   * @throws TeXIOException Problem writing to disk
   * @throws TeXException   If no document class is given
   */
  public void createPreamble() throws TeXIOException, TeXException
  {
    if (texClass == null)
      throw new TeXException("Document class is null");
    writer.setHeaderWritten();
    
    /* Add personal touch */
    writer.write(TeXCommands.multiLineComment(
        "Created by: jTeX library",
        "Date: " + new Date(),
        ""/*,
        "This file is created by jTeX library.",
        "",
        "jTeX is free software: you can redistribute it and/or modify",
        "it under the terms of the GNU General Public License as published by",
        "the Free Software Foundation, either version 3 of the License, or",
        "(at your option) any later version.",
        "",
        "jTeX is distributed in the hope that it will be useful,",
        "but WITHOUT ANY WARRANTY; without even the implied warranty of",
        "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the",
        "GNU General Public License for more details.",
        "",
        "You should have received a copy of the GNU General Public License",
        "along with jTeX.  If not, see <http://www.gnu.org/licenses/>."*/));
    /**/
    
    writer.newLine();
    writer.writel(TeXCommands.lineComment("PREAMBLE"));
    ///writer.writel(texClass.getString());
    if (packages != null)
      for (ITPackage p : packages)
        writer.writel(p.getString());
    writer.writel(TeXCommands.lineComment("PREAMBLE"));
    writer.newLine();
    
    docEnvironment = new TeXEnvironmentImpl(TeXEnvEnum.DOCUMENT);
    writer.writel(docEnvironment.head());
  }
  
  /**
   * Get ITClass used in this document
   * 
   * @return {@link ITClass}
   */
  public ITClass getTeXClass()
  {
    return texClass;
  }
  
  /**
   * Set ITClass used in this document
   * If preamble is already written, this has no effect.
   */
  public void setTeXClass(ITClass c)
  {
    if (!writer.isHeaderWritten())
      texClass = c;
  }
  
  /**
   * Get used package collection
   * 
   * @return {@link ITPackageCollection}
   */
  public ITPackageCollection getPackageCollection()
  {
    return packages;
  }
  
  /**
   * Sets package collection used in this document.
   * If preamble is already written, this has no effect.
   */
  public void setPackageCollection(ITPackageCollection c)
  {
    if (!writer.isHeaderWritten())
      packages = c;
  }
  
  /**
   * Flush buffer to disk
   * 
   * @throws TeXIOException Problem writing to disk
   */
  public void flush() throws TeXIOException
  {
    if (writer.isClosed()) return;
    writer.flush();
  }
  
  /**
   * Close file
   * 
   * @throws TeXIOException Problem writing to disk
   */
  public void close() throws TeXIOException 
  {
    if (writer.isClosed()) return;
    writer.writel(docEnvironment.foot());
    writer.close();
  }
  
  /**
   * Get jTeX file writer
   * 
   * @return {@link TeXWriter}
   */
  public TeXWriter getWriter()
  {
    return writer;
  }
  
  public void eventFired(TeXItemEvent e)
  {
    switch (e.getType()) {
      case ADDED: break;
      case CLOSED: break;
      case CREATED: break;
    }
  }
  
  public static void main(String[] args) 
  throws TeXIOException, TeXInvalidFileException, TeXException 
  {
    TeXClassImpl tc = new TeXClassImpl(TeXClassEnum.ARTICLE);
    tc.addOption(OptionsClassArticle.PRINT_SIDE.withValue("twopage"));
    
    TeXPackageCollectionImpl tpc = new TeXPackageCollectionImpl();
    tpc.addPackage(new TeXPackageImpl(TeXPackageEnum.BABEL).addOption(TeXPackageOptionsEnum.OptionsPackageBabel.SI));
    
    TeXDocument td = new TeXDocument(
        "/home/matej/jtex.tex", 
        tc,
        tpc);
    td.createPreamble();
    
    
    td.close();
  }
}
