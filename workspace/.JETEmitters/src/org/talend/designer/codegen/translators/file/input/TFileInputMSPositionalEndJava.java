package org.talend.designer.codegen.translators.file.input;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;

public class TFileInputMSPositionalEndJava
{
  protected static String nl;
  public static synchronized TFileInputMSPositionalEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileInputMSPositionalEndJava result = new TFileInputMSPositionalEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tnb_line_";
  protected final String TEXT_2 = "++;" + NL + "\t\t" + NL + "\t\tif(limit_";
  protected final String TEXT_3 = " != -1 && nb_line_";
  protected final String TEXT_4 = " >= limit_";
  protected final String TEXT_5 = "){" + NL + "\t\t\tbreak;" + NL + "\t\t}" + NL + "\t}" + NL + "\treader_";
  protected final String TEXT_6 = ".close();" + NL + "\treader_";
  protected final String TEXT_7 = " = null;" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_8 = "_NB_LINE\", nb_line_";
  protected final String TEXT_9 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_10 = "_NB_LINE_REJECTED\", nb_line_rejected_";
  protected final String TEXT_11 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_12 = "_NB_LINE_UNKOWN_HEADER_TYPES\", nb_line_unknownHeader_";
  protected final String TEXT_13 = ");" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_14 = "_NB_LINE_PARSE_ERRORS\", nb_line_parseError_";
  protected final String TEXT_15 = ");";
  protected final String TEXT_16 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

	List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
	if (conns!=null && conns.size()>0) { //1

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    
	} //1

    stringBuffer.append(TEXT_16);
    return stringBuffer.toString();
  }
}
