package org.usajusaj.jtex.samples;

import java.io.File;

import org.usajusaj.jtex.ITClass;
import org.usajusaj.jtex.TeXClassEnum;
import org.usajusaj.jtex.TeXClassImpl;
import org.usajusaj.jtex.TeXDocument;
import org.usajusaj.jtex.TeXException;
import org.usajusaj.jtex.TeXPackageCollectionImpl;
import org.usajusaj.jtex.TeXPackageImpl;
import org.usajusaj.jtex.io.TeXIOException;
import org.usajusaj.jtex.io.TeXInvalidFileException;
import org.usajusaj.jtex.items.ITItem;
import org.usajusaj.jtex.items.env.TeXEnvEnum;
import org.usajusaj.jtex.items.env.TeXEnvironmentImpl;
import org.usajusaj.jtex.util.CmdUtil;
import org.usajusaj.jtex.util.TeXCommands;

/**
 * 
 * @author che
 *
 */
public class Test {
	public static void main(String[] args) throws TeXIOException, TeXInvalidFileException, TeXException {
		String path = System.getProperty("user.dir");
		
		ITClass c = new TeXClassImpl(TeXClassEnum.LTX_DOC);
		TeXPackageCollectionImpl pc = new TeXPackageCollectionImpl();
		
		// [utf8]{inputenc}
		pc.addPackage(new TeXPackageImpl("inputenc", "utf8"));
		// 横版-横置
		//pc.addPackage(new TeXPackageImpl("geometry", "landscape"));
		
		// 创建文件
		TeXDocument doc = new TeXDocument(path + File.separator + "rebey.tex", c, pc);
		
		doc.getWriter().writel(TeXCommands.documentClass(TeXClassEnum.ARTICLE.toString(), null));
		
		// 序
	    doc.createPreamble();

	    // 
	    ITItem centerEnvironment = new TeXEnvironmentImpl(TeXEnvEnum.CENTER);
	    ITItem tableEnvironment = new TeXEnvironmentImpl(TeXEnvEnum.TABLE);
	    doc.getWriter().writel(centerEnvironment.head());
	    doc.getWriter().writel(tableEnvironment.head());
	    doc.getWriter().writel(TeXCommands.beginTabular(null, "|l|l|l|l|"));
	    doc.getWriter().writel(TeXCommands.CMD_TAB_HORIZ_LINE + "主页" +
	    		TeXCommands.CMD_TAB_NEXT_COL + "" +
	    		TeXCommands.CMD_TAB_NEXT_COL + "rebey.cn" + 
	    		TeXCommands.CMD_TAB_NEXT_COL + "公式" +
	    		TeXCommands.CMD_LINE_BREAK +
	    		TeXCommands.CMD_TAB_HORIZ_LINE +
	    		
	    		TeXCommands.CMD_TAB_HORIZ_LINE + "作者" +
	    		TeXCommands.CMD_TAB_NEXT_COL + "" +
	    		TeXCommands.CMD_TAB_NEXT_COL + "che" + 
	    		TeXCommands.CMD_TAB_NEXT_COL + "${x}^{2}$" +
	    		TeXCommands.CMD_LINE_BREAK +
	    		TeXCommands.CMD_TAB_HORIZ_LINE);
	    doc.getWriter().writel(TeXCommands.endTabular());
	    
	    	//TeXCommands.commandArgParm(
//	    		"\\begin{tabular}{|c|c|c|}"
//	    		,"\\hline 2&9&4\\\\"
//	    		,"\\hline 7&5&3\\\\"
//	    		,"\\hline 6&1&8\\\\"
//	    		,"\\hline"
//	    		,"\\end{tabular}")
	    doc.getWriter().writel(tableEnvironment.foot());
	    doc.getWriter().writel(centerEnvironment.foot());
	    
	    doc.close();
	    
	    CmdUtil.exec("pandoc " + path + File.separator + "rebey.tex -o " + path + File.separator + "tex.doc --latex-engine=xelatex -V mainfont=\"SimSun\"");
	    
	}
}
