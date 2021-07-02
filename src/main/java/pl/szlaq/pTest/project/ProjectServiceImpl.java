package pl.szlaq.pTest.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szlaq.pTest.testPlan.TestPlan;
import pl.szlaq.pTest.testPlan.TestPlanService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
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
        Optional<ProjectDTO> optionalProject = projectRepository.findById(id);
        if (optionalProject.isPresent()) {
            Project project = new Project(optionalProject.get());
            project.setTestPlanList(testPlanService.getTestPlansInProject(id));
            return project;
        } else {
            throw new NoSuchElementException("There is no project with id = " + id);
        }

    }

    @Override
    public Project editProject(Project project) {
        Optional<ProjectDTO> optionalProject = projectRepository.findById(project.getId());
        if (optionalProject.isPresent()) {
            ProjectDTO projectToEdit = optionalProject.get();
            projectToEdit.setName(project.getName());
            projectToEdit.setDescription(project.getDescription());
            projectRepository.save(projectToEdit);
            return new Project(projectToEdit);
        } else {
            throw new NoSuchElementException("There is no project with id = " + project.getId());
        }
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
