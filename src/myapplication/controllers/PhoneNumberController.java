package myapplication.controllers;

import myapplication.AllScenes;

import java.io.IOException;

public class PhoneNumberController extends BaseController {

    public void continueButtonClick() {
        try {
            goToAccessCodeScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void goToAccessCodeScene() throws IOException {
        switchSceneTo(AllScenes.AccessCodeScreen.getAccessCodeScene().getTitle(),
                AllScenes.AccessCodeScreen.getAccessCodeScene().getPath());
    }
}

