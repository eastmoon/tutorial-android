package com.company.project.Unitily;

import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Observers.Subject;
import com.company.project.Pattern.Observers.Trigger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Chen on 2016/3/14.
 */
public class ObserversUnitTest {
    public class TestObject {
        public int result = 0;
        public void value() {
            this.result = 1;
        }
        public void add(int _value) {
            this.result += _value;
        }
        public void add(int _source, int _target) {
            this.result = _source + _target;
        }
    }
    // Initial unit test class
    public ObserversUnitTest() {
        super();
        ExceptionBox.getInstances().setBoxStyle(ExceptionBox.STYLE_NONE);
    }
    @Test
    public void trigger_create() throws Exception {
        // 1. create trigger
        TestObject obj = new TestObject();
        String method = "add";
        Trigger t = new Trigger(obj, method);
        // Test output
        assertEquals("Trigger object is equals.", obj, t.getTarget());
        assertEquals("Trigger method is equals.", method, t.getMethod());
    }
    @Test
    public void trigger_execute_with_no_param() throws Exception {
        // 1. create trigger
        TestObject obj = new TestObject();
        String method = "value";
        Trigger t = new Trigger(obj, method);
        // 2. execute method in TestObject
        t.execute();
        // Test output
        assertEquals("Equation is result = 1.", 1, obj.result);
    }
    @Test
    public void trigger_execute_with_param_types() throws Exception {
        // 1. create trigger
        TestObject obj = new TestObject();
        String method = "add";
        Trigger t = new Trigger(obj, method);
        // 2. assign types
        Class[] types = {Integer.TYPE};
        t.setTypes(types);
        // 3. execute method in TestObject with 1 param.
        t.execute(5);
        // Test output
        assertEquals("Equation is result = 0 + 5", 5, obj.result);
        // 3. execute method in TestObject with 1 param.
        t.execute(10);
        // Test output
        assertEquals("Equation is result = 5 + 10", 15, obj.result);
    }
    @Test
    public void trigger_execute_with_difference_param_types() throws Exception {
        // 1. create trigger
        TestObject obj = new TestObject();
        String method = "add";
        Trigger t = new Trigger(obj, method);
        // 3. execute method in TestObject with 2 param.
        t.execute(new Class[]{Integer.TYPE, Integer.TYPE}, 5, 5);
        // Test output
        assertEquals("Equation is result = 5 + 5", 10, obj.result);
        // 3. execute method in TestObject with 1 param.
        t.execute(new Class[]{Integer.TYPE}, 10);
        // Test output
        assertEquals("Equation is result = 10 + 10", 20, obj.result);
    }
    @Test
    public void subject_create() throws Exception {
        // 1. create subject
        Subject s = new Subject();
        // Test output
        assertEquals("New subject didn't have any trigger.", 0, s.count());
    }
    @Test
    public void subject_register() throws Exception {
        boolean result = true;
        // 1. create subject
        Subject s = new Subject();
        // 2. register object 1
        result = s.register(new TestObject(), "value");
        assertEquals("Register success", true, result);
        // 2. register object 2
        Trigger t = new Trigger(new TestObject(), "value");
        result = s.register(t);
        assertEquals("Register success", true, result);
        // 3. register method will reject duplicate object.
        // duplicate is mean the same object and method.
        result = s.register(t);
        assertNotEquals("Register fail", true, result);
        // Test output
        assertEquals("Register 2 object.", 2, s.count());
    }
    @Test
    public void subject_remove() throws Exception {
        boolean result = true;
        // 1. create subject
        Subject s = new Subject();
        // 2. register object
        TestObject obj = new TestObject();
        Trigger t = new Trigger(obj, "value");
        s.register(obj, "add");
        s.register(t);
        assertEquals("Register 2 object.", 2, s.count());
        // 3. remove trigger by target object and method
        result = s.remove(obj, "add");
        assertEquals("Register success", true, result);
        // 3. remove trigger by trigger
        result = s.remove(t);
        assertEquals("Register success", true, result);
        // 4. remove non-exist object will return false.
        result = s.remove(t);
        assertNotEquals("Register fail", true, result);
        // Test output
        assertEquals("No object in subject.", 0, s.count());
    }
    @Test
    public void subject_retrieve() throws Exception {
        // 1. create subject
        Subject s = new Subject();
        // 2. register object
        TestObject obj = new TestObject();
        s.register(obj, "value");
        s.register(obj, "add");
        // 3. retrieve trigger with target object and "value" method
        Trigger t1 = s.retrieve(obj, "value");
        assertNotEquals("Retrieve trigger", null, t1);
        // 3. retrieve trigger with target object and "add" method
        Trigger t2 = s.retrieve(obj, "add");
        assertNotEquals("Retrieve trigger", null, t2);
    }
    @Test
    public void subject_has() throws Exception {
        boolean result = true;
        // 1. create subject
        Subject s = new Subject();
        // 2. register object
        TestObject obj = new TestObject();
        Trigger t1 = new Trigger(obj, "value");
        Trigger t2 = new Trigger(obj, "add");
        s.register(t1);
        s.register(t2);
        // 3. has trigger with target object and "value" method
        result = s.has(t1);
        assertEquals("Has trigger 1", true, result);
        // 3. has trigger with target object and "add" method
        result = s.has(t2);
        assertEquals("Has trigger 2", true, result);
    }
    @Test
    public void subject_notify_with_no_param() throws Exception {
        // 1. create subject
        Subject s = new Subject();
        // 2. register object
        Trigger t1 = new Trigger(new TestObject(), "value");
        s.register(t1);
        Trigger t2 = new Trigger(new TestObject(), "value");
        s.register(t2);
        // 3. notify
        s.notifyTrigger();
        // Test output
        assertEquals("Object 1 value is 1.", 1, ((TestObject)t1.getTarget()).result);
        assertEquals("Object 2 value is 1.", 1, ((TestObject)t2.getTarget()).result);
    }
    @Test
    public void subject_notify_with_param() throws Exception {
        // 1. create subject
        Subject s = new Subject();
        // 2. register object
        Trigger t1 = new Trigger(new TestObject(), "add");
        s.register(t1);
        Trigger t2 = new Trigger(new TestObject(), "add");
        s.register(t2);
        // default set
        ((TestObject)t1.getTarget()).result = 5;
        ((TestObject)t2.getTarget()).result = 10;
        // 3. notify
        s.setTypes(new Class[]{Integer.TYPE});
        s.notifyTrigger(10);
        // Test output
        assertEquals("Object 1 value is 15.", 15, ((TestObject)t1.getTarget()).result);
        assertEquals("Object 2 value is 20.", 20, ((TestObject) t2.getTarget()).result);
        // 3. notify
        s.notifyTrigger(new Class[]{Integer.TYPE, Integer.TYPE}, 10, 10);
        // Test output
        assertEquals("Object 1 value is 20.", 20, ((TestObject)t1.getTarget()).result);
        assertEquals("Object 2 value is 20.", 20, ((TestObject)t2.getTarget()).result);
    }
}
