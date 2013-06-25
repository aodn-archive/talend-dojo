package org.talend.designer.codegen.translators.common;

import java.util.Vector;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IProcess;

public class Header_additional_talendesb_wsconsumerJava
{
  protected static String nl;
  public static synchronized Header_additional_talendesb_wsconsumerJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Header_additional_talendesb_wsconsumerJava result = new Header_additional_talendesb_wsconsumerJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tprivate ESBEndpointRegistry registry = null;" + NL + "" + NL + "\tpublic void setEndpointRegistry(ESBEndpointRegistry registry) {" + NL + "\t\tthis.registry = registry;" + NL + "\t}" + NL + "" + NL + "\tprivate Object wrapPayload(Object payload, Object customProperties) {" + NL + "\t\tjava.util.Map<String, Object> outputWrapped = new java.util.HashMap<String, Object>();" + NL + "\t\toutputWrapped.put(\"PAYLOAD\", payload);" + NL + "\t\tif (null != customProperties) {" + NL + "\t\t\toutputWrapped.put(\"SAM-PROPS\", customProperties);" + NL + "\t\t}" + NL + "\t\treturn outputWrapped;" + NL + "\t}";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "\tprivate ESBProviderCallback callback = null;" + NL + "" + NL + "\tpublic void setProviderCallback(ESBProviderCallback callback) { }" + NL + "" + NL + "\tpublic ESBEndpointInfo getEndpoint() {" + NL + "\t\treturn null;" + NL + "\t}";
  protected final String TEXT_4 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
Vector v = (Vector) codeGenArgument.getArgument();
IProcess process = (IProcess) v.get(0);

boolean actAsProvider = !process.getNodesOfType("tESBProviderRequestLoop").isEmpty();
boolean actAsConsumer = !process.getNodesOfType("tESBConsumer").isEmpty();

if (actAsConsumer) { 
    stringBuffer.append(TEXT_1);
     }
    stringBuffer.append(TEXT_2);
     if (!actAsProvider) { 
    stringBuffer.append(TEXT_3);
     } 
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
