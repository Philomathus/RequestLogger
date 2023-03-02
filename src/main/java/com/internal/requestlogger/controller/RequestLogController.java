package com.internal.requestlogger.controller;

import com.internal.requestlogger.dto.RequestLogDto;
import com.internal.requestlogger.model.RequestLog;
import com.internal.requestlogger.service.iface.RequestLogService;
import com.internal.requestlogger.vo.ResponseHelper;
import com.internal.requestlogger.vo.ResponseVo;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/requestLogger")
public class RequestLogController {

    @Resource
    private RequestLogService requestLogService;

    @PostMapping("/add")
    public ResponseVo<?> add(@RequestBody RequestLog requestLog) {
        requestLogService.add(requestLog);
        return ResponseHelper.success();
    }

    @PostMapping("/getByPageWithFilter")
    public ResponseVo<?> getWithFilter(@RequestBody RequestLogDto requestLogDto) {
        return ResponseHelper.success(requestLogService.getAll(requestLogDto));
    }
}
