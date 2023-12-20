package demoTest.mytest;

import lombok.Data;

@Data
public class ProjectVo  {
    private Integer stepNumber;

    {
        stepNumber = 100;
    }

}