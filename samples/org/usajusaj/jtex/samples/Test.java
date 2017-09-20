package org.usajusaj.jtex.samples;

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
import org.usajusaj.jtex.util.TeXCommands;

/**
 * 
 * @author che
 *
 */
public class Test {
	public static void main(String[] args) throws TeXIOException, TeXInvalidFileException, TeXException {
		ITClass c = new TeXClassImpl(TeXClassEnum.LTX_DOC);
		TeXPackageCollectionImpl pc = new TeXPackageCollectionImpl();
		// 横版布局
		pc.addPackage(new TeXPackageImpl("geometry", "landscape"));
		
		// 创建文档
		TeXDocument doc = new TeXDocument("C:/Users/Administrator/Desktop/t.tex", c, pc);
		
		// 插入序
	    doc.createPreamble();
	    
	    // 
	    ITItem tableEnvironment = new TeXEnvironmentImpl(TeXEnvEnum.TABLE);
	    doc.getWriter().writel(tableEnvironment.head());
	    doc.getWriter().writel(TeXCommands.beginTabular(null, "|c|c|c|"));
	    doc.getWriter().writel(TeXCommands.CMD_TAB_HORIZ_LINE + 1 +
	    		TeXCommands.CMD_TAB_NEXT_COL + 2 +
	    		TeXCommands.CMD_TAB_NEXT_COL + 3 + 
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
	    
	    doc.close();
	}
}
