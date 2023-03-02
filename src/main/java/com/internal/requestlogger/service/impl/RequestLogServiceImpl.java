package com.internal.requestlogger.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.internal.requestlogger.dto.RequestLogDto;
import com.internal.requestlogger.mapper.RequestLogMapper;
import com.internal.requestlogger.model.RequestLog;
import com.internal.requestlogger.service.iface.RequestLogService;
import static io.micrometer.common.util.StringUtils.*;
import jakarta.annotation.Resource;
import static org.apache.commons.lang3.StringUtils.*;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import java.util.Arrays;
import static java.util.Objects.isNull;
import static com.internal.requestlogger.exception.Assert.*;


@Service
public class RequestLogServiceImpl implements RequestLogService {

    @Resource
    private RequestLogMapper requestLogMapper;

    @Override
    public void add(RequestLog requestLog) {
        isFalse( isNull(requestLog), "The request must not be null!" );

        requestLog.setMethod( upperCase( trim( requestLog.getMethod() ) ) );
        requestLog.setUrl( trim( requestLog.getUrl() ) );
        requestLog.setContentType( trim( requestLog.getContentType() ) );
        requestLog.setContent( trim( requestLog.getContent() ) );

        isFalse( isEmpty( requestLog.getMethod() ), "The method must not be blank!" );
        isFalse( Arrays.stream( HttpMethod.values() )
                       .noneMatch( m -> m.toString().equalsIgnoreCase( requestLog.getMethod() ) ),
                "The method is not valid!" );
        isFalse( isEmpty( requestLog.getUrl() ), "The url must not be blank!" );
        isFalse( isEmpty( requestLog.getContentType() ), "The content must not be blank!" );

        requestLogMapper.insert(requestLog);
    }

    @Override
    public PageInfo<RequestLog> getAll(RequestLogDto requestLogDto) {
        PageHelper.startPage(requestLogDto.getPageNum(), requestLogDto.getPageSize());
        return new PageInfo<>(requestLogMapper.queryAllWithFilter(requestLogDto));
    }
}
