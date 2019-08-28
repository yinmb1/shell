package com.ymb.shell.controller;

import com.ymb.shell.http.HttpUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yinmb
 * @Date 2019/8/28 16:20:29
 */
@RestController
@RequestMapping(value = "/hello/")
public class HelloWordController
{
    @RequestMapping(value = "/httpTest", method = RequestMethod.POST)
    public String  helleHttp() {
        String json="json";

        String string = HttpUtil.postJson("http://127.0.0.1:8002/applyJob", json);

        return string;
    }
}
