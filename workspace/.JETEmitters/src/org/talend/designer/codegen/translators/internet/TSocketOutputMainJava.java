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

public class TSocketOutputMainJava
{
  protected static String nl;
  public static synchronized TSocketOutputMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TSocketOutputMainJava result = new TSocketOutputMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = "      " + NL + "                    String[] row";
  protected final String TEXT_4 = "=new String[";
  protected final String TEXT_5 = "];      ";
  protected final String TEXT_6 = NL + "                            row";
  protected final String TEXT_7 = "[";
  protected final String TEXT_8 = "] =String.valueOf(";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = "); ";
  protected final String TEXT_11 = NL + "                            if(";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = " == null){" + NL + "                                row";
  protected final String TEXT_14 = "[";
  protected final String TEXT_15 = "]=\"\";" + NL + "                            }else{";
  protected final String TEXT_16 = NL + "                                    row";
  protected final String TEXT_17 = "[";
  protected final String TEXT_18 = "] = ";
  protected final String TEXT_19 = ".";
  protected final String TEXT_20 = ";";
  protected final String TEXT_21 = NL + "                                    row";
  protected final String TEXT_22 = "[";
  protected final String TEXT_23 = "] = FormatterUtils.format_Date(";
  protected final String TEXT_24 = ".";
  protected final String TEXT_25 = ", ";
  protected final String TEXT_26 = ");";
  protected final String TEXT_27 = NL + "                                    row";
  protected final String TEXT_28 = "[";
  protected final String TEXT_29 = "] = java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_30 = ".";
  protected final String TEXT_31 = ")).toString();";
  protected final String TEXT_32 = NL + "                                    row";
  protected final String TEXT_33 = "[";
  protected final String TEXT_34 = "] = String.valueOf(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "                            }";
  protected final String TEXT_38 = NL + "                       //encoding" + NL + "                        for(int i =0;i<row";
  protected final String TEXT_39 = ".length;i++){" + NL + "                            row";
  protected final String TEXT_40 = "[i]=new sun.misc.BASE64Encoder().encode(com";
  protected final String TEXT_41 = ".zip(row";
  protected final String TEXT_42 = "[i].getBytes(";
  protected final String TEXT_43 = ")));//encodeing!!!!!!!!!!!!!!!!!!!" + NL + "                        }";
  protected final String TEXT_44 = "    " + NL + "                        CsvWriter";
  protected final String TEXT_45 = ".writeNext(row";
  protected final String TEXT_46 = "); " + NL + "                        CsvWriter";
  protected final String TEXT_47 = ".flush();                " + NL + "" + NL + "                    nb_line_";
  protected final String TEXT_48 = "++;";
  protected final String TEXT_49 = "            ";
  protected final String TEXT_50 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
    CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
    INode node = (INode)codeGenArgument.getArgument();
    String cid = node.getUniqueName();  

    stringBuffer.append(TEXT_2);
    
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {                                    
        String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
        boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
        
        List< ? extends IConnection> conns = node.getIncomingConnections();
        if(conns!=null){
            if (conns.size()>0){
                IConnection conn =conns.get(0);
                if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                List<IMetadataColumn> columns = metadata.getListColumns();
                    int sizeColumns = columns.size();

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_5);
    
                    for (int i = 0; i < sizeColumns; i++) {
                        IMetadataColumn column = columns.get(i);
                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                        String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                        if(JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable())){
                            
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_10);
    
                        }else { 
                            
    stringBuffer.append(TEXT_11);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_15);
                      
                                if(javaType == JavaTypesManager.STRING ){
                                    
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_20);
    
                                }else if(javaType == JavaTypesManager.DATE && pattern != null){
                                    
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_24);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_25);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_26);
    
                                }else if(javaType == JavaTypesManager.BYTE_ARRAY){
                                    
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_30);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_31);
    
                                }else{
                                    
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_36);
    
                                }
                                
    stringBuffer.append(TEXT_37);
                  
                        }
                    } 

                        
     if(compress){
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_43);
     } 
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_48);
              
                }
            
            }
        }   
    
    }

}

    stringBuffer.append(TEXT_49);
    stringBuffer.append(TEXT_50);
    return stringBuffer.toString();
  }
}
