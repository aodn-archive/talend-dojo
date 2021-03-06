package org.talend.designer.codegen.translators.common;

import org.talend.core.model.process.IProcess;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.designer.runprocess.CodeGeneratorRoutine;
import org.talend.designer.codegen.i18n.Messages;
import org.talend.core.ui.branding.IBrandingService;
import org.talend.core.ui.branding.AbstractBrandingService;
import org.talend.core.GlobalServiceRegister;
import org.talend.designer.codegen.ITalendSynchronizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Vector;
import org.talend.core.model.process.IContextParameter;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.utils.NodeUtil;
import org.talend.core.model.utils.JavaResourcesHelper;

public class HeaderJava
{
  protected static String nl;
  public static synchronized HeaderJava create(String lineSeparator)
  {
    nl = lineSeparator;
    HeaderJava result = new HeaderJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "package ";
  protected final String TEXT_3 = ";" + NL;
  protected final String TEXT_4 = NL + "import routines.";
  protected final String TEXT_5 = ";";
  protected final String TEXT_6 = NL + "import routines.system.*;" + NL + "import routines.system.api.*;" + NL + "import java.text.ParseException;" + NL + "import java.text.SimpleDateFormat;" + NL + "import java.util.Date;" + NL + "import java.util.List;" + NL + "import java.math.BigDecimal;" + NL + "import java.io.ByteArrayOutputStream;" + NL + "import java.io.ByteArrayInputStream;" + NL + "import java.io.DataInputStream;" + NL + "import java.io.DataOutputStream;" + NL + "import java.io.ObjectOutputStream;" + NL + "import java.io.ObjectInputStream;" + NL + "import java.io.IOException;" + NL + "import java.util.Comparator;" + NL;
  protected final String TEXT_7 = NL;
  protected final String TEXT_8 = NL;
  protected final String TEXT_9 = NL + NL;
  protected final String TEXT_10 = NL + "\t//the import part of ";
  protected final String TEXT_11 = NL + "\t";
  protected final String TEXT_12 = NL;
  protected final String TEXT_13 = NL + NL + "@SuppressWarnings(\"unused\")" + NL + "" + NL + "/**" + NL + " * Job: ";
  protected final String TEXT_14 = " Purpose: ";
  protected final String TEXT_15 = "<br>" + NL + " * Description: ";
  protected final String TEXT_16 = " <br>" + NL + " * @author ";
  protected final String TEXT_17 = NL + " * @version ";
  protected final String TEXT_18 = NL + " * @status ";
  protected final String TEXT_19 = NL + " */";
  protected final String TEXT_20 = NL + "public class ";
  protected final String TEXT_21 = " implements ";
  protected final String TEXT_22 = " {" + NL;
  protected final String TEXT_23 = NL + "\tpublic TalendESBJob newTalendESBJob() {" + NL + "\t\t";
  protected final String TEXT_24 = " talendESBJob = new ";
  protected final String TEXT_25 = "();" + NL + "\t\ttalendESBJob.setDataSources((java.util.Map<String, javax.sql.DataSource>) globalMap.get(KEY_DB_DATASOURCES));" + NL + "\t\treturn talendESBJob;" + NL + "\t}";
  protected final String TEXT_26 = NL + NL + "\tpublic final Object obj = new Object();" + NL + "" + NL + "\t// for transmiting parameters purpose" + NL + "\tprivate Object valueObject = null;" + NL + "" + NL + "\tpublic Object getValueObject() {" + NL + "\t\treturn this.valueObject;" + NL + "\t}" + NL + "" + NL + "\tpublic void setValueObject(Object valueObject) {" + NL + "\t\tthis.valueObject = valueObject;" + NL + "\t}";
  protected final String TEXT_27 = NL + "\tprivate Object[] multiThreadLockWrite = new Object[0];";
  protected final String TEXT_28 = NL + "\t";
  protected final String TEXT_29 = NL + "\tprivate final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();" + NL + "" + NL + "\t";
  protected final String TEXT_30 = NL + "\tprivate final static String utf8Charset = \"UTF-8\";" + NL + "" + NL + "\t// create and load default properties" + NL + "\tprivate java.util.Properties defaultProps = new java.util.Properties();" + NL + "\t// create application properties with default" + NL + "\tpublic class ContextProperties extends java.util.Properties {" + NL + "" + NL + "\t\tprivate static final long serialVersionUID = 1L;" + NL + "\t" + NL + "\t\tpublic ContextProperties(java.util.Properties properties){" + NL + "\t\t\tsuper(properties);" + NL + "\t\t}" + NL + "\t\tpublic ContextProperties(){" + NL + "\t\t\tsuper();" + NL + "\t\t}" + NL + "" + NL + "\t\tpublic void synchronizeContext(){" + NL + "\t\t\t";
  protected final String TEXT_31 = NL + "\t\t\tif(";
  protected final String TEXT_32 = " != null){" + NL + "\t\t\t\t";
  protected final String TEXT_33 = NL + "\t\t\t\t\tString pattern_";
  protected final String TEXT_34 = " = \"yyyy-MM-dd HH:mm:ss\";" + NL + "\t\t\t\t\tString value_";
  protected final String TEXT_35 = " = \"";
  protected final String TEXT_36 = "\";" + NL + "\t\t\t\t\tString[] parts_";
  protected final String TEXT_37 = " = value_";
  protected final String TEXT_38 = ".split(\";\");" + NL + "\t\t\t\t\tif(parts_";
  protected final String TEXT_39 = ".length > 1){" + NL + "\t\t\t\t\t\tpattern_";
  protected final String TEXT_40 = " = parts_";
  protected final String TEXT_41 = "[0];" + NL + "\t\t\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_42 = "\", pattern_";
  protected final String TEXT_43 = " + \";\" + FormatterUtils.format_Date(";
  protected final String TEXT_44 = ", pattern_";
  protected final String TEXT_45 = "));" + NL + "\t\t\t\t\t}else{" + NL + "\t\t\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_46 = "\", FormatterUtils.format_Date(";
  protected final String TEXT_47 = ", pattern_";
  protected final String TEXT_48 = "));" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_49 = NL + "\t\t\t\t\tthis.setProperty(\"";
  protected final String TEXT_50 = "\", ";
  protected final String TEXT_51 = ".toString());" + NL + "\t\t\t\t";
  protected final String TEXT_52 = NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_53 = NL + "\t\t}" + NL;
  protected final String TEXT_54 = NL + "\t\tpublic String ";
  protected final String TEXT_55 = ";" + NL + "\t\tpublic String get";
  protected final String TEXT_56 = "(){" + NL + "\t\t\treturn this.";
  protected final String TEXT_57 = ";" + NL + "\t\t}" + NL + "\t\t";
  protected final String TEXT_58 = NL + "public ";
  protected final String TEXT_59 = " ";
  protected final String TEXT_60 = ";" + NL + "public ";
  protected final String TEXT_61 = " get";
  protected final String TEXT_62 = "(){" + NL + "\treturn this.";
  protected final String TEXT_63 = ";" + NL + "}";
  protected final String TEXT_64 = NL + "\t}" + NL + "\tprivate ContextProperties context = new ContextProperties();" + NL + "\tpublic ContextProperties getContext() {" + NL + "\t\treturn this.context;" + NL + "\t}" + NL + "\tprivate final String jobVersion = \"";
  protected final String TEXT_65 = "\";" + NL + "\tprivate final String jobName = \"";
  protected final String TEXT_66 = "\";" + NL + "\tprivate final String projectName = \"";
  protected final String TEXT_67 = "\";" + NL + "\tpublic Integer errorCode = null;" + NL + "\tprivate String currentComponent = \"\";";
  protected final String TEXT_68 = NL + "\tprivate final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();" + NL + "\tprivate final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();" + NL + "\tprivate final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();" + NL + "\tprivate final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();" + NL + "\tpublic  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();";
  protected final String TEXT_69 = NL + "\tprivate final java.util.Map<String, Long> start_Hash = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Long>());" + NL + "\tprivate final java.util.Map<String, Long> end_Hash = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Long>());" + NL + "\tprivate final java.util.Map<String, Boolean> ok_Hash = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Boolean>());" + NL + "\tprivate final java.util.Map<String, Object> globalMap = java.util.Collections.synchronizedMap(new java.util.HashMap<String, Object>());" + NL + "\tpublic  final java.util.List<String[]> globalBuffer = java.util.Collections.synchronizedList(new java.util.ArrayList<String[]>());";
  protected final String TEXT_70 = NL;
  protected final String TEXT_71 = NL + "private RunStat runStat = new RunStat();";
  protected final String TEXT_72 = NL + "private RunTrace runTrace = new RunTrace();";
  protected final String TEXT_73 = NL + NL + "public boolean isExportedAsOSGI = ";
  protected final String TEXT_74 = ";" + NL + "" + NL + "\t// OSGi DataSource" + NL + "\tprivate final static String KEY_DB_DATASOURCES = \"KEY_DB_DATASOURCES\";" + NL + "" + NL + "\tpublic void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {" + NL + "\t\tglobalMap.put(KEY_DB_DATASOURCES, dataSources);" + NL + "\t}" + NL;
  protected final String TEXT_75 = NL + "\tLogCatcherUtils ";
  protected final String TEXT_76 = " = new LogCatcherUtils();";
  protected final String TEXT_77 = NL + "\tStatCatcherUtils ";
  protected final String TEXT_78 = " = new StatCatcherUtils(\"";
  protected final String TEXT_79 = "\", \"";
  protected final String TEXT_80 = "\");";
  protected final String TEXT_81 = NL + "\tMetterCatcherUtils ";
  protected final String TEXT_82 = " = new MetterCatcherUtils(\"";
  protected final String TEXT_83 = "\", \"";
  protected final String TEXT_84 = "\");";
  protected final String TEXT_85 = NL + "\tAssertCatcherUtils ";
  protected final String TEXT_86 = " = new AssertCatcherUtils();";
  protected final String TEXT_87 = NL + NL + "private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();" + NL + "private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));" + NL + "" + NL + "public String getExceptionStackTrace() {" + NL + "\tif (\"failure\".equals(this.getStatus())) {" + NL + "\t\terrorMessagePS.flush();" + NL + "\t\treturn baos.toString();" + NL + "\t}" + NL + "\treturn null;" + NL + "}" + NL + "" + NL + "private Exception exception = null;" + NL + "" + NL + "public Exception getException() {" + NL + "\tif (\"failure\".equals(this.getStatus())) {" + NL + "\t\treturn this.exception;" + NL + "\t}" + NL + "\treturn null;" + NL + "}" + NL + "" + NL + "private class TalendException extends Exception {" + NL + "" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "" + NL + "\tprivate java.util.Map<String, Object> globalMap = null;" + NL + "\tprivate Exception e = null;" + NL + "\tprivate String currentComponent = null;" + NL + "" + NL + "\tprivate TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {" + NL + "\t\tthis.currentComponent= errorComponent;" + NL + "\t\tthis.globalMap = globalMap;" + NL + "\t\tthis.e = e;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic void printStackTrace() {" + NL + "\t\tif (!(e instanceof TalendException || e instanceof TDieException)) {" + NL + "\t\t\t globalMap.put(currentComponent+\"_ERROR_MESSAGE\",e.getMessage());" + NL + "\t\t\tSystem.err.println(\"Exception in component \" + currentComponent);" + NL + "\t\t}" + NL + "\t\tif (!(e instanceof TDieException)) {" + NL + "\t\t\tif(e instanceof TalendException){" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t} else {" + NL + "\t\t\t\te.printStackTrace();" + NL + "\t\t\t\te.printStackTrace(errorMessagePS);" + NL + "\t\t\t\t";
  protected final String TEXT_88 = ".this.exception = e;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tif (!(e instanceof TalendException)) {" + NL + "\t\ttry {" + NL + "\t\t\tfor (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {" + NL + "\t\t\t\tif (m.getName().compareTo(currentComponent + \"_error\") == 0) {" + NL + "\t\t\t\t\tm.invoke(";
  protected final String TEXT_89 = ".this, new Object[] { e , currentComponent, globalMap});" + NL + "\t\t\t\t\tbreak;" + NL + "\t\t\t\t}" + NL + "\t\t\t}" + NL + "" + NL + "\t\t\tif(!(e instanceof TDieException)){";
  protected final String TEXT_90 = NL + "\t\t\t\t";
  protected final String TEXT_91 = ".addMessage(\"Java Exception\", currentComponent, 6, e.getClass().getName() + \":\" + e.getMessage(), 1);";
  protected final String TEXT_92 = NL + "\t\t\ttry{";
  protected final String TEXT_93 = NL + "\t\t\t\t";
  protected final String TEXT_94 = "Process(globalMap);";
  protected final String TEXT_95 = NL + "\t\t\t}finally{";
  protected final String TEXT_96 = NL + "\t\t\t\t";
  protected final String TEXT_97 = "Process(globalMap);";
  protected final String TEXT_98 = NL + "\t\t\t}";
  protected final String TEXT_99 = NL + "\t\t\t}" + NL + "\t\t} catch (java.lang.SecurityException e) {" + NL + "\t\t\tthis.e.printStackTrace();" + NL + "\t\t} catch (java.lang.IllegalArgumentException e) {" + NL + "\t\t\tthis.e.printStackTrace();" + NL + "\t\t} catch (java.lang.IllegalAccessException e) {" + NL + "\t\t\tthis.e.printStackTrace();" + NL + "\t\t} catch (java.lang.reflect.InvocationTargetException e) {" + NL + "\t\t\tthis.e.printStackTrace();" + NL + "\t\t}";
  protected final String TEXT_100 = NL + "\t\t\t\tcatch (TalendException e) {" + NL + "\t\t\t\t\t// do nothing" + NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_101 = NL + "\t\t} else {" + NL + "\t\t";
  protected final String TEXT_102 = NL + "\t\t((java.util.Map)threadLocal.get()).put(\"status\", \"failure\");" + NL + "\t\t";
  protected final String TEXT_103 = NL + "\t\t status = \"failure\";" + NL + "\t\t ";
  protected final String TEXT_104 = NL + "\t\t}" + NL + "\t}" + NL + "}" + NL;
  protected final String TEXT_105 = NL + "\t\t\tpublic void ";
  protected final String TEXT_106 = "_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {" + NL + "\t\t\t\tend_Hash.put(\"";
  protected final String TEXT_107 = "\", System.currentTimeMillis());" + NL + "\t\t\t\t";
  protected final String TEXT_108 = NL + "\t\t\t\t\t\t\t\tif(!(exception instanceof TDieException)){" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_109 = ".addMessage(pid, projectName, jobName, \"java\", null, \"Failed\", \"Job execution error\", exception.getMessage());" + NL + "\t\t\t\t\t\t\t\t\t";
  protected final String TEXT_110 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_111 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_112 = ".addMessage(\"failure\",\"";
  protected final String TEXT_113 = "\", end_Hash.get(\"";
  protected final String TEXT_114 = "\")-start_Hash.get(\"";
  protected final String TEXT_115 = "\"));" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_116 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_117 = NL + "\t\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_118 = NL + "\t\t\t\t\t\t\t\tif(this.execStat){" + NL + "\t\t\t\t\t\t    \t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_119 = "\", 0, \"error\");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_120 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_121 = NL + "\t\t\t\t\t\t\t\t((java.util.Map)threadLocal.get()).put(\"errorCode\", null);" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_122 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t\tif ( !\"failure\".equals(((java.util.Map)threadLocal.get()).get(\"status\")) ) {" + NL + "\t\t\t\t\t\t\t\t\t((java.util.Map)threadLocal.get()).put(\"status\", \"end\");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_123 = NL + "\t\t\t\t\t\t\t\terrorCode = null;" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_124 = "Process(globalMap);" + NL + "\t\t\t\t\t\t\t\tif (!\"failure\".equals(status)) {" + NL + "\t\t\t\t\t\t\t\t\tstatus = \"end\";" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_125 = NL + NL + "\t\t\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_126 = NL + "\t\t\t\t((java.util.Map)threadLocal.get()).put(\"status\", \"failure\");" + NL + "\t\t\t\t";
  protected final String TEXT_127 = NL + "\t\t\t\tstatus = \"failure\";" + NL + "\t\t\t\t";
  protected final String TEXT_128 = NL + "\t\t\t\t";
  protected final String TEXT_129 = "_onSubJobError(exception, errorComponent, globalMap);" + NL + "" + NL + "\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_130 = NL + "\t\t\tpublic void ";
  protected final String TEXT_131 = "_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {";
  protected final String TEXT_132 = NL + NL + "resumeUtil.addLog(\"SYSTEM_LOG\", \"NODE:\"+ errorComponent, \"\", Thread.currentThread().getId()+ \"\", \"";
  protected final String TEXT_133 = "\", \"\", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),\"\");" + NL;
  protected final String TEXT_134 = NL + "\t\t\t\ttry {" + NL + "\t\t\t\t\t";
  protected final String TEXT_135 = NL + "\t\t\t\t\t\tif(this.execStat){" + NL + "\t\t\t\t    \t\trunStat.updateStatOnConnection(\"";
  protected final String TEXT_136 = "\", 0, \"error\");" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t";
  protected final String TEXT_137 = NL + "\t\t\t\t\t((java.util.Map)threadLocal.get()).put(\"errorCode\", null);" + NL + "\t\t\t\t\t";
  protected final String TEXT_138 = "Process(globalMap);" + NL + "\t\t\t\t\tif ( !\"failure\".equals(((java.util.Map)threadLocal.get()).get(\"status\")) ) {" + NL + "\t\t\t\t\t\t((java.util.Map)threadLocal.get()).put(\"status\", \"end\");" + NL + "\t\t\t\t\t}";
  protected final String TEXT_139 = NL + "\t\t\t\t\terrorCode = null;" + NL + "\t\t\t\t\t";
  protected final String TEXT_140 = "Process(globalMap);" + NL + "\t\t\t\t\tif (!\"failure\".equals(status)) {" + NL + "\t\t\t\t\t\tstatus = \"end\";" + NL + "\t\t\t\t\t}";
  protected final String TEXT_141 = NL + "\t\t\t\t} catch (Exception e) {" + NL + "\t\t\t\t\te.printStackTrace();" + NL + "\t\t\t\t}";
  protected final String TEXT_142 = NL + "\t\t\t}";
  protected final String TEXT_143 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	Vector v = (Vector) codeGenArgument.getArgument();
	IProcess process = (IProcess)v.get(0);
	String version = (String)v.get(1);
	String exportAsOSGI = (String)v.get(2);

	List< ? extends INode> processNodes = (List< ? extends INode>)process.getGeneratingNodes();
	boolean stats = codeGenArgument.isStatistics();
	boolean trace = codeGenArgument.isTrace();
	boolean isRunInMultiThread = codeGenArgument.getIsRunInMultiThread();
	List<IContextParameter> params = new ArrayList<IContextParameter>();
	params=process.getContextManager().getDefaultContext().getContextParameterList();

    
IBrandingService service=(IBrandingService)GlobalServiceRegister.getDefault().getService(IBrandingService.class);
if(service instanceof AbstractBrandingService){

    stringBuffer.append(TEXT_1);
    stringBuffer.append(((AbstractBrandingService) service).getJobLicenseHeader(version));
    
}
	String jobFolderName = JavaResourcesHelper.getJobFolderName(process.getName(), process.getVersion());
	String packageName = codeGenArgument.getCurrentProjectName().toLowerCase() + "." + jobFolderName;

    stringBuffer.append(TEXT_2);
    stringBuffer.append( packageName );
    stringBuffer.append(TEXT_3);
    for (String routine : CodeGeneratorRoutine.getRequiredRoutineName(process)) {
	if(!routine.equals(ITalendSynchronizer.TEMPLATE)){
    stringBuffer.append(TEXT_4);
    stringBuffer.append(routine);
    stringBuffer.append(TEXT_5);
    	}
}
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(ElementParameterParser.getValue(process, "__HEADER_IMPORT__") );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(ElementParameterParser.getValue(process, "__FOOTER_IMPORT__") );
    stringBuffer.append(TEXT_9);
    
	List<INode> nodesWithImport = process.getNodesWithImport();
	if(nodesWithImport != null) {
		for(INode node:nodesWithImport){

    stringBuffer.append(TEXT_10);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(ElementParameterParser.getValue(node, "__IMPORT__") );
    stringBuffer.append(TEXT_12);
    		}
	}

    stringBuffer.append(TEXT_13);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(ElementParameterParser.getValue(process, "__PURPOSE__") );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(ElementParameterParser.getValue(process, "__DESCRIPTION__") );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(ElementParameterParser.getValue(process, "__AUTHOR__") );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(version );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(ElementParameterParser.getValue(process, "__STATUS__") );
    stringBuffer.append(TEXT_19);
    
String talendJobInterfaces = "TalendJob";

boolean talendMdmJob = !process.getNodesOfType("tMDMTriggerInput").isEmpty() || !process.getNodesOfType("tMDMTriggerOutput").isEmpty();
boolean talendEsbJob = !process.getNodesOfType("tESBProviderRequest").isEmpty() || !process.getNodesOfType("tESBConsumer").isEmpty();
boolean talendEsbJobFactory = !process.getNodesOfType("tESBProviderRequest").isEmpty();

if (talendMdmJob) {
	talendJobInterfaces += ", TalendMDMJob"; // Talend MDM job
}
if (talendEsbJob) {
	talendJobInterfaces += ", TalendESBJob"; // Talend ESB job
}
if (talendEsbJobFactory) {
	talendJobInterfaces += ", TalendESBJobFactory"; // Talend ESB provider job
}

    stringBuffer.append(TEXT_20);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_21);
    stringBuffer.append(talendJobInterfaces);
    stringBuffer.append(TEXT_22);
     if (talendEsbJobFactory) { 
    stringBuffer.append(TEXT_23);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_24);
    stringBuffer.append(process.getName());
    stringBuffer.append(TEXT_25);
     } 
    stringBuffer.append(TEXT_26);
    
if(isRunInMultiThread){

    stringBuffer.append(TEXT_27);
    
}

    stringBuffer.append(TEXT_28);
    //it will be use in job setting.
    stringBuffer.append(TEXT_29);
    //uft-8 is for temp file, for example: tSortRow, tMap. Because they need keep reversibility.
    stringBuffer.append(TEXT_30);
     for (IContextParameter ctxParam :params){
				String cParaName = ctxParam.getName();
			
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_32);
    if(ctxParam.getType().equals("id_Date")){
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(ctxParam.getValue() );
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
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_48);
    }else{
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cParaName );
    stringBuffer.append(TEXT_51);
    }
    stringBuffer.append(TEXT_52);
     } 
    stringBuffer.append(TEXT_53);
    
		for (IContextParameter ctxParam :params)
		{
				if(ctxParam.getType().equals("id_List Of Value") || ctxParam.getType().equals("id_File") || ctxParam.getType().equals("id_Directory"))
				{
		
    stringBuffer.append(TEXT_54);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_55);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_56);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_57);
    
				}else
				{

    stringBuffer.append(TEXT_58);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_59);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(JavaTypesManager.getTypeToGenerate(ctxParam.getType(),true));
    stringBuffer.append(TEXT_61);
    stringBuffer.append(Character.toUpperCase(ctxParam.getName().charAt(0)) + ctxParam.getName().substring(1));
    stringBuffer.append(TEXT_62);
    stringBuffer.append(ctxParam.getName());
    stringBuffer.append(TEXT_63);
    				}
		}

    stringBuffer.append(TEXT_64);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(codeGenArgument.getJobName() );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(codeGenArgument.getCurrentProjectName() );
    stringBuffer.append(TEXT_67);
    
	if(!isRunInMultiThread ){

    stringBuffer.append(TEXT_68);
    
	} else {

    stringBuffer.append(TEXT_69);
     } 
    stringBuffer.append(TEXT_70);
    
	if (stats) {

    stringBuffer.append(TEXT_71);
    
	}

    
	if (trace) {

    stringBuffer.append(TEXT_72);
    
	}

    stringBuffer.append(TEXT_73);
    stringBuffer.append(exportAsOSGI);
    stringBuffer.append(TEXT_74);
    
	for (INode logCatcher : process.getNodesOfType("tLogCatcher")) {

    stringBuffer.append(TEXT_75);
    stringBuffer.append(logCatcher.getUniqueName() );
    stringBuffer.append(TEXT_76);
    
	}

	for (INode statCatcher : process.getNodesOfType("tStatCatcher")) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(statCatcher.getUniqueName() );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(process.getId() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_80);
    
	}

	for (INode metterCatcher : process.getNodesOfType("tFlowMeterCatcher")) {

    stringBuffer.append(TEXT_81);
    stringBuffer.append(metterCatcher.getUniqueName() );
    stringBuffer.append(TEXT_82);
    stringBuffer.append(process.getId() );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(process.getVersion() );
    stringBuffer.append(TEXT_84);
    
	}

	for (INode assertCatcher : process.getNodesOfType("tAssertCatcher")) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(assertCatcher.getUniqueName() );
    stringBuffer.append(TEXT_86);
    
	}

    stringBuffer.append(TEXT_87);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(process.getName() );
    stringBuffer.append(TEXT_89);
    
		if (process.getNodesOfType("tLogCatcher").size() > 0) {
			List<INode> logCatchers = (List<INode>)process.getNodesOfType("tLogCatcher");
			for (INode logCatcher : logCatchers) {
				if (ElementParameterParser.getValue(logCatcher, "__CATCH_JAVA_EXCEPTION__").equals("true")) {
					// 1) add the message to the stack

    stringBuffer.append(TEXT_90);
    stringBuffer.append(logCatcher.getUniqueName() );
    stringBuffer.append(TEXT_91);
    
				}
			}

			INode virtualNCatchNode = null;
			boolean hasRealCatchNode = false;
			for (INode logCatcher : logCatchers) {
				if (ElementParameterParser.getValue(logCatcher, "__CATCH_JAVA_EXCEPTION__").equals("true")) {
					if(logCatcher.isVirtualGenerateNode()){
						virtualNCatchNode = logCatcher;
					}else{
						hasRealCatchNode = true;
					}
				}
			}
			if(hasRealCatchNode && virtualNCatchNode!=null){

    stringBuffer.append(TEXT_92);
    
			}
			for (INode logCatcher : logCatchers) {
				if (ElementParameterParser.getValue(logCatcher, "__CATCH_JAVA_EXCEPTION__").equals("true")) {
					if(logCatcher!=virtualNCatchNode){
					// 2) launch logCatcher subProcess

    stringBuffer.append(TEXT_93);
    stringBuffer.append(logCatcher.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_94);
    
					}
				}
			}
			if(hasRealCatchNode && virtualNCatchNode!=null){

    stringBuffer.append(TEXT_95);
    
			}
			if(virtualNCatchNode!=null){

    stringBuffer.append(TEXT_96);
    stringBuffer.append(virtualNCatchNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_97);
    
			}
			if(hasRealCatchNode && virtualNCatchNode!=null){

    stringBuffer.append(TEXT_98);
    
			}
		}

    stringBuffer.append(TEXT_99);
    
		boolean needCatchTalendException = false;
		if (process.getNodesOfType("tLogCatcher").size() > 0) {
			for(INode node:process.getNodesOfType("tLogCatcher")){
				if(ElementParameterParser.getValue(node, "__CATCH_JAVA_EXCEPTION__").equals("true")){
					needCatchTalendException = true;
					break;
				}
			}
		}

		if ((!needCatchTalendException) && (process.getNodesOfType("tAssertCatcher").size() > 0)) {
			for(INode node:process.getNodesOfType("tAssertCatcher")){
				if(ElementParameterParser.getValue(node, "__CATCH_JAVA_EXCEPTION__").equals("true")){
					needCatchTalendException = true;
					break;
				}
			}
		}
		if(needCatchTalendException) {
			if (process.getNodesOfType("tLogCatcher").size() > 0) {
				
    stringBuffer.append(TEXT_100);
    
			}
		}
		
    stringBuffer.append(TEXT_101);
    
		if (isRunInMultiThread ) {
		
    stringBuffer.append(TEXT_102);
    
		 } else {
    stringBuffer.append(TEXT_103);
    
		 }
		 
    stringBuffer.append(TEXT_104);
     // Methods for RUN IF Error links 
    
	for (INode node : processNodes) {
		if (node.isActivate()) {
			
    stringBuffer.append(TEXT_105);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_107);
    
				boolean ifBeforRunError = NodeUtil.checkComponentErrorConnectionAfterNode(node);
				if(!ifBeforRunError) {
					if (process.getNodesOfType("tAssertCatcher").size() > 0) {
						List<INode> assertCatchers = (List<INode>)process.getNodesOfType("tAssertCatcher");
						for (INode assertCatcher : assertCatchers) {
							if (ElementParameterParser.getValue(assertCatcher, "__CATCH_JAVA_EXCEPTION__").equals("true")) {
								// 1) add the message to the stack
								
    stringBuffer.append(TEXT_108);
    stringBuffer.append(assertCatcher.getUniqueName());
    stringBuffer.append(TEXT_109);
    stringBuffer.append(assertCatcher.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_110);
    
							}
						}
					}
				}
				if (!node.getComponent().getName().equals("tDie")) {
					String statCatcher = ElementParameterParser.getValue(node,"__TSTATCATCHER_STATS__");
					if (statCatcher.compareTo("true")==0) {
						for (INode statCatcherNode : node.getProcess().getNodesOfType("tStatCatcher")) {
							
    stringBuffer.append(TEXT_111);
    stringBuffer.append(statCatcherNode.getUniqueName() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(statCatcherNode.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_116);
    
						}
					}
				}
				boolean isExistOnCompErrorLink = false;
				List< ? extends IConnection> conns = node.getOutgoingConnections();
				for (IConnection conn : conns) {
					if (conn.getLineStyle().equals(EConnectionType.ON_COMPONENT_ERROR)) {
						isExistOnCompErrorLink = true;
						
    stringBuffer.append(TEXT_117);
    if (stats) {
    stringBuffer.append(TEXT_118);
    stringBuffer.append(conn.getUniqueName() );
    stringBuffer.append(TEXT_119);
    }
    stringBuffer.append(TEXT_120);
    
							if (isRunInMultiThread ) {
								
    stringBuffer.append(TEXT_121);
    stringBuffer.append(conn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_122);
    
							} else {
								
    stringBuffer.append(TEXT_123);
    stringBuffer.append(conn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_124);
    
							}
							
    stringBuffer.append(TEXT_125);
    
					}
				}
				boolean isSubjobHasOnSubJobError = false;
				if (!isExistOnCompErrorLink) {
					INode subJobStartNode =	node.getDesignSubjobStartNode();
					if (subJobStartNode != null) {
						List< ? extends IConnection> tempConns = subJobStartNode.getOutgoingConnections();
						for (IConnection conn : tempConns) {
							if (conn.getLineStyle().equals(EConnectionType.ON_SUBJOB_ERROR)) {
								isSubjobHasOnSubJobError = true;
								break;
							}
						}
					}
				}

				if (!isSubjobHasOnSubJobError && !isExistOnCompErrorLink) { // when there is no subjoberror and no onComponentError
					if (isRunInMultiThread ) {
				
    stringBuffer.append(TEXT_126);
    
					} else {
				
    stringBuffer.append(TEXT_127);
    
					}
				}
				// when use parallelize will add virtual components(tAsyncIn and tAsyncOut) but in graphical these is visable=false
				if ("true".equals(ElementParameterParser.getValue(node, "__PARALLELIZE__"))) {
					for (INode gNode :node.getProcess().getGeneratingNodes()) {
						if (gNode.getUniqueName().equals(node.getUniqueName())) {
							if (gNode.getIncomingConnections(EConnectionType.FLOW_MAIN).size()!= 0) {
								INode gSourceNode = gNode.getIncomingConnections(EConnectionType.FLOW_MAIN).get(0).getSource();
								node = gSourceNode;
							}
						}
					}
				}
				//end
				
    stringBuffer.append(TEXT_128);
    stringBuffer.append(node.getDesignSubjobStartNode().getUniqueName() );
    stringBuffer.append(TEXT_129);
    
		}
	}
	for (INode node : processNodes) {
		if (node.isDesignSubjobStartNode()) {

    stringBuffer.append(TEXT_130);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_131);
    
			List< ? extends IConnection> conns = node.getOutgoingConnections();
			int count = 0;
			for (IConnection conn : conns) {
				if (conn.getLineStyle().equals(EConnectionType.ON_SUBJOB_ERROR)) {
					count++;
				}
			}

			String label = "ERROR";

			if(count == 0){//FATAL
				label = "FATAL";
			}else{//ERROR------>RunSubJobError
				label = "ERROR";
			}

    stringBuffer.append(TEXT_132);
    stringBuffer.append(label );
    stringBuffer.append(TEXT_133);
    
			for (IConnection conn : conns) {
				if (conn.getLineStyle().equals(EConnectionType.ON_SUBJOB_ERROR)) {

    stringBuffer.append(TEXT_134);
    if (stats) {
    stringBuffer.append(TEXT_135);
    stringBuffer.append(conn.getUniqueName() );
    stringBuffer.append(TEXT_136);
    }
    
					if(isRunInMultiThread ){

    stringBuffer.append(TEXT_137);
    stringBuffer.append(conn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_138);
    
					} else {

    stringBuffer.append(TEXT_139);
    stringBuffer.append(conn.getTarget().getUniqueName() );
    stringBuffer.append(TEXT_140);
    
					}

    stringBuffer.append(TEXT_141);
    
				}
			}

    stringBuffer.append(TEXT_142);
    
		}
	}

    stringBuffer.append(TEXT_143);
    return stringBuffer.toString();
  }
}
