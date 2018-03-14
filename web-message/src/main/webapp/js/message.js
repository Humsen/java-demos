/**
 * @author 何明胜
 * 
 * 2017年9月25日
 */

$(function() {
	/*
	 * var oCmt = new Comment({ parent : $('#message_box'), // 你想要将这个评论放到页面哪个元素中
	 * id : 0, getCmtUrl : './php/getcomment.php', setCmtUrl :
	 * './php/comment.php' });
	 */

	Comment.allocate({
		parent : $('#message_box'),
		id : 0,
		getCmtUrl : './php/getcomment.php',
		setCmtUrl : './php/comment.php'
	})

});

function Comment(options) {
	this.belong = options.id;
	this.getCmtUrl = options.getCmtUrl;
	this.setCmtUrl = options.setCmtUrl;
	this.lists = [];
	this.keys = {};
	this.offset = 5;
}

var fn = Comment.prototype;

/**
 * 执行初始化
 */
Comment.allocate = function(options) {
	var oCmt = new Comment(options);
	if (oCmt.belong == undefined || !oCmt.getCmtUrl || !oCmt.setCmtUrl) {
		return null;
	}
	;
	oCmt.init(options);
	return oCmt;
};

/*
 * function Comment(options) { this.belong = options.id; this.getCmtUrl =
 * options.getCmtUrl; this.setCmtUrl = options.setCmtUrl; this.lists = [];
 * this.keys = {}; this.offset = 5; if (this.belong == undefined ||
 * !this.getCmtUrl || !this.setCmtUrl) { return null; } ; this.init(options) }
 */

/**
 * 初始化函数
 */
fn.init = function(options) {
	// 初始化node
	this.initNode(options);
	// 将内容放进容器
	this.parent.html(this.body);
	// 初始化事件
	this.initEvent();
	// 获取列表
	this.getList();
};

/**
 * 初始化结点或者缓存DOM
 */
fn.initNode = function(options) {
	// init wrapper box
	if (!!options.parent) {
		this.parent = options.parent[0].nodeType == 1 ? options.parent : $('#'
				+ options.parent);
	}

	if (!this.parent) {
		this.parent = $('div');
		$('body').append(this.parent);
	}

	// init content
	this.body = (function() {
		var strHTML = '<div class="m-comment">'
				+ '<div class="cmt-form">'
				+ '<textarea class="cmt-text" placeholder="欢迎建议，提问题，共同学习！"></textarea>'
				+ '<button class="u-button u-login-btn">提交评论</button>'
				+ '</div>' + '<div class="cmt-content">'
				+ '<div class="u-loading1"></div>'
				+ '<div class="no-cmt">暂时没有评论</div>'
				+ '<ul class="cmt-list"></ul>' + '<div class="f-clear">'
				+ '<div class="pager-box"></div>' + '</div>' + '</div>'
				+ '</div>';
		return $(strHTML);
	})();

	// init other node
	this.text = this.body.find('.cmt-text').eq(0);
	this.cmtBtn = this.body.find('.u-button').eq(0);
	this.noCmt = this.body.find('.no-cmt').eq(0);
	this.cmtList = this.body.find('.cmt-list').eq(0);
	this.loading = this.body.find('.u-loading1').eq(0);
	this.pagerBox = this.body.find('.pager-box').eq(0);
};

/**
 * 初始化列表
 */
fn.resetList = function() {
	this.loading.css('display', 'block')
	this.noCmt.css('display', 'none');
	this.cmtList.html('');
};

/**
 * ajax获取
 */
fn.getList = function() {

	var self = this;
	this.resetList();

	$.ajax({
		url : self.getCmtUrl,
		type : 'get',
		dataType : 'json',
		data : {
			id : self.belong
		},
		success : function(data) {
			if (!data) {
				alert('获取评论列表失败');
				return !1;
			}
			;
			// 整理评论列表
			self.initList(data);
			self.loading.css('display', 'none');
			// 显示评论列表
			if (self.lists.length == 0) {
				// 暂时没有评论
				self.noCmt.css('display', 'block');
			} else {
				// 设置分页器
				var total = Math.ceil(self.lists.length / self.offset);

				self.pager = new Pager({
					index : 1,
					total : total,
					parent : self.pagerBox[0],
					onchange : self.doChangePage.bind(self),
					label : {
						prev : '<',
						next : '>'
					}
				});

			}
		},
		error : function() {
			alert('获取评论列表失败');
		}
	});
};