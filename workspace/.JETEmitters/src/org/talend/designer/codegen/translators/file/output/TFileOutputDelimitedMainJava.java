package org.talend.designer.codegen.translators.file.output;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.List;
import java.util.ArrayList;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.metadata.types.JavaType;

public class TFileOutputDelimitedMainJava
{
  protected static String nl;
  public static synchronized TFileOutputDelimitedMainJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TFileOutputDelimitedMainJava result = new TFileOutputDelimitedMainJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = NL + "    \t\t\t\tStringBuilder sb_";
  protected final String TEXT_4 = " = new StringBuilder();" + NL + "    \t\t        ";
  protected final String TEXT_5 = NL + "\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_6 = NL + "\t\t\t\tsynchronized (lockWrite) {" + NL + "\t\t        ";
  protected final String TEXT_7 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t";
  protected final String TEXT_8 = NL + "\t        \t\tif(isFirstCheckDyn_";
  protected final String TEXT_9 = " && (file_";
  protected final String TEXT_10 = ".length()==0)){" + NL + "\t                \t";
  protected final String TEXT_11 = NL + "    \t\t        if(isFirstCheckDyn_";
  protected final String TEXT_12 = " && file";
  protected final String TEXT_13 = ".length()==0){" + NL + "        \t\t        ";
  protected final String TEXT_14 = NL + "    \t\t        \tout";
  protected final String TEXT_15 = ".write(\"";
  protected final String TEXT_16 = "\");" + NL + "        \t\t         ";
  protected final String TEXT_17 = NL + "\t    \t\t        routines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_18 = ".";
  protected final String TEXT_19 = ", out";
  protected final String TEXT_20 = ", OUT_DELIM_";
  protected final String TEXT_21 = "); " + NL + "    \t    \t\t     ";
  protected final String TEXT_22 = NL + "                        out";
  protected final String TEXT_23 = ".write(OUT_DELIM_";
  protected final String TEXT_24 = ");" + NL + "        \t\t         ";
  protected final String TEXT_25 = NL + "                        out";
  protected final String TEXT_26 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_27 = ");" + NL + "                        isFirstCheckDyn_";
  protected final String TEXT_28 = " = false;" + NL + "    \t\t        }" + NL + "\t\t        ";
  protected final String TEXT_29 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_30 = NL + "\t\t\t\t} " + NL + "\t\t        ";
  protected final String TEXT_31 = NL + "\t\t\t\t}" + NL + "\t\t\t\t";
  protected final String TEXT_32 = NL + "    \t\t                    ";
  protected final String TEXT_33 = "   \t\t\t\t" + NL + "    \t    \t\t\t\tif(";
  protected final String TEXT_34 = ".";
  protected final String TEXT_35 = " != null) {" + NL + "        \t\t\t\t    ";
  protected final String TEXT_36 = NL + "    \t\t\t\t    routines.system.DynamicUtils.writeValuesToStringBuilder(";
  protected final String TEXT_37 = ".";
  protected final String TEXT_38 = ", sb_";
  protected final String TEXT_39 = ", OUT_DELIM_";
  protected final String TEXT_40 = ");" + NL + "    \t\t\t\t    ";
  protected final String TEXT_41 = NL + "    \t\t\t\t\tsb_";
  protected final String TEXT_42 = ".append(" + NL + "    \t\t\t        ";
  protected final String TEXT_43 = NL + "    \t\t\t\t\t\tFormatterUtils.format_Date(";
  protected final String TEXT_44 = ".";
  protected final String TEXT_45 = ", ";
  protected final String TEXT_46 = ")" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_47 = NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_48 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(";
  protected final String TEXT_49 = ".toPlainString(), ";
  protected final String TEXT_50 = ", ";
  protected final String TEXT_51 = ")\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_52 = NL + "        \t\t\t\t\t\t\tFormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_53 = ".";
  protected final String TEXT_54 = ")).toPlainString(), ";
  protected final String TEXT_55 = ", ";
  protected final String TEXT_56 = ")\t\t\t\t\t\t" + NL + "        \t\t\t\t\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_58 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_59 = ".toPlainString()" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_60 = NL + "    \t\t\t\t\t\tjava.nio.charset.Charset.forName(";
  protected final String TEXT_61 = ").decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_62 = ".";
  protected final String TEXT_63 = ")).toString()" + NL + "    \t\t\t\t\t\t";
  protected final String TEXT_64 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_65 = ".";
  protected final String TEXT_66 = NL + "    \t\t\t\t\t\t";
  protected final String TEXT_67 = NL + "    \t\t\t\t\t);" + NL + "    \t\t\t\t\t";
  protected final String TEXT_68 = NL + "    \t\t\t\t\t    } " + NL + "    \t\t\t\t\t";
  protected final String TEXT_69 = "\t\t\t\t\t" + NL + "    \t\t\t            sb_";
  protected final String TEXT_70 = ".append(OUT_DELIM_";
  protected final String TEXT_71 = ");" + NL + "    \t\t\t            ";
  protected final String TEXT_72 = NL + "    \t\t        sb_";
  protected final String TEXT_73 = ".append(OUT_DELIM_ROWSEP_";
  protected final String TEXT_74 = ");" + NL + "    \t\t" + NL + "    \t\t\t\t" + NL + "    \t\t\t\t";
  protected final String TEXT_75 = NL + "    \t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "    \t\t\t\t";
  protected final String TEXT_76 = NL + "    \t\t\t\tsynchronized (lockWrite) {" + NL + "    \t\t        ";
  protected final String TEXT_77 = NL + "\t\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t\t";
  protected final String TEXT_78 = NL + "    \t\t        nb_line_";
  protected final String TEXT_79 = "++;" + NL + "    \t\t        ";
  protected final String TEXT_80 = NL + "    \t\t            if(currentRow_";
  protected final String TEXT_81 = " % splitEvery_";
  protected final String TEXT_82 = "==0 && currentRow_";
  protected final String TEXT_83 = "!=0){" + NL + "    \t\t                splitedFileNo_";
  protected final String TEXT_84 = "++;" + NL + "    \t\t                out";
  protected final String TEXT_85 = ".close(); " + NL + "    \t\t                //close original outputStream" + NL + "    \t\t                out";
  protected final String TEXT_86 = " = new ";
  protected final String TEXT_87 = "(new java.io.OutputStreamWriter(" + NL + "    \t\t                        new java.io.FileOutputStream(fullName_";
  protected final String TEXT_88 = " + splitedFileNo_";
  protected final String TEXT_89 = " + extension_";
  protected final String TEXT_90 = ", ";
  protected final String TEXT_91 = "),";
  protected final String TEXT_92 = "));" + NL + "    \t\t                file";
  protected final String TEXT_93 = " = new java.io.File(fullName_";
  protected final String TEXT_94 = " + splitedFileNo_";
  protected final String TEXT_95 = " + extension_";
  protected final String TEXT_96 = ");  \t\t\t\t\t" + NL + "    " + NL + "    \t\t                ";
  protected final String TEXT_97 = NL + "    \t\t                    if(file";
  protected final String TEXT_98 = ".length()==0){  " + NL + "    \t\t                        ";
  protected final String TEXT_99 = NL + "    \t\t                            out";
  protected final String TEXT_100 = ".write(\"";
  protected final String TEXT_101 = "\");" + NL + "    \t\t                            ";
  protected final String TEXT_102 = NL + "\t    \t\t            \t\t\troutines.system.DynamicUtils.writeHeaderToDelimitedFile(";
  protected final String TEXT_103 = ".";
  protected final String TEXT_104 = ", out";
  protected final String TEXT_105 = ", OUT_DELIM_";
  protected final String TEXT_106 = "); " + NL + "\t    \t\t            \t\t\t";
  protected final String TEXT_107 = NL + "    \t\t                                out";
  protected final String TEXT_108 = ".write(OUT_DELIM_";
  protected final String TEXT_109 = ");" + NL + "    \t\t                                ";
  protected final String TEXT_110 = NL + "    \t\t                        out";
  protected final String TEXT_111 = ".write(OUT_DELIM_ROWSEP_";
  protected final String TEXT_112 = ");" + NL + "    \t\t                    }\t" + NL + "    \t\t                    ";
  protected final String TEXT_113 = NL + "    \t\t                out";
  protected final String TEXT_114 = ".write(sb_";
  protected final String TEXT_115 = ".toString());" + NL + "    \t\t                ";
  protected final String TEXT_116 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_117 = "%";
  protected final String TEXT_118 = " == 0) {" + NL + "        \t\t                out";
  protected final String TEXT_119 = ".flush();" + NL + "        \t\t                }" + NL + "    \t\t                    ";
  protected final String TEXT_120 = " \t\t\t" + NL + "    \t\t            }else{" + NL + "    \t\t                out";
  protected final String TEXT_121 = ".write(sb_";
  protected final String TEXT_122 = ".toString());" + NL + "    \t\t                ";
  protected final String TEXT_123 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_124 = "%";
  protected final String TEXT_125 = " == 0) {" + NL + "        \t\t                out";
  protected final String TEXT_126 = ".flush();" + NL + "        \t\t                }" + NL + "    \t\t                    ";
  protected final String TEXT_127 = "  \t\t\t" + NL + "    \t\t            }\t" + NL + "    \t\t            currentRow_";
  protected final String TEXT_128 = "++;\t\t\t\t" + NL + "    \t\t\t" + NL + "    " + NL + "    \t\t            ";
  protected final String TEXT_129 = NL + "    \t\t" + NL + "    \t\t            out";
  protected final String TEXT_130 = ".write(sb_";
  protected final String TEXT_131 = ".toString());" + NL + "    \t\t            ";
  protected final String TEXT_132 = NL + "        \t\t                if(nb_line_";
  protected final String TEXT_133 = "%";
  protected final String TEXT_134 = " == 0) {" + NL + "        \t\t                out";
  protected final String TEXT_135 = ".flush();" + NL + "        \t\t                }" + NL + "    \t\t                ";
  protected final String TEXT_136 = "     \t\t\t" + NL + "    \t\t            ";
  protected final String TEXT_137 = NL + "    \t\t        ";
  protected final String TEXT_138 = NL + "    \t\t\t\t} " + NL + "    \t\t        ";
  protected final String TEXT_139 = NL + "    \t\t\t\t} " + NL + "    \t\t        ";
  protected final String TEXT_140 = NL + "    \t\t\t\t}" + NL + "    \t\t\t\t";
  protected final String TEXT_141 = " \t\t\t" + NL + "    \t\t        " + NL + "    \t\t        ";
  protected final String TEXT_142 = NL;
  protected final String TEXT_143 = NL;
  protected final String TEXT_144 = NL + "\t\t\t\t\tsynchronized (multiThreadLockWrite) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_145 = NL + "\t\t\t\t\tsynchronized (lockWrite) {" + NL + "\t        \t\t\t\t";
  protected final String TEXT_146 = NL + "        \t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "        \t\t\tsynchronized (pLockWrite) {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_147 = NL + "        \t\t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_148 = " && (file_";
  protected final String TEXT_149 = ".length()==0)){" + NL + "        \t\t\t\t\theadColu";
  protected final String TEXT_150 = " = new String[";
  protected final String TEXT_151 = "-1+";
  protected final String TEXT_152 = ".";
  protected final String TEXT_153 = ".getColumnCount()];" + NL + "            \t\t\t\t";
  protected final String TEXT_154 = NL + "            \t\t\tif(isFirstCheckDyn_";
  protected final String TEXT_155 = " && file";
  protected final String TEXT_156 = ".length()==0){" + NL + "            \t\t\t\theadColu";
  protected final String TEXT_157 = " = new String[";
  protected final String TEXT_158 = "-1+";
  protected final String TEXT_159 = ".";
  protected final String TEXT_160 = ".getColumnCount()];" + NL + "            \t\t\t";
  protected final String TEXT_161 = NL + "        \t\t        \theadColu";
  protected final String TEXT_162 = "[";
  protected final String TEXT_163 = "]=\"";
  protected final String TEXT_164 = "\";" + NL + "            \t\t         ";
  protected final String TEXT_165 = NL + "        \t    \t\t     for(int mi=0;mi<";
  protected final String TEXT_166 = ".";
  protected final String TEXT_167 = ".getColumnCount();mi++){" + NL + "        \t    \t\t     \theadColu";
  protected final String TEXT_168 = "[";
  protected final String TEXT_169 = "+mi]=";
  protected final String TEXT_170 = ".";
  protected final String TEXT_171 = ".getColumnMetadata(mi).getName();" + NL + "        \t    \t\t     }" + NL + "        \t    \t\t     ";
  protected final String TEXT_172 = NL + "                            CsvWriter";
  protected final String TEXT_173 = ".writeNext(headColu";
  protected final String TEXT_174 = ");" + NL + "        \t            \tCsvWriter";
  protected final String TEXT_175 = ".flush();" + NL + "        \t            \t";
  protected final String TEXT_176 = NL + "        \t            \tout";
  protected final String TEXT_177 = ".write(strWriter";
  protected final String TEXT_178 = ".getBuffer().toString());" + NL + "        \t            \tout";
  protected final String TEXT_179 = ".flush();" + NL + "        \t            \tstrWriter";
  protected final String TEXT_180 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_181 = ".getBuffer().length()); \t" + NL + "                    \t\t";
  protected final String TEXT_182 = NL + "        \t            }" + NL + "            \t        ";
  protected final String TEXT_183 = NL + "\t\t\t\t\t} " + NL + "            \t        ";
  protected final String TEXT_184 = NL + "\t\t\t\t\t} " + NL + "            \t        ";
  protected final String TEXT_185 = NL + "\t\t\t\t\t}" + NL + "            \t\t\t";
  protected final String TEXT_186 = NL + "        \t            if(isFirstCheckDyn_";
  protected final String TEXT_187 = "){" + NL + "                    \t\tCsvWriter";
  protected final String TEXT_188 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_189 = ".getEscapeChar());" + NL + "            \t\t\t\tCsvWriter";
  protected final String TEXT_190 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_191 = ".getTextEnclosure());" + NL + "                    \t\tisFirstCheckDyn_";
  protected final String TEXT_192 = " = false;" + NL + "                    \t}";
  protected final String TEXT_193 = "  \t" + NL + "                    \tString[] row";
  protected final String TEXT_194 = "=new String[";
  protected final String TEXT_195 = "];\t\t" + NL + "                    \t";
  protected final String TEXT_196 = NL + "                            if (";
  protected final String TEXT_197 = ".";
  protected final String TEXT_198 = " != null) {" + NL + "                            \troutines.system.DynamicUtils.writeValuesToStringArray(";
  protected final String TEXT_199 = ".";
  protected final String TEXT_200 = ", row";
  protected final String TEXT_201 = ", ";
  protected final String TEXT_202 = ");" + NL + "                            }" + NL + "                \t\t\t";
  protected final String TEXT_203 = " " + NL + "                \t\t\trow";
  protected final String TEXT_204 = "[";
  protected final String TEXT_205 = "]=";
  protected final String TEXT_206 = ".";
  protected final String TEXT_207 = ";" + NL + "                \t\t\t";
  protected final String TEXT_208 = "FormatterUtils.format_Date(";
  protected final String TEXT_209 = ".";
  protected final String TEXT_210 = ", ";
  protected final String TEXT_211 = ");" + NL + "                \t\t\t";
  protected final String TEXT_212 = "java.nio.charset.Charset.defaultCharset().decode(java.nio.ByteBuffer.wrap(";
  protected final String TEXT_213 = ".";
  protected final String TEXT_214 = ")).toString();" + NL + "                \t\t\t";
  protected final String TEXT_215 = "FormatterUtils.format_Number(";
  protected final String TEXT_216 = ".toPlainString(), ";
  protected final String TEXT_217 = ", ";
  protected final String TEXT_218 = ");\t\t\t\t\t" + NL + "                \t\t\t";
  protected final String TEXT_219 = "FormatterUtils.format_Number(new java.math.BigDecimal(String.valueOf(";
  protected final String TEXT_220 = ".";
  protected final String TEXT_221 = ")).toPlainString(), ";
  protected final String TEXT_222 = ", ";
  protected final String TEXT_223 = ");\t\t\t\t\t\t" + NL + "                \t\t\t";
  protected final String TEXT_224 = ".toPlainString();" + NL + "                \t\t\t";
  protected final String TEXT_225 = "String.valueOf(";
  protected final String TEXT_226 = ".";
  protected final String TEXT_227 = ");" + NL + "                \t\t\t";
  protected final String TEXT_228 = NL + "    \t\t\tsynchronized (multiThreadLockWrite) {";
  protected final String TEXT_229 = NL + "\t\t\t\tsynchronized (lockWrite) {";
  protected final String TEXT_230 = NL + "\t\t\t\tObject[] pLockWrite = (Object[])globalMap.get(\"PARALLEL_LOCK_WRITE\");" + NL + "\t\t\t\tsynchronized (pLockWrite) {";
  protected final String TEXT_231 = NL + "\t\t\t\tnb_line_";
  protected final String TEXT_232 = "++;";
  protected final String TEXT_233 = NL + "            \t\t\t    if(currentRow_";
  protected final String TEXT_234 = " % splitEvery_";
  protected final String TEXT_235 = "==0 && currentRow_";
  protected final String TEXT_236 = "!=0){" + NL + "            \t\t\t        splitedFileNo_";
  protected final String TEXT_237 = "++;" + NL + "            \t\t\t        CsvWriter";
  protected final String TEXT_238 = ".close(); " + NL + "            \t\t\t        //close original outputStream" + NL + "            \t\t\t        ";
  protected final String TEXT_239 = NL + "            \t\t\t        out";
  protected final String TEXT_240 = " = new routines.system.BufferedOutput(new java.io.OutputStreamWriter(" + NL + "\t\t\t\t\t\t\t\t\tnew java.io.FileOutputStream(fullName_";
  protected final String TEXT_241 = " + splitedFileNo_";
  protected final String TEXT_242 = " + extension_";
  protected final String TEXT_243 = ", ";
  protected final String TEXT_244 = "),";
  protected final String TEXT_245 = "));" + NL + "\t\t\t\t\t\t\t\tstrWriter";
  protected final String TEXT_246 = " = new java.io.StringWriter();" + NL + "            \t                CsvWriter";
  protected final String TEXT_247 = " = new com.talend.csv.CSVWriter(strWriter";
  protected final String TEXT_248 = ", " + NL + "\t\t    \t\t\t\t\t\tcsvSettings_";
  protected final String TEXT_249 = ".getFieldDelim(),'\\0','\\0',lineSeparator_";
  protected final String TEXT_250 = ");" + NL + "            \t                ";
  protected final String TEXT_251 = NL + "            \t                CsvWriter";
  protected final String TEXT_252 = " = new com.talend.csv.CSVWriter(new java.io.BufferedWriter(new java.io.OutputStreamWriter(" + NL + "\t\t\t\t\t\t\t\t\tnew java.io.FileOutputStream(fullName_";
  protected final String TEXT_253 = " + splitedFileNo_";
  protected final String TEXT_254 = " + extension_";
  protected final String TEXT_255 = ", ";
  protected final String TEXT_256 = "),";
  protected final String TEXT_257 = ")), " + NL + "\t\t\t\t\t\t\t\t\tcsvSettings_";
  protected final String TEXT_258 = ".getFieldDelim(),'\\0','\\0',lineSeparator_";
  protected final String TEXT_259 = ");" + NL + "            \t                ";
  protected final String TEXT_260 = NL + "            \t\t\t        //set header." + NL + "            \t\t\t        ";
  protected final String TEXT_261 = NL + "            \t\t\t            CsvWriter";
  protected final String TEXT_262 = ".writeNext(headColu";
  protected final String TEXT_263 = ");" + NL + "            \t\t\t            ";
  protected final String TEXT_264 = "\t" + NL + "            \t\t\t            out";
  protected final String TEXT_265 = ".write(strWriter";
  protected final String TEXT_266 = ".getBuffer().toString());" + NL + "               \t\t\t\t\t\tstrWriter";
  protected final String TEXT_267 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_268 = ".getBuffer().length());" + NL + "            \t\t\t            ";
  protected final String TEXT_269 = NL + "                                    file";
  protected final String TEXT_270 = " = new java.io.File(fullName_";
  protected final String TEXT_271 = " + splitedFileNo_";
  protected final String TEXT_272 = " + extension_";
  protected final String TEXT_273 = ");" + NL + "                        \t\t    if(file";
  protected final String TEXT_274 = ".length() == 0) {" + NL + "                        \t\t        CsvWriter";
  protected final String TEXT_275 = ".writeNext(headColu";
  protected final String TEXT_276 = "); " + NL + "                        \t\t        ";
  protected final String TEXT_277 = NL + "                        \t\t        out";
  protected final String TEXT_278 = ".write(strWriter";
  protected final String TEXT_279 = ".getBuffer().toString());" + NL + "                \t\t\t\t\t\tstrWriter";
  protected final String TEXT_280 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_281 = ".getBuffer().length());" + NL + "                \t\t\t\t\t\t";
  protected final String TEXT_282 = NL + "                       \t\t    \t}\t  " + NL + "                        \t\t    ";
  protected final String TEXT_283 = NL + "                        \t\t//initialize new CsvWriter information" + NL + "\t\t\t\t\t\t\t\tCsvWriter";
  protected final String TEXT_284 = ".setEscapeChar(csvSettings_";
  protected final String TEXT_285 = ".getEscapeChar());\t\t\t\t\t      \t\t" + NL + "\t\t\t\t\t      \t\tCsvWriter";
  protected final String TEXT_286 = ".setQuoteChar(csvSettings_";
  protected final String TEXT_287 = ".getTextEnclosure()); " + NL + "\t\t\t\t\t      \t\t        \t\t" + NL + "                        \t\tCsvWriter";
  protected final String TEXT_288 = ".writeNext(row";
  protected final String TEXT_289 = ");" + NL + "                        \t\t";
  protected final String TEXT_290 = NL + "                        \t\tout";
  protected final String TEXT_291 = ".write(strWriter";
  protected final String TEXT_292 = ".getBuffer().toString());" + NL + "                \t\t\t\tstrWriter";
  protected final String TEXT_293 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_294 = ".getBuffer().length());" + NL + "                        \t\t";
  protected final String TEXT_295 = NL + "            \t\t                if(nb_line_";
  protected final String TEXT_296 = "%";
  protected final String TEXT_297 = " == 0) {" + NL + "            \t\t                ";
  protected final String TEXT_298 = NL + "            \t\t                out";
  protected final String TEXT_299 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_300 = NL + "            \t\t                CsvWriter";
  protected final String TEXT_301 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_302 = NL + "            \t\t                }" + NL + "                        \t\t    ";
  protected final String TEXT_303 = " " + NL + "         \t\t\t\t" + NL + "         \t\t\t\t\t}else{" + NL + "         \t\t\t\t\t    CsvWriter";
  protected final String TEXT_304 = ".writeNext(row";
  protected final String TEXT_305 = ");\t" + NL + "         \t\t\t\t\t    ";
  protected final String TEXT_306 = NL + "         \t\t\t\t\t    out";
  protected final String TEXT_307 = ".write(strWriter";
  protected final String TEXT_308 = ".getBuffer().toString());" + NL + "                \t\t\t\tstrWriter";
  protected final String TEXT_309 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_310 = ".getBuffer().length());" + NL + "         \t\t\t\t\t    ";
  protected final String TEXT_311 = NL + "            \t\t                if(nb_line_";
  protected final String TEXT_312 = "%";
  protected final String TEXT_313 = " == 0) {" + NL + "            \t\t                ";
  protected final String TEXT_314 = NL + "            \t\t                out";
  protected final String TEXT_315 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_316 = NL + "            \t\t                CsvWriter";
  protected final String TEXT_317 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_318 = NL + "            \t\t                }" + NL + "         \t\t\t\t\t        ";
  protected final String TEXT_319 = "  \t\t\t\t\t" + NL + "         \t\t\t\t\t}\t" + NL + "            \t\t\t    currentRow_";
  protected final String TEXT_320 = "++;\t\t" + NL + "             \t\t\t" + NL + "            \t\t\t    ";
  protected final String TEXT_321 = NL + "            \t\t\t    CsvWriter";
  protected final String TEXT_322 = ".writeNext(row";
  protected final String TEXT_323 = ");\t" + NL + "            \t\t\t    ";
  protected final String TEXT_324 = NL + "            \t\t\t    out";
  protected final String TEXT_325 = ".write(strWriter";
  protected final String TEXT_326 = ".getBuffer().toString());" + NL + "                \t\t\tstrWriter";
  protected final String TEXT_327 = ".getBuffer().delete(0, strWriter";
  protected final String TEXT_328 = ".getBuffer().length());" + NL + "            \t\t\t    ";
  protected final String TEXT_329 = NL + "            \t\t                if(nb_line_";
  protected final String TEXT_330 = "%";
  protected final String TEXT_331 = " == 0) {" + NL + "            \t\t                ";
  protected final String TEXT_332 = NL + "            \t\t                out";
  protected final String TEXT_333 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_334 = NL + "            \t\t                CsvWriter";
  protected final String TEXT_335 = ".flush();" + NL + "            \t\t                ";
  protected final String TEXT_336 = NL + "            \t\t                }" + NL + "            \t\t\t        ";
  protected final String TEXT_337 = "  \t\t\t\t" + NL + "            \t\t\t    ";
  protected final String TEXT_338 = NL + "    \t\t\t} ";
  protected final String TEXT_339 = NL + "\t\t\t\t}";
  protected final String TEXT_340 = NL + "    \t\t\t}";
  protected final String TEXT_341 = NL + "            \t\t\t" + NL + "            \t\t\t";
  protected final String TEXT_342 = NL;
  protected final String TEXT_343 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
     
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();

boolean useStream = ("true").equals(ElementParameterParser.getValue(node,"__USESTREAM__"));

if(("false").equals(ElementParameterParser.getValue(node,"__CSV_OPTION__"))) {	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_2);
    
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {
                        
            String fieldSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__FIELDSEPARATOR__",
                "FIELDSEPARATOR"
            );
            
            String rowSeparator = ElementParameterParser.getValueWithUIFieldKey(
                node,
                "__ROWSEPARATOR__",
                "ROWSEPARATOR"
            );
            
            String encoding = ElementParameterParser.getValue(
                node,
                "__ENCODING__"
            );
            
            boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));
            
            boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
    		String fileNewname = ElementParameterParser.getValue(node,"__FILENAME__");
    		
    		boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
    		
    		boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
            String splitEvery = ElementParameterParser.getValue(node, "__SPLIT_EVERY__");
            
            boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
            String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
            
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER); 
   		    
			String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
			boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
			
			boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
			
			boolean hasDynamic = metadata.isDynamicSchema();

        	List< ? extends IConnection> conns = node.getIncomingConnections();
        	for (IConnection conn : conns) {
        		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        			List<IMetadataColumn> columns = metadata.getListColumns();
        			int sizeColumns = columns.size();
        		    
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_4);
    
	                if(isIncludeHeader && hasDynamic){
						if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_5);
    
    					}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_6);
     
    		        	}
    		        	if (isParallelize) {
				
    stringBuffer.append(TEXT_7);
     
						}
	                	if(!split && compress && !isAppend){
	                	
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_10);
    
	                	}else{
    		        
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    
        		        }
                    	for (int i = 0; i < sizeColumns; i++) {
                            IMetadataColumn column = columns.get(i);
                            if(!("id_Dynamic".equals(column.getTalendType()))) {
        		         
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_15);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_16);
    
        		            }else{
    	    		     
    stringBuffer.append(TEXT_17);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_18);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_21);
    
        		            }
        		            if(i != sizeColumns - 1) {
        		         
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_24);
    
                            }
                        }
        		        
    stringBuffer.append(TEXT_25);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_28);
     
		        		if (isParallelize) {
				
    stringBuffer.append(TEXT_29);
    
		        		}
						if (codeGenArgument.subTreeContainsParallelIterate()) {
				
    stringBuffer.append(TEXT_30);
    
		        		}
		        		if(codeGenArgument.getIsRunInMultiThread()){
				
    stringBuffer.append(TEXT_31);
    
						}
		        
    stringBuffer.append(TEXT_32);
    
    		        }					  
        			for (int i = 0; i < sizeColumns; i++) {
      			
        				IMetadataColumn column = columns.get(i);
    					JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
    					boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( javaType, column.isNullable());
    					if(!isPrimitive) {
    					    
    stringBuffer.append(TEXT_33);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_34);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_35);
    
    				    } 
    				    if(column.getTalendType().equals("id_Dynamic")){
    				    
    stringBuffer.append(TEXT_36);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_37);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_40);
    
    				    }else{
    				    
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_42);
    
    			        	String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
    			        	if (javaType == JavaTypesManager.DATE && pattern != null && pattern.trim().length() != 0) {
    			            
    stringBuffer.append(TEXT_43);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_44);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_45);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_46);
    	
    						} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
							
    stringBuffer.append(TEXT_47);
     if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_48);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_49);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_50);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_51);
     } else { 
    stringBuffer.append(TEXT_52);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_53);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_54);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_55);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_56);
     } 
    stringBuffer.append(TEXT_57);
    
							} else if(javaType == JavaTypesManager.BIGDECIMAL){
    						
    stringBuffer.append(TEXT_58);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_59);
    
							} else if(javaType == JavaTypesManager.BYTE_ARRAY){
    						
    stringBuffer.append(TEXT_60);
    stringBuffer.append(encoding );
    stringBuffer.append(TEXT_61);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_62);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_63);
    
    			        	} else {
    			            
    stringBuffer.append(TEXT_64);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_65);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_66);
    				
    			        	}
    			        
    stringBuffer.append(TEXT_67);
    
    					}
    					if(!isPrimitive) {
    					    
    stringBuffer.append(TEXT_68);
    
    			        } 
    			        if(i != sizeColumns - 1) {
    			            
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_71);
    
    			        }
    		        }
    		        
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_73);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_74);
    
    					if(codeGenArgument.getIsRunInMultiThread()){
    				
    stringBuffer.append(TEXT_75);
    
    					}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {
    				
    stringBuffer.append(TEXT_76);
     
    		        	}
    		        	if (isParallelize) {
  					
    stringBuffer.append(TEXT_77);
     
						}
    		        
    stringBuffer.append(TEXT_78);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_79);
    
    		        // add a prerequisite useStream to support output stream feature:8873
    		        if(!useStream && split){ 
    		            
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_86);
    stringBuffer.append(isInRowMode?"routines.system.BufferedOutput":"java.io.BufferedWriter");
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_89);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_90);
    stringBuffer.append( isAppend);
    stringBuffer.append(TEXT_91);
    stringBuffer.append( encoding);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    
    		                if(isIncludeHeader){
    		                    
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    		
    		                        //List<IMetadataColumn> columns = metadata.getListColumns();
    		                        //int sizeColumns = columns.size();
    		                        for (int i = 0; i < sizeColumns; i++) {
    		                            IMetadataColumn column = columns.get(i);
    		                            if(!("id_Dynamic".equals(column.getTalendType()))) {
    		                            
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_100);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_101);
    
    		                            }else{
	    		            			
    stringBuffer.append(TEXT_102);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_103);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_106);
    
    		                            }
    		                            if(i != sizeColumns - 1) {
    		                                
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_109);
    
    		                            }
    		                        }
    		                        
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_112);
    
    		                }
    		                
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_115);
     
    		                if(flushOnRow) { 
    		                    
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_117);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_118);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_119);
    
    		                }
    		                
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_122);
     
    		                if(flushOnRow) { 
    		                    
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_124);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_126);
    
    		                }
    		                
    stringBuffer.append(TEXT_127);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_128);
     
    		        } else { 
    		            
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_130);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_131);
     
    		            if(flushOnRow) { 
    		                
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_133);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_135);
    
    		            }
    		            
    stringBuffer.append(TEXT_136);
    
    		        }
    		        
    stringBuffer.append(TEXT_137);
     
    		        	if (isParallelize) {
    				
    stringBuffer.append(TEXT_138);
    
    		        	}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {
    				
    stringBuffer.append(TEXT_139);
    
    		        	}
    		        	if(codeGenArgument.getIsRunInMultiThread()){
    				
    stringBuffer.append(TEXT_140);
    
    					}
    		        
    stringBuffer.append(TEXT_141);
    
    	        }
            }
        }
    }
    
    stringBuffer.append(TEXT_142);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}else{//the following is the tFileOutputCSV component
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    stringBuffer.append(TEXT_143);
    
    
    List<IMetadataTable> metadatas = node.getMetadataList();
    if ((metadatas!=null)&&(metadatas.size()>0)) {
        IMetadataTable metadata = metadatas.get(0);
        if (metadata!=null) {                                    
            String encoding = ElementParameterParser.getValue(node,"__ENCODING__");
    		String delim = ElementParameterParser.getValue(node, "__FIELDSEPARATOR__");
        	boolean isIncludeHeader = ("true").equals(ElementParameterParser.getValue(node,"__INCLUDEHEADER__"));
        	boolean isAppend = ("true").equals(ElementParameterParser.getValue(node,"__APPEND__"));

        	boolean split = ("true").equals(ElementParameterParser.getValue(node, "__SPLIT__"));
        	
        	boolean isInRowMode = ("true").equals(ElementParameterParser.getValue(node,"__ROW_MODE__"));
        	
        	boolean flushOnRow = ("true").equals(ElementParameterParser.getValue(node, "__FLUSHONROW__"));
        	String flushMod = ElementParameterParser.getValue(node, "__FLUSHONROW_NUM__");
        	
    		String advancedSeparatorStr = ElementParameterParser.getValue(node, "__ADVANCED_SEPARATOR__");
    		boolean advancedSeparator = (advancedSeparatorStr!=null&&!("").equals(advancedSeparatorStr))?("true").equals(advancedSeparatorStr):false;
    		String thousandsSeparator = ElementParameterParser.getValueWithJavaType(node, "__THOUSANDS_SEPARATOR__", JavaTypesManager.CHARACTER);
    		String decimalSeparator = ElementParameterParser.getValueWithJavaType(node, "__DECIMAL_SEPARATOR__", JavaTypesManager.CHARACTER);        	
        	
        	String parallelize = ElementParameterParser.getValue(node,"__PARALLELIZE__");
			boolean isParallelize = (parallelize!=null&&!("").equals(parallelize))?("true").equals(parallelize):false;
        	
        	List< ? extends IConnection> conns = node.getIncomingConnections();
        	
        	boolean compress = ("true").equals(ElementParameterParser.getValue(node,"__COMPRESS__"));
        	
        	boolean hasDynamic = metadata.isDynamicSchema();
        	IMetadataColumn dynamicCol = metadata.getDynamicColumn();
        	
        	if(conns!=null){
        		if (conns.size()>0){
        		    IConnection conn =conns.get(0);
            		if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
        				List<IMetadataColumn> columns = metadata.getListColumns();
            			int sizeColumns = columns.size();
            			if(isIncludeHeader && hasDynamic){

							if(codeGenArgument.getIsRunInMultiThread()){
							
    stringBuffer.append(TEXT_144);
    
            				}
            				if (codeGenArgument.subTreeContainsParallelIterate()) {
							
    stringBuffer.append(TEXT_145);
     
            	        	}
            	        	if (isParallelize) {
							
    stringBuffer.append(TEXT_146);
     
							}
            				if(!split && compress && !isAppend){
            				
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_152);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_153);
    
            				}else{
            			
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(TEXT_158);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_159);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_160);
    
            				}
                        	for (int i = 0; i < sizeColumns; i++) {
                                IMetadataColumn column = columns.get(i);
                                if(!("id_Dynamic".equals(column.getTalendType()))) {
            		         
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_164);
    
            		            }else{
        	    		     
    stringBuffer.append(TEXT_165);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_166);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_170);
    stringBuffer.append(dynamicCol.getLabel());
    stringBuffer.append(TEXT_171);
    
            		            }
                            }
                            
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    if(isInRowMode){
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_179);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    }
    stringBuffer.append(TEXT_182);
     
            	        	if (isParallelize) {
            			
    stringBuffer.append(TEXT_183);
    
            	        	}
            				if (codeGenArgument.subTreeContainsParallelIterate()) {
            			
    stringBuffer.append(TEXT_184);
    
            	        	}
            	        	if(codeGenArgument.getIsRunInMultiThread()){
            			
    stringBuffer.append(TEXT_185);
    
            				}
            	        
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_192);
    
            			}
            			
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(sizeColumns);
    stringBuffer.append(hasDynamic?"+"+conn.getName()+".":"" );
    stringBuffer.append(dynamicCol==null?"":dynamicCol.getLabel()+".getColumnCount()-1" );
    stringBuffer.append(TEXT_195);
    
            			for (int i = 0; i < sizeColumns; i++) {
                			IMetadataColumn column = columns.get(i);
                			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                			String pattern = column.getPattern() == null || column.getPattern().trim().length() == 0 ? null : column.getPattern();
                			boolean isPrimitive = JavaTypesManager.isJavaPrimitiveType( column.getTalendType(), column.isNullable());
                			
                			if(("id_Dynamic").equals(column.getTalendType())) {
                			
    stringBuffer.append(TEXT_196);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_197);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_198);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_199);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_202);
    
                			}else{
                			
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(isPrimitive? "":conn.getName()+"."+column.getLabel()+ "==null?\"\":");
    					
                				if(javaType == JavaTypesManager.STRING ){
                			
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_206);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_207);
    
                				}else if(javaType == JavaTypesManager.DATE && pattern != null){
                			
    stringBuffer.append(TEXT_208);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_209);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_210);
    stringBuffer.append( pattern );
    stringBuffer.append(TEXT_211);
    
                				}else if(javaType == JavaTypesManager.BYTE_ARRAY){
                			
    stringBuffer.append(TEXT_212);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_213);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_214);
    
                				} else if(advancedSeparator && JavaTypesManager.isNumberType(javaType, column.isNullable())) { 
        							if(javaType == JavaTypesManager.BIGDECIMAL) {
    stringBuffer.append(TEXT_215);
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_216);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_217);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_218);
      	} else { 
    stringBuffer.append(TEXT_219);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_220);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_221);
    stringBuffer.append( thousandsSeparator );
    stringBuffer.append(TEXT_222);
    stringBuffer.append( decimalSeparator );
    stringBuffer.append(TEXT_223);
    		}
        						} else if (javaType == JavaTypesManager.BIGDECIMAL) {
							
    stringBuffer.append(column.getPrecision() == null? conn.getName() + "." + column.getLabel() : conn.getName() + "." + column.getLabel() + ".setScale(" + column.getPrecision() + ", java.math.RoundingMode.HALF_UP)" );
    stringBuffer.append(TEXT_224);
    
                			 	} else{
                			
    stringBuffer.append(TEXT_225);
    stringBuffer.append(conn.getName() );
    stringBuffer.append(TEXT_226);
    stringBuffer.append(column.getLabel() );
    stringBuffer.append(TEXT_227);
    
                				}
                			}
            			}

        					if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_228);
    
    					}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {

    stringBuffer.append(TEXT_229);
    
						}
						if (isParallelize) {

    stringBuffer.append(TEXT_230);
    
						}

    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_232);
    
            			if(!useStream && split){
            			    
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    if(isInRowMode){
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_245);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    }else{
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(isAppend);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(encoding);
    stringBuffer.append(TEXT_257);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    }
    stringBuffer.append(TEXT_260);
    
            			        if(isIncludeHeader && !isAppend){
            			            
    stringBuffer.append(TEXT_261);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_263);
    if(isInRowMode){
    stringBuffer.append(TEXT_264);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_265);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_266);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_267);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_268);
    }
            			        }
            			        if(isIncludeHeader && isAppend){
            			            
    stringBuffer.append(TEXT_269);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_270);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_271);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_272);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_276);
    if(isInRowMode){
    stringBuffer.append(TEXT_277);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_278);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_279);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_281);
    }
    stringBuffer.append(TEXT_282);
    
            			        }
                        		
    stringBuffer.append(TEXT_283);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_284);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_285);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    if(isInRowMode){
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    }
                        		if(flushOnRow) { 
                        		    
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_296);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_297);
    if(isInRowMode){
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    }else{
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_301);
    }
    stringBuffer.append(TEXT_302);
    
                    			}
                        		
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    if(isInRowMode){
    stringBuffer.append(TEXT_306);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_307);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_308);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_309);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_310);
    }
         					    if(flushOnRow) { 
         					        
    stringBuffer.append(TEXT_311);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_312);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_313);
    if(isInRowMode){
    stringBuffer.append(TEXT_314);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_315);
    }else{
    stringBuffer.append(TEXT_316);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_317);
    }
    stringBuffer.append(TEXT_318);
    
         					    }
         					    
    stringBuffer.append(TEXT_319);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_320);
    
            			}else{
            			    
    stringBuffer.append(TEXT_321);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_322);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_323);
    if(isInRowMode){
    stringBuffer.append(TEXT_324);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_325);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_326);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_327);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_328);
    }
            			    if(flushOnRow) { 
            			        
    stringBuffer.append(TEXT_329);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_330);
    stringBuffer.append(flushMod );
    stringBuffer.append(TEXT_331);
    if(isInRowMode){
    stringBuffer.append(TEXT_332);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_333);
    }else{
    stringBuffer.append(TEXT_334);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_335);
    }
    stringBuffer.append(TEXT_336);
    
                			}
            			    
    stringBuffer.append(TEXT_337);
       		
            		
            			}
            			
     
						if ( isParallelize) {

    stringBuffer.append(TEXT_338);
    
    		        	}
    					if (codeGenArgument.subTreeContainsParallelIterate()) {

    stringBuffer.append(TEXT_339);
    
						}
						if(codeGenArgument.getIsRunInMultiThread()){

    stringBuffer.append(TEXT_340);
    
    					}

    stringBuffer.append(TEXT_341);
       		
            		}
        		
        		}
        	}	
    	
        }
    
    }
    
    stringBuffer.append(TEXT_342);
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}

    stringBuffer.append(TEXT_343);
    return stringBuffer.toString();
  }
}
