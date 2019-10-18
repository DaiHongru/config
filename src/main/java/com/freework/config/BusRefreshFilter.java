package com.freework.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class BusRefreshFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String url = new String(httpServletRequest.getRequestURI());
        //只过滤/actuator/bus-refresh请求
        if (!url.endsWith("/bus-refresh")) {
            chain.doFilter(request, response);
            return;
        }
        CustometRequestWrapper requestWrapper = new CustometRequestWrapper(httpServletRequest);
        chain.doFilter(requestWrapper, response);
    }
}
