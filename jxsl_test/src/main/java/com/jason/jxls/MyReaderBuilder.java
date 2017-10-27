package com.jason.jxls;


import org.apache.commons.digester3.Digester;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Leonid Vysochyn
 */
public class MyReaderBuilder extends ReaderBuilder {

    public static XLSReader buildFromXML(InputStream xmlStream) throws IOException, SAXException {
        Digester digester = new Digester();
        digester.setValidating( false );
        digester.addObjectCreate("workbook", "org.jxls.reader.XLSReaderImpl");
        digester.addObjectCreate("workbook/worksheet", "org.jxls.reader.XLSSheetReaderImpl");
        digester.addSetProperties("workbook/worksheet", "name", "sheetName");
        digester.addSetProperties("workbook/worksheet", "idx", "sheetIdx");
        digester.addSetNext("workbook/worksheet", "addSheetReader");
        digester.addObjectCreate("*/loop", "org.jxls.reader.XLSForEachBlockReaderImpl");
        digester.addSetProperties("*/loop");
        digester.addSetNext("*/loop", "addBlockReader");
        digester.addObjectCreate("*/section", "com.jason.jxls.MySimpleBlockReaderImpl");
        digester.addSetProperties("*/section");
        digester.addSetNext("*/section", "addBlockReader");
        digester.addObjectCreate("*/mapping", "org.jxls.reader.BeanCellMapping");
        digester.addSetProperties("*/mapping");
        digester.addCallMethod("*/mapping", "setFullPropertyName", 1);
        digester.addCallParam("*/mapping", 0);
        digester.addSetNext("*/mapping", "addMapping");
        digester.addObjectCreate("*/loop/loopbreakcondition", "com.jason.jxls.MySimpleSectionCheck");
        digester.addSetNext("*/loop/loopbreakcondition", "setLoopBreakCondition");
        digester.addObjectCreate("*/loopbreakcondition/rowcheck", "org.jxls.reader.OffsetRowCheckImpl");
        digester.addSetProperties("*/loopbreakcondition/rowcheck");
        digester.addSetNext("*/loopbreakcondition/rowcheck", "addRowCheck");
        digester.addObjectCreate("*/rowcheck/cellcheck", "org.jxls.reader.OffsetCellCheckImpl");
        digester.addSetProperties("*/rowcheck/cellcheck");
        digester.addCallMethod("*/rowcheck/cellcheck", "setValue", 1);
        digester.addCallParam("*/rowcheck/cellcheck", 0);
        digester.addSetNext("*/rowcheck/cellcheck", "addCellCheck");
        return (XLSReader) digester.parse( xmlStream );
    }
}
