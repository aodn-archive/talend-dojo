package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TSalesforceOutputBulkBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceOutputBulkBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceOutputBulkBeginJava result = new TSalesforceOutputBulkBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "int nb_line_";
  protected final String TEXT_2 = " = 0;" + NL + "" + NL + "java.io.File file_";
  protected final String TEXT_3 = " = new java.io.File(";
  protected final String TEXT_4 = ");\t\t" + NL + "file_";
  protected final String TEXT_5 = ".getParentFile().mkdirs();" + NL + "" + NL + "String lineSeparator_";
  protected final String TEXT_6 = " = (String) java.security.AccessController.doPrivileged(" + NL + "\tnew sun.security.action.GetPropertyAction(\"line.separator\"));" + NL + "" + NL + "com.talend.csv.CSVWriter csvWriter_";
  protected final String TEXT_7 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "        new java.io.FileOutputStream(file_";
  protected final String TEXT_8 = ", ";
  protected final String TEXT_9 = "), \"UTF-8\")), ',','\\0','\\0',lineSeparator_";
  protected final String TEXT_10 = ");" + NL;
  protected final String TEXT_11 = "  \t" + NL + "\t                    \tString[] header_";
  protected final String TEXT_12 = "=new String[";
  protected final String TEXT_13 = "];" + NL + "\t                    \t";
  protected final String TEXT_14 = NL + "\t\t\t\t\t\t\t\theader_";
  protected final String TEXT_15 = "[";
  protected final String TEXT_16 = "] = \"";
  protected final String TEXT_17 = "\";";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\t\t\theader_";
  protected final String TEXT_19 = "[";
  protected final String TEXT_20 = "] = ";
  protected final String TEXT_21 = " + \".\" + ";
  protected final String TEXT_22 = ";";
  protected final String TEXT_23 = NL + "\tcsvWriter_";
  protected final String TEXT_24 = ".writeNext(header_";
  protected final String TEXT_25 = ");" + NL + "\tcsvWriter_";
  protected final String TEXT_26 = ".setQuoteChar('\"');" + NL + "\tcsvWriter_";
  protected final String TEXT_27 = ".setEscapeChar('\"');";
  protected final String TEXT_28 = NL + "        ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

List<Map<String, String>> relationshipMappings = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__UPSERT_RELATION__");

List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
    
	    String filename = ElementParameterParser.getValue(node,"__FILENAME__");
	    boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
        

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(isAppend );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    		if(!isAppend){
			List< ? extends IConnection> conns = node.getIncomingConnections();
	        	if(conns!=null){
	        		if (conns.size()>0){
	        		    IConnection conn =conns.get(0);
	            		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
	            			List<IMetadataColumn> columns = metadata.getListColumns();
	                		int sizeColumns = columns.size();
	            			
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_13);
    
	                    
	            			for (int i = 0; i < sizeColumns; i++) {
	                			IMetadataColumn column = columns.get(i);
	                			
	                			boolean reference = false;
	                			String lookupFieldName = null;
	                			String externalIdFromLookupField = null;
	                			
	                			for(Map<String,String> row : relationshipMappings) {
	                				String columnName = row.get("COLUMN_NAME");
	                				if(columnName.equals(column.getLabel())) {
	                					lookupFieldName = row.get("LOOKUP_FIELD_NAME");
										externalIdFromLookupField = row.get("LOOKUP_FIELD_EXTERNAL_ID_NAME");
	                					reference = true;
										break;
									}
								}
								
								if(!reference) {

    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_17);
    
								} else {

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(lookupFieldName );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(externalIdFromLookupField );
    stringBuffer.append(TEXT_22);
    
								}
							}
						}
					}
				}

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    
		}
	}
}

    stringBuffer.append(TEXT_28);
    return stringBuffer.toString();
  }
}
