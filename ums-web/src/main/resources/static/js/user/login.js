(function () {
    /**
     * 登录方法
     */
   $("#btn-login").on("click",function (e) {
       var user = UMS.serializeObject("#user-login-form");

       if(!user.name || !user.name.trim()){
           $("#user-login-name-check").html("用户名不能是空或空字符");
           $("#user-login-name-check").removeClass("text-hide");
           return;
       }else {
           var isExsit=$("#user-login-name-check").hasClass("text-hide");
           isExsit || $("#user-login-name-check").addClass("text-hide");
       }

       if(!user.password || !user.password.trim()){
           $("#user-login-password-check").html("密码不能是空或空字符");
           $("#user-login-password-check").removeClass("text-hide");
           return;
       }

       if(user.password.length<6){
           $("#user-login-password-check").html("密码长度不能小于6");
           $("#user-login-password-check").removeClass("text-hide");
           return;
       }else{
           var isExsit=$("#user-login-password-check").hasClass("text-hide");
           isExsit || $("#user-login-password-check").addClass("text-hide");
       }

       $.post("../,,/user/login",user,function (req) {
            if(req && req.status===0){
                window.location='./index.html';
            }
       },"JSON")
   });
    /**
     * 清空
     */
   $("#btn-reset").on("click",function (e) {
        $("input").each(function (i,ele) {
            $(ele).val('');
        })
    });
})();