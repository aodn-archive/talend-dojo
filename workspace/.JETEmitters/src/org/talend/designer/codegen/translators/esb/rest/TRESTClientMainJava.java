package org.talend.designer.codegen.translators.esb.rest;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TRESTClientMainJava
{
  protected static String nl;
  public static synchronized TRESTClientMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TRESTClientMainJava result = new TRESTClientMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t";
  protected final String TEXT_2 = " = null;";
  protected final String TEXT_3 = NL + NL + "try {" + NL + "\t// request body" + NL + "\torg.dom4j.Document requestDoc_";
  protected final String TEXT_4 = " = null;" + NL + "\tString requestString_";
  protected final String TEXT_5 = " = null;" + NL + "\t";
  protected final String TEXT_6 = NL + "\t\tif (null != ";
  protected final String TEXT_7 = ".body) {" + NL + "\t\t\trequestDoc_";
  protected final String TEXT_8 = " = ";
  protected final String TEXT_9 = ".body.getDocument();" + NL + "\t\t}" + NL + "\t\trequestString_";
  protected final String TEXT_10 = " = ";
  protected final String TEXT_11 = ".string;" + NL + "\t";
  protected final String TEXT_12 = NL + NL + "\tObject requestBody_";
  protected final String TEXT_13 = " = requestDoc_";
  protected final String TEXT_14 = " != null ? requestDoc_";
  protected final String TEXT_15 = " : requestString_";
  protected final String TEXT_16 = ";" + NL + "" + NL + "\t// expected response body" + NL + "\tObject responseDoc_";
  protected final String TEXT_17 = " = null;" + NL + "\tClass<?> responseClass_";
  protected final String TEXT_18 = " = ";
  protected final String TEXT_19 = "String.class";
  protected final String TEXT_20 = "org.dom4j.Document.class";
  protected final String TEXT_21 = ";" + NL + "" + NL + "\t// create web client instance" + NL + "\torg.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_";
  protected final String TEXT_22 = " =" + NL + "\t\tnew org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();" + NL + "\tfactoryBean_";
  protected final String TEXT_23 = ".setAddress(";
  protected final String TEXT_24 = ");" + NL + "\t";
  protected final String TEXT_25 = NL + "\t\tfactoryBean_";
  protected final String TEXT_26 = ".setUsername(";
  protected final String TEXT_27 = ");" + NL + "\t\tfactoryBean_";
  protected final String TEXT_28 = ".setPassword(";
  protected final String TEXT_29 = ");" + NL + "\t";
  protected final String TEXT_30 = NL + NL + "\tjava.util.List<Object> providers_";
  protected final String TEXT_31 = " = new java.util.ArrayList<Object>();" + NL + "\tproviders_";
  protected final String TEXT_32 = ".add(new ClientDOM4JProvider());" + NL + "\torg.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_";
  protected final String TEXT_33 = " =" + NL + "\t\tnew org.apache.cxf.jaxrs.provider.json.JSONProvider();" + NL + "\tjsonProvider_";
  protected final String TEXT_34 = ".setIgnoreNamespaces(true);" + NL + "        jsonProvider_";
  protected final String TEXT_35 = ".setAttributesToElements(true); " + NL + "\tproviders_";
  protected final String TEXT_36 = ".add(jsonProvider_";
  protected final String TEXT_37 = ");" + NL + "\tfactoryBean_";
  protected final String TEXT_38 = ".setProviders(providers_";
  protected final String TEXT_39 = ");" + NL + "\tfactoryBean_";
  protected final String TEXT_40 = ".setTransportId(\"http://cxf.apache.org/transports/http\");" + NL + "" + NL + "\torg.apache.cxf.jaxrs.client.WebClient webClient_";
  protected final String TEXT_41 = " = factoryBean_";
  protected final String TEXT_42 = ".createWebClient();" + NL + "" + NL + "\t// set connection properties" + NL + "\torg.apache.cxf.transport.http.HTTPConduit conduit_";
  protected final String TEXT_43 = " =" + NL + "\torg.apache.cxf.jaxrs.client.WebClient.getConfig(webClient_";
  protected final String TEXT_44 = ").getHttpConduit();" + NL + "\tconduit_";
  protected final String TEXT_45 = ".getClient().setReceiveTimeout(";
  protected final String TEXT_46 = ");" + NL + "\tconduit_";
  protected final String TEXT_47 = ".getClient().setConnectionTimeout(";
  protected final String TEXT_48 = ");" + NL + "\t";
  protected final String TEXT_49 = NL + "\t\tconduit_";
  protected final String TEXT_50 = ".getClient().setProxyServer(";
  protected final String TEXT_51 = ");" + NL + "\t\tconduit_";
  protected final String TEXT_52 = ".getClient().setProxyServerPort(Integer.valueOf(";
  protected final String TEXT_53 = "));" + NL + "\t\tconduit_";
  protected final String TEXT_54 = ".getProxyAuthorization().setUserName(";
  protected final String TEXT_55 = ");" + NL + "\t\tconduit_";
  protected final String TEXT_56 = ".getProxyAuthorization().setPassword(";
  protected final String TEXT_57 = ");" + NL + "\t";
  protected final String TEXT_58 = NL + NL + "\t// set Content-Type" + NL + "\t";
  protected final String TEXT_59 = NL + "\t\twebClient_";
  protected final String TEXT_60 = ".type(\"";
  protected final String TEXT_61 = "\");" + NL + "\t";
  protected final String TEXT_62 = NL + "\t// set Accept-Type" + NL + "\t";
  protected final String TEXT_63 = NL + "\t\twebClient_";
  protected final String TEXT_64 = ".accept(\"";
  protected final String TEXT_65 = "\");" + NL + "\t";
  protected final String TEXT_66 = NL + NL + "\t// set optional query and header properties if any" + NL + "\t";
  protected final String TEXT_67 = NL + "\t\twebClient_";
  protected final String TEXT_68 = ".header(";
  protected final String TEXT_69 = " ,";
  protected final String TEXT_70 = ");" + NL + "\t";
  protected final String TEXT_71 = NL + NL + "\t// if FORM request then capture query parameters into Form, otherwise set them as queries" + NL + "\t";
  protected final String TEXT_72 = NL + "\t\torg.apache.cxf.jaxrs.ext.form.Form form_";
  protected final String TEXT_73 = " = new org.apache.cxf.jaxrs.ext.form.Form();" + NL + "\t\t";
  protected final String TEXT_74 = NL + "\t\t\tform_";
  protected final String TEXT_75 = ".set(";
  protected final String TEXT_76 = " ,";
  protected final String TEXT_77 = ");" + NL + "\t\t";
  protected final String TEXT_78 = NL + "\t\trequestBody_";
  protected final String TEXT_79 = " = form_";
  protected final String TEXT_80 = ";" + NL + "\t";
  protected final String TEXT_81 = NL + "\t\t";
  protected final String TEXT_82 = NL + "\t\t\twebClient_";
  protected final String TEXT_83 = ".query(";
  protected final String TEXT_84 = " ,";
  protected final String TEXT_85 = ");" + NL + "\t\t";
  protected final String TEXT_86 = NL + "\t";
  protected final String TEXT_87 = NL + NL + NL + "\ttry {" + NL + "" + NL + "\t\t";
  protected final String TEXT_88 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_89 = " = webClient_";
  protected final String TEXT_90 = ".get(responseClass_";
  protected final String TEXT_91 = ");" + NL + "\t\t";
  protected final String TEXT_92 = NL + "\t\t\tresponseDoc_";
  protected final String TEXT_93 = " = webClient_";
  protected final String TEXT_94 = ".post(requestBody_";
  protected final String TEXT_95 = ", responseClass_";
  protected final String TEXT_96 = ");" + NL + "\t\t";
  protected final String TEXT_97 = NL + "\t\t\twebClient_";
  protected final String TEXT_98 = ".invoke(\"";
  protected final String TEXT_99 = "\", requestBody_";
  protected final String TEXT_100 = ");" + NL + "\t\t";
  protected final String TEXT_101 = NL + NL + "\t\t";
  protected final String TEXT_102 = NL + "\t\t\tif (";
  protected final String TEXT_103 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_104 = " = new ";
  protected final String TEXT_105 = "Struct();" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\t";
  protected final String TEXT_106 = ".statusCode = webClient_";
  protected final String TEXT_107 = ".getResponse().getStatus();" + NL + "\t\t\tif (responseDoc_";
  protected final String TEXT_108 = " != null) {" + NL + "\t\t\t\tif (responseClass_";
  protected final String TEXT_109 = " == String.class) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_110 = ".string = (String) responseDoc_";
  protected final String TEXT_111 = ";" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tDocument responseTalendDoc_";
  protected final String TEXT_112 = " = null;" + NL + "\t\t\t\t\tif (null != responseDoc_";
  protected final String TEXT_113 = ") {" + NL + "\t\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_114 = " = new Document();" + NL + "\t\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_115 = ".setDocument((org.dom4j.Document) responseDoc_";
  protected final String TEXT_116 = ");" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_117 = ".body = responseTalendDoc_";
  protected final String TEXT_118 = ";" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_119 = NL + NL + "\t} catch (org.apache.cxf.jaxrs.client.ServerWebApplicationException ex_";
  protected final String TEXT_120 = ") {" + NL + "\t\t";
  protected final String TEXT_121 = NL + "\t\t\tif (";
  protected final String TEXT_122 = " == null) {" + NL + "\t\t\t\t";
  protected final String TEXT_123 = " = new ";
  protected final String TEXT_124 = "Struct();" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_125 = ".errorCode = ex_";
  protected final String TEXT_126 = ".getStatus();" + NL + "\t\t\t";
  protected final String TEXT_127 = ".errorMessage = ex_";
  protected final String TEXT_128 = ".getMessage();" + NL + "\t\t";
  protected final String TEXT_129 = NL + "\t\t\tSystem.out.println(\"error response: \" + ex_";
  protected final String TEXT_130 = ".getStatus() + \":\" + ex_";
  protected final String TEXT_131 = ".getMessage());" + NL + "\t\t";
  protected final String TEXT_132 = NL + "\t}" + NL + "" + NL + "} catch(Exception e_";
  protected final String TEXT_133 = ") {" + NL + "\t";
  protected final String TEXT_134 = NL + "\t\tthrow(e_";
  protected final String TEXT_135 = ");" + NL + "\t";
  protected final String TEXT_136 = NL + "\t\tSystem.err.print(e_";
  protected final String TEXT_137 = ".getMessage());" + NL + "\t";
  protected final String TEXT_138 = NL + "}";
  protected final String TEXT_139 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();


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

List<? extends IConnection> conns = node.getOutgoingSortedConnections();
if (conns != null && conns.size() > 0) {
	for (int i = 0; i < conns.size(); i++) {
		IConnection conn = conns.get(i);
		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_2);
    
		}
	}
}

