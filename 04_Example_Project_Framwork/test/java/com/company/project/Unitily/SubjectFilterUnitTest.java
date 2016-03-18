package com.company.project.Unitily;

import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Progress.Filters.SubjectFilter;
import com.company.project.Pattern.Progress.Pipe;
import com.company.project.Pattern.Progress.Progress;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Chen on 2016/3/15.
 */
public class SubjectFilterUnitTest {
    public class CountProgress extends Progress {
        public int count = 5;
    }
    public class TestObject {
        public int result = 0;
        public int result1 = 0;
        public int result2 = 0;
        public void value1(Progress _progress) {
            if(_progress != null) {
                this.result1 = ((CountProgress) _progress).count++;

                // Only 1 method could run progress.nextStep, if 2 method run will make sequence non-control.
                _progress.nextStep();
            } else {
                this.result = 1;
            }
        }
        public void value2(Progress _progress) {
            if(_progress != null) {
                this.result2 = ((CountProgress) _progress).count * 2;
            } else {
                this.result = 2;
            }
        }
    }
    // Initial unit test class
    public SubjectFilterUnitTest() {
        super();
        ExceptionBox.getInstances().setBoxStyle(ExceptionBox.STYLE_NONE);
    }
    @Test
    public void subject_filter_create() throws Exception {
        // 1. create trigger filter
        TestObject obj1 = new TestObject();
        TestObject obj2 = new TestObject();
        SubjectFilter f = new SubjectFilter("Step1");
        f.register(obj1, "value1");
        f.register(obj2, "value2");
        // Test case
        f.execute(null);
        assertEquals("Trigger object 1 result.", 1, obj1.result);
        assertEquals("Trigger object 2 result.", 2, obj2.result);
    }
    @Test
    public void subject_filter_execute_with_progress() throws Exception {
        // 1. create object
        TestObject obj1 = new TestObject();
        TestObject obj2 = new TestObject();
        // 2. create subject
        SubjectFilter f1 = new SubjectFilter("Step1");
        f1.register(obj1, "value2");
        f1.register(obj1, "value1");
        SubjectFilter f2 = new SubjectFilter("Step2");
        f2.register(obj2, "value2");
        f2.register(obj2, "value1");
        // 2. create pipe
        Pipe p = new Pipe();
        p.register(f1);
        p.register(f2);
        // Test case
        p.execute(new CountProgress());
        assertEquals("Trigger object 1 result1.", 5, obj1.result1);
        assertEquals("Trigger object 1 result2.", 10, obj1.result2);
        assertEquals("Trigger object 2 result1.", 6, obj2.result1);
        assertEquals("Trigger object 2 result2.", 12, obj2.result2);
    }
}
