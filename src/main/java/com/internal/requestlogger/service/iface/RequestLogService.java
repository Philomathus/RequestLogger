package com.internal.requestlogger.service.iface;

import com.github.pagehelper.PageInfo;
import com.internal.requestlogger.dto.RequestLogDto;
import com.internal.requestlogger.model.RequestLog;

public interface RequestLogService {

    void add(RequestLog requestLog);

    PageInfo<RequestLog> getAll(RequestLogDto requestLogDto);

}
