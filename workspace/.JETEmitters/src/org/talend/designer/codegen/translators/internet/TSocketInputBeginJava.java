package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;
import java.util.List;
import java.util.Map;

public class TSocketInputBeginJava
{
  protected static String nl;
  public static synchronized TSocketInputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSocketInputBeginJava result = new TSocketInputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "      ";
  protected final String TEXT_3 = NL + "class Compress{" + NL + "    public byte[] unzip(byte[] zipBytes) throws java.io.IOException {" + NL + "        java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(zipBytes);" + NL + "        java.util.zip.ZipInputStream zis = new java.util.zip.ZipInputStream(bais);" + NL + "        zis.getNextEntry();" + NL + "        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();" + NL + "        final int BUFSIZ = 8192;" + NL + "        byte inbuf[] = new byte[BUFSIZ];" + NL + "        int n;" + NL + "        while ((n = zis.read(inbuf, 0, BUFSIZ)) != -1) {" + NL + "            baos.write(inbuf, 0, n);" + NL + "        }" + NL + "        byte[] data = baos.toByteArray();" + NL + "        zis.close();" + NL + "        return data;" + NL + "    } " + NL + "}" + NL + "Compress com";
  protected final String TEXT_4 = " = new Compress();";
  protected final String TEXT_5 = NL + NL + "int nb_line_";
  protected final String TEXT_6 = "=0;" + NL + "" + NL + "java.net.ServerSocket ss";
  protected final String TEXT_7 = ";" + NL + "java.net.Socket socket";
  protected final String TEXT_8 = "=null;" + NL + "java.io.BufferedReader in";
  protected final String TEXT_9 = ";" + NL + "java.io.PrintWriter out";
  protected final String TEXT_10 = ";" + NL;
  protected final String TEXT_11 = NL + "ss";
  protected final String TEXT_12 = " = new java.net.ServerSocket(";
  protected final String TEXT_13 = ", 0, java.net.InetAddress.getByName(";
  protected final String TEXT_14 = "));";
  protected final String TEXT_15 = NL + "ss";
  protected final String TEXT_16 = " = new java.net.ServerSocket(";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = NL + "    ss";
  protected final String TEXT_20 = ".setSoTimeout(";
  protected final String TEXT_21 = ");";
  protected final String TEXT_22 = NL + "boolean done";
  protected final String TEXT_23 = " = true;" + NL + "while (done";
  protected final String TEXT_24 = ") {" + NL + "\ttry{" + NL + "\t" + NL + "   \t  socket";
  protected final String TEXT_25 = " = ss";
  protected final String TEXT_26 = ".accept();" + NL + "" + NL + "      System.out.println(\"socket connected\");" + NL + "      " + NL + "      String rowSeparator_";
  protected final String TEXT_27 = " = \"\\n\";" + NL + "      char quotechar_";
  protected final String TEXT_28 = " = '";
  protected final String TEXT_29 = "';" + NL + "      char escape_";
  protected final String TEXT_30 = " = '\\\\';" + NL + "      ";
  protected final String TEXT_31 = NL + "      rowSeparator_";
  protected final String TEXT_32 = " = \"";
  protected final String TEXT_33 = "\";";
  protected final String TEXT_34 = NL + "    ";
  protected final String TEXT_35 = NL + "    ";
  protected final String TEXT_36 = NL + "      escape_";
  protected final String TEXT_37 = " = quotechar_";
  protected final String TEXT_38 = ";";
  protected final String TEXT_39 = NL + "    " + NL + "    //READ DATA" + NL + "    com.talend.csv.CSVReader csvReader";
  protected final String TEXT_40 = " =" + NL + "          new com.talend.csv.CSVReader(socket";
  protected final String TEXT_41 = ".getInputStream(),";
  protected final String TEXT_42 = ",rowSeparator_";
  protected final String TEXT_43 = ",'";
  protected final String TEXT_44 = "'" + NL + "          ,quotechar_";
  protected final String TEXT_45 = ",escape_";
  protected final String TEXT_46 = ",true,0);" + NL + "    " + NL + "    String[] row";
  protected final String TEXT_47 = "=null;   " + NL + "    while ((row";
  protected final String TEXT_48 = " = csvReader";
  protected final String TEXT_49 = ".readNext())!=null) {         ";
  protected final String TEXT_50 = NL + "        //decoding" + NL + "        for(int i =0;i<row";
  protected final String TEXT_51 = ".length;i++){" + NL + "           row";
  protected final String TEXT_52 = "[i] = new String(com";
  protected final String TEXT_53 = ".unzip(new sun.misc.BASE64Decoder().decodeBuffer(row";
  protected final String TEXT_54 = "[i])), ";
  protected final String TEXT_55 = ");           " + NL + "        }";
  protected final String TEXT_56 = "   " + NL + "        if(row";
  protected final String TEXT_57 = ".length == 1 && (\"\\015\").equals(row";
  protected final String TEXT_58 = "[0])){//empty line when row separator is '\\n'" + NL + "            continue;" + NL + "        }" + NL + "                                                                 ";
  protected final String TEXT_59 = NL + "        ";
  protected final String TEXT_60 = " = null;            ";
  protected final String TEXT_61 = NL + "        boolean whetherReject_";
  protected final String TEXT_62 = " = false;";
  protected final String TEXT_63 = NL + "        ";
  protected final String TEXT_64 = " = new ";
  protected final String TEXT_65 = "Struct();" + NL + "        try {           ";
  protected final String TEXT_66 = "                          " + NL + "        if(row";
  protected final String TEXT_67 = ".length == 1 && (\"\\015\").equals(row";
  protected final String TEXT_68 = "[0])){//empty line when row separator is '\\n'           ";
  protected final String TEXT_69 = NL + "            ";
  protected final String TEXT_70 = ".";
  protected final String TEXT_71 = " = ";
  protected final String TEXT_72 = ";           ";
  protected final String TEXT_73 = "           " + NL + "        }else{      ";
  protected final String TEXT_74 = "                         " + NL + "            if(";
  protected final String TEXT_75 = " < row";
  protected final String TEXT_76 = ".length){              ";
  protected final String TEXT_77 = NL + "                ";
  protected final String TEXT_78 = ".";
  protected final String TEXT_79 = " = row";
  protected final String TEXT_80 = "[";
  protected final String TEXT_81 = "];";
  protected final String TEXT_82 = NL + "                    if(row";
  protected final String TEXT_83 = "[";
  protected final String TEXT_84 = "].length() > 0) {";
  protected final String TEXT_85 = NL + "                            ";
  protected final String TEXT_86 = ".";
  protected final String TEXT_87 = " = ParserUtils.parseTo_Date(row";
  protected final String TEXT_88 = "[";
  protected final String TEXT_89 = "], ";
  protected final String TEXT_90 = ");";
  protected final String TEXT_91 = "                          ";
  protected final String TEXT_92 = NL + "                            ";
  protected final String TEXT_93 = ".";
  protected final String TEXT_94 = " = row";
  protected final String TEXT_95 = "[";
  protected final String TEXT_96 = "].getBytes(";
  protected final String TEXT_97 = ");";
  protected final String TEXT_98 = NL + "                            ";
  protected final String TEXT_99 = ".";
  protected final String TEXT_100 = " = ParserUtils.parseTo_";
  protected final String TEXT_101 = "(row";
  protected final String TEXT_102 = "[";
  protected final String TEXT_103 = "]);";
  protected final String TEXT_104 = "                  " + NL + "                    }else{";
  protected final String TEXT_105 = NL + "                        ";
  protected final String TEXT_106 = ".";
  protected final String TEXT_107 = " = ";
  protected final String TEXT_108 = ";" + NL + "                    }";
  protected final String TEXT_109 = "                             " + NL + "            }else{                                      ";
  protected final String TEXT_110 = NL + "            ";
  protected final String TEXT_111 = ".";
  protected final String TEXT_112 = " = ";
  protected final String TEXT_113 = ";" + NL + "            }";
  protected final String TEXT_114 = NL + "        }" + NL + "        nb_line_";
  protected final String TEXT_115 = "++;" + NL + "} catch (Exception e) {" + NL + "    whetherReject_";
  protected final String TEXT_116 = " = true;";
  protected final String TEXT_117 = NL + "        throw(e);";
  protected final String TEXT_118 = NL + "                ";
  protected final String TEXT_119 = " = new ";
  protected final String TEXT_120 = "Struct();";
  protected final String TEXT_121 = NL + "                ";
  protected final String TEXT_122 = ".";
  protected final String TEXT_123 = " = ";
  protected final String TEXT_124 = ".";
  protected final String TEXT_125 = ";";
  protected final String TEXT_126 = NL + "            ";
  protected final String TEXT_127 = ".errorMessage = e.getMessage() + \" - Line: \" + tos_count_";
  protected final String TEXT_128 = ";";
  protected final String TEXT_129 = NL + "            ";
  protected final String TEXT_130 = " = null;";
  protected final String TEXT_131 = NL + "            System.err.print(e.getMessage());";
  protected final String TEXT_132 = NL + "            ";
  protected final String TEXT_133 = " = null;";
  protected final String TEXT_134 = NL + "}";
  protected final String TEXT_135 = "if(!whetherReject_";
  protected final String TEXT_136 = ") { ";
  protected final String TEXT_137 = "      " + NL + "         if(";
  protected final String TEXT_138 = " == null){ ";
  protected final String TEXT_139 = NL + "             ";
  protected final String TEXT_140 = " = new ";
  protected final String TEXT_141 = "Struct();" + NL + "         }              ";
  protected final String TEXT_142 = NL + "         ";
  protected final String TEXT_143 = ".";
  protected final String TEXT_144 = " = ";
  protected final String TEXT_145 = ".";
  protected final String TEXT_146 = ";                    ";
  protected final String TEXT_147 = " } ";
  protected final String TEXT_148 = "  ";
  protected final String TEXT_149 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();      

