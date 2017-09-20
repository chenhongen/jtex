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
package org.usajusaj.jtex.util;

public class TeXCharacters
{
  public static final String CROSSHATCH = "\\#";
  public static final String DOLLAR_SIGN = "\\$";
  public static final String PERCENT_SIGN = "\\%";
  public static final String CIRCUMFLEX = "\\^{}";
  public static final String AMPERSAND = "\\&";
  public static final String UNDERSCORE = "\\_";
  public static final String LEFT_BRACE = "\\{";
  public static final String RIGHT_BRACE = "\\}";
  public static final String TILDE_ABOVE = "\\~{}";
  public static final String TILDE = "$\\sim$";
  public static final String BACKSLASH = "$\\backslash$";
  
  public static final String DISCRETE_HYPHEN = "\\-";
  public static final String HYPHEN = "-";
  public static final String EN_DASH = "--";
  public static final String EM_DASH = "---";
  
  public static final String DEGREE = "\\textcelsius";
  
  public static final String EURO = "\\texteuro";
  
  public static final String QUOT_DOUBLE_OPEN = "``";
  public static final String QUOT_DOUBLE_CLOSE = "''";
  public static final String QUOT_SINGLE_OPEN = "`";
  public static final String QUOT_SINGLE_CLOSE = "'";
  
  public static final String ACC_GRAVE = "\\‘";
  public static final String ACC_ACCUTE = "\\’";
  public static final String ACC_ACCUTE_DOUBLE = "\\H ";
  public static final String ACC_CIRCUMFLEX = "\\^";
  public static final String ACC_TILDE = "\\~";
  public static final String ACC_MACRON_ABOVE = "\\=";
  public static final String ACC_MACRON_BELOW = "\\b ";
  public static final String ACC_DOT_ABOVE = "\\.";
  public static final String ACC_DOT_BELOW = "\\d ";
  public static final String ACC_UMLAUT = "\\\"";
  public static final String ACC_CEDILLA = "\\c ";
  public static final String ACC_BREVE = "\\u ";
  public static final String ACC_CARON = "\\v ";
  public static final String ACC_TITLO = "\\t ";
  
  public static final String OE_LOWER = "\\oe ";
  public static final String OE_UPPER = "\\OE ";
  public static final String AE_LOWER = "\\ae ";
  public static final String AE_UPPER = "\\AE ";
  public static final String A_CIRCLE_LOWER = "\\aa ";
  public static final String A_CIRCLE_UPPER = "\\AA ";
  public static final String O_SLASH_LOWER = "\\o ";
  public static final String O_SLASH_UPPER = "\\O ";
  public static final String L_SLASH_LOWER = "\\l ";
  public static final String L_SLASH_UPPER = "\\L ";
  public static final String NO_DOT_I = "\\i ";
  public static final String NO_DOT_J = "\\j ";
  public static final String MARK_QUESTION_INV = "?‘";
  public static final String MARK_EXCLAMATION_INV = "!‘";
  public static final String DOUBLE_S = "\\ss{}";
  
  public static final String deLigaturate(String w)
  {
    w.replace(
        "ff", 
        new StringBuilder("f").append(TeXCommands.mbox(null)).append("f"));
    
    w.replace(
        "fi", 
        new StringBuilder("f").append(TeXCommands.mbox(null)).append("i"));
    
    w.replace(
        "fl", 
        new StringBuilder("f").append(TeXCommands.mbox(null)).append("l"));

    return w;
  }
}
