package pl.szlaq.pTest.testPlan;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.szlaq.pTest.project.ProjectDTO;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name = "test_plans")
public class TestPlanDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "", sequenceName = "test_plan")
    protected Long id;

    @NonNull
    protected String name;

    protected String description;

    @NonNull
    private Long projectId;



}
