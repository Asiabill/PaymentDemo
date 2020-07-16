package com.asiabill.common.utils;

import com.asiabill.common.bean.ConstantsBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author: Xiongyancong
 * @create: 2020-06-30 17:54
 */
@Slf4j
public class RedirectUtil {

    /**
     *
     * @param redirectUrl
     * @param params
     * @param request
     * @param response
     * @return
     */
    public static boolean redirectPayment(String redirectUrl, Map<String, String> params, HttpServletRequest request, HttpServletResponse response) {
        try {
            String html =getRedirect(params,redirectUrl);

            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();

            out.println(html);

            out.flush();
            out.close();
        } catch (IOException e) {
            log.error(StringHandleUtils.getExceptionInfo(e));
            return false;
        }
        return true;
    }

    /**
     * 跳转错误页面
     * @param code
     * @param msg
     * @param req
     * @param resp
     * @return
     */
    public static boolean redirectError(String code, String msg,
                                        HttpServletRequest req, HttpServletResponse resp) {

        try {
            String htm = getErrorHtml(code, msg, "developer@asiabill.com");

            resp.setContentType("text/html");
            resp.setCharacterEncoding("utf-8");
            PrintWriter out = resp.getWriter();

            out.println(htm);

            out.flush();
            out.close();
        } catch (IOException e) {
            log.error(StringHandleUtils.getExceptionInfo(e));
            return false;
        }catch (Exception e) {
            log.error(StringHandleUtils.getExceptionInfo(e));
            return false;
        }
        return true;
    }

    /**
     * 自动跳转页面
     * @param params
     * @param redirectUrl
     * @return
     */
    private static String getRedirect(Map<String, String> params, String redirectUrl) {
        StringBuffer htm = new StringBuffer();
        htm.append("<!DOCTYPE html>");
        htm.append("<html>");
        htm.append("<head>");
        htm.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        htm.append("<meta name=\"referrer\" content=\"no-referrer\">");
        htm.append("<body onload=\"setTimeout(function() {testForm.submit();})\">");
        htm.append("<form id=\"testForm\" name=\"testForm\" action=\"").append(redirectUrl).append("\" method=\"post\" >");
        for (Map.Entry<String, String> entry : params.entrySet()) {
            htm.append("<input type=\"hidden\" name=\"").append(entry.getKey()).append("\" value = \"").append(entry.getValue()).append("\" >");
        }
        htm.append("</body>");
        htm.append("</head>");
        htm.append("</html>");
        return htm.toString();
    }

    /**
     * 错误页面
     * @param code
     * @param msg
     * @param returnUrl
     * @return
     */
    private static String getErrorHtml(String code, String msg, String returnUrl) {
        StringBuffer htm = new StringBuffer();
        htm.append("<!DOCTYPE html>");
        htm.append("<html>");
        htm.append("<head>");
        htm.append("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />");
        htm.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0\">");
        htm.append("<title>Error page</title>");
        htm.append("<style>");
        htm.append("body{margin:0;padding:0}div{display:inline-block;height:auto;width:100%;box-sizing:border-box}.ui-wrap{position:relative;margin-top:10%}.ui-inner{position:absolute;min-width:320px;max-width:100%;width:auto;border-radius:4px;left:50%;top:50%;padding:15px;top:20%;transform:translateX(-50%);-moz-transform:translateX(-50%);-ms-transform:translateX(-50%);text-align:center;color:#f56c6c;word-break:break-word}.ui-error-sum{font-size:28px;font-weight:600;margin-bottom:15px;position:relative}.ui-error-icon{width:24px;height:24px;border-radius:50%;border:3px solid #f56c6c;font-size:20px;position:relative;color:#f56c6c;text-align:center;line-height:24px;font-weight:600;display:inline-block;margin-right:10px;bottom:3px}.ui-error-common{font-size:15px;color:#666}.ui-link-wrap{position:absolute;right:0;font-size:13px;text-decoration:none;bottom:-20px;color:#666}.ui-link{color:#0095ff}");
        htm.append("</style>");
        htm.append("<title>Error page</title>");
        htm.append("</head>");
        htm.append("<body >");

        //错误提示内容
        htm.append("<div class=\"ui-wrap\">");
        htm.append("<div class=\"ui-inner\">");
        htm.append("<div class=\"ui-error-sum\"><span class=\"ui-error-icon\">!</span> ERROR</div>");
        htm.append("<div class=\"ui-error-common\">");
        htm.append(code).append(" - ").append(msg);
        htm.append("</div>");

        //联系我们
        if(!StringUtils.isBlank(returnUrl)) {
            htm.append("<div class=\"ui-link-wrap\">For further assistance, please contact our technical support team at ");
            htm.append("<a href=\"mailto:").append(returnUrl).append("\" class=\"ui-link\" target=\"_blank\">").append(returnUrl).append("</a>");
            htm.append("</div>");
        }

        htm.append("</div></div>");
        htm.append("</body>");
        htm.append("</html>");

        return htm.toString();
    }

}
