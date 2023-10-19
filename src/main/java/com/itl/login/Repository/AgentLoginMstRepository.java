//package com.itl.login.Repository;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//
//import com.itl.entities.AgentLoginMst;
//
//public interface AgentLoginMstRepository extends JpaRepository<AgentLoginMst, Integer> {
//
//	@Query(name = "checkAgentIsPresent", value = "SELECT a from AgentLoginMst a WHERE a.username=:username")
//	public abstract AgentLoginMst checkAgentIsPresent(@Param("username") String username);
//	
//}
