/**
 * 专门给主页用的js
 */

/**
 * 统一调用需要执行的方法
 */
initSort();

/**
 * 使用Ajax 初始化分类列表
 */

function initSort(){
	$.ajax({
		url:'/api/goodsSort/getParent',   //获取分类信息
		type:'get',
		data:{},
		dataType:'json',
		success: function(data){
			var html ="";
			$.each(data,function(index,item){
				if(index>=10) return false;  //最多只能显示10条
				html += '<li><a href="javascript:;">'+item.name+'<i class="mi-icon icon-right"></i></a>'
				var width = parseInt((item.sonSorts.length+5/6) * 248)
						width = width>(4*248)?4*248:width;
				html += '<div class="children" style="width:'+width+'px;"><ul class="left">';
				
				//生成二级分类，遍历它的二级分类
				$.each(item.sonSorts,function(i,son){
					html += '<li><a href="/search?goodsSortId='+son.id+'">\
							<img src="upload/'+son.picture+'" >\
							<span>'+son.name+'</span>\
							</a></li>';
					if(i>=23){
						return false; 
					}
					
					if((i+1)%6==0){
						html += '</ul>';
						html += '<ul class="left">';
					}					
				})
				
				html +='</ul></div>';
				html += '</li>';

			});
			$(".goods-sorts>ul").html(html);
		},
		error: function(){
			
		}
	});
	
}