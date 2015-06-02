package me.quantumti.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import me.quantumti.common.Page;

//定义一个标签处理类
public class PageAccess extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 分页对象名称
	 */
	private Page<?> pageObject;
	/**
	 * 获取分页对象方法名称
	 */
	private String pageFunction;
	/**
	 * 分页信息元素ID前缀
	 */
	private String prefix;

	@Override
	public int doEndTag() throws JspException {
		JspWriter out = pageContext.getOut();
		// 系统设置对象
		try {
			out.print("<table width=\"100%\" style=\"font-size:13px\"><tr>");
			out.print("<td align=\"left\">");
			// 分页信息
			out.print("当前&nbsp;<font id=\""
					+ prefix
					+ "_pageNum\" >"+pageObject.getPageNum()+"</font>&nbsp;页&nbsp;/&nbsp;共&nbsp;<font id=\""
					+ prefix + "_pageSum\">"+pageObject.getPageSum()+"</font>&nbsp;页&nbsp;&nbsp;");
			// 每页多少条数据
			out.print("每页&nbsp;");
			out.print("<input id=\""
					+ prefix
					+ "_pageSize\" name=\""
					+ prefix
					+ ".pageSize\" value=\""
					+ pageObject.getPageSize()
					+ "\" maxlength=\"9\" onkeydown=\"javascript:if (13==event.keyCode) "
					+ pageFunction + "(1"//" + pageObject.getPageNum()
					+ ");\" title=\"输入数字，回车跳转\" style=\"width:30px\"/>");
			out.print("&nbsp;条&nbsp;&nbsp;");
			// 分页信息
			out.print("共有&nbsp;<font id=\"" + prefix
					+ "_dataSum\">"+pageObject.getDataSum()+"</font>&nbsp;条记录&nbsp;&nbsp;");
			out.print("</td>");
			/* 右边部分 */
			out.print("<td align=\"right\">");
			// 首页page
			out.print("<a href=\"javascript:" + pageFunction
					+ "(1);\">首页</a>&nbsp;");
			int pn = 0;
			// 上一页
			pn = pageObject.getPageNum() - 1;
			pn = pn < 1 ? 1 : pn ;
			out.print("<a href=\"javascript:" + pageFunction + "(" + pn
					+ ");\">上一页</a>&nbsp;");
			// 下一页
			pn = pageObject.getPageNum() + 1;
			pn = pn > pageObject.getPageSum() ? pageObject.getPageSum() : pn ;
			out.print("<a href=\"javascript:" + pageFunction + "(" + pn
					+ ");\">下一页</a>&nbsp;");
			// 尾页
			out.print("<a href=\"javascript:" + pageFunction + "(" + pageObject.getPageSum()
					+ ");\">尾页</a>&nbsp;");
			// 跳转文本框
			out.print("到第&nbsp;<input id=\""
					+ prefix
					+ "_pageNumText\" name=\""
					+ prefix
					+ ".pageNum\"  value=\""
					+ pageObject.getPageNum()
					+ "\" maxlength=\"9\" onkeydown=\"javascript:if(13==event.keyCode) "
					+ pageFunction
					+ "(this.value);\" title=\"输入数字，回车跳转\" style=\"width:30px\"/>&nbsp;页");

			out.print("</td>");
			out.print("</tr></table>");

			out.print("<script type=\"text/javascript\">");
			// 设置文本框只能输入数字
			out.print("$(\"#"
					+ prefix
					+ "_pageNumText\").keyup(function(){$(this).val($(this).val().replace(/\\D|^0/g,''));})"
					+ ".bind(\"paste\",function(){$(this).val($(this).val().replace(/\\D|^0/g,''));}).css(\"ime-mode\",\"disabled\");");

			out.print("$(\"#"
					+ prefix
					+ "_pageSize\").keyup(function(){$(this).val($(this).val().replace(/\\D|^0/g,''));})"
					+ ".bind(\"paste\",function(){$(this).val($(this).val().replace(/\\D|^0/g,''));}).css(\"ime-mode\",\"disabled\");");

			out.print("</script>");
		} catch (Exception e) {
			throw new JspException(e);
		}
		return super.doEndTag();
	}
	
	
	public String getPageFunction() {
		return pageFunction;
	}

	public void setPageFunction(String pageFunction) {
		this.pageFunction = pageFunction;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	private String pageSize;
	private String pageNum;

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public Page<?> getPageObject() {
		return pageObject;
	}

	public void setPageObject(Page<?> pageObject) {
		this.pageObject = pageObject;
	}
}
