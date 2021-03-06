package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class TWebServiceMainJava
{
  protected static String nl;
  public static synchronized TWebServiceMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TWebServiceMainJava result = new TWebServiceMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\tinMap_";
  protected final String TEXT_2 = " = new java.util.HashMap<String,Object>();" + NL + "\t\tjava.util.Map<String,Object> paramMap_";
  protected final String TEXT_3 = " = new java.util.HashMap<String,Object>();" + NL + "\t\tObject inputValueObject_";
  protected final String TEXT_4 = ";" + NL + "\t\tjavax.xml.namespace.QName anyTypeQName_";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = "\t" + NL + "    \t\t\t\tinputValueObject_";
  protected final String TEXT_7 = " = util_";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ";";
  protected final String TEXT_10 = "\t" + NL + "\t\t\t\t\tinputValueObject_";
  protected final String TEXT_11 = " = ";
  protected final String TEXT_12 = ";";
  protected final String TEXT_13 = NL + "\t\t\t\tparamMap_";
  protected final String TEXT_14 = ".put(util_";
  protected final String TEXT_15 = ".removePunctuation(\"";
  protected final String TEXT_16 = "\"),inputValueObject_";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = "\t\t" + NL + "\t\t\t\t\tanyTypeQName_";
  protected final String TEXT_19 = " = new javax.xml.namespace.QName(\"";
  protected final String TEXT_20 = "\",\"anyType\"); " + NL + "\t\t\t\t\tparamMap_";
  protected final String TEXT_21 = ".put(util_";
  protected final String TEXT_22 = ".removePunctuation(\"";
  protected final String TEXT_23 = "\"+\"_type\"),anyTypeQName_";
  protected final String TEXT_24 = ");\t";
  protected final String TEXT_25 = NL + "\t\tutil_";
  protected final String TEXT_26 = ".resolveInputPath(paramMap_";
  protected final String TEXT_27 = ");" + NL + "\t\tif(!paramMap_";
  protected final String TEXT_28 = ".isEmpty()){" + NL + "\t\t\tinMap_";
  protected final String TEXT_29 = " = org.talend.webservice.helper.map.MapConverter.mapToDeepMap(paramMap_";
  protected final String TEXT_30 = ");" + NL + "\t\t}" + NL + "\t\tif(inMap_";
  protected final String TEXT_31 = ".isEmpty()){" + NL + "\t\t\tinMap_";
  protected final String TEXT_32 = " = null;" + NL + "\t\t}";
  protected final String TEXT_33 = "\t" + NL + "\t java.util.Map<String, Object> results_";
  protected final String TEXT_34 = " = null;" + NL + "\t try{" + NL + "\t results_";
  protected final String TEXT_35 = " = serviceInvokerHelper_";
  protected final String TEXT_36 = ".invoke(serviceName_";
  protected final String TEXT_37 = ", portName_";
  protected final String TEXT_38 = ", \"";
  protected final String TEXT_39 = "\", inMap_";
  protected final String TEXT_40 = ");" + NL + "\t }catch(Exception e){";
  protected final String TEXT_41 = NL + "\t\tthrow(e);";
  protected final String TEXT_42 = NL + "\t\tSystem.err.print(e.getMessage());";
  protected final String TEXT_43 = NL + "\t }";
  protected final String TEXT_44 = "            \t\t" + NL + "\t\t\t\t\tjava.util.Map<String, Object> outMap_";
  protected final String TEXT_45 = "=null;" + NL + "\t\t\t\t\tif(results_";
  protected final String TEXT_46 = "!=null&&!results_";
  protected final String TEXT_47 = ".isEmpty()){" + NL + "\t\t\t\t\t\toutMap_";
  protected final String TEXT_48 = " = org.talend.webservice.helper.map.MapConverter.deepMapToMap(results_";
  protected final String TEXT_49 = ");" + NL + "\t\t\t\t\t}" + NL + "            \t\tjava.util.Map<String,Object> returnValuesMap_";
  protected final String TEXT_50 = " = new java.util.HashMap<String,Object>();" + NL + "            \t\tObject outputValue_";
  protected final String TEXT_51 = ";";
  protected final String TEXT_52 = NL + "\t\t\t\t\toutputValue_";
  protected final String TEXT_53 = " = util_";
  protected final String TEXT_54 = ".normalize(util_";
  protected final String TEXT_55 = ".getValue(outMap_";
  protected final String TEXT_56 = ",util_";
  protected final String TEXT_57 = ".removePunctuation(\"";
  protected final String TEXT_58 = "\")).toString(),\"";
  protected final String TEXT_59 = "\");";
  protected final String TEXT_60 = "    \t\t\t\t" + NL + "        \t\t\toutputValue_";
  protected final String TEXT_61 = " = util_";
  protected final String TEXT_62 = ".denormalize((List)util_";
  protected final String TEXT_63 = ".getValue(outMap_";
  protected final String TEXT_64 = ",util_";
  protected final String TEXT_65 = ".removePunctuation(\"";
  protected final String TEXT_66 = "\")),\"";
  protected final String TEXT_67 = "\");    \t\t\t\t";
  protected final String TEXT_68 = NL + " \t\t\t\t\toutputValue_";
  protected final String TEXT_69 = " = util_";
  protected final String TEXT_70 = ".getValue(outMap_";
  protected final String TEXT_71 = ",util_";
  protected final String TEXT_72 = ".removePunctuation(\"";
  protected final String TEXT_73 = "\"));";
  protected final String TEXT_74 = NL + "\t\t\t\t\treturnValuesMap_";
  protected final String TEXT_75 = ".put(\"";
  protected final String TEXT_76 = "\",outputValue_";
  protected final String TEXT_77 = ");\t\t";
  protected final String TEXT_78 = "\t\t\t\t" + NL + "\t\t\tif(returnValuesMap_";
  protected final String TEXT_79 = "!=null&&!returnValuesMap_";
  protected final String TEXT_80 = ".isEmpty()){";
  protected final String TEXT_81 = NL + NL + "\t\t\t\tif(returnValuesMap_";
  protected final String TEXT_82 = ".get(\"";
  protected final String TEXT_83 = "\")!=null){";
  protected final String TEXT_84 = "\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_85 = ".";
  protected final String TEXT_86 = " = returnValuesMap_";
  protected final String TEXT_87 = ".get(\"";
  protected final String TEXT_88 = "\").toString();";
  protected final String TEXT_89 = NL + "\t\t\t\t\t";
  protected final String TEXT_90 = ".";
  protected final String TEXT_91 = " = ParserUtils.parseTo_Date(returnValuesMap_";
  protected final String TEXT_92 = ".get(\"";
  protected final String TEXT_93 = "\").toString(), ";
  protected final String TEXT_94 = ");";
  protected final String TEXT_95 = NL + "\t\t\t\t\tif(returnValuesMap_";
  protected final String TEXT_96 = ".get(\"";
  protected final String TEXT_97 = "\") instanceof byte[]){" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_98 = ".";
  protected final String TEXT_99 = " = (byte[])returnValuesMap_";
  protected final String TEXT_100 = ".get(\"";
  protected final String TEXT_101 = "\");\t" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_102 = ".";
  protected final String TEXT_103 = " = returnValuesMap_";
  protected final String TEXT_104 = ".get(\"";
  protected final String TEXT_105 = "\").toString().getBytes();" + NL + "\t\t\t\t\t}";
  protected final String TEXT_106 = NL + "\t\t\t\t\t";
  protected final String TEXT_107 = ".";
  protected final String TEXT_108 = " = (List<Object>)returnValuesMap_";
  protected final String TEXT_109 = ".get(\"";
  protected final String TEXT_110 = "\");";
  protected final String TEXT_111 = "\t\t\t\t\t\t\t\t\t" + NL + "\t\t\t\t\t";
  protected final String TEXT_112 = ".";
  protected final String TEXT_113 = " = ParserUtils.parseTo_";
  protected final String TEXT_114 = "(returnValuesMap_";
  protected final String TEXT_115 = ".get(\"";
  protected final String TEXT_116 = "\").toString());\t";
  protected final String TEXT_117 = NL + "\t\t\t\t}else{" + NL + "        \t\t\t";
  protected final String TEXT_118 = ".";
  protected final String TEXT_119 = " = ";
  protected final String TEXT_120 = ";" + NL + "\t\t\t\t}\t";
  protected final String TEXT_121 = "\t\t\t";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
String methodTemp = ElementParameterParser.getValue(node,"__METHOD__");
String method = methodTemp.indexOf("(")!=-1?methodTemp.substring(0,methodTemp.indexOf("(")):methodTemp;

IConnection inputConn = null;
List<? extends IConnection> incomingConnections = node.getIncomingConnections();
if (incomingConnections != null && !incomingConnections.isEmpty()) {
	for (IConnection conn : incomingConnections) {
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
			inputConn = conn;
			break;
		}
	}
}

    
	List<Map<String, String>> inputParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__INPUT_PARAMS__");
	
	if(inputParams!=null&&!inputParams.isEmpty()){//input params start
    	String expression;
    	String element;
    	String namespace;

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
        
		int elementNum = 0;
		java.util.regex.Pattern normalizePattern = java.util.regex.Pattern.compile("^normalize\\(.*,\".*\"\\)$"); // normalize(row1.col1,";")
        java.util.regex.Pattern denormalizePattern = java.util.regex.Pattern.compile("^denormalize\\(.*,\".*\"\\)$"); // denormalize(row1.col1,";")
		java.util.regex.Pattern anyTypePattern = java.util.regex.Pattern.compile("(.*[\\.])?anyType(\\[\\d+\\])?$"); // anyType or anyType[1]
		
		for(Map<String,String> inputParam:inputParams){
    		elementNum++;
    		expression = inputParam.get("EXPRESSION");
        	element = inputParam.get("ELEMENT").trim();
  			namespace = inputParam.get("NAMESPACE");
			if(expression!=null&&!"".equals(expression)&&element!=null&&!"".equals(element)){
				    		
        		if(normalizePattern.matcher(expression).matches()||denormalizePattern.matcher(expression).matches()){

    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_9);
        		
        		}else{

    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(expression);
    stringBuffer.append(TEXT_12);
        		
        		}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(element);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    
        		if(anyTypePattern.matcher(element).matches()){

    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(namespace);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(element);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    
				}
			}
    	}

    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    
	}//input params end


    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    
	 if (("true").equals(dieOnError)) {

    stringBuffer.append(TEXT_41);
    
	 } else {

    stringBuffer.append(TEXT_42);
    
	 }

    stringBuffer.append(TEXT_43);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	//IMetadataTable metadata = metadatas.get(0);
	
