package com.aa.soft.childrenspictures.auth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * @author Anjum Abbas
 * @version 1.0
 */
public class APIKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter
{

  private String principalRequestHeader;

  public APIKeyAuthFilter(String principalRequestHeader) {
    this.principalRequestHeader = principalRequestHeader;
  }

  @Override
  protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
    return request.getHeader(principalRequestHeader);
  }

  @Override
  protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
    return "N/A";
  }

}
