package org.usajusaj.jtex.util;

import java.io.IOException;
/**
 * 
 * @author che
 *
 */
public class CmdUtil {
	/**
	 * 
	 * @param cmd
	 * @return
	 */
	public static int exec(String cmd) {
		Runtime runtime = Runtime.getRuntime();
        try {
            Process process = runtime.exec(cmd);
            int exitVal = process.waitFor();
            System.out.println(exitVal == 0 ? "成功" : "失败");
            return exitVal;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
	}
}
