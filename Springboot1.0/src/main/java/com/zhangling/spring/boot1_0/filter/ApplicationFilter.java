package com.zhangling.spring.boot1_0.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*过滤器放在web资源之前，可以在请求抵达它所应用的web资源(可以是一个Servlet、一个Jsp页面，甚至是一个HTML页面)之前截获进入的请求，并且在它返回到客户之前截获输出请求。
 Filter：用来拦截请求，处于客户端与被请求资源之间，目的是重用代码。Filter链，在web.xml中哪个先配置，哪个就先调用。在filter中也可以配置一些初始化参数。

 依赖于servlet容器,是JavaEE标准,是在请求进入容器之后，还未进入Servlet之前进行预处理，并且在请求结束返回给前端这之间进行后期处理。在实现上基于函数回调，可以对几乎所有请求进行过滤，
 但是缺点是一个过滤器实例只能在容器初始化时调用一次。使用过滤器的目的是用来做一些过滤操作，获取我们想要获取的数据，比如：在过滤器中修改字符编码；在过滤器中修改HttpServletRequest的一些参数，包括：过滤低俗文字、危险字符等

 在spring boot中的FilterRegistrationBean注册过滤器的类中有个order属性，
 private int order = Ordered.LOWEST_PRECEDENCE;
 细看源码可以知道，这个order的默认值是Integer.MAX_VALUE 也就是int的最大值，
 spring boot 会按照order值的大小，从小到大的顺序来依次过滤。

 */

@WebFilter(filterName="ApplicationFilter",urlPatterns={"/*"})
public class ApplicationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行了ApplicationFilter的init()方法...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("执行了ApplicationFilter的doFilter()方法...");
        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        System.out.println("执行了ApplicationFilter的destroy()方法...");
    }


//    /**
//     * 配置过滤器
//     * @return
//     */
//    @Bean
//    @Order(value = Integer.MAX_VALUE)
//    public FilterRegistrationBean someFilterRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(applicationFilter());
//        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("applicationFilter");
//        return registration;
//    }
//
//    /**
//     * 创建一个bean
//     * @return
//     */
//    @Bean(name = "applicationFilter")
//    public Filter applicationFilter() {
//        return new ApplicationFilter();
//    }


}
