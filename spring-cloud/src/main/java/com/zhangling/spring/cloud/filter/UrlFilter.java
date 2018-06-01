package com.zhangling.spring.cloud.filter;

import com.zhangling.spring.cloud.util.LogUtil;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Order(value = Integer.MIN_VALUE)
public class UrlFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LogUtil.printLog("UrlFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
