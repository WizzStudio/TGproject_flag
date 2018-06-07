package com.ctg.flag.dao.projection;

import java.util.Date;

public interface CouncilOrderStatusProjection {
    Integer getState();
    String getActivityName();
    Date getStartTime();
    Date getEndTime();
    String getFeedback();
}
