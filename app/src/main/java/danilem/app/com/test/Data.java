package danilem.app.com.test;

import java.util.ArrayList;

public class Data {

    public static ArrayList<Model> getModelList() {
        ArrayList<Model> list = new ArrayList<>();

        final String date = "18.04.2019";
        final String johnSnowImage = "https://pbs.twimg.com/profile_images/901947348699545601/hqRMHITj_400x400.jpg";
        final String ygritteImage = "https://upload.wikimedia.org/wikipedia/en/thumb/c/c4/Ygritte-Rose_Leslie.jpg/220px-Ygritte-Rose_Leslie.jpg";

        Model yourFirstMessage = new Model();
        yourFirstMessage.setType(Model.YOUR_MESSAGE_TYPE);
        yourFirstMessage.setImage(johnSnowImage);
        yourFirstMessage.setMessage("Игритт, подожди!");
        yourFirstMessage.setDate(date);
        list.add(yourFirstMessage);

        Model interlocutorFirstMessage = new Model();
        interlocutorFirstMessage.setType(Model.INTERLOCUTOR_MESSAGE_TYPE);
        interlocutorFirstMessage.setImage(ygritteImage);
        interlocutorFirstMessage.setMessage("Ничего ты не знаешь, Джон Сноу!");
        interlocutorFirstMessage.setDate(date);
        list.add(interlocutorFirstMessage);

        Model yourSecondMessage = new Model();
        yourSecondMessage.setType(Model.YOUR_MESSAGE_TYPE);
        yourSecondMessage.setImage(johnSnowImage);
        yourSecondMessage.setMessage("Кое-что я знаю. Знаю что люблю тебя. Знаю что ты меня любишь. И знаю что ты должна скачать приложение от спонсора!");
        yourSecondMessage.setDate(date);
        list.add(yourSecondMessage);

        Model firstAdvertisingIntegration = new Model();
        firstAdvertisingIntegration.setType(Model.ADVERTISING_INTEGRATION_TYPE);
        list.add(firstAdvertisingIntegration);

        Model interlocutorSecondMessage = new Model();
        interlocutorSecondMessage.setType(Model.INTERLOCUTOR_MESSAGE_TYPE);
        interlocutorSecondMessage.setImage(ygritteImage);
        interlocutorSecondMessage.setMessage("Вау! Спасибо!");
        interlocutorSecondMessage.setDate(date);
        list.add(interlocutorSecondMessage);

        Model yourThirdMessage = new Model();
        yourThirdMessage.setType(Model.YOUR_MESSAGE_TYPE);
        yourThirdMessage.setImage(johnSnowImage);
        yourThirdMessage.setMessage("А ещё если кликнуть на мои сообщение , то выскочить toast!");
        yourThirdMessage.setDate(date);
        list.add(yourThirdMessage);

        Model secondAdvertisingIntegration = new Model();
        secondAdvertisingIntegration.setType(Model.ADVERTISING_INTEGRATION_TYPE);
        list.add(secondAdvertisingIntegration);

        return list;
    }

}
