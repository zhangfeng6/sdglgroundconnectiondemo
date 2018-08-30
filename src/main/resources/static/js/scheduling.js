function qiehuan(dd) {
    var a = $(dd).next().next();
    var b = $(a).is(":hidden") ? 0 : 1;
    if (b == 0) {
        $(dd).attr("src", "../images/up.PNG");
    } else {
        $(dd).attr("src", "../images/down.PNG");
    }
    $(a).slideToggle();

}

function xianlu(obj) {
    var text = $(obj).html();
    var name=$(obj).attr("name");
    var index=name.substring(1,2);
    if (text == "自行填写") {
        $(obj).parent().prev().html("<input type='text' name='d"+index+"template' class='layui-input'>");
        $(obj).html("选择模板");
    } else {
        $(obj).parent().prev().html("<select name='d"+index+"template' style='height: 35px;width:180px;' onchange='xianluchange(this)' lay-ignore>" +

            "</select>");
        $(obj).html("自行填写");
        gerresource();
    }

    layui.use(['form', 'layedit', 'laydate', 'element'], function () {
        var form = layui.form,
            layer = layui.layer,
            layedit = layui.layedit,
            element = layui.element,
            laydate = layui.laydate,
            a;
        element.render('test1');
        form.render(); //更新全部
        form.render('select'); //刷新select选择框渲染
    });
}

function shanchu(aa) {
    var a = $(aa).parent();
    a.remove();
}

