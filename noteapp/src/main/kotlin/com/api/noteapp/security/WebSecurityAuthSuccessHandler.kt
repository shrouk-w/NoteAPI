package com.api.noteapp.security

import org.springframework.util.StringUtils
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.context.annotation.Bean
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler
import org.springframework.security.web.savedrequest.HttpSessionRequestCache
import org.springframework.stereotype.Component

@Component
class WebSecurityAuthSuccessHandler: SimpleUrlAuthenticationSuccessHandler() {

    var requestCache = HttpSessionRequestCache()

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication) {
        val saveRequest = requestCache.getRequest(request, response)
        if(saveRequest == null) {
            clearAuthenticationAttributes(request)
            return
        }
        val parameter = request.getParameter(targetUrlParameter)
        val ok = isAlwaysUseDefaultTargetUrl || targetUrlParameter != null && StringUtils.hasText(parameter)
        if (ok){
            requestCache.removeRequest(request, response)
            clearAuthenticationAttributes(request)
            return
        }
        clearAuthenticationAttributes(request)
    }
}