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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public final class TeXCommands
{
  //TODO makebox, page 46, chapter 2.12
  
  public static final String CMD_TODAY = "\\today";
  public static final String CMD_TEX_LOGO = "\\TeX";
  public static final String CMD_LATEX_LOGO = "\\LaTeX";
  public static final String CMD_LATEXE_LOGO = "\\LaTeXe";
  public static final String CMD_LINE_BREAK = "\\\\";
  public static final String CMD_NEW_LINE = "\\newline";
  public static final String CMD_NEW_PAGE = "\\newpage";
  public static final String CMD_LINE_BREAK_NO_PAGE_BREAK = "\\\\*";
  public static final String CMD_MAKE_TITLE = "\\maketitle";
  public static final String CMD_TABLE_OF_CONTENTS = "\\tableofcontents";
  public static final String CMD_LIST_OF_FIGURES = "\\listoffigures";
  public static final String CMD_LIST_OF_TABLES = "\\listoftables";
  public static final String CMD_LOW_DOTS = "\\ldots{}";
  public static final String CMD_LOW_SLOPPY = "\\sloppy";
  public static final String CMD_FRENCH_SPACING = "\\frenchspacing";
  public static final String CMD_FIXED_SPACE = "~";
  public static final String CMD_PART = "\\part";
  public static final String CMD_APPENDIX = "\\appendix";
  public static final String CMD_FRONT_MATTER = "\\frontmatter";
  public static final String CMD_BACK_MATTER = "\\backmatter";
  public static final String CMD_MAIN_MATTER = "\\mainmatter";
  public static final String CMD_FLUSH_LEFT = "\\flushleft";
  public static final String CMD_ITEM = "\\item";
  public static final String CMD_TAB_P_WIDTH = "p{width}";
  public static final String CMD_TAB_NEXT_COL = "&";
  public static final String CMD_TAB_NEW_ROW = CMD_LINE_BREAK;
  public static final String CMD_TAB_HORIZ_LINE = "\\hline";
  public static final String CMD_TAB_ALIGN_COL_LEFT = "l";
  public static final String CMD_TAB_ALIGN_COL_RIGHT = "r";
  public static final String CMD_TAB_ALIGN_COL_CENTER = "c";
  public static final String CMD_TAB_VERT_LINE = "|";
  public static final String CMD_TAB_ALIGN_ROW_TOP = "t";
  public static final String CMD_TAB_ALIGN_ROW_BOTTOM = "b";
  public static final String CMD_TAB_ALIGN_ROW_CENTER = "c";
  public static final String CMD_FLOAT_HERE = "h";
  public static final String CMD_FLOAT_TOP = "t";
  public static final String CMD_FLOAT_BOTTOM = "b";
  public static final String CMD_FLOAT_OWN_PAGE = "p";
  public static final String CMD_FLOAT_IGNORE = "!";
  public static final String CMD_CLEAR_PAGE = "\\clearpage";
  public static final String CMD_CLEAR_PAGE_DOUBLE = "\\cleardoublepage";
  public static final String CMD_PROTECT = "\\protect";
  public static final String CMD_CENTERING = "\\centering";
  public static final String CMD_TEXT_WIDTH = "\\textwidth";
  public static final String CMD_MAKE_INDEX = "\\makeindex";
  public static final String CMD_PRINT_INDEX = "\\printindex";
  
  public static final String italic(String s)
  {
    if (s == null) return null;
    return commandArg("textsl", s);
  }
  
  public static final String italic2(String s)
  {
    if (s == null) return null;
    return commandArg("textit", s);
  }

  public static final String sansSerif(String s)
  {
    if (s == null) return null;
    return commandArg("textsf", s);
  }
  
  public static final String typeWriter(String s)
  {
    if (s == null) return null;
    return commandArg("texttt", s);
  }

  public static final String lineComment(String c)
  {
    if (c == null) return null;
    return new StringBuilder("% ")
        .append(c).toString();
  }
  
  public static final String multiLineComment(String... s)
  {
    StringBuilder sb = new StringBuilder();
    for (String x : s)
      sb.append(lineComment(x)).append("\n");
    return sb.toString();
  }
  
  public static final String documentClass(String c, String... parms)
  {
    if (c == null) return null;
    return commandArgParm("documentclass", c, parms);
  }
  
  public static final String usePackage(String p, String... parms)
  {
    if (p == null) return null;
    return commandArgParm("usepackage", p, parms);
  }
  
  public static final String beginDocument()
  {
    return begin(TeXConstants.ENV_DOCUMENT);
  }
  
  public static final String beginComment()
  {
    return begin(TeXConstants.ENV_COMMENT);
  }

  public static final String beginEnumerate()
  {
    return begin(TeXConstants.ENV_ENUMERATE);
  }

  public static final String beginItemize()
  {
    return begin(TeXConstants.ENV_ITEMIZE);
  }

  public static final String beginDescription()
  {
    return begin(TeXConstants.ENV_DESCRIPTION);
  }

  public static final String beginFlushLeft()
  {
    return begin(TeXConstants.ENV_FLUSH_LEFT);
  }

  public static final String beginFlushRight()
  {
    return begin(TeXConstants.ENV_FLUSH_RIGHT);
  }

  public static final String beginCenter()
  {
    return begin(TeXConstants.ENV_CENTER);
  }

  public static final String beginQuote()
  {
    return begin(TeXConstants.ENV_QUOTE);
  }

  public static final String beginQuotation()
  {
    return begin(TeXConstants.ENV_QUOTATION);
  }

  public static final String beginVerse()
  {
    return begin(TeXConstants.ENV_VERSE);
  }

  public static final String beginAbstract()
  {
    return begin(TeXConstants.ENV_ABSTRACT);
  }

  public static final String beginVerbatim()
  {
    return begin(TeXConstants.ENV_VERBATIM);
  }

  public static final String beginVerbatimShowSpace()
  {
    return begin(TeXConstants.ENV_VERBATIM_SPACES);
  }

  public static final String beginTabular(String pos, String spec)
  {
    if (spec == null || spec.equals("")) return null;
    StringBuilder sb = new StringBuilder(begin(TeXConstants.ENV_TABULAR));
    if (pos != null && !pos.equals("")) sb.append(embracket(pos));
    sb.append(embrace(spec));
    
    return sb.toString();
  }

  public static final String beginFigure(String placement)
  {
    StringBuilder sb = new StringBuilder(begin(TeXConstants.ENV_FIGURE));
    if (placement != null && !placement.equals("")) sb.append(embrace(placement));
    
    return sb.toString();
  }

  public static final String beginTable(String placement)
  {
    StringBuilder sb = new StringBuilder(begin(TeXConstants.ENV_TABLE));
    if (placement != null && !placement.equals("")) sb.append(embrace(placement));
    
    return sb.toString();
  }
  
  public static final String beginBibliography(int maxW)
  {
    return new StringBuilder(begin(TeXConstants.ENV_BIBLIOGRAPHY)).append(embrace(String.valueOf(maxW))).toString();
  }

  public static final String begin(String env)
  {
    if (env == null) return null;
    return commandArg("begin", env);
  }

  public static final String endDocument()
  {
    return end(TeXConstants.ENV_DOCUMENT);
  }
  
  public static final String endComment()
  {
    return end(TeXConstants.ENV_COMMENT);
  }

  public static final String endEnumerate()
  {
    return end(TeXConstants.ENV_ENUMERATE);
  }

  public static final String endItemize()
  {
    return end(TeXConstants.ENV_ITEMIZE);
  }
  
  public static final String endDescription()
  {
    return end(TeXConstants.ENV_DESCRIPTION);
  }
  
  public static final String endFlushLeft()
  {
    return end(TeXConstants.ENV_FLUSH_LEFT);
  }
  
  public static final String endFlushRight()
  {
    return end(TeXConstants.ENV_FLUSH_RIGHT);
  }
  
  public static final String endCenter()
  {
    return end(TeXConstants.ENV_CENTER);
  }
  
  public static final String endQuote()
  {
    return end(TeXConstants.ENV_QUOTE);
  }
  
  public static final String endQuotation()
  {
    return end(TeXConstants.ENV_QUOTATION);
  }
  
  public static final String endVerse()
  {
    return end(TeXConstants.ENV_VERSE);
  }
  
  public static final String endAbstract()
  {
    return end(TeXConstants.ENV_ABSTRACT);
  }
  
  public static final String endVerbatim()
  {
    return end(TeXConstants.ENV_VERBATIM);
  }
  
  public static final String endVerbatimShowSpace()
  {
    return end(TeXConstants.ENV_VERBATIM_SPACES);
  }
  
  public static final String endTabular()
  {
    return end(TeXConstants.ENV_TABULAR);
  }

  public static final String endFigure()
  {
    return end(TeXConstants.ENV_FIGURE);
  }

  public static final String endTable()
  {
    return end(TeXConstants.ENV_TABLE);
  }

  public static final String endBibliography()
  {
    return end(TeXConstants.ENV_BIBLIOGRAPHY);
  }

  public static final String end(String env)
  {
    if (env == null) return null;
    return commandArg("end", env);
  }
  
  public static final String verbatimInline(String s, char delim)
  {
    if (s == null || delim == '*' || delim == ' ') return null;
    return new StringBuilder("\\verb").append(delim).append(s).append(delim).toString();
  }
  
  public static final String verbatimInlineShowSpace(String s, char delim)
  {
    if (s == null || delim == '*' || delim == ' ') return null;
    return new StringBuilder("\\verb*").append(delim).append(s).append(delim).toString();
  }
  
  public static final String caption(String s, String l)
  {
    if (l == null) return null;
    StringBuilder sb = new StringBuilder("\\")
        .append("caption");
    if (s != null) sb.append(embracket(s));
    return sb.append(embrace(l)).toString();
  }
  
  public static final String item(String n)
  {
    return commandParm("item", n);
  }
  
  public static final String tabPartialLine(int cBegin, int cEnd)
  {
    if (cBegin < 1 || cEnd < 1) return null;
    return commandArg(
        "cline", 
        new StringBuilder(cBegin).append("-").append(cEnd).toString());
  }
  
  public static final String tabColWidth(String w)
  {
    if (w == null || w.equals("")) return null;
    return commandArg("p", w);
  }
  
  public static final String tabVerticalLinePattern(String p)
  {
    if (p == null) return null;
    return new StringBuilder("@").append(embrace(p)).toString();
  }
  
  public static final String tabMultiColumn(int n, String pattern, String name)
  {
    if (n < 2 || pattern == null || pattern.equals("") || name == null) return null;
    return new StringBuilder(commandArg("multicolumn", String.valueOf(n)))
        .append(embrace(pattern)).append(embrace(name)).toString();
  }

  public static final String author(String a)
  {
    if (a == null) return null;
    return commandArg("author", a);
  }
  
  public static final String authors(String... a)
  {
    if (a == null) return null;
    return commandArg("author", elseize("\\and", a).toString());
  }

  public static final String title(String t)
  {
    if (t == null) return null;
    return commandArg("title", t);
  }
  
  public static final String date(String t)
  {
    if (t == null) return null;
    return commandArg("date", t);
  }

  public static final String section(String s)
  {
    if (s == null) return null;
    return commandArg("section", s);
  }

  public static final String subSection(String s)
  {
    if (s == null) return null;
    return commandArg("subsection", s);
  }

  public static final String subSubSection(String s)
  {
    if (s == null) return null;
    return commandArg("subsubsection", s);
  }
  
  public static final String paragraph(String s)
  {
    if (s == null) return null;
    return commandArg("paragraph", s);
  }

  public static final String subParagraph(String s)
  {
    if (s == null) return null;
    return commandArg("subparagraph", s);
  }
  
  public static final String part(String s)
  {
    if (s == null) return null;
    return commandArg("part", s);
  }

  public static final String chapter(String s)
  {
    if (s == null) return null;
    return commandArg("chapter", s);
  }

  public static final String chapter(String s, String entry)
  {
    if (s == null || entry == null) return null;
    return commandArgParm("chapter", s, entry);
  }

  public static final String pageStyle(String s)
  {
    if (s == null) return null;
    return commandArg("pagestyle", s);
  }

  public static final String thisPageStyle(String s)
  {
    if (s == null) return null;
    return commandArg("thispagestyle", s);
  }
  
  public static final String include(String file)
  {
    if (file == null) return null;
    return commandArg("include", file);
  }

  public static final String includeOnly(String... files)
  {
    if (files == null) return null;
    return commandArg("includeonly", commatize(files).toString());
  }
  
  public static final String input(String i)
  {
    if (i == null) return null;
    return commandArg("input", i);
  }
  
  public static final String lineBreak(int i)
  {
    if (i < 0 || i > 4) return null;
    return commandParm("linebreak", String.valueOf(i));
  }

  public static final String noLineBreak(int i)
  {
    if (i < 0 || i > 4) return null;
    return commandParm("nolinebreak", String.valueOf(i));
  }

  public static final String pageBreak(int i)
  {
    if (i < 0 || i > 4) return null;
    return commandParm("pagebreak", String.valueOf(i));
  }

  public static final String noPageBreak(int i)
  {
    if (i < 0 || i > 4) return null;
    return commandParm("nopagebreak", String.valueOf(i));
  }
  
  public static final String hyphenation(String... l)
  {
    if (l == null || l.length < 1) return null;
    return commandArg("hyphenation", spaceize(l).toString());
  }
  
  public static final String mbox(String t)
  {
    if (t == null) t = "";
    return commandArg("mbox", t);
  }

  public static final String fbox(String t)
  {
    if (t == null) return null;
    return commandArg("fbox", t);
  }

  public static final String emph(String t)
  {
    if (t == null) return null;
    return commandArg("emph", t);
  }
  
  public static final String underline(String t)
  {
    if (t == null) return null;
    return commandArg("underline", t);
  }
  
  public static final String quotateDouble(String s)
  {
    return new StringBuilder(TeXCharacters.QUOT_DOUBLE_OPEN)
        .append(s).append(TeXCharacters.QUOT_DOUBLE_CLOSE).toString();
  }
  
  public static final String quotateSingle(String s)
  {
    return new StringBuilder(TeXCharacters.QUOT_SINGLE_OPEN)
        .append(s).append(TeXCharacters.QUOT_SINGLE_CLOSE).toString();
  }
  
  public static final String activateLanguage(String lang)
  {
    if (lang == null) return null;
    return commandArg("selectlanguage", lang);
  }
  
  public static final String unNumber(String s)
  {
    if (s == null) return null;
    
    StringBuilder sb = new StringBuilder(s);
    int i = sb.indexOf("[");
    if (i < 0) i = sb.indexOf("{");
    if (i < 0) return sb.toString();
    
    sb.insert(i, '*');
    
    return sb.toString();
  }

  public static final String label(String l)
  {
    if (l == null) return null;
    return commandArg("label", l);
  }

  public static final String ref(String r)
  {
    if (r == null) return null;
    return commandArg("ref", r);
  }

  public static final String pageRef(String r)
  {
    if (r == null) return null;
    return commandArg("pageref", r);
  }

  public static final String footnote(String f)
  {
    if (f == null) return null;
    return commandArg("footnote", f);
  }
  
  public static final String includeGraphics(String w, String h, String angle, String scale, String file)
  {
    ArrayList<String> a = new ArrayList<String>();
    if (w != null && !w.equals("")) a.add(elseize("=", TeXConstants.GRAPHIC_WIDTH, w).toString());
    if (h != null && !h.equals("")) a.add(elseize("=", TeXConstants.GRAPHIC_HEIGHT, h).toString());
    if (angle != null && !angle.equals("")) a.add(elseize("=", TeXConstants.GRAPHIC_ANGLE, angle).toString());
    if (scale != null && !scale.equals("")) a.add(elseize("=", TeXConstants.GRAPHIC_SCALE, scale).toString());
    
    return commandArgParm("includegraphics", file, commatize((String[])a.toArray()).toString());
  }
  
  public static final String bibitem(String label, String marker)
  {
    if (marker == null || marker.length() == 0) return null;
    StringBuilder sb = new StringBuilder("\\bibitem");
    if (label != null && label.length() == 0) sb.append(embracket(label));
    return sb.append(embrace(marker)).toString();
  }
  
  public static final String cite(String marker)
  {
    return commandArg("cite", marker);
  }

  public static final String index(String key)
  {
    return commandArg("index", key);
  }

  private static final String commandArg(String cmd, String arg)
  {
    assert cmd != null && arg != null : cmd;
    return new StringBuilder("\\")
        .append(cmd).append(embrace(arg)).toString();
  }

  private static final String commandParm(String cmd, String parm)
  {
    assert cmd != null && parm != null : cmd;
    return new StringBuilder("\\")
        .append(cmd).append(embracket(parm)).toString();
  }

  private static final String commandArgParm(String cmd, String arg, String... parm)
  {
    assert cmd != null && arg != null && parm != null: cmd;
    return new StringBuilder("\\")
        .append(cmd).append(embracket(parm)).append(embrace(arg)).toString();
  }
  
  private static final StringBuilder embrace(String s)
  {
    assert s != null : s;
    return new StringBuilder("{").append(s).append("}");
  }

  private static final StringBuilder embracket(String... s)
  {
    if (s == null || s.length < 1) return new StringBuilder();
    return new StringBuilder("[").append(commatize(s)).append("]");
  }
  
  private static final StringBuilder commatize(String... s)
  {
    if (s == null || s.length < 1) return new StringBuilder();
    StringBuilder sb = new StringBuilder();
    for (String x : s)
      sb.append(x).append(",");
    return sb.replace(sb.length() - 1, sb.length(), "");
  }
  
  private static final StringBuilder spaceize(String... s)
  {
    if (s == null || s.length < 1) return new StringBuilder();
    StringBuilder sb = new StringBuilder();
    for (String x : s)
      sb.append(x).append(" ");
    return sb.replace(sb.length() - 1, sb.length(), "");
  }

  private static final StringBuilder elseize(String delim, String... s)
  {
    if (s == null || s.length < 1 || delim == null) return new StringBuilder();
    StringBuilder sb = new StringBuilder();
    for (String x : s)
      sb.append(x).append(delim).append(" ");
    return sb.replace(sb.length() - 1 - delim.length(), sb.length(), "");
  }

  public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    String n = null;
    int testimin = Integer.MIN_VALUE;
    int testineg = -1;
    int testipos = 1;
    int testimax = Integer.MAX_VALUE;
    String testE = "";
    String testOne = "1";
    String testMulti = "123";
    
    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("italic", null, n); break;
      case 1: testMethod("italic", "\\textsl{}", testE); break;
      case 2: testMethod("italic", "\\textsl{1}", testOne); break;
      case 3: testMethod("italic", "\\textsl{123}", testMulti); break;
      default: assert false;
      }
    
    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("lineComment", null, n); break;
      case 1: testMethod("lineComment", "% ", testE); break;
      case 2: testMethod("lineComment", "% 1", testOne); break;
      case 3: testMethod("lineComment", "% 123", testMulti); break;
      default: assert false;
      }
