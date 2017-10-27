package com.jasoncoding.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jason.jxls.MyReaderBuilder;
import org.apache.commons.lang3.StringUtils;
import org.jxls.reader.ReaderBuilder;
import org.jxls.reader.XLSReadStatus;
import org.jxls.reader.XLSReader;

import javax.swing.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Jason Peng
 */
public class TestMain {

    public static final String field_STR = "field";

    private static String config = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<workbook>\n" +
            "    <worksheet idx=\"0\">\n" +
            "        <loop startRow=\"0\" endRow=\"0\" items=\"excelDto\" var=\"dto\" varType=\"java.util.HashMap\">\n" +
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
            "        <loop startRow=\"0\" endRow=\"0\" items=\"excelDto1\" var=\"dto\" varType=\"java.util.HashMap\">\n" +
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


    private final String excelUrl = "http://ou3k7hg80.bkt.clouddn.com/testExcel.xlsx";

    /**
     * 打开文件选择窗口选择导入文件
     * @return 返回文件路径
     * @throws Exception
     */
    public String getExcelPath() throws Exception{
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        JFileChooser jFileChooser=new JFileChooser();
        int i = jFileChooser.showOpenDialog(null);
        if(i == JFileChooser.APPROVE_OPTION){
            //打开文件
            String path = jFileChooser.getSelectedFile().getAbsolutePath();
            String fileName = jFileChooser.getSelectedFile().getName();
            String extName =fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
            System.out.println("当前文件路径："+path+";\n当前文件名："+fileName+";\n当前文件扩展名："+extName);
            if(null!=extName && "xlsx".equals(extName)){
                return path;
            }else{
                System.out.println("您好,只能导入扩展名为xlsx的Excel文件！");
                return null;
            }
        }else{
            System.out.println("没有选中文件");
            return null;
        }
    }


    /**
     * 使用jxls解析导入的Excel
     * @param path 导入文件路径
     * @return List<VideoInfo> 导入对象集合
     */
    public List<HashMap<String,Object>> getExcelDataForVideoInfo(String path){
        List<HashMap<String,Object>> excelDto = new ArrayList<HashMap<String, Object>>();
        try {
//            InputStream inputXML = new BufferedInputStream(getClass().getClassLoader().getResourceAsStream("config.xml"));
//            XLSReader mainReader = ReaderBuilder.buildFromXML( inputXML );
            InputStream stringXML = new BufferedInputStream( new ByteArrayInputStream(config.getBytes()));
            XLSReader mainReader = MyReaderBuilder.buildFromXML(stringXML);
//            XLSReader mainReader = ReaderBuilder.buildFromXML(stringXML);

            InputStream inputXLS = new BufferedInputStream(new FileInputStream(new File(path)));
//            URL url = new URL(excelUrl);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            DataInputStream input = new DataInputStream(conn.getInputStream());
//            InputStream inputXLS = new BufferedInputStream(input);
//            ExcelImportDTO videoInfo = new ExcelImportDTO();
            HashMap<String,Object> videoInfo = Maps.newHashMap();
            Map<String,Object> beans = Maps.newHashMap();
            List<HashMap<String,Object>> excelDto1 = new ArrayList<HashMap<String, Object>>();
            beans.put("dto", videoInfo);
            beans.put("excelDto", excelDto);
            beans.put("excelDto1", excelDto1);

            XLSReadStatus readStatus = mainReader.read( inputXLS, beans);
            if(readStatus.isStatusOK()){
                System.out.println("jxls读取Excel成功！");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return excelDto;
    }

    public static void main(String[] args) {
        TestMain syncDataService = new TestMain();
        try {
//            String filePath = syncDataService.getExcelPath();
            String filePath = "/Users/jason/Downloads/test1.xlsx";
            if(null!=filePath && StringUtils.isNotBlank(filePath)){
                //导入Excel文件解析信息获取资源id
                List<HashMap<String,Object>> infoList = syncDataService.getExcelDataForVideoInfo(filePath);

                System.out.println("infoList大小==="+infoList.size());
                for(HashMap<String,Object> video:infoList){
                    System.out.println("打印ideoInfo详细信息======"+video.toString());
                    for (Map.Entry e :video.entrySet()){
                        System.out.println("打印 map ======"+e.toString());
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
