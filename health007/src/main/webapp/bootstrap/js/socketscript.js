$(document).ready(function () {
    //名單畫面下縮
//    $('.chat_head').click(function () {
//        $('.chat_body').slideToggle('slow');
//    });
	
	$('.chat_box').click(function(){
		$('.chat_box').hide(1000);
	});
	
    //聊天畫面下縮
    $('.msg_head').click(function () {
        $('.msg_wrap').slideToggle('slow');
    });
    //聊天畫面x
    $('.close').click(function () {
        $('.msg_box').hide(1000);
        $('.chat_box').show("slow");
    });
    //點使用者
    $('.chat_box').click(function () {
        $('.msg_wrap').show();
        $('.msg_box').show();
    });
    //輸入的
    $('textarea').keypress(function (e) {
        if (e.keyCode == 13) {  //keycode 13 = Enter
            e.preventDefault();
            var msg = $(this).val();
            $(this).val('');
            if (msg != '')  //無輸入不送出
            //$("<div class='msg_a'> " + msg + "</div>").insertBefore('.msg_insert');  //(插入的内容).insertBefore(插入的地方)
            $('.msg_body').scrollTop($('.msg_body')[0].scrollHeight);//scrollTop() 方法返回或设置匹配元素的滚动条的垂直位置。自動將聊天窗口的控制條移動到最下面
        }
    });
});