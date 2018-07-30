package com.demo.web.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Copyright (C), 2015-2018, XXX有限公司
 * FileName: GlobalExceptionHandler
 * @Author:   雷声正
 * Date:     2018-04-04 18:48
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * 所有异常报错
     * @param exception 异常信息
     */
    @ExceptionHandler(value=Exception.class)
    public void allExceptionHandler(HttpServletResponse response, Exception exception) throws IOException {

        System.out.println(exception);
        // 重定向到404
        PrintWriter pw = response.getWriter();
        pw.write("<script>top.location.href ='/404';</script>");
        pw.flush();
    }
}