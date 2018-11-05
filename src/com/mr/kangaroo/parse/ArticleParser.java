package com.mr.kangaroo.parse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mr.kangaroo.utils.JDBCUtils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author daisy
 * @desc
 * @create 2018/7/14
 */
public class ArticleParser {

    private final static String regex = "<a.*?>*?</a>";
    private final static String insert_article_sql = "insert into article (theme,title,content) values (?,?,?)";
    private final static String insert_article_comment_sql = "insert into article_comment (theme,content,replies) values (?,?,?)";
    private final static String select_id = "select id from article where title = ?";
    private final static String select_content = "select content from article where title = ?";
    private final static String sql1 = "insert into ref_article (article_id,ref_title,ref_link) values (?,?,?)";

    private final static String theme = "左耳听风";
    private final static String theme1 = "从0开始学架构";
    private final static String theme2 = "网络协议";
    private final static String theme3 = "JAVA36讲";
    private final static String theme4 = "深入Java虚拟机";
    private final static String theme5 = "设计秒杀系统";

    // 文章内容
    private final static String acticleContent = "";

    // 文章品论
    private final static String acticleComment = "";

    public static String parse() {
        JSONObject jsonObject = (JSONObject) JSON.parse(acticleContent);
        JSONObject data = (JSONObject) jsonObject.get("data");
        String title = data.get("article_sharetitle").toString();
        String content = data.get("article_content").toString();
        saveArticle(insert_article_sql, theme5, title, content);
        parseTagA(content, title);
        return content;
    }

    public static void parseTagA(String articleContent, String title) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(articleContent);
        int articleId = select(select_id, title);
        while (matcher.find()) {
            String aTag = matcher.group();
            String link = aTag.substring(aTag.indexOf("href=\"") + 6, aTag.indexOf("\">"));
            String title1 = aTag.substring(aTag.indexOf("\">") + 2, aTag.indexOf("</"));

            try {
                saveRefArticle(sql1, articleId, title1, link);
            } catch (Exception e) {
                System.out.println("link is dup");
            }
        }
    }

    public static void parseAndSaveComment(String articleComment, String theme) {
        JSONObject articleCommentResp = JSONObject.parseObject(articleComment);
        JSONArray jsonArray = JSONArray.parseArray(articleCommentResp.getJSONObject("data").getString("list"));
        if (!jsonArray.isEmpty()) {
            jsonArray.forEach(json -> {
                String commentContent = ((JSONObject) json).getString("comment_content");
                String replies = "";
                JSONArray replyArray = JSONArray.parseArray(((JSONObject) json).getString("replies"));

                if(replyArray!= null && !replyArray.isEmpty()){
                    replies = ((JSONObject)replyArray.get(0)).getString("content");
                }
                commentContent = commentContent.replaceAll("[^\\u0000-\\uFFFF]", "");
                replies = replies.replaceAll("[^\\u0000-\\uFFFF]", "");
                saveArticleComment(insert_article_comment_sql, theme, commentContent, replies);
            });
        }
    }

    public static int saveArticle(String sql, String theme, String title, String content) {
        return JDBCUtils.update(sql, theme, title, content);
    }

    public static int saveRefArticle(String sql, int articleId, String title, String content) {
        return JDBCUtils.update(sql, articleId, title, content);
    }

    public static int saveArticleComment(String sql, String theme, String commentContent, String commentReplys) {
        int result = 0;
        try {
            result = JDBCUtils.update(sql, theme, commentContent, commentReplys);
        } catch (Exception e) {
            System.out.println(commentContent);
        }
        return result;
    }

    public static int select(String sql, String title) {
        Map<String, Object> map = JDBCUtils.queryForMap(sql, title);
        return (int) map.get("id");
    }

    public static String select_content(String sql, String title) {
        Map<String, Object> map = JDBCUtils.queryForMap(sql, title);
        return map.get("content").toString();
    }

    public static void main(String[] args) {
        // 解析保存文章内容
//        parse();
        // 解析保存文章评论
        parseAndSaveComment(acticleComment, theme5);
    }
}
