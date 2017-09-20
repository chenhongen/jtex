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

import org.usajusaj.jtex.TeXClassOptionsEnum.OptionsClassArticle;
import org.usajusaj.jtex.TeXClassOptionsEnum.OptionsClassBook;
import org.usajusaj.jtex.TeXClassOptionsEnum.OptionsClassGeneric;
import org.usajusaj.jtex.TeXClassOptionsEnum.OptionsClassReport;


public enum TeXClassEnum {
  /** The article class */
  ARTICLE ("article"),
  /** The book class */
  BOOK ("book"),
  /** The report class */
  REPORT ("report"),
  /** The letter class */
  LETTER ("letter"),
  /** The slides class */
  SLIDES ("slides"),
  /** A document class for proceedings, based on <code>article</code> */
  PROC ("proc"),
  /** 
   * The document class for documenting the LATEX program, based on 
   * <code>article</code> 
   */
  LTX_DOC ("ltxdoc"),
  /** 
   * The document class for LATEX 2e for Authors and LATEX 2e for Class and 
   * Package Writers, based on article. The layout for this class is likely to 
   * change in future releases of LATEX.
   */
  LTX_GUIDE ("ltxguide"),
  /**
   * The document class for the LATEX News information sheet, based on 
   * <code>article</code>. The layout for this class is likely to change in 
   * future releases of LATEX.
   */
  LT_NEWS ("ltnews"),
  /**
   * This class is the bare minimum (3 lines) that is needed in a LATEX class
   * file. It just sets the text width and height, and defines 
   * <code>\normalsize</code>. It is principally intended for debugging and 
   * testing LATEX code in situations where you do not need to load a 'full'
   * class such as <code>article</code>. If, however, you are designing a 
   * completely new class that is aimed for documents with structure radically 
   * different from the structure supplied by the <code>article</code> class, 
   * then it may make sense to use this as a base and add to it code 
   * implementing the required structure, rather than starting from article and 
   * modifying the code there.
   */
  MINIMAL ("minimal"),
  /** User defined document class. Must call setCmd(String)! */
  USER_DEFINED (null);

  private String cmd;

  private TeXClassEnum(String s){ 
    cmd = s;
  }
  
  public String withValue(String v) {
    if (this == USER_DEFINED) {
      cmd = v;
    }
    return cmd;
  }
  
  public String getCmd() {
    return cmd;
  }
  
  public TeXClassOptionsEnum[] getOptions()
  {
    switch (this)
    {
    case ARTICLE: return OptionsClassArticle.values();
    case BOOK: return OptionsClassBook.values();
    case REPORT: return OptionsClassReport.values();
    default : return OptionsClassGeneric.values();
    }
  }
  
  @Override
  public String toString() {
    return cmd;
  }
}
