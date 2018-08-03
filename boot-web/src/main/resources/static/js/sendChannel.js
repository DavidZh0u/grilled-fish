function page(pageNum) {

    //获取当前URL
    var local_url = document.location.href;
    //获取要取得的get参数位置
    var get = local_url.indexOf("num");
    if(get === -1){
        if(local_url.indexOf("?") === -1)
            local_url += "?num="+pageNum;
        else
            local_url += "&num="+pageNum;
    }
    else{
        local_url = local_url.slice(0, get) + "num=" + pageNum;
    }
    window.location.href=local_url;

}

/*弹出层*/
function popups(title,url,w,h){
    layer.open({
        type: 2,
        area: [w+'px', h +'px'],
        fix: false, //不固定
        shadeClose: false,
        shade:0.4,
        title: title,
        content: url
    });
}

var layer,form,$;
layui.use(['form', 'layer'], function () {
    $ = layui.jquery;
    form = layui.form;
    layer = layui.layer;

    form.verify({
        checkLength50: function(value){
            if(value.length>50){
                return '超过长度限制';
            }
        },
        name: function(value){
            if(value === '供应商名称'){
                return '请选择供应商名称';
            }
        },
        billingLength: function(value){
        if(value.length>3){
            return '超过长度限制';
        }
        if(!/^\d+$/.test(value)){
            return '格式不正确';
        }
    }
    });

    form.on("submit(query)", function () {
        top.layer.msg('数据提交中，请稍候', { icon: 16, time: false, shade: 0.8 });
    });

    form.on('submit(add)', function (data) {
        //弹出loading
        var loading = parent.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});

        $.post("/student/add", data.field, function (response) {
            parent.layer.close(loading);
            layer.alert(response, { closeBtn: 0, title: '消息', anim: 6, shadeClose: false}, function (index) {

                if (response === "添加成功") {
                    //刷新父页面
                    parent.location.reload();
                }else{
                    layer.close(index);
                }
            });
        });
        return false;
    });

    form.on('submit(update)', function (data) {
        //弹出loading
        var loading = parent.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});

        $.post("/student/edit", data.field, function (response) {
            parent.layer.close(loading);
            layer.alert(response, { closeBtn: 0, title: '消息', anim: 6, shadeClose: false}, function (index) {

                if (response === "更新成功") {
                    //刷新父页面
                    parent.location.reload();
                }else{
                    layer.close(index);
                }
            });
        });
        return false;
    });
});

/*用户-删除*/
function del(obj,id){
    layer.confirm('确认要删除吗？',function(){

        //弹出loading
        var index = layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});

        //发异步，把数据提交给后台
        $.post("/sendChannel-delete", {id:id}, function (data) {
            layer.close(index);
            //更新表单
            $(obj).parents("tr").remove();
            layer.msg(data,{icon:1,time:1000});
        });
    });
}

//获取url中的参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return decodeURI(r[2]); return null; //返回参数值
}

function load() {

    var render = false;

    if(getUrlParam('supplierName') != null){
        render = true;
        $("#supplierName").val(getUrlParam('supplierName'));
    }

    if(getUrlParam('smsChannelName') != null){
        render = true;
        $("#smsChannelName").val(getUrlParam('smsChannelName').replace(/\+/g, ' '));
    }

    if(render){
        form.render('select'); //刷新select选择框渲染
        top.layer.closeAll();
    }
}