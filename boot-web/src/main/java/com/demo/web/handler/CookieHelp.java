package com.demo.web.handler;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHelp {

    /**
     * 添加Cookie
     * @param response 响应内容
     * @param name cookie键
     * @param value cookie值
     */
    public static void addCookie(HttpServletResponse response, String name, Object value){
        Cookie cookie = new Cookie(name.trim(), value.toString().trim());
        // 设置为2小时
        cookie.setMaxAge(2 * 60 * 60);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    /**
     * 查询Cookie
     * @param request 请求内容
     * @param name cookie键
     * @return cookie值
     */
    public static String getCookieByName(HttpServletRequest request, String name){

        String value = null;
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    value = cookie.getValue();
                    break;
                }
            }
        }
        return value;
    }

    /**
     * 删除Cookie
     * @param request 请求内容
     * @param response 响应内容
     * @param name cookie键
     */
    public static void delCookie(HttpServletRequest request,HttpServletResponse response,String name){

        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    cookie.setValue(null);
                    // 立即销毁cookie
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }

}