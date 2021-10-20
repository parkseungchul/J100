package shutup.code.j006.config;

import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import shutup.code.j006.domain.Member;
import shutup.code.j006.repository.MemberRepository;


@Slf4j
@Component
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private HttpServletResponse response;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		

	    Optional<Member> op =  memberRepository.findById(username);
	    
	    if(!op.isPresent()) {
	    	throw new UsernameNotFoundException("사용자 없음");
	    }
	    
	    /**
	     * 로그인 정상으로 된 이후 해당 아이디로 60초만 유효한 토근을 발생
	     */
	    String token = jwtService.createToken(username, 60 * 1000);
	    
	    /**
	     * response header 에 생성된 토근을 넣음
	     */
	    response.setHeader(Constant.AUTH_HEADER, token);
	    
	    
	    Member member = op.get();
		return new SecurityUser(member);
	}

}
