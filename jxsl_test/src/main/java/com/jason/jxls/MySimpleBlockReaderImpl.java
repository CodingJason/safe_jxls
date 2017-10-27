package com.jason.jxls;

import org.jxls.reader.*;

import java.util.Iterator;
import java.util.Map;

public class MySimpleBlockReaderImpl extends SimpleBlockReaderImpl implements SimpleBlockReader {
    @Override
    public XLSReadStatus read(XLSRowCursor cursor, Map beans) {
        // 从第一列确定列的长度
        if(getMappings().isEmpty()){
        short cellNum = cursor.getSheet().getRow(0).getLastCellNum();
            for(short i = 0; i<cellNum; i++){
                BeanCellMapping mapping = new BeanCellMapping(0,i,"dto","field"+i);
                addMapping(mapping);
            }
        }
        return super.read(cursor,beans);
    }
}
