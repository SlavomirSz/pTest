package pl.szlaq.pTest.project;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.szlaq.pTest.testPlan.TestPlan;

import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Project {

    protected Long id;

    @NonNull
    protected String name;

    protected String description;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<TestPlan> testPlanList;

    public Project(ProjectDTO projectDTO) {
        this.id = projectDTO.getId();
        this.name = projectDTO.getName();
        this.description = projectDTO.getDescription();
    }

}
