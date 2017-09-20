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

public interface TeXPackageOptionsEnum
{
  public String getValue();
  public TeXPackageOptionsEnum withValue(String s);
  
  public enum OptionsPackageBabel implements TeXPackageOptionsEnum {
    EN_US ("american"),
    FR ("french"),
    DE ("german"),
    DE_N ("ngerman"),
    ID_BA ("bahasa"),
    BG ("bulgarian"),
    ES_BA ("basque"),
    ES_CA ("catalan"),
    HR ("croatian"),
    CZ ("czech"),
    DK ("danish"),
    ESPERANTO ("esperanto"),
    NL ("dutch"),
    EE ("estonian"),
    FI ("finnish"),
    GR ("greek"),
    IS ("icelandic"),
    IE ("irish"),
    IT ("italian"),
    LATIN ("latin"),
    HU ("magyar"),
    NO ("norsk"),
    PL ("polish"),
    PT ("portuges"),
    RO ("romanian"),
    RU ("russian"),
    RS ("serbian"),
    SK ("slovak"),
    SI ("slovene"),
    ES ("spanish"),
    SE ("swedish"),
    TR ("turkish"),
    UA ("ukrainian"),
    NOHYPHENATION ("nohyphenation"),
    USER_DEFINED (null);
    
    private String value;
    OptionsPackageBabel(String s){ value = s;}
    
    public TeXPackageOptionsEnum withValue(String s){ value = s; return this;}
    public String getValue() { return value;}
  }
  
  public enum OptionsPackageGeneric implements TeXPackageOptionsEnum {
    USER_DEFINED;
    
    private String value;
    public TeXPackageOptionsEnum withValue(String s){ value = s; return this;}
    public String getValue() { return value;}
  }
}
