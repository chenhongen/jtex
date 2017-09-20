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

public interface TeXClassOptionsEnum
{
  String getValue();
  String withValue(String s);
  TeXClassOptionsEnum[] getValues();
  int ordinal();
  String name();
  
  public enum OptionsClassArticle implements TeXClassOptionsEnum {
    BODY_TEXT_SIZE,
    PAPER_SIZE,
    ORIENTATION,
    PRINT_SIDE,
    QUALITY,
    TITLE_PAGE,
    COLUMNS,
    EQUATION_NUM,
    EQUATION_POS,
    BIB_STYLE;
    
    private String value;
    public String withValue(String s){ value = s; return value;}
    public String getValue() { return value;}
    public TeXClassOptionsEnum[] getValues() { return values();}
  }
  
  public enum OptionsClassBook implements TeXClassOptionsEnum {
    BODY_TEXT_SIZE,
    PAPER_SIZE,
    ORIENTATION,
    PRINT_SIDE,
    QUALITY,
    TITLE_PAGE,
    COLUMNS,
    CHAPTER_ON_LEFT,
    EQUATION_NUM,
    EQUATION_POS,
    BIB_STYLE;
    
    private String value;
    public String withValue(String s){ value = s; return value;}
    public String getValue() { return value;}
    public TeXClassOptionsEnum[] getValues() { return values();}
  }
  
  public enum OptionsClassReport implements TeXClassOptionsEnum {
    BODY_TEXT_SIZE,
    PAPER_SIZE,
    ORIENTATION,
    PRINT_SIDE,
    QUALITY,
    TITLE_PAGE,
    COLUMNS,
    CHAPTER_ON_LEFT,
    EQUATION_NUM,
    EQUATION_POS,
    BIB_STYLE;
    
    private String value;
    public String withValue(String s){ value = s; return value;}
    public String getValue() { return value;}
    public TeXClassOptionsEnum[] getValues() { return values();}
  }
  
  public enum OptionsClassGeneric implements TeXClassOptionsEnum {
    USER_DEFINED;
    
    private String value;
    public String withValue(String s){ value = s; return value;}
    public String getValue() { return value;}
    public TeXClassOptionsEnum[] getValues() { return values();}
  }

  public enum OptionsValuesClass{
    TXTSIZE_10PT ("10pt"),
    TXTSIZE_11PT ("11pt"),
    TXTSIZE_12PT ("12pt"),
    PAPER_A4 ("a4paper"),
    PAPER_LETTER ("letterpaper"),
    PAPER_A5 ("a5paper"),
    PAPER_B5 ("b5paper"),
    PAPER_EXECUTIVE ("executivepaper"),
    PAPER_LEGAL ("legalpaper"),
    FLEQN ("fleqn"),
    LEQNO ("leqno"),
    TITLE_PAGE ("titlepage"),
    NO_TITLE_PAGE ("notitlepage"),
    COL_ONE ("onecolumn"),
    COL_TWO ("twocolumn"),
    SIDE_ONE ("oneside"),
    SIDE_TWO ("twoside"),
    LANDSCAPE ("landscape"),
    OPEN_RIGHT ("openright"),
    OPEN_ANY ("openany"),
    DRAFT ("draft");
    
    OptionsValuesClass(String s) {
      value = s;
    }
    
    private String value;
    public String getValue() { return value;}
  }
}
