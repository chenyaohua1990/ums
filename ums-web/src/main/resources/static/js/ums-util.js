/*
字符串格式化
 */
String.prototype.format=function(args) {
    var result = this;
    if (arguments.length > 0) {
        if (arguments.length == 1 && typeof (args) == "object") {
            for (var key in args) {
                if(args[key]!=undefined){
                    var reg = new RegExp("({" + key + "})", "g");
                    result = result.replace(reg, args[key]);
                }
            }
        }
        else {
            for (var i = 0; i < arguments.length; i++) {
                if (arguments[i] != undefined) {
                    var reg= new RegExp("({)" + i + "(})", "g");
                    result = result.replace(reg, arguments[i]);
                }
            }
        }
    }
    return result;
};

Date.prototype.format = function(fmt){
    var o = {
        "M+" : this.getMonth()+1,                 //月份
        "d+" : this.getDate(),                    //日
        "h+" : this.getHours(),                   //小时
        "m+" : this.getMinutes(),                 //分
        "s+" : this.getSeconds(),                 //秒
        "q+" : Math.floor((this.getMonth()+3)/3), //季度
        "S"  : this.getMilliseconds()             //毫秒
    };
    if(/(y+)/.test(fmt))
        fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
        if(new RegExp("("+ k +")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    return fmt;
};



function ums(){
    /**
     * 初始化页面加载参数
     */
    this.init=function(){

        this.userAllAuthorize();
        /**
         * 权限扫描
         */
        setTimeout(function () {
            $("[shiroPermission]").each(function (x,sl) {
                var $sl=$(el);
                var key=$sl.attr("shiroPermission");
                if(sessionStorage.getItem(key)){
                    $sl.addClass("text-hide");
                }
            })
        },500);
        this.i18nAllParam();
        /**
        国际化扫描
         */
        setTimeout(function () {
            $("[i18n]").each(function (x,sl) {
                var $sl=$(el);
                var key=$sl.attr("i18n");
                if($sl.tagName="INPUT"){
                    $sl.val(localStorage.getItem(key));
                }else {
                    $sl.html(localStorage.getItem(key));
                }
            })
        },500);
    }
    /**
     *
     * @param id    标签选择器
     * @returns {Object}    参数对象
     */
    this.serializeObject=function(select) {
        var ar=$(select).serializeArray();
        var param=new Object();
        if(!ar || ar.length==0){
            return param;
        }
        for(var i=0;i<ar.length;i++){
            param[ar[i].name]=ar[i].value;
        }
        return param;
    }

    /**
     *
     * @param url
     * @param data
     * @param fun   回调函数
     * @constructor
     */
    this.PUT=function(url,data,callback){
        $.ajax({
            url:url,
            data:JSON.stringify(data),
            dataType:'JSON',
            contentType:'application/json',
            type:'PUT',
            success:callback
        })
    }

    this.POST=function(url,data,callback){
        $.ajax({
            url:url,
            data:JSON.stringify(data),
            dataType:'JSON',
            contentType:'application/json',
            type:'POST',
            success:callback
        })
    }

    this.GET=function(url,data,callback){
        $.ajax({
            url:url,
            data:JSON.stringify(data),
            dataType:'JSON',
            contentType:'application/json',
            type:'GET',
            success:callback
        })
    }

    this.DELETE=function(url,data,callback){
        $.ajax({
            url:url,
            data:JSON.stringify(data),
            dataType:'JSON',
            contentType:'application/json',
            type:'DELETE',
            success:callback
        })
    }
    /**
     * 获取服务器地址
     * @returns {string}
     */
    this.basePath=function () {
        var loction = document.location;
        var href = loction.origin;
        var pathname = loction.pathname;
        var split = pathname.split("/");
        var s =href+'/'+split[1]+"/";
        return  s ;
    }
    this.lookup=function(){

    }

    this.i18nAllParam=function () {
        $.ajax({
            url:this.basePath()+"i18n",
            async:true,
            type:'GET',
            success:function(req){
                if(req && req.length>0){
                    req.forEach(function (t, number) {
                        localStorage.setItem(t.key,t.value);
                    })
                }
            }
        })
    }
    /**
     * 获取国际化参数
     * @param key
     */
    this.i18n=function(key){
        return localStorage.getItem(key);
    }
    /**
     * 检查shiro授权
     */
    this.checkShiroAuthorize=function () {

        return false;
    }
    /**
     * 获取用户全部权限
     */
    this.userAllAuthorize=function () {

    }

};


var UMS=new ums();

UMS.init();