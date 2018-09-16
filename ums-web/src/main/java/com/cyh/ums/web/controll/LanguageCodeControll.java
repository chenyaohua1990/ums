package com.cyh.ums.web.controll;

import com.cyh.ums.domain.LanguageCode;
import com.cyh.ums.dto.Result;
import com.cyh.ums.serviceI.LanguageCodeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("languageCode")
public class LanguageCodeControll {
    @Autowired
    private LanguageCodeService LanguageCodeService;

    @GetMapping(value = "i18n")
    @ApiOperation(value = "获取国际化数据",tags = {"国际化模块"})
    public Result<List<LanguageCode>> list(){
        List<LanguageCode> list= LanguageCodeService.list();
        return null;
    }

}
