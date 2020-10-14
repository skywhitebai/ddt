(function($) {
	
	var printAreaCount = 0;
	var removePrintArea = function(id) {
		$("iframe#" + id).remove();
	};
	
	$.fn.printArea = function() {
		var ele = $(this);
		var idPrefix = "printArea_";
		removePrintArea(idPrefix + printAreaCount);
		
		printAreaCount++;
		var iframeId = idPrefix + printAreaCount;
		var iframeStyle = 'position:absolute;width:0px;height:0px;left:-500px;top:-500px;';
		iframe = document.createElement('IFRAME');
		$(iframe).attr({
			style: iframeStyle,
			id: iframeId
		});
		
		// 把iframe放到body中
		document.body.appendChild(iframe);
		
		// 获取iframe的document的属性
		var doc = iframe.contentWindow.document;
		doc.open(); // 开启
		
		// 获取当前窗口的css文件并引入到iframe中
		$(document).find("link").filter(function() {
			return $(this).attr("rel").toLowerCase() == "stylesheet";
		}).each(function() {
				doc.write('<link type="text/css" rel="stylesheet" href="' +
					$(this).attr("href") + '" >');
		});
		
		// 展示要打印的内容
		doc.write('<div class="' + $(ele).attr("class") + '">' + $(ele).html() +
			'</div>');
			
		doc.close(); // 关闭
		
		var frameWindow = iframe.contentWindow;
		frameWindow.close();
		frameWindow.focus();
		frameWindow.print();
	}
	
	
})(jQuery);
