package com.cyh.ums.web.controll;

import com.cyh.ums.domain.LookupItem;
import com.cyh.ums.dto.Result;
import com.cyh.ums.serviceI.LookupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("lookup")
public class LookupControll {

    @Autowired
    private LookupService lookupService;

    @GetMapping(value = "lookup")
    public Result<List<LookupItem>> lookup(String lookupCode){
        List<LookupItem> list=lookupService.lookup(lookupCode);
        Result<List<LookupItem>> result=new Result<>();
        result.setData(list);
        return result;
    }


    @GetMapping(value = "lookup/list")
    public Result<Map<String,List<LookupItem>>> lookupList(List<String> codeList){

        return null;
    }



}
