package com.jason.jxls;

/**
 * @author jason
 */
public class JxlsImportConstants {
    public static final String EXL_FIELD_HEAD = "FILED_";
    public static final String EXL_OBJECT_KEY = "dto";
    public static final int EXL_HEAD_ROW_NUM = 0;
    public static String EXL_IMPORT_CONFIG = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<workbook>\n" +
            "    <worksheet idx=\"0\">\n" +
            "        <loop startRow=\"0\" endRow=\"0\" items=\"sheet1List\" var=\"dto\" varType=\"java.util.HashMap\">\n" +
            "            <section startRow=\"0\" endRow=\"0\">\n" +
            "            </section>\n" +
            "            <loopbreakcondition>\n" +
            "                <rowcheck offset=\"0\">\n" +
            "                    <cellcheck offset=\"0\">break</cellcheck>\n" +
            "                </rowcheck>\n" +
            "            </loopbreakcondition>\n" +
            "        </loop>\n" +
            "    </worksheet>\n" +
            "    <worksheet idx=\"1\">\n" +
            "        <loop startRow=\"0\" endRow=\"0\" items=\"sheet2List\" var=\"dto\" varType=\"java.util.HashMap\">\n" +
            "            <section startRow=\"0\" endRow=\"0\">\n" +
            "            </section>\n" +
            "            <loopbreakcondition>\n" +
            "                <rowcheck offset=\"0\">\n" +
            "                    <cellcheck offset=\"0\">break</cellcheck>\n" +
            "                </rowcheck>\n" +
            "            </loopbreakcondition>\n" +
            "        </loop>\n" +
            "    </worksheet>\n" +
            "</workbook>";
}
