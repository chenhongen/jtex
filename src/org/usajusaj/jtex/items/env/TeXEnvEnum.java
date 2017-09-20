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
package org.usajusaj.jtex.items.env;

import org.usajusaj.jtex.util.GenericConstEnum;

public enum TeXEnvEnum implements GenericConstEnum
{
  DOCUMENT ("document"),
  COMMENT ("comment"),
  ENUMERATE ("enumerate"),
  ITEMIZE ("itemize"),
  DESCRIPTION ("description"),
  FLUSH_LEFT ("flushleft"),
  FLUSH_RIGHT ("flushright"),
  CENTER ("center"),
  QUOTE ("quote"),
  QUOTATION ("quotation"),
  VERSE ("verse"),
  ABSTRACT ("abstract"),
  VERBATIM ("verbatim"),
  VERBATIM_SPACES ("verbatim*"),
  TABULAR ("tabular"),
  FIGURE ("figure"),
  TABLE ("table"),
  BIBLIOGRAPHY ("thebibliography"),
  USER_DEFINED (null);

  private String cmd;

  private TeXEnvEnum(String s){ 
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
  
  @Override
  public String toString() {
    return cmd;
  }
}
