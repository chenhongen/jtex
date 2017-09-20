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
import java.util.Iterator;

public class TeXPackageCollectionImpl implements ITPackageCollection
{
  private ArrayList<ITPackage> packages;
  
  public TeXPackageCollectionImpl(ITPackage... packages)
  {
    this.packages = new ArrayList<ITPackage>();
    for (ITPackage p : packages)
      this.packages.add(p);
  }
  
  @Override
  public ITPackageCollection addPackage(ITPackage p)
  {
    for (ITPackage pp : packages)
      if (pp.equals(p)) return this;
    packages.add(p);
    return this;
  }

  @Override
  public void clearPackages()
  {
    packages.clear();
  }

  @Override
  public ITPackage getPackage(String p)
  {
    for (ITPackage pp : packages)
      if (pp.getName().equals(p)) return pp;
    return null;
  }

  @Override
  public void removePackage(ITPackage p)
  {
    packages.remove(p);
  }

  @Override
  public void removePackage(String p)
  {
    ITPackage pp = getPackage(p);
    if (pp != null) packages.remove(pp);
  }

  @Override
  public Iterator<ITPackage> iterator()
  {
    return packages.iterator();
  }
}
