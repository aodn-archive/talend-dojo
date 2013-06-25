package org.talend.designer.codegen.translators.business.bonita;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;

public class TBonitaInstantiateProcessMainJava
{
  protected static String nl;
  public static synchronized TBonitaInstantiateProcessMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TBonitaInstantiateProcessMainJava result = new TBonitaInstantiateProcessMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "\t" + NL + "\ttry {";
  protected final String TEXT_3 = NL + "\t\t\t\t\t\t\t\tparameters_";
  protected final String TEXT_4 = ".put(\"";
  protected final String TEXT_5 = "\", ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = ");";
  protected final String TEXT_8 = NL + NL + "\t\torg.ow2.bonita.facade.uuid.ProcessInstanceUUID instanceUUID_";
  protected final String TEXT_9 = " = runtimeAPI_";
  protected final String TEXT_10 = ".instantiateProcess(processID_";
  protected final String TEXT_11 = ", parameters_";
  protected final String TEXT_12 = ");" + NL + "\t\tprocessInstanceUUID_";
  protected final String TEXT_13 = " = instanceUUID_";
  protected final String TEXT_14 = ".getValue();";
  protected final String TEXT_15 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = " = processInstanceUUID_";
  protected final String TEXT_18 = ";";
  protected final String TEXT_19 = NL + NL + "\t\t " + NL + "\t\tSystem.out.println(\"**** Instance \"+ processInstanceUUID_";
  protected final String TEXT_20 = " + \" created ****\");" + NL + "\t} catch (Exception e_";
  protected final String TEXT_21 = ") {";
  protected final String TEXT_22 = NL + "\t\tthrow e_";
  protected final String TEXT_23 = ";";
  protected final String TEXT_24 = NL + "\t\tSystem.err.println(e_";
  protected final String TEXT_25 = ".getMessage());";
  protected final String TEXT_26 = NL + "\t} finally {" + NL + "\t\tloginContext_";
  protected final String TEXT_27 = ".logout();\t" + NL + "\t}" + NL + "" + NL + "" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_28 = "_ProcessInstanceUUID\", processInstanceUUID_";
  protected final String TEXT_29 = "); ";
  protected final String TEXT_30 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();

	String processID = ElementParameterParser.getValue(node, "__PROCESS_ID__");
	
	boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"));

    stringBuffer.append(TEXT_2);
    
		List< ? extends IConnection> conns = node.getIncomingConnections();
		if(conns != null && conns.size() > 0 && conns.get(0) != null) {
	    	IConnection conn = conns.get(0);
	    	if(conn!=null && conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)){
		    	INode previousNode = conn.getSource();
		    	if(previousNode != null) {
					List<IMetadataTable> metadatas = previousNode.getMetadataList();
					if ((metadatas!=null)&&(metadatas.size()>0)) {
						IMetadataTable metadata = metadatas.get(0);
						if (metadata!=null) {
							List<IMetadataColumn> columns = metadata.getListColumns();
							int sizeColumns = columns.size();
							for (int i = 0; i < sizeColumns; i++) {

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_7);
    
							}
						}
					}
		    	}
		    }
	    }

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
    
		List<IMetadataTable> metadatas = node.getMetadataList();
		if ((metadatas!=null)&&(metadatas.size()>0)) {
			IMetadataTable metadata = metadatas.get(0);
			if (metadata!=null) {
				List< ? extends IConnection> conns_out = node.getOutgoingConnections();
				for (IConnection conn : conns_out) {
					String connName = conn.getName();
					if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
						List<IMetadataColumn> columns = metadata.getListColumns();
						int sizeColumns = columns.size();
						for (int i = 0; i < sizeColumns; i++) {
							if ("ProcessInstanceUUID".equals(columns.get(i).getLabel()) ) {

    stringBuffer.append(TEXT_15);
    stringBuffer.append(connName);
    stringBuffer.append(TEXT_16);
    stringBuffer.append((columns.get(i)).getLabel());
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    
								break;
							}
						}
					}
				}
			}
		}

    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    
	if (dieOnError) {

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
	} else {

    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    	
	}

    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(TEXT_30);
    return stringBuffer.toString();
  }
}
