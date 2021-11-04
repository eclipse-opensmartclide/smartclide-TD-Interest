package gr.zisis.interestapi.persistence;

import gr.zisis.interestapi.controller.response.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gr.zisis.interestapi.domain.Projects;

/**
 * @author George Digkas <digasgeo@gmail.com>
 *
 */
@Repository
public interface ProjectsRepository extends JpaRepository<Projects, Long> {

    @Query(value = "SELECT new gr.zisis.interestapi.controller.response.entity.Project(p.pid, p.url, p.owner, p.repo) "
            + "FROM Projects p "
            + "WHERE p.owner = ?1 AND p.repo = ?2")
    Project findProject(String owner, String repo);

}