function addss() {
    var fantype="fantype";
    var leng=$("div[name=xianlu]");
    var index=leng.length+1;
    var xlhtml=$("select[name=d1template]").html();
    var jiuhtml=$("select[name=d1hoteltype]").html();
    var jdhtml=$("select[name=d1scenicspot1]").html();
    var gwdhtml=$("select[name=d1shopping]").html();
    var fanhtml=$("select[name=d1wucan]").html();
    var a = "<div style='margin-bottom: 25px;width: 1090px' name='xianlu' ><input type='hidden' value='"+index+"'/><input type='image' src='/images/up.PNG' style='height: 30px;width: 35px;' id='toggle' onclick='qiehuan(this)'/>" +
        "<input type='image' id='sc'  src='/images/del.PNG' onclick='shanchu(this)'  style='display:inline-block;height: 30px;width: 35px;margin-left:1065px ;' />" +
        "<div id='content'>" +
        "<form class='layui-form layui-form-pane' action=''>" +
        "<table border='0'  cellspacing='0' cellpadding='0' >" +
        "<tr>" +
        "	<td><label class='layui-form-label'>线路</label></td>" +
        "	<td>" +
        "	<select name='d"+index+"template' style='height: 35px;width:180px;' onchange='xianluchange(this)' lay-ignore>" +
        ""+xlhtml+"</select>" +
        "	</td>" +
        "	<td colspan='2'>&nbsp;<button type='button' name='d"+index+"qiehuan' class='layui-btn layui-btn-normal layui-btn-radius' style='height: 30px;width: 100px;' onclick='xianlu(this)'>自行填写</button></td>" +
        "	</tr>" +
        "<tr>" +
        "<td><label class='layui-form-label'>日期</label></td>" +
        "<td>" +
        "<input type='text' name='d"+index+"data' class='layui-input'>" +
        "</td>" +
        "</tr>" +
        "	<tr>" +
        "	<td><label class='layui-form-label'>酒店</label></td>" +
        "	<td>" +
        "	<select name='d"+index+"hoteltype' style='height: 35px;width:180px;' onchange='typechange(this,'hoteltype')' lay-ignore>" +
        ""+jiuhtml+"</select>" +
        "</td>" +
        "<td>" +
        "<select name='d"+index+"hotel' onchange='emptynum(this)' style='height: 35px;width:180px;' lay-ignore>" +
        "	<option value='0'selected='selected'>--请选择酒店房间类型--</option>" +
        "	</select>" +
        "	</td>" +
        "<td><label class='layui-form-label'>数量：</label></td>" +
        "<td><input type='text' name='d"+index+"num' onchange='sumchange(this)' class='layui-input'></td>" +
        "	<td><label class='layui-form-label'>成本价</label></td>" +
        "	<td><input name='d"+index+"jiucb'type='text' class='layui-input'></td>" +
        "<td style='width: 90px;padding-left: 5px;'>签单<input type='radio' value='签单' name='d"+index+"hotelpayment'></td>"+
        "<td style='width: 90px;'>付现<input type='radio' value='付现' name='d"+index+"hotelpayment'></td>"+
        "</tr>" +
        "<tr>" +
        "<td><label class='layui-form-label'>司陪：</label></td>" +
        "<td><label class='layui-form-label'  style='width: 140px;'>请输入房间数：</label></td>" +
        "<td><input name='d"+index+"spnum' type='text'onchange='sipeichange(this)' class='layui-input'></td>" +
        "<td><label class='layui-form-label'>成本价：</label></td>" +
        "<td><input name='d"+index+"spchengben' type='text' class='layui-input'></td>" +
        "</tr>" +
        "</tr>" +
        "<tr id='onClickjd' >" +
        "<td colspan='2'><button name='d"+index+"scenicspot' class='layui-btn' type='button' style='font-size:12px' onclick='add("+index+")'>添加景点+</button></td>" +
        "</tr>" +
        "<tr id='scenic' name='d"+index+"jingdian'>" +
        "<td><label class='layui-form-label'>景点</label></td>" +
        "<td>" +
        "<select name='d"+index+"scenicspot1' style='height: 35px;width:180px;' onchange='jdchange(this)' lay-ignore>" +

        ""+jdhtml+"</select>" +
        "</td>" +
        "<td><label class='layui-form-label' style='width: 200px;'>成本价:</label></td>" +
        "<td><input type='text' name='d"+index+"costprice1' class='layui-input'></td>" +
        "<td></td>"+
        "<td></td>"+
        "<td></td>"+
        "<td style='width: 90px;padding-left: 5px;'>签单<input type='radio' value='签单' name='d"+index+"jingdpayment1'></td>"+
        "<td style='width: 90px;'>付现<input type='radio' value='付现' name='d"+index+"jingdpayment1'></td>"+
        "</tr>" +
        "<tr name='d"+index+"gouwudi'>" +
        "<td><label class='layui-form-label'>购物地：</label></td>" +
        "<td colspan='3'>" +
        "<select name='d"+index+"shopping' style='height: 35px;width:180px;' lay-ignore>" +
        ""+gwdhtml+"</select>" +
        "</td>" +
        "	</tr>" +
        "<tr>" +
        "<td><label class='layui-form-label'>午餐</label></td>" +
        "	<td>" +
        "<select name='d"+index+"wucan' style='height: 35px;width:180px;' onchange=\"typechange(this,'fantype')\" lay-ignore>" +
        ""+fanhtml+"</select>" +
        "	</td>" +
        "<td>" +
        "<select name='d"+index+"wufan' style='height: 35px;width:180px;' onchange='jdchange(this)' lay-ignore>" +
        "<option value='0'>--请选择饭店类型--</option>"+
        "</select>" +
        "	</td>" +
        "	<td><label class='layui-form-label'>成本价</label></td>" +
        "	<td colspan='3'><input type='text' name='d"+index+"wucancb' class='layui-input'></td>" +
        "<td style='width: 90px;padding-left: 5px;'>签单<input type='radio' value='签单' name='d"+index+"wucanpayment'></td>"+
        "<td style='width: 90px;'>付现<input type='radio' value='付现' name='d"+index+"wucanpayment'></td>"+
        "</tr>" +
        "	<tr>" +
        "<td><label class='layui-form-label'>晚餐</label></td>" +
        "<td>" +
        "	<select name='d"+index+"wancan' style='height: 35px;width:180px;' onchange=\"typechange(this,'fantype')\" lay-ignore>" +
        ""+fanhtml+"</select>" +
        "	</td>" +
        "	<td>" +
        "<select name='d"+index+"wanfan' style='height: 35px;width:180px;' onchange='jdchange(this)' lay-ignore>" +
        "<option value='0'>--请选择饭店类型--</option>"+
        "</select>" +
        "</td>" +
        "<td><label class='layui-form-label'>成本价</label></td>" +
        "	<td colspan='3'><input type='text' name='d"+index+"wancancb' class='layui-input'></td>" +
        "<td style='width: 90px;padding-left: 5px;'>签单<input type='radio' value='签单' name='d"+index+"wancanpayment'></td>"+
        "<td style='width: 90px;'>付现<input type='radio' value='付现' name='d"+index+"wancanpayment'></td>"+
        "	</tr>" +
        "	<tr>" +
        "	<td><label class='layui-form-label'>行程</label></td>" +
        "	<td colspan='5'> <textarea placeholder='请输入内容' class='layui-textarea' name='d"+index+"xingcheng'></textarea></td>" +
        "	</tr>" +
        "</table>	" +
        "	</form></div></div> <br />";
    $("#zong").append(a);

    layui.use(['form', 'layedit', 'laydate', 'element'], function () {
        var form = layui.form,
            layer = layui.layer,
            layedit = layui.layedit,
            element = layui.element,
            laydate = layui.laydate,
            a;
        element.render('test1');
        form.render(); //更新全部
        form.render('select'); //刷新select选择框渲染;
        form.on('radio(filter)', function (data) {
            console.log(data.elem); //得到radio原始DOM对象
            console.log(data.value); //被点击的radio的value值
        });
    });

    var b = $("#add");
    b.remove();
    var f = "<button class='layui-btn layui-btn-normal layui-btn-radius' onclick='addss()' id='add'>十</button>";
    $("#zong").append(f);
}

function addjd(obj) {
    var jd = $(obj).prev().val();
    alert(jd);
    var textar = $(obj).next().html();
    $(obj).next().html(textar + jd + ",");
}

function deljd(obj) {
    $(obj).parent().prev().html("<textarea placeholder='请输入内容' class='layui-textarea' name='desc'>");
}
