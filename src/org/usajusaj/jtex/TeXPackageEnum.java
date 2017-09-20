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

public enum TeXPackageEnum
{
  /* LATEX STANDARD PACKAGES: */
  /**
   * This package provides the alltt environment, which is like the 
   * <code>verbatim</code> environment except that <code>\</code>, 
   * <code>{</code>, and <code>}</code> have their usual meanings
   */
  ALLTT ("alltt"),
  /**
   * This is the basic package for typesetting the documentation of LATEX 
   * programs
   */
  DOC ("doc"),
  /** This provides scaled versions of the math extension font */
  EXSCALE ("exscale"),
  /** This is used to specify which font encoding LATEX should use */
  FONTENC ("fontenc"),
  /** 
   * This package defines the <code>\graphpaper</code> command; this can be used
   * in a picture environment
   */
  GRAPHPAP ("graphpap"),
  /**
   * Provides commands of the form <code>if... then do... otherwise do...</code>
   */
  IFTHEN ("ifthen"),
  /** This is used to specify which input encoding LATEX should use */
  INPUT_ENC ("inputenc"),
  /**
   * LATEX 2e no longer loads the LATEX symbol font by default. To access it, 
   * you should use the latexsym package
   */
  LATEXSYM ("latexsym"),
  /** This provides commands for producing indexes */
  MAKE_INDEX ("makeidx"),
  /**
   * This is used to emulate the font commands of LATEX 2.09 with the New Font 
   * Selection Scheme
   */
  NEW_LFONT ("newlfont"),
  /** This is used to emulate the font commands of LATEX 2.09 */
  OLD_LFONT ("oldlfont"),
  /**
   * This causes the argument of each <code>\index</code> command to be printed 
   * on the page where it occurs
   */
  SHOW_INDEX ("showidx"),
  /** This is used to process a document without typesetting it */
  SYNTONLY ("syntonly"),
  /**
   * This allows you to control how much information about LATEX's font loading 
   * is displayed
   */
  TRACE_FONT ("tracefnt"),
  
  /* LATEX POPULAR PACKAGES: */
  /**
   * Advanced mathematical typesetting from the American Mathematical Society. 
   * This includes the <code>amsmath</code> package; it provides many commands 
   * for typesetting mathematical formulas of higher complexity. It is produced 
   * and supported by the American Mathematical Society
   */
  AMS_LATEX ("amslatex"),
  /** This package and related files support typesetting in many languages */
  BABEL ("babel"),
  /**
   * Everything you need (except the fonts themselves) for typesetting with
   * Cyrillic fonts
   */
  CYRILLIC ("cyrillic"),
  /**
   * This includes the graphics package which provides support for the inclusion 
   * and transformation of graphics, including files produced by other software. 
   * Also included, is the <code>color</code> package which provides support for
   * typesetting in colour
   */
  GRAPHICS ("graphics"),
  /**
   * Everything you need (except the fonts themselves) for typesetting with a 
   * large range of Type 1 (PostScript) fonts.
   */
  PSNFSS ("psnfss"),
  /** Miscellaneous packages written by the LATEX3 project team */
  TOOLS ("tools"),
  
  /* LATEX OTHER PACKAGES: */
  /**
   * Extended versions of the environments <code>array</code>, 
   * <code>tabular</code> and <code>tabular*</code>, with many extra features
   */
  ARRAY ("array"),
  /**
   * Enables the use of certain algebraic notation when specifying values for 
   * lengths and counters
   */
  CALC ("calc"),
  /**
   * Alignment on 'decimal points' in <code>tabular</code> entries. Requires the 
   * <code>array</code> package.
   */
  DCOLUMN ("dcolumn"),
  /** Adds 'large delimiters' around arrays. Requires <code>array</code> */
  DELARRAY ("delarray"),
  /**
   * Finer control over horizontal rules in tables. Requires <code>array</code> 
   */
  HHLINE ("hhline"),
  /**
   * Multi-page tables. (Does not require <code>array</code>, but it uses the 
   * extended features if both are loaded.)
   */
  LONG_TABLE ("longtable"),
  /**
   * Defines a tabularx environment that is similar to <code>tabular*</code> but 
   * it modifies the column widths, rather than the inter-column space, to 
   * achieve the desired table width
   */
  TABULARX ("tabularx"),
  /** Place text after the current page */
  AFTERPAGE ("afterpage"),
  /** Access bold math symbols */
  BM ("bm"),
  /** Extended version of the enumerate environment */
  ENUMERATE ("enumerate"),
  /** Package and test file for producing 'font samples'" */
  FONTSMPL ("fontsmpl"),
  /**  Place all footnotes in the right-hand column in two-column mode */
  FTNRIGHT ("ftnright"),
  /** Indent the first paragraph of sections, etc */
  INDENT_FIRST ("indentfirst"),
  /** Show the page layout defined by the current document class */
  LAYOUT ("layout"),
  /** Typeset text in columns, with the length of the columns 'balanced' */
  MULTICOL ("multicol"),
  /** Preload fonts using the old internal font names of LATEX 2.09 */
  RAWFONTS ("rawfonts"),
  /** Selective handling of package options. (Used by the rawfonts pack-age.) */
  SOMEDEFS ("somedefs"),
  /**
   * Prints the 'keys' used by <code>\label</code>, <code>\ref</code>, 
   * <code>\cite</code> etc.; useful whilst drafting
   */
  SHOW_KEYS ("showkeys"),
  /** Flexible declaration of 'theorem-like' environments */
  THEOREM ("theorem"),
  /** 'Smart' handling of page references */
  VARIOREF ("varioref"),
  /** Flexible extension of the verbatim environment */
  VERBATIM ("verbatim"),
  /** Cross reference other 'external' documents */
  XR ("xr"),
  /**
   * 'Smart space' command that helps you to avoid the common mistake of missing 
   * spaces after command names.
   */
  XSPACE ("xspace"),
  /** User defined package. Must call setCmd(String)! */
  USER_DEFINED (null);
  
  /* NOTE: Check if this packages are necessary
   * FONT_ENC ("fontenc"),
   * TEXT_COMP ("textcomp"),
   * UCS ("ucs"),
   * AMS_MATH ("amsmath"),
   * GRAPHICX ("graphicx"),
   * FANCY_HEADERS ("fancyhdr"),
   */
  
  private String cmd;

  TeXPackageEnum(String s)
  {
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
