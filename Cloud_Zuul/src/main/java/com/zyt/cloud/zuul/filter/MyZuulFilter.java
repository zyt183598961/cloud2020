package com.zyt.cloud.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.zyt.common.vo.R;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class MyZuulFilter extends ZuulFilter {

    /**
     * 1.过滤器类型 取值如下：
     * PRE 预处理 前置过滤器
     * ROUTING 处理中 正在执行
     * POST  请求结束 后置过滤
     * ERROR 错误过滤 一般用于收集错误信息
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器排序  值越小  数据约靠前    1开始
     *
     * @return int
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否启用
     *
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤处理
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest req = requestContext.getRequest();
        if (!req.getParameterMap().containsKey("mustParameter")) {
            requestContext.setResponseStatusCode(HttpServletResponse.SC_BAD_REQUEST);
            requestContext.setSendZuulResponse(false);
            HttpServletResponse resp = requestContext.getResponse();
            resp.setContentType("application/json;charset=UTF-8");
            try {
                resp.getWriter().println(R.fail("缺少必带参数"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
