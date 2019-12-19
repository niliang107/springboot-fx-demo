package com.nee.demo;

import de.felixroske.jfxsupport.AbstractFxmlView;
import de.roskenet.jfxsupport.test.GuiTest;
import javafx.application.Platform;
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class ApplicationGuiTests<T extends AbstractFxmlView> extends GuiTest {

    protected Class clz;

    public ApplicationGuiTests() {
        Class s = this.getClass();
        Type t = s.getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            this.clz = (Class<T>) p[0];
        }
    }

    @PostConstruct
    public final void init() throws Exception {
        init(this.clz);
    }

    @After
    public final void clear() {
        Platform.runLater(() -> ApplicationGuiTests.this.reset());
    }

    public abstract void reset();
}
