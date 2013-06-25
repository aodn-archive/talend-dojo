package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.Map;

public class TPivotToColumnsDelimitedEndJava
{
  protected static String nl;
  public static synchronized TPivotToColumnsDelimitedEndJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TPivotToColumnsDelimitedEndJava result = new TPivotToColumnsDelimitedEndJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "  ////////////////////////////////  Delimited  /////////  ";
  protected final String TEXT_4 = NL + "    out";
  protected final String TEXT_5 = ".write(\"";
  protected final String TEXT_6 = "\");" + NL + "    " + NL + "    out";
  protected final String TEXT_7 = ".write(";
  protected final String TEXT_8 = ");";
  protected final String TEXT_9 = NL + "    " + NL + "\tfor(int i = 0; i < pivot_Keys";
  protected final String TEXT_10 = ".size(); i++) {" + NL + "\t\tout";
  protected final String TEXT_11 = ".write(pivot_Keys";
  protected final String TEXT_12 = ".get(i));" + NL + "\t\tif(i == pivot_Keys";
  protected final String TEXT_13 = ".size()-1) {" + NL + "\t\t\tbreak;" + NL + "\t\t}" + NL + "\t\tout";
  protected final String TEXT_14 = ".write(";
  protected final String TEXT_15 = ");" + NL + "\t}" + NL + "    " + NL + "    out";
  protected final String TEXT_16 = ".write(";
  protected final String TEXT_17 = ");" + NL + "" + NL + "    for(int i = 0;i<group_Keys";
  protected final String TEXT_18 = ".size();i++){" + NL + "        " + NL + "        for(int j = 0; j < group_Keys";
  protected final String TEXT_19 = ".get(i).size(); j++) {" + NL + "\t\t\tout";
  protected final String TEXT_20 = ".write(group_Keys";
  protected final String TEXT_21 = ".get(i).get(j));" + NL + "\t\t\tout";
  protected final String TEXT_22 = ".write(";
  protected final String TEXT_23 = ");" + NL + "\t\t}" + NL + "        " + NL + "        java.util.List<String> aggOut";
  protected final String TEXT_24 = " = aggregation";
  protected final String TEXT_25 = ".get(group_Keys";
  protected final String TEXT_26 = ".get(i));" + NL + "" + NL + "        int gap";
  protected final String TEXT_27 = " = aggOut";
  protected final String TEXT_28 = ".size() - pivot_Keys";
  protected final String TEXT_29 = ".size();" + NL + "        " + NL + "        if(gap";
  protected final String TEXT_30 = " < 0){" + NL + "        " + NL + "        \tfor(int k=0;k<-gap";
  protected final String TEXT_31 = ";k++)" + NL + "\t\t\t\taggOut";
  protected final String TEXT_32 = ".add(\"\");" + NL + "\t" + NL + "        }" + NL + "" + NL + "\t\tfor(int j = 0; j < aggOut";
  protected final String TEXT_33 = ".size(); j++) {" + NL + "\t\t\tout";
  protected final String TEXT_34 = ".write(aggOut";
  protected final String TEXT_35 = ".get(j));" + NL + "\t\t\tif(j == aggOut";
  protected final String TEXT_36 = ".size()-1) {" + NL + "\t\t\t\tbreak;" + NL + "\t\t\t}" + NL + "\t\t\tout";
  protected final String TEXT_37 = ".write(";
  protected final String TEXT_38 = ");" + NL + "\t\t}" + NL + "        " + NL + "        out";
  protected final String TEXT_39 = ".write(";
  protected final String TEXT_40 = ");" + NL + "" + NL + "    }" + NL + "" + NL + "    out";
  protected final String TEXT_41 = ".flush();" + NL + "    " + NL + "    out";
  protected final String TEXT_42 = ".close();" + NL + "    " + NL;
  protected final String TEXT_43 = "  ////////////////////////////////   CSV    /////////    " + NL + "" + NL + "    int rowSize";
  protected final String TEXT_44 = " = pivot_Keys";
  protected final String TEXT_45 = ".size() + ";
  protected final String TEXT_46 = ";" + NL + "    " + NL + "    String[] finalStr";
  protected final String TEXT_47 = " = new String[rowSize";
  protected final String TEXT_48 = "];" + NL;
  protected final String TEXT_49 = NL + "    " + NL + "    finalStr";
  protected final String TEXT_50 = "[";
  protected final String TEXT_51 = "] = \"";
  protected final String TEXT_52 = "\";" + NL;
  protected final String TEXT_53 = NL + NL + "    for (int i=0; i<pivot_Keys";
  protected final String TEXT_54 = ".size(); i++) {" + NL + "" + NL + "        finalStr";
  protected final String TEXT_55 = "[i+";
  protected final String TEXT_56 = "] = pivot_Keys";
  protected final String TEXT_57 = ".get(i);" + NL + "" + NL + "   }  " + NL + "    " + NL + "    " + NL + "    CsvWriter";
  protected final String TEXT_58 = ".writeNext(finalStr";
  protected final String TEXT_59 = ");" + NL + "    " + NL + "    CsvWriter";
  protected final String TEXT_60 = ".flush();" + NL + "" + NL + "    for(int i = 0;i<group_Keys";
  protected final String TEXT_61 = ".size();i++){" + NL + "        " + NL + "        finalStr";
  protected final String TEXT_62 = " = new String[rowSize";
  protected final String TEXT_63 = "];" + NL + "" + NL + "        java.util.List<String> gkSplit";
  protected final String TEXT_64 = " = group_Keys";
  protected final String TEXT_65 = ".get(i);" + NL + "        ";
  protected final String TEXT_66 = NL + "        " + NL + "        finalStr";
  protected final String TEXT_67 = "[";
  protected final String TEXT_68 = "] = gkSplit";
  protected final String TEXT_69 = ".get(";
  protected final String TEXT_70 = ");" + NL;
  protected final String TEXT_71 = NL + "        " + NL + "        java.util.List<String> aggOut";
  protected final String TEXT_72 = " = aggregation";
  protected final String TEXT_73 = ".get(gkSplit";
  protected final String TEXT_74 = ");" + NL + "" + NL + "  for (int j=0; j<aggOut";
  protected final String TEXT_75 = ".size(); j++) {" + NL + "" + NL + "        finalStr";
  protected final String TEXT_76 = "[j+";
  protected final String TEXT_77 = "] =  aggOut";
  protected final String TEXT_78 = ".get(j);" + NL + "" + NL + "  } " + NL + "        " + NL + "        CsvWriter";
  protected final String TEXT_79 = ".writeNext(finalStr";
  protected final String TEXT_80 = ");" + NL + "        " + NL + "        CsvWriter";
  protected final String TEXT_81 = ".flush();" + NL + "" + NL + "    }" + NL + "    " + NL + "    \tCsvWriter";
  protected final String TEXT_82 = ".close();" + NL;
  protected final String TEXT_83 = NL + NL + "globalMap.put(\"";
  protected final String TEXT_84 = "_NB_LINE\",nb_line_";
  protected final String TEXT_85 = ");" + NL;
  protected final String TEXT_86 = NL + "\tif(nb_line_";
  protected final String TEXT_87 = " == 0){" + NL + "\t\tnew java.io.File(";
  protected final String TEXT_88 = ").delete();" + NL + "\t}\t\t";
  protected final String TEXT_89 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

String filename = ElementParameterParser.getValue(node,"__FILENAME__");
boolean isDeleteEmptyFile = ("true").equals(ElementParameterParser.getValue(node, "__DELETE_EMPTYFILE__"));
	
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas!=null)&&(metadatas.size()>0)) {
    IMetadataTable metadata = metadatas.get(0);
    if (metadata!=null) {
        
        List<Map<String, String>> groupbys = 
            ( List<Map<String,String>>)ElementParameterParser.getObjectValue(node, "__GROUPBYS__");

        boolean csvOption = ("true").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"));
        
        String pivotColumn = ElementParameterParser.getValue(node, "__PIVOT_COLUMN__");

        String aggColumn = ElementParameterParser.getValue(node, "__AGGREGATION_COLUMN__");
        
        String aggFunction = ElementParameterParser.getValue(node, "__AGGREGATION_FUNCTION__");
        
        String rowSeparator = ElementParameterParser.getValue(node,"__ROWSEPARATOR__");
        
        String fieldSeparator = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
        

    stringBuffer.append(TEXT_2);
     if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) { 
    stringBuffer.append(TEXT_3);
      for (int i=0; i<groupbys.size(); i++) {
        
        Map<String, String> groupby = groupbys.get(i);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(groupby.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_8);
    
       }  

    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(rowSeparator);
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
    stringBuffer.append(fieldSeparator);
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
    stringBuffer.append(fieldSeparator);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    stringBuffer.append(rowSeparator);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    }else{
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(groupbys.size());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
      for (int i=0; i<groupbys.size(); i++) {
        
        Map<String, String> groupby = groupbys.get(i);

    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_51);
    stringBuffer.append(groupby.get("INPUT_COLUMN"));
    stringBuffer.append(TEXT_52);
    
       }  

    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(groupbys.size());
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
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
      for (int i=0; i<groupbys.size(); i++) {
            
        Map<String, String> groupby = groupbys.get(i);

    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_70);
      }  
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    stringBuffer.append(groupbys.size());
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
    
        }
    }
}

    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    if(isDeleteEmptyFile){
    stringBuffer.append(TEXT_86);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_87);
    stringBuffer.append(filename );
    stringBuffer.append(TEXT_88);
    }
    stringBuffer.append(TEXT_89);
    return stringBuffer.toString();
  }
}
