package EEDD;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer> {
    List<TeamMember> findByUsername(String username);
    long countByUsername(String username);
}
