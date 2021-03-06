package org.talend.designer.codegen.translators.internet.ftp;

import org.talend.core.model.process.INode;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TFTPDeleteMainJava
{
  protected static String nl;
  public static synchronized TFTPDeleteMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFTPDeleteMainJava result = new TFTPDeleteMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "try{";
  protected final String TEXT_3 = NL + NL + "   globalMap.put(\"";
  protected final String TEXT_4 = "_CURRENT_STATUS\", \"No file deleted.\");" + NL + "   java.util.Set<String> keySet";
  protected final String TEXT_5 = " = map";
  protected final String TEXT_6 = ".keySet(); " + NL + "   for (String key";
  protected final String TEXT_7 = " : keySet";
  protected final String TEXT_8 = ")" + NL + "   {     " + NL + "    \tString filemask";
  protected final String TEXT_9 = " = key";
  protected final String TEXT_10 = "; " + NL + "    \tString dir";
  protected final String TEXT_11 = " = null;" + NL + "    \tString mask";
  protected final String TEXT_12 = " = filemask";
  protected final String TEXT_13 = ".replaceAll(\"\\\\\\\\\", \"/\") ;" + NL + "    \tint i";
  protected final String TEXT_14 = " = mask";
  protected final String TEXT_15 = ".lastIndexOf('/');" + NL + "\t\tif (i";
  protected final String TEXT_16 = "!=-1)" + NL + "\t\t{" + NL + "\t\t\tdir";
  protected final String TEXT_17 = " = mask";
  protected final String TEXT_18 = ".substring(0, i";
  protected final String TEXT_19 = "); " + NL + "\t\t\tmask";
  protected final String TEXT_20 = " = mask";
  protected final String TEXT_21 = ".substring(i";
  protected final String TEXT_22 = "+1); " + NL + "    \t}";
  protected final String TEXT_23 = " " + NL + "    \tmask";
  protected final String TEXT_24 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask";
  protected final String TEXT_25 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "\t\tjava.util.Vector listings";
  protected final String TEXT_26 = " = c_";
  protected final String TEXT_27 = ".ls(";
  protected final String TEXT_28 = ");" + NL + "\t\tfor (int m";
  protected final String TEXT_29 = " = 0; m";
  protected final String TEXT_30 = " < listings";
  protected final String TEXT_31 = ".size(); m";
  protected final String TEXT_32 = "++)" + NL + "\t\t{ " + NL + "\t\t\tString filePath";
  protected final String TEXT_33 = " =  ((com.jcraft.jsch.ChannelSftp.LsEntry) listings";
  protected final String TEXT_34 = ".elementAt(m";
  protected final String TEXT_35 = ")).getFilename() ;" + NL + "\t\t\tif ( filePath";
  protected final String TEXT_36 = ".matches(mask";
  protected final String TEXT_37 = "))" + NL + "\t\t\t{" + NL + "\t\t\ttry {";
  protected final String TEXT_38 = "\t\t\t" + NL + "\t\t\t\t \tc_";
  protected final String TEXT_39 = ".rm((";
  protected final String TEXT_40 = ")+\"/\"+ filePath";
  protected final String TEXT_41 = ");";
  protected final String TEXT_42 = NL + "\t\t\t\t \tc_";
  protected final String TEXT_43 = ".rmdir((";
  protected final String TEXT_44 = ")+\"/\"+ filePath";
  protected final String TEXT_45 = ");";
  protected final String TEXT_46 = NL + "\t\t\t\t globalMap.put(\"";
  protected final String TEXT_47 = "_CURRENT_STATUS\", \"File deleted.\");" + NL + "\t\t\t\t } catch (com.jcraft.jsch.SftpException e_";
  protected final String TEXT_48 = ") {" + NL + "                       globalMap.put(\"";
  protected final String TEXT_49 = "_CURRENT_STATUS\", \"Deleting file action error\");" + NL + "                       throw e_";
  protected final String TEXT_50 = ";" + NL + "                 }" + NL + "\t\t\t\t nb_file_";
  protected final String TEXT_51 = "++;" + NL + "\t\t\t}" + NL + "\t\t}\t     " + NL + "   \t}  " + NL + "" + NL + "" + NL + "   " + NL + "    ";
  protected final String TEXT_52 = NL + NL + "\tglobalMap.put(\"";
  protected final String TEXT_53 = "_CURRENT_STATUS\", \"No file deleted.\");" + NL + "    java.util.Set<String> keySet";
  protected final String TEXT_54 = " = map";
  protected final String TEXT_55 = ".keySet(); " + NL + "    try {" + NL + "   for (String key";
  protected final String TEXT_56 = " : keySet";
  protected final String TEXT_57 = ")" + NL + "   {     " + NL + "    \tString filemask";
  protected final String TEXT_58 = " = key";
  protected final String TEXT_59 = "; " + NL + "    \tString dir";
  protected final String TEXT_60 = " = null;" + NL + "    \tString mask";
  protected final String TEXT_61 = " = filemask";
  protected final String TEXT_62 = ".replaceAll(\"\\\\\\\\\", \"/\") ;" + NL + "    \tint i";
  protected final String TEXT_63 = " = mask";
  protected final String TEXT_64 = ".lastIndexOf('/');" + NL + "\t\tif (i";
  protected final String TEXT_65 = "!=-1)" + NL + "\t\t{" + NL + "\t\t\tdir";
  protected final String TEXT_66 = " = mask";
  protected final String TEXT_67 = ".substring(0, i";
  protected final String TEXT_68 = "); " + NL + "\t\t\tmask";
  protected final String TEXT_69 = " = mask";
  protected final String TEXT_70 = ".substring(i";
  protected final String TEXT_71 = "+1); " + NL + "    \t}" + NL + "    \tif (dir";
  protected final String TEXT_72 = "!=null && !\"\".equals(dir";
  protected final String TEXT_73 = ")) ftp_";
  protected final String TEXT_74 = ".chdir(dir";
  protected final String TEXT_75 = ");" + NL + "    \tmask";
  protected final String TEXT_76 = " = org.apache.oro.text.GlobCompiler.globToPerl5(mask";
  protected final String TEXT_77 = ".toCharArray(), org.apache.oro.text.GlobCompiler.DEFAULT_MASK);" + NL + "    \tString[] fileName_";
  protected final String TEXT_78 = " = null;" + NL + "    \tboolean dirFailed_";
  protected final String TEXT_79 = " = false;" + NL + "    \ttry{" + NL + "    \t\tfileName_";
  protected final String TEXT_80 = " = ftp_";
  protected final String TEXT_81 = ".dir(null,false);" + NL + "    \t}catch(com.enterprisedt.net.ftp.FTPException e_";
  protected final String TEXT_82 = "){" + NL + "    \t\tdirFailed_";
  protected final String TEXT_83 = " = true;" + NL + "    \t}" + NL + "    \tif((fileName_";
  protected final String TEXT_84 = " == null) || dirFailed_";
  protected final String TEXT_85 = " || (fileName_";
  protected final String TEXT_86 = ".length <= 0)){" + NL + "\t\t\tcom.enterprisedt.net.ftp.FTPFile[] fileList_";
  protected final String TEXT_87 = " = ftp_";
  protected final String TEXT_88 = ".dirDetails(null);" + NL + "\t\t\tfileName_";
  protected final String TEXT_89 = " = new String[fileList_";
  protected final String TEXT_90 = ".length];" + NL + "\t\t\tfor (int i_";
  protected final String TEXT_91 = " = 0 ; i_";
  protected final String TEXT_92 = " < fileList_";
  protected final String TEXT_93 = ".length ; i_";
  protected final String TEXT_94 = "++){" + NL + "\t\t\t\tfileName_";
  protected final String TEXT_95 = "[i_";
  protected final String TEXT_96 = "] = fileList_";
  protected final String TEXT_97 = "[i_";
  protected final String TEXT_98 = "].getName();" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "\t\tfor (String file_";
  protected final String TEXT_99 = " : fileName_";
  protected final String TEXT_100 = ")" + NL + "\t\t{  " + NL + "\t\t\tif (file_";
  protected final String TEXT_101 = ".matches(mask";
  protected final String TEXT_102 = "))" + NL + "\t\t\t{";
  protected final String TEXT_103 = "\t\t\t\t" + NL + "\t\t\t\t\tftp_";
  protected final String TEXT_104 = ".delete(file_";
  protected final String TEXT_105 = ");";
  protected final String TEXT_106 = "\t\t\t\t\t" + NL + "\t\t\t\t\tftp_";
  protected final String TEXT_107 = ".rmdir(file_";
  protected final String TEXT_108 = ");";
  protected final String TEXT_109 = "\t\t\t\t\t" + NL + "\t\t\t\tglobalMap.put(\"";
  protected final String TEXT_110 = "_CURRENT_STATUS\", \"File deleted.\");" + NL + "\t\t\t\tnb_file_";
  protected final String TEXT_111 = "++;" + NL + "\t\t\t}" + NL + "\t\t}" + NL + "   \t}" + NL + "   \t}catch(com.enterprisedt.net.ftp.FTPException e_";
  protected final String TEXT_112 = "){" + NL + "   \t\tglobalMap.put(\"";
  protected final String TEXT_113 = "_CURRENT_STATUS\", \"Deleting file action error\");" + NL + "   \t\tthrow e_";
  protected final String TEXT_114 = ";" + NL + "   \t}" + NL + "   ftp_";
  protected final String TEXT_115 = ".chdir(root";
  protected final String TEXT_116 = ");";
  protected final String TEXT_117 = NL + " \t}catch(Exception e_";
  protected final String TEXT_118 = "){";
  protected final String TEXT_119 = NL + "            throw(e_";
  protected final String TEXT_120 = ");";
  protected final String TEXT_121 = NL + "\t\t\tSystem.err.print(e_";
  protected final String TEXT_122 = ".getMessage());";
  protected final String TEXT_123 = NL + "\t}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	String dieOnError = ElementParameterParser.getValue(node, "__DIE_ON_ERROR__");
	String remotedir = ElementParameterParser.getValue(node, "__REMOTEDIR__");
	String targetType = ElementParameterParser.getValue(node, "__TARGET_TYPE__");
	String connection = ElementParameterParser.getValue(node, "__CONNECTION__");
	String useExistingConn = ElementParameterParser.getValue(node, "__USE_EXISTING_CONNECTION__");
	boolean sftp = false;
	if(("true").equals(useExistingConn)){
		List<? extends INode> nodeList = node.getProcess().getGeneratingNodes();
		for(INode n : nodeList){
			if(n.getUniqueName().equals(connection)){
				sftp = ("true").equals(ElementParameterParser.getValue(n, "__SFTP__"));
			}
		}
	}else{
		sftp = ("true").equals(ElementParameterParser.getValue(node, "__SFTP__"));
	}

    stringBuffer.append(TEXT_2);
    
	if(sftp){

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    
		//bug TDI-19189 make regex to match the file name with Regular Expressions  

    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_37);
    
				if("FILE".equals(targetType)){

    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    
				}else{

    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(remotedir );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    
				}

    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    }else{
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    
				if("FILE".equals(targetType)){

    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    
				}else{

    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    
				}

    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_116);
    }
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_118);
    
        if(("true").equals(dieOnError)){

    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_120);
    
		}else{

    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
    
		}

    stringBuffer.append(TEXT_123);
    return stringBuffer.toString();
  }
}
