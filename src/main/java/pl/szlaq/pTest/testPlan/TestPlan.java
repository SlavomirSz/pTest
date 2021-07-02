package pl.szlaq.pTest.testPlan;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import pl.szlaq.pTest.domain.TestCase;

import javax.persistence.ManyToOne;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TestPlan {

    protected Long id;

    @NonNull
    protected String name;

    protected String description;


    List<TestCase> testCaseList;

    public TestPlan(TestPlanDTO testPlanDTO) {
        this.id = testPlanDTO.getId();
        this.name = testPlanDTO.getName();
        this.description = testPlanDTO.getDescription();
    }

}