for(IMetadataTable metadata:metadatas){
		if("OUTPUT".equals(metadata.getTableName())){
	if (metadata != null) {
	
		List<IMetadataColumn> columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();			
		List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
		if(outgoingConns!=null&&outgoingConns.size()>0){
		IConnection outgoingConn = outgoingConns.get(0);
		if(outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { 
			if (nbSchemaColumns > 0 && outgoingConns != null && outgoingConns.size() > 0){

    
				List<Map<String, String>> outputParams = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__OUTPUT_PARAMS__");	
				if(outputParams!=null){//retrieve start

    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    
            		String realExpression="";
            		String delimiter;
            		java.util.regex.Pattern normalizePattern = java.util.regex.Pattern.compile("^normalize\\(.*,\".*\"\\)$"); // normalize(row1.col1,";")
                    java.util.regex.Pattern denormalizePattern = java.util.regex.Pattern.compile("^denormalize\\(.*,\".*\"\\)$"); // denormalize(row1.col1,";")
            		for(Map<String,String> outputParam:outputParams){
                		String expression = outputParam.get("EXPRESSION").trim();
                		String column = outputParam.get("COLUMN").trim();
                		if(column!=null&&!"".equals(column)){
                    		if(normalizePattern.matcher(expression).matches()){ 
                    			realExpression = expression.substring(expression.indexOf("(")+1,expression.indexOf(",")).trim();
                    			delimiter = expression.substring(expression.indexOf("\"")+1,expression.lastIndexOf("\""));

    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(realExpression);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(delimiter);
    stringBuffer.append(TEXT_59);
    
                    		}else if(denormalizePattern.matcher(expression).matches()){
                    			realExpression = expression.substring(expression.indexOf("(")+1,expression.indexOf(",")).trim();
                    			delimiter = expression.substring(expression.indexOf("\"")+1,expression.lastIndexOf("\""));

    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(realExpression);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(delimiter);
    stringBuffer.append(TEXT_67);
        		
                    		}else{
                    			realExpression=expression.trim();

    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(realExpression);
    stringBuffer.append(TEXT_73);
    
    						}

    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(column);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
    
                		}
                	}
				}//retrieve end

    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    
    			for( int i = 0; i < columnList.size(); i++) {
    						
    			IMetadataColumn column = columnList.get(i);
    						
    			String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
    							
    			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    							
    			String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();

    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_83);
    							
					if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_84);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_85);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_88);
    
					} else if(javaType == JavaTypesManager.DATE) { // Date

    stringBuffer.append(TEXT_89);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_90);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_93);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_94);
    
					} else if(javaType == JavaTypesManager.BYTE_ARRAY) { //byte[]

    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_97);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_98);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_101);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_105);
    
					} else if(javaType == JavaTypesManager.LIST){	//List

    stringBuffer.append(TEXT_106);
    stringBuffer.append(outgoingConn.getName() );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_110);
    
					}else{

    stringBuffer.append(TEXT_111);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_112);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_113);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_116);
    
					}

    stringBuffer.append(TEXT_117);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_118);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate,column.getDefault()));
    stringBuffer.append(TEXT_120);
    			
			}	
			
			}
		}
	}
	}}
	}
}

    stringBuffer.append(TEXT_121);
    return stringBuffer.toString();
  }
}
