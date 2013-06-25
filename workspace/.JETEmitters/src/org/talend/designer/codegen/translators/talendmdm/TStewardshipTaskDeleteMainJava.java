package org.talend.designer.codegen.translators.talendmdm;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;

public class TStewardshipTaskDeleteMainJava
{
  protected static String nl;
  public static synchronized TStewardshipTaskDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TStewardshipTaskDeleteMainJava result = new TStewardshipTaskDeleteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\tint deleted_task_";
  protected final String TEXT_2 = " = 0;\t" + NL + "        java.net.Authenticator.setDefault(new java.net.Authenticator() {" + NL + "            protected java.net.PasswordAuthentication getPasswordAuthentication() {" + NL + "            \treturn new java.net.PasswordAuthentication(";
  protected final String TEXT_3 = ", ";
  protected final String TEXT_4 = ".toCharArray());" + NL + "        }});" + NL + "\t\t" + NL + "\t\tjava.net.URL wsdlUrl_";
  protected final String TEXT_5 = " = new java.net.URL(\"http://\"+";
  protected final String TEXT_6 = "+\":\"+";
  protected final String TEXT_7 = "+\"/org.talend.datastewardship/services/TDSCWS?wsdl\");" + NL + "\t\torg.talend.datastewardship.server.ws.TDSCWS_Service service_";
  protected final String TEXT_8 = " = new org.talend.datastewardship.server.ws.TDSCWS_Service(wsdlUrl_";
  protected final String TEXT_9 = ");" + NL + "\t\torg.talend.datastewardship.server.ws.TDSCWS TDSCWS_";
  protected final String TEXT_10 = " = service_";
  protected final String TEXT_11 = ".getTDSCWSImplPort();" + NL + "\t\t" + NL + "\t\tString startDateString_";
  protected final String TEXT_12 = " = ";
  protected final String TEXT_13 = ";" + NL + "\t\tString endDateString_";
  protected final String TEXT_14 = " = ";
  protected final String TEXT_15 = ";" + NL + "    \tcom.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl startXMLGregorianCalendar_";
  protected final String TEXT_16 = " = null;" + NL + "    \tcom.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl endXMLGregorianCalendar_";
  protected final String TEXT_17 = " = null;" + NL + "    \tif(startDateString_";
  protected final String TEXT_18 = "!=null && !startDateString_";
  protected final String TEXT_19 = ".equals(\"\")){" + NL + "    \t\tjava.text.SimpleDateFormat startdf_";
  protected final String TEXT_20 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "\t\t\tstartdf_";
  protected final String TEXT_21 = ".parse(startDateString_";
  protected final String TEXT_22 = ");" + NL + "\t\t\tjava.util.Calendar startCal_";
  protected final String TEXT_23 = " = startdf_";
  protected final String TEXT_24 = ".getCalendar();" + NL + "\t\t\tjava.util.GregorianCalendar startDate_";
  protected final String TEXT_25 = " = (java.util.GregorianCalendar) startCal_";
  protected final String TEXT_26 = ";" + NL + "\t\t\tstartXMLGregorianCalendar_";
  protected final String TEXT_27 = " = new com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl(startDate_";
  protected final String TEXT_28 = ");" + NL + "\t\t}" + NL + "    \tif(endDateString_";
  protected final String TEXT_29 = "!=null && !endDateString_";
  protected final String TEXT_30 = ".equals(\"\")){" + NL + "        \tjava.text.SimpleDateFormat enddf_";
  protected final String TEXT_31 = " = new java.text.SimpleDateFormat(\"yyyy-MM-dd HH:mm:ss\");" + NL + "            enddf_";
  protected final String TEXT_32 = ".parse(endDateString_";
  protected final String TEXT_33 = ");" + NL + "            java.util.Calendar endCal_";
  protected final String TEXT_34 = " = enddf_";
  protected final String TEXT_35 = ".getCalendar();" + NL + "            java.util.GregorianCalendar endDate_";
  protected final String TEXT_36 = " = (java.util.GregorianCalendar) endCal_";
  protected final String TEXT_37 = ";" + NL + "\t\t\tendXMLGregorianCalendar_";
  protected final String TEXT_38 = " = new com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl(endDate_";
  protected final String TEXT_39 = ");" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tdeleted_task_";
  protected final String TEXT_40 = " = TDSCWS_";
  protected final String TEXT_41 = ".deleteTasks(";
  protected final String TEXT_42 = ",";
  protected final String TEXT_43 = ",";
  protected final String TEXT_44 = ",startXMLGregorianCalendar_";
  protected final String TEXT_45 = ",endXMLGregorianCalendar_";
  protected final String TEXT_46 = ",";
  protected final String TEXT_47 = ",";
  protected final String TEXT_48 = ",";
  protected final String TEXT_49 = ");" + NL + "\t\t" + NL + "\t\tglobalMap.put(\"";
  protected final String TEXT_50 = "_DELETED_TASK_NUMBER\",deleted_task_";
  protected final String TEXT_51 = ");";
  protected final String TEXT_52 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();	

	String host = ElementParameterParser.getValue(node, "__HOST__");
	String port = ElementParameterParser.getValue(node, "__PORT__");
	String taskType = ElementParameterParser.getValue(node, "__TASKTYPE__");
	String owner = ElementParameterParser.getValue(node,"__OWNER__");
	String tag = ElementParameterParser.getValue(node, "__TAG__");
	String startDate = ElementParameterParser.getValue(node, "__START_DATETIME__");
	String endDate = ElementParameterParser.getValue(node, "__END_DATETIME__");
	String starRanking = ElementParameterParser.getValue(node, "__STAR_RANKING__");
	String limit = ElementParameterParser.getValue(node,"__LIMIT__");
	String status = ElementParameterParser.getValue(node,"__STATUS__");
	String username = ElementParameterParser.getValue(node, "__USERNAME__");
	String password = ElementParameterParser.getValue(node, "__PASSWORD__");
	boolean targetRecordOnly = ("true").equals(ElementParameterParser.getValue(node,"__TARGET_RECORD_ONLY__"));
			

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(username);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(password);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(port);
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
    stringBuffer.append(startDate.equals("")?null:startDate);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(endDate.equals("")?null:endDate);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(taskType);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(owner.equals("")?null:owner);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(tag.equals("")?null:tag);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(starRanking);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(limit);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(status.equals("null")?null:"\""+status+"\"");
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(TEXT_52);
    return stringBuffer.toString();
  }
}