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

import java.util.ArrayList;

import org.usajusaj.jtex.items.ITItem;
import org.usajusaj.jtex.items.TeXItemEnum;
import org.usajusaj.jtex.items.TeXItemEvent;
import org.usajusaj.jtex.util.TeXCommands;

/**
 * @author Matej Usaj
 */
public class TeXEnvironmentImpl extends ITItem
{
  private String env;
  private ArrayList<ITItem> a;
  
  public TeXEnvironmentImpl(TeXEnvEnum e)
  {
    this(e.getCmd());
  }
  
  public TeXEnvironmentImpl(String e)
  {
    env = e;
    a = new ArrayList<ITItem>();
  }
  
  @Override
  public void addItem(ITItem i)
  {
    a.add(i);
    fireEvent(new TeXItemEvent(this, TeXItemEnum.CREATED));
  }

  @Override
  public String body()
  {
    return "";
  }

  @Override
  public String foot()
  {
    return TeXCommands.end(env);
  }

  @Override
  public String head()
  {
    return TeXCommands.begin(env);
  }
}
