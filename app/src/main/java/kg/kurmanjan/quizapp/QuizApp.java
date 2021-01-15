package kg.kurmanjan.quizapp;

import android.app.Application;

import kg.kurmanjan.quizapp.data.IQuizApiClient;
import kg.kurmanjan.quizapp.data.QuizApiClient;

public class QuizApp extends Application {

    public static IQuizApiClient quizApiClient;

    @Override
    public void onCreate() {
        super.onCreate();

        quizApiClient = new QuizApiClient();
    }
}
