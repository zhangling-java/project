package com.ccydsz.ysec.obd;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//Filter功能
//
//        在HttpServletRequest到达 Servlet 之前，拦截客户的HttpServletRequest 。根据需要检查HttpServletRequest，也可以修改HttpServletRequest 头和数据。
//        在HttpServletResponse到达客户端之前，拦截HttpServletResponse 。根据需要检查HttpServletResponse，也可以修改HttpServletResponse头和数据。


//Filter接口中有一个doFilter方法，当开发人员编写好Filter，并配置对哪个web资源进行拦截后，Web服务器每次在调用web资源的service方法之前，都会先调用一下filter的doFilter方法，因此，在该方法内编写代码可达到如下目的：
//
//        调用目标资源之前，让一段代码执行。
//        是否调用目标资源（即是否让用户访问web资源）。
//        web服务器在调用doFilter方法时，会传递一个filterChain对象进来，filterChain对象是filter接口中最重要的一个对象，它也提供了一个doFilter方法，开发人员可以根据需求决定是否调用此方法，调用该方法，则web服务器就会调用web资源的service方法，即web资源就会被访问，否则web资源不会被访问。

//1.过滤器是JavaEE标准，采用函数回调的方式进行。是在请求进入容器之后，还未进入Servlet之前进行预处理，并且在请求结束返回给前端这之间进行后期处理。

@WebFilter(filterName="ApplicationFilter",urlPatterns={"/*"})
public class ApplicationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("ApplicationFilter: doFilter");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

