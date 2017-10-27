package com.jason.jxls;

import org.jxls.reader.SimpleSectionCheck;
import org.jxls.reader.XLSRowCursor;

import java.util.List;

public class MySimpleSectionCheck extends SimpleSectionCheck {
    public MySimpleSectionCheck() {}

    public MySimpleSectionCheck(List relativeRowChecks) {
        setOffsetRowChecks(relativeRowChecks);
    }

    @Override
    public boolean isCheckSuccessful(XLSRowCursor cursor) {
        // row num can not greater than sheet last row num;
        if(cursor.getSheet().getLastRowNum() >= cursor.getCurrentRowNum()) {
            return super.isCheckSuccessful(cursor);
        }
        return true;
    }
}
