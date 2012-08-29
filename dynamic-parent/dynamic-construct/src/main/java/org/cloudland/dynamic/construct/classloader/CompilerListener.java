/**
  * @Title CompilerDiagnosticListener.java
  * @Package org.dynamic.construct.classloader
  * @Description <p>TODO</p>
  * @author Lei
  * @date 2012-7-25
  * @version 1.0
  */
package org.cloudland.dynamic.construct.classloader;

import java.util.Locale;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticListener;

/**
 * @ClassName CompilerDiagnosticListener
 * @Description TODO
 * @author Lei
 * @date 2012-7-25 下午07:53:03
 *
 */
public class CompilerListener<S> implements DiagnosticListener<S> {
	
	public void report(Diagnostic<? extends S> diagnostic) {
		String out = String.format("Kind: %1$-6s\r\nLine: %2$-6s\r\nColumn: %3$-6s\r\nMessage: %4$-6s\r\nCode:\r\n%5$-6s\r\n", diagnostic.getKind(), diagnostic.getLineNumber(), diagnostic.getColumnNumber(), diagnostic.getMessage(Locale.CHINA), ((JITCompiler.JavaSourceForString)diagnostic.getSource()).getCode());

		System.out.println(out);
	}
}
