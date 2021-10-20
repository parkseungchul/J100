package shutup.code.j006.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtHandlerInterceptorImpl implements HandlerInterceptor {
	

	@Autowired
	private JwtService jwtService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		final String token = request.getHeader(Constant.AUTH_HEADER);
		
		try {
			if(token == null) {
				responseError(response, Constant.AUTH_INVALID);
				return false;
			}
			log.debug("token: " + token);
			jwtService.isUsable(token);
			return true;
			
		}catch(ExpiredJwtException ex) {
			responseError(response, Constant.TOKEN_TIME_OUT);
			return false;
		}catch(Exception e) {
			responseError(response, Constant.AUTH_INVALID);
			return false;
		}
	}

	private void responseError(HttpServletResponse response, String message) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		ResultDto result = new ResultDto(false, message, null);
		response.setContentType("application/json; charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().write(mapper.writeValueAsString(result));
		
	}

}
