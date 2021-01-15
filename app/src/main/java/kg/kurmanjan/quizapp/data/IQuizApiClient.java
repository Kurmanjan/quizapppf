package kg.kurmanjan.quizapp.data;

import java.util.List;

import kg.kurmanjan.quizapp.model.Category;
import kg.kurmanjan.quizapp.model.Question;
import kg.kurmanjan.quizapp.core.IBaseCallBack;

public interface IQuizApiClient {

    void getQuestions(QuestionsCallBack callBack, Integer amount, Integer category, String difficulty);

    void getCategory(CategoryCallBack callBack);

    interface QuestionsCallBack extends IBaseCallBack<List<Question>> {
        @Override
        void onSuccess(List<Question> result);

        @Override
        void onFailure(Exception e);
    }

    interface CategoryCallBack extends IBaseCallBack<Category> {
        @Override
        void onSuccess(Category result);

        @Override
        void onFailure(Exception e);
    }

}
