package org.talend.designer.codegen.translators.internet;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TSocketOutputBeginJava
{
  protected static String nl;
  public static synchronized TSocketOutputBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSocketOutputBeginJava result = new TSocketOutputBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = "    ";
  protected final String TEXT_3 = NL + "class Compress{" + NL + "    public byte[] zip(byte[] data) throws java.io.IOException {" + NL + "        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();" + NL + "        java.util.zip.ZipEntry ze = new java.util.zip.ZipEntry(\"servletservice\");" + NL + "        java.util.zip.ZipOutputStream zos = new java.util.zip.ZipOutputStream(baos);" + NL + "        zos.putNextEntry(ze);" + NL + "        zos.write(data, 0, data.length);" + NL + "        zos.close();" + NL + "        byte[] zipBytes = baos.toByteArray();" + NL + "        return zipBytes;" + NL + "    }" + NL + "   " + NL + "}" + NL + "Compress com";
  protected final String TEXT_4 = " = new Compress();";
  protected final String TEXT_5 = NL + NL + "java.net.Socket socket";
  protected final String TEXT_6 = " = null;" + NL + "int nb_line_";
  protected final String TEXT_7 = " = 0;" + NL + "boolean retry";
  protected final String TEXT_8 = " = true;" + NL + "" + NL + "for(int i=0;i<";
  protected final String TEXT_9 = "-1;i++){" + NL + "    if(retry";
  protected final String TEXT_10 = "){" + NL + "        try{" + NL + "            socket";
  protected final String TEXT_11 = " = new java.net.Socket(";
  protected final String TEXT_12 = ",";
  protected final String TEXT_13 = ");" + NL + "            retry";
  protected final String TEXT_14 = " = false;" + NL + "        }catch(java.net.ConnectException e";
  protected final String TEXT_15 = "){" + NL + "            Thread.sleep(";
  protected final String TEXT_16 = ");" + NL + "        }" + NL + "    }" + NL + "}" + NL + "    " + NL + "String lineSeparator_";
  protected final String TEXT_17 = " = (String) java.security.AccessController.doPrivileged(" + NL + "\tnew sun.security.action.GetPropertyAction(\"line.separator\"));" + NL + "char quotechar_";
  protected final String TEXT_18 = " = '";
  protected final String TEXT_19 = "';" + NL + "char escape_";
  protected final String TEXT_20 = " = '\\\\';" + NL + "\t";
  protected final String TEXT_21 = NL + "\tlineSeparator_";
  protected final String TEXT_22 = " = \"";
  protected final String TEXT_23 = "\";";
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "\tescape_";
  protected final String TEXT_26 = " = quotechar_";
  protected final String TEXT_27 = ";";
  protected final String TEXT_28 = NL + NL + "com.talend.csv.CSVWriter CsvWriter";
  protected final String TEXT_29 = " = " + NL + "   new com.talend.csv.CSVWriter(" + NL + "      new java.io.BufferedWriter(new java.io.OutputStreamWriter(socket";
  protected final String TEXT_30 = ".getOutputStream(),";
  protected final String TEXT_31 = ")), '";
  protected final String TEXT_32 = "',quotechar_";
  protected final String TEXT_33 = ",escape_";
  protected final String TEXT_34 = ",lineSeparator_";
  protected final String TEXT_35 = ");  ";
  protected final String TEXT_36 = NL;

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
        String delim1 = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
        String delim = delim1.substring(1,delim1.length()-1);
        String port = ElementParameterParser.getValue(node,"__PORT__");
        String host = ElementParameterParser.getValue(node,"__HOST__");
        String retry = ElementParameterParser.getValue(node,"__RETRY__");
        String timeout = ElementParameterParser.getValue(node,"__TIMEOUT__");
        boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
        boolean dieOnError = ("true").equals(ElementParameterParser.getValue(node,"__DIE_ON_ERROR__"));
        
        String rowSeparator1 = ElementParameterParser.getValue(node, "__ROWSEPARATOR__");
        String rowSeparator = rowSeparator1.substring(1,rowSeparator1.length()-1);
        
        String escapeChar1 = ElementParameterParser.getValue(node, "__ESCAPE_CHAR__");
        String escapeChar = escapeChar1.substring(1,escapeChar1.length()-1);
        String textEnclosure1 = ElementParameterParser.getValue(node, "__TEXT_ENCLOSURE__");
        String textEnclosure = textEnclosure1.substring(1,textEnclosure1.length()-1);
        if ("".equals(textEnclosure)) textEnclosure = "\0";
        
        

    stringBuffer.append(TEXT_2);
     if(compress){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(retry);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(host);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(port);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(timeout);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(textEnclosure );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    if(!("\\n").equals(rowSeparator) && !("\\r").equals(rowSeparator)){
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_23);
    }
    stringBuffer.append(TEXT_24);
    if(("\\\\").equals(escapeChar)){

}else if(escapeChar.equals(textEnclosure)){
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    }
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_30);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_31);
    stringBuffer.append(delim);
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_35);
        	
	}
}

    stringBuffer.append(TEXT_36);
    return stringBuffer.toString();
  }
}
