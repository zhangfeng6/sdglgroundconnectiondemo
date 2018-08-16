layui.use(['laypage', 'layer'], function(){
    var laypage = layui.laypage
        ,layer = layui.layer;
    //测试数据
    var data = [
        "<tr><td>1</td><td>途牛组团社</td><td>10</td><td>忻州</td><td>2017-02-02</td><td>2017-02-03</td><td>100</td><td>玩具</td><td><div class='layui-inline'><button class='layui-btn layui-btn-small layui-btn-normal add-btn' data-url='article-add.html'><i class='layui-icon'>&#xe654;</i></button><button class='layui-btn layui-btn-small layui-btn-normal go-btn' data-url='article-detail.html'><i class='layui-icon'>&#xe642;</i></button><button class='layui-btn layui-btn-small layui-btn-danger del-btn' data-id='1' data-url='article-detail.html'><i class='layui-icon'>&#xe640;</i></button></div></td></tr>","<tr><td>2</td><td>途牛组团社</td><td>10</td><td>忻州</td><td>2017-02-02</td><td>2017-02-03</td><td>100</td><td>玩具01</td><td><div class='layui-inline'><button class='layui-btn layui-btn-small layui-btn-normal add-btn' data-url='article-add.html'><i class='layui-icon'>&#xe654;</i></button><button class='layui-btn layui-btn-small layui-btn-normal go-btn' data-url='article-detail.html'><i class='layui-icon'>&#xe642;</i></button><button class='layui-btn layui-btn-small layui-btn-danger del-btn' data-id='1' data-url='article-detail.html'><i class='layui-icon'>&#xe640;</i></button></div></td></tr>"
    ];

    //调用分页
    laypage.render({
        elem: 'demo20'
        ,count: data.length
        ,limit: 1
        ,jump: function(obj){
            //模拟渲染
            document.getElementById('biuuu_city_list').innerHTML = function(){
                var arr = []
                    ,thisData = data.concat().splice(obj.curr*obj.limit - obj.limit, obj.limit);
                layui.each(thisData, function(index, item){
                    arr.push('<li>'+ item +'</li>');
                });
                return arr.join('');
            }();
        }
    });

});