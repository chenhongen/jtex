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

import java.util.ArrayList;

import org.usajusaj.jtex.util.TeXCommands;
import org.usajusaj.jtex.util.Tools;

public class TeXPackageImpl implements ITPackage
{
  private String name;
  private ArrayList<String> options;
  
  public TeXPackageImpl(TeXPackageEnum name)
  {
    this(name.getCmd());
  }

  public TeXPackageImpl(String name, String... options)
  {
    this.name = name;
    this.options = new ArrayList<String>();
    for (String s : options)
      addOption(s);
  }

  @Override
  public ITPackage addOption(String o) {
    if (!options.contains(o)) options.add(o);
    return this;
  }

  public ITPackage addOption(TeXPackageOptionsEnum o) {
    return addOption(o.getValue());
  }

  @Override
  public void clearOptions() {
    options.clear();
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getString() {
    return TeXCommands.usePackage(name, Tools.arrayListToStringArray(options));
  }

  @Override
  public void removeOption(String o) {
    options.remove(o);
  }

  @Override
  public void setName(String n) {
    name = n;
  }

  @Override
  public boolean equals(ITPackage p) {
    return name.equals(p.getName());
  }
}
