package shutup.code.j006.config;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import shutup.code.j006.domain.Member;

@Getter
@Setter
@ToString
public class SecurityUser extends User{

	private Member member;
	
	public SecurityUser(Member member) {
		super(member.getId(), member.getPassword(), AuthorityUtils.createAuthorityList(member.getRole().toString()));
		
		this.member = member;
		
		
	}
}
