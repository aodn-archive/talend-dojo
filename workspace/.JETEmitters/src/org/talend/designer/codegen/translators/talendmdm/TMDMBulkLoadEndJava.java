package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TMDMBulkLoadEndJava
{
  protected static String nl;
  public static synchronized TMDMBulkLoadEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TMDMBulkLoadEndJava result = new TMDMBulkLoadEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "if (inputStreamMerger_";
  protected final String TEXT_2 = "!=null) {" + NL + "inputStreamMerger_";
  protected final String TEXT_3 = ".close();" + NL + "} " + NL + "bulkloadClient_";
  protected final String TEXT_4 = ".waitForEndOfQueue();" + NL + "bulkloadClient_";
  protected final String TEXT_5 = " = null;";
  protected final String TEXT_6 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
//for bug TDI-22445

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
