(function () {
    /**
     * 语言下拉菜单
     */
    var languageType=UMS.lookup("LANGUAGE_TYPE");
    if(languageType){
        //设置默认值
        $("#login-languageType").attr("data-option",JSON.stringify(languageType[0]));
        $(".btn.btn-primary.dropdown-toggle").html(languageType[0].lookupItemName);
        UMS.setCookie("languageType",languageType[0].lookupItemCode);

        var html="";
        $.each(languageType,function (i,data) {
            html+="<a class='dropdown-item' data-option='{0}'>{1}</a>".format(JSON.stringify(data),data.lookupItemName);
        });
        $("#login-languageType").html(html);
        /**
         * 绑定事件
         */
        $(".dropdown-item").click(function (e) {
            var $ele=$(this);
            var val =JSON.parse($ele.attr("data-option")) ;
            $("#login-languageType").attr("data-option",$ele.attr("data-option"))
            $(".btn.btn-primary.dropdown-toggle").html(val.lookupItemName)
            UMS.setCookie("languageType",val.lookupItemCode);

        })
    }

    /**
     * 登录方法
     */
   $("#btn-login").on("click",function (e) {
       var user = UMS.serializeObject("#user-login-form");

       if(!user.email || !user.email.trim()){
           $("#user-login-email-check").html("Email不能是空或空字符");
           $("#user-login-email-check").removeClass("text-hide");
           return;
       }else {
           var isExsit=$("#user-login-email-check").hasClass("text-hide");
           isExsit || $("#user-login-email-check").addClass("text-hide");
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

       UMS.POST(UMS.basePath()+"user/login",user,function (req) {
           if(req && req.status===0 && req.data==='SUCCESS'){
               window.location='./index.html';
           }
       })

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