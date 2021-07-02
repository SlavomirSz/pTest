package pl.szlaq.pTest.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {


    @Autowired
    ProjectServiceImpl projectServiceImpl;

    @GetMapping("/getProjects")
    public List<Project> getProjects() {
        return projectServiceImpl.getAllProjects();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectServiceImpl.getProject(id);
    }

    @PutMapping("/editProject")
    public Project editProject(@RequestBody Project project) {
        return projectServiceImpl.editProject(project);
    }

    @PostMapping("/")
    public Project createProject(@RequestBody ProjectMapper projectMapper) {
        return projectServiceImpl.createProject(projectMapper);
    }

    @DeleteMapping("/{id}")
    public String deleteProject(@PathVariable Long id) {
        return projectServiceImpl.deleteProject(id);
    }


}
