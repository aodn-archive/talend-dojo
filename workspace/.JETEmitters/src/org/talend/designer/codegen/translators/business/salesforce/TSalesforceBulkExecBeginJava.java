package org.talend.designer.codegen.translators.business.salesforce;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.utils.TalendTextUtils;
import java.util.List;

public class TSalesforceBulkExecBeginJava
{
  protected static String nl;
  public static synchronized TSalesforceBulkExecBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSalesforceBulkExecBeginJava result = new TSalesforceBulkExecBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = NL + "\tint nb_line_";
  protected final String TEXT_3 = " = 0;" + NL + "    int nb_success_";
  protected final String TEXT_4 = " = 0;" + NL + "    int nb_reject_";
  protected final String TEXT_5 = " = 0;" + NL + "\t" + NL + "\torg.talend.salesforceBulk.SalesforceBulkAPI sforceBulk_";
  protected final String TEXT_6 = " = new org.talend.salesforceBulk.SalesforceBulkAPI();" + NL + "\t";
  protected final String TEXT_7 = NL + "\t\tsforceBulk_";
  protected final String TEXT_8 = ".setProxy(true,";
  protected final String TEXT_9 = ",";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = ",";
  protected final String TEXT_12 = ");" + NL + "\t";
  protected final String TEXT_13 = NL + "\t";
  protected final String TEXT_14 = NL + "\t\tif(globalMap.get(\"conn_";
  protected final String TEXT_15 = "\")==null){" + NL + "\t\t\tthrow new RuntimeException(\"Get null connection from ";
  protected final String TEXT_16 = "\");" + NL + "\t\t}" + NL + "\t\tsforceBulk_";
  protected final String TEXT_17 = ".login((com.sforce.async.BulkConnection)globalMap.get(\"conn_";
  protected final String TEXT_18 = "\"));" + NL + "\t";
  protected final String TEXT_19 = NL + "\t\tsforceBulk_";
  protected final String TEXT_20 = ".login(";
  protected final String TEXT_21 = ",";
  protected final String TEXT_22 = ",";
  protected final String TEXT_23 = ",";
  protected final String TEXT_24 = ");" + NL + "\t";
  protected final String TEXT_25 = NL + "\tsforceBulk_";
  protected final String TEXT_26 = ".setConcurrencyMode(\"";
  protected final String TEXT_27 = "\");" + NL + "" + NL + "" + NL + "\tsforceBulk_";
  protected final String TEXT_28 = ".executeBulk(\"";
  protected final String TEXT_29 = "\",\"";
  protected final String TEXT_30 = "\",";
  protected final String TEXT_31 = ",\"";
  protected final String TEXT_32 = "\",";
  protected final String TEXT_33 = ",";
  protected final String TEXT_34 = ",";
  protected final String TEXT_35 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_36 = NL + "\t\t\tint j_";
  protected final String TEXT_37 = "=0;" + NL + "\t\t\tint batchCount_";
  protected final String TEXT_38 = " = sforceBulk_";
  protected final String TEXT_39 = ".getBatchCount();" + NL + "\t\t\tfor(int i = 0; i < batchCount_";
  protected final String TEXT_40 = "; i++){" + NL + "\t\t\t\tjava.util.List<java.util.Map<String,String>> resultListMessage_";
  protected final String TEXT_41 = " = sforceBulk_";
  protected final String TEXT_42 = ".getBatchLog(i);" + NL + "\t\t\t\tfor(java.util.Map<String,String> resultMessage_";
  protected final String TEXT_43 = " : resultListMessage_";
  protected final String TEXT_44 = "){" + NL + "\t\t\t\t\tj_";
  protected final String TEXT_45 = "++;" + NL + "\t\t\t";
  protected final String TEXT_46 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_47 = " = null;\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_48 = "\t" + NL + "\t\t\tif(\"true\".equals(resultMessage_";
  protected final String TEXT_49 = ".get(\"Success\"))){" + NL + "\t\t\t\t";
  protected final String TEXT_50 = NL + "\t\t\t\t\t\tnb_success_";
  protected final String TEXT_51 = "++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_52 = " = new ";
  protected final String TEXT_53 = "Struct();" + NL + "" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_54 = ".salesforce_created = resultMessage_";
  protected final String TEXT_55 = ".get(\"Created\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_56 = ".salesforce_id = resultMessage_";
  protected final String TEXT_57 = ".get(\"Id\");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_58 = "\t\t\t" + NL + "\t\t\t\t\t\t\tif(\"#N/A\".equals(String.valueOf(resultMessage_";
  protected final String TEXT_59 = ".get(\"";
  protected final String TEXT_60 = "\")))){" + NL + "\t\t\t\t        \t\tresultMessage_";
  protected final String TEXT_61 = ".put(\"";
  protected final String TEXT_62 = "\",null);" + NL + "\t\t\t\t        \t}" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_63 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_64 = ".";
  protected final String TEXT_65 = " = resultMessage_";
  protected final String TEXT_66 = ".get(\"";
  protected final String TEXT_67 = "\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_68 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_69 = ".";
  protected final String TEXT_70 = " = ParserUtils.parseTo_Date(resultMessage_";
  protected final String TEXT_71 = ".get(\"";
  protected final String TEXT_72 = "\"), ";
  protected final String TEXT_73 = ");" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_74 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_75 = ".";
  protected final String TEXT_76 = " = ParserUtils.parseTo_";
  protected final String TEXT_77 = "(resultMessage_";
  protected final String TEXT_78 = ".get(\"";
  protected final String TEXT_79 = "\"));" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_80 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_81 = ".";
  protected final String TEXT_82 = " = ParserUtils.parseTo_";
  protected final String TEXT_83 = "(resultMessage_";
  protected final String TEXT_84 = ".get(\"";
  protected final String TEXT_85 = "\"));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_86 = NL + "\t\t\t\t           \t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t}else{" + NL + "\t\t\t\t";
  protected final String TEXT_88 = NL + "\t\t\t\t\t\tnb_reject_";
  protected final String TEXT_89 = "++;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_90 = " = new ";
  protected final String TEXT_91 = "Struct();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_92 = ".error = resultMessage_";
  protected final String TEXT_93 = ".get(\"Error\");" + NL + "\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_94 = "\t\t\t" + NL + "\t\t\t\t\t\t\tif(\"#N/A\".equals(String.valueOf(resultMessage_";
  protected final String TEXT_95 = ".get(\"";
  protected final String TEXT_96 = "\")))){" + NL + "\t\t\t\t\t        \t\tresultMessage_";
  protected final String TEXT_97 = ".put(\"";
  protected final String TEXT_98 = "\",null);" + NL + "\t\t\t\t\t        }" + NL + "\t\t\t\t\t\t    ";
  protected final String TEXT_99 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_100 = ".";
  protected final String TEXT_101 = " = resultMessage_";
  protected final String TEXT_102 = ".get(\"";
  protected final String TEXT_103 = "\");" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_104 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_105 = ".";
  protected final String TEXT_106 = " = ParserUtils.parseTo_Date(resultMessage_";
  protected final String TEXT_107 = ".get(\"";
  protected final String TEXT_108 = "\"), ";
  protected final String TEXT_109 = ");" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_110 = NL + "\t\t\t\t\t            ";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = " = ParserUtils.parseTo_";
  protected final String TEXT_113 = "(resultMessage_";
  protected final String TEXT_114 = ".get(\"";
  protected final String TEXT_115 = "\"));" + NL + "\t\t\t\t\t        ";
  protected final String TEXT_116 = NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_117 = ".";
  protected final String TEXT_118 = " = ParserUtils.parseTo_";
  protected final String TEXT_119 = "(resultMessage_";
  protected final String TEXT_120 = ".get(\"";
  protected final String TEXT_121 = "\"));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_122 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\tSystem.err.print(\"Row \"+j_";
  protected final String TEXT_124 = "+\":\"+resultMessage_";
  protected final String TEXT_125 = ".get(\"Error\"));" + NL + "\t\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_127 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();    	
	
	String endpoint = ElementParameterParser.getValue(node, "__ENDPOINT__");
	String apiVersion = ElementParameterParser.getValue(node, "__API_VERSION__");
	String username = ElementParameterParser.getValue(node, "__USER__");
	String password = ElementParameterParser.getValue(node, "__PASS__");
	
	String sObject = ElementParameterParser.getValue(node, "__MODULENAME__");
	String customModulename = ElementParameterParser.getValue(node, "__CUSTOM_MODULE_NAME__");
	if ("CustomModule".equals(sObject)) {
		//modulename = customModulename; 
		sObject = customModulename.replaceAll("\"","");
	}
	
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String externalId = ElementParameterParser.getValue(node, "__UPSERT_KEY_COLUMN__");
	//String contentType = ElementParameterParser.getValue(node, "__CONTENTTYPE__");
	String contentType = "csv";
	String bulkFileName = ElementParameterParser.getValue(node, "__BULKFILENAME__").trim();
	
	String maxBytes = ElementParameterParser.getValue(node,"__COMMIT_LEVEL_BYTES__");
	String maxRows = ElementParameterParser.getValue(node,"__COMMIT_LEVEL_ROWS__");
	
	boolean useProxy = ("true").equals(ElementParameterParser.getValue(node,"__USE_PROXY__"));
	String proxyHost = ElementParameterParser.getValue(node,"__PROXY_HOST__");
   	String proxyPort = ElementParameterParser.getValue(node,"__PROXY_PORT__");
   	String proxyUsername = ElementParameterParser.getValue(node,"__PROXY_USERNAME__");
   	String proxyPassword = ElementParameterParser.getValue(node,"__PROXY_PASSWORD__");
	
	boolean useExistingConn = ("true").equals(ElementParameterParser.getValue(node,"__USE_EXISTING_CONNECTION__"));
	String connection = ElementParameterParser.getValue(node,"__CONNECTION__");
	
	String concurrencyMode = ElementParameterParser.getValue(node,"__CONCURRENCY_MODE__");
	
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    if(useProxy){
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(proxyHost);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(TalendTextUtils.removeQuotes(proxyPort));
    stringBuffer.append(TEXT_10);
    stringBuffer.append(proxyUsername);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(proxyPassword);
    stringBuffer.append(TEXT_12);
    }
    stringBuffer.append(TEXT_13);
    if(useExistingConn){
    stringBuffer.append(TEXT_14);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(connection );
    stringBuffer.append(TEXT_18);
    }else{
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(endpoint);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(apiVersion);
    stringBuffer.append(TEXT_24);
    }
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(concurrencyMode);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(sObject);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(action);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(externalId);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(contentType);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(bulkFileName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(maxBytes);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(maxRows);
    stringBuffer.append(TEXT_35);
    
	List<IMetadataTable> metadatas = node.getMetadataList();
	if ((metadatas!=null)&&(metadatas.size()>0)) {//1
	    IMetadataTable metadata = metadatas.get(0);
	    if (metadata!=null) {//2
		
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
     
			List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
			if(outgoingConns!=null){
				for (int i=0;i<outgoingConns.size();i++) {
			    IConnection outgoingConn = outgoingConns.get(i);
			    	if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					
    stringBuffer.append(TEXT_46);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_47);
    
			    	}
			    }
			}
    	
			List<? extends IConnection> connsSuccess = node.getOutgoingConnections("MAIN");
			List<? extends IConnection> connsReject = node.getOutgoingConnections("REJECT");
			
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    
				if (connsSuccess != null && connsSuccess.size() == 1) {
					IConnection connSuccess = connsSuccess.get(0);
					if (connSuccess.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_51);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_52);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    
						for (IMetadataColumn column: metadata.getListColumns()) {
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_62);
    		
					        if(javaType == JavaTypesManager.STRING ){
							
    stringBuffer.append(TEXT_63);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_67);
    
					        }else if(javaType == JavaTypesManager.DATE){
					        
    stringBuffer.append(TEXT_68);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_73);
    
					        }else if(JavaTypesManager.isNumberType(javaType)) {
					        
    stringBuffer.append(TEXT_74);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_79);
    
					        }else { 
							
    stringBuffer.append(TEXT_80);
    stringBuffer.append(connSuccess.getName() );
    stringBuffer.append(TEXT_81);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_85);
    
							}
							
    stringBuffer.append(TEXT_86);
    					 
						}
					}
				}
				
    stringBuffer.append(TEXT_87);
    
				if (connsReject != null && connsReject.size() == 1) {
					IConnection connReject = connsReject.get(0);
					if (connReject.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
					
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_91);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    
						for (IMetadataColumn column: metadata.getListColumns()) {
							String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
							JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
							String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
							
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_98);
    		
					        if(javaType == JavaTypesManager.STRING ){
							
    stringBuffer.append(TEXT_99);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_103);
    
					        }else if(javaType == JavaTypesManager.DATE && pattern != null){
					        
    stringBuffer.append(TEXT_104);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_109);
    
					        }else if(JavaTypesManager.isNumberType(javaType)) {
					        
    stringBuffer.append(TEXT_110);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_115);
    
					        }else { 
							
    stringBuffer.append(TEXT_116);
    stringBuffer.append(connReject.getName() );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_121);
    
							}
							
    stringBuffer.append(TEXT_122);
    					 
						}
					}
				}else{
				
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
				}
		}//2
	}//1
	
    stringBuffer.append(TEXT_126);
    stringBuffer.append(TEXT_127);
    return stringBuffer.toString();
  }
}
