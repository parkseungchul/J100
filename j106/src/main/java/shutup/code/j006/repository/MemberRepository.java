package shutup.code.j006.repository;

import org.springframework.data.repository.CrudRepository;

import shutup.code.j006.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
