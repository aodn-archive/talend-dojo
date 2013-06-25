package org.talend.designer.codegen.translators.esb.webservices;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TESBConsumerMainJava
{
  protected static String nl;
  public static synchronized TESBConsumerMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TESBConsumerMainJava result = new TESBConsumerMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "\t\t";
  protected final String TEXT_2 = " = null;" + NL + "\t";
  protected final String TEXT_3 = NL + "\ttry {" + NL + "\t\tDocument requestTalendDoc_";
  protected final String TEXT_4 = " = ";
  protected final String TEXT_5 = ".payload;" + NL + "" + NL + "\t\ttry {" + NL + "\t\t\torg.dom4j.Document responseDoc_";
  protected final String TEXT_6 = " = null;" + NL + "" + NL + "\t\t\tif (consumer_";
  protected final String TEXT_7 = " == null) {" + NL + "\t\t\t\tresponseDoc_";
  protected final String TEXT_8 = " = serviceInvokerHelper_";
  protected final String TEXT_9 = ".invoke(" + NL + "\t\t\t\t\t\tserviceName_";
  protected final String TEXT_10 = ", portName_";
  protected final String TEXT_11 = ", \"";
  protected final String TEXT_12 = "\"," + NL + "\t\t\t\t\t\trequestTalendDoc_";
  protected final String TEXT_13 = ".getDocument(), ";
  protected final String TEXT_14 = ");" + NL + "\t\t\t} else {" + NL + "\t\t\t\tjava.util.Map<String, String> customProps_";
  protected final String TEXT_15 = " = null;" + NL + "\t\t\t\t";
  protected final String TEXT_16 = NL + "\t\t\t\t\t\tcustomProps_";
  protected final String TEXT_17 = " = new java.util.HashMap<String, String>();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_18 = NL + "\t\t\t\t\t\tcustomProps_";
  protected final String TEXT_19 = ".put(";
  protected final String TEXT_20 = ", ";
  protected final String TEXT_21 = ");" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_22 = NL + "\t\t\t\t\t";
  protected final String TEXT_23 = NL + "\t\t\t\t";
  protected final String TEXT_24 = NL + "\t\t\t\tObject request_";
  protected final String TEXT_25 = " = wrapPayload(requestTalendDoc_";
  protected final String TEXT_26 = ".getDocument(), customProps_";
  protected final String TEXT_27 = ");" + NL + "\t\t\t\tresponseDoc_";
  protected final String TEXT_28 = " = (org.dom4j.Document) consumer_";
  protected final String TEXT_29 = ".invoke(request_";
  protected final String TEXT_30 = ");" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\t\tif (";
  protected final String TEXT_32 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_33 = " = new ";
  protected final String TEXT_34 = "Struct();" + NL + "\t\t\t\t}" + NL + "\t\t\t\tDocument responseTalendDoc_";
  protected final String TEXT_35 = " = null;" + NL + "\t\t\t\tif (null != responseDoc_";
  protected final String TEXT_36 = ") {" + NL + "\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_37 = " = new Document();" + NL + "\t\t\t\t\tresponseTalendDoc_";
  protected final String TEXT_38 = ".setDocument(responseDoc_";
  protected final String TEXT_39 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_40 = ".payload = responseTalendDoc_";
  protected final String TEXT_41 = ";" + NL + "\t\t\t";
  protected final String TEXT_42 = NL + "\t\t} catch (javax.xml.ws.soap.SOAPFaultException e) {" + NL + "\t\t\t";
  protected final String TEXT_43 = NL + "\t\t\t\tjavax.xml.soap.SOAPFault soapFault_";
  protected final String TEXT_44 = " = e.getFault();" + NL + "\t\t\t\torg.dom4j.Document faultDoc_";
  protected final String TEXT_45 = " = null;" + NL + "\t\t\t\tif (null != soapFault_";
  protected final String TEXT_46 = ".getDetail() && null != soapFault_";
  protected final String TEXT_47 = ".getDetail().getFirstChild()) {" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tjavax.xml.transform.Source faultSource_";
  protected final String TEXT_48 = " =" + NL + "\t\t\t\t\t\t\tnew javax.xml.transform.dom.DOMSource(soapFault_";
  protected final String TEXT_49 = ".getDetail().getFirstChild());" + NL + "" + NL + "\t\t\t\t\t\torg.dom4j.io.DocumentResult result_";
  protected final String TEXT_50 = " = new org.dom4j.io.DocumentResult();" + NL + "\t\t\t\t\t\tjavax.xml.transform.TransformerFactory.newInstance()" + NL + "\t\t\t\t\t\t\t.newTransformer().transform(faultSource_";
  protected final String TEXT_51 = ", result_";
  protected final String TEXT_52 = ");" + NL + "\t\t\t\t\t\tfaultDoc_";
  protected final String TEXT_53 = " = result_";
  protected final String TEXT_54 = ".getDocument();" + NL + "\t\t\t\t\t} catch (Exception e1) {" + NL + "\t\t\t\t\t\te1.printStackTrace();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tif (";
  protected final String TEXT_55 = " == null) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_56 = " = new ";
  protected final String TEXT_57 = "Struct();" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_58 = ".faultCode = soapFault_";
  protected final String TEXT_59 = ".getFaultCodeAsQName().toString();" + NL + "\t\t\t\t";
  protected final String TEXT_60 = ".faultString = soapFault_";
  protected final String TEXT_61 = ".getFaultString();" + NL + "\t\t\t\t";
  protected final String TEXT_62 = ".faultActor = soapFault_";
  protected final String TEXT_63 = ".getFaultActor();" + NL + "" + NL + "\t\t\t\t";
  protected final String TEXT_64 = ".faultNode = null;" + NL + "\t\t\t\t";
  protected final String TEXT_65 = ".faultRole = null;" + NL + "\t\t\t\tif (javax.xml.soap.SOAPConstants.URI_NS_SOAP_1_2_ENVELOPE.equals(soapFault_";
  protected final String TEXT_66 = ".getNamespaceURI())) {" + NL + "\t\t\t\t\t// SOAP 1.2" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_67 = ".faultNode = soapFault_";
  protected final String TEXT_68 = ".getFaultNode();" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_69 = ".faultRole = soapFault_";
  protected final String TEXT_70 = ".getFaultRole();" + NL + "\t\t\t\t\t} catch (java.lang.UnsupportedOperationException uoe) { }" + NL + "\t\t\t\t}" + NL + "" + NL + "\t\t\t\tDocument faultTalendDoc_";
  protected final String TEXT_71 = " = null;" + NL + "\t\t\t\tif (null != faultDoc_";
  protected final String TEXT_72 = ") {" + NL + "\t\t\t\t\tfaultTalendDoc_";
  protected final String TEXT_73 = " = new Document();" + NL + "\t\t\t\t\tfaultTalendDoc_";
  protected final String TEXT_74 = ".setDocument(faultDoc_";
  protected final String TEXT_75 = ");" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_76 = ".faultDetail = faultTalendDoc_";
  protected final String TEXT_77 = ";" + NL + "\t\t\t";
  protected final String TEXT_78 = NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t";
  protected final String TEXT_79 = NL + "\t\t}" + NL + "\t} catch(Exception e){" + NL + "\t\t";
  protected final String TEXT_80 = NL + "\t\t\tthrow(e);" + NL + "\t\t";
  protected final String TEXT_81 = NL + "\t\t\tSystem.err.print(e.getMessage());" + NL + "\t\t";
  protected final String TEXT_82 = NL + "\t}" + NL;
  protected final String TEXT_83 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode) codeGenArgument.getArgument();
String cid = node.getUniqueName();

String methodTemp = ElementParameterParser.getValue(node, "__METHOD__");
String method = methodTemp.indexOf("(") != -1 ? methodTemp.substring(0, methodTemp.indexOf("(")) : methodTemp;

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
if (inputConn != null) {
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

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(inputConn.getName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(method);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(ElementParameterParser.getValue(node, "__ESB_ENDPOINT__"));
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
     if (Boolean.valueOf(ElementParameterParser.getValue(node, "__SERVICE_ACTIVITY_MONITOR__"))) {
					List<Map<String, String>> customProperties = (List<Map<String,String>>)
							ElementParameterParser.getObjectValue(node, "__SERVICE_ACTIVITY_CUSTOM_PROPERTIES__");
					if (!customProperties.isEmpty()) { 
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
     for (int k = 0; k < customProperties.size(); k++) { 
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(customProperties.get(k).get("PROP_NAME"));
    stringBuffer.append(TEXT_20);
    stringBuffer.append(customProperties.get(k).get("PROP_VALUE"));
    stringBuffer.append(TEXT_21);
     } 
    stringBuffer.append(TEXT_22);
     } 
    stringBuffer.append(TEXT_23);
     } 
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
     if (null != connResponse) {
				String connResponseName = connResponse.getName(); 
    stringBuffer.append(TEXT_31);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(connResponseName);
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
    stringBuffer.append(connResponseName);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
     } 
    stringBuffer.append(TEXT_42);
     if (null != connFault) {
				String connFaultName = connFault.getName(); 
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(connFaultName);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_77);
     } else { 
    stringBuffer.append(TEXT_78);
     } 
    stringBuffer.append(TEXT_79);
     if (("true").equals(ElementParameterParser.getValue(node, "__DIE_ON_ERROR__"))) { 
    stringBuffer.append(TEXT_80);
     } else { 
    stringBuffer.append(TEXT_81);
     } 
    stringBuffer.append(TEXT_82);
     } 
    stringBuffer.append(TEXT_83);
    return stringBuffer.toString();
  }
}
