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
package org.usajusaj.jtex.samples;

import java.util.Scanner;

import org.usajusaj.jtex.ITClass;
import org.usajusaj.jtex.TeXClassEnum;
import org.usajusaj.jtex.TeXClassImpl;
import org.usajusaj.jtex.TeXClassOptionsEnum;
import org.usajusaj.jtex.TeXDocument;
import org.usajusaj.jtex.TeXException;
import org.usajusaj.jtex.TeXClassOptionsEnum.OptionsClassGeneric;
import org.usajusaj.jtex.io.TeXIOException;
import org.usajusaj.jtex.io.TeXInvalidFileException;

public class DocumentTest
{
  public static void main(String[] args) throws TeXIOException, TeXInvalidFileException, TeXException
  {
    Scanner s = new Scanner(System.in);
    
    ITClass c = getTClass(s);
    addClassOpts(c, s);
    TeXDocument doc = new TeXDocument("/tmp/t.tex", c);
    doc.createPreamble();
    doc.close();
  }
  
  private static void addClassOpts(ITClass c, Scanner s)
  {
    TeXClassOptionsEnum[] opts = c.getPossibleOptions();
    for (TeXClassOptionsEnum o : opts)
      System.out.println("[" + o.ordinal() + "] " + o.name());
    System.out.println("[" + opts.length + "] USER_DEFINED");

    int i = TeXClassEnum.values().length; // USER_DEFINED
    while (true)
    {
      System.out.print("\nSelect option number: ");
      String in = s.next();
      int val = 0;
      try {
        val = Integer.valueOf(in);
      } catch (NumberFormatException e) {
        if (in.equalsIgnoreCase("x")) System.exit(1);
        else if (in.equalsIgnoreCase("end")) return;
        System.out.print(
            "\tinput a number to select, 'x' to quit or 'end' to finish class options");
        continue;
      }
      
      TeXClassOptionsEnum so = OptionsClassGeneric.USER_DEFINED;
      if (val >= 0 && val < i)
      {
        i = val;
        so = opts[i];
      }
      System.out.println("\tselected " + so);
      
      
      System.out.print("value: ");
      c.addOption(so.withValue(s.next()));
    }
  }
  
  private static ITClass getTClass(Scanner s)
  {
    for (TeXClassEnum t : TeXClassEnum.values())
      System.out.println("[" + t.ordinal() + "] " + t.name());
    
    int i = TeXClassEnum.values().length - 1; // USER_DEFINED
    while (true)
    {
      System.out.print("\nSelect class number: ");
      String in = s.next();
      int val = 0;
      try {
        val = Integer.valueOf(in);
      } catch (NumberFormatException e) {
        if (in.equalsIgnoreCase("x")) System.exit(1);
        System.out.print("\tinput a number, or 'x' to quit");
        continue;
      }
      if (val >= 0 && val <= i)
      {
        i = val;
        System.out.print("\tselected ");
      }
      else System.out.print("\tunknown, defaulting to ");
      break;
    }
    
    TeXClassEnum c = TeXClassEnum.USER_DEFINED;
    for (TeXClassEnum t : TeXClassEnum.values())
      if (t.ordinal() == i) c = t;
    
    System.out.println(c.name());
    
    if (c == TeXClassEnum.USER_DEFINED)
    {
      System.out.print("Give a name for USER_DEFINED class: ");
      c.withValue(s.next());
    }
    
    return new TeXClassImpl(c);
  }
}