List<? extends IConnection> connsResponse = node.getOutgoingConnections("RESPONSE");
List<? extends IConnection> connsFault = node.getOutgoingConnections("FAULT");
IConnection connResponse = null;
IConnection connFault = null;
if (connsResponse.size() == 1) {
	connResponse = connsResponse.get(0);
}
if (connsFault.size() == 1) {
	connFault = connsFault.get(0);
}



String url = ElementParameterParser.getValue(node,"__URL__");

String connectionTimeoutString = ElementParameterParser.getValue(node,"__CONNECTION_TIMEOUT__");
String connectionTimeoutSec = (null != connectionTimeoutString && !connectionTimeoutString.trim().isEmpty()) ? connectionTimeoutString : "30";
long connectionTimeout = (long) (Double.valueOf(connectionTimeoutSec) * 1000);

String receiveTimeoutString = ElementParameterParser.getValue(node,"__RECEIVE_TIMEOUT__");
String receiveTimeoutSec = (null != receiveTimeoutString && !receiveTimeoutString.trim().isEmpty()) ? receiveTimeoutString : "60";
long receiveTimeout = (long) (Double.valueOf(receiveTimeoutSec) * 1000);

List<Map<String, String>> headers = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__HEADERS__");
List<Map<String, String>> queries = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node,"__QUERY__");

