package com.company.project.Unitily;

import com.company.project.Pattern.Facade.ExceptionBox;
import com.company.project.Pattern.Progress.Filter;
import com.company.project.Pattern.Progress.Pipe;
import com.company.project.Pattern.Progress.Progress;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
/**
 * Created by Chen on 2016/3/14.
 */
public class ProgressUnitTest {
    public static int temp = 5;
    public class TestFilter extends Filter {
        public int result = 0;

        public TestFilter(String _keyID) {
            super(_keyID);
        }

        @Override
        public void execute(Progress _progress) {
            this.result = ProgressUnitTest.temp++;
            //Log.d("Test-Log", "Execute filter : " + this.getKeyID());
            _progress.nextStep();
        }
    }
    public class TestPipe extends Pipe {
        public int result1 = 0;
        public int result2 = 0;
        @Override
        protected void onPipeStart(Progress _progress) {
            result1 = 1;
            //Log.d("Test-Log", "Execute onPipeStart");
            // execute internal program in parent class.
            super.onPipeStart(_progress);
        }

        @Override
        protected void onPipeComplete(Progress _progress) {
            result2 = 10;
            //Log.d("Test-Log", "Execute onPipeComplete");
            // execute internal program in parent class.
            super.onPipeComplete(_progress);
        }
    }
    public class TestPipeDefinedRoutes extends Pipe {
        public int result1 = 0;
        public int result2 = 0;
        private ArrayList mRoutes;
        @Override
        public ArrayList getRoutes() {
            return this.mRoutes;
        }
        public void setRoures(ArrayList _routes) {
            this.mRoutes = _routes;
        }
        @Override
        protected void onPipeStart(Progress _progress) {
            result1 = 1;
            //Log.d("Test-Log", "Execute onPipeStart");
            // execute internal program in parent class.
            super.onPipeStart(_progress);
        }

        @Override
        protected void onPipeComplete(Progress _progress) {
            result2 = 10;
            //Log.d("Test-Log", "Execute onPipeComplete");
            // execute internal program in parent class.
            super.onPipeComplete(_progress);
        }
    }
    // Initial unit test class
    public ProgressUnitTest() {
        super();
        ExceptionBox.getInstances().setBoxStyle(ExceptionBox.STYLE_NONE);
    }
    @Test
    public void filter_create() throws Exception {
        // 1. Create Filter
        String stepName = "Step1";
        Filter f = new TestFilter(stepName);
        // Test output
        assertEquals("Filter name : ", stepName, f.getKeyID());
    }
    @Test
    public void pipe_create() throws Exception {
        // 1. Create Pipe
        Pipe p = new Pipe();
        // Test output
        assertEquals("Initial pipe have 0 filter : ", 0, p.count());
    }
    @Test
    public void pipe_register() throws Exception {
        // 1. Create Pipe
        Pipe p = new Pipe();
        // 2. Create Filter
        Filter f1 = new Filter("Step1");
        Filter f2 = new Filter("Step2");
        // Test case
        boolean result;
        result = p.register(f1);
        assertEquals("Register success", true, result);
        result = p.register(f2);
        assertEquals("Register success", true, result);
        result = p.register(f2);
        assertNotEquals("Register fail, Duplicate register", true, result);
        // Test output
        assertEquals("Filter amount : ", 2, p.count());
    }
    @Test
    public void pipe_remove() throws Exception {
        // 1. Create Filter
        Pipe p = new Pipe();
        // 2. Create Filter & register
        Filter f1 = new Filter("Step1");
        p.register(f1);
        Filter f2 = new Filter("Step2");
        p.register(f2);
        // Test case
        boolean result;
        result = p.remove(f1.getKeyID());
        assertEquals("Remove success", true, result);
        result = p.remove(f2.getKeyID());
        assertEquals("Remove success", true, result);
        result = p.remove(f2.getKeyID());
        assertNotEquals("Remove fail", true, result);
        // Test output
        assertEquals("Filter amount : ", 0, p.count());
    }
    @Test
    public void pipe_retrieve() throws Exception {
        // 1. Create Filter
        Pipe p = new Pipe();
        // 2. Create Filter & register
        Filter f1 = new Filter("Step1");
        p.register(f1);
        Filter f2 = new Filter("Step2");
        p.register(f2);
        // Test case
        Filter t = null;
        t = (Filter)p.retrieve(f1.getKeyID());
        assertNotEquals("Retrieve Filter", null, t);
        t = (Filter)p.retrieve(f2.getKeyID());
        assertNotEquals("Retrieve Filter", null, t);
        t = (Filter)p.retrieve("Error");
        assertEquals("Retrieve Filter error", null, t);
    }
    @Test
    public void pipe_has() throws Exception {
        // 1. Create Filter
        Pipe p = new Pipe();
        // 2. Create Filter & register
        Filter f1 = new Filter("Step1");
        p.register(f1);
        Filter f2 = new Filter("Step2");
        p.register(f2);
        // Test case
        boolean result;
        result = p.has(f1.getKeyID());
        assertEquals("Has filter", true, result);
        result = p.has(f2.getKeyID());
        assertEquals("Has filter", true, result);
        result = p.has("Error");
        assertNotEquals("Doesn't have filter", true, result);
    }
    @Test
    public void pipe_step_execute() throws Exception {
        // 1. Create Filter
        TestPipe p = new TestPipe();
        TestFilter f1 = new TestFilter("Step1");
        p.register(f1);
        TestFilter f2 = new TestFilter("Step2");
        p.register(f2);
        // Test case
        ProgressUnitTest.temp = 5;
        p.execute(new Progress());
        assertEquals("Pipe start : ", 1, p.result1);
        assertEquals("Filter 1 : ", 5, f1.result);
        assertEquals("Filter 2 : ", 6, f2.result);
        assertEquals("Pipe start : ", 10, p.result2);
    }
    @Test
    public void pipe_step_execute_with_defined_routes() throws Exception {
        // 1. Create Filter
        TestPipeDefinedRoutes p = new TestPipeDefinedRoutes();
        TestFilter f1 = new TestFilter("Step1");
        p.register(f1);
        TestFilter f2 = new TestFilter("Step2");
        p.register(f2);
        // 2. Self-defined routes
        ArrayList r = new ArrayList();
        r.add(f2.getKeyID());
        r.add(f1.getKeyID());
        p.setRoures(r);
        // Test case
        ProgressUnitTest.temp = 5;
        p.execute(new Progress());
        assertEquals("Pipe start : ", 1, p.result1);
        assertEquals("Filter 2 : ", 5, f2.result);
        assertEquals("Filter 1 : ", 6, f1.result);
        assertEquals("Pipe start : ", 10, p.result2);
    }
}
