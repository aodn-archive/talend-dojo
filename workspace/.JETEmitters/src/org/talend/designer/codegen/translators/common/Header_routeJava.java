package org.talend.designer.codegen.translators.common;

import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Map;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.talend.core.GlobalServiceRegister;
import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.JavaResourcesHelper;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.ui.branding.AbstractBrandingService;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.designer.codegen.ITalendSynchronizer;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.CodeGeneratorRoutine;
import org.talend.core.model.process.EParameterFieldType;

public class Header_routeJava
{
  protected static String nl;
  public static synchronized Header_routeJava create(String lineSeparator)
  {
    nl = lineSeparator;
    Header_routeJava result = new Header_routeJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL;
  protected final String TEXT_4 = NL + "\t\t";
  protected final String TEXT_5 = " ;";
  protected final String TEXT_6 = NL + NL + "/**" + NL + " * Job: ";
  protected final String TEXT_7 = " Purpose: ";
  protected final String TEXT_8 = "<br>" + NL + " * Description: ";
  protected final String TEXT_9 = " <br>" + NL + " * @author ";
  protected final String TEXT_10 = NL + " * @version ";
  protected final String TEXT_11 = NL + " * @status ";
  protected final String TEXT_12 = NL + " */" + NL + " public class ";
  protected final String TEXT_13 = " implements TalendESBRoute {" + NL + "" + NL + "\tprivate final String jobVersion = \"";
  protected final String TEXT_14 = "\";" + NL + "\tprivate final String jobName = \"";
  protected final String TEXT_15 = "\";" + NL + "\tprivate final String projectName = \"";
  protected final String TEXT_16 = "\";" + NL + "\tpublic Integer errorCode = null;" + NL + "\tprivate String currentComponent = \"\";" + NL + "\tpublic TalendESBRoute stopDelegate = null;" + NL + "" + NL + "\tpublic ";
  protected final String TEXT_17 = "(){" + NL + "\t\tinitUriMap();" + NL + "\t}" + NL + "" + NL + "\tpublic void stop() throws Exception {" + NL + "\t\tif (stopDelegate != null) stopDelegate.stop();" + NL + "\t}" + NL + "" + NL + "\tpublic void shutdown() throws Exception {" + NL + "\t\tif (stopDelegate != null) stopDelegate.shutdown();" + NL + "\t}" + NL;
  protected final String TEXT_18 = NL + "\t\t\tprivate org.osgi.framework.BundleContext bundleContext;" + NL + "" + NL + "\t\t\tpublic void setBundleContext(org.osgi.framework.BundleContext bundleContext) {" + NL + "\t\t\t\tthis.bundleContext = bundleContext;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_19 = NL;
  protected final String TEXT_20 = NL + "\t\t\t//ESB Service Activity Monitor Feature" + NL + "\t\t\tprivate org.apache.cxf.feature.AbstractFeature eventFeature;" + NL + "" + NL + "\t\t\tpublic void setEventFeature(org.apache.cxf.feature.AbstractFeature eventFeature) {" + NL + "\t\t\t\tthis.eventFeature = eventFeature;" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_21 = NL + NL + "\tprivate org.apache.camel.builder.RouteBuilder routeBuilder;" + NL + "" + NL + "\tprivate java.util.Map<String, String> uriMap;" + NL + "" + NL + "\tpublic java.util.Map<String,String> getUriMap() {" + NL + "\t\treturn this.uriMap;" + NL + "\t}" + NL + "" + NL + "\tpublic void loadCustomUriMap(java.util.Map<String,String> newMap) {" + NL + "\t\tif(newMap == null) {" + NL + "\t\t\treturn;" + NL + "\t\t}" + NL + "\t\tfor(java.util.Map.Entry<String, String> entry: newMap.entrySet()) {" + NL + "\t\t\turiMap.put(entry.getKey(), entry.getValue());" + NL + "\t\t}" + NL + "\t}" + NL + "" + NL + "\tprotected void initUriMap() {" + NL + "\t\turiMap = new java.util.HashMap<String, String>();";
  protected final String TEXT_22 = NL + "\t\turiMap.put(\"";
  protected final String TEXT_23 = "\", ";
  protected final String TEXT_24 = ");";
  protected final String TEXT_25 = NL + "\t}" + NL + "" + NL + "\tprivate java.util.Properties defaultProps = new java.util.Properties();" + NL + "" + NL + "\tpublic class ContextProperties extends java.util.Properties {" + NL + "" + NL + "\t\tpublic ContextProperties(java.util.Properties properties) {" + NL + "\t\t\tsuper(properties);" + NL + "\t\t}" + NL + "\t\tpublic ContextProperties() {" + NL + "\t\t\tsuper();" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void synchronizeContext() {" + NL + "\t\t";
  protected final String TEXT_26 = NL + "\t\t\tif(";
  protected final String TEXT_27 = " != null){" + NL + "\t\t\t";
  protected final String TEXT_28 = NL + "\t\t\t\tString pattern_";
  protected final String TEXT_29 = " = \"yyyy-MM-dd HH:mm:ss\";" + NL + "\t\t\t\tString value_";
  protected final String TEXT_30 = " = \"";
  protected final String TEXT_31 = "\";" + NL + "\t\t\t\tString[] parts_";
  protected final String TEXT_32 = " = value_";
  protected final String TEXT_33 = ".split(\";\");" + NL + "\t\t\t\tif (parts_";
  protected final String TEXT_34 = ".length > 1) {" + NL + "\t\t\t\t\tpattern_";
  protected final String TEXT_35 = " = parts_";
  protected final String TEXT_36 = "[0];" + NL + "\t\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_37 = "\", pattern_";
  protected final String TEXT_38 = " + \";\" + FormatterUtils.format_Date(";
  protected final String TEXT_39 = ", pattern_";
  protected final String TEXT_40 = "));" + NL + "\t\t\t\t} else {" + NL + "\t\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_41 = "\", FormatterUtils.format_Date(";
  protected final String TEXT_42 = ", pattern_";
  protected final String TEXT_43 = "));" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_44 = NL + "\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_45 = "\", ";
  protected final String TEXT_46 = ".toString());" + NL + "\t\t\t";
  protected final String TEXT_47 = NL + "\t\t\t}" + NL + "\t\t";
  protected final String TEXT_48 = NL + "\t\t}" + NL;
  protected final String TEXT_49 = NL + "\t\tpublic String ";
  protected final String TEXT_50 = ";" + NL + "\t\tpublic String get";
  protected final String TEXT_51 = "() {" + NL + "\t\t\treturn this.";
  protected final String TEXT_52 = ";" + NL + "\t\t}";
  protected final String TEXT_53 = NL + "\t\tpublic ";
  protected final String TEXT_54 = " ";
  protected final String TEXT_55 = ";" + NL + "\t\tpublic ";
  protected final String TEXT_56 = " get";
  protected final String TEXT_57 = "() {" + NL + "\t\t\treturn this.";
  protected final String TEXT_58 = ";" + NL + "\t\t}";
  protected final String TEXT_59 = NL + "\t}" + NL + "" + NL + "\tprivate ContextProperties context = new ContextProperties();" + NL + "\tpublic ContextProperties getContext() {" + NL + "\t\treturn this.context;" + NL + "\t}" + NL + NL + NL;
  protected final String TEXT_60 = NL + NL + "\tclass MyStatThread implements Runnable {" + NL + "" + NL + "\t\tCamelStat stats;" + NL + "\t\tboolean isFinished;" + NL + "" + NL + "\t\tpublic MyStatThread(CamelStat stats) {" + NL + "\t\t\tthis.stats = stats;" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void run() {" + NL + "\t\t\twhile (true) {" + NL + "\t\t\t\ttry {";
  protected final String TEXT_61 = NL + "\t\t\t\t\tstats.updateStatOnConnection(\"";
  protected final String TEXT_62 = "\", 1, \"";
  protected final String TEXT_63 = "\");";
  protected final String TEXT_64 = NL + "\t\t\t\t\tThread.sleep(1000);" + NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t}";
  protected final String TEXT_65 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess) v.get(0);
	String version = (String) v.get(1);

	List<? extends INode> processNodes = (List<? extends INode>) process.getGeneratingNodes();
	List<? extends INode> graphicalNodes = (List<? extends INode>) process.getGraphicalNodes();
	boolean stats = codeGenArgument.isStatistics();
	boolean trace = codeGenArgument.isTrace();
	boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();
	List<IContextParameter> params = new ArrayList<IContextParameter>();
	params=process.getContextManager().getDefaultContext().getContextParameterList();

    
IBrandingService service = (IBrandingService) GlobalServiceRegister.getDefault().getService(IBrandingService.class);
if (service instanceof AbstractBrandingService) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(((AbstractBrandingService) service).getJobLicenseHeader(version));
    
}

	String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
	String packageName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + jobFolderName;

    stringBuffer.append(TEXT_2);
    stringBuffer.append( packageName );
    stringBuffer.append(TEXT_3);
    
	java.util.Set<String> importsSet = new java.util.TreeSet<String>();
	for (String routine : CodeGeneratorRoutine.getRequiredRoutineName(process)) {
		if (!routine.equals(ITalendSynchronizer.TEMPLATE)) {
			importsSet.add("import routines."+routine);
		}
	}
	importsSet.add("import routines.system.*");
	importsSet.add("import routines.system.api.*");
	importsSet.add("import java.text.ParseException");
	importsSet.add("import java.text.SimpleDateFormat");
	importsSet.add("import java.util.Date");
	importsSet.add("import java.util.List");
	importsSet.add("import java.math.BigDecimal");
	importsSet.add("import java.io.ByteArrayOutputStream");
	importsSet.add("import java.io.ByteArrayInputStream");
	importsSet.add("import java.io.DataInputStream");
	importsSet.add("import java.io.DataOutputStream");
	importsSet.add("import java.io.ObjectOutputStream");
	importsSet.add("import java.io.ObjectInputStream");
	importsSet.add("import java.io.IOException");
	importsSet.add("import java.util.Comparator");
	importsSet.add("import java.util.Map");
	importsSet.add("import java.util.HashMap");
	importsSet.add("import org.apache.camel.spi.Registry");
	
	String headerImports = ElementParameterParser.getValue(process, "__HEADER_IMPORT__");
	if(headerImports!=null && !"".equals(headerImports.trim())){
		String[] imports = headerImports.split(";");
		for(String s: imports){
			if(s!=null && !"".equals(s.trim())){
				importsSet.add(s.trim());
			}
		}
	}
	String footerImports = ElementParameterParser.getValue(process, "__FOOTER_IMPORT__");
	if(footerImports!=null && !"".equals(footerImports.trim())){
		String[] imports = footerImports.split(";");
		for(String s: imports){
			if(s!=null && !"".equals(s.trim())){
				importsSet.add(s.trim());
			}
		}
	}

//	List<INode> nodesWithImport = process.getNodesWithImport();
//	if (nodesWithImport != null) {
//		for (INode node:nodesWithImport) {
//			String tmp = ElementParameterParser.getValue(node, "__IMPORT__");
//			if(tmp == null || "".equals(tmp.trim())){
//				continue;
//			}
//			String[] imports = tmp.trim().split(";");
//			for(String s: imports){
//				if(s!=null && !"".equals(s.trim())){
//					importsSet.add(s.trim());
//				}
//			}
//		}
//	}
	List<? extends INode> generatingNodes = process.getGeneratingNodes();
	for(INode n: generatingNodes){
		List<? extends IElementParameter> elementParameters = n.getElementParameters();
		for(IElementParameter p: elementParameters){
			if(p.getShowIf() != null && !p.isShow(elementParameters)){
				continue;
			}
			if(EParameterFieldType.MEMO_IMPORT == p.getFieldType()){
				Object value = p.getValue();
				if(value == null || !(value instanceof String) || "".equals(((String)value).trim())){
					continue;
				}
				String[] imports = ((String)value).trim().split(";");
				for(String s: imports){
					if(s!=null && !"".equals(s.trim())){
						importsSet.add(s.trim());
					}
				}
			}
		}
		
	}
	
	for(String s: importsSet){

    stringBuffer.append(TEXT_4);
    stringBuffer.append(s);
    stringBuffer.append(TEXT_5);
    
	}

    stringBuffer.append(TEXT_6);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(process, "__PURPOSE__") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getValue(process, "__DESCRIPTION__") );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(ElementParameterParser.getValue(process, "__AUTHOR__") );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(version );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getValue(process, "__STATUS__") );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_13);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_17);
    
	for (INode node : graphicalNodes) {
		Object value = node.getPropertyValue("STARTABLE");
		if (null != value && (Boolean) value) { 
    stringBuffer.append(TEXT_18);
     break;
		}
	}

    stringBuffer.append(TEXT_19);
    
	for (INode node : graphicalNodes) {
		if("cCXF".equals(node.getComponent().getName())) { 
    stringBuffer.append(TEXT_20);
     break;
		}
	}

    stringBuffer.append(TEXT_21);
    
