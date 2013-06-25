package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFTPPutBeginJava
{
  protected static String nl;
  public static synchronized TFTPPutBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPPutBeginJava result = new TFTPPutBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "  java.util.Properties props_";
  protected final String TEXT_2 = " = System.getProperties();" + NL + "  props_";
  protected final String TEXT_3 = ".put(\"socksProxyPort\", ";
  protected final String TEXT_4 = ");" + NL + "  props_";
  protected final String TEXT_5 = ".put(\"socksProxyHost\", ";
  protected final String TEXT_6 = ");" + NL + "  props_";
  protected final String TEXT_7 = ".put(\"java.net.socks.username\", ";
  protected final String TEXT_8 = ");" + NL + "  props_";
  protected final String TEXT_9 = ".put(\"java.net.socks.password\", ";
  protected final String TEXT_10 = ");        ";
  protected final String TEXT_11 = NL + "int nb_file_";
  protected final String TEXT_12 = " = 0;" + NL;
  protected final String TEXT_13 = NL + NL + "  class MyProgressMonitor_";
  protected final String TEXT_14 = " implements com.jcraft.jsch.SftpProgressMonitor {" + NL + "    public void init(int op, String src, String dest, long max) {}" + NL + "    public boolean count(long count) { return true;}" + NL + "    public void end() {}" + NL + "  }" + NL;
  protected final String TEXT_15 = NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_16 = " = (com.jcraft.jsch.ChannelSftp)globalMap.get(\"";
  protected final String TEXT_17 = "\");" + NL + "    if(c_";
  protected final String TEXT_18 = ".getHome()!=null && !c_";
  protected final String TEXT_19 = ".getHome().equals(c_";
  protected final String TEXT_20 = ".pwd())){" + NL + "  \t\tc_";
  protected final String TEXT_21 = ".cd(c_";
  protected final String TEXT_22 = ".getHome());" + NL + "  \t}";
  protected final String TEXT_23 = "    " + NL + "    class MyUserInfo_";
  protected final String TEXT_24 = " implements com.jcraft.jsch.UserInfo, com.jcraft.jsch.UIKeyboardInteractive {" + NL + "      String passphrase_";
  protected final String TEXT_25 = " = ";
  protected final String TEXT_26 = ";" + NL + "      public String getPassphrase() { return passphrase_";
  protected final String TEXT_27 = "; }" + NL + "      public String getPassword() { return null; } " + NL + "      public boolean promptPassword(String arg0) { return true; } " + NL + "      public boolean promptPassphrase(String arg0) { return true; } " + NL + "      public boolean promptYesNo(String arg0) { return true; } " + NL + "      public void showMessage(String arg0) { } " + NL + "      " + NL + "      public String[] promptKeyboardInteractive(String destination, String name, String instruction, String[] prompt," + NL + "        boolean[] echo) {" + NL + "        String[] password_";
  protected final String TEXT_28 = " = {";
  protected final String TEXT_29 = "};" + NL + "        return password_";
  protected final String TEXT_30 = ";" + NL + "      }" + NL + "    };" + NL + "    final com.jcraft.jsch.UserInfo defaultUserInfo_";
  protected final String TEXT_31 = " = new MyUserInfo_";
  protected final String TEXT_32 = "();" + NL + "    com.jcraft.jsch.JSch jsch_";
  protected final String TEXT_33 = "=new com.jcraft.jsch.JSch(); " + NL;
  protected final String TEXT_34 = NL + "      jsch_";
  protected final String TEXT_35 = ".addIdentity(";
  protected final String TEXT_36 = ", defaultUserInfo_";
  protected final String TEXT_37 = ".getPassphrase());";
  protected final String TEXT_38 = NL + "    com.jcraft.jsch.Session session_";
  protected final String TEXT_39 = "=jsch_";
  protected final String TEXT_40 = ".getSession(";
  protected final String TEXT_41 = ", ";
  protected final String TEXT_42 = ", ";
  protected final String TEXT_43 = ");" + NL;
  protected final String TEXT_44 = " " + NL + "      session_";
  protected final String TEXT_45 = ".setPassword(";
  protected final String TEXT_46 = "); ";
  protected final String TEXT_47 = NL + "    session_";
  protected final String TEXT_48 = ".setUserInfo(defaultUserInfo_";
  protected final String TEXT_49 = "); " + NL + "\t";
  protected final String TEXT_50 = NL + "  \tif((\"true\").equals(System.getProperty(\"http.proxySet\")) ){" + NL + "  \t\tcom.jcraft.jsch.ProxyHTTP proxy_";
  protected final String TEXT_51 = " = new com.jcraft.jsch.ProxyHTTP(System.getProperty(\"http.proxyHost\"),Integer.parseInt(System.getProperty(\"http.proxyPort\")));" + NL + "  \t\tif(!\"\".equals(System.getProperty(\"http.proxyUser\"))){" + NL + "  \t\t\tproxy_";
  protected final String TEXT_52 = ".setUserPasswd(System.getProperty(\"http.proxyUser\"),System.getProperty(\"http.proxyPassword\"));" + NL + "  \t\t}" + NL + "  \t\tsession_";
  protected final String TEXT_53 = ".setProxy(proxy_";
  protected final String TEXT_54 = ");" + NL + "  \t}" + NL + "\t";
  protected final String TEXT_55 = NL + "    session_";
  protected final String TEXT_56 = ".connect();" + NL + "    com.jcraft.jsch. Channel channel_";
  protected final String TEXT_57 = "=session_";
  protected final String TEXT_58 = ".openChannel(\"sftp\");" + NL + "    channel_";
  protected final String TEXT_59 = ".connect();" + NL + "    com.jcraft.jsch.ChannelSftp c_";
  protected final String TEXT_60 = "=(com.jcraft.jsch.ChannelSftp)channel_";
  protected final String TEXT_61 = ";" + NL + "    c_";
  protected final String TEXT_62 = ".setFilenameEncoding(";
  protected final String TEXT_63 = ");";
  protected final String TEXT_64 = NL + "  // becasue there is not the same method in JSch class as FTPClient class, define a list here" + NL + "  java.util.List<String> msg_";
  protected final String TEXT_65 = " = new java.util.ArrayList<String>();" + NL + "  com.jcraft.jsch.SftpProgressMonitor monitor";
  protected final String TEXT_66 = " = new MyProgressMonitor_";
  protected final String TEXT_67 = "();" + NL + "  java.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_68 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL + "  ";
  protected final String TEXT_69 = NL + "    java.util.Map<String,String> map";
  protected final String TEXT_70 = " = new java.util.HashMap<String,String>();" + NL + "    map";
  protected final String TEXT_71 = ".put(";
  protected final String TEXT_72 = ", ";
  protected final String TEXT_73 = ");    " + NL + "    list";
  protected final String TEXT_74 = ".add(map";
  protected final String TEXT_75 = ");       ";
  protected final String TEXT_76 = "  " + NL + "  String localdir";
  protected final String TEXT_77 = " = ";
  protected final String TEXT_78 = ";" + NL + "  for (java.util.Map<String, String> map";
  protected final String TEXT_79 = " : list";
  protected final String TEXT_80 = ") {" + NL;
  protected final String TEXT_81 = NL + "  com.enterprisedt.net.ftp.FTPClient ftp_";
  protected final String TEXT_82 = " =null;" + NL;
  protected final String TEXT_83 = NL + "    ftp_";
  protected final String TEXT_84 = " = (com.enterprisedt.net.ftp.FTPClient)globalMap.get(\"";
  protected final String TEXT_85 = "\");";
  protected final String TEXT_86 = "    " + NL + "    ftp_";
  protected final String TEXT_87 = " = new com.enterprisedt.net.ftp.FTPClient();" + NL + "    ftp_";
  protected final String TEXT_88 = ".setRemoteHost(";
  protected final String TEXT_89 = ");" + NL + "    ftp_";
  protected final String TEXT_90 = ".setRemotePort(";
  protected final String TEXT_91 = ");" + NL;
  protected final String TEXT_92 = NL + "      ftp_";
  protected final String TEXT_93 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.ACTIVE);";
  protected final String TEXT_94 = NL + "      ftp_";
  protected final String TEXT_95 = ".setConnectMode(com.enterprisedt.net.ftp.FTPConnectMode.PASV);";
  protected final String TEXT_96 = NL + "    ftp_";
  protected final String TEXT_97 = ".setControlEncoding(";
  protected final String TEXT_98 = ");" + NL + "    ftp_";
  protected final String TEXT_99 = ".connect();  " + NL + "    ftp_";
  protected final String TEXT_100 = ".login(";
  protected final String TEXT_101 = ", ";
  protected final String TEXT_102 = "); ";
  protected final String TEXT_103 = "  " + NL + "" + NL + "  // msg_";
  protected final String TEXT_104 = " likes a String[] to save the message from transfer.  " + NL + "  com.enterprisedt.net.ftp.TransferCompleteStrings msg_";
  protected final String TEXT_105 = " = ftp_";
  protected final String TEXT_106 = ".getTransferCompleteMessages();" + NL + "  msg_";
  protected final String TEXT_107 = ".clearAll();" + NL + "  java.util.List<java.util.Map<String,String>> list";
  protected final String TEXT_108 = " = new java.util.ArrayList<java.util.Map<String,String>>();" + NL;
  protected final String TEXT_109 = "    " + NL + "    java.util.Map<String,String> map";
  protected final String TEXT_110 = " = new java.util.HashMap<String,String>();" + NL + "    map";
  protected final String TEXT_111 = ".put(";
  protected final String TEXT_112 = ",";
  protected final String TEXT_113 = ");  " + NL + "    list";
  protected final String TEXT_114 = ".add(map";
  protected final String TEXT_115 = ");       ";
  protected final String TEXT_116 = "  " + NL + "  String remotedir";
  protected final String TEXT_117 = " = ";
  protected final String TEXT_118 = ";" + NL + "  ftp_";
  protected final String TEXT_119 = ".chdir(remotedir";
  protected final String TEXT_120 = ");" + NL;
  protected final String TEXT_121 = "  " + NL + "    ftp_";
  protected final String TEXT_122 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.BINARY);";
  protected final String TEXT_123 = "  " + NL + "    ftp_";
  protected final String TEXT_124 = ".setType(com.enterprisedt.net.ftp.FTPTransferType.ASCII);";
  protected final String TEXT_125 = NL + "  String localdir";
  protected final String TEXT_126 = "  = ";
  protected final String TEXT_127 = ";" + NL + "" + NL + "  for (java.util.Map<String, String> map";
  protected final String TEXT_128 = " : list";
  protected final String TEXT_129 = ") {";
  protected final String TEXT_130 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();  