/*
    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("documentClass", null, n, n); break;
      case 1: testMethod("documentClass", "\\begin{comment}\nend{comment}", testE, "hehe"); break;
      case 2: testMethod("documentClass", "\\begin{comment}\n1\nend{comment}", testOne); break;
      case 3: testMethod("documentClass", "\\begin{comment}\n1\n2\n3\nend{comment}", testMulti); break;
      default: assert false;
      }
*/
    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("usePackage", null, n); break;
      case 1: testMethod("usePackage", "\\usepackage{}", testE); break;
      case 2: testMethod("usePackage", "\\usepackage{1}", testOne); break;
      case 3: testMethod("usePackage", "\\usepackage{123}", testMulti); break;
      default: assert false;
      }
    
    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("author", null, n); break;
      case 1: testMethod("author", "\\author{}", testE); break;
      case 2: testMethod("author", "\\author{1}", testOne); break;
      case 3: testMethod("author", "\\author{123}", testMulti); break;
      default: assert false;
      }

    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("title", null, n); break;
      case 1: testMethod("title", "\\title{}", testE); break;
      case 2: testMethod("title", "\\title{1}", testOne); break;
      case 3: testMethod("title", "\\title{123}", testMulti); break;
      default: assert false;
      }

    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("section", null, n); break;
      case 1: testMethod("section", "\\section{}", testE); break;
      case 2: testMethod("section", "\\section{1}", testOne); break;
      case 3: testMethod("section", "\\section{123}", testMulti); break;
      default: assert false;
      }

    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("pageStyle", null, n); break;
      case 1: testMethod("pageStyle", "\\pagestyle{}", testE); break;
      case 2: testMethod("pageStyle", "\\pagestyle{1}", testOne); break;
      case 3: testMethod("pageStyle", "\\pagestyle{123}", testMulti); break;
      default: assert false;
      }

    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("thisPageStyle", null, n); break;
      case 1: testMethod("thisPageStyle", "\\thispagestyle{}", testE); break;
      case 2: testMethod("thisPageStyle", "\\thispagestyle{1}", testOne); break;
      case 3: testMethod("thisPageStyle", "\\thispagestyle{123}", testMulti); break;
      default: assert false;
      }

    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("include", null, n); break;
      case 1: testMethod("include", "\\include{}", testE); break;
      case 2: testMethod("include", "\\include{1}", testOne); break;
      case 3: testMethod("include", "\\include{123}", testMulti); break;
      default: assert false;
      }
