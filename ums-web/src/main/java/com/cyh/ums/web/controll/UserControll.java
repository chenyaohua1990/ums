package com.cyh.ums.web.controll;

import com.alibaba.fastjson.JSON;
import com.cyh.ums.domain.TUser;
import com.cyh.ums.dto.Result;
import com.cyh.ums.serviceI.UserService;
import com.cyh.ums.util.MD5Utils;
import com.cyh.ums.validator.UserLoginCheck;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import javax.validation.Valid;
import java.util.Set;

@RestController
@Api(tags = {"用户接口类"})
@RequestMapping(value = "user")
public class UserControll {

    private static final Logger LOGGER= LoggerFactory.getLogger(UserControll.class);
    @Autowired
    private UserService userService;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @PostMapping(value = "login")
    @ApiOperation(value = "用户登录",tags = {"用户接口类"})
    public Result<String> login(@Validated(value = {UserLoginCheck.class}) @RequestBody TUser user){
        Result<String> result=new Result<>();
        try{
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken authenticationToken=new UsernamePasswordToken(user.getEmail(), user.getPassword());
            subject.login(authenticationToken);
            result.setData("SUCCESS");
        }catch (Exception e){
            result.setData("FAIL");
        }
        return   result;
    }

    @GetMapping(value = "translate")
    @ApiOperation(value = "翻译",tags = {"其他接口"})
    public String translate(@RequestParam String query){
        String translate = userService.translate(query);
        return translate;
    }

    @PostMapping(value = "createUser")
    @ApiOperation(value = "创建用户",tags = {"用户接口类"})
    public Boolean createUser(@Validated(value = {UserLoginCheck.class}) @RequestBody TUser user){
        TUser i=userService.createUser(user);
        return ObjectUtils.isEmpty(i);
    }
}