String cid = "";
String componentName = "";
String uri = "";
for (INode node : graphicalNodes) {
   	cid = node.getUniqueName();
//  http://jira.talendforge.org/browse/TESB-5241
	/*
   	 * change to use label + unique to make it unique but readable
   	 */
	IElementParameter param = node.getElementParameter("LABEL");
	if(param != null && !"__UNIQUE_NAME__".equals(param.getValue())){
		cid = (String)param.getValue()+"_"+cid;	
	}
   	
	componentName = node.getComponent().getName();
	uri = "";
	if ("cMessagingEndpoint".equals(componentName)) {
		uri = ElementParameterParser.getValue(node, "__URI__");
	} else if ("cFile".equals(componentName)) {
		String filePath = ElementParameterParser.getValue(node, "__URI__");
		String noop = ElementParameterParser.getValue(node, "__NOOP__");
		String flatten = ElementParameterParser.getValue(node, "__FLATTEN__");
		String bufferSize = ElementParameterParser.getValue(node, "__BUFFER_SIZE__");
		String autoCreate = ElementParameterParser.getValue(node, "__AUTOCREATE__");
		String fileName = ElementParameterParser.getValue(node, "__FILENAME__");
		String charset = ElementParameterParser.getValue(node, "__ENCODING__");

		StringBuffer arguments = new StringBuffer();

		uri = "\"file://\"+" + filePath;

		if ("true".equals(noop)) {
			arguments.append("\"noop=true\"+");
		} else {
			arguments.append("\"noop=false\"+");
		}

		if ("false".equals(autoCreate)) {// default true, ignore.
			arguments.append("\"&autoCreate=false\"+");
		}

		if ("true".equals(flatten)) {// default false, ignore.
			arguments.append("\"&flatten=true\"+");
		}

		if (fileName != null && !fileName.equals("\"\"") && fileName.length() > 0 ) {
			arguments.append("\"&fileName=\"+").append(fileName).append("+");
		}

		if (charset != null  && !charset.equals("\"\"") && charset.length() > 0) {
			arguments.append("\"&charset=\"+").append(charset).append("+");
		}

		if (bufferSize != null && !bufferSize.equals("\"\"") && bufferSize.length() > 0) {
			arguments.append("\"&bufferSize=\"+").append(bufferSize).append("+");
		}

		List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ADVARGUMENTS__");
		for (Map<String, String> map : tableValues) {
			String argName = map.get("NAME");
			String argValue = map.get("VALUE");
			arguments.append("\"&\"+").append(argName).append("+\"=\"+").append(argValue).append("+");
		}

		if (arguments.length() > 0) {
			arguments.deleteCharAt(arguments.length() - 1);
			uri = uri + "+\"?\"+" + arguments.toString();
		}
		System.out.println(uri);

	} else if ("cCXF".equals(componentName)) {
		String url = ElementParameterParser.getValue(node, "__ADDRESS__").trim();

		if ("true".equals(ElementParameterParser.getValue(node, "__ENABLE_SL__"))) {
			List<? extends IConnection> conns = node.getIncomingConnections();
			if (!conns.isEmpty()) {
				INode source = conns.get(0).getSource();
				if (!("cErrorHandler".equals(source.getComponent().getName())
						&& source.getIncomingConnections().isEmpty())) {
					// consumer role
					url = "((null == bundleContext) ? " + url + " : \"locator://locator/\")";
				}
			}
		}

		String serviceType = ElementParameterParser.getValue(node, "__SERVICE_TYPE__");

		StringBuilder sb = new StringBuilder();
		sb.append("\"cxf://\"+").append(url).append("+\"?" + serviceType + "=\"");

		if ("wsdlURL".equals(serviceType)) {
		
			//http://jira.talendforge.org/browse/TESB-6226
		    String filePath = "";
			
			String wsdlType = ElementParameterParser.getValue(node, "__WSDL_TYPE__");
			if("file".equals(wsdlType)){
			  filePath =  ElementParameterParser.getValue(node, "__WSDL_FILE__");
			}else{
				filePath =  ElementParameterParser.getValue(node, "__ROUTE_RESOURCE_TYPE_RES_URI__");
				filePath = "\"classpath:" + filePath + "\"";
			}
			filePath.replaceAll("\\\\","/");
			sb.append("+").append(filePath);
		} else {
			sb.append("+" + ElementParameterParser.getValue(node, "__SERVICE_CLASS__"));
		}


		String dataformat = ElementParameterParser.getValue(node, "__DATAFORMAT__");
		sb.append("+\"&dataFormat=" + dataformat + "\"");

		String specifyService = ElementParameterParser.getValue(node, "__SPECIFY_SERVICE__");
		if("true".equals(specifyService)){
			sb.append("+\"&serviceName=\"+").append(ElementParameterParser.getValue(node, "__SERVICE_NAME__").trim());
			sb.append("+\"&portName=\"+").append(ElementParameterParser.getValue(node, "__PORT_NAME__").trim());
		}

		List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ADVARGUMENTS__");
		for (Map<String, String> map : tableValues) {
			String argName = map.get("NAME").trim();
			String argValue = map.get("VALUE").trim();
			sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
		}
		uri = sb.toString();

	} else if ("cFtp".equals(componentName)) {
		String type = ElementParameterParser.getValue(node, "__TYPE__");
		String username = ElementParameterParser.getValue(node, "__USERNAME__");
		String server = ElementParameterParser.getValue(node, "__SERVER__");
		String port = ElementParameterParser.getValue(node, "__PORT__");
		String password = ElementParameterParser.getValue(node, "__PASSWORD__");
		String directory = ElementParameterParser.getValue(node, "__DIRECTORY__");

		StringBuffer fragments = new StringBuffer();
		fragments.append("\"" + type + "://\"");

		if (username.trim().length() > 0) {
			fragments.append("+" + username.trim()).append("+\"@\"");
		}

		fragments.append("+" + server.trim());

		if (port.trim().length() > 0) {
			fragments.append("+\":\"").append("+" + port.trim());
		}

		if (directory.trim().length() > 0) {
			fragments.append("+\"/\"").append("+" + directory.trim());
		}

		boolean hasArg = false;
		if (password.trim().length() > 0) {
			hasArg = true;
			fragments.append("+\"?password=\"+" + password);
		}

		List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ADVARGUMENTS__");
		for (Map<String, String> map : tableValues) {
			String argName = map.get("NAME").trim();
			String argValue = map.get("VALUE").trim();
			if (!hasArg) {
				fragments.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
				hasArg = true;
			} else {
				fragments.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			}
		}
		uri = fragments.toString();

	} else if("cJMS".equals(componentName)) {
		//http://jira.talendforge.org/browse/TESB-4861
		String name = ElementParameterParser.getValue(node, "__ROUTE_COMPONENT_TYPE_ID__");
		if (name == null || name.equals("")) {
			name = "jms";
		}
		name = name.replace("_", "");
		name = "\"" + name + "\"";
		//String name = ElementParameterParser.getValue(node, "__NAME__").trim();
		//Remove unnecessary subfix
		//name += "+";
		//name += ElementParameterParser.getValue(node, "__SUBFIX__").trim();
		String type = ElementParameterParser.getValue(node, "__TYPE__");
		String destination = ElementParameterParser.getValue(node, "__DESTINATION__").trim();

		boolean hasOptions = false;

		StringBuffer sb = new StringBuffer();
		sb.append(name).append("+\":" + type + ":\"").append("+" + destination);

		List<Map<String, String>> tableValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__URI_OPTIONS__");
		for (Map<String, String> map : tableValues) {
			String argName = map.get("NAME").trim();
			String argValue = map.get("VALUE").trim();

			if (!hasOptions) {
				sb.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
				hasOptions = true;
			} else {
				sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			}
		}

		uri = sb.toString();

	} else if ("cLog".equals(componentName)) {
		String useLogEIP = ElementParameterParser.getValue(node, "__USE_LOGEIP__");
		if ("true".equals(useLogEIP)) {
			continue;
		}

		StringBuffer sb = new StringBuffer();
		sb.append("\"log:").append(cid);

		String level = ElementParameterParser.getValue(node, "__LEVEL_TYPE__");
		sb.append("?").append("level=").append(level);

		String isSize = ElementParameterParser.getValue(node, "__GROUP_SIZE__");
		String isInterval = ElementParameterParser.getValue(node, "__GROUP_INTERVAL__");
		String isFormat = ElementParameterParser.getValue(node, "__FORMAT__");

		if ("true".equals(isSize)) {
			String groupSize = ElementParameterParser.getValue(node, "__SIZE__");
			sb.append("&groupSize=").append(groupSize).append("\"");
		} else if ("true".equals(isInterval)) {
			String interval = ElementParameterParser.getValue(node, "__INTERVAL__");
			sb.append("&groupInterval=").append(interval);
			String delay = ElementParameterParser.getValue(node, "__DELAY__");
			if (!"0".equals(delay)) {
				sb.append("&groupDelay=").append(delay);
			}
			String activeOnly = ElementParameterParser.getValue(node, "__ACTIVE_ONLY__");
			if (!"true".equals(activeOnly)) {
				sb.append("&groupActiveOnly=").append(activeOnly);
			}
			sb.append("\"");
		} else if ("true".equals(isFormat)) {
			sb.append("\"");
			List<Map<String, String>> formatValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ARGUMENTS__");
			for (Map<String, String> map : formatValues) {
				String argName = map.get("NAME").trim();
				String argValue = map.get("VALUE").trim();
				sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			}
		} else {
			sb.append("\"");
		}

		uri = sb.toString();

	} else if ("cMail".equals(componentName)) {

		StringBuffer sb = new StringBuffer();

		String protocols = ElementParameterParser.getValue(node, "__PROTOCOLS__");
		sb.append("\"").append(protocols).append("://");

		String host = ElementParameterParser.getValue(node, "__HOST__");
		sb.append("\"+").append(host);

		String port = ElementParameterParser.getValue(node, "__PORT__");
		if (!"\"\"".equals(port)) {
			sb.append("+\":\"+").append(port);
		}

		boolean hasParam = false;
		String userName = ElementParameterParser.getValue(node, "__USERNAME__");
		if (!"\"\"".equals(userName)) {
			sb.append("+\"?username=\"+").append(userName);
			hasParam = true;
		}

		String password = ElementParameterParser.getValue(node, "__PASSWORD__");
		if (!"\"\"".equals(password)) {
			if (hasParam) {
				sb.append("+\"&password=\"+");
			} else {
				sb.append("+\"?password=\"+");
			}
			sb.append(password);
			hasParam = true;
		}

		String subject = ElementParameterParser.getValue(node, "__SUBJECT__");
		if (!"\"\"".equals(subject)) {
			if (hasParam) {
				sb.append("+\"&subject=\"+");
			} else {
				sb.append("+\"?subject=\"+");
			}
			sb.append(subject);
			hasParam = true;
		}

		String from = ElementParameterParser.getValue(node, "__FROM__");
		if (!"\"\"".equals(from)) {
			if (hasParam) {
				sb.append("+\"&from=\"+");
			} else {
				sb.append("+\"?from=\"+");
			}
			sb.append(from);
			hasParam = true;
		}

		String to = ElementParameterParser.getValue(node, "__TO__");
		if (!"\"\"".equals(to)) {
			if (hasParam) {
				sb.append("+\"&to=\"+");
			} else {
				sb.append("+\"?to=\"+");
			}
			sb.append(to);
			hasParam = true;
		}

		String contentType = ElementParameterParser.getValue(node, "__CONTENTTYPE__");
		if (!"\"\"".equals(contentType)) {
			if (hasParam) {
				sb.append("+\"&contentType=\"+");
			} else {
				sb.append("+\"?contentType=\"+");
			}
			sb.append(contentType);
			hasParam = true;
		}

		String cc = ElementParameterParser.getValue(node, "__CC__");
		if (!"\"\"".equals(cc)) {
			if (hasParam) {
				sb.append("+\"&CC=\"+");
			} else {
				sb.append("+\"?CC=\"+");
			}
			sb.append(cc);
			hasParam = true;
		}

		String bcc = ElementParameterParser.getValue(node, "__BCC__");
		if (!"\"\"".equals(bcc)) {
			if (hasParam) {
				sb.append("+\"&BCC=\"+");
			} else {
				sb.append("+\"?BCC=\"+");
			}
			sb.append(bcc);
			hasParam = true;
		}

		List<Map<String, String>> formatValues = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__ARGUMENTS__");
		for (Map<String, String> map : formatValues) {
			String argName = map.get("NAME").trim();
			String argValue = map.get("VALUE").trim();
			if (hasParam) {
				sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
			} else {
				sb.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
				hasParam = true;
			}
		}

		//sb.append("+\"");
		uri = sb.toString();
	} else if ("cHttp".equals(componentName)) {

		StringBuffer sb = new StringBuffer();

		String resourceUri = ElementParameterParser.getValue(node, "__URI__");
		sb.append(resourceUri);

		boolean hasParam = resourceUri==null?false:resourceUri.contains("?");

		String method = ElementParameterParser.getValue(node, "__METHOD__");
		if("GET".equals(method)||"HEAD".equals(method) || "DELETE".equals(method)){
			List<Map<String, String>> parameters = (List<Map<String, String>>) ElementParameterParser.getObjectValue(node, "__PARAMETERS__");
			String encodeCharset = ElementParameterParser.getValue(node, "__ENCODER_CHARSET__");

			for (Map<String, String> map : parameters) {
				String argName = map.get("KEY").trim();
				String argValue = map.get("VALUE").trim();
				try{
					if(argName.startsWith("\"")&&argName.endsWith("\"")&&argName.length()>=2){
						argName = URLEncoder.encode(argName.substring(1, argName.length()-1),encodeCharset);
						argName = "\""+argName+"\"";
					}else{
						argName = URLEncoder.encode(argName,encodeCharset);
					}
					if(argValue.startsWith("\"")&&argValue.endsWith("\"")&&argValue.length()>=2){
						argValue = URLEncoder.encode(argValue.substring(1, argValue.length()-1),encodeCharset);
						argValue = "\""+argValue+"\"";
					}else{
						argValue = URLEncoder.encode(argValue,encodeCharset);
					}
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				if (hasParam) {
					sb.append("+\"&\"+" + argName + "+\"=\"+" + argValue);
				} else {
					sb.append("+\"?\"+" + argName + "+\"=\"+" + argValue);
					hasParam = true;
				}
			}
		}

		uri = sb.toString();
	} else {
		continue;
	}

    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(uri);
    stringBuffer.append(TEXT_24);
    
}

    stringBuffer.append(TEXT_25);
     for (IContextParameter ctxParam : params){
			String cParaName = ctxParam.getName(); 
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_27);
     if(ctxParam.getType().equals("id_Date")){ 
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(ctxParam.getValue() );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_43);
     } else { 
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_46);
     } 
    stringBuffer.append(TEXT_47);
     } 
    stringBuffer.append(TEXT_48);
    
for (IContextParameter ctxParam : params) {
	if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory")) { 
    stringBuffer.append(TEXT_49);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_51);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_52);
    	} else { 
    stringBuffer.append(TEXT_53);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_57);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_58);
    	}
}

    stringBuffer.append(TEXT_59);
     if(stats) { 
    stringBuffer.append(TEXT_60);
    
		for (INode node : processNodes) {
			if (node.isActivate()) {
				for(int i=0; i<node.getIncomingConnections().size(); i++) {

    stringBuffer.append(TEXT_61);
    stringBuffer.append(node.getIncomingConnections().get(i).getUniqueName());
    stringBuffer.append(TEXT_62);
    stringBuffer.append(node.getUniqueName());
    stringBuffer.append(TEXT_63);
    
				}
			}
		}

    stringBuffer.append(TEXT_64);
     } //if stats 
    stringBuffer.append(TEXT_65);
    return stringBuffer.toString();
  }
}
