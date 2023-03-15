package com.luckk.lizzie.controller;

import com.luckk.lizzie.service.ElasticSearchService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author liukun.inspire
 * @Date 2023/3/12 14:03
 * @PackageName:com.luckk.lizzie.controller
 * @ClassName: EsController
 * @Version 1.0
 */
@RestController
public class EsController {
    private final ElasticSearchService elasticSearchService;
    public EsController(ElasticSearchService elasticSearchService) {
        this.elasticSearchService = elasticSearchService;
    }

    @GetMapping("/hello")
    public String  sayHello(){
        return elasticSearchService.getIndex();

    }
}
