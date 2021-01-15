package kg.kurmanjan.quizapp.data;

import kg.kurmanjan.quizapp.model.Category;
import kg.kurmanjan.quizapp.model.QuizResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class QuizApiClient implements IQuizApiClient {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://opentdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    QuizApi quizApi = retrofit.create(QuizApi.class);

    @Override
    public void getQuestions(QuestionsCallBack callBack,Integer amount, Integer category, String difficulty) {
        Call<QuizResponse> call = quizApi.getQuestions(amount, category, difficulty);

        call.enqueue(new Callback<QuizResponse>() {
            @Override
            public void onResponse(Call<QuizResponse> call, Response<QuizResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        callBack.onSuccess(response.body().getResults());
                    } else {
                        callBack.onFailure(new Exception("Response is Empty" + response.code()));
                    }
                } else {
                    callBack.onFailure(new Exception("Response is Empty" + response.code()));
                }
            }

            @Override
            public void onFailure(Call<QuizResponse> call, Throwable t) {
                callBack.onFailure(new Exception(t));
            }
        });
    }
    @Override
    public void getCategory(CategoryCallBack callBack){
        Call<Category> categoryCall = quizApi.getCategory();
        categoryCall.enqueue(new Callback<Category>() {

            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callBack.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                    callBack.onFailure(new Exception(t));
            }
        });
    }
    }
