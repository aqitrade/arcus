package com.aqitrade.arcus.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class SessionHandler extends HandlerInterceptorAdapter {

  @Value("${session.max.inactive.interval:3600}")
  private int maxInactiveInternval;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    request.getSession().setMaxInactiveInterval(maxInactiveInternval);
    return true;
  }
}
