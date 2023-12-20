package demoTest.extend;

import lombok.Data;

@Data
public class ProjectVo implements StepNumberAware {
    private Integer stepNumber;
}