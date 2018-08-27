package com.cyh.ums.web.controll;

import com.alibaba.fastjson.JSON;
import com.cyh.ums.domain.TUser;
import com.cyh.ums.dto.Result;
import com.cyh.ums.serviceI.UserService;
import com.cyh.ums.validator.UserLoginCheck;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Set;

@RestController
@Api(tags = {"用户接口类"})
@RequestMapping(value = "user")
public class UserControll {

    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @PutMapping(value = "login")
    @ApiOperation(value = "用户登录",tags = {"用户接口类"})
    public ResponseEntity<String> login(@RequestBody /*@Validated(value = {UserLoginCheck.class})*/ TUser user, @ApiIgnore HttpServletRequest request){


        ValueOperations<String, Object> stringObjectValueOperations = redisTemplate.opsForValue();
        //字符串set
        stringObjectValueOperations.set("333", JSON.toJSONString(user));
        //字符串读取缓存
        System.out.println(stringObjectValueOperations.get("333"));;
        //获取全部键值
        Set<String> keys = redisTemplate.keys("*");
        keys.forEach(x->{
            System.out.println(x);
        });
        //判断是否存在相应的键
        Boolean aBoolean = redisTemplate.hasKey("333");
        Boolean user1 = redisTemplate.hasKey("user");
        System.out.println(String.format("%1b:%2b",aBoolean,user1));

        //删除对应键值
        Boolean delete = redisTemplate.delete("333");
        System.out.println(String.format("是否删除成功：%b",delete));

        return ResponseEntity.ok().body("SUCCESS");
    }

    @GetMapping(value = "translate")
    @ApiOperation(value = "翻译",tags = {"其他接口"})
    public String translate(@RequestParam String query){
        String translate = userService.translate(query);
        return translate;
    }

}