String cid = node.getUniqueName();
String host = ElementParameterParser.getValue(node, "__HOST__");
String port = ElementParameterParser.getValue(node, "__PORT__");
String user = ElementParameterParser.getValue(node, "__USERNAME__");
String pass = ElementParameterParser.getValue(node, "__PASSWORD__");
String localdir = ElementParameterParser.getValue(node, "__LOCALDIR__");  
String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
String encoding = ElementParameterParser.getValue(node, "__ENCODING__");
String authMethod = ElementParameterParser.getValue(node, "__AUTH_METHOD__");
String privateKey = ElementParameterParser.getValue(node, "__PRIVATEKEY__");
String passPhrase = ElementParameterParser.getValue(node, "__PASSPHRASE__");
List<Map<String, String>> files = (List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__FILES__");  
boolean useProxy = ("true").equals(ElementParameterParser.getValue(node, "__USE_PROXY__"));
String proxyHost = ElementParameterParser.getValue(node, "__PROXY_HOST__");
String proxyPort = ElementParameterParser.getValue(node, "__PROXY_PORT__");
String proxyUser = ElementParameterParser.getValue(node, "__PROXY_USERNAME__");
String proxyPassword = ElementParameterParser.getValue(node, "__PROXY_PASSWORD__");  
String connectMode = ElementParameterParser.getValue(node, "__CONNECT_MODE__");
String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
boolean sftp = false;

if (("true").equals(useExistingConn)) {
  List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();

  for (INode n : nodeList) {
    if (n.getUniqueName().equals(connection)) {
      sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
    }
  }
} else {
  sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
}  

//The following part support the socks proxy for FTP and SFTP (Socks V4 or V5, they are all OK). 
//And it can not work with the FTP proxy directly, only support the socks proxy.
if (useProxy) {

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(proxyPort );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(proxyHost );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(proxyUser );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(proxyPassword );
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    if (sftp) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    if (("true").equals(useExistingConn)) {
    String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(conn );
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
    } else {
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(passPhrase );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    if (("PUBLICKEY").equals(authMethod)) {
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(privateKey );
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    }
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(user);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_43);
    if (("PASSWORD").equals(authMethod)) {
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(pass);
    stringBuffer.append(TEXT_46);
    }
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    if (!useProxy) {
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    }
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_62);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_63);
    }
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
  for (int i = 0; i < files.size(); i++) {
    Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_71);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_72);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_75);
    
  }
  
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    } else {
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_82);
    
  if (("true").equals(useExistingConn)) {
    String conn= "conn_" + connection;
    
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(conn );
    stringBuffer.append(TEXT_85);
    } else {
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(host );
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(port );
    stringBuffer.append(TEXT_91);
    if (("ACTIVE").equals(connectMode)) {
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_93);
    } else {
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    }
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_97);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(user );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(pass );
    stringBuffer.append(TEXT_102);
    }
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    
  for (int i = 0; i < files.size(); i++) {
    Map<String, String> line = files.get(i);
    
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_111);
    stringBuffer.append( line.get("FILEMASK") );
    stringBuffer.append(TEXT_112);
    stringBuffer.append( line.get("NEWNAME") );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(i );
    stringBuffer.append(TEXT_115);
    
  }
  
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(remotedir);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    if ("binary".equalsIgnoreCase(ElementParameterParser.getValue(node, "__MODE__"))) {
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    } else { 
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    }
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    stringBuffer.append(localdir);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_129);
    }
    stringBuffer.append(TEXT_130);
    return stringBuffer.toString();
  }
}
