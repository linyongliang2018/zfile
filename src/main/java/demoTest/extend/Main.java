package demoTest.extend;

import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        /*MultiProjectVo stepProjectVo = new MultiProjectVo();
        ProjectVo projectVo = new ProjectVo();

        doFillStepNumber(stepProjectVo, 10);
        doFillStepNumber(projectVo, 20);

        System.out.println("StepProjectVo stepNumber: " + stepProjectVo.getStepNumber());
        System.out.println("ProjectVo stepNumber: " + projectVo.getStepNumber());*/


        MultiProjectVo multiProjectVo1 = new MultiProjectVo();
        ProjectVo projectVo2 = new ProjectVo();
        Main main = new Main();

        try {
            main.setStepNumber(multiProjectVo1, 1);
            main.setStepNumber(projectVo2, 2);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println("multiProjectVo1 = " + multiProjectVo1);
        System.out.println("projectVo2 = " + projectVo2);
    }

    public static <T extends StepNumberAware> void doFillStepNumber(T obj, Integer stepNumber) {
        obj.setStepNumber(stepNumber);
    }


    public <T> void setStepNumber(T obj, Integer stepNumber) throws NoSuchFieldException, IllegalAccessException {
        Field field = getField(obj.getClass(), "stepNumber");
        field.setAccessible(true);
        field.set(obj, stepNumber);
    }

    private Field getField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            Class<?> superclass = clazz.getSuperclass();
            if (superclass == null) {
                throw e;
            } else {
                return getField(superclass, fieldName);
            }
        }
    }
}

