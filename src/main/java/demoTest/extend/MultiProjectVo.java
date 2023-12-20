package demoTest.extend;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MultiProjectVo extends StepProjectVo implements StepNumberAware{

}
