package com.ymb.shell.controller;


import com.ymb.shell.annotation.ApiIdempotent;
import com.ymb.shell.common.ServerResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {


    @ApiIdempotent
    @PostMapping("testIdempotence")
    public ServerResponse testIdempotence() {
        return ServerResponse.success("testIdempotence: success");
    }

}
