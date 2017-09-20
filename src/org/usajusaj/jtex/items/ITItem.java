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
package org.usajusaj.jtex.items;

import java.util.ArrayList;

/**
 * @author Matej Usaj
 */
public abstract class ITItem
{
  private static ArrayList<TeXItemEventListener> listeners;
  private ITItem parent;
  private ArrayList<ITItem> children;
  
  public abstract void addItem(ITItem i);
  
  public abstract String head();
  public abstract String body();
  public abstract String foot();
  
  public static void addListener(TeXItemEventListener l)
  {
    if (listeners == null)
      listeners = new ArrayList<TeXItemEventListener>();
    listeners.add(l);
  }
  
  public static void removeListener(TeXItemEventListener l)
  {
    if (listeners == null) return;
    listeners.remove(l);
  }
  
  public static void fireEvent(TeXItemEvent e)
  {
    if (listeners == null) return;
    for (TeXItemEventListener l : listeners)
      l.eventFired(e);
  }
  
  public ITItem getParent()
  {
    return parent;
  }
  
  public ArrayList<ITItem> getChildren()
  {
    return children;
  }
  
  public static ITItem getTopmostParent(ITItem i)
  {
    ITItem res = i;
    while (res.parent != null)
      res = res.parent;
    return res;
  }
}
