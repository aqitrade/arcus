package com.aqitrade.arcus.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.aqitrade.arcus.core.context.UserContext;
import com.aqitrade.arcus.data.dto.UserDto;
import com.aqitrade.arcus.web.util.WebConstants;

@Component
public class AuthentictionHandlerInterceptor extends HandlerInterceptorAdapter {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    HttpSession session = request.getSession(false);
    if (session == null
        || session.getAttribute(WebConstants.SessionAttributes.USER.name()) == null) {
      response.getWriter().write("Unauthorized");
      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return false;
    } else {
      UserDto userDto = (UserDto) session.getAttribute(WebConstants.SessionAttributes.USER.name());
      UserContext userContext = new UserContext(userDto.getUserId(), userDto.getFirstName(),
          userDto.getLastName(), userDto.getPhoneNumber(), userDto.getEmailId());
      UserContext.set(userContext);
    }
    return super.preHandle(request, response, handler);
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    try {
      super.afterCompletion(request, response, handler, ex);
    } finally {
      cleanup();
    }
  }

  private void cleanup() {
    UserContext.remove();
  }
}
