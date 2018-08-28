package com.cyh.ums.serviceImp;

import com.cyh.ums.dao.TUserMapper;
import com.cyh.ums.domain.TUser;
import com.cyh.ums.serviceI.UserService;
import com.cyh.ums.util.Constant;
import com.cyh.ums.util.MD5Utils;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private TUserMapper userMapper;



    @Override
    public String translate(String query) {
        boolean matches = query.matches("[\\u4e00-\\u9fa5]");
        String from=matches?"en":"zh";
        String to=matches?"zh":"en";
        long salt = ThreadLocalRandom.current().nextLong();
        String sign = MD5Utils.encodeNew(Constant.APPID + query + salt + Constant.ENCRYPTION_KEY);
        try {
            String url = String.format("http://api.fanyi.baidu.com/api/trans/" +
                    "vip/translate?q=%1s&from=%2s&to=%3s&appid=%4s&salt=%5d&sign=%6s",
                    URLEncoder.encode(query,"utf-8"),from,to, Constant.APPID,salt,sign).replace(" ","");
            OkHttpClient okHttpClient=new OkHttpClient();
            Request builder = new Request.Builder().url(url).get().build();
            Response execute = okHttpClient.newCall(builder).execute();
            if(execute.isSuccessful()){
                ResponseBody body = execute.body();
                String string = body.string();
               return string;
            }
        }catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return query;
    }

    @Override
    @Cacheable(key = "'user_email_'+#email",value = "user" ,unless = "#result==null")
    public TUser findByEmail(String email) {
        Assert.notNull(email,"Email不能为空！");
        TUser tuser=new TUser();
        tuser.setEmail(email);
        TUser byEmail = userMapper.findByEmail(tuser);
        return byEmail;
    }
}