    stringBuffer.append(TEXT_1);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
        boolean bindHostname = ("true").equals(ElementParameterParser.getValue(node,"__BIND_HOSTNAME__"));
        String hostname = ElementParameterParser.getValue(node,"__SERVERHOSTNAME__");
        String port = ElementParameterParser.getValue(node,"__PORT__");
        boolean uncompress = ("true").equals(ElementParameterParser.getValue(node,"__UNCOMPRESS__"));
        boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
        
        String delim1 = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
        String fieldSeparator = delim1.substring(1,delim1.length()-1);
        if(("'").equals(fieldSeparator)) fieldSeparator = "\\'";
        
        String rowSeparator1 = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
        String rowSeparator = rowSeparator1.substring(1,rowSeparator1.length()-1);
        if(("'").equals(rowSeparator)) rowSeparator = "\\'";
        
        String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
        String escapeChar = escapeChar1.substring(1,escapeChar1.length()-1);
        if(("'").equals(escapeChar)) escapeChar = "\\'";
        
        String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
        String textEnclosure = textEnclosure1.substring(1,textEnclosure1.length()-1);
        if ("".equals(textEnclosure)) textEnclosure = "\0";
        if(("'").equals(textEnclosure)) textEnclosure = "\\'";
        
        String timeout = ElementParameterParser.getValue(node, "__TIMEOUT__");

