package com.project.manager.ui.components;

import com.project.manager.TestData;
import com.project.manager.controllers.manager.ManagerTaskBrickComponentController;
import com.project.manager.models.TaskStatus;
import com.project.manager.services.SessionService;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TaskGeneratorTest {
    @Mock
    private SessionService sessionService;
    @Mock
    private FXMLLoader fxmlLoader;
    @InjectMocks
    private TaskGenerator taskGenerator;

    @Test
    public void testInject() throws IOException {
        when(sessionService.getProject()).thenReturn(TestData.getProject());
        FXMLLoader customFxmlLoader = new FXMLLoader(getClass().getResource("/fxml/manager/managerTaskBrickComponent.fxml"));
        ManagerTaskBrickComponentController managerTaskBrickComponentController = new ManagerTaskBrickComponentController();
        customFxmlLoader.setController(managerTaskBrickComponentController);
        when(fxmlLoader.load()).thenReturn(customFxmlLoader.load());
        VBox vBox = new VBox();
        taskGenerator.inject(vBox, TaskStatus.SPRINT_BACKLOG);
    }
}
