package pl.szlaq.pTest.project;

import pl.szlaq.pTest.testPlan.TestPlan;

import java.util.List;

public interface ProjectService {

    List<Project> getAllProjects();

    Project getProject(long id);

    Project editProject(Project project);

    String deleteProject(long id);

    Project createProject(ProjectMapper projectMapper);

    List<TestPlan> getTestPlanList(long id);

}
