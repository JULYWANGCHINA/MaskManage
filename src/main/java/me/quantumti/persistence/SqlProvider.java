package me.quantumti.persistence;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * <p>Title: SqlProvider</p>
 * <p>Description: 动态生成SQL</p>
 */
public class SqlProvider {

    /**
     * <p>Title: generatePageSql</p>
     * <p>Description: 根据数据库类型生成分页SQL</p>
     * @param sql 原始SQL
     * @param page 分页对象
     * @return String
     */
	protected String generatePageSql(String sql, Object beginNum, Object endNum) {
//		String dialect = PropertiesUtils.getDialect();
		String dialect = "mysql";
		if (beginNum != null && dialect != null) {
			StringBuffer pageSql = new StringBuffer();
			sql = sql.trim();
			if ("mysql".equals(dialect)) {
				if((Integer)beginNum > 0)
					beginNum = (Integer)beginNum-1;
				int pageSize = 0;
				if(endNum!=null){
					pageSize = (Integer)endNum - (Integer)beginNum;
				}
				if(pageSize<=0){
					pageSize = 20;
				}
				pageSql.append(sql);
				pageSql.append(" limit " + beginNum + "," + pageSize);
			} else if ("oracle".equals(dialect)) {
				pageSql.append("select * from ( select row_.*, rownum rownum_ from ( ");
				pageSql.append(sql);
				pageSql.append(" ) row_ ) where rownum_ >= ");
				pageSql.append(beginNum);
				pageSql.append(" and rownum_ <= ");
				pageSql.append(endNum);
			} else if ("mssqlserver58".equals(dialect)) {
				int endnum = (Integer)endNum;
				String order = "";
				pageSql.append(
						"select * from (select row_number()over(order by tempcolumn)temprownumber,* ")
						.append(" from (select top ")
						.append(endnum)
						.append(" tempcolumn=0,* from ( ");
				// 暂不支持多排序结果合并查询【order by后面的排序字段不要加表(别)名前缀】
				// 判断是否order....结尾, 分页中排序需要拆分sql
				Pattern p = Pattern.compile("\t|\r|\n");
				Matcher m = p.matcher(sql);
				sql = m.replaceAll(" ");
				if (sql.toLowerCase().matches(".+order[^)]+$")) {
					order = sql.substring(sql.toLowerCase().lastIndexOf("order"));
					sql = sql.substring(0, sql.toLowerCase().lastIndexOf("order"));
				}
				
				pageSql.append(sql);
				pageSql.append(" ) d ").append(order)
						.append(" ) t )tt where temprownumber>=")
						.append(beginNum);
			}
			System.out.println("=============================================");
			System.out.println(pageSql.toString());
			return pageSql.toString();
		} else {
			return sql;
		}
	}


	

}