    stringBuffer.append(TEXT_2);
     if(uncompress){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    if(bindHostname){
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(hostname );
    stringBuffer.append(TEXT_14);
    }else{
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_17);
    }
    stringBuffer.append(TEXT_18);
    if(!("").equals(timeout)){
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_21);
    }
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
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
          if(!("\\n").equals(rowSeparator) && !("\\r").equals(rowSeparator)){
    stringBuffer.append(TEXT_31);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(rowSeparator  );
    stringBuffer.append(TEXT_33);
           }
    stringBuffer.append(TEXT_34);
          if(("\\\\").equals(escapeChar)){
    stringBuffer.append(TEXT_35);
          }else if(escapeChar.equals(textEnclosure)){
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
          }
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_49);
     if(uncompress){
    stringBuffer.append(TEXT_50);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_55);
     } 
    stringBuffer.append(TEXT_56);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_58);
    
List< ? extends IConnection> conns = node.getOutgoingSortedConnections();
String rejectConnName = "";
List<? extends IConnection> rejectConns = node.getOutgoingConnections("REJECT");
if(rejectConns != null && rejectConns.size() > 0) {
    IConnection rejectConn = rejectConns.get(0);
    rejectConnName = rejectConn.getName();
}
List<IMetadataColumn> rejectColumnList = null;
IMetadataTable metadataTable = node.getMetadataFromConnector("REJECT");
if(metadataTable != null) {
    rejectColumnList = metadataTable.getListColumns();      
}
    if (conns!=null) {
        if (conns.size()>0) {
            for (int i=0;i<conns.size();i++) {
                IConnection connTemp = conns.get(i);
                if (connTemp.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {

    stringBuffer.append(TEXT_59);
    stringBuffer.append(connTemp.getName() );
    stringBuffer.append(TEXT_60);
    
                }
            }
        }
    }
    
String firstConnName = "";
if (conns!=null) {
    if (conns.size()>0) {
        IConnection conn = conns.get(0);
        firstConnName = conn.getName();       
        if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        
    stringBuffer.append(TEXT_61);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_65);
    
            List<IMetadataColumn> columns=metadata.getListColumns();
            int columnSize = columns.size();
            
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_68);
    
    for (IMetadataColumn column1: metadata.getListColumns()) {
    stringBuffer.append(TEXT_69);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(column1.getLabel() );
    stringBuffer.append(TEXT_71);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaIdType(column1.getTalendType(), column1.isNullable()));
    stringBuffer.append(TEXT_72);
          }
    stringBuffer.append(TEXT_73);
    
        for (int i=0;i<columnSize;i++) {
                IMetadataColumn column=columns.get(i);
                String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                String patternValue = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
        
    stringBuffer.append(TEXT_74);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_76);
    
                if(javaType == JavaTypesManager.STRING || javaType == JavaTypesManager.OBJECT) {

    stringBuffer.append(TEXT_77);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_78);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_79);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_80);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_81);
    
                } else {

    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_83);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_84);
    
                        if(javaType == JavaTypesManager.DATE) {

    stringBuffer.append(TEXT_85);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_88);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_89);
    stringBuffer.append( patternValue );
    stringBuffer.append(TEXT_90);
    
                        } else if(javaType == JavaTypesManager.BYTE_ARRAY){ 

    stringBuffer.append(TEXT_91);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_93);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_95);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_96);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_97);
    
                        } else {

    stringBuffer.append(TEXT_98);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_99);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_100);
    stringBuffer.append( typeToGenerate );
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_102);
    stringBuffer.append(i );
    stringBuffer.append(TEXT_103);
    
                        }

    stringBuffer.append(TEXT_104);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_106);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_107);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_108);
                      
                }
    stringBuffer.append(TEXT_109);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_112);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_113);
              }
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_116);
    
    if (dieOnError) {
        
    stringBuffer.append(TEXT_117);
    
    } else {
        if(!("").equals(rejectConnName)&&!rejectConnName.equals(firstConnName)&&rejectColumnList != null && rejectColumnList.size() > 0) {
        
    stringBuffer.append(TEXT_118);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_119);
    stringBuffer.append(rejectConnName );
    stringBuffer.append(TEXT_120);
    
            for(IMetadataColumn column : metadata.getListColumns()) {
                
    stringBuffer.append(TEXT_121);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_122);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_123);
    stringBuffer.append(firstConnName);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_125);
    
            }
            
    stringBuffer.append(TEXT_126);
    stringBuffer.append(rejectConnName);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(node.getUniqueName() );
    stringBuffer.append(TEXT_128);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_130);
    
        } else {
            
    stringBuffer.append(TEXT_131);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_133);
    
        }
    } 
    
    stringBuffer.append(TEXT_134);
              
        }
    }
    if (conns.size()>0) {   
        boolean isFirstEnter = true;
        for (int i=0;i<conns.size();i++) {
            IConnection conn = conns.get(i);
            if ((conn.getName().compareTo(firstConnName)!=0)&&(conn.getName().compareTo(rejectConnName)!=0)&&(conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA))) {

     if(isFirstEnter) {
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
     isFirstEnter = false; } 
    stringBuffer.append(TEXT_137);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_138);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_140);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_141);
    
                 for (IMetadataColumn column: metadata.getListColumns()) {

    stringBuffer.append(TEXT_142);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_143);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_144);
    stringBuffer.append(firstConnName );
    stringBuffer.append(TEXT_145);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_146);
    
                }
            }
        }

     if(!isFirstEnter) {
    stringBuffer.append(TEXT_147);
     } 
    stringBuffer.append(TEXT_148);
    
     }
    }
  }
}

    stringBuffer.append(TEXT_149);
    return stringBuffer.toString();
  }
}
