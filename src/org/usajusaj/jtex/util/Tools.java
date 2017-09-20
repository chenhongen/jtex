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

import java.util.ArrayList;

/**
 * @author Matej Usaj
 */
public class Tools
{
  public static String[] arrayListToStringArray(ArrayList<String> l)
  {
    return l.toArray(new String[l.size()]);
  }
  
  public static StringBuilder commatize(String... s)
  {
    return elseize(",", s);
  }
  
  public static StringBuilder spaceize(String... s)
  {
    return elseize(" ", s);
  }

  public static StringBuilder elseize(String delim, String... s)
  {
    if (s == null || s.length < 1 || delim == null) return new StringBuilder();
    StringBuilder sb = new StringBuilder();
    for (String x : s)
      sb.append(x).append(delim);
    return sb.replace(sb.length() - delim.length(), sb.length(), "");
  }
}
