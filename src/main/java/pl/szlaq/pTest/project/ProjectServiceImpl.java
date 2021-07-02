package pl.szlaq.pTest.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szlaq.pTest.testPlan.TestPlan;
import pl.szlaq.pTest.testPlan.TestPlanRepository;
import pl.szlaq.pTest.testPlan.TestPlanService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TestPlanService testPlanService;

    @Override
    public List<Project> getAllProjects() {
        List<ProjectDTO> projectDTOList = (List<ProjectDTO>) projectRepository.findAll();
        List<Project> projects = projectDTOList.stream()
                .map(Project::new)
                .collect(Collectors.toList());
        projects.forEach(project -> project.setTestPlanList(testPlanService.getTestPlansInProject(project.getId())));
        return projects;
    }

    @Override
    public Project getProject(long id) {
        Project project = new Project(projectRepository.findById(id).get());
        project.setTestPlanList(testPlanService.getTestPlansInProject(id));
        return project;
    }

    @Override
    public Project editProject(Project project) {
        ProjectDTO proj = projectRepository.findById(project.getId()).get();
        proj.setName(project.getName());
        proj.setDescription(project.getDescription());
        projectRepository.save(proj);
        return new Project(proj);
    }

    @Override
    public String deleteProject(long id) {
        if (projectRepository.findById(id).isPresent()) {
            projectRepository.deleteById(id);
            return "Project deleted";
        } else {
            return "Didn't find project with id " + id;
        }
    }

    @Override
    public Project createProject(ProjectMapper projectMapper) {
        ProjectDTO newProject = new ProjectDTO(projectMapper.name());
        if (!projectMapper.description().isBlank()) {
            newProject.setDescription(projectMapper.description());
        }
        projectRepository.save(newProject);
        return new Project(newProject);
    }

    @Override
    public List<TestPlan> getTestPlanList(long id) {
        return null;
    }
}
