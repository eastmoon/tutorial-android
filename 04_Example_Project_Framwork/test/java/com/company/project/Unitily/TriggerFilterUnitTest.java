package com.company.project.Unitily;

import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Progress.Filters.TriggerFilter;
import com.company.project.Pattern.Progress.Pipe;
import com.company.project.Pattern.Progress.Progress;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Chen on 2016/3/15.
 */
public class TriggerFilterUnitTest {
    public class CountProgress extends Progress {
        public int count = 5;
    }
    public class TestObject {
        public int result = 0;
        public void value(Progress _progress) {
            if(_progress != null) {
                this.result = ((CountProgress) _progress).count++;
                _progress.nextStep();
            } else {
                this.result = 1;
            }
        }
    }
    // Initial unit test class
    public TriggerFilterUnitTest() {
        super();
        ExceptionBox.getInstances().setBoxStyle(ExceptionBox.STYLE_NONE);
    }
    @Test
    public void trigger_filter_create() throws Exception {
        // 1. create trigger filter
        TestObject obj = new TestObject();
        String method = "value";
        TriggerFilter f = new TriggerFilter("Step1", obj, method);
        // Test case
        f.execute(null);
        assertEquals("Trigger object result.", 1, obj.result);
    }
    @Test
    public void trigger_filter_execute_with_progress() throws Exception {
        // 1. create object
        String method = "value";
        TestObject obj1 = new TestObject();
        TestObject obj2 = new TestObject();
        // 2. create pipe
        Pipe p = new Pipe();
        p.register(new TriggerFilter("Step1", obj1, method));
        p.register(new TriggerFilter("Step2", obj2, method));
        // Test case
        p.execute(new CountProgress());
        assertEquals("Trigger object 1 result.", 5, obj1.result);
        assertEquals("Trigger object 2 result.", 6, obj2.result);
    }
}