String method = ElementParameterParser.getValue(node,"__METHOD__");

String acceptType = ElementParameterParser.getValue(node,"__ACCEPT_TYPE__");
if (acceptType == null) {
	acceptType = "application/xml";
}

String contentType = ElementParameterParser.getValue(node,"__CONTENT_TYPE__");
if (contentType == null) {
	contentType = "application/xml";
}

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
     if (null != inputConn) { 
    stringBuffer.append(TEXT_6);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_11);
     } 
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
     if ("*/*".equals(acceptType)) { 
    stringBuffer.append(TEXT_19);
     } else { 
    stringBuffer.append(TEXT_20);
     } 
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(url);
    stringBuffer.append(TEXT_24);
     if (Boolean.valueOf(ElementParameterParser.getValue(node,"__NEED_AUTH__"))) { 
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(ElementParameterParser.getValue(node,"__AUTH_USERNAME__"));
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ElementParameterParser.getValue(node,"__AUTH_PASSWORD__"));
    stringBuffer.append(TEXT_29);
     } 
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(receiveTimeout);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(connectionTimeout);
    stringBuffer.append(TEXT_48);
     if (Boolean.valueOf(ElementParameterParser.getValue(node,"__USE_PROXY__"))) { 
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PROXY_HOST__"));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PROXY_PORT__"));
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PROXY_USERNAME__"));
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ElementParameterParser.getValue(node,"__PROXY_PASSWORD__"));
    stringBuffer.append(TEXT_57);
     } 
    stringBuffer.append(TEXT_58);
     if (!"GET".equals(method) && !"DELETE".equals(method)) { 
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(contentType);
    stringBuffer.append(TEXT_61);
     } 
    stringBuffer.append(TEXT_62);
     if (!acceptType.isEmpty()) { 
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(acceptType);
    stringBuffer.append(TEXT_65);
     } 
    stringBuffer.append(TEXT_66);
     for (Map<String, String> header : headers) { 
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(header.get("NAME") );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(header.get("VALUE") );
    stringBuffer.append(TEXT_70);
     } 
    stringBuffer.append(TEXT_71);
     if ("application/x-www-form-urlencoded".equals(contentType) && !"GET".equals(method) && !"DELETE".equals(method)) { 
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
     for (Map<String, String> query : queries) { 
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(query.get("NAME") );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(query.get("VALUE") );
    stringBuffer.append(TEXT_77);
     } 
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
     } else { 
    stringBuffer.append(TEXT_81);
     for (Map<String, String> query : queries) { 
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(query.get("NAME") );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(query.get("VALUE") );
    stringBuffer.append(TEXT_85);
     } 
    stringBuffer.append(TEXT_86);
     } 
    stringBuffer.append(TEXT_87);
     if ("GET".equals(method)) { 
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
     } else if ("POST".equals(method)) { 
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
     } else { 
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
     } 
    stringBuffer.append(TEXT_101);
     if (null != connResponse) {
			String connResponseName = connResponse.getName(); 
    stringBuffer.append(TEXT_102);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
     } 
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
     if (null != connFault) {
			String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_121);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
     } else { 
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_131);
     } 
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
     if ("true".equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"))) { 
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
     } else { 
    stringBuffer.append(TEXT_136);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_137);
     } 
    stringBuffer.append(TEXT_138);
    stringBuffer.append(TEXT_139);
    return stringBuffer.toString();
  }
}
