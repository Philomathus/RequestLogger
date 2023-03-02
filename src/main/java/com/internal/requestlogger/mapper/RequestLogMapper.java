package com.internal.requestlogger.mapper;

import com.internal.requestlogger.dto.RequestLogDto;
import com.internal.requestlogger.model.RequestLog;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface RequestLogMapper {

    void insert(RequestLog requestLog);

    List<RequestLog> queryAllWithFilter(RequestLogDto requestLogDto);
}
