import javafx.scene.Scene;

import java.io.IOException;

/**
 * Created by Mirek on 2016-10-25.
 */
public class AccessCodeController extends BaseController {

    private Scene scene;

    public void enterCheers() {
        try {
            goToProfileStage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToProfileStage() throws IOException {
        switchStageTo(AllScenes.ProfileScreen.getProfileScene().getTitle(),
                AllScenes.ProfileScreen.getProfileScene().getPath());
    }

}