/*
    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("includeOnly", null, n); break;
      case 1: testMethod("includeOnly", "\\includeonly{}", testE); break;
      case 2: testMethod("includeOnly", "\\includeonly{1}", testOne); break;
      case 3: testMethod("includeOnly", "\\includeonly{123}", testMulti); break;
      default: assert false;
      }
*/    
    testMethod("beginDocument", "\\begin{document}", (Object[])null);
    testMethod("endDocument", "\\end{document}", (Object[])null);
    testMethod("beginComment", "\\begin{comment}", (Object[])null);
    testMethod("endComment", "\\end{comment}", (Object[])null);
    
    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("input", null, n); break;
      case 1: testMethod("input", "\\input{}", testE); break;
      case 2: testMethod("input", "\\input{1}", testOne); break;
      case 3: testMethod("input", "\\input{123}", testMulti); break;
      default: assert false;
      }

    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("lineBreak", null, testimin); break;
      case 1: testMethod("lineBreak", null, testineg); break;
      case 2: testMethod("lineBreak", "\\linebreak[1]", testipos); break;
      case 3: testMethod("lineBreak", null, testimax); break;
      default: assert false;
      }

    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("noLineBreak", null, testimin); break;
      case 1: testMethod("noLineBreak", null, testineg); break;
      case 2: testMethod("noLineBreak", "\\nolinebreak[1]", testipos); break;
      case 3: testMethod("noLineBreak", null, testimax); break;
      default: assert false;
      }

    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("pageBreak", null, testimin); break;
      case 1: testMethod("pageBreak", null, testineg); break;
      case 2: testMethod("pageBreak", "\\pagebreak[1]", testipos); break;
      case 3: testMethod("pageBreak", null, testimax); break;
      default: assert false;
      }

    for (int i = 0; i < 4; i++)
      switch (i) {
      case 0: testMethod("noPageBreak", null, testimin); break;
      case 1: testMethod("noPageBreak", null, testineg); break;
      case 2: testMethod("noPageBreak", "\\nopagebreak[1]", testipos); break;
      case 3: testMethod("noPageBreak", null, testimax); break;
      default: assert false;
      }

  }
  
  private static int i = 0;
  private static void testMethod(
      String methodName,
      String expected,
      Object... args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    System.out.print( ++i +
        ") Testing: " + methodName);
    System.out.print("\t: \"" + expected);
    
    Object res = null;
    for (Method m : TeXCommands.class.getMethods())
      if (m.getName().equals(methodName))
        res = m.invoke(null, args);
    
    System.out.print("\" == \"" + res);
    
    assert res == null ? res == expected : res.toString().equals(expected) : res;
    
    System.out.println("\"\tOK!");
  }
}
