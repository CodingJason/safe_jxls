package com.jason.jxls;


import org.apache.commons.digester3.Digester;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReader;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static com.jason.jxls.JxlsImportConstants.EXL_IMPORT_CONFIG;

/**
 * @author Leonid Vysochyn
 */
public class MyReaderBuilder extends ReaderBuilder {

    public static XLSReader buildFromXML() throws IOException, SAXException, ParserConfigurationException {
        /*
         * 在 Digester.class 中 factory.setSchema( schema );
         * schema 可能为null 手动写入.
         */
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(false);
        factory.setXIncludeAware(false);
        factory.setValidating(false);
        SAXParser parser = factory.newSAXParser();
        Digester digester = new Digester(parser);
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
        digester.addObjectCreate("*/mapping", "ocom.jason.jxls..MyBeanCellMapping");
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
//        return (XLSReader) digester.parse( xmlStream );
        return (XLSReader) digester.parse(new ByteArrayInputStream(EXL_IMPORT_CONFIG.getBytes()));
    }
}
