package com.cyh.ums.web.controll;

import com.cyh.ums.domain.LanguageCode;
import com.cyh.ums.dto.Result;
import com.cyh.ums.serviceI.LanguageCodeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("languageCode")
public class LanguageCodeControll {
    @Autowired
    private LanguageCodeService LanguageCodeService;

    @GetMapping(value = "i18n")
    @ApiOperation(value = "获取国际化数据",tags = {"国际化模块"})
    public Result<List<LanguageCode>> list(@CookieValue(value = "languageType",required = false) Integer languageType){
        System.out.println("语言类型"+languageType);
        Result<List<LanguageCode>> listResult=new Result<>();
        List<LanguageCode> list= LanguageCodeService.list(languageType);
        listResult.setData(list);
        return  listResult;
    }

}
