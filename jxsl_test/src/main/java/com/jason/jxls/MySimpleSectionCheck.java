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
        // 判断行数是否已经大于最后一行. fix 无法跳出 bug.
        if(cursor.getSheet().getLastRowNum() >= cursor.getCurrentRowNum()) {
            return super.isCheckSuccessful(cursor);
        }
        return true;
    }
}